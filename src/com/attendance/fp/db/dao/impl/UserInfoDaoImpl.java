package com.attendance.fp.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

import com.attendance.fp.db.FPDatabaseHelper;
import com.attendance.fp.db.dao.UserInfoDao;
import com.attendance.fp.model.UserInfoModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;


@EBean
public class UserInfoDaoImpl implements UserInfoDao
{

	private static final String Tag = UserInfoDaoImpl.class.getSimpleName();
	
	@OrmLiteDao(helper=FPDatabaseHelper.class)
	public Dao<UserInfoModel, Integer> userInfoDao;
	
	
	
	
	@Override
	public int addUserInfo(UserInfoModel model)
	{
		// TODO Auto-generated method stub
		
		try
		{
			if (userInfoDao.queryForEq("userid", model.getUserId()).size() == 0)
			{
				return userInfoDao.create(model);
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
	public int deleteUserInfo(String userId)
	{
		// TODO Auto-generated method stub
		DeleteBuilder<UserInfoModel, Integer> deleteBuilder = userInfoDao.deleteBuilder();
				
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
	public int updateUserInfo(String oldUserId, String newUserId)
	{
		// TODO Auto-generated method stub
		try
		{
			UpdateBuilder<UserInfoModel, Integer> updateBuilder = userInfoDao.updateBuilder();
			updateBuilder.updateColumnValue("userid", newUserId);
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
	public int updateUserInfo(UserInfoModel model)
	{
		// TODO Auto-generated method stub
		
		try
		{
			if (userInfoDao.queryForEq("userid", model.getUserId()).size() != 0)
			{
				return userInfoDao.update(model);
			}
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int getUserInfoCount()
	{
		// TODO Auto-generated method stub
		List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		
		QueryBuilder<UserInfoModel, Integer> queryBuilder = userInfoDao.queryBuilder();
		
		try
		{

			list = queryBuilder.query();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list.size();
	}

	@Override
	public List<UserInfoModel> listUserInfo()
	{
		// TODO Auto-generated method stub
		List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		
		QueryBuilder<UserInfoModel, Integer> queryBuilder = userInfoDao.queryBuilder();
		
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
	public UserInfoModel getUserInfo(String userId)
	{
		// TODO Auto-generated method stub
	    List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		
		QueryBuilder<UserInfoModel, Integer> queryBuilder = userInfoDao.queryBuilder();
		
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
	public void deleteAllUserInfo()
	{
		// TODO Auto-generated method stub
		DeleteBuilder<UserInfoModel, Integer> deleteBuilder = userInfoDao.deleteBuilder();
		
		try
		{
			 deleteBuilder.delete();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
