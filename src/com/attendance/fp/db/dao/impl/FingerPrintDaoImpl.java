package com.attendance.fp.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

import com.attendance.fp.db.FPDatabaseHelper;
import com.attendance.fp.db.dao.FingerPrintDao;
import com.attendance.fp.model.AttendanceRecordModel;
import com.attendance.fp.model.FingerPrintModel;
import com.attendance.fp.util.LogUtil;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;


@EBean
public class FingerPrintDaoImpl implements FingerPrintDao
{
	
	private final static String TAG = FingerPrintDaoImpl.class.getSimpleName();
	
	@OrmLiteDao(helper=FPDatabaseHelper.class)
	public Dao<FingerPrintModel,Integer> fingerPrintDao;
	
	

	@Override
	public int addFingerPrint(FingerPrintModel model)
	{
		// TODO Auto-generated method stub
		try
		{
			if (fingerPrintDao.queryForEq("fingerid", Integer.valueOf(model.getFingerId())).size() == 0)
			{
				return fingerPrintDao.create(model);
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
	public int deleteFingerPrint(int fingerId)
	{
		// TODO Auto-generated method stub
		DeleteBuilder<FingerPrintModel, Integer> deleteBuilder = fingerPrintDao.deleteBuilder();
		
		try
		{
			 deleteBuilder.where().eq("fingerid", Integer.valueOf(fingerId));
			 
			 return deleteBuilder.delete();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateFingerPrint(int fingerId,String newUserId)
	{
		// TODO Auto-generated method stub
		UpdateBuilder<FingerPrintModel, Integer> updateBuilder = fingerPrintDao.updateBuilder();
		
		try
		{
			updateBuilder.updateColumnValue("userid", newUserId);
			updateBuilder.updateColumnValue("UserInfo_userid", newUserId);
			
			//更新用户id
			updateBuilder.where().eq("fingerid",Integer.valueOf(fingerId));
			
			return updateBuilder.update();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public boolean isFingerPrint(int fingerId)
	{
		// TODO Auto-generated method stub
	
		try
		{
			if (fingerPrintDao.queryForEq("fingerid", Integer.valueOf(fingerId)).size() != 0)
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
	public FingerPrintModel getFingerPrint(int fingerId)
	{
		// TODO Auto-generated method stub
		List<FingerPrintModel> list = new ArrayList<FingerPrintModel>();
		
		QueryBuilder<FingerPrintModel, Integer> queryBuilder = fingerPrintDao.queryBuilder();
		try
		{
			queryBuilder.where().eq("fingerid", Integer.valueOf(fingerId));
			list = queryBuilder.query();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (list.size() != 0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public  FingerPrintModel getFingerPrint(String userId)
	{
		// TODO Auto-generated method stub
		List<FingerPrintModel> list = new ArrayList<FingerPrintModel>();
		
		QueryBuilder<FingerPrintModel, Integer> queryBuilder = fingerPrintDao.queryBuilder();
		try
		{
			queryBuilder.where().eq("userInfo_userid", userId);
			list = queryBuilder.query();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LogUtil.d(TAG, "list.size():"+list.size()+" userId:"+userId);
		if (list.size() != 0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<FingerPrintModel> listFingerPrint()
	{
		// TODO Auto-generated method stub
		List<FingerPrintModel> list = new ArrayList<FingerPrintModel>();
		
		QueryBuilder<FingerPrintModel, Integer> queryBuilder = fingerPrintDao.queryBuilder();
		try
		{
			list = queryBuilder.query();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void deleteAllFingerPrint()
	{
	 	// TODO Auto-generated method stub
	 DeleteBuilder< FingerPrintModel, Integer> deleteBuilder = fingerPrintDao.deleteBuilder();
		
		
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
