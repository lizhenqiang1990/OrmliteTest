package com.attendance.fp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 考勤类型 模型
 * @author Administrator
 *
 */
@DatabaseTable(tableName = "attendancetypemodel")
public class AttendanceTypeModel
{
	/**
	 * 自增id
	 */
	@DatabaseField(generatedId = true)
	private int id;
	
	
	
	/**
	 * 签到类型名称
	 * 不可以为空
	 */
	@DatabaseField(columnName="typetame",canBeNull=false)
	private String typeName;
	
	
	
	/**
	 * 开启的时间
	 */
	@DatabaseField(columnName="starttime")
	private long startTime;

	
	/**
	 * 类型开关
	 * 默认为关
	 */
	@DatabaseField(columnName="isstart",defaultValue="false")
	private boolean isStart;
	
	
	
	/**
	 * 配对 类型
	 * 不可以为空
	 */
	@DatabaseField(columnName="matchtype",canBeNull=false)
	private String matchType;
	
	
	
	
	/**
	 * 配对类型优先级
	 * 0先或1后 
	 */
	@DatabaseField(columnName="priority")
	private int priority;
	
	
	
	/**
	 * 类型触发方式
	 * 触发方式-1或0 自动和手动
	 */
	@DatabaseField(columnName="startmode")
	private int startMode;
	
	
	

	
	public String getTypeName()
	{
		return this.typeName;
	}
	
	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}
	
	public long getStartTime()
	{
		return this.startTime;
	}
	
	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}
	
	public boolean getIsStart()
	{
		return this.isStart;
	}
	
	public void setIsStart(boolean isStart)
	{
		this.isStart = isStart;
	}
	
	
	public String getMatchType()
	{
		return this.matchType;
	}
	
	public void setMatchType(String matchType)
	{
		this.matchType = matchType;
	}
	
	public int getPriority()
	{
		return this.priority;
	}
	
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	public int getStartMode()
	{
		return this.startMode;
	}
	
	public void setStartMode(int startMode)
	{
		this.startMode = startMode;
	}
}
