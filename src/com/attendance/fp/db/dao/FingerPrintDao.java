package com.attendance.fp.db.dao;

import java.util.List;

import com.attendance.fp.model.FingerPrintModel;

/**
 * 指纹 模型 表 操作接口
 * @author Administrator
 *
 */
public abstract interface  FingerPrintDao
{
	
	 /**
     * 添加 指纹记录
     * @param model
     * @return
     */
    public abstract int addFingerPrint(FingerPrintModel model);
    
    
    /**
     * 根据指纹id  删除 指纹记录
     * @param fingerId 指纹id
     * @return
     */
    public abstract int deleteFingerPrint(int fingerId);
    
    
    /**
     * 更新 指纹记录
     * 如:id 和 模版信息
     * @param FingerPrintModel
     * @return
     */
    public abstract int updateFingerPrint(int fid,String newUserId);
    
    
    /**
     * 判断 指纹id 是否存在
     * @param fingerId 指纹id
     * @return
     */
    public abstract boolean isFingerPrint(int fingerId);
    
    /**
     * 根据 指纹id 获取指纹记录
     * @param fingerId 指纹id
     * @return
     */
    public abstract FingerPrintModel  getFingerPrint(int fingerId);
    
    
    /**
     * 根据 用户id 获取指纹记录
     * @param userId 用户id
     * @return
     */
    public abstract FingerPrintModel  getFingerPrint(String userId);
    
    
    /**
     * 获取 指纹 列表
     * @return
     */
    public abstract List<FingerPrintModel > listFingerPrint();
    

    /**
     * 删除所有 指纹记录
     */
    public abstract void deleteAllFingerPrint() ;
}
