package com.attendance.fp.util;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;


@SharedPref(value=SharedPref.Scope.UNIQUE)
public  interface Prefs
{
	/**
     * 设置安装次数
     * @param InstallCount 
     */
	  @DefaultInt(0)
	  public  int  installCount();
	
	/**
	 * 记录密码
	 * 默认初始化 ""
	 * @param pwd
	 */
	  @DefaultString("")
	  public  String lockPwd();
	  
     /**
      * 获取是否锁屏的标志
      * true=开启 false=关闭
      * 默认开启
      * @return
      */
	  @DefaultBoolean(true)
	  public  boolean lockScreen();
	  
     /**
      * 获取是否开启了--快捷启动的标志
      * true=开启 false=关闭
      * @return
      */
	  @DefaultBoolean(false)
	  public  boolean quickLaunch();
	  
	  
     /**
       * 获取是否拦截快捷启动的标志
      * true=开启 false=关闭
      * @return
      */
	  @DefaultBoolean(false)
	  public  boolean lowPower();
	  
	/**
     * 获取刚刚开机状态
     * true=刚刚开机时刻  false=不是
     * @return
     */
	  @DefaultBoolean(false)
	  public  boolean bootStatus();
	  
	/**
     * 设置开机之后是否直接解锁 
     * 	解锁放在 fpLockservice中
     * @param bootTime
     */
	  @DefaultBoolean(false)
	  public  boolean  firstBootUnLock(); 
	  
     /**
      * 设置第一锁屏服务是否已经开启 
      * 	解锁放在 fpLockservice中
      * @param FirstServiceTask
      * true=开启  false=未开启
      */
	  @DefaultBoolean(false)
	  public  boolean firstServiceTask();
	  
	  
     /**
      * 设置主题名称
      * @param ThemePackageName
      */
	  @DefaultString("")
	  public  String themePackageName();
	  
    /**
     * 设置手指进行注册
     * @param regfinger
     */
	  @DefaultString("0,0,0,0,0,0,0,0,0,0")
	  public  String registerFinger();
	  
	  
	/**
     * 获取黑名单拒绝回复语言模式
     * 
     * @return -1 未设置
     */
	  @DefaultInt(-1)
	  public  int callAction();
	  
	  
     /**
      * 设置指纹模版设备的种类
      * @param type
      */
	  @DefaultInt(0)
	  public  int usbType();
	  
	  
     /**
      * 设置指纹模版设备的uid
      * @param uid
      */
	  @DefaultString("")
	  public  String usbID();
	  
}
