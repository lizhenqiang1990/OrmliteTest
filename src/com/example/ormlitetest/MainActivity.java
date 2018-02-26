package com.example.ormlitetest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import com.attendance.fp.db.dao.AdminDao;
import com.attendance.fp.db.dao.AttendanceCountDao;
import com.attendance.fp.db.dao.AttendanceRecordDao;
import com.attendance.fp.db.dao.AttendanceTypeDao;
import com.attendance.fp.db.dao.FingerPrintDao;
import com.attendance.fp.db.dao.UserInfoDao;
import com.attendance.fp.db.dao.impl.AdminDaoImpl;
import com.attendance.fp.db.dao.impl.AttendanceCountDaoImpl;
import com.attendance.fp.db.dao.impl.AttendanceRecordDaoImpl;
import com.attendance.fp.db.dao.impl.AttendanceTypeDaoImpl;
import com.attendance.fp.db.dao.impl.FingerPrintDaoImpl;
import com.attendance.fp.db.dao.impl.UserInfoDaoImpl;
import com.attendance.fp.finder.AdminFinder;
import com.attendance.fp.finder.AttendanceCountFinder;
import com.attendance.fp.finder.AttendanceRecordFinder;
import com.attendance.fp.finder.AttendanceTypeFinder;
import com.attendance.fp.finder.FingerPrintFinder;
import com.attendance.fp.finder.UserInfoFinder;
import com.attendance.fp.finder.impl.AdminFinderImpl;
import com.attendance.fp.finder.impl.AttendanceCountFinderImpl;
import com.attendance.fp.finder.impl.AttendanceRecordFinderImpl;
import com.attendance.fp.finder.impl.AttendanceTypeFinderImpl;
import com.attendance.fp.finder.impl.FingerPrintFinderImpl;
import com.attendance.fp.finder.impl.UserInfoFinderImpl;
import com.attendance.fp.model.AdminModel;
import com.attendance.fp.model.AttendanceCountModel;
import com.attendance.fp.model.AttendanceRecordModel;
import com.attendance.fp.model.AttendanceTypeModel;
import com.attendance.fp.model.FingerPrintModel;
import com.attendance.fp.model.UserInfoModel;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends Activity
{
	private final static String TAG = MainActivity.class.getSimpleName();
 
	@Bean(AdminDaoImpl.class)
	public AdminDao adminDao;
	
	@Bean(AttendanceTypeDaoImpl.class)
	public AttendanceTypeDao attendanceTypeDao;
	
	@Bean(AttendanceCountDaoImpl.class)
	public AttendanceCountDao attendanceCountDao;
	
	@Bean(AttendanceRecordDaoImpl.class)
	public AttendanceRecordDao attendanceRecordDao;
	
	@Bean(FingerPrintDaoImpl.class)
	public FingerPrintDao fingerPrintDao;
	
	@Bean(UserInfoDaoImpl.class)
	public UserInfoDao userInfoDao;
	
	
	
	
	@Bean(AdminFinderImpl.class)
	public AdminFinder adminFinder;
	
	@Bean(AttendanceTypeFinderImpl.class)
	public AttendanceTypeFinder attendanceTypeFinder;
	
	@Bean(AttendanceCountFinderImpl.class)
	public AttendanceCountFinder attendanceCountFinder;
	
	@Bean(AttendanceRecordFinderImpl.class)
	public AttendanceRecordFinder attendanceRecordFinder;
	
	@Bean(FingerPrintFinderImpl.class)
	public FingerPrintFinder fingerPrintFinder;
	
	@Bean(UserInfoFinderImpl.class)
	public UserInfoFinder userInfoFinder;
	

	@AfterInject
	public void afterInject()
	{
		
	}
	
	@AfterViews
	public void afterViews()
	{
		 timeConvertDate();
		
		//用户--操作测试
		addUser("123456","李振强");
		addUser("234567","李平");
		printAllUser();
//		updateUser("123456","123");
//		printUser("123");
//		deleteUser("123");
//		printAllUser();
//		deleteAllUser();
//		printAllUser();
		
		
		//指纹操作测试--指纹id和用户id
		addFp(1,"123456");
		//两种方式分别查询打印指纹
		printFP(1,"123456");
//		//一开始绑定 123456 现在用户id修改为234567
//		updatefp(1,"234567");
//		//打印
//		printFP(1,"234567");
//		//打印全部
//		printAllFP();
//		//删除
//		deletefp(1);
//		//删除所有
//		deleteAllfp();
//		//打印全部
//		printAllFP();
		
		
		//考勤测试
		//添加记录
		addrecord("123456", 2015, 1, 10);
		addrecord("123456", 2015, 2, 11);
		addrecord("123456", 2015, 3, 12);
		addrecord("789456", 2015, 1, 10);
		addrecord("789456", 2015, 1, 10);
		addrecord("789456", 2015, 3, 11);
		addrecord("789456", 2015, 4, 11);
		//打印全部
		printAllRecord();
//		//修改名称
//		updateRecord("123456", "234567");
//		//打印全部
//		printAllRecord();
//		//删除某一个用户记录
//		deleteRecord("234567");
//		printRecord("234567");
//		//固定用户+日期
//		printRecord("789456", 2015, 1, 10);
//		deleteRecord("789456", 2015, 1, 10);
//		printRecord("789456", 2015, 0, 11);
//		//打印全部
//		printAllRecord();
//		//删除全部
//		deleteAllRecord();
//		//打印全部
//		printAllRecord();
		
		//管理员表测试
		//添加管理员
		addAdmin("李振强","abcdefghijkemnopqrstuvwxyz",true,1);
		addAdmin("李鹏","abcdefghijkemnopqrstuvwxyz",false,2);
		//实验各种判断
		isadmin("李振强","abcdefghijkemnopqrstuvwxyz",1);
		isadmin("李鹏","abcdefghijkemnopqrstuvwxyz",2);
		//打印所有
		printAllAdmin();
//		//修改一个管理员
//		updateAdmin("李振强", false);
//		updateAdmin("李鹏", "abcdefsfsfdsfstuvwxyz");
//		//打印所有
//		printAllAdmin();
//		//删除管理员
//		deleteAdmin("李鹏");
//		//打印信息
//		printAdmin("李鹏");
//		//重新获取之后修改所有在填充修改
//		updateAdmin("李振强","nihao!",true,10);
//		//打印所有
//		printAllAdmin();
//		//删除所有
//		deleteAllAdmin();
//		//打印所有
//		printAllAdmin();
		
		//考勤统计实验
		//添加考勤统计
		addCount("123456",1,2,3,4,2015,2);
		addCount("123456",1,2,3,4,2015,3);
		addCount("123456",1,2,3,4,2015,4);
		addCount("100245",1,2,3,4,2015,2);
		//打印所有
		printAllCount();
//		//修改统计
//		updateCount("123456","234567");
//		//打印
//		printCount("234567", 2015, 2);
//		//更新统计
//		updateCount("234567", 2015, 2, 4, 3, 2, 1);
//		//打印
//		printCount("234567", 2015, 2);
//		//删除一条
//		deleteCount("234567", 2015, 2);
//		//打印
//		printCount("234567", 2015, 2);
//		//删除一条
//		deleteCount("234567");
//		//打印所有
//		printAllCount();
//		//删除所有
//		deleteAllCount();
//		//打印所有
//		printAllCount();
		
		
		
		//实验 考勤类型操作
		//添加一个考勤类型
		addType("上班", "下班", true, 0, 1, 1423703400000L);
		addType("下班", "上班", true, 1, 1, 1423733400000L);
		//打印所有
		printAllType();
		//修改一个类型名称
		updateType("上班", "加班");
		updateType("加班", false);
		//打印
		printType("加班");
		//删除
		deleteType("加班");
		//打印所有
		printAllType();
		//修改信息
		updateType("下班",  "加班", false, 1, 0, 1423744200000L);
		//打印
		printAllType();
		//删除所有
		deleteAllType();
		//打印所有
		printAllType();

	}
	
	/**
	 * 添加一个考勤类型
	 */
	public void addType(String typeName,String matchType,boolean isStart,
			int priority,int startMode,long startTime)
	{
		AttendanceTypeModel model = new AttendanceTypeModel();

		model.setTypeName(typeName);
		model.setMatchType(matchType);
		model.setIsStart(isStart);
		model.setPriority(priority);
		model.setStartMode(startMode);
		model.setStartTime(startTime);
		
		attendanceTypeDao.addAttendanceType(model);
	}
	
	/**
	 * 修改考勤类型名称
	 */
	public void updateType(String oldTypeName,String newTypeName)
	{
		attendanceTypeDao.updateAttendanceType(oldTypeName, newTypeName);
	}
	
	/**
	 * 修改考勤类型开关
	 */
	public void updateType(String typeName,boolean isStart)
	{
		attendanceTypeDao.updateAttendanceType(typeName, isStart);
	}
	
	/**
	 * 修改考勤类型信息
	 */
	public void updateType(String typeName,String matchType,boolean isStart,
			int priority,int startMode,long startTime)
	{
		AttendanceTypeModel model = new AttendanceTypeModel();

		model = attendanceTypeDao.getAttendanceType(typeName);
		
		model.setTypeName(typeName);
		model.setMatchType(matchType);
		model.setIsStart(isStart);
		model.setPriority(priority);
		model.setStartMode(startMode);
		model.setStartTime(startTime);
		
		attendanceTypeDao.updateAttendanceType(model);
	}
	
	/**
	 * 删除一个考勤类型
	 */
	public void deleteType(String typeName)
	{
		attendanceTypeDao.deleteAttendanceType(typeName);
	}
	
	/**
	 * 删除所有考勤类型
	 */
	public void deleteAllType()
	{
		attendanceTypeDao.deleteAllAttendanceType();
	}
	
	/**
	 * 打印一个考勤类型信息
	 */
	public void printType(String typeName)
	{
		AttendanceTypeModel model = new AttendanceTypeModel();
		
		model = attendanceTypeDao.getAttendanceType(typeName);
		
		if (model == null)
		{
			Log.d(TAG, "printType model == null");
			return ;
		}
		
		Log.d(TAG, "printType typeName:"+model.getTypeName()
		+" startTime"+model.getStartTime()
		+" isStart"+model.getIsStart()
		+" matchType"+model.getMatchType()
		+" priority"+model.getPriority()
		+" startMode"+model.getStartMode());
	}
	
	/**
	 * 打印所有考勤类型信息
	 */
	public void printAllType()
	{
		List<AttendanceTypeModel> list = new ArrayList<AttendanceTypeModel>();
		
		list = attendanceTypeFinder.findAttendanceType();
		if (list.size() == 0)
		{
			Log.d(TAG, "printAllType list.size() == 0");
			return ;
		}
		
		for (AttendanceTypeModel model: list)
		{
			Log.d(TAG, "printAllType typeName:"+model.getTypeName()
					+" startTime"+model.getStartTime()
					+" isStart"+model.getIsStart()
					+" matchType"+model.getMatchType()
					+" priority"+model.getPriority()
					+" startMode"+model.getStartMode());
		}
		
		
	}
	
	
	
	/**
	 * 添加一个统计表
	 */
	public void addCount(String userId,int signTatol,int lateTatol,
			int absenteeismTatol,int forgetTatol,int year,int month)
	{
		AttendanceCountModel model = new AttendanceCountModel();
		UserInfoModel userInfoModel = new UserInfoModel();
		model.setUserId(userId);
		model.setSignTatol(signTatol);
		model.setAbsenteeismTatol(absenteeismTatol);
		model.setLateTatol(lateTatol);
		model.setForgetTatol(forgetTatol);
		model.setYear(year);
		model.setMonth(month);
		
		userInfoModel.setUserId(userId);
		model.setUserInfoModel(userInfoModel);
		
		attendanceCountDao.addAttendanceCount(model);
		
	}
	/**
	 * 修改一个统计表
	 */
	public void updateCount(String oldUserId,String newUserId)
	{
		attendanceCountDao.updateAttendanceCount(oldUserId, newUserId);
	}
	
	public void updateCount(String userId,int year,int month,
			int signTatol,int lateTatol,
			int absenteeismTatol,int forgetTatol)
	{
		AttendanceCountModel model = new AttendanceCountModel();
		model.setUserId(userId);
		model.setSignTatol(signTatol);
		model.setAbsenteeismTatol(absenteeismTatol);
		model.setLateTatol(lateTatol);
		model.setForgetTatol(forgetTatol);
		
		attendanceCountDao.updateAttendanceCount(model, userId,year,month);
	}
	
	/**
	 * 删除某个用户的统计表
	 */
	public void deleteCount(String userId)
	{
		attendanceCountDao.deleteAttendanceCount(userId);
	}
	
	/**
	 * 删除某个用户某个时间段的统计表
	 */
	public void deleteCount(String userId,int year,int month)
	{
		attendanceCountDao.deleteAttendanceCount(userId,year,month);
	}
	
	/**
	 * 删除所有统计表
	 */
	public void deleteAllCount()
	{
		attendanceCountDao.deleteAllAttendanceCount();
	}
	/**
	 * 打印某个统计表
	 */
	public void printCount(String userId,int year,int month)
	{
		AttendanceCountModel model = new AttendanceCountModel();
		UserInfoModel userInfoModel = new UserInfoModel();
		
		model = attendanceCountDao.getAttendanceinfo(userId,year,month);
		if (model == null)
		{
			Log.d(TAG, "printCount model= null");
			return;
		}
		
		userInfoModel = model.getUserInfoModel();
		if (userInfoModel == null)
		{//说明没有这个用户
			
			Log.d(TAG, "printCount userId1:"+model.getUserId()
					+" SignTatol:"+model.getSignTatol()
					+" year:"+model.getYear()
					+" month:"+model.getMonth()
					+" userInfoModel=null");
			return;
		}
		
		Log.d(TAG, "printCount userId1:"+model.getUserId()
				+" SignTatol:"+model.getSignTatol()
				+" year:"+model.getYear()
				+" month:"+model.getMonth()
				+" userId2:"+userInfoModel.getUserId()
				+" username:"+userInfoModel.getUserName());
		
	}
	/**
	 * 打印所有统计表
	 */
	public void printAllCount()
	{
		List<AttendanceCountModel> list = new ArrayList<AttendanceCountModel>();
		
		UserInfoModel userInfoModel = new UserInfoModel();
		
		list = attendanceCountFinder.findAttendanceCount();
		
		if (list.size() == 0)
		{
			Log.d(TAG, "printAllCount null");
			return;
		}
		
		for (AttendanceCountModel model: list )
		{
			userInfoModel = model.getUserInfoModel();
			if (userInfoModel == null)
			{//说明没有这个用户
				
				Log.d(TAG, "printAllCount userId1:"+model.getUserId()
						+" SignTatol:"+model.getSignTatol()
						+" year:"+model.getYear()
						+" month:"+model.getMonth()
						+" userInfoModel=null");
				continue;
			}
			
			Log.d(TAG, "printAllCount userId1:"+model.getUserId()
					+" SignTatol:"+model.getSignTatol()
					+" year:"+model.getYear()
					+" month:"+model.getMonth()
					+" userId2:"+userInfoModel.getUserId()
					+" username:"+userInfoModel.getUserName());
		}
	}
	
	
	/**
	 * 添加一个管理员
	 */
	public void addAdmin(String adminName,String md5Key,boolean isAdmin,int fingerId)
	{
		AdminModel adminModel = new AdminModel();
		
		adminModel.setAdminName(adminName);
		adminModel.setFingerId(fingerId);
		adminModel.setIsAdmin(isAdmin);
		adminModel.setMd5Key(md5Key);
		
		adminDao.addAdmin(adminModel);
	}
	
	/**
	 * 修改一个管理员开关
	 */
	public void updateAdmin(String adminName,boolean isAdmin)
	{
		adminDao.updateAdmin(adminName,isAdmin);
	}
	
	/**
	 * 修改一个管理员密码
	 */
	public void updateAdmin(String adminName,String md5Key)
	{
		adminDao.updateAdmin(adminName,md5Key);
	}
	
	/**
	 * 修改一个管理员信息
	 */
	public void updateAdmin(String adminName,String md5Key,boolean isAdmin,int fingerId)
	{
		AdminModel adminModel = new AdminModel();
		//查询一个
		adminModel = adminDao.getAdmininfo(adminName);
		adminModel.setAdminName("李平");
		adminModel.setFingerId(fingerId);
		adminModel.setIsAdmin(isAdmin);
		adminModel.setMd5Key(md5Key);
		
		adminDao.updateAdmin(adminModel);
	}
	/**
	 * 删除一个管理员
	 */
	public void deleteAdmin(String adminName)
	{
		adminDao.deleteAdmin(adminName);
	}
	
	/**
	 * 删除所有管理员
	 */
	
	public void deleteAllAdmin()
	{
		adminDao.deleteAllAdmin();
	}
	/**
	 * 判断密码是否正确,是否开起
	 */
	public void isadmin(String adminName,String md5Key,int fingerId)
	{
		boolean bl = false;
		//是否开启服务
		bl = adminDao.isStart(adminName);
		Log.d(TAG, "adminName:"+adminName+" isStart "+bl);
		
		//判断是否密码一样
		bl = adminDao.isAdmin(fingerId);
		Log.d(TAG, "fingerId:"+fingerId+" isAdmin "+bl);
		
		//判断是否有这个指纹id
		bl = adminDao.isAdmin(adminName,md5Key);
		Log.d(TAG, "md5Key:"+md5Key+" isAdmin "+bl);

	}
	
	/**
	 * 显示一个管理员信息
	 */
	public void printAdmin(String adminName)
	{
		AdminModel adminModel = new AdminModel();
		adminModel = adminDao.getAdmininfo(adminName);
		
		if (adminModel == null)
		{
			Log.d(TAG, "printAdmin adminModel= null");
			return;
		}
		
		Log.d(TAG, "printAdmin: adminname:"+adminModel.getAdminName()
				+" isadmin:"+adminModel.isAdmin()
				+" md5key:"+adminModel.getMd5Key()
				+" fingerid:"+adminModel.getFingerId());
	}
	
	/**
	 * 显示所有管理员信息
	 */
	public void printAllAdmin()
	{
		List< AdminModel> list = new ArrayList<AdminModel>();
		
		list = adminFinder.findAdmin();
		
		if (list.size() == 0)
		{
			Log.d(TAG, "printAllAdmin  list.size()= 0");
			return;
		}
		
		for (AdminModel adminModel: list)
		{
			Log.d(TAG, "printAdmin: adminname:"+adminModel.getAdminName()
					+" isadmin:"+adminModel.isAdmin()
					+" md5key:"+adminModel.getMd5Key()
					+" fingerid:"+adminModel.getFingerId());
		}
	}
	
	
	
	/**
	 * 时间换算
	 */
	public void timeConvertDate()
	{
		 //时间换算
		long  time = System.currentTimeMillis(); 
		
		Log.d(TAG, "time:"+time);
		
		//把值换算成时间戳
		String dateTime = new java.text.SimpleDateFormat("yyyy年MM月dd日 E HH时mm分ss秒").format(new java.util.Date(1423584000000L));
		
		Log.d(TAG, "date:"+dateTime);
		
		try
		{
			//把时间戳转换成值
			Date date = new java.text.SimpleDateFormat("yyyy年MM月dd日 E HH时mm分ss秒").parse("2015年02月11日 周三 00时00分00秒");
			
			Log.d(TAG, "time1:"+date.getTime()+" time2:"+Long.valueOf(date.getTime()));
		} 
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 添加一个用户
	 */
	private void addUser(String userId,String userName)
	{
		//添加一个用户
		UserInfoModel userInfoModel = new UserInfoModel();
		
		userInfoModel.setUserAge(23);
		userInfoModel.setUserDepartment("研发");
		userInfoModel.setUserId(userId);
		userInfoModel.setUserEmail("1456544@qq.com");
		userInfoModel.setUserName(userName);
		userInfoModel.setUserPhone("18518756504");
		userInfoModel.setUserSex(1);
		userInfoModel.setUserSupplement("nihao!");
		
		userInfoDao.addUserInfo(userInfoModel);
				
	}
	
	/**
	 * 更新 用户id
	 */
	private void updateUser(String oldUserId,String newUserId)
	{
		userInfoDao.updateUserInfo(oldUserId, newUserId);
	}
	
	/**
	 * 删除记录
	 */
	private void deleteUser(String UserId)
	{
		userInfoDao.deleteUserInfo(UserId);
	}
	
	/**
	 * 删除所有记录
	 */
	private void deleteAllUser( )
	{
		userInfoDao.deleteAllUserInfo();
	}
	
	/**
	 * 打印用户记录
	 */
	private void printUser(String userId)
	{
		
		UserInfoModel userInfoModel = userInfoDao.getUserInfo(userId);
		
		if (userInfoModel == null)
		{
			Log.d(TAG, "printUser null");
			return;
		}
		
		Log.d(TAG, "printUser: UserName:"+userInfoModel.getUserName()
			+" userid:"+userInfoModel.getUserId()
			+" userage:"+userInfoModel.getUserAge()
			);
		
	}
	/**
	 * 打印用户记录
	 */
	private void printAllUser( )
	{
		List<UserInfoModel> list = userInfoFinder.findUserInfo();
		
		if (list.size() == 0)
		{
			Log.d(TAG, "printAllUser null");
			return;
		}
		
		for (UserInfoModel userInfoModel: list)
		{
			Log.d(TAG, "printAllUser: UserName:"+userInfoModel.getUserName()
				+" userid:"+userInfoModel.getUserId()
				+" userage:"+userInfoModel.getUserAge()
				);
		}
	}
	/**
	 * 添加一个考勤
	 */
	public void addrecord(String userId,int year,int month,int day)
	{
		AttendanceRecordModel model = new AttendanceRecordModel();
		UserInfoModel userInfoModel = new UserInfoModel();
		//年月日
		model.setYear(year);
		model.setMonth(month);
		model.setDay(day);
		
		model.setSignType(1);
		model.setUserId(userId);
		userInfoModel.setUserId(userId);
		
		//设置外键
		model.setUserInfoModel(userInfoModel);
		
		attendanceRecordDao.addAttendanceRecord(model);
	}
	
	/**
	 * 修改 考勤记录中用户名称
	 */
	public void updateRecord(String oldUserId,String newUserId)
	{
		attendanceRecordDao.updateAttendanceRecord(oldUserId, newUserId);
	}

	/**
	 * 删除某人的考勤
	 */
	public void deleteRecord(String userId)
	{
		attendanceRecordDao.deleteAttendanceRecord(userId);
	}
	
	/**
	 * 删除某天的某人的考勤
	 */
	public void deleteRecord(String userId,int year,int month,int day)
	{
		attendanceRecordDao.deleteAttendanceRecord(userId, year, month, day);
	}
	
	/**
	 * 删除所有考勤
	 */
	public void deleteAllRecord()
	{
		attendanceRecordDao.deleteAllAttendanceRecord();
	}
	/**
	 * 打印一个用户
	 */
	public void printRecord(String userId)
	{
		List<AttendanceRecordModel> list = new ArrayList<AttendanceRecordModel>();
		UserInfoModel userInfoModel = new UserInfoModel();
		
		list = attendanceRecordFinder.findAttendanceRecord(userId);
		if (list.size() == 0)
		{
			Log.d(TAG, "printRecord null");
			return;
		}
		
		for (AttendanceRecordModel model: list )
		{
			userInfoModel = model.getUserInfoModel();
			if (userInfoModel == null)
			{//说明没有这个用户
				
				Log.d(TAG, "printRecord userId1:"+model.getUserId()
						+" signtype:"+model.getSignType()
						+" year:"+model.getYear()
						+" month:"+model.getMonth()
						+" day:"+model.getDay()
						+" userInfoModel=null");
				continue;
			}
			
			Log.d(TAG, "printRecord userId1:"+model.getUserId()
					+" signtype:"+model.getSignType()
					+" year:"+model.getYear()
					+" month:"+model.getMonth()
					+" day:"+model.getDay()
					+" userId2:"+userInfoModel.getUserId()
					+" username:"+userInfoModel.getUserName());
		}
	}
	
	/**
	 * 打印一个用户
	 */
	public void printRecord(String userId,int year,int month,int day)
	{
		List<AttendanceRecordModel> list = new ArrayList<AttendanceRecordModel>();
		UserInfoModel userInfoModel = new UserInfoModel();
		
		list = attendanceRecordFinder.findAttendanceRecord(userId, year, month, day);
		if (list.size() == 0)
		{
			Log.d(TAG, "printRecord null");
			return;
		}
		
		for (AttendanceRecordModel model: list )
		{
			userInfoModel = model.getUserInfoModel();
			if (userInfoModel == null)
			{//说明没有这个用户
				
				Log.d(TAG, "printRecord userId1:"+model.getUserId()
						+" signtype:"+model.getSignType()
						+" year:"+model.getYear()
						+" month:"+model.getMonth()
						+" day:"+model.getDay()
						+" userInfoModel=null");
				continue;
			}
			
			Log.d(TAG, "printRecord userId1:"+model.getUserId()
					+" signtype:"+model.getSignType()
					+" year:"+model.getYear()
					+" month:"+model.getMonth()
					+" day:"+model.getDay()
					+" userId2:"+userInfoModel.getUserId()
					+" username:"+userInfoModel.getUserName());
		}
	}
	/**
	 * 打印所有考勤
	 */
	public void printAllRecord()
	{
		List<AttendanceRecordModel> list = new ArrayList<AttendanceRecordModel>();
		UserInfoModel userInfoModel = new UserInfoModel();
		
		list = attendanceRecordFinder.findAttendanceRecord();
		
		if (list.size() == 0)
		{
			Log.d(TAG, "printAllRecord null");
			return;
		}
		
		for (AttendanceRecordModel model: list )
		{
			userInfoModel = model.getUserInfoModel();
			
			if (userInfoModel == null)
			{//说明没有这个用户
				
				Log.d(TAG, "printAllRecord userId1:"+model.getUserId()
						+" signtype:"+model.getSignType()
						+" year:"+model.getYear()
						+" month:"+model.getMonth()
						+" day:"+model.getDay()
						+" userInfoModel=null");
				continue;
			}
			
			Log.d(TAG, "printAllRecord userId1:"+model.getUserId()
					+" signtype:"+model.getSignType()
					+" year:"+model.getYear()
					+" month:"+model.getMonth()
					+" day:"+model.getDay()
					+" userId2:"+userInfoModel.getUserId()
					+" username:"+userInfoModel.getUserName());
		}
		
	}
	
	
	/**
	 * 
	 * 添加一个指纹
	 * 
	 */
	private void addFp(int fid,String userId)
	{

		//添加一条指纹记录
		UserInfoModel userInfoModel = new UserInfoModel();
		FingerPrintModel fingerPrintModel = new FingerPrintModel();
		
		fingerPrintModel.setFingerId(fid);
		fingerPrintModel.setUserId(userId);
		
		userInfoModel = new UserInfoModel();
		userInfoModel.setUserId(userId);
		
		fingerPrintModel.setUserInfoModel(userInfoModel);
		fingerPrintDao.addFingerPrint(fingerPrintModel);
	}
	
	private void deletefp(int fid)
	{
		fingerPrintDao.deleteFingerPrint(fid);
	}
	
	private void deleteAllfp( )
	{
		fingerPrintDao.deleteAllFingerPrint();
	}
	
	/**
	 * 修改 用户id
	 * @param fid
	 * @param userId
	 */
	private void updatefp(int fid,String newUserId)
	{
//		FingerPrintModel fingerPrintModel = new FingerPrintModel();
//		UserInfoModel userInfoModel = new UserInfoModel();
//		//使用指纹id查询一次
//		fingerPrintModel = fingerPrintDao.getFingerPrint(fid);
//		
//		if (fingerPrintModel == null)
//		{
//			Log.d(TAG, "updatefp null");
//			return;
//		}
//		
//		userInfoModel = fingerPrintModel.getUserInfoModel();
//		
//		Log.d(TAG, "getFingerPrint1 fpid:"+fingerPrintModel.getFingerId()
//				+"fuserid1:"+fingerPrintModel.getUserId()
//				+"userid2:"+userInfoModel.getUserId()
//				);
//		
//		userInfoModel.setUserId(newUserId);
		
		//直接更新
		fingerPrintDao.updateFingerPrint(fid,newUserId);
	}
	
	
	
	/**
	 * 打印查询指纹记录
	 */
	private void printFP(int fid,String userId)
	{
		//获取指纹记录
		UserInfoModel userInfoModel = new UserInfoModel();
		FingerPrintModel fingerPrintModel = new FingerPrintModel();

		//使用指纹id查询一次
		fingerPrintModel = fingerPrintDao.getFingerPrint(fid);
		
		Log.d(TAG, "getFingerPrint1 fpid:"+fingerPrintModel.getFingerId()
				+"userid:"+fingerPrintModel.getUserId()
				);
		
		userInfoModel = fingerPrintModel.getUserInfoModel();
		if (userInfoModel == null)
		{//说明没有这个用户
			
			Log.d(TAG, "printFP userId1:"
					+" userInfoModel=null");
			return;
		}
		
		Log.d(TAG, "getFingerPrint1 UserName:"+userInfoModel.getUserName()
				+"userid:"+userInfoModel.getUserId()
				+"userage:"+userInfoModel.getUserAge()
				);
				
		//在使用外键查询一次
		fingerPrintModel = new FingerPrintModel();
		
		fingerPrintModel = fingerPrintDao.getFingerPrint(userId);
		
		Log.d(TAG, "getFingerPrint2 fpid:"+fingerPrintModel.getFingerId()
				+"userid:"+fingerPrintModel.getUserId()
				);
		
		userInfoModel = fingerPrintModel.getUserInfoModel();
		
		Log.d(TAG, "getFingerPrint2 UserName:"+userInfoModel.getUserName()
				+"userid:"+userInfoModel.getUserId()
				+"userage:"+userInfoModel.getUserAge()
				);
				
	}
	
	
	public void	printAllFP()
	{
		List<FingerPrintModel> list = new ArrayList<FingerPrintModel>();
		UserInfoModel userInfoModel = new UserInfoModel();
		
		list = fingerPrintFinder.findFingerPrint();
		if (list.size() == 0)
		{
			Log.d(TAG, "printAllFP null");
			return;
		}
		
		for (FingerPrintModel fingerPrintModel: list )
		{
			userInfoModel = fingerPrintModel.getUserInfoModel();
			if (userInfoModel == null)
			{//说明没有这个用户
				
				Log.d(TAG, "printAllFP fpid:"+fingerPrintModel.getFingerId()
						+" userInfoModel = null"
						);
				continue;
			}
			Log.d(TAG, "printAllFP fpid:"+fingerPrintModel.getFingerId()
					+ " UserName:"+userInfoModel.getUserName()
					+" userid:"+userInfoModel.getUserId()
					+" userage:"+userInfoModel.getUserAge()
					);
		}
		
	}
	

	
	@OptionsItem(R.id.action_settings)
	public void OptionsItem()
	{
		Log.d(TAG, "action_settings。。。");
	}
}
