package com.attendance.fp.finder;

import java.util.List;

import com.attendance.fp.model.AdminModel;


/**
 * 管理员 数据表 列表 获取 接口
 * @author Administrator
 *
 */
public abstract interface  AdminFinder
{

	/**
	 * 获取 管理员 列表
	 * @return
	 */
    public abstract List<AdminModel> findAdmin();
 
}
