package com.humanval.hsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import com.humanval.hsm.dao.DailySales;
import com.humanval.hsm.util.ComUtil;

import frame.ibatis.dao.IbatisManager;

public class DailySalesService {

	private IbatisManager im = null; 
	
	public DailySalesService() {
		im = new IbatisManager();
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<DailySales> selectList(String whereOption) {
		List<DailySales> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<DailySales>)(Object)im.getList(prmMap, "DAILY_SALES.getDailySales");

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<DailySales> selectListDesc(String whereOption) {
		List<DailySales> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<DailySales>)(Object)im.getList(prmMap, "DAILY_SALES.getDailySalesDesc");

		return list;
	}

	// get count DAILY_SALES
	public int count(String sumup_dt ) {
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SUMUP_DT", sumup_dt);
		
		int cnt =(int)im.getInt(prmMap, "DAILY_SALES.getCount");

		return cnt;
	}
	public int sumCount(String sumup_dt ) {
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SUMUP_DT", sumup_dt);
		
		int cnt =(int)im.getInt(prmMap, "DAILY_SALES.getSumCount");

		return cnt;
	}

	// get count USER_MST joined 
	public int countUser(String sumup_dt ) {
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SUMUP_DT", sumup_dt);
		
		int cnt =(int)im.getInt(prmMap, "DAILY_SALES.getUserCount");

		return cnt;
	}
	
	/**
	 * 조회할 때 일자별 실적을 집계하여 저장한다. 
	 * @param day
	 * @return
	 */
	public int sumupDailySales(String sumup_dt, boolean isToday) {
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int rtn = 0; 
		
		int cnt = count(sumup_dt); 
		int sum_cnt = 0; 
		
		if( !isToday ) sum_cnt = sumCount(sumup_dt) + 1; 
		
		// System.out.println("sum dt : " + sumup_dt + " isToday : " + isToday + " sum cnt : " + sum_cnt); 
		
		prmMap.put("SUMUP_DT", sumup_dt);
		prmMap.put("SUM_CNT", sum_cnt);
		
		// 삭제하고 다시 집계를 한다.  
		if( sum_cnt < 3 ) {
			im.Update(prmMap, "DAILY_SALES.delete");
			rtn = im.Insert(prmMap, "DAILY_SALES.sumupDailySales");
		}

		// 오늘 일자 혹은 집계가 안된 경우 이전 일자 집계를 수행한다. 
		if( isToday || cnt == 0 ) {
			// recursive call to calculate if user join is exist..  
			String prevDate = ComUtil.gapDayString(sumup_dt, -1); 
			if( countUser(prevDate) > 0 && sum_cnt < 3 ) sumupDailySales(prevDate, false);  
		}

		return rtn;
	}


}