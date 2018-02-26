package com.attendance.fp.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

import com.attendance.fp.db.FPDatabaseHelper;
import com.attendance.fp.db.dao.AttendanceCountDao;
import com.attendance.fp.model.AttendanceCountModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

@EBean
public class AttendanceCountDaoImpl implements AttendanceCountDao
{
	private final static String TAG = AttendanceCountDaoImpl.class.getSimpleName();
	
	@OrmLiteDao(helper=FPDatabaseHelper.class)
	public Dao<AttendanceCountModel, Integer> attendanceConutDao;
	
	
	
	@Override
	public int addAttendanceCount(AttendanceCountModel model)
	{
		// TODO Auto-generated method stub
		QueryBuilder<AttendanceCountModel, Integer> queryBuilder = attendanceConutDao.queryBuilder();
		List<AttendanceCountModel> list = new ArrayList<AttendanceCountModel>();
		try
		{
			queryBuilder.where().eq("userid", model.getUserId()).and().eq("year", model.getYear())
			.and().eq("month", model.getMonth());
			list = queryBuilder.query();
			
			if (list.size() == 0)
			{
				return attendanceConutDao.create(model);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteAttendanceCount(String userId)
	{
		// TODO Auto-generated method stub
		DeleteBuilder< AttendanceCountModel,Integer> deleteBuilder = attendanceConutDao.deleteBuilder();
		
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
	public int deleteAttendanceCount(String userId, int year,int month)
	{
		// TODO Auto-generated method stub
		
		DeleteBuilder< AttendanceCountModel,Integer> deleteBuilder = attendanceConutDao.deleteBuilder();
		
		try
		{
			//双条件 
			deleteBuilder.where().eq("userid", userId).and().eq("year", year).and().eq("month", month);
			
			return deleteBuilder.delete();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateAttendanceCount(String oldUserId,String newUserId)
	{
		// TODO Auto-generated method stub
		
		try
		{
			UpdateBuilder<AttendanceCountModel, Integer> updateBuilder = attendanceConutDao.updateBuilder();
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
	public int updateAttendanceCount(AttendanceCountModel model,String userId,int year,int month)
	{
		// TODO Auto-generated method stub
		try
		{
			UpdateBuilder<AttendanceCountModel, Integer> updateBuilder = attendanceConutDao.updateBuilder();
			
			updateBuilder.updateColumnValue("signtatol", model.getSignTatol());
			updateBuilder.updateColumnValue("latetatol", model.getLateTatol());
			updateBuilder.updateColumnValue("absenteeismtatol", model.getAbsenteeismTatol());
			updateBuilder.updateColumnValue("forgettatol", model.getForgetTatol());

			updateBuilder.where().eq("userid", userId).and().eq("year", year).and().eq("month", month);
			
			return updateBuilder.update();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public  int getAttendanceCount(String userId)
	{
		List<AttendanceCountModel> list = new ArrayList<AttendanceCountModel>();
		
		QueryBuilder<AttendanceCountModel, Integer> queryBuilder = attendanceConutDao.queryBuilder();
		
		try
		{
			queryBuilder.where().eq("userid", userId);
			
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
	public boolean isAttendanceCount(String userId,int year,int month)
	{
		// TODO Auto-generated method stub
		List<AttendanceCountModel> list = new ArrayList<AttendanceCountModel>();
		
		QueryBuilder<AttendanceCountModel, Integer> queryBuilder = attendanceConutDao.queryBuilder();
		
		try
		{
			queryBuilder.where().eq("userid", userId).and().eq("year", year).and().eq("month", month);
			
			list = queryBuilder.query();
			if (list.size() != 0)
			{
				return true;
			}
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<AttendanceCountModel> listAttendanceCount()
	{
		// TODO Auto-generated method stub
		List<AttendanceCountModel> list = new ArrayList<AttendanceCountModel>();
		
		QueryBuilder<AttendanceCountModel, Integer> queryBuilder = attendanceConutDao.queryBuilder();
		
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
	public List<AttendanceCountModel >  listAttendanceCount(String userId)
	{
		// TODO Auto-generated method stub
		List<AttendanceCountModel> list = new ArrayList<AttendanceCountModel>();
		
		QueryBuilder<AttendanceCountModel, Integer> queryBuilder = attendanceConutDao.queryBuilder();
		
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
	public AttendanceCountModel getAttendanceinfo(String userId,int year,int month)
	{
		// TODO Auto-generated method stub
		
		List<AttendanceCountModel> list = new ArrayList<AttendanceCountModel>();
		
		QueryBuilder<AttendanceCountModel, Integer> queryBuilder = attendanceConutDao.queryBuilder();
		
		try
		{
			queryBuilder.where().eq("userid", userId).and().eq("year", year).and().eq("month", month);
			
			list = queryBuilder.query();
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (list.size() != 0)
		{
			return list.get(0);
		}
		
		return null;
		
	}

	@Override
	public void deleteAllAttendanceCount()
	{
		// TODO Auto-generated method stub
		
		DeleteBuilder<AttendanceCountModel, Integer> deleteBuilder = attendanceConutDao.deleteBuilder();
		
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
