package com.attendance.fp.util;

import java.io.File;
import java.util.List;


import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/**
 * android  app 应用操作类
 * @author Administrator
 *
 */
public class AndroidUtil 
{
	
	private final static String TAG = AndroidUtil.class.getSimpleName();
	
	private static final String SCHEME = "package";  
    /** 
	 * 调用系统InstalledAppDetails界面所需的Extra名称(用于Android 2.1及之前版本) 
	 */  
	private static final String APP_PKG_NAME_21 = "com.android.settings.ApplicationPkgName";  
	/** 
	 * 调用系统InstalledAppDetails界面所需的Extra名称(用于Android 2.2) 
	 */  
	private static final String APP_PKG_NAME_22 = "pkg";  
	/** 
	 * InstalledAppDetails所在包名 
	 */  
	private static final String APP_DETAILS_PACKAGE_NAME = "com.android.settings";  
	/** 
	 * InstalledAppDetails类名 
	 */  
	private static final String APP_DETAILS_CLASS_NAME = "com.android.settings.InstalledAppDetails"; 
    

    
    
    
    /**
     * 用来判断服务是否运行.
     * @param context
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    public static boolean isServiceRunning(Context mContext,String className) 
    {
        boolean isRunning = false;
        LogUtil.d(TAG, " isServiceRunning  className:"+className);
        //获取系统服务
        ActivityManager activityManager = (ActivityManager)
        		mContext.getSystemService(Context.ACTIVITY_SERVICE);
        //获取正在运行的服务
        List<ActivityManager.RunningServiceInfo> serviceList
        	= activityManager.getRunningServices(30);

       if (!(serviceList.size()>0)) 
        {
            return false;
        }
       //遍历判断
        for (int i=0; i<serviceList.size(); i++) 
        {
            if (serviceList.get(i).service.getClassName().equals(className) == true) 
            {
                isRunning = true;
                LogUtil.d(TAG, " ServiceRunning  className:"+className);
                break;
            }
        }
        
        return isRunning;
    }
    
    

    
    /**
    * 三方应用程序的过滤器
    *
    * @param info
    * @return true=三方应用  false=系统应用
    */
    public static boolean filterApp(ApplicationInfo info)
    {
	    if ((info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) 
	    {
		    // 代表的是系统的应用,但是被用户升级了. 用户应用
		    return true;
	    } 
	    else if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) 
	    {
		    // 代表的用户的应用
		    return true;
	    }
	    
	    return false;
    
    } 

    /**
     * 获取应用图像
     * @param context
     * @param packageName
     * @return
     */
    public static Drawable getAppicon(Context context, String packageName)
    {
      PackageManager pm = context.getPackageManager();
      
      try
      {
        return pm.getApplicationIcon(packageName);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
          localNameNotFoundException.printStackTrace();

      }
      return null;
    }
    
 
  
    /**
     * 获取当前主页包的名称
     * @param context
     * @return
     */
    public static String getGoHome(Context context) 
    {
    	//包信息
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        
        //搜寻匹配获取列表
        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
       
        //根据条件直接获取
        ResolveInfo def = packageManager.resolveActivity(intent, 0);
        
        if(def == null) 
        {
        	//直接为系统默认
            return "android";
        }
        
        //返回 此项目是该包的名称
        return def.activityInfo.packageName;
    }
    
    /**
     * 设置默认的home 桌面
     * 
     * 弹出一个 带有home种类的应用
     * @param context
     * @param packageName
     */
    public static void setDefaultHomeLaucher(Context context) 
    {
         Intent intent = new Intent();
         //intent.setAction(Intent.ACTION_VIEW);//设置为默认查看
         intent.setAction(Intent.ACTION_MAIN);
         //显示设备启动时的第一个活动
         intent.addCategory(Intent.CATEGORY_HOME);
         ComponentName cn = new ComponentName("android","com.android.internal.app.ResolverActivity");
        //设置要素--启动某程序-某部分必须的匹配条件
         intent.setComponent(cn);
         intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//10200000--0x10000000|0x200000
         context.startActivity(intent); 
        

    }
    
