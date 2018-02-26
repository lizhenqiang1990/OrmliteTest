package com.attendance.fp.finder.impl;

import java.util.List;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import com.attendance.fp.db.dao.AttendanceRecordDao;
import com.attendance.fp.db.dao.impl.AttendanceRecordDaoImpl;
import com.attendance.fp.finder.AttendanceRecordFinder;
import com.attendance.fp.model.AttendanceRecordModel;

@EBean
public class AttendanceRecordFinderImpl implements AttendanceRecordFinder
{
	private final static String TAG = AttendanceRecordFinderImpl.class.getSimpleName();
	
	@Bean(AttendanceRecordDaoImpl.class)
	public AttendanceRecordDao attendanceRecordDao;
	
	@Override
	public List<AttendanceRecordModel> findAttendanceRecord()
	{
		// TODO Auto-generated method stub
		return attendanceRecordDao.listAttendanceRecord();
	}

	@Override
	public List<AttendanceRecordModel> findAttendanceRecord(String userid)
	{
		// TODO Auto-generated method stub
		return attendanceRecordDao.listAttendanceRecord(userid);
	}

	@Override
	public List<AttendanceRecordModel> findAttendanceRecord(String userid,
			int year,int month,int day)
	{
		// TODO Auto-generated method stub
		return attendanceRecordDao.listAttendanceRecord(userid,  year, month, day);
	}

}
