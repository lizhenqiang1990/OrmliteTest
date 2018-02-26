package com.attendance.fp.db.dao;

import java.util.List;

import com.attendance.fp.model.AdminModel;


/**
 * 权限 Dao 操作 接口
 * @author Administrator
 *
 */
public abstract interface  AdminDao
{
	 /**
     * 添加 Admin
     * @param Admin
     * @return
     */
    public abstract int addAdmin(AdminModel adminModel);
    
    
    /**
     * 根据管理员名称 删除Admin
     * @param adminName
     * @return
     */
    public abstract int deleteAdmin(String adminName);
    
    
    /**
     * 更新admin 信息
     * model必须是直接从数据库获取,之后修改值重新填充到数据库中修改才行,因为根据_ID进行修改的支持
     * @param adminModel
     * @return
     */
    public abstract int updateAdmin(AdminModel adminModel);
    
    
    /**
     * 根据名称 更新 管理员开关
     * @param adminName 管理员名称
     * @param isAdmin 管理员标志位
     * @return
     */
    public abstract int updateAdmin(String adminName,boolean isAdmin);
    
    
    
    /**
     * 修改密码
     * @param adminName 管理员名称
     * @param newMd5Key 新md5密码
     * @return
     */
    public abstract int updateAdmin(String adminName,String newMd5Key);
    
    
    /**
     * 使用管理员名称  判断 开启使用
     * @param adminName 管理员名称
     * @return
     */
    public abstract boolean isStart(String adminName);
    
    /**
     * 使用指纹id  判断该是否为管理员
     * (fid+开关关联)
     * @param fingerId 指纹id
     * @return
     */
    public abstract boolean isAdmin(int fingerId);
    
    /**
     * 使用密钥  判断该是否为管理员
     * (用户+密码+开关关联)
     * @param md5Key 密码
     * @return
     */
    public abstract boolean isAdmin(String adminName,String md5Key);
    
    
    /**
     * 获取管理员信息列表
     * @return
     */
    public abstract List<AdminModel > listAdmin();
    
    
    
    /**
     * 根据用户id获取管理员信息
     * @param adminName 管理员名称
     * @return
     */
    public abstract AdminModel getAdmininfo(String adminName);
    
    
    /**
     * 删除所有 管理员
     */
    public abstract void deleteAllAdmin() ;
    
}
