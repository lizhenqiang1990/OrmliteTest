package com.attendance.fp.finder.impl;

import java.util.List;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import com.attendance.fp.db.dao.AttendanceCountDao;
import com.attendance.fp.db.dao.impl.AttendanceCountDaoImpl;
import com.attendance.fp.finder.AttendanceCountFinder;
import com.attendance.fp.model.AttendanceCountModel;


/**
 * 考勤统计 列表获取
 * @author Administrator
 *
 */
@EBean
public class AttendanceCountFinderImpl implements AttendanceCountFinder
{

	private final static String TAG = AttendanceCountFinderImpl.class.getSimpleName();
	
	@Bean(AttendanceCountDaoImpl.class)
	public AttendanceCountDao attendanceCountDao;
	
	@Override
	public  List<AttendanceCountModel> findAttendanceCount(String userId)
	{
		// TODO Auto-generated method stub
		return attendanceCountDao.listAttendanceCount(userId);
	}
	
	@Override
	public List<AttendanceCountModel> findAttendanceCount()
	{
		// TODO Auto-generated method stub
		return attendanceCountDao.listAttendanceCount();
	}

}