    /** 
	 * 调用系统InstalledAppDetails界面显示已安装应用程序的详细信息。 对于Android 2.3（Api Level 
	 * 9）以上，使用SDK提供的接口； 2.3以下，使用非公开的接口（查看InstalledAppDetails源码）。 
	 *  
	 * @param context 
	 *  
	 * @param packageName 
	 *            应用程序的包名 
	 */  
	public static void openInstalledAppDetails(Context context, String packageName) 
    {
    	 Intent intent = new Intent();  
 	    final int apiLevel = Build.VERSION.SDK_INT;  
 	    if (apiLevel >= 9) 
 	    { // 2.3（ApiLevel 9）以上，使用SDK提供的接口  
 	        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);  
 	        Uri uri = Uri.fromParts(SCHEME, packageName, null);  
 	        intent.setData(uri);  
 	    } 
 	    else 
 	    { // 2.3以下，使用非公开的接口（查看InstalledAppDetails源码）  
 	        // 2.2和2.1中，InstalledAppDetails使用的APP_PKG_NAME不同。  
 	        final String appPkgName = (apiLevel == 8 ? APP_PKG_NAME_22  
 	                : APP_PKG_NAME_21);  
 	        intent.setAction(Intent.ACTION_VIEW);  
 	        intent.setClassName(APP_DETAILS_PACKAGE_NAME,  
 	                APP_DETAILS_CLASS_NAME);  
 	        intent.putExtra(appPkgName, packageName);  
 	    }
 	    
 	    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
 	    context.startActivity(intent);  
    }
    
    
    /**
     * 根据包杀死其程序
     * @param context
     * @param packageName
     */
    public static void killApkTask(Context context, String packageName)
	{
    	LogUtil.d(TAG, "killApkTask packageName:"+packageName);
    	//获得获得管理器
	    ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
	   //通过包名杀死关联进程--发现无效--对于系统级别程序更是如此
	    am.killBackgroundProcesses(packageName);
	    
//	    Method forceStopPackage = am.getClass().getDeclaredMethod("forceStopPackage", String.class);  
//	    forceStopPackage.setAccessible(true);  
//	    forceStopPackage.invoke(am, packageName);  
	}
    
    /**
     * 获取已经安装的应用app版本名称
     * @param context
     * @param packageName
     * @return
     */
    public static String getInstallVersion(Context context, String packageName)
    {
        try 
        {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(packageName, 0);
            return info.versionName;
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return "0";
    }
    
    /**
     * 获取本地的应用app版本名称
     * @param context
     * @param packageName
     * @return
     */
    public static String getLocalApkVersion(Context context, String absPath)
    {
        try 
        {
            PackageManager pm = context.getPackageManager();
            PackageInfo pkgInfo = pm.getPackageArchiveInfo(absPath,PackageManager.GET_ACTIVITIES);  
            return pkgInfo.versionName;
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        
        return "0";
    }

    /**
     * 根据全局上下文 获取本应用的版本号
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) 
    {
        try 
        {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } 
        catch(PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
     * 获取当前系统的android版本
     * @return
     */
    public static int getSDKVersion( )
    {
        return android.os.Build.VERSION.SDK_INT;
    } 


  
    
  
    
    /**
     * 打开app
     * @param context
     * @param packageName 应用包名
     */
    public static void openApp(Context context, String packageName) 
    {
        try 
        {
            PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
            
            //设置意图和匹配条件
            Intent resolveIntent = new Intent("android.intent.action.MAIN",null);
            resolveIntent.addCategory("android.intent.category.LAUNCHER");//该程序默认启动的窗体
            resolveIntent.setPackage(pi.packageName);
            
            //搜寻到的第一个为匹配目标
            List<ResolveInfo> apps = context.getPackageManager().queryIntentActivities(resolveIntent, 0);
            ResolveInfo ri = (ResolveInfo)apps.iterator().next();
            
            if(ri != null) 
            {
                packageName = ri.activityInfo.packageName;//程序包名
                String className = ri.activityInfo.name;//程序类名路径
                
                LogUtil.d(TAG, "packageName:"+packageName+" className"+className);
                
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//10200000--0x10000000|0x200000
                ComponentName cn = new ComponentName(packageName, className);
                //设置要素--启动某程序-某部分必须的匹配条件
                intent.setComponent(cn);
                context.startActivity(intent);
                return;
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * 直接打开 home 页
     * @param context
     * @param packageName
     */
    public static void openHome(Context context, String packageName) 
    {
        try {
        	
            PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
            Intent resolveIntent = new Intent("android.intent.action.MAIN", null);
            resolveIntent.addCategory("android.intent.category.DEFAULT");
            resolveIntent.setPackage(pi.packageName);
            List<ResolveInfo> apps = context.getPackageManager().queryIntentActivities(resolveIntent, 0x0);
            ResolveInfo ri = (ResolveInfo)apps.iterator().next();
            if(ri != null) 
            {
                packageName = ri.activityInfo.packageName;
                String className = ri.activityInfo.name;
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                //将引发已经运行的Activity移动到历史stack的顶端
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);//0x20000
                //开始一个新的任务或将顶端现有任务
                //如果已经存在一个Task与新Activity的affinity相同，这个Activity就会加入到那个Task中。如果不是，启动一个新的Task。
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);//10200000--0x10000000|0x200000
                ComponentName cn = new ComponentName(packageName, className);
                //显式设置组件来处理的意图--intent对象传递到指定类的实例
                intent.setComponent(cn);
                context.startActivity(intent);
                
                return;
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 安装 apk
     * @param filepath
     */
    public static void installApk(Context mContext,String apkPath)
    {
    	// TODO Auto-generated method stub
		LogUtil.d(TAG, "installApk:"+apkPath);
		
		//if(getSDKVersion()>VERSION_CODES.JELLY_BEAN_MR1)
		//判断是否可以安装第三方
		/**
		 * 1 = allow installing from other sources
         * 0 = only allow installing from Google Play
		 */
		int result = Settings.Secure.getInt(mContext.getContentResolver(),
				Settings.Secure.INSTALL_NON_MARKET_APPS, 0);   
		if (result == 0) 
		{   
			Intent intent = new Intent();   
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(Settings.ACTION_APPLICATION_SETTINGS);   
			mContext.startActivity(intent);   
		} 
		else
		{
			Intent intent = new Intent();
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(android.content.Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.fromFile(new File(apkPath)), "application/vnd.android.package-archive");
			mContext.startActivity(intent);
		}
    }
    
    public static void uninstallApk(Context mContext,String packageName)
	{
    	Intent uninstallIntent = new Intent();   
    	uninstallIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	uninstallIntent.setAction(Intent.ACTION_DELETE);
    	Uri packageURI = Uri.fromParts("package", packageName, null);
    	uninstallIntent.setData(packageURI);
    	
    	mContext.startActivity(uninstallIntent);  
	}
    
    /**
     * 判断是否已经安装
     * @param context
     * @param packagename
     * @return
     */
    public static boolean isApkInstalled(Context context, String packagename)
    {
    	if (packagename == null || "".equals(packagename))  
    	{
    		   return false;  
    	}
      PackageManager localPackageManager = context.getPackageManager();
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(packagename, PackageManager.GET_UNINSTALLED_PACKAGES);
        return true;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {//没有则异常
       return false;
      }
      
 
      
    }
}
