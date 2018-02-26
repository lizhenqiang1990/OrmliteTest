package com.attendance.fp.db;

import com.attendance.fp.model.AdminModel;
import com.attendance.fp.model.AttendanceCountModel;
import com.attendance.fp.model.AttendanceRecordModel;
import com.attendance.fp.model.AttendanceTypeModel;
import com.attendance.fp.model.FingerPrintModel;
import com.attendance.fp.model.UserInfoModel;
import com.attendance.fp.util.LogUtil;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;









import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import java.sql.SQLException;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class FPDatabaseHelper extends OrmLiteSqliteOpenHelper 
{
	 private final static String TAG = "FPDatabaseHelper";
	
    private static final String DATABASE_NAME = "FPOrmlite.db";
    private static final int DATABASE_VERSION = 1;
    
    /**
     * Interface Dao<T,ID>
     * T - The class that the code will be operating on.
	 * ID - The class of the ID column associated with the class. The T class does not require an ID field. 
	 * The class needs an ID parameter however so you can use Void or Object to satisfy the compiler.
     */
  
    private Dao<UserInfoModel, Integer> userInfoDao;
    private Dao<FingerPrintModel, Integer> fingerPrintDao;
    private Dao<AttendanceTypeModel, Integer> attendanceTypeDao;
    private Dao<AttendanceRecordModel, Integer> attendanceRecordDao;
    private Dao<AttendanceCountModel, Integer> attendanceCountDao;
    private Dao<AdminModel, Integer> adminDao;
    
    /**
     * 数据库 操作 帮助类
     * @param context
     */
    public FPDatabaseHelper(Context context) 
    {
		// 第一个参数是应用的上下文
		// 第二个参数是应用的数据库名字
		// 第三个参数CursorFactory指定在执行查询时获得一个游标实例的工厂类,设置为null,代表使用系统默认的工厂类
		// 第四个参数是数据库版本，必须是大于0的int
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		LogUtil.d(TAG, "FPDatabaseHelper  FPDatabaseHelper 1!");
    }
    
    //继承父类
	public FPDatabaseHelper(Context context, String name,
			CursorFactory factory, int version)
	{
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		LogUtil.d(TAG, "FPDatabaseHelper  FPDatabaseHelper 2!");
	}
	
    /**
     * 创建表
     */
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) 
    {
    	LogUtil.d(TAG, "FPDatabaseHelper  onCreate!");
        try 
        {
            TableUtils.createTable(connectionSource, UserInfoModel.class);
            TableUtils.createTable(connectionSource, FingerPrintModel.class);
            TableUtils.createTable(connectionSource, AttendanceTypeModel.class);
            TableUtils.createTable(connectionSource, AttendanceRecordModel.class);
            TableUtils.createTable(connectionSource, AttendanceCountModel.class);
            TableUtils.createTable(connectionSource, AdminModel.class);
            return;
            
        } 
        catch(SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 版本更新之后的操作
     */
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int arg2, int arg3) 
    {
    	LogUtil.d(TAG, "FPDatabaseHelper  onUpgrade!");
        try
        {
        	//先删
            TableUtils.dropTable(connectionSource, UserInfoModel.class, true);
            TableUtils.dropTable(connectionSource, FingerPrintModel.class, true);
            TableUtils.dropTable(connectionSource, AttendanceTypeModel.class, true);
            TableUtils.dropTable(connectionSource, AttendanceRecordModel.class, true);
            TableUtils.dropTable(connectionSource, AttendanceCountModel.class, true);
            TableUtils.dropTable(connectionSource, AdminModel.class, true);
            //重新创建
            onCreate(db, connectionSource);
            return;
        }
        catch(SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    /**
     * getDao(Class<T> clazz) throws SQLException
     * 获取用户信息 dao
     * @return
     * @throws SQLException
     */
    public Dao<UserInfoModel, Integer> getUserInfoDao() throws SQLException {
        if(userInfoDao == null) {
        	userInfoDao = getDao(UserInfoModel.class);
        }
        return userInfoDao;
    }
    
    /**
     * 获取指纹dao
     * @return
     * @throws SQLException
     */
    public Dao<FingerPrintModel, Integer> getFingerPrintDao() throws SQLException {
        if(fingerPrintDao == null) {
        	fingerPrintDao = getDao(FingerPrintModel.class);
        }
        return fingerPrintDao;
    }
    
    /**
     * 获取考勤类型 dao
     * @return
     * @throws SQLException
     */
    public Dao<AttendanceTypeModel, Integer> getAttendanceTypeDao() throws SQLException {
        if(attendanceTypeDao == null) {
        	attendanceTypeDao = getDao(AttendanceTypeModel.class);
        }
        return attendanceTypeDao;
    }
    
    /**
     * 获取考勤记录 dao
     * @return
     * @throws SQLException
     */
    public  Dao<AttendanceRecordModel, Integer> getAttendanceRecordDao() throws SQLException {
        if(attendanceRecordDao == null) {
        	attendanceRecordDao = getDao(AttendanceRecordModel.class);
        }
        return attendanceRecordDao;
    }
    
    /**
     * 获取考勤统计 dao
     * @return
     * @throws SQLException
     */
    public  Dao<AttendanceCountModel, Integer> getAttendanceCountDao() throws SQLException {
        if(attendanceCountDao == null) {
        	attendanceCountDao = getDao(AttendanceCountModel.class);
        }
        return attendanceCountDao;
    }
    
    /**
     * 获取 权限 dao
     * @return
     * @throws SQLException
     */
    public  Dao<AdminModel, Integer> getAdminDao() throws SQLException {
        if(adminDao == null) {
        	adminDao = getDao(AdminModel.class);
        }
        return adminDao;
    }
    
   
    
    public void close() 
    {
        super.close();
        adminDao = null;
        attendanceCountDao = null;
    }
}
