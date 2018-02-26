package com.attendance.fp.model;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * 用户信息 模型
 * 未指定 字段名称 则 使用变量名称
 * 
 * @author Administrator
 *
 */
@DatabaseTable(tableName="userinfo")
public class UserInfoModel
{
	/**
	 * 自增id
	 */
	@DatabaseField(generatedId = true)
	private int id;
	
	/**
	 * 用户id
	 * 设置为 unique（唯一约束）---作为其他表的外键索引
	 */
	@DatabaseField(columnName="userid",canBeNull=false,unique=true)
	private String userId;

	/**
	 * 用户名称
	 */
	@DatabaseField(columnName="username",canBeNull=false)
	private String userName;
	
	/**
	 * 用户年龄
	 */
	@DatabaseField(columnName="userage")
	private int userAge;
	
	/**
	 * 性别
	 * 0=女生
	 * 1=男生
	 * 2...
	 */
	@DatabaseField(columnName="usersex")
	private int userSex;
	
	/**
	 * 电话
	 */
	@DatabaseField(columnName="userphone")
	private String userPhone;
	
	/**
	 * 邮件
	 */
	@DatabaseField(columnName="useremail")
	private String userEmail;

	/**
	 * 部门
	 */
	@DatabaseField(columnName="userdepartment")
	private String userDepartment;
	
	/**
	 * 补充
	 */
	@DatabaseField(columnName="usersupplement")
	private String userSupplement;
	
	 
	 /**
	  * 图像数据
	  * 由于向后兼容性,任何字段的类型byte[]必须指定数据类型
	  */
	 @DatabaseField(columnName="imgdata",dataType=DataType.BYTE_ARRAY)
	 private byte[] imgData;
	

	public UserInfoModel() 
	{
		// ORMLite needs a no-arg constructor 
	}
	
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return this.userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public int getUserAge()
	{
		return this.userAge;
	}
	
	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
	
	public int getUserSex()
	{
		return this.userSex;
	}
	
	public void setUserSex(int userSex)
	{
		this.userSex = userSex;
	}
	
	public String getUserPhone()
	{
		return this.userPhone;
	}
	
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}
	
	
	public String getUserEmail()
	{
		return this.userEmail;
	}
	
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	
	public String getUserDepartment()
	{
		return this.userDepartment;
	}
	
	public void setUserDepartment(String userDepartment)
	{
		this.userDepartment = userDepartment;
	}
	
	
	public String getUserSupplement()
	{
		return this.userSupplement;
	}
	
	public void setUserSupplement(String userSupplement)
	{
		this.userSupplement = userSupplement;
	}
	
	public byte[] getImgData()
	{
		return this.imgData;
	}
	
	public void setImgData(byte[] imgData)
	{
		this.imgData = imgData;
	}
	
}
