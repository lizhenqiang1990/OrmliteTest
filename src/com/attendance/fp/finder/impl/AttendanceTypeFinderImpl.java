package com.attendance.fp.finder.impl;

import java.util.List;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import com.attendance.fp.db.dao.AttendanceTypeDao;
import com.attendance.fp.db.dao.impl.AttendanceTypeDaoImpl;
import com.attendance.fp.finder.AttendanceTypeFinder;
import com.attendance.fp.model.AttendanceTypeModel;

@EBean
public class AttendanceTypeFinderImpl implements AttendanceTypeFinder
{
	private final static String TAG = AttendanceTypeFinderImpl.class.getSimpleName();
	
	@Bean(AttendanceTypeDaoImpl.class)
	public AttendanceTypeDao attendanceTypeDao;
	
	@Override
	public List<AttendanceTypeModel> findAttendanceType()
	{
		// TODO Auto-generated method stub
		return attendanceTypeDao.listAttendanceType();
	}

}
