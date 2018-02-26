package com.attendance.fp.db.dao;

import java.util.List;

import com.attendance.fp.model.AttendanceRecordModel;



/**
 * 考勤记录 dao 功能接口
 * 
 * 不能提供修改考勤类型，只能修改用户名称，另外不提供时间段单个删除，只能整天
 * 
 * @author Administrator
 *
 */
public abstract interface  AttendanceRecordDao
{

	 /**
     * 添加 一个考勤记录
     * @param AttendanceRecord
     * @return
     */
    public abstract int addAttendanceRecord(AttendanceRecordModel model);
    
    
    /**
     * 根据用户id 删除 考勤记录
     * @param userId
     * @return
     */
    public abstract int deleteAttendanceRecord(String userId);
    
    /**
     * 根据用户id和日期  删除 考勤记录
     * @param userId
     * @return
     */
    public abstract int deleteAttendanceRecord(String userId,int year,int month,int day);
    
    
    /**
     * 更新 用户id 信息
     * @param oldUserId  旧用户id
     * @param newUserId  新用户id
     * @return
     */
    public abstract int updateAttendanceRecord(String oldUserId,String newUserId);
    

    /**
     * 统计该用户 某日期内 考勤 数
     * @param userId 用户id
     * @param dateTime 日期
     * @return
     */
    public abstract int getAttendanceRecordCount(String userId,int year,int month,int day);
    
  
    
    /**
     * 获取所有考勤列表
     * @return
     */
    public abstract List<AttendanceRecordModel > listAttendanceRecord();
    
    
    
    /**
     * 获取对应用户id考勤 列表
     * @param userId 用户id
     * @return
     */
    public abstract List<AttendanceRecordModel > listAttendanceRecord(String userId);
    
    /**
     * 获取对应用户id和日期 的 考勤列表
     * 
     * @param userId 用户id
     * @param dateTime 日期
     * @return
     */
    public abstract List<AttendanceRecordModel > listAttendanceRecord(String userId,int year,int month,int day);
    
    
    /**
     * 删除所有 考勤统计 记录
     */
    public abstract void deleteAllAttendanceRecord() ;
    
}
