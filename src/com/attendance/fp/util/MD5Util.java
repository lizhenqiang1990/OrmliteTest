package com.attendance.fp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



import android.content.Context;


public class MD5Util 
{
	
	public static final String TAG = MD5Util.class.getSimpleName();
	
	
	//二进制转换匹配
	 protected static char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};  
     protected static MessageDigest messageDigest = null;  
     
 	public static final int  buffersize = 1024*1024*8;
     
     static
     {
         try
         {   // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
             messageDigest = MessageDigest.getInstance("MD5");  
         }
         catch (NoSuchAlgorithmException e)
         {  
             System.err.println(MD5Util.class.getName()+"初始化失败，MessageDigest不支持MD5Util.");  
             e.printStackTrace();  
         }  
     }  
        
	
	
	/**
	 *  MD5変換--生成字符串的md5校验值
	 * @param str
	 * 
	 * @return 失败返回 null
	 */
	public static String getMD5String(String str)
	{
		if (str != null && !str.equals("")) 
		{
			try
			{
				 // 输入的字符串转换成字节数组
			     byte[] inputByteArray = str.getBytes("UTF8");
				
				 // 更新使用给定的byte []
			     messageDigest.update(inputByteArray);
			     // 转换并返回结果，也是字节数组，包含16个元素
				byte[] md5Byte = messageDigest.digest();
				
				StringBuffer sb = new StringBuffer();
				
				for (int i = 0; i < md5Byte.length; i++) 
				{
					sb.append(hexDigits[(int) (md5Byte[i] & 0xff) / 16]);
					sb.append(hexDigits[(int) (md5Byte[i] & 0xff) % 16]);
				}
				
				str = sb.toString();
				
				return str;
				
			} 
			catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			    
	
		}
		
		return null;
	}
	
	
	/**
	 * 判断字符串的md5校验码是否与一个已知的md5码相匹配
	 * 
	 * @param password 要校验的字符串
	 * @param md5PwdStr 已知的md5校验码
	 * @return
	 */
	public static boolean checkPassword(String password, String md5PwdStr) 
	{
		if (password == null  || md5PwdStr == null)
		{
			return false;
		}
		
		String s = getMD5String(password);
		
		return s.equals(md5PwdStr);
		
	}
	
	
	/************************************文件****MD5**********************************/
	
	
     /** 
      * 计算文件的MD5 
      * @param fileName 文件的绝对路径 
      * @return 
      * @throws IOException 
      */ 
     public static String getFileMD5String(String fileName) throws IOException
     {  
         File f = new File(fileName);  
         return getFileMD5String(f);  
     }  
        
     /** 
      * 计算文件的MD5，重载方法 
      * 对于打文件--只取一段
      * @param file 文件对象 
      * @return 
      * @throws IOException 
      */ 
     public static String getFileMD5String(File file) throws IOException
     {  
    	 long filesize = file.length();
    	 if (filesize > buffersize )
    	 {
    		 filesize = buffersize;
    	 }
    	 
         FileInputStream in = new FileInputStream(file);  
         FileChannel ch = in.getChannel();  
         //内存映射速度更快--问题就是如果问题太大内存是个大问题
         MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, filesize);  
         messageDigest.update(byteBuffer);  
         return bufferToHex(messageDigest.digest());  
     }  
     
     /**
      * 对于大文件，可以使用DigestInputStream。
      * 文件太大耗时--暂时不使用
      * @param inputFile
      * @return
      */
     public static String getfileMD5(String inputFile) 
     {

    	  // 缓冲区大小（这个可以抽出一个参数）

    	  int bufferSize = 256 * 1024;
    	  FileInputStream fileInputStream = null;
    	  DigestInputStream digestInputStream = null;

  
    	     // 使用DigestInputStream
    	     try
			{
				fileInputStream = new FileInputStream(inputFile);
				digestInputStream = new DigestInputStream(fileInputStream,messageDigest);
	    	     // read的过程中进行MD5处理，直到读完文件
	    	     byte[] buffer =new byte[bufferSize];
	    	     try
				{
					while (digestInputStream.read(buffer) > 0);
					
					 // 获取最终的MessageDigest
		    	     messageDigest= digestInputStream.getMessageDigest();
		    	     // 拿到结果，也是字节数组，包含16个元素
		    	     byte[] resultByteArray = messageDigest.digest();
		    	     
		    	     // 同样，把字节数组转换成字符串
		    	     return bufferToHex(resultByteArray);
		    	     
				} 
	    	    catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    
			}
    	    catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
    	  finally 
    	  {

    	     try 
    	     {

    	        digestInputStream.close();

    	     } 
    	     catch (Exception e) 
    	     {

    	     }

    	     try 
    	     {

    	        fileInputStream.close();

    	     }
    	     catch (Exception e) 
    	     {

    	     }

    	  }
    	     
		return null;
    }
     
        
     /**
      * 缓存转为16进制字符串
      * @param bytes
      * @return
      */
     private static String bufferToHex(byte bytes[]) 
     {  
        return bufferToHex(bytes, 0, bytes.length);  
     }  
        
     private static String bufferToHex(byte bytes[], int m, int n) 
     {  
        StringBuffer stringbuffer = new StringBuffer(2 * n);  
        int k = m + n;  
        for (int l = m; l < k; l++) 
        {  
         appendHexPair(bytes[l], stringbuffer);  
        }  
        return stringbuffer.toString();  
     }  
     
     //构造02x样式
     private static void appendHexPair(byte bt, StringBuffer stringbuffer) 
     {  
    	  // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
    	 //高四位
        char c0 = hexDigits[(bt & 0xf0) >> 4];  
        //低四位
        char c1 = hexDigits[bt & 0xf];  
        //追加
        stringbuffer.append(c0);  
        stringbuffer.append(c1);  
     }  
     
     
   
	
}
