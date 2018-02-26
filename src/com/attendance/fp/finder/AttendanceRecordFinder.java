package com.attendance.fp.finder;

import java.util.List;

import com.attendance.fp.model.AttendanceRecordModel;


/**
 * 获取考勤记录接口
 * @author Administrator
 *
 */
public abstract interface AttendanceRecordFinder
{

    public abstract List<AttendanceRecordModel> findAttendanceRecord();
    
    public abstract List<AttendanceRecordModel> findAttendanceRecord(String userid);
    
    public abstract List<AttendanceRecordModel> findAttendanceRecord(String userid,int year,int month,int day);
}
