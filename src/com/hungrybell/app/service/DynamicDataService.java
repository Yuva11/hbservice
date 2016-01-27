package com.hungrybell.app.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hungrybell.Encryption.HungryBellsSecretKey;
import com.hungrybell.app.dao.CityDao;
import com.hungrybell.app.dao.DealDao;
import com.hungrybell.app.dao.DealDeliveryTypeDao;
import com.hungrybell.app.dao.DealUserFavouritesDao;
import com.hungrybell.app.dao.DealUserLikeDao;
import com.hungrybell.app.dao.DealUserSharedDao;
import com.hungrybell.app.dao.DealUserViewDao;
import com.hungrybell.app.dao.DeliveryTypeDao;
import com.hungrybell.app.dao.DiscountCouponDao;
import com.hungrybell.app.dao.FeedBackDao;
import com.hungrybell.app.dao.KitchenCouponDao;
import com.hungrybell.app.dao.LocationDao;
import com.hungrybell.app.dao.MerchantBranchDao;
import com.hungrybell.app.dao.MerchantDao;
import com.hungrybell.app.dao.NewOrderDetailsDao;
import com.hungrybell.app.dao.OrderDeatilDao;
import com.hungrybell.app.dao.OrdersDao;
import com.hungrybell.app.dao.PaymentDao;
import com.hungrybell.app.dao.RecommendedTagDao;
import com.hungrybell.app.dao.RepeatDiscountDao;
import com.hungrybell.app.dao.RolesDao;
import com.hungrybell.app.dao.SettingDao;
import com.hungrybell.app.dao.TrendingTagDao;
import com.hungrybell.app.dao.UserDao;
import com.hungrybell.app.date.CalculateDifferenceInDays;
import com.hungrybell.app.date.CheckAvailabilityDate;
import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.email.EmailUtility;
import com.hungrybell.app.email.EmailUtilityForAdmin;
import com.hungrybell.app.google.api.GetAddressGoogleApi;
import com.hungrybell.app.google.api.GetLocationAddressGoogleApi;
import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.DealDeliveryType;
import com.hungrybell.app.model.DealOrders;
import com.hungrybell.app.model.DeliveryType;
import com.hungrybell.app.model.DiscountCoupon;
import com.hungrybell.app.model.KitchenCoupon;
import com.hungrybell.app.model.Location;
import com.hungrybell.app.model.Merchant;
import com.hungrybell.app.model.MerchantBranch;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.NewPayment;
import com.hungrybell.app.model.OrderDetail;
import com.hungrybell.app.model.RecommendedTag;
import com.hungrybell.app.model.RepeatDiscount;
import com.hungrybell.app.model.Roles;
import com.hungrybell.app.model.Setting;
import com.hungrybell.app.model.TrendingTag;
import com.hungrybell.app.model.User;
import com.hungrybell.app.sms.SmsUtility;
import com.hungrybell.app.sms.SpearSMSUtility;
import com.hungrybell.app.vo.request.Orders;
import com.hungrybell.app.vo.request.PayUmoneyBean;
import com.hungrybell.app.vo.response.AdminLoginStatus;
import com.hungrybell.app.vo.response.Body;
import com.hungrybell.app.vo.response.ChangeLocationResponseVO;
import com.hungrybell.app.vo.response.CheckDiscountCodeResponseVO;
import com.hungrybell.app.vo.response.CheckDistanceResponseVO;
import com.hungrybell.app.vo.response.DealVO;
import com.hungrybell.app.vo.response.DealVOACT;
import com.hungrybell.app.vo.response.FavTagVo;
import com.hungrybell.app.vo.response.GoogleLocationResponseVO;
import com.hungrybell.app.vo.response.HomePageFavTagResponseVO;
import com.hungrybell.app.vo.response.HomePageResponseVO;
import com.hungrybell.app.vo.response.HomePageVO;
import com.hungrybell.app.vo.response.LocationVO;
import com.hungrybell.app.vo.response.MerchantOrderStatus;
import com.hungrybell.app.vo.response.MerchantPasswordStatus;
import com.hungrybell.app.vo.response.MerchantPriceStatus;
import com.hungrybell.app.vo.response.MerchantStatus;
import com.hungrybell.app.vo.response.Merchantorderdetails;
import com.hungrybell.app.vo.response.MyOrderStatus;
import com.hungrybell.app.vo.response.Myorderdetails;
import com.hungrybell.app.vo.response.ResetPasswrdStatus;
import com.hungrybell.app.vo.response.Result;
import com.hungrybell.app.vo.response.Status;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;
import com.hungrybell.app.vo.response.TagDealsListResponseVOAddToCart;
import com.hungrybell.app.vo.response.TagListDealsPageVO;
import com.hungrybell.app.vo.response.TagListDealsPageVOATC;
import com.hungrybell.app.vo.response.TagVO;
import com.hungrybell.app.vo.response.UpdateUserDetailsResponseVo;
import com.hungrybell.app.vo.response.UserDetailsResponseVo;
import com.hungrybell.util.DistanceCalculatorUtil;

