package com.attendance.fp.finder;

import java.util.List;

import com.attendance.fp.model.FingerPrintModel;

/**
 * 指纹列表 接口
 * @author Administrator
 *
 */
public abstract interface  FingerPrintFinder
{ 
    public abstract List<FingerPrintModel> findFingerPrint();
}
