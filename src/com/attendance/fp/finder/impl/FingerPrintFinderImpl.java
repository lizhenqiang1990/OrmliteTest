package com.attendance.fp.finder.impl;

import java.util.List;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import com.attendance.fp.db.dao.FingerPrintDao;
import com.attendance.fp.db.dao.impl.FingerPrintDaoImpl;
import com.attendance.fp.finder.FingerPrintFinder;
import com.attendance.fp.model.FingerPrintModel;

@EBean
public class FingerPrintFinderImpl implements FingerPrintFinder
{
	private final static String TAG = FingerPrintFinderImpl.class.getSimpleName();
	
	@Bean(FingerPrintDaoImpl.class)
	public FingerPrintDao fingerPrintDao;
	
	@Override
	public List<FingerPrintModel> findFingerPrint()
	{
		// TODO Auto-generated method stub
		return fingerPrintDao.listFingerPrint();
	}

}
