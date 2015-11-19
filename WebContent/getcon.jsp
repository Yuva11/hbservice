<%@page import="com.hungrybell.app.propertyload.DataGetFromProperty2"%>
<%@ page import="java.sql.*" %>
<%!
Connection con=null;
  PreparedStatement ps=null;
  String kk=null;
    String secondsoft=null;
    String title=null;
%>
<%

DataGetFromProperty2 dataproperty=new DataGetFromProperty2();
dataproperty.getPropValues();
String className=dataproperty.className;
String urlName=dataproperty.urlName;
String user=dataproperty.user;
String pass=dataproperty.pass;

Class.forName(className);
con=DriverManager.getConnection(urlName,user,pass);
 
%>