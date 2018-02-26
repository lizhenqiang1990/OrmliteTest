package com.attendance.fp.finder;

import java.util.List;

import com.attendance.fp.model.AttendanceCountModel;

/**
 *  考勤统计 列表获取
 * @author Administrator
 *
 */
public abstract interface AttendanceCountFinder
{
	
	/**
	 * 获取  考勤统计 列表
	 * @return
	 */
    public abstract List<AttendanceCountModel> findAttendanceCount(String userId);
    
	/**
	 * 获取  考勤统计 列表
	 * @return
	 */
    public abstract List<AttendanceCountModel> findAttendanceCount();
}
