package com.attendance.fp.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.OrmLiteDao;

import com.attendance.fp.db.FPDatabaseHelper;
import com.attendance.fp.db.dao.AdminDao;
import com.attendance.fp.model.AdminModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

@EBean
public class AdminDaoImpl implements AdminDao
{
	private final static String TAG = AdminDaoImpl.class.getSimpleName();
	
	 //--3.1开始舍弃 model参数--模型类从注解中推断
	// @OrmLiteDao(helper=FPDatabaseHelper.class, model=AdminModel.class)
	@OrmLiteDao(helper=FPDatabaseHelper.class)
	public Dao<AdminModel, Integer> adminDao;
	
	
	
	
	@Override
	public int addAdmin(AdminModel adminModel)
	{
		// TODO Auto-generated method stub
		
		try
		{
			if (adminDao.queryForEq("adminname", adminModel.getAdminName()).size() == 0)
			{
				return adminDao.create(adminModel);
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
	public int deleteAdmin(String adminName)
	{
		// TODO Auto-generated method stub
		DeleteBuilder<AdminModel, Integer> deleteBuilder = adminDao.deleteBuilder();
		
		try
		{
			deleteBuilder.where().eq("adminname",adminName);
			
			return deleteBuilder.delete();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}




	@Override
	public int updateAdmin(AdminModel adminModel)
	{
		// TODO Auto-generated method stub
		try
		{
			return adminDao.update(adminModel);
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}




	@Override
	public int updateAdmin(String adminName, boolean isAdmin)
	{
		// TODO Auto-generated method stub
		UpdateBuilder<AdminModel, Integer> updateBuilder = adminDao.updateBuilder();
		
		try
		{
			updateBuilder.updateColumnValue("isadmin", Boolean.valueOf(isAdmin));
			updateBuilder.where().eq("adminname", adminName);
			return updateBuilder.update();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}


    public  int updateAdmin(String adminName,String newMd5Key)
    {
    	UpdateBuilder<AdminModel, Integer> updateBuilder = adminDao.updateBuilder();
		
		try
		{
			updateBuilder.updateColumnValue("md5key", newMd5Key);
			updateBuilder.where().eq("adminname", adminName);
			return updateBuilder.update();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
    }


	@Override
	public boolean isAdmin(String adminName,String md5Key)
	{
		// TODO Auto-generated method stub
		List<AdminModel> list = new ArrayList<AdminModel>();
		
		QueryBuilder< AdminModel, Integer> queryBuilder = adminDao.queryBuilder();
		try
		{
			//开启了管理员且密码存在
			queryBuilder.where().eq("adminname", adminName).and().eq("md5key", md5Key).and().eq("isadmin", true);
			
			list = queryBuilder.query();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (list.size() != 0)
		{
			return true;
		}
		
		return false;

	}
	
	@Override
	public boolean isAdmin(int fingerId)
	{
		// TODO Auto-generated method stub
		List<AdminModel> list = new ArrayList<AdminModel>();
		
		QueryBuilder< AdminModel, Integer> queryBuilder = adminDao.queryBuilder();
		try
		{
			//开启了管理员且存在这个fid
			queryBuilder.where().eq("fingerid", fingerId).and().eq("isadmin", true);
			
			list = queryBuilder.query();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (list.size() != 0)
		{
			return true;
		}
		
		return false;
	}



	
	@Override
	public boolean isStart(String adminName)
	{
		// TODO Auto-generated method stub
		List<AdminModel> list = new ArrayList<AdminModel>();
		
		QueryBuilder< AdminModel, Integer> queryBuilder = adminDao.queryBuilder();
		try
		{
			queryBuilder.where().eq("adminname", adminName);
			
			list = queryBuilder.query();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (list.size() != 0)
		{
			//判断是否开启管理员
			return list.get(0).isAdmin();
		}
		
		return false;
	}






	@Override
	public List<AdminModel> listAdmin()
	{
		// TODO Auto-generated method stub
		
		List<AdminModel> models = new ArrayList<AdminModel>();
		
		QueryBuilder<AdminModel, Integer> queryBuilder = adminDao.queryBuilder();
		//降序
		queryBuilder.orderBy("adminname", true);
		
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
	public AdminModel getAdmininfo(String adminName)
	{
		// TODO Auto-generated method stub
		List<AdminModel> models = new ArrayList<AdminModel>();
		
		QueryBuilder<AdminModel, Integer> queryBuilder = adminDao.queryBuilder();
		try
		{
			queryBuilder.where().eq("adminname", adminName);
			
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
		
		return null;
		
	}




	@Override
	public void deleteAllAdmin()
	{
		// TODO Auto-generated method stub
		
		DeleteBuilder< AdminModel, Integer> deleteBuilder = adminDao.deleteBuilder();
		
		
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
