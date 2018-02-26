package com.attendance.fp.model;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 指纹 模型
 * @author Administrator
 *
 */
@DatabaseTable(tableName="fingerprintmodel")
public class FingerPrintModel
{
	 /**
	  * 自增长
	  */
	 @DatabaseField(generatedId=true)
	 private int id;
	 
	 
	/**
	 * 用户id
	 * 外键索引--用于查询FingerPrintModel对象
	 */
	@DatabaseField(columnName="userid")
	private String userId;
	 
	 /**
	  * 外键 ，调用query获取log对象时候直接也携带UserInfoModel对象，外键列自定义为；userInfo_userid以userInfo.userid为索引
	  * 添加 foreignAutoRefresh = true 标志为调用ueryForId时，携带了UserInfoModel
	  */
	 @DatabaseField(foreign=true,foreignAutoCreate=true,foreignAutoRefresh = true,foreignColumnName="userid")
	 private UserInfoModel userInfo;//用户信息信息--外键
	 
	 /**
	  * 指纹ID
	  */
	 @DatabaseField(columnName="fingerid",defaultValue="-1")
	 private int fingerId;
	
	 
	 
	 /**
	  * 模版数据
	  * 由于向后兼容性,任何字段的类型byte[]必须指定数据类型
	  */
	 @DatabaseField(columnName="fingertemplate",dataType=DataType.BYTE_ARRAY)
	 private byte[] fingerTemplate;
	 


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
	 
	
	public int getFingerId()
	{
		return this.fingerId;
	}
	
	public void setFingerId(int fingerId)
	{
		this.fingerId = fingerId;
	}
	
	
	public byte[] getFingerTemplate()
	{
		return this.fingerTemplate;
	}
	
	public void setFingerTemplate(byte[] fingerTemplate)
	{
		this.fingerTemplate = fingerTemplate;
	}
}