@Service("dynamicDataService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class DynamicDataService {
	@Autowired
	DealDao dealDao;
	@Autowired
	MerchantBranchDao merchantBranchDao;
	@Autowired
	LocationDao locationDao;
	@Autowired
	UserDao userDao;
	@Autowired
	DealUserLikeDao dealUserLikeDao;
	@Autowired
	DealUserFavouritesDao dealUserFavouritesDao;
	@Autowired
	DealUserSharedDao dealUserSharedDao;
	@Autowired
	DealUserViewDao dealUserViewDao;

	@Autowired
	DeliveryTypeDao deliveryTypeDao;

	@Autowired
	DealDeliveryTypeDao dealDeliveryTypeDao;
	@Autowired
	MerchantDao merchantDao;

	@Autowired
	OrderDeatilDao orderDeatilDao;

	@Autowired
	DiscountCouponDao discountCouponDao;

	@Autowired
	TrendingTagDao trendingTagDao;

	@Autowired
	RecommendedTagDao recommendedTagDao;

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	OrdersDao ordersDao2;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private FeedBackDao feedbackDao;

	@Autowired
	private NewOrderDetailsDao newOrdersDetails;

	@Autowired
	private RolesDao rolesDao;

	@Autowired
	private CityDao cityDao;

	@Autowired
	private KitchenCouponDao kitchenCouponDao;

	@Autowired
	private SettingDao settingDao;
	
	@Autowired
	private RepeatDiscountDao repeatDiscountDao;
	
	
	
	Location location1 = null;

	List<TrendingTag> trendingtag = null;
	List<RecommendedTag> recomendedtag = null;

	public HomePageResponseVO getAllDealsForLocationTrendingTag() {
		HomePageResponseVO homePageResponseVo = null;
		String locationStr = null;
		try {
			// delete all trending tag
			trendingTagDao.allDeleteTrendingTag();
			List<Deal> alldealsList = dealDao.getAllDeals(); // now all deal
																// banglore
			homePageResponseVo = prepareHomePageVOTagInsert(alldealsList,
					"Bangalore");
			// trending logic automatic call service all trending save
			List<Location> locationList = locationDao.getAllLocationLists();
			if (locationList != null) {
				System.out.println("location List Size3" + locationList.size());
				Iterator iterator = null;
				int count = 0;
				for (Location loc : locationList) {
					String locationName = loc.getName();
					List<Long> branchids = getMerchantBranchForLocation(loc
							.getId());
					if (branchids != null) {
						List<Deal> dealsList1 = dealDao
								.getAllDealsForBranchIds(branchids); // before
						if (dealsList1 != null) {
							homePageResponseVo = prepareHomePageVOTagInsert(
									dealsList1, locationName);
						}

					}
				}
			}
			return homePageResponseVo;
		} catch (Exception ek) {
			ek.printStackTrace();

			return homePageResponseVo;
		}
	}

	public HomePageResponseVO getAllDealsForLocationRecomTag() {
		HomePageResponseVO homePageResponseVo = null;
		String locationStr = null;
		try {

			// delete all trending tag
			recommendedTagDao.allDeleteRecomTag();
			List<Deal> alldealsList = dealDao.getAllDeals(); // now all deal
																// banglore
			homePageResponseVo = prepareHomePageVOTagInsertRecom(alldealsList,
					"Bangalore");
			// trending logic automatic call service all trending save
			List<Location> locationList = locationDao.getAllLocationLists();
			if (locationList != null) {
				Iterator iterator = null;
				int count = 0;
				for (Location loc : locationList) {
					String locationName = loc.getName();
					List<Long> branchids = getMerchantBranchForLocation(loc
							.getId());
					if (branchids != null) {
						List<Deal> dealsList1 = dealDao
								.getAllDealsForBranchIdsRecommended(branchids); // before
						if (dealsList1 != null) {
							homePageResponseVo = prepareHomePageVOTagInsertRecom(
									dealsList1, locationName);
						}

					}
				}
			}
			try
			{
			EmailUtility emailUtility=new EmailUtility();
			emailUtility.emailSendOurTeamForTrendingRecom("ramzi@getwise.in");
			emailUtility.emailSendOurTeamForTrendingRecom("manoharan@getwise.in");
			emailUtility.emailSendOurTeamForTrendingRecom("bheem@getwise.in");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return homePageResponseVo;
		} catch (Exception ek) {
			ek.printStackTrace();
			return homePageResponseVo;
		}
	}

	private HomePageResponseVO getNearestHomePageLocation(String latitude,
			String longitude) {
		HomePageResponseVO homePageResponseVo = null;
		String locationStr = getLocation(latitude, longitude);
		Location location1 = locationDao.getLocation(locationStr);
		List<MerchantBranch> mb = merchantBranchDao
				.getMerchantBranchForNearestLocationList();
		Iterator iterator = null;
		List<Long> branchidList = new ArrayList<Long>();
		for (iterator = mb.iterator(); iterator.hasNext();) {
			MerchantBranch mbo = (MerchantBranch) iterator.next();
			try {
				double kmDealTag = getNearestLocationDistance(latitude,
						longitude, mbo.lattitue, mbo.longitude);
				if (kmDealTag <= 3.5) {
					System.out.println("km-----------lessthen 3 km - --  "
							+ kmDealTag);
					branchidList.add(mbo.getId());
				}
			} catch (Exception ek1) {
				ek1.printStackTrace();
			}
		}
		List<Deal> dealsListTotal = dealDao
				.getAllDealsForLocation(branchidList);
		List<Deal> dealsList = dealDao
				.getNearestAllDealsForBranchIds(branchidList);
		List<Deal> recoDealsList = dealDao
				.getAllRecommendedDealsForLocation(branchidList);
		homePageResponseVo = prepareHomePageVO(dealsList, null, null, ""
				+ dealsListTotal.size(), null, null, null, null);
		homePageResponseVo.getResult().setLocation(locationStr);

		return homePageResponseVo;

	}

	private List<Long> getMerchantBranchForLocation(Long locationId) {
		List<MerchantBranch> mbs = merchantBranchDao
				.getMerchantBranchIdsForLocationId(locationId);
		if (mbs != null) {
			List<Long> ids = new ArrayList<Long>();
			if (mbs != null) {
				for (Iterator iterator = mbs.iterator(); iterator.hasNext();) {
					MerchantBranch merchantBranch = (MerchantBranch) iterator
							.next();
					ids.add(merchantBranch.getId());
				}
			}
			return ids;
		}
		return null;
	}

	private List<String> getMerchantBranchNameForLocaton(Long locationId) {
		List<MerchantBranch> mbs = merchantBranchDao
				.getMerchantBranchIdsForLocationId(locationId);
		List<String> ids = new ArrayList<String>();
		if (mbs != null) {
			for (Iterator iterator = mbs.iterator(); iterator.hasNext();) {
				MerchantBranch merchantBranch = (MerchantBranch) iterator
						.next();
				ids.add(merchantBranch.getBranch_name());
			}
		}
		return ids;

	}

	private MerchantBranch getMerchantDetailForMerchantBranchId(
			Long merchantBranchId) {
		MerchantBranch mbs = merchantBranchDao
				.getMerchantDetailForMerchantBranchId(merchantBranchId);
		return mbs;

	}

	private Merchant getMerchantDetailForMerchantId(Long merchantId) {
		Merchant ms = merchantDao.getMerchantDetailForMerchantId(merchantId);
		return ms;

	}

	private HomePageResponseVO prepareHomePageVO(List<Deal> trendingDeals,
			List<Deal> nearestrecoDeals, List<Deal> favDeals, String items,
			String locationName, List<TrendingTag> trendingtag,
			List<Deal> nearestList, List<RecommendedTag> recomtag) {

		HomePageVO homePageVo = new HomePageVO();
		homePageVo.setTotal_food_items(items);
		if (trendingDeals != null) {
			List<TagVO> trendingTagList = prepareTagVOListTrending(
					trendingDeals, locationName, null, null);
			homePageVo.setTrending(trendingTagList);
		}
		if (nearestList != null) {
			List<TagVO> trendingTagList1 = prepareTagVOList(nearestList);
			homePageVo.setTrending(trendingTagList1);

		}
		if (nearestrecoDeals != null) {
			List<TagVO> trendingTagList13 = prepareTagVOListrecom(nearestrecoDeals);
			homePageVo.setRecomended(trendingTagList13);

		}
		if (trendingtag != null) {
			List<TagVO> trendingTagList1 = prepareTagVOListTrending(null,
					locationName, trendingtag, null);
			homePageVo.setTrending(trendingTagList1);
		}
		if (recomtag != null) {
			List<TagVO> recTagList = prepareTagVOListRecom(null, locationName,
					recomtag, null);
			homePageVo.setRecomended(recTagList);
		}
		if (favDeals != null) {
			List<TagVO> favTagList = prepareTagVOList(favDeals);
			homePageVo.setRecomended(favTagList);
		}
		// homePageVo.setRecomended(tagsList);
		// homePageVo.setFavourites(tagsList);
		HomePageResponseVO hvo = new HomePageResponseVO();
		hvo.setResult(homePageVo);
		return hvo;
	}

	private HomePageResponseVO prepareHomePageVOTagInsert(
			List<Deal> trendingDeals, String locationName) {

		HomePageVO homePageVo = new HomePageVO();
		// homePageVo.setTotal_food_items(items);
		if (trendingDeals != null) {
			List<TagVO> trendingTagList = prepareTagVOListTrendingTagInsert(
					trendingDeals, locationName);
			homePageVo.setTrending(trendingTagList);
		}
		HomePageResponseVO hvo = new HomePageResponseVO();
		hvo.setResult(homePageVo);
		return hvo;
	}

	private HomePageResponseVO prepareHomePageVOTagInsertRecom(
			List<Deal> trendingDeals, String locationName) {

		HomePageVO homePageVo = new HomePageVO();
		if (trendingDeals != null) {
			List<TagVO> trendingTagList = prepareTagVOListTrendingTagInsertRecom(
					trendingDeals, locationName);
			homePageVo.setTrending(trendingTagList);
		}
		HomePageResponseVO hvo = new HomePageResponseVO();
		hvo.setResult(homePageVo);
		return hvo;
	}

	public TagDealsListResponseVO getAllDealsForTagName(String tagName,
			String latitude, String longitude) {
		TagDealsListResponseVO tagDealsListResponseVO = null;
		try {
			String location = getLocation(latitude, longitude);
			Location location1 = locationDao.getLocation(location);
			long locationId = location1.getId();
			List<Long> branchIds = getMerchantBranchForLocation(locationId);
			List<Deal> dealsListTotal = dealDao.getAllDealsForLocation(branchIds);
			List<Deal> dealsList = dealDao.getAllDealsForBranchIdsAndTag(branchIds, tagName);
			// tagDealsListResponseVO=new TagDealsListResponseVO();
			tagDealsListResponseVO = prepareTagDealsListVO(dealsList, ""+ dealsListTotal.size(), latitude, longitude);
			return tagDealsListResponseVO;
		} catch (Exception ek) {// Nearest tagDealList logic
			List<MerchantBranch> mb = merchantBranchDao	.getMerchantBranchForNearestLocationList();
			tagDealsListResponseVO = new TagDealsListResponseVO();
			GetAddressGoogleApi getAddressGoogleApi = new GetAddressGoogleApi();
			if (mb != null) {
				Iterator iterator = null;
				List<Long> branchidList = new ArrayList<Long>();
				for (iterator = mb.iterator(); iterator.hasNext();) {
					MerchantBranch mbo = (MerchantBranch) iterator.next();
					try {
						double kmDealTag = getNearestLocationDistance(latitude,
								longitude, mbo.lattitue, mbo.longitude);
						if (kmDealTag <= 3.5) {
							branchidList.add(mbo.getId());
						}
						/*
						 * String jsonAddress =
						 * getAddressGoogleApi.getAddress(latitude, longitude,""
						 * + mbo.getLattitue(), ""+ mbo.getLongitude());
						 * CheckDistanceResponseVO json_all_address = null;
						 * ObjectMapper mapper = new ObjectMapper();
						 * json_all_address =
						 * mapper.readValue(jsonAddress,CheckDistanceResponseVO
						 * .class); double distanse =
						 * json_all_address.getRows()[
						 * 0].getElements()[0].getDistance().getValue(); if
						 * (distanse > 5000.0) { branchidList.add(mbo.getId());
						 * }
						 */
					} catch (Exception ek1) {
						ek1.printStackTrace();
					}
				}
				List<Deal> dealsListTotaln = dealDao.getAllDealsForLocation(branchidList);
				if (dealsListTotaln != null && dealsListTotaln.size() != 0) {
					List<Deal> dealsListn = dealDao.getNearestAllDealsForBranchIdsAndTag(branchidList,tagName);
					if (dealsListn != null) {
						tagDealsListResponseVO = prepareTagDealsListVO(dealsListn, "" + dealsListTotaln.size(),latitude, longitude);
					}
				}
			}
			return tagDealsListResponseVO;
		}
	}

	private TagDealsListResponseVO prepareTagDealsListVO(List<Deal> deals,
			String items, String latitude, String longitude) {
		TagListDealsPageVO tagListDealsPageVO = new TagListDealsPageVO();
		tagListDealsPageVO.setTotal_food_items(items);
		List<DealVO> dealVOs = new ArrayList<DealVO>();
		if (deals != null && deals.size() > 0) {
			for (Iterator iterator = deals.iterator(); iterator.hasNext();) {
				Deal deal = (Deal) iterator.next();
				DealVO dealVO = new DealVO();
				dealVO.setDealId(deal.getId());
				dealVO.setName(deal.getName());
				dealVO.setDealPrice(deal.getDeal_price());
				dealVO.setDetailText(deal.getDetail_text());
				dealVO.setCan_buy(deal.getCan_buy());
				dealVO.setAvailability(deal.getAvailability());
				dealVO.setOriginal_price(deal.getOriginal_price());
				dealVO.setContent_type(deal.getContent_type());
				dealVO.setDeallike_count(deal.getDeallike_count());
				dealVO.setDealshare_count(deal.getDealshare_count());
				dealVO.setDealview_count(deal.getDealview_count());
				dealVO.setDetails(deal.getDetails());
				dealVO.setOpening_quantity(deal.getOpening_quantity());
				dealVO.setDealOrderedCount(deal.getOrderedCount());
				// set merchant Details
				MerchantBranch mb = getMerchantDetailForMerchantBranchId(deal
						.getMerchantbranch_id());
				if (mb != null) {
					dealVO.setMerchantName(mb.getBranch_name());
					dealVO.setMerchantBranchid(mb.getId());
					dealVO.setMerchantAddress(mb.getAddress());
					dealVO.setImageUrl(getImagePath(mb.getMerchant_id(),
							deal.getId()));
					dealVO.setMerchantLongitude(mb.getLongitude());
					dealVO.setMerchantLatitude(mb.getLattitue());
					dealVO.setMin_order_value(mb.getMin_order_value());
					dealVO.setOperation_time(mb.getOperation_time());

					dealVO.setMerchantLogo(getMerchantLogoImagePath(mb
							.getMerchant_id()));// merchant logic

					Merchant merchant = getMerchantDetailForMerchantId(mb
							.getMerchant_id());
					if (merchant != null) {
						dealVO.setMerchantName(merchant.getName());
					}
				}
				Double dis = DistanceCalculatorUtil.distance(new Double(
						latitude), new Double(longitude), mb.getLattitue(), mb
						.getLongitude(), "K");
				dealVO.setDistance(dis);
				// get deliveryType
				List<DealDeliveryType> ddts = dealDeliveryTypeDao
						.getAllDeliveryTypesForDealIdList(deal.getId());
				if (ddts != null) {
					List<String> options = new ArrayList<String>();
					for (Iterator iterator2 = ddts.iterator(); iterator2
							.hasNext();) {
						DealDeliveryType dealDeliveryType = (DealDeliveryType) iterator2
								.next();
						DeliveryType dt = deliveryTypeDao
								.getDeliveryTypeForDeliveryTypeId(dealDeliveryType
										.getDeliveryid());
						options.add(dt.getType());
					}
					dealVO.setDeliveryTypes(options);
				}
				dealVOs.add(dealVO);
			}
		}
		tagListDealsPageVO.setDeals(dealVOs);
		TagDealsListResponseVO tdlrvo = new TagDealsListResponseVO();
		tdlrvo.setResult(tagListDealsPageVO);
		return tdlrvo;
	}

	public TagDealsListResponseVO getAllDealsForSearchString(
			String searchString, String latitude, String longitude) {
		TagDealsListResponseVO tagDealsListResponseVO = null;
		try {
			String locationStr = getLocation(latitude, longitude);
			Location location1 = locationDao.getLocation(locationStr);
			List<Long> branchIds = getMerchantBranchForLocation(location1
					.getId());
			List<Deal> dealsListTotal = dealDao
					.getAllDealsForLocation(branchIds);
			List<Deal> dealsList = dealDao
					.getAllDealsForBranchIdsAndMultipleSearchString(branchIds,
							searchString);
			tagDealsListResponseVO = prepareTagDealsListVO(dealsList, ""
					+ dealsListTotal.size(), latitude, longitude);
			return tagDealsListResponseVO;

		} catch (Exception ekl) {// nearest logic for search string (deal)
			List<MerchantBranch> mb = merchantBranchDao
					.getMerchantBranchForNearestLocationList();
			Iterator iterator = null;
			List<Long> branchidList = new ArrayList<Long>();
			for (iterator = mb.iterator(); iterator.hasNext();) {
				MerchantBranch mbo = (MerchantBranch) iterator.next();
				try {
					double kmDealTag = getNearestLocationDistance(latitude,
							longitude, mbo.lattitue, mbo.longitude);
					if (kmDealTag <= 3.5) {
						branchidList.add(mbo.getId());
					}

				} catch (Exception ek1) {
					ek1.printStackTrace();
				}
			}
			List<Deal> dealsListTotaln = dealDao
					.getAllDealsForLocation(branchidList);
			List<Deal> dealsListn = dealDao
					.getAllDealsForBranchIdsAndMultipleSearchString(
							branchidList, searchString);
			tagDealsListResponseVO = prepareTagDealsListVO(dealsListn, ""
					+ dealsListTotaln.size(), latitude, longitude);
			return tagDealsListResponseVO;

		}
	}

	public String getLocation(String latitude, String longitude) {
		String location = null;
		GetAddressGoogleApi getAddressGoogleApi = new GetAddressGoogleApi();
		GetLocationAddressGoogleApi getLocationAddressGoogleApi = new GetLocationAddressGoogleApi();
		try {
			String address1 = getLocationAddressGoogleApi.getLocationAddress(
					latitude, longitude);
			GoogleLocationResponseVO google_location = null;
			ObjectMapper mapper1 = new ObjectMapper();
			google_location = mapper1.readValue(address1,
					GoogleLocationResponseVO.class);
			for (int i = 0; i < google_location.getResults()[0]
					.getAddress_components().length; i++) {
				if (google_location.getResults()[0].getAddress_components()[i]
						.getTypes()[0].equals("sublocality_level_1")) {
					location = google_location.getResults()[0]
							.getAddress_components()[i].getShort_name();
				}
			}
		} catch (Exception ek) {
			ek.printStackTrace();
		}
		return location;
	}

	public String getCityName(String latitude, String longitude) {
		String city = null;
		GetAddressGoogleApi getAddressGoogleApi = new GetAddressGoogleApi();
		GetLocationAddressGoogleApi getLocationAddressGoogleApi = new GetLocationAddressGoogleApi();
		try {
			String jsonForCityName = getLocationAddressGoogleApi.getCityName(
					latitude, longitude);
			GoogleLocationResponseVO google_location_city_name = null;
			ObjectMapper mapper1 = new ObjectMapper();
			google_location_city_name = mapper1.readValue(jsonForCityName,
					GoogleLocationResponseVO.class);
			for (int i = 0; i < google_location_city_name.getResults()[0]
					.getAddress_components().length; i++) {
				if (google_location_city_name.getResults()[0]
						.getAddress_components()[i].getTypes()[0]
						.equals("locality")) {
					city = google_location_city_name.getResults()[0]
							.getAddress_components()[i].getShort_name();
				}
			}
		} catch (Exception ek) {
			ek.printStackTrace();
		}
		return city;
	}

	/*
	 * public User getUserId(String device_id, String email) { User user =
	 * userDao.checkUser(device_id, email); if (user == null) { return
	 * userDao.saveUser(device_id, email); } else { return user; } }
	 */

	public User getUserByEmail(String email) {
		User user = userDao.getUserByEmail(email);
		return user;
	}

	public User getUserByDevice(String deviceId) {
		User user = userDao.getUserByDevice(deviceId);
		return user;
	}

	public void saveUser(Long id, String first_name, String email,
			String mobile_number, String address, long cust_id)
			throws Exception {
		User user = userDao.getUserByCustid(cust_id);
		userDao.addUser(id, first_name, email, mobile_number, address, cust_id,
				user);
	}

	public void saveNewOrderDetails(Double longitude, Double latitude,
			String address, String landmark, String order_type,
			Long order_quantity, double order_amount, Long deal_id,
			String delivery_status, String status, Long cust_id,
			String mobile_number, String first_name, String useremailid) {
		String merchantbranchemail = null;
		String merchantname = null;
		String mob_no_merchant = null;
		String orderidcreate = null;
		Long merchant_branch_id = null;

		Deal mb = getMerchantBranchDetailForDealId(deal_id);
		EmailUtility emailUtility = new EmailUtility();
		SmsUtility smsUtility = new SmsUtility();

		if (mb != null) {
			String dealname = mb.getName();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yymmddhhmmss");
			Calendar calendar = Calendar.getInstance();
			simpleDateFormat.format(calendar.getTime());
			String orimob = mobile_number;

			String mobsub = mobile_number.substring(8, 10);
			orderidcreate = "BA" + simpleDateFormat.format(calendar.getTime())
					+ first_name.substring(0, 2).toUpperCase() + mobsub;

			MerchantBranch merchantBranch = getMerchantDetailForMerchantBranchId(mb
					.getMerchantbranch_id());
			if (merchantBranch != null) {
				mob_no_merchant = "" + merchantBranch.getMobile_number();
				merchant_branch_id = merchantBranch.getId();
				merchantbranchemail = merchantBranch.getE_mail();

				Merchant merchant = getMerchantDetailForMerchantId(merchantBranch
						.getMerchant_id());
				if (merchant != null) {
					merchantname = merchant.getName();
					// email and message send

					emailUtility.emailSend("manoharan@getwise.in",
							orderidcreate, first_name, address, mobile_number,
							order_quantity, order_amount, merchantname,
							dealname, order_type);
					smsUtility.smsSend(orderidcreate, order_quantity,
							merchantname, "9840979995", dealname, order_type,
							first_name, mobile_number);

					emailUtility.emailSend("vinay@getwise.in", orderidcreate,
							first_name, address, mobile_number, order_quantity,
							order_amount, merchantname, dealname, order_type);
					smsUtility.smsSend(orderidcreate, order_quantity,
							merchantname, "9741158599", dealname, order_type,
							first_name, mobile_number);

					emailUtility.emailSend("peter@getwise.in", orderidcreate,
							first_name, address, mobile_number, order_quantity,
							order_amount, merchantname, dealname, order_type);
					smsUtility.smsSend(orderidcreate, order_quantity,
							merchantname, "9840718462", dealname, order_type,
							first_name, mobile_number);

				}
			}
			orderDeatilDao.addOrderDetail(longitude, latitude, address,
					landmark, order_type, order_quantity, order_amount,
					deal_id, delivery_status, status, cust_id, mobile_number,
					first_name, orderidcreate, merchant_branch_id);
			float f1 = (float) order_amount;
			ordersDao.saveOrder(orderidcreate, deal_id, order_quantity, f1);

		}

	}

	public Status saveAddToCartOrderDetails(double longitude, double latitude,
			String address, String landmark, String order_type,
			List<Orders> orders, String order_amount, String delivery_status,
			String status, Long cust_id, String mobile_number,
			String first_name, String useremailid, String discount_method,
			double discount_amount, String coupon_code,String delivery_date,String delivery_time) {
		Status status2 = new Status();
		String merchantbranchemail = null;
		String merchantname = null;
		String mob_no_merchant = null;
		String orderidcreate = null;
		Long merchant_branch_id = null;
		Long deal_id = null;
		Long order_quantitys = null;
		Long temp_qty = null;
		Long cunt_qty = 0L;
		Long order_quantity = null;
		for (Orders order : orders) {
			deal_id = Long.parseLong("" + order.getDeal_id());
			order_quantitys = Long.parseLong("" + order.getQuantity());
			cunt_qty++;
		}
		String order_quantityss = "" + cunt_qty;
		Deal mb = getMerchantBranchDetailForDealId(deal_id);
		EmailUtility emailUtility = new EmailUtility();
		SmsUtility smsUtility = new SmsUtility();
		SpearSMSUtility spearSMSUtility = new SpearSMSUtility();

		if (mb != null) {
			String dealname = mb.getName();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yymmddhhmmss");
			Calendar calendar = Calendar.getInstance();
			simpleDateFormat.format(calendar.getTime());
			String orimob = mobile_number;

			String mobsub = mobile_number.substring(8, 10);
			String trimFirstName = first_name.replaceAll(" ", "").substring(0,
					2);
			orderidcreate = "BA" + simpleDateFormat.format(calendar.getTime())
					+ trimFirstName.toUpperCase().trim() + mobsub;

			MerchantBranch merchantBranch = getMerchantDetailForMerchantBranchId(mb
					.getMerchantbranch_id());
			if (merchantBranch != null) {
				mob_no_merchant = "" + merchantBranch.getMobile_number();
				merchant_branch_id = merchantBranch.getId();
				merchantbranchemail = merchantBranch.getE_mail();

				Merchant merchant = getMerchantDetailForMerchantId(merchantBranch
						.getMerchant_id());
				if (merchant != null && order_type.equals("COD")
						|| order_type.equals("FO")) {
					merchantname = merchant.getName();

					// email and message send//old api for sms mantra

					/*
					 * emailUtility.emailSendAddToCart("manoharan@getwise.in",
					 * orderidcreate, first_name, address, mobile_number,
					 * order_quantityss, order_amount, merchantname, dealname,
					 * order_type); smsUtility.smsSendAddToCart(orderidcreate,
					 * order_quantityss, merchantname, "9840979995", dealname,
					 * order_type, first_name, mobile_number);
					 * 
					 * emailUtility.emailSendAddToCart("yuvaraj@getwise.in",
					 * orderidcreate, first_name, address, mobile_number,
					 * order_quantityss, order_amount, merchantname, dealname,
					 * order_type); smsUtility.smsSendAddToCart(orderidcreate,
					 * order_quantityss, merchantname, "9986699280", dealname,
					 * order_type, first_name, mobile_number);
					 * 
					 * emailUtility.emailSendAddToCart("peter@getwise.in",
					 * orderidcreate, first_name, address, mobile_number,
					 * order_quantityss, order_amount, merchantname, dealname,
					 * order_type); smsUtility.smsSendAddToCart(orderidcreate,
					 * order_quantityss, merchantname, "9840718462", dealname,
					 * order_type, first_name, mobile_number);
					 * 
					 * emailUtility.emailSendAddToCart("jasmeet@getwise.in",
					 * orderidcreate, first_name, address, mobile_number,
					 * order_quantityss, order_amount, merchantname, dealname,
					 * order_type); smsUtility.smsSendAddToCart(orderidcreate,
					 * order_quantityss, merchantname, "9632308678", dealname,
					 * order_type, first_name, mobile_number);
					 */// new Api for Spear Communication

					// get All Operation Managment Team Email and mobno
					long role_id = 0;
					Roles roles = rolesDao.getOperationMangUserData();
					if (roles != null) {
						// getAll_Ids
						role_id = roles.getId();

					}
					String getUserEmails = null;
					String getUserMob_no = null;
					List<User> users_details = userDao
							.getOperationMangUserDataDetails(role_id);
					if (users_details != null) {
						for (User user : users_details) {
							getUserEmails = user.getUsername();
							getUserMob_no = user.getMobile_number();

							GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
							String orderdate = ""
									+ getDateFromSystem.getDateFromSystem();
							String orderdatetime = orderdate.substring(11, 16);
							String smsnewtemplate = "Dear Team New Order "
									+ orderidcreate + " received for "
									+ merchantname + " at " + orderdatetime
									+ " from " + first_name + " mobile no "
									+ mobile_number + ".";
							try {
								emailUtility.emailSendAddToCart(getUserEmails,
										orderidcreate, first_name, address,
										mobile_number, order_quantityss,
										order_amount, merchantname, dealname,
										order_type);
								spearSMSUtility.process_sms(getUserMob_no,
										smsnewtemplate, "", "", "");

							} catch (Exception ek) {
							}
						}
					}
					// sms going to cutomer
					try {
						String dealNames = "";
						for (Orders order4 : orders) {
							dealNames += order4.getDeal_name() + "-"
									+ order4.getQuantity() + ",";
						}
						dealNames = dealNames.substring(0,
								dealNames.length() - 1);
						String smsnewtemplateCustomer = "Dear " + first_name
								+ " your order for " + dealNames + " Order id "
								+ orderidcreate
								+ " received. Thanks Hungry Bells";
						spearSMSUtility.process_sms(mobile_number,
								smsnewtemplateCustomer, "", "", "");
					} catch (Exception ek) {

					}

				}
			}
			
			//Repeat order check
			int orderNumber=getOrderCount(cust_id)+1;
			if(discount_method.trim().equals("repeat_order")){
				if(offerExistsForOrder(getOrderCount(cust_id)+1))
					coupon_code="Repeat order #"+orderNumber;
				else{
					discount_method="none";
					coupon_code="none";
			}}
			
			orderDeatilDao.addOrderDetailAddTOCart(longitude, latitude,
					address, landmark, order_type, cunt_qty,
					Double.parseDouble(order_amount), deal_id, delivery_status,
					status, cust_id, mobile_number, first_name, orderidcreate,
					merchant_branch_id, discount_method, discount_amount,
					coupon_code,delivery_date,delivery_time);

			for (Orders orders2 : orders) {
				ordersDao.saveOrders(orderidcreate, orders2.getDeal_id(),
						orders2.getQuantity(), orders2.getAmount(),
						orders2.getDeal_name(), orders2.getMerchant_name());
			}

			String location_name1 = getLocation("" + latitude, "" + longitude);
			String city_name = getCityName("" + latitude, "" + longitude);
			long cityId = cityDao.getCityId(city_name);
			if (!locationDao.locationExists(cityId, location_name1))
				locationDao.saveNewLocation(latitude, longitude,
						location_name1, cityId);
	
		}
		status2.setCode(1);
		status2.setMessage("Order Placed  Successfully");
		status2.setOrderid(orderidcreate);
		return status2;
	}

	private boolean offerExistsForOrder(int orderNumber) {
		return repeatDiscountDao.getCheckExistsUser(orderNumber);	
	}

	private Deal getMerchantBranchDetailForDealId(Long dealId) {
		Deal mbs = dealDao.getDealForDealId(dealId);
		return mbs;

	}

	public DealVO getDealForDealId(String dealId) {

		Deal deal = dealDao.getDealForDealId(Long.parseLong(dealId));
		DealVO dealVO = new DealVO();
		dealVO.setDealId(deal.getId());
		dealVO.setName(deal.getName());
		dealVO.setCan_buy(deal.getCan_buy());
		dealVO.setDetailText(deal.getDetail_text());
		dealVO.setDealPrice(deal.getDeal_price());
		return dealVO;
	}

	private List<TagVO> prepareTagVOList(List<Deal> deals) {

		List<TagVO> tagsList = new ArrayList<TagVO>();

		if (deals != null) {
			HashMap<String, String> nearest = new HashMap();

			for (Iterator iterator = deals.iterator(); iterator.hasNext();) {
				Deal deal = (Deal) iterator.next();
				String[] dealsTag = deal.getTag().split(",");
				// System.out.println(dealsTag);
				for (int i = 0; i < dealsTag.length; i++) {
					if (nearest.get(dealsTag[i]) == null) {
						nearest.put(dealsTag[i], dealsTag[i]);
					}
				}
			}

			Set keys = nearest.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				String tagName = (String) iterator.next();
				String tagId = nearest.get(tagName);
				if (!tagName.trim().isEmpty()) {
					TagVO tagVO = new TagVO();
					tagVO.setTag_id(tagId);
					tagVO.setTag_name(tagName);

					tagsList.add(tagVO);
				}
			}
		}
		return tagsList;

	}

	private List<TagVO> prepareTagVOListrecom(List<Deal> dealss) {

		List<TagVO> tagsList1 = new ArrayList<TagVO>();

		if (dealss != null) {
			HashMap<String, String> nearest1 = new HashMap();

			for (Iterator iterator = dealss.iterator(); iterator.hasNext();) {
				Deal deal = (Deal) iterator.next();
				String[] dealsTag1 = deal.getTag().split(",");
				// System.out.println(dealsTag);
				System.out.println("----------voList---r1-------");
				for (int i = 0; i < dealsTag1.length; i++) {
					if (nearest1.get(dealsTag1[i]) == null) {
						nearest1.put(dealsTag1[i], dealsTag1[i]);
					}
				}
			}

			Set keys = nearest1.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				String tagName1 = (String) iterator.next();
				System.out.println("----------voList---r-2------");
				String tagId = nearest1.get(tagName1);
				if (!tagName1.trim().isEmpty()) {
					TagVO tagVO1 = new TagVO();
					tagVO1.setTag_id(tagId);
					tagVO1.setTag_name(tagName1);

					tagsList1.add(tagVO1);
					System.out.println("----------voList---r-3------"
							+ tagName1);
				}
			}
		}
		return tagsList1;

	}

	public ChangeLocationResponseVO getChangeAllLocationList(String latitude,
			String longitude) {
		ChangeLocationResponseVO changeLocationResponseVO = new ChangeLocationResponseVO();

		if (latitude.equals("0") && longitude.equals("0")) {
			List<Location> mb = locationDao.getChangeLocationList();
			List<LocationVO> changeList = new ArrayList<LocationVO>();
			Iterator iterator = null;
			Iterator iterator1 = null;
			List<Long> branchidList = new ArrayList<Long>();
			ArrayList<LocationVO> loList = new ArrayList();
			Location locations = null;
			try {
				for (iterator1 = mb.iterator(); iterator1.hasNext();) {
					Location lc = (Location) iterator1.next();
					LocationVO locationVO = new LocationVO();

					boolean checklocation = checkLocation(lc.getId(), mb);
					if (checklocation == true) {
						/*
						 * double dis = getNearestLocationDistance(latitude,
						 * longitude, Double.parseDouble(lc.latitude),
						 * Double.parseDouble(lc.longitude));
						 *//*
							 * if (dis <= 12.0) {
							 *///
						locationVO.setDistance(0.0);
						locationVO.setLocationName(lc.getName());
						locationVO.setLatitude(lc.getLatitude());
						locationVO.setLongitude(lc.getLongitude());
						changeList.add(locationVO);
						loList.add(locationVO);
						/* } */

					}
				}
			} catch (Exception ek) {
				ek.printStackTrace();
			}
			Collections.sort(changeList);
			changeLocationResponseVO.setChangeLocation(changeList);

		} else {
			List<Location> mb = locationDao.getChangeLocationList();
			List<LocationVO> changeList = new ArrayList<LocationVO>();
			Iterator iterator = null;
			Iterator iterator1 = null;
			List<Long> branchidList = new ArrayList<Long>();
			ArrayList<LocationVO> loList = new ArrayList();
			Location locations = null;
			try {
				for (iterator1 = mb.iterator(); iterator1.hasNext();) {
					Location lc = (Location) iterator1.next();
					LocationVO locationVO = new LocationVO();

					boolean checklocation = checkLocation(lc.getId(), mb);
					if (checklocation == true) {
						double dis = getNearestLocationDistance(latitude,
								longitude, Double.parseDouble(lc.latitude),
								Double.parseDouble(lc.longitude));
						if (dis <= 12.0) {
							locationVO.setDistance(dis);
							locationVO.setLocationName(lc.getName());
							locationVO.setLatitude(lc.getLatitude());
							locationVO.setLongitude(lc.getLongitude());
							changeList.add(locationVO);
							loList.add(locationVO);
						}

					}
				}
			} catch (Exception ek) {
				ek.printStackTrace();
			}
			Collections.sort(changeList);
			changeLocationResponseVO.setChangeLocation(changeList);
		}
		return changeLocationResponseVO;

	}

	private boolean checkLocation(Long locationVoId, List<Location> mb) {
		for (Location location : mb) {
			if (locationVoId == location.getId()) {
				return true;
			}
		}

		return false;
	}

	public void saveDealLiked(String userId, String dealId) {
		dealUserLikeDao.saveUserLike(new Long(userId), null, new Long(dealId));
		dealDao.updateDealUserActionForDealId(new Long(dealId), "like");
	}

	public void saveDealFavourited(String userId, String dealId) {
		dealUserFavouritesDao.saveUserFavourite(new Long(userId), null,
				new Long(dealId));
	}

	public void saveDealShared(String userId, String dealId) {
		dealUserSharedDao.saveUserFavourite(new Long(userId), null, new Long(
				dealId));
		dealDao.updateDealUserActionForDealId(new Long(dealId), "share");
	}

	public void saveDealViewed(String userId, String dealId) {
		dealUserViewDao.saveUserView(new Long(userId), null, new Long(dealId));
		dealDao.updateDealUserActionForDealId(new Long(dealId), "view");
	}

	public String getImagePath(Long merchantId, Long dealId) {

		String testUrl = "http://testservice.hungrybells.in:9091/images/merchant/deal/";
		String productionUrl = "http://service.hungrybells.in:9090/images/merchant/deal/";

		String url = productionUrl;
		String imageName = merchantId + "_" + dealId;
		String imageUrl = url + imageName + ".png";
		return imageUrl;

	}

	public String getMerchantLogoImagePath(Long merchantId) {

		String testUrl = "http://testservice.hungrybells.in:9091/images/merchant/";
		String productionUrl = "http://service.hungrybells.in:9090/images/merchant/";

		String url = productionUrl;
		String imageName = "MERCHANT_" + merchantId;
		String imageUrl = url + imageName + ".png";
		return imageUrl;

	}

	public Double getNearestLocationDistance(String latitude, String longitude,
			double latitude1, double longitude1) {
		double dis = 0.0;
		DistanceCalculatorUtil distanceCalculatorUtil = new DistanceCalculatorUtil();
		try {
			dis = distanceCalculatorUtil.distance(Double.parseDouble(latitude),
					Double.parseDouble(longitude), latitude1, longitude1, "K");
		} catch (Exception ek) {
			ek.printStackTrace();
		}
		return dis;

	}

	public HomePageResponseVO getAllHomePageData(String latitude,
			String longitude) {
		HomePageResponseVO homePageResponseVo = new HomePageResponseVO();
		Status status = new Status();
		if (latitude.isEmpty() && longitude.isEmpty()) {
			status.setMessage("failure");
		} else {
			try {
				String locationStr1 = getLocation(latitude, longitude);
				Location location1 = locationDao.getLocation(locationStr1);
				List<Long> ids = getMerchantBranchForLocation(location1.getId());
				List<Deal> dealsListTotal = dealDao.getAllDealsForLocation(ids);
				trendingtag = trendingTagDao.getAllTag(location1.getName(), 13);
				recomendedtag = recommendedTagDao.getAllTagRecom(location1.getName(), 13);
				homePageResponseVo = prepareHomePageVO(null, null, null, ""	+ dealsListTotal.size(), null, trendingtag, null,recomendedtag);
				homePageResponseVo.getResult().setLocation(location1.getName());
				return homePageResponseVo;
			} catch (Exception ek) {
				String locationStr = getLocation(latitude, longitude);
				System.out.print("---location name--1--" + locationStr);
				List<MerchantBranch> mb = merchantBranchDao
						.getMerchantBranchForNearestLocationList();
				Iterator iterator = null;
				List<Long> branchidList = new ArrayList<Long>();
				for (iterator = mb.iterator(); iterator.hasNext();) {
					MerchantBranch mbo = (MerchantBranch) iterator.next();
					try {
						double kmDealTag = getNearestLocationDistance(latitude,
								longitude, mbo.lattitue, mbo.longitude);
						if (kmDealTag <= 3.5) {
							branchidList.add(mbo.getId());
						}
					} catch (Exception ek1) {
						ek1.printStackTrace();
					}
				}
				List<Deal> dealsListTotal = dealDao
						.getAllDealsForLocation(branchidList);
				List<Deal> dealsList = dealDao
						.getNearestAllDealsForBranchIds(branchidList);
				List<Deal> recoDealsList = dealDao
						.getAllRecommendedDealsForLocation(branchidList);
				homePageResponseVo = prepareHomePageVO(null, recoDealsList,
						null, "" + dealsListTotal.size(), null, null,
						dealsList, null);
				homePageResponseVo.getResult().setLocation(locationStr);
			}
		}
		return homePageResponseVo;

	}

	private List<TagVO> prepareTagVOListTrending(List<Deal> deals,
			String locationName, List<TrendingTag> trendingtag,
			List<TrendingTag> nearestList) {
		List<TagVO> tagsListr = new ArrayList<TagVO>();
		if (trendingtag != null) {
			LinkedHashMap<String, String> trending1 = new LinkedHashMap<String, String>();
			for (Iterator iterator = trendingtag.iterator(); iterator.hasNext();) {
				TrendingTag tag = (TrendingTag) iterator.next();
				String[] dealsTag = tag.getTagName_of_location().split(",");
				for (int i = 0; i < dealsTag.length; i++) {
					if (trending1.get(dealsTag[i]) == null) {
						trending1.put(dealsTag[i], dealsTag[i]);
					}
				}
			}
			Set keys1 = trending1.keySet();
			for (Iterator iterator = keys1.iterator(); iterator.hasNext();) {
				String tagName = (String) iterator.next();
				if (!tagName.trim().isEmpty()) {
					String tagId = trending1.get(tagName);
					TagVO tagVO = new TagVO();
					tagVO.setTag_id(tagId);
					tagVO.setTag_name(tagName);
					tagsListr.add(tagVO);
				}
			}
		}
		return tagsListr;
	}

	private List<TagVO> prepareTagVOListRecom(List<Deal> deals,
			String locationName, List<RecommendedTag> recomtag,
			List<TrendingTag> nearestList) {
		List<TagVO> tagsListr = new ArrayList<TagVO>();
		if (recomtag != null) {
			LinkedHashMap<String, String> recomend = new LinkedHashMap<String, String>();
			for (Iterator iterator = recomtag.iterator(); iterator.hasNext();) {
				RecommendedTag tag = (RecommendedTag) iterator.next();
				String[] dealsTag = tag.getTagName_of_location().split(",");
				for (int i = 0; i < dealsTag.length; i++) {
					if (recomend.get(dealsTag[i]) == null) {
						recomend.put(dealsTag[i], dealsTag[i]);
					}
				}
			}
			Set keys1 = recomend.keySet();
			for (Iterator iterator = keys1.iterator(); iterator.hasNext();) {
				String tagName = (String) iterator.next();
				if (!tagName.trim().isEmpty()) {
					String tagId = recomend.get(tagName);
					TagVO tagVO = new TagVO();
					tagVO.setTag_id(tagId);
					tagVO.setTag_name(tagName);
					tagsListr.add(tagVO);
				}
			}
		}
		return tagsListr;

	}

	String locationName;

	private List<TagVO> prepareTagVOListTrendingTagInsert(List<Deal> deals,
			String locationName) {
		int count = 0;
		this.locationName = locationName;
		if (deals != null) {
			LinkedHashMap<String, Integer> resultsMap = new LinkedHashMap<String, Integer>();
			for (Deal deal : deals) {
				int dealPriority = ((deal.getDealview_count() * 1)
						+ (deal.getDeallike_count() * 2) + (deal
						.getDealshare_count() * 3));
				String tag = deal.getTag();
				if (tag != null) {
					String tagArray[] = tag.split(",");
					if (tagArray.length > 1) {
						for (String tagName : tagArray) {
							boolean checktag = checkTagExist(tagName,
									resultsMap);
							if (checktag == true) {
								int oldvalue = resultsMap.get(tagName);
								resultsMap
										.put(tagName, dealPriority + oldvalue);
							} else {
								resultsMap.put(tagName, dealPriority);
							}
						}
					} else {
						for (String tagName : tagArray) {
							boolean checktag = checkTagExist(tagName,
									resultsMap);
							if (checktag == true) {
								int oldvalue = resultsMap.get(deal.getTag());
								resultsMap.put(deal.getTag(), dealPriority
										+ oldvalue);
							} else {
								resultsMap.put(deal.getTag(), dealPriority);
							}
						}
					}
				}

			}

			Map hashMap = sortByValue(resultsMap);

			List<TagVO> tagsList = new ArrayList<TagVO>();
			Set keys = hashMap.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				count++;
				String tagName = (String) iterator.next();

				TagVO tagVO = new TagVO();
				tagVO.setTag_id(tagName);
				tagVO.setTag_name(tagName);
				tagsList.add(tagVO);
				/* if (count < 15) { */
				trendingTagDao.addTrendingTag(locationName, tagName.trim());
				/* } */
			
			}
			return tagsList;

		}
		return null;
	}

	String locationName1;

	private List<TagVO> prepareTagVOListTrendingTagInsertRecom(
			List<Deal> deals, String locationName) {
		int count = 0;
		this.locationName1 = locationName;
		if (deals != null) {
			LinkedHashMap<String, Integer> resultsMap = new LinkedHashMap<String, Integer>();
			for (Deal deal : deals) {
				int dealPriority = ((deal.getDealview_count() * 1)
						+ (deal.getDeallike_count() * 2) + (deal
						.getDealshare_count() * 3));
				String tag = deal.getTag();
				if (tag != null) {
					String tagArray[] = tag.split(",");
					if (tagArray.length > 1) {
						for (String tagName : tagArray) {
							boolean checktag = checkTagExist(tagName,
									resultsMap);
							if (checktag == true) {
								int oldvalue = resultsMap.get(tagName);
								resultsMap
										.put(tagName, dealPriority + oldvalue);
							} else {
								resultsMap.put(tagName, dealPriority);
							}
						}
					} else {
						for (String tagName : tagArray) {
							boolean checktag = checkTagExist(tagName,
									resultsMap);
							if (checktag == true) {
								int oldvalue = resultsMap.get(deal.getTag());
								resultsMap.put(deal.getTag(), dealPriority
										+ oldvalue);
							} else {
								resultsMap.put(deal.getTag(), dealPriority);
							}
						}
					}
				}

			}

			Map hashMap = sortByValue(resultsMap);

			List<TagVO> tagsList = new ArrayList<TagVO>();
			Set keys = hashMap.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				count++;
				String tagName = (String) iterator.next();

				TagVO tagVO = new TagVO();
				tagVO.setTag_id(tagName);
				tagVO.setTag_name(tagName);
				tagsList.add(tagVO);
				/* if (count < 15) { */
				recommendedTagDao.addRecommendedTag(locationName,
						tagName.trim());
				/* } */
			

			}
			
			return tagsList;

		}
		
		return null;
	}

	public Map sortByValue(LinkedHashMap<String, Integer> map) {
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		Map result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	private Boolean checkTagExist(String tagName,
			LinkedHashMap<String, Integer> hashMap) {
		Set set = hashMap.entrySet();
		Iterator integer = set.iterator();
		while (integer.hasNext()) {
			Map.Entry object = (Map.Entry) integer.next();
			if (tagName == object.getKey()) {
				return true;
			}

		}

		return false;
	}

	// /---------Add TO Cart-- select deal--------

	public TagDealsListResponseVOAddToCart getAllDealsForBranchNameAddTOCart(
			Long merchantbranch_id, String latitude, String longitude) {
		TagDealsListResponseVOAddToCart tagDealsListResponseVOAddToCart = null;
		try {

			List<Deal> dealsList = dealDao
					.getAllDealsForBranchIdsAndTagAddToCart(merchantbranch_id);
			tagDealsListResponseVOAddToCart = prepareTagDealsListVOAddTOCart(
					dealsList, null, latitude, longitude);
			return tagDealsListResponseVOAddToCart;

		} catch (Exception ek) {
			ek.printStackTrace();

		}
		return null;

	}

	private TagDealsListResponseVOAddToCart prepareTagDealsListVOAddTOCart(
			List<Deal> deals, String items, String latitude, String longitude) {

		TagListDealsPageVOATC tagListDealsPageVO = new TagListDealsPageVOATC();
		tagListDealsPageVO.setTotal_food_items(items);
		List<DealVOACT> dealVOs = new ArrayList<DealVOACT>();
		if (deals != null && deals.size() > 0) {
			for (Iterator iterator = deals.iterator(); iterator.hasNext();) {
				Deal deal = (Deal) iterator.next();
				DealVOACT dealVO = new DealVOACT();
				dealVO.setDealId(deal.getId());
				dealVO.setName(deal.getName());
				dealVO.setDealPrice(deal.getDeal_price());
				dealVO.setDetailText(deal.getDetail_text());
				dealVO.setCan_buy(deal.getCan_buy());
				dealVO.setAvailability(deal.getAvailability());
				dealVO.setOriginal_price(deal.getOriginal_price());
				dealVO.setContent_type(deal.getContent_type());
				dealVO.setDeallike_count(deal.getDeallike_count());
				dealVO.setDealshare_count(deal.getDealshare_count());
				dealVO.setDealview_count(deal.getDealview_count());
				dealVO.setDetails(deal.getDetails());
				// set merchant Details
				MerchantBranch mb = getMerchantDetailForMerchantBranchId(deal
						.getMerchantbranch_id());
				if (mb != null) {
					dealVO.setMerchantName(mb.getBranch_name());
					dealVO.setMerchantBranchid(mb.getId());
					dealVO.setMerchantAddress(mb.getAddress());
					dealVO.setImageUrl(getImagePath(mb.getMerchant_id(),
							deal.getId()));
					dealVO.setMerchantLongitude(mb.getLongitude());
					dealVO.setMerchantLatitude(mb.getLattitue());
					dealVO.setMin_order_value(mb.getMin_order_value());
					dealVO.setOperation_time(mb.getOperation_time());

					dealVO.setMerchantLogo(getMerchantLogoImagePath(mb
							.getMerchant_id()));// merchant logic

					Merchant merchant = getMerchantDetailForMerchantId(mb
							.getMerchant_id());
					if (merchant != null) {
						dealVO.setMerchantName(merchant.getName());
					}
				}
				Double dis = DistanceCalculatorUtil.distance(new Double(
						latitude), new Double(longitude), mb.getLattitue(), mb
						.getLongitude(), "K");
				dealVO.setDistance(dis);
				// get deliveryType
				List<DealDeliveryType> ddts = dealDeliveryTypeDao
						.getAllDeliveryTypesForDealIdList(deal.getId());
				if (ddts != null) {
					List<String> options = new ArrayList<String>();
					for (Iterator iterator2 = ddts.iterator(); iterator2
							.hasNext();) {
						DealDeliveryType dealDeliveryType = (DealDeliveryType) iterator2
								.next();
						DeliveryType dt = deliveryTypeDao
								.getDeliveryTypeForDeliveryTypeId2(dealDeliveryType
										.getDeliveryid());
						options.add(dt.getType());
						dealVO.setDeliveryTypes(options);
					}
				}

				/*
				 * List<String> ar = dealVO.getDeliveryTypes(); if
				 * (ar.contains("HOMEDELIVERY") || ar.contains("PICKUP")) {
				 */dealVOs.add(dealVO);
				/* } */
			}
		}
		tagListDealsPageVO.setDeals(dealVOs);
		TagDealsListResponseVOAddToCart tdlrvo = new TagDealsListResponseVOAddToCart();
		tdlrvo.setResult(tagListDealsPageVO);
		return tdlrvo;
	}

	private List<Long> getMerchantBranchForDealAddTocart(Long locationId) {
		List<Deal> mbs = dealDao
				.getMerchantBranchIdsForDealIdAddToCart(locationId);
		if (mbs != null) {
			List<Long> ids = new ArrayList<Long>();
			if (mbs != null) {
				for (Iterator iterator = mbs.iterator(); iterator.hasNext();) {
					Deal merchantBranch = (Deal) iterator.next();
					ids.add(merchantBranch.getId());
				}

			}
			return ids;
		}
		return null;

	}

	public void addPaymentStatus(PayUmoneyBean payment) {
		paymentDao.addPaymentStatus(payment);
	}

	/*
	 * public void addPaymentStatus1(String mihpayid, String mode, String
	 * status, String key, String txnid, String amount, String discount, String
	 * productinfo, String firstname, String lastname, String address1, String
	 * address2, String city, String state, String country, String zipcode,
	 * String email, String phone, String udf1, String udf2, String udf3, String
	 * udf4, String udf5, String hash, String Error, String PG_TYPE, String
	 * bank_ref_num, String shipping_firstname, String shipping_lastname, String
	 * shipping_address1, String shipping_address2, String shipping_city, String
	 * shipping_state, String shipping_country, String shipping_zipcode, String
	 * shipping_phone, String shipping_phoneverified, String unmappedstatus,
	 * String payuMoneyId) { paymentDao.addPaymentStatus1(mihpayid, mode,
	 * status, key, txnid, amount, discount, productinfo, firstname, lastname,
	 * address1, address2, city, state, country, zipcode, email, phone, udf1,
	 * udf2, udf3, udf4, udf5, hash, Error, PG_TYPE, bank_ref_num,
	 * shipping_firstname, shipping_lastname, shipping_address1,
	 * shipping_address2, shipping_city, shipping_state, shipping_country,
	 * shipping_zipcode, shipping_phone, shipping_phoneverified, unmappedstatus,
	 * payuMoneyId); }
	 */

	public Status saveFeedback(String order_id, String user_id, String rating,
			String feedback, String timestamp) {
		Status status2 = new Status();
		{
			feedbackDao.addFeedback(order_id, user_id, rating, feedback,
					timestamp);

		}
		status2.setCode(1);
		status2.setMessage("FeedBack Inserted  Successfully");
		return status2;
	}

	public void updateFeedBack(String order_id) {
		{
			orderDeatilDao.updateFeedback(order_id);

		}

	}

	static final Logger logger = Logger.getLogger(DynamicDataService.class);

	public Status isFeedBackPending(Long user_id) {
		Status status2 = new Status();
		{

			OrderDetail lastOrder = orderDeatilDao.getLastOrder(user_id);
			if (lastOrder != null) {
				if (lastOrder.getFeedback_received().equals("true")) {
					status2.setCode(0);
					status2.setMessage("false");
					status2.setOrderid(lastOrder.getOrder_id());
				} else {
					status2.setCode(1);
					status2.setMessage("true");
					status2.setOrderid(lastOrder.getOrder_id());
				}
			}
			return status2;
		}

	}

	public void sendTeamSmsEmailService(String orderidcreate,
			String first_name, String address, String mobile_number,
			String order_quantityss, String order_amount, String merchantname,
			String dealname, String order_type, String teamemail,
			String team_mobno, String customer_mobileno,
			String customer_emailid, ArrayList deals, ArrayList quantities) {
		{
			GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
			EmailUtility emailUtility = new EmailUtility();
			SmsUtility smsUtility = new SmsUtility();
			SpearSMSUtility spearSMSUtility = new SpearSMSUtility();
			String orderdate = "" + getDateFromSystem.getDateFromSystem();
			String orderdatetime = orderdate.substring(11, 16);
			// String
			// smsnewtemplate="Dear Team Customer Order "+orderidcreate+" dated "+orderdatetime+" Qty "+order_quantityss+" to "+merchantname+" has been placed by "+first_name+" mobile no "+mobile_number+".";
			String smsnewtemplate = "Dear Team New Order " + orderidcreate
					+ " received for " + merchantname + " at " + orderdatetime
					+ " from " + first_name + " mobile no " + mobile_number
					+ ".";
			try {
				if (team_mobno != null) {
					emailUtility.emailSendAddToCart(teamemail, orderidcreate,
							first_name, address, mobile_number,
							order_quantityss, order_amount, merchantname,
							dealname, order_type);
					spearSMSUtility.process_sms(team_mobno, smsnewtemplate, "",
							"", "");
				} else {
					String dealNames = "";
					for (int i = 0; i < deals.size(); i++) {
						dealNames += deals.get(i) + "-" + quantities.get(i);
						if (i < deals.size() - 1)
							dealNames += ",";

					}
					String smsnewtemplateCustomer = "Dear " + first_name
							+ " your order for " + dealNames + " Order id "
							+ orderidcreate + " received. Thanks Hungry Bells";

					emailUtility.emailSendAddToCart(customer_emailid,
							orderidcreate, first_name, address, mobile_number,
							order_quantityss, order_amount, merchantname,
							dealname, order_type);

					spearSMSUtility.process_sms(customer_mobileno,
							smsnewtemplateCustomer, "", "", "");

				}
			} catch (Exception ek) {
				ek.printStackTrace();
			}

		}

	}

	public MerchantStatus merchantLogin(String username, String password) {
		MerchantStatus status = new MerchantStatus();
		Map<String, String> map = new HashMap<String, String>();
		List<MerchantBranch> merchantBranchs = merchantBranchDao.loginMerchant(
				username, password);
		for (MerchantBranch merchantBranch : merchantBranchs) {
			map.put("e_mail", merchantBranch.getE_mail());
			map.put("branch_name", merchantBranch.getBranch_name());
			map.put("mob_no", "" + merchantBranch.getMobile_number());
			map.put("branch_id", "" + merchantBranch.getId());
			map.put("address", "" + merchantBranch.getAddress());
		}
		status.setStatus("success");
		status.setMerchantdetails(map);
		return status;

	}

	public MerchantOrderStatus merchantOrders(long merchantbranch_id) {
		MerchantOrderStatus status = new MerchantOrderStatus();

		List<Merchantorderdetails> list = new ArrayList<Merchantorderdetails>();

		List<NewOrderDetails> orders = newOrdersDetails
				.merchantOrders(merchantbranch_id);
		if (orders != null) {
			for (NewOrderDetails order : orders) {
				Merchantorderdetails merchantorderdetails = new Merchantorderdetails();

				merchantorderdetails.setDelivery_address(order
						.getDelivery_address());
				merchantorderdetails.setLandmark(order.getLandmark());
				merchantorderdetails.setOrder_type(order.getOrder_type());
				merchantorderdetails.setOrder_quantity(""
						+ order.getOrder_quantity());
				merchantorderdetails.setOrder_amount(""
						+ order.getOrder_amount());
				merchantorderdetails.setDeal_id("" + order.getDeal_id());
				merchantorderdetails.setOrder_date_time(order
						.getOrder_date_time());
				merchantorderdetails.setDelivery_status(order
						.getDelivery_status());
				merchantorderdetails.setOrder_status(order.getOrder_status());
				merchantorderdetails.setUser_id("" + order.getUser_id());
				merchantorderdetails.setMerchantbranch_id(""
						+ order.getMerchantbranch_id());
				merchantorderdetails.setOrder_id(order.getOrder_id());
				merchantorderdetails.setDiscount_method(order
						.getDiscount_method());
				merchantorderdetails.setDiscount_amount(""
						+ order.getDiscount_amount());
				merchantorderdetails.setCoupan_code(order.getCoupan_code());
				merchantorderdetails.setDelivery_ship_id(order
						.getDelivery_ship_id());
				merchantorderdetails.setDelivery_agent_name(order
						.getDelivery_agent_name());

				list.add(merchantorderdetails);

			}
			status.setStatus("success");
			status.setMerchantorderdetails(list);
		} else {
			status.setStatus("failure");
			status.setMerchantorderdetails(list);
		}

		return status;

	}

	public MerchantPriceStatus merchantPriceEdit(String merchant_id,
			String deal_id, String deal_price) {
		MerchantPriceStatus status = new MerchantPriceStatus();

		try {

			dealDao.editMerchantPrice(merchant_id, deal_id, deal_price);

			status.setStatus("success");
			status.setMerchantpricestatus("successfully edited");
		} catch (Exception e) {
			e.printStackTrace();
			status.setStatus("fails");
			status.setMerchantpricestatus("successfully not edited");

		}

		return status;

	}

	public MerchantPasswordStatus updateMerchantPassword(String username,
			String newPassword) {
		MerchantPasswordStatus status = new MerchantPasswordStatus();
		try {

			merchantBranchDao.editMerchantPassword(username, newPassword);

			status.setStatus("success");
			status.setMerchant_password_status("Merchant Password successfully edited");

		} catch (Exception e) {
			e.printStackTrace();
			status.setStatus("fails");
			status.setMerchant_password_status("Merchant Password successfully not edited");

		}

		return status;

	}

	// /******************check discount coupon code****************//

	public CheckDiscountCodeResponseVO getCheckDiscountCode(String coupanCode,
			int merchantbranch_id, double total_order_value, long user_id) {
		CheckDiscountCodeResponseVO checkDiscountCodeResponseVO = new CheckDiscountCodeResponseVO();
		GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
		String systemdate = "" + getDateFromSystem.getDateFromSystem();
		DiscountCoupon checkType = discountCouponDao
				.getCheckDiscountCodeType(coupanCode);
		// single time check coupon code started
		CheckAvailabilityDate checkAvailabilityDate = new CheckAvailabilityDate();
		CalculateDifferenceInDays calculateDifferenceInDays = new CalculateDifferenceInDays();
		if (checkType.getCoupon_type() == 1) {
			DiscountCoupon coupon = discountCouponDao
					.getCheckDiscountCodeForMerchant(coupanCode);
			NewOrderDetails orderdiscountcheck = newOrdersDetails
					.getCheckDiscountCodeForUser(coupanCode, user_id);
			if (orderdiscountcheck == null) {
				// checking for selected merchant coupon code
				if (coupon.getMerchant_id() > 0) {
					DiscountCoupon coupon_id = discountCouponDao
							.getCouponCodeId(coupanCode);
					List<KitchenCoupon> kitchen_coupon_id = kitchenCouponDao
							.getAllMerchantbranch_id_from_kichenCoupon(coupon_id
									.getId());
					if (kitchen_coupon_id == null
							|| kitchen_coupon_id.size() > 0) {
						if (coupon.getMin_order_value() < total_order_value) {
							boolean isOutletCoupon = false;
							for (KitchenCoupon kitchenCoupon : kitchen_coupon_id) {
								if (kitchenCoupon.getMerchantbranch_id() == merchantbranch_id) {
									isOutletCoupon = true;
									break;
								} else {
									isOutletCoupon = false;
								}
							}
							if (!isOutletCoupon) {
								checkDiscountCodeResponseVO
										.setError("Your coupon code is not valid for this restaurant.");
							} else if (calculateDifferenceInDays
									.checkAvailability(systemdate,
											coupon.getEnd_date())) {
								checkDiscountCodeResponseVO = new CheckDiscountCodeResponseVO();
								checkDiscountCodeResponseVO
										.setStatus("success");
								checkDiscountCodeResponseVO
										.setCoupon_code(coupon.getCoupon_code());
								checkDiscountCodeResponseVO.setError(null);
								checkDiscountCodeResponseVO
										.setPercentage(coupon.getPercentage());
								checkDiscountCodeResponseVO.setMax_value(coupon
										.getMax_value());
								checkDiscountCodeResponseVO
										.setStart_date(coupon.getStart_date());
								checkDiscountCodeResponseVO.setEnd_date(coupon
										.getEnd_date());
								checkDiscountCodeResponseVO.setCity(coupon
										.getCity());
								checkDiscountCodeResponseVO
										.setMin_order_value(coupon
												.getMin_order_value());
								checkDiscountCodeResponseVO
										.setMerchantbranch_id(coupon
												.getMerchantbranch_id());
								checkDiscountCodeResponseVO.setUsage(coupon
										.getUsages());
								checkDiscountCodeResponseVO.setMax_usage(coupon
										.getMax_usage());
								return checkDiscountCodeResponseVO;
							} else {
								checkDiscountCodeResponseVO
										.setError("Your Coupon Code is Expired.");
							}

						} else {
							checkDiscountCodeResponseVO
									.setError("You have to order for minimum "
											+ coupon.getMin_order_value()
											+ " value to use this coupon.");

						}
						try {
							discountCouponDao.increamentUsageValue(
									coupon.getUsages(), coupon.getId());
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
				// check coupon code for merchant code is closed
				// start for hungrybells single type
				else {

					DiscountCoupon coupon1 = discountCouponDao
							.getCheckDiscountCode(coupanCode);
					if (coupon1 != null
							&& coupon1.getMin_order_value() < total_order_value) {
						if (calculateDifferenceInDays.checkAvailability(
								systemdate, coupon1.getEnd_date())) {
							System.out.println("Second");
							checkDiscountCodeResponseVO.setStatus("success");
							checkDiscountCodeResponseVO.setCoupon_code(coupon1
									.getCoupon_code());
							checkDiscountCodeResponseVO.setPercentage(coupon1
									.getPercentage());
							checkDiscountCodeResponseVO.setMax_value(coupon1
									.getMax_value());
							checkDiscountCodeResponseVO.setStart_date(coupon1
									.getStart_date());
							checkDiscountCodeResponseVO.setEnd_date(coupon1
									.getEnd_date());
							checkDiscountCodeResponseVO.setCity(coupon1
									.getCity());
							checkDiscountCodeResponseVO
									.setMin_order_value(coupon1
											.getMin_order_value());
							checkDiscountCodeResponseVO
									.setMerchantbranch_id(coupon1
											.getMerchantbranch_id());
							checkDiscountCodeResponseVO.setUsage(coupon1
									.getUsages());
							checkDiscountCodeResponseVO.setMax_usage(coupon1
									.getMax_usage());
						} else {
							checkDiscountCodeResponseVO
									.setError("Your Coupon Code is Expired.");
						}
						try {
							discountCouponDao.increamentUsageValue(
									coupon1.getUsages(), coupon1.getId());
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						checkDiscountCodeResponseVO
								.setError("You have to order for minimum "
										+ coupon1.getMin_order_value()
										+ " value to use this coupon.");
					}
				}

			} else {
				checkDiscountCodeResponseVO
						.setError("You have already used this coupon code.");
			}
		}
		// ***********closed coupon code stopped.....//
		// ***********limited coupon code started.....//
		else if (checkType.getCoupon_type() == 2) {
			DiscountCoupon couponLimted = discountCouponDao
					.getCheckDiscountCodeLimited(coupanCode);
			if (couponLimted.getMerchant_id() > 0) {// start limited checking
													// for merchant coupon code
				DiscountCoupon coupon_id = discountCouponDao
						.getCouponCodeId(coupanCode);
				List<KitchenCoupon> kitchen_coupon_id = kitchenCouponDao
						.getAllMerchantbranch_id_from_kichenCoupon(coupon_id
								.getId());
				if (kitchen_coupon_id == null || kitchen_coupon_id.size() > 0) {
					if (couponLimted.getMin_order_value() < total_order_value) {
						boolean isOutletCoupon = false;
						for (KitchenCoupon kitchenCoupon : kitchen_coupon_id) {
							if (kitchenCoupon.getMerchantbranch_id() == merchantbranch_id) {
								isOutletCoupon = true;
								break;
							} else {
								isOutletCoupon = false;
							}
						}
						if (!isOutletCoupon) {
							checkDiscountCodeResponseVO
									.setError("Your coupon code is not valid for this restaurant.");
						} else if (calculateDifferenceInDays.checkAvailability(
								systemdate, couponLimted.getEnd_date())) {
							checkDiscountCodeResponseVO = new CheckDiscountCodeResponseVO();
							checkDiscountCodeResponseVO.setStatus("success");
							checkDiscountCodeResponseVO
									.setCoupon_code(couponLimted
											.getCoupon_code());
							checkDiscountCodeResponseVO.setError(null);
							checkDiscountCodeResponseVO
									.setPercentage(couponLimted.getPercentage());
							checkDiscountCodeResponseVO
									.setMax_value(couponLimted.getMax_value());
							checkDiscountCodeResponseVO
									.setStart_date(couponLimted.getStart_date());
							checkDiscountCodeResponseVO
									.setEnd_date(couponLimted.getEnd_date());
							checkDiscountCodeResponseVO.setCity(couponLimted
									.getCity());
							checkDiscountCodeResponseVO
									.setMin_order_value(couponLimted
											.getMin_order_value());
							checkDiscountCodeResponseVO
									.setMerchantbranch_id(couponLimted
											.getMerchantbranch_id());
							checkDiscountCodeResponseVO.setUsage(couponLimted
									.getUsages());
							checkDiscountCodeResponseVO
									.setMax_usage(couponLimted.getMax_usage());
							return checkDiscountCodeResponseVO;
						} else {
							checkDiscountCodeResponseVO
									.setError("Your Coupon Code is Expired.");
						}

					} else {
						checkDiscountCodeResponseVO
								.setError("You have to order for minimum "
										+ couponLimted.getMin_order_value()
										+ " value to use this coupon.");

					}
					try {
						discountCouponDao.increamentUsageValue(
								couponLimted.getUsages(), couponLimted.getId());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				// close limited checking for merchant coupon code
			} else if (couponLimted != null
					&& couponLimted.getMin_order_value() <= total_order_value
					&& couponLimted.getUsages() < couponLimted.getMax_usage()) {
				if (calculateDifferenceInDays.checkAvailability(systemdate,
						couponLimted.getEnd_date())) {
					checkDiscountCodeResponseVO.setStatus("success");
					checkDiscountCodeResponseVO.setCoupon_code(couponLimted
							.getCoupon_code());
					checkDiscountCodeResponseVO.setPercentage(couponLimted
							.getPercentage());
					checkDiscountCodeResponseVO.setMax_value(couponLimted
							.getMax_value());
					checkDiscountCodeResponseVO.setStart_date(couponLimted
							.getStart_date());
					checkDiscountCodeResponseVO.setEnd_date(couponLimted
							.getEnd_date());
					checkDiscountCodeResponseVO.setCity(couponLimted.getCity());
					checkDiscountCodeResponseVO.setMin_order_value(couponLimted
							.getMin_order_value());
					checkDiscountCodeResponseVO
							.setMerchantbranch_id(couponLimted
									.getMerchantbranch_id());
					checkDiscountCodeResponseVO.setUsage(couponLimted
							.getUsages());
					checkDiscountCodeResponseVO.setMax_usage(couponLimted
							.getMax_usage());
				} else {
					checkDiscountCodeResponseVO
							.setError("Your Coupon Code is Expired.");

				}
				try {
					discountCouponDao.increamentUsageValue(
							couponLimted.getUsages(), couponLimted.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				checkDiscountCodeResponseVO
						.setError("You have order for minimum "
								+ couponLimted.getMin_order_value()
								+ " value to use this coupon.");
			}
		}

		// **********unlimited coupon code started...........*/
		else if (checkType.getCoupon_type() == 3) {

			DiscountCoupon couponUnLimted = discountCouponDao
					.getCheckDiscountCodeUnLimited(coupanCode);
			if (couponUnLimted.getMerchant_id() > 0) {
				// start limited checking for merchant coupon code
				DiscountCoupon coupon_id = discountCouponDao
						.getCouponCodeId(coupanCode);
				List<KitchenCoupon> kitchen_coupon_id = kitchenCouponDao
						.getAllMerchantbranch_id_from_kichenCoupon(coupon_id
								.getId());
				if (kitchen_coupon_id == null || kitchen_coupon_id.size() > 0) {
					if (couponUnLimted.getMin_order_value() < total_order_value) {
						boolean isOutletCoupon = false;
						for (KitchenCoupon kitchenCoupon : kitchen_coupon_id) {
							if (kitchenCoupon.getMerchantbranch_id() == merchantbranch_id) {
								isOutletCoupon = true;
								break;
							} else {
								isOutletCoupon = false;
							}
						}
						if (!isOutletCoupon) {
							checkDiscountCodeResponseVO
									.setError("Your coupon code is not valid for this restaurant.");
						} else if (calculateDifferenceInDays.checkAvailability(
								systemdate, couponUnLimted.getEnd_date())) {
							checkDiscountCodeResponseVO = new CheckDiscountCodeResponseVO();
							checkDiscountCodeResponseVO.setStatus("success");
							checkDiscountCodeResponseVO
									.setCoupon_code(couponUnLimted
											.getCoupon_code());
							checkDiscountCodeResponseVO.setError(null);
							checkDiscountCodeResponseVO
									.setPercentage(couponUnLimted
											.getPercentage());
							checkDiscountCodeResponseVO
									.setMax_value(couponUnLimted.getMax_value());
							checkDiscountCodeResponseVO
									.setStart_date(couponUnLimted
											.getStart_date());
							checkDiscountCodeResponseVO
									.setEnd_date(couponUnLimted.getEnd_date());
							checkDiscountCodeResponseVO.setCity(couponUnLimted
									.getCity());
							checkDiscountCodeResponseVO
									.setMin_order_value(couponUnLimted
											.getMin_order_value());
							checkDiscountCodeResponseVO
									.setMerchantbranch_id(couponUnLimted
											.getMerchantbranch_id());
							checkDiscountCodeResponseVO.setUsage(couponUnLimted
									.getUsages());
							checkDiscountCodeResponseVO
									.setMax_usage(couponUnLimted.getMax_usage());
							return checkDiscountCodeResponseVO;
						} else {
							checkDiscountCodeResponseVO
									.setError("Your Coupon Code is Expired.");
						}
					} else {
						checkDiscountCodeResponseVO
								.setError("You have to order for minimum "
										+ couponUnLimted.getMin_order_value()
										+ " value to use this coupon.");
					}
					try {
						discountCouponDao.increamentUsageValue(
								couponUnLimted.getUsages(),
								couponUnLimted.getId());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// close limited checking for merchant coupon code
			} else if (couponUnLimted != null
					&& couponUnLimted.getMin_order_value() <= total_order_value) {
				if (calculateDifferenceInDays.checkAvailability(systemdate,
						couponUnLimted.getEnd_date())) {
					checkDiscountCodeResponseVO.setStatus("success");
					checkDiscountCodeResponseVO.setCoupon_code(couponUnLimted
							.getCoupon_code());
					checkDiscountCodeResponseVO.setPercentage(couponUnLimted
							.getPercentage());
					checkDiscountCodeResponseVO.setMax_value(couponUnLimted
							.getMax_value());
					checkDiscountCodeResponseVO.setStart_date(couponUnLimted
							.getStart_date());
					checkDiscountCodeResponseVO.setEnd_date(couponUnLimted
							.getEnd_date());
					checkDiscountCodeResponseVO.setCity(couponUnLimted
							.getCity());
					checkDiscountCodeResponseVO
							.setMin_order_value(couponUnLimted
									.getMin_order_value());
					checkDiscountCodeResponseVO
							.setMerchantbranch_id(couponUnLimted
									.getMerchantbranch_id());
					checkDiscountCodeResponseVO.setUsage(couponUnLimted
							.getUsages());
					checkDiscountCodeResponseVO.setMax_usage(couponUnLimted
							.getMax_usage());
				} else {
					checkDiscountCodeResponseVO
							.setError("Your Coupon Code is Expired.");
				}
				try {
					discountCouponDao.increamentUsageValue(
							couponUnLimted.getUsages(), couponUnLimted.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				checkDiscountCodeResponseVO
						.setError("You have order for minimum "
								+ couponUnLimted.getMin_order_value()
								+ " value to use this coupon.");
			}
		}
		return checkDiscountCodeResponseVO;
	}

	
	// get Address Current Location and Merchant Location ..
	public CheckDistanceResponseVO getDistanceDetails(String latitude,String longitude, String merchantbranch_id,String userId) {
		CheckDistanceResponseVO status = new CheckDistanceResponseVO();
		try {
			if (latitude != null && longitude != null) {
				MerchantBranch fetch_Lot_long = merchantBranchDao.getCheckDiscountCodeForMerchant(merchantbranch_id);
				GetAddressGoogleApi getAddressGoogleApi = new GetAddressGoogleApi();
				if (fetch_Lot_long != null) {
					fetch_Lot_long.getLongitude();
					try {
						String jsonAddress = getAddressGoogleApi.getAddress(latitude, longitude,"" + fetch_Lot_long.getLattitue(), ""+ fetch_Lot_long.getLongitude());
						CheckDistanceResponseVO json_all_address = null;
						ObjectMapper mapper = new ObjectMapper();
						json_all_address = mapper.readValue(jsonAddress,CheckDistanceResponseVO.class);
						double distance = json_all_address.getRows()[0].getElements()[0].getDistance().getValue();
						Setting setting=settingDao.getDeails();
						Double km=0D;
						if(setting!=null)
							km=(Double.parseDouble(""+setting.getDelivery_distance()))*1000;
						if (distance > km) {
							status.setStatus("failue");
						} else {
							status.setStatus("success");
							status.setDestination_addresses(json_all_address.getOrigin_addresses());
							status.setOrigin_addresses(json_all_address.getOrigin_addresses());
							status.setRows(json_all_address.getRows());
						 	
							if (setting != null) {
								status.setDeliveryCharge(""+ setting.getDelivery_charges());
								status.setFree_delivery_minimum_order_value(setting.getFree_delivery_minimum_order_value());
							}
							int orderCounts=getOrderCount(Long.parseLong(userId));
							if(orderCounts>0){
								RepeatDiscount repeatDiscount = repeatDiscountDao.getRepeatDiscount(orderCounts+1);
								if(repeatDiscount!=null)
								{
								status.setType(repeatDiscount.getType()+"");
								status.setValue(repeatDiscount.getValue()+"");
								status.setMessage(repeatDiscount.getCustome_message());
								status.setMaximumDiscountValue(repeatDiscount.getMaximum_discount_value());
								status.setMinimumOrderValue(repeatDiscount.getManimum_order_value());
								}
							}
							User userDetails = userDao.getUserDetails(Long.parseLong(userId));
							if (userDetails != null) {
								status.setUserName(userDetails.getFirst_name());
								status.setUserEmail(userDetails.getEmail());
								status.setUserMob(userDetails.getMobile_number());
							}
							status.setHbMoneyMaxLimit("300");
							String lastOrderLandmark = newOrdersDetails.getLastOrderLandmark(Long.parseLong(userId));
							if (lastOrderLandmark != null) {
								status.setCustomerAddressLandMark(lastOrderLandmark);
							}
			
						}
					} catch (Exception ek) {
						ek.printStackTrace();
					}
				}
			} else {
				status.setStatus("failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	// ..........
	/* ....Call Google Api For Address... */
	/* ....Service for my order details... */
	public MyOrderStatus myOrders(long user_id) {
		MyOrderStatus status = new MyOrderStatus();
		List<Myorderdetails> list = new ArrayList<Myorderdetails>();
		List<Orders> order_list = new ArrayList<Orders>();
		List<NewOrderDetails> orders = newOrdersDetails.myOrders(user_id);
		if (orders != null) {
			for (NewOrderDetails order : orders) {
				Myorderdetails merchantorderdetails = new Myorderdetails();
				Body body = new Body();
				body.setUser_id("" + order.getUser_id());
				body.setAddress(order.getDelivery_address());
				body.setLandmark(order.getLandmark());
				body.setOrder_type(order.getOrder_type());
				body.setOrder_amount("" + order.getOrder_amount());
				body.setDiscount_amount("" + order.getDiscount_amount());
				body.setDiscount_method(order.getDiscount_method());
				body.setCoupon_code(order.getCoupan_code());
				body.setLatitude("" + order.getLatitude());
				body.setLongitude("" + order.getLongitude());
				body.setDelivery_status(order.getDelivery_status());
				// getOrdersDeatils
				List<DealOrders> orderListFromDB = ordersDao.getOrder(order.getOrder_id());
				com.hungrybell.app.vo.response.Orders dealOrdersArray[] = new com.hungrybell.app.vo.response.Orders[orderListFromDB
						.size()];
				int i = 0;
				if (orderListFromDB != null) {
					for (DealOrders dealOrders : orderListFromDB) {
						com.hungrybell.app.vo.response.Orders orders1 = new com.hungrybell.app.vo.response.Orders();
						orders1.setDeal_id(dealOrders.getDeal_id());
						orders1.setQuantity(dealOrders.getQuantity());
						orders1.setAmount(dealOrders.getAmount());
						if (orders1 != null) {
							dealOrdersArray[i++] = orders1;
						}
					}
				}
				// getUserDetails
				User getUserDetails = userDao
						.getUserDetails(order.getUser_id());
				if (getUserDetails != null) {
					body.setFirst_name(getUserDetails.getFirst_name());
					body.setEmail(getUserDetails.getEmail());
					body.setMobile_number(getUserDetails.getMobile_number());

				}
				body.setOrders(dealOrdersArray);
				merchantorderdetails.setBody(body);
				list.add(merchantorderdetails);
			}
			status.setStatus("success");
			status.setMyorderdetails(list);
		} else {
			status.setStatus("failure");
			status.setMyorderdetails(list);
		}
		return status;
	}

	public Status getDeliveryTrackingStatus(String shipment_id,
			String townrush_shipment_id, String status, String name,
			String mobileno) {
		Status statusresponse = new Status();
		try {
			orderDeatilDao.updateDeliveryTracking(shipment_id,
					townrush_shipment_id, status, name, mobileno);

			statusresponse.setCode(1);
			statusresponse.setMessage("Successfully Updated Delivery Status");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusresponse;
	}

	public Status getDeliveryTrackingRoadRunnrStatus(String order_id,
			String status, String driver_name, String driver_number,
			String timestamp) {
		Status statusresponse = new Status();
		try {
			String customer_mob_no = null, order_id_our = null;
			SpearSMSUtility smsUtility = new SpearSMSUtility();
			NewOrderDetails user_id = newOrdersDetails
					.getUserIdFormNeworderDetails(order_id);
			if (user_id != null) {
				order_id_our = user_id.getOrder_id();
				User userdetails = userDao.getUserDetails(user_id.getUser_id());
				if (userdetails != null) {
					customer_mob_no = userdetails.getMobile_number();
					String smstemplatefortracking = "Status of your order delivery - "
							+ status
							+ " Delivery boy "
							+ driver_name
							+ " Contact Number "
							+ driver_number
							+ " Hungry Bells.";
					smsUtility.process_sms(customer_mob_no,
							smstemplatefortracking, "", "", "");
				}
			}
			orderDeatilDao.updateDeliveryTrackingRaodRunnr(order_id, status,
					driver_name, driver_number);
			statusresponse.setCode(1);
			statusresponse.setMessage("Successfully Updated Delivery Status");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusresponse;

	}

	public List<String> getNewPayDetails() {
		ArrayList<String> newPaymentDetails = new ArrayList<String>();
		List<NewOrderDetails> iniciatedDetails = newOrdersDetails
				.getIniciatedTxnidID();
		if (iniciatedDetails != null) {
			for (NewOrderDetails iniciatePAYU : iniciatedDetails) {
				newPaymentDetails.add(iniciatePAYU.getOrder_id());
			}
		}
		return newPaymentDetails;
	}

	public List<String> getNewOrderDetails() {
		ArrayList<String> newOrderIdDetails = new ArrayList<String>();
		List<NewPayment> iniciatedDetails = paymentDao.getIniciatedTxnidID();
		if (iniciatedDetails != null) {
			for (NewPayment iniciatePAYU : iniciatedDetails) {
				newOrderIdDetails.add(iniciatePAYU.getTxnid());
			}
		}
		return newOrderIdDetails;
	}

	public String updateIniciatedDataOfPayu(Result[] initiatedResultOfPayu) {
		paymentDao.updateIniciatedDataOfPayu(initiatedResultOfPayu);
		return "all iniciated data updated of Paysetled";
	}

	public ResetPasswrdStatus resetPassword(String user_email) {
		ResetPasswrdStatus resetPassword = new ResetPasswrdStatus();
		try {

			GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
			String date_time = "" + getDateFromSystem.getDateFromSystem();
			String confirm_pass = user_email.substring(0, 2) + "hb"
					+ date_time.substring(5, 7) + "ge";
			HungryBellsSecretKey hungryBellsSecretKey = new HungryBellsSecretKey();
			String encryptconfirm_pass = hungryBellsSecretKey
					.encrypt(confirm_pass);
			EmailUtilityForAdmin emailUtility = new EmailUtilityForAdmin();

			emailUtility.emailSendForAdmin(user_email, confirm_pass);
			userDao.resetPassword(user_email, encryptconfirm_pass);
			resetPassword.setStatus("success");
		} catch (Exception ek) {
			resetPassword.setStatus("failure");
		}

		return resetPassword;
	}

	public AdminLoginStatus checkAdminLoginPanel(String user_email,
			String confirm_pass) {
		AdminLoginStatus adminloginstatus = new AdminLoginStatus();
		try {
			HungryBellsSecretKey hungryBellsSecretKey = new HungryBellsSecretKey();
			String encryptconfirm_pass = hungryBellsSecretKey
					.encrypt(confirm_pass);
			User adminCheck = userDao.checkAdminLoginPanel(user_email,
					encryptconfirm_pass);
			if (adminCheck != null) {
				adminloginstatus.setStatus("success");
				adminloginstatus.setEmail(adminCheck.getUsername());
				;
			} else {
				adminloginstatus.setStatus("failure");
			}

		} catch (Exception ek) {
			adminloginstatus.setStatus("failure");
		}
		return adminloginstatus;
	}

	public HomePageFavTagResponseVO getAllHomePageDataForFavTag(
			String latitude, String longitude, String user_id) {
		ArrayList<FavTagVo> favTagList = new ArrayList<FavTagVo>();
		HomePageFavTagResponseVO homePageResponseVo = new HomePageFavTagResponseVO();
		List<FavTagVo> favouritesTags = new ArrayList<FavTagVo>();
		FavTagVo favTag = null;
		List<FavTagVo> tagsListr = null;
		List<Deal> user_tag_names = null;
		HomePageResponseVO homePageResponseVo1 = null;
		String locationStr = getLocation(latitude, longitude);
		try {
			ArrayList<String> allTagsInLocation = new ArrayList<String>();
			List<NewOrderDetails> orderIds = newOrdersDetails
					.getAllOrdersId(user_id);
			if (orderIds != null && orderIds.size() > 0) {
				for (NewOrderDetails newOrderDetails : orderIds) {
					List<DealOrders> dealnames = ordersDao
							.getAllOrdersIdForDealName(newOrderDetails
									.getOrder_id());
					if (dealnames != null && dealnames.size() > 0) {
						for (DealOrders dealOrders : dealnames) {
							user_tag_names = new ArrayList<Deal>();
							user_tag_names = dealDao
									.getAllTagForUser(dealOrders.getDeal_id());
							tagsListr = new ArrayList<FavTagVo>();
							tagsListr = prepareFavTagVO(user_tag_names);
							for (int i = 0; i < tagsListr.size(); i++) {
								if (!exists(favTagList, tagsListr.get(i)))
									favTagList.add(tagsListr.get(i));
							}
						}

						Location location1 = locationDao
								.getLocation(locationStr);
						trendingtag = trendingTagDao.getAllTag(
								location1.getName(), 0);
						recomendedtag = recommendedTagDao.getAllTagRecom(
								location1.getName(), 0);
						List<String> recommendedTagNames = new<String> ArrayList();
						if (recomendedtag != null) {
							for (RecommendedTag recomTag : recomendedtag) {
								recommendedTagNames
										.add(recomTag.getTagName_of_location()
												.toLowerCase());
								System.out.println("recomended : "
										+ recomTag.getTagName_of_location());
							}
						}

						List<String> trendingTagNames = new<String> ArrayList();
						if (trendingtag != null) {
							for (TrendingTag trendingTag : trendingtag) {
								trendingTagNames
										.add(trendingTag
												.getTagName_of_location()
												.toLowerCase());
								System.out.println("trending : "
										+ trendingTag.getTagName_of_location());
							}
						}

						allTagsInLocation.addAll(recommendedTagNames);

						// Remove duplicates & add
						allTagsInLocation.removeAll(trendingTagNames);
						allTagsInLocation.addAll(trendingTagNames);

						for (int i = 0; i < favTagList.size(); i++) {
							FavTagVo favouriteTag = (FavTagVo) favTagList
									.get(i);
							String favTagName = favouriteTag.getTag_name()
									.toLowerCase();
							if (!allTagsInLocation.contains(favTagName)) {
								favTagList.remove(i--);
							}
						}
					}
				}

				for (int i = 0; i < favTagList.size(); i++) {
					System.out.println("Favourite:"
							+ favTagList.get(i).getTag_name());
				}

				// this logic for filter data for Favourites tags
				if (favTagList.size() > 0) {
					homePageResponseVo.setFavourites(favTagList);
					return homePageResponseVo;
				}
			}
			// /////////////////nearest location tags
			if (favTagList.size() == 0 || allTagsInLocation.size() == 0) {
				orderIds = newOrdersDetails.getAllOrdersId(user_id);
				if (orderIds != null) {
					for (NewOrderDetails newOrderDetails : orderIds) {
						homePageResponseVo = new HomePageFavTagResponseVO();

						// favTagList =new ArrayList<FavTagVo>();
						List<DealOrders> dealnames = ordersDao
								.getAllOrdersIdForDealName(newOrderDetails
										.getOrder_id());
						if (dealnames != null) {
							for (DealOrders dealOrders : dealnames) {
								user_tag_names = new ArrayList<Deal>();
								user_tag_names = dealDao
										.getAllTagForUser(dealOrders
												.getDeal_id());

								tagsListr = new ArrayList<FavTagVo>();
								tagsListr = prepareFavTagVO(user_tag_names);
								for (int i = 0; i < tagsListr.size(); i++) {
									if (!exists(favTagList, tagsListr.get(i)))
										favTagList.add(tagsListr.get(i));
								}
							}
							List<MerchantBranch> mb = merchantBranchDao
									.getMerchantBranchForNearestLocationList();
							Iterator iterator = null;
							List<Long> branchidList = new ArrayList<Long>();
							for (iterator = mb.iterator(); iterator.hasNext();) {
								MerchantBranch mbo = (MerchantBranch) iterator
										.next();
								try {
									double kmDealTag = getNearestLocationDistance(
											latitude, longitude, mbo.lattitue,
											mbo.longitude);
									if (kmDealTag <= 3.5) {
										branchidList.add(mbo.getId());
									}
								} catch (Exception ek1) {
									ek1.printStackTrace();
								}
							}
							List<Deal> dealsListTotal = dealDao
									.getAllDealsForLocation(branchidList);
							List<Deal> dealsList = dealDao
									.getNearestAllDealsForBranchIds(branchidList);
							List<Deal> recoDealsList = dealDao
									.getAllRecommendedDealsForLocation(branchidList);
							homePageResponseVo1 = new HomePageResponseVO();
							homePageResponseVo1 = prepareHomePageVO(null,
									recoDealsList, null,
									"" + dealsListTotal.size(), null, null,
									dealsList, null);

							List<TagVO> nearByRecommendedTags = homePageResponseVo1
									.getResult().getRecomended();
							List<TagVO> nearByTrendingTags = homePageResponseVo1
									.getResult().getTrending();

							// Remove duplicates & add
							List<String> allTagsInNearByLocation = new ArrayList<String>();

							System.out.println("Recommended:");
							if (nearByRecommendedTags != null)
								for (int i = 0; i < nearByRecommendedTags
										.size(); i++) {
									allTagsInNearByLocation
											.add(nearByRecommendedTags.get(i)
													.getTag_name()
													.toLowerCase().trim());
									System.out.println(nearByRecommendedTags
											.get(i).getTag_name().toLowerCase()
											.trim());
								}

							System.out.println("Trending");

							List<String> tempTagList = new ArrayList<String>();
							if (nearByTrendingTags != null)
								for (int i = 0; i < nearByTrendingTags.size(); i++) {
									tempTagList
											.add(nearByTrendingTags.get(i)
													.getTag_name()
													.toLowerCase().trim());
									System.out.println(nearByTrendingTags
											.get(i).getTag_name().toLowerCase()
											.trim());
								}

							// Remove duplicates & add trending tags
							allTagsInNearByLocation.removeAll(tempTagList);
							allTagsInNearByLocation.addAll(tempTagList);
							System.out.println("Favourite before checking:");
							for (int i = 0; i < favTagList.size(); i++) {
								System.out.println(favTagList.get(i)
										.getTag_name().toLowerCase().trim());
							}

							for (int i = 0; i < favTagList.size(); i++) {
								FavTagVo favouriteTag = (FavTagVo) favTagList
										.get(i);
								String favTagName = favouriteTag.getTag_name()
										.toLowerCase().trim();
								if (!allTagsInNearByLocation
										.contains(favTagName)) {
									System.out.println("Not found: nearest"
											+ favTagName);
									favTagList.remove(i--);
								}
							}
							homePageResponseVo.setFavourites(favTagList);
						}
					}
				}
			}
		} catch (Exception ek) {
			ek.printStackTrace();
		}

		for (int i = 0; i < favTagList.size(); i++) {
			System.out.println("Favourite:" + favTagList.get(0).getTag_name());
		}

		return homePageResponseVo;
	}

	private List<FavTagVo> prepareFavTagVO(List<Deal> favtag) {
		List<FavTagVo> tagsList = new ArrayList<FavTagVo>();

		if (favtag != null) {
			HashMap<String, String> nearest = new HashMap();
			for (Iterator iterator = favtag.iterator(); iterator.hasNext();) {
				Deal deal = (Deal) iterator.next();
				String[] dealsTag = deal.getTag().split(",");
				// System.out.println(dealsTag);
				for (int i = 0; i < dealsTag.length; i++) {
					if (nearest.get(dealsTag[i]) == null) {
						nearest.put(dealsTag[i], dealsTag[i]);
					}
				}
			}
			Set keys = nearest.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				String tagName = (String) iterator.next();
				String tagId = nearest.get(tagName);
				if (!tagName.trim().isEmpty()) {
					FavTagVo tagVO = new FavTagVo();
					tagVO.setDeal_id(tagName.trim());
					tagVO.setTag_name(tagName.trim());
					tagsList.add(tagVO);
				}
			}
		}

		return tagsList;
	}

	private boolean exists(ArrayList<FavTagVo> favTagList, FavTagVo tagVO) {
		for (FavTagVo favTags : favTagList) {
			FavTagVo favouriteTag = favTags;
			if (favouriteTag.getTag_name().toLowerCase()
					.equals(tagVO.getTag_name().toLowerCase()))
				return true;
		}
		return false;
	}

	public User createNewUser(String deviceId, String email,String branchId) {
		return userDao.saveUser(deviceId, email,branchId);
	}

	public boolean updateUserEmail(long userId, String email) {
		userDao.updateEmail(userId, email);
		return true;
	}

	public boolean updateUserDevice(Long userId, String deviceId) {
		userDao.updateDevice(userId, deviceId);
		return true;
	}
	
	
	//user gamification logic
/*	
 public UserGemificationStatus	userGamificationDetails(long cust_id)
 {
	UserGemificationStatus userGemificationStatus=new UserGemificationStatus();
	List<NewOrderDetails> user_order_count = newOrdersDetails.getUserOrderCount(cust_id);
	if(user_order_count!=null){				
	if (!userGamificationDao.userExists(cust_id)) {
		userGamificationDao.saveUserOrderCount(user_order_count.size(), cust_id);
		userGemificationStatus.setStatus("success");
	}
	else{
		userGamificationDao.updateUserOrderCount(user_order_count.size(), cust_id);
		userGemificationStatus.setStatus("success");
	}
	}
	return userGemificationStatus;
	
 }
*/

	public int getOrderCount(long userId){
		List<NewOrderDetails> user_order_count = newOrdersDetails.getUserOrderCount(userId);
		if(user_order_count!=null)
		{
			return user_order_count.size();
		}
		return 0;
	}
	
	public UserDetailsResponseVo getUserDetails(String userid)
	{
		UserDetailsResponseVo userDetailsResponseVo = new UserDetailsResponseVo();
		User userDetails = userDao.getUserDetails(Long.parseLong(userid));
		if (userDetails != null) {
			userDetailsResponseVo.setUserId("" + userDetails.getId());
			userDetailsResponseVo.setUserName(userDetails.getFirst_name());
			userDetailsResponseVo.setUserEmail(userDetails.getEmail());
			userDetailsResponseVo.setUser_Mob_No(userDetails.getMobile_number());
			userDetailsResponseVo.setDeviceId(userDetails.getDevice_id());
			userDetailsResponseVo.setBranchId(userDetails.getBranch_id());
			NewOrderDetails lastOrder = newOrdersDetails.getLastOrderAddress(Long.parseLong(userid));
			if (lastOrder != null) {
				userDetailsResponseVo.setUserAddress(lastOrder.getDelivery_address());
				userDetailsResponseVo.setLatitude("" + lastOrder.getLatitude());
				userDetailsResponseVo.setLongitude("" + lastOrder.getLongitude());
			}

		}
		return userDetailsResponseVo;
	}
	
	public UpdateUserDetailsResponseVo getUpdateUserDetails(String userid,String userName,String userEmail,String mobileNo,String deviceId,String branchid,String address,String latitude,String longitude)
	{
		UpdateUserDetailsResponseVo updateUserDetailsResponseVo = new UpdateUserDetailsResponseVo();
		try {
			userDao.updateUserDetails(userid, userName, userEmail, mobileNo);
			updateUserDetailsResponseVo.setStatus("success");
		} catch (Exception el) {
			updateUserDetailsResponseVo.setStatus("failure");
		}
	
		return updateUserDetailsResponseVo;
	}

 
	
}
