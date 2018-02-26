package com.attendance.fp.finder;

import java.util.List;

import com.attendance.fp.model.AttendanceTypeModel;

/**
 * 考勤类型 列表获取 
 * @author Administrator
 *
 */
public abstract interface AttendanceTypeFinder
{

    public abstract List<AttendanceTypeModel> findAttendanceType();
}
