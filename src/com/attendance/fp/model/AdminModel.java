package com.attendance.fp.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author Administrator
 *
 */
@DatabaseTable(tableName = "adminmodel")
public class AdminModel
{
	
	/**
	 * 自增id
	 */
	@DatabaseField(generatedId = true)
	private int id;
	
	
	/**
	 * 用户名称
	 */
	@DatabaseField(columnName="adminname",canBeNull=false,unique=true)
	private String adminName;
	
	
	/**
	 * 是否为管理员
	 */
	@DatabaseField(columnName = "isadmin",defaultValue="false")
	private  boolean isAdmin;
	
	
	
	/**
	 * md5 密码
	 */
	@DatabaseField(columnName = "md5key",defaultValue="")
	private String md5Key;
	
	
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
	 
	
	
	
	public String getAdminName()
	{
		return this.adminName;
	}
	
	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}
	
	
	
	public boolean isAdmin()
	{
		return this.isAdmin;
	}
	
	public void setIsAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	
	public String getMd5Key()
	{
		return this.md5Key;
	}
	
	public void setMd5Key(String md5Key)
	{
		this.md5Key = md5Key;
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
