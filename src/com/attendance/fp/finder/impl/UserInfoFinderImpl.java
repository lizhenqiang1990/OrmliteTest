package com.attendance.fp.finder.impl;

import java.util.List;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import com.attendance.fp.db.dao.UserInfoDao;
import com.attendance.fp.db.dao.impl.UserInfoDaoImpl;
import com.attendance.fp.finder.UserInfoFinder;
import com.attendance.fp.model.UserInfoModel;

@EBean
public class UserInfoFinderImpl implements UserInfoFinder
{
	private final static String TAG = UserInfoFinderImpl.class.getSimpleName();
	
	@Bean(UserInfoDaoImpl.class)
	public UserInfoDao userInfoDao;
	
	@Override
	public List<UserInfoModel> findUserInfo()
	{
		// TODO Auto-generated method stub
		return userInfoDao.listUserInfo();
	}

}
