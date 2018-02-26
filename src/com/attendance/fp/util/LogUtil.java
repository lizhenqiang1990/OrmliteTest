package com.attendance.fp.util;

import java.io.FileWriter;
import java.io.IOException;

import android.content.Context;
import android.widget.Toast;



public class LogUtil 
{  
	//public static final String TAG = EncryptGen.class.getSimpleName();
    private static final boolean DEBUG = true;
    
    public static void ToastD(Context context,String content)
    {
    	 if(DEBUG) 
         {
    		 Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
         }
    }
    
    public static void ToastI(Context context,String content)
    {
    	 if(DEBUG) 
         {
    		 Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
         }
    }
      
    public static void v(String TAG, String msg)
    {  
        if(DEBUG) 
        {  
            android.util.Log.v(TAG, msg);  
        }  
    }  
    
    public static void v(String TAG, String msg, Throwable tr)
    {  
        if(DEBUG) 
        {  
            android.util.Log.v(TAG, msg, tr);  
        }  
    }  
    
    public static void d(String TAG, String msg)
    {  
        if(DEBUG) 
        {  
            android.util.Log.d(TAG, "fp:"+msg);  
            //这个是用来输入到文件中作为记录
            //file_info(TAG+":"+msg);
        }  
    }  
    
    public static void d(String TAG, String msg, Throwable tr) 
    {  
        if(DEBUG) 
        {  
            android.util.Log.d(TAG, msg, tr);  
        }  
    }  
    
    public static void i(String TAG, String msg) 
    {  
        if(DEBUG)
        {  
            android.util.Log.i(TAG, msg);  
        }  
    }  
    
    public static void i(String TAG, String msg, Throwable tr)
    {  
        if(DEBUG) 
        {  
            android.util.Log.i(TAG, msg, tr);  
        }  
    }  
    
    public static void w(String TAG, String msg) 
    {  
        if(DEBUG) 
        {  
            android.util.Log.w(TAG, msg);  
        }  
    }  
    
    public static void w(String TAG, String msg, Throwable tr) 
    {  
        if(DEBUG) 
        {  
            android.util.Log.w(TAG, msg, tr);  
        }  
    }  
    public static void w(String TAG, Throwable tr) 
    {  
        if(DEBUG)
        {  
            android.util.Log.w(TAG, tr);  
        }  
    }  
    
    public static void e(String TAG, String msg)
    {  
        if(DEBUG) 
        {  
            android.util.Log.e(TAG, msg);  
        }  
    }  
    
    public static void e(String TAG, String msg, Throwable tr) 
    {  
        if(DEBUG) 
        {  
            android.util.Log.e(TAG, msg, tr);  
        }  
    }  
    

	public static void file_info(String msg)
	{

		  try 
		  {
			  // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件 
			  FileWriter writer = new FileWriter("./sdcard/fingerjavaloginfo.txt", true); 
			  writer.write(msg+"\n");
		      writer.close(); 
		  } 
		  catch (IOException e) 
		  { 
			  e.printStackTrace();
		 }

	}
  
}