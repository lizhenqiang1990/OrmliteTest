package com.attendance.fp.db.dao;

import java.util.List;

import com.attendance.fp.model.AttendanceCountModel;


/**
 * 考勤统计 表 功能接口
 * @author Administrator
 *
 */
public abstract interface  AttendanceCountDao
{
	 /**
     * 根据日期 添加 一个考勤统计表
     * @param AttendanceCount
     * @return
     */
    public abstract int addAttendanceCount(AttendanceCountModel model);
    
    
    /**
     * 根据用户id 删除 考 勤统计表
     * @param userId
     * @return
     */
    public abstract int deleteAttendanceCount(String userId);
    
    /**
     * 根据用户id和日期  删除 考 勤统计表
     * @param userId 用户id
     * @param date 日期
     * @return
     */
    public abstract int deleteAttendanceCount(String userId,int year,int month);
    
    
    /**
     *  更新 用户id  信息
     * @param oldUserId 旧用户id
     * @param newUserId 新用户id
     * @return
     */
    public abstract int updateAttendanceCount(String oldUserId,String newUserId);
    
    
    /**
     * 更新 用户id 和 日期  所对应 的 考勤统计表 信息
     * @param model 信息
     * @param userId 用户id
     * @param date 日期
     * @return
     */
    public abstract int updateAttendanceCount(AttendanceCountModel model,String userId,int year,int month);
    
    
    /**
     * 统计该用户 有统计表个数
     * @param userId 用户id
     * @return
     */
    public abstract int getAttendanceCount(String userId);
    
    /**
     * 判断 用户这个月是否统计
     * @param userId 用户id
     * @param date 日期
     * @return
     */
    public abstract boolean isAttendanceCount(String userId,int year,int month);
    
    /**
     * 获取所有考勤统计表列表
     * @return
     */
    public abstract List<AttendanceCountModel > listAttendanceCount();
    
    
    
    /**
     * 获取对应用户id考勤统计列表
     * @param userId 用户id
     * @return
     */
    public abstract List<AttendanceCountModel >  listAttendanceCount(String userId);
    
    /**
     * 获取对应用户id和日期 的 考勤统计列表
     * 
     * @param userId 用户id 
     * @param date 日期
     * @return
     */
    public abstract AttendanceCountModel getAttendanceinfo(String userId,int year,int month);
    
    
    /**
     * 删除所有 考勤统计表 记录
     */
    public abstract void deleteAllAttendanceCount() ;
    
}
