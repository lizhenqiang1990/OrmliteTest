package com.attendance.fp.model;



import com.j256.ormlite.field.DatabaseField;

/**
 * 考勤统计 模型
 * @author Administrator
 *
 */
public class AttendanceCountModel
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
	  * 签到总数
	  */
	 @DatabaseField(columnName="signtatol")
	 private int signTatol;
	
	 
	 /**
	  * 迟到总数
	  */
	 @DatabaseField(columnName="latetatol")
	 private int lateTatol;
	
	 
	 /**
	  * 缺勤总数
	  */
	 @DatabaseField(columnName="absenteeismtatol")
	 private int absenteeismTatol;
	
	 
	 /**
	  * 忘签总数
	  */
	 @DatabaseField(columnName="forgettatol")
	 private int forgetTatol;
	
	 

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
	

	
 

	public int getSignTatol()
	{
		return this.signTatol;
	}
	 
	public void setSignTatol(int signTatol)
	{
		this.signTatol = signTatol;
	}
	
	
	 public int getLateTatol()
	 {
		return this.lateTatol;
	 }
	 
	 public void setLateTatol(int lateTatol)
	 {
		this.lateTatol = lateTatol;
	 }
	 
	 public int getAbsenteeismTatol()
	 {
		return this.absenteeismTatol;
	 }
	 
	 public void setAbsenteeismTatol(int absenteeismTatol)
	 {
		this.absenteeismTatol = absenteeismTatol;
	 }
	 
	 public int getForgetTatol()
	 {
		return this.forgetTatol;
	 }
	 
	 public void setForgetTatol(int forgetTatol)
	 {
		this.forgetTatol = forgetTatol;
	 }
}
