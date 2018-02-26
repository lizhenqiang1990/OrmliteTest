package com.attendance.fp.db.dao;

import java.util.List;

import com.attendance.fp.model.UserInfoModel;


/**
 * 用户信息模型 dao 操作接口
 * @author Administrator
 *
 */
public abstract interface  UserInfoDao
{

	 /**
     * 添加 一个 用户
     * @param UserInfo
     * @return
     */
    public abstract int addUserInfo(UserInfoModel model);
    
    
    /**
     * 根据用户id 删除 用户
     * @param userId 
     * @return
     */
    public abstract int deleteUserInfo(String userId);

    /**
     * 更新 用户id 信息
     * @param oldUserId  旧用户id
     * @param newUserId  新用户id
     * @return
     */
    public abstract int updateUserInfo(String oldUserId,String newUserId);
    
    
    /**
     * 更新 用户id 所对应 的 用户 信息
     * model 必须是直接从数据库获取,之后修改值重新填充到数据库中修改才行,因为根据_ID进行修改的支持
     * @param model 信息
     * @return
     */
    public abstract int updateUserInfo(UserInfoModel model);
    
    
    /**
     * 统计该用户总数
     * @return
     */
    public abstract int getUserInfoCount();
    
  
    
    /**
     * 获取所有考勤列表
     * @return
     */
    public abstract List<UserInfoModel > listUserInfo();
    
    
    
    /**
     * 获取对应用户id 信息
     * @param userId 用户id
     * @return
     */
    public abstract UserInfoModel getUserInfo(String userId);
    

    /**
     * 删除所有 用户
     */
    public abstract void deleteAllUserInfo() ;
}
