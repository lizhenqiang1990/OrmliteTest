package com.attendance.fp.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

import com.attendance.fp.db.FPDatabaseHelper;
import com.attendance.fp.db.dao.AttendanceRecordDao;
import com.attendance.fp.model.AttendanceRecordModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

@EBean
public class AttendanceRecordDaoImpl implements AttendanceRecordDao
{
	
	private final static String TAG = AttendanceRecordDaoImpl.class.getSimpleName();
	
	@OrmLiteDao(helper=FPDatabaseHelper.class)
	public Dao<AttendanceRecordModel, Integer> attendancerecorDao;

	
	
	@Override
	public int addAttendanceRecord(AttendanceRecordModel model)
	{
		// TODO Auto-generated method stub
		
		try
		{
			return attendancerecorDao.create(model);
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteAttendanceRecord(String userId)
	{
		// TODO Auto-generated method stub
	  DeleteBuilder< AttendanceRecordModel,Integer> deleteBuilder = attendancerecorDao.deleteBuilder();
		
		try
		{
			deleteBuilder.where().eq("userid", userId);
			
			return deleteBuilder.delete();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	

	@Override
	public int deleteAttendanceRecord(String userId, int year,int month,int day)
	{
		// TODO Auto-generated method stub
		DeleteBuilder< AttendanceRecordModel,Integer> deleteBuilder = attendancerecorDao.deleteBuilder();
		
		try
		{
			//双条件 

			deleteBuilder.where().eq("userid", userId).and();
			
			if (year > 0 )
			{
				deleteBuilder.where().eq("year", year).and();
			}
			
			if (month > 0)
			{
				deleteBuilder.where().eq("month", month).and();
			}
			
			if (day > 0)
			{
				deleteBuilder.where().eq("day", day);
			}
			
			return deleteBuilder.delete();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateAttendanceRecord(String oldUserId, String newUserId)
	{
		// TODO Auto-generated method stub
		try
		{
			UpdateBuilder<AttendanceRecordModel, Integer> updateBuilder = attendancerecorDao.updateBuilder();
			updateBuilder.updateColumnValue("userid", newUserId);
			updateBuilder.updateColumnValue("UserInfo_userid", newUserId);
			//更新用户id
			updateBuilder.where().eq("userid", oldUserId);
			
			return updateBuilder.update();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	

	@Override
	public int getAttendanceRecordCount(String userId,int year,int month,int day)
	{
		// TODO Auto-generated method stub
		List<AttendanceRecordModel> list = new ArrayList<AttendanceRecordModel>();
		
		QueryBuilder<AttendanceRecordModel, Integer> queryBuilder = attendancerecorDao.queryBuilder();
		
		try
		{
			queryBuilder.where().eq("userid", userId).and();
			
			if (year > 0 )
			{
				queryBuilder.where().eq("year", year).and();
			}
			
			if (month > 0)
			{
				queryBuilder.where().eq("month", month).and();
			}
			
			if (day > 0)
			{
				queryBuilder.where().eq("day", day);
			}
			
			list = queryBuilder.query();
			
			return list.size();

		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<AttendanceRecordModel> listAttendanceRecord()
	{
		// TODO Auto-generated method stub
		List<AttendanceRecordModel> list = new ArrayList<AttendanceRecordModel>();
		
		QueryBuilder<AttendanceRecordModel, Integer> queryBuilder = attendancerecorDao.queryBuilder();
		
		try
		{
			list = queryBuilder.query();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<AttendanceRecordModel> listAttendanceRecord(String userId)
	{
		// TODO Auto-generated method stub
		List<AttendanceRecordModel> list = new ArrayList<AttendanceRecordModel>();
		
		QueryBuilder<AttendanceRecordModel, Integer> queryBuilder = attendancerecorDao.queryBuilder();
		
		try
		{
			queryBuilder.where().eq("userid", userId);
			
			list = queryBuilder.query();
			

		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<AttendanceRecordModel> listAttendanceRecord(String userId,
			int year,int month,int day)
	{
		// TODO Auto-generated method stub
	    List<AttendanceRecordModel> list = new ArrayList<AttendanceRecordModel>();
		
		QueryBuilder<AttendanceRecordModel, Integer> queryBuilder = attendancerecorDao.queryBuilder();
		
		try
		{
			queryBuilder.where().eq("userid", userId).and();
			
			if (year > 0 )
			{
				queryBuilder.where().eq("year", year).and();
			}
			
			if (month > 0)
			{
				queryBuilder.where().eq("month", month).and();
			}
			
			if (day > 0)
			{
				queryBuilder.where().eq("day", day);
			}
			
			list = queryBuilder.query();
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void deleteAllAttendanceRecord()
	{
		// TODO Auto-generated method stub
		DeleteBuilder<AttendanceRecordModel, Integer> deleteBuilder = attendancerecorDao.deleteBuilder();
		
		try
		{
			deleteBuilder.delete();
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
