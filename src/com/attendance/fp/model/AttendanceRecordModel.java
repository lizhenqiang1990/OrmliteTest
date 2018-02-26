package com.attendance.fp.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

/**
 * 考勤记录模型
 * @author Administrator
 *
 */
public class AttendanceRecordModel
{
	/**
	 * 自增id
	 */
	@DatabaseField(generatedId = true)
	private int id;
	
	/**
	 * 用户id
	 * 外键索引--用于查询FingerPrintModel对象
	 */
	@DatabaseField
	private String userId;
	 
	 /**
	  * 外键 ，调用query获取log对象时候直接也携带UserInfoModel对象，外键列自定义为；UserInfo_userid以userInfo.userid为索引
	  * 添加 foreignAutoRefresh = true 标志为调用ueryForId时，携带了UserInfoModel
	  */
	 @DatabaseField(foreign=true,foreignAutoCreate=true,foreignAutoRefresh = true,foreignColumnName="userid")
	 private UserInfoModel userInfo;//用户信息信息--外键
	 
	
	/**
	 * 签到类型
	 */
	@DatabaseField(columnName="signtype")
	private int signType;
	
	
	/**
	 * 年
	 */
	@DatabaseField(columnName="year")
	private int year ;
	
	
	
	/**
	 * 月
	 */
	@DatabaseField(columnName="month")
	private int month ;
	
	
	/**
	 * 日
	 */
	@DatabaseField(columnName="day")
	private int day ;
	

	
//	/**
//	 * 时间日期--年月日
//	 * 时间单位是s 10位
//	 * ms 末尾加L转为Long保存
//	 */
//	@DatabaseField(columnName="datetime")
//	private long dateTime ;
	
	
	
	

	public String getUserId()
	{
		return this.userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public UserInfoModel getUserInfoModel()
	{
		return this.userInfo;
	}
	 
	public void setUserInfoModel(UserInfoModel userInfo)
	{
		this.userInfo = userInfo;
	}
	
	
	public int getSignType()
	{
		return this.signType;
	}
	
	public void setSignType(int signType)
	{
		this.signType = signType;
	}
	

//	public long getDateTime()
//	{
//		return this.dateTime;
//	}
//	
//	public void setDateTime(long dateTime)
//	{
//		this.dateTime = dateTime;
//	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	
}
