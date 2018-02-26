package com.attendance.fp.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

import com.attendance.fp.db.FPDatabaseHelper;
import com.attendance.fp.db.dao.AttendanceTypeDao;
import com.attendance.fp.model.AttendanceRecordModel;
import com.attendance.fp.model.AttendanceTypeModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

@EBean
public class AttendanceTypeDaoImpl implements AttendanceTypeDao
{
	private final static String TAG = AttendanceTypeDaoImpl.class.getSimpleName();
	
	@OrmLiteDao(helper=FPDatabaseHelper.class)
	public Dao<AttendanceTypeModel, Integer> attendanceTypeDao;
	
	
	
	@Override
	public int addAttendanceType(AttendanceTypeModel model)
	{
		// TODO Auto-generated method stub
		try
		{
			if (attendanceTypeDao.queryForEq("typetame", model.getTypeName()).size() == 0)
			{
				return attendanceTypeDao.create(model);
			}
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return 0;
	}

	@Override
	public int deleteAttendanceType(String typeName)
	{
		// TODO Auto-generated method stub
		DeleteBuilder<AttendanceTypeModel, Integer> deleteBuilder = attendanceTypeDao.deleteBuilder();
		
		try
		{
			deleteBuilder.where().eq("typetame",typeName);
			
			return deleteBuilder.delete();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int updateAttendanceType(AttendanceTypeModel model)
	{
		// TODO Auto-generated method stub
		try
		{
			return attendanceTypeDao.update(model);
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
	@Override
	public int updateAttendanceType(String oldTypeName, String newTypeName)
	{
		// TODO Auto-generated method stub
		try
		{
			UpdateBuilder<AttendanceTypeModel, Integer> updateBuilder = attendanceTypeDao.updateBuilder();
			updateBuilder.updateColumnValue("typetame", newTypeName);
			
			//更新
			updateBuilder.where().eq("typetame", oldTypeName);
			
			return updateBuilder.update();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int updateAttendanceType(String typeName, boolean isStart)
	{
		// TODO Auto-generated method stub
		UpdateBuilder<AttendanceTypeModel, Integer> updateBuilder = attendanceTypeDao.updateBuilder();
		
		try
		{
			//更新的值
			updateBuilder.updateColumnValue("isstart", isStart);
			//条件
			updateBuilder.where().eq("typetame", typeName);
			
			return updateBuilder.update();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public boolean isAttendanceType(String typeName)
	{
		// TODO Auto-generated method stub
		try
		{
			List<AttendanceTypeModel> list = attendanceTypeDao.queryForEq("typetame",typeName);
			if (list.size() > 0)
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
	public  boolean isStart(String typeName)
	{
		List<AttendanceTypeModel> models = new ArrayList<AttendanceTypeModel>();
		
		QueryBuilder<AttendanceTypeModel, Integer> queryBuilder = attendanceTypeDao.queryBuilder();

		try
		{
			queryBuilder.where().eq("typetame",typeName);
			//降序
			queryBuilder.orderBy("typetame", true);
			
			models = queryBuilder.query();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (models.size() != 0)
		{
			return models.get(0).getIsStart();
		}
		else
		{
			return false;
		}
		
	}
	

	@Override
	public AttendanceTypeModel getAttendanceType(String typeName)
	{
		// TODO Auto-generated method stub
		List<AttendanceTypeModel> models = new ArrayList<AttendanceTypeModel>();
		
		QueryBuilder<AttendanceTypeModel, Integer> queryBuilder = attendanceTypeDao.queryBuilder();
		
		
		try
		{
			queryBuilder.where().eq("typetame",typeName);
			//降序
			queryBuilder.orderBy("typetame", true);
			
			models = queryBuilder.query();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (models.size() != 0)
		{
			return models.get(0);
		}
		else
		{
			return null;
		}
		
		
	}

	@Override
	public List<AttendanceTypeModel> listAttendanceType()
	{
		// TODO Auto-generated method stub
		List<AttendanceTypeModel> models = new ArrayList<AttendanceTypeModel>();
		
		QueryBuilder<AttendanceTypeModel, Integer> queryBuilder = attendanceTypeDao.queryBuilder();
		//降序
		queryBuilder.orderBy("typetame", true);
		
		try
		{
			models = queryBuilder.query();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return models;
	}

	@Override
	public void deleteAllAttendanceType()
	{
		// TODO Auto-generated method stub
		DeleteBuilder< AttendanceTypeModel, Integer> deleteBuilder = attendanceTypeDao.deleteBuilder();
		
		
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
