package com.attendance.fp.finder;

import java.util.List;

import com.attendance.fp.model.UserInfoModel;

public abstract interface UserInfoFinder
{
	 public abstract List<UserInfoModel> findUserInfo();
}
