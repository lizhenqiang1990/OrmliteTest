package com.attendance.fp.finder.impl;

import java.util.List;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import com.attendance.fp.db.dao.AdminDao;
import com.attendance.fp.db.dao.impl.AdminDaoImpl;
import com.attendance.fp.finder.AdminFinder;
import com.attendance.fp.model.AdminModel;

/**
 * 权限 数据表 获取 接口 实现
 * @author Administrator
 *
 */
@EBean
public class  AdminFinderImpl implements AdminFinder
{
	private final static String TAG = AdminFinderImpl.class.getSimpleName();

	@Bean(AdminDaoImpl.class)
	public AdminDao adminDao;
	


	@Override
	public List<AdminModel> findAdmin( )
	{
		// TODO Auto-generated method stub
		return adminDao.listAdmin();
	}
}
