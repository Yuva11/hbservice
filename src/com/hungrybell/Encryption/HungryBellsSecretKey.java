package com.hungrybell.Encryption;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class HungryBellsSecretKey {
static Cipher cipher;
public static void main(String[] args)throws Exception {
 String plainText="bheem1992";
 String enc="";
 enc=encrypt(plainText);
 System.out.println("Before Encrypt -: "+plainText);
 System.out.println("After Encrypt -: "+enc);
 System.out.println("After Decrypt - : "+decrypt(enc));
}
public static String encrypt(String plainText) throws Exception 
{
 String encryptedText="";
 if(plainText != null)
 {  
 byte[] plainTextByte = plainText.getBytes();
 Key key=getSecretKey();
 cipher.init(Cipher.ENCRYPT_MODE,key);
 byte[] encryptedByte = cipher.doFinal(plainTextByte);
 Base64.Encoder encoder = Base64.getEncoder();
 encryptedText = encoder.encodeToString(encryptedByte);
 return encryptedText;
 }else
 {
  return encryptedText;
 }
 
}


public static Key getSecretKey() throws Exception
{
 Key key= new SecretKeySpec(get_SHA_1_SecureUsernamforSalt("getbheemwise1992system"),"AES");
 cipher = Cipher.getInstance("AES");
 return key;
}


private static byte[] get_SHA_1_SecureUsernamforSalt( String key) {

 
 byte[] bytes=null;
 try {
  MessageDigest md = MessageDigest.getInstance("SHA-1");
   bytes= md.digest(key.getBytes());
  bytes=Arrays.copyOf(bytes, 16);
 } catch (NoSuchAlgorithmException e) 
 {
  e.printStackTrace();
 }
 
 return bytes;
}
public static String decrypt(String encryptedText) throws Exception 
{
  String decryptedText="";
    if(encryptedText != null)
    {
     Base64.Decoder decoder = Base64.getDecoder();
     byte[] encryptedTextByte = decoder.decode(encryptedText);
     Key key=getSecretKey();
     cipher.init(Cipher.DECRYPT_MODE, key);
     byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
     decryptedText = new String(decryptedByte);
     return decryptedText;
    }
    else
    {
     return decryptedText;
    }
   
}
}