package com.attendance.fp.db.dao;

import java.util.List;

import com.attendance.fp.model.AttendanceTypeModel;


/**
 * 考勤类型 dao 接口
 * @author Administrator
 *
 */
public abstract interface  AttendanceTypeDao
{
	 /**
     * 添加 考勤类型
     * @param model
     * @return
     */
    public abstract int addAttendanceType(AttendanceTypeModel model);
    
    
    /**
     * 根据类型名称 删除签到类型
     * @param typeName
     * @return
     */
    public abstract int deleteAttendanceType(String typeName);
    
    
    /**
     * 更新签到类型 信息
     * model 必须是直接从数据库获取,之后修改值重新填充到数据库中修改才行,因为根据_ID进行修改的支持
     * @param AttendanceTypeModel
     * @return
     */
    public abstract int updateAttendanceType(AttendanceTypeModel model);
    
    
    /**
     * 修改类型名称
     * @param typeName 旧签到类型名称
     * @param matchType 新签到类型名称
     * @return
     */
    public abstract int updateAttendanceType(String oldTypeName, String newTypeName);
    
    /**
     *  修改配对类型
     * @param typeName 签到类型名称
     * @param matchType 需要修改的配对名称
     * @return
     */
    public abstract int updateAttendanceType(String typeName, boolean isStart);
    

    
    
    /**
     * 判断类型是否存在
     * @param typeName 类型名称
     * @return
     */
    public abstract boolean isAttendanceType(String typeName);
    
    /**
     * 判断类型是否开启
     * @param typeName 类型名称
     * @return
     */
    public abstract boolean isStart(String typeName);
    
    /**
     * 根据 类型名称 获取签到类型
     * @param typeName 类型名称
     * @return
     */
    public abstract AttendanceTypeModel  getAttendanceType(String typeName);
    
    
    /**
     * 获取签到类型 列表
     * @return
     */
    public abstract List<AttendanceTypeModel > listAttendanceType();
    

    /**
     * 删除所有 签到类型
     */
    public abstract void deleteAllAttendanceType() ;
}
