package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.Buy_history;

import frame.ibatis.dao.IbatisManager;

public class Buy_historyService {

	private IbatisManager im = null; 
	
	public Buy_historyService() {
		im = new IbatisManager();
	}	
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public int count(String whereOption){
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		prmMap.put("WHERE_OPTION", whereOption);
		
		rtn = im.getInt(prmMap, "BUY_HISTORY.getCount");

		return rtn;
	}

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Buy_history selectSum(String whereOption) {
		List<Buy_history> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Buy_history>)(Object)im.getList(prmMap, "BUY_HISTORY.getSum");
		if( list.size() > 0 ) return list.get(0); 
		return new Buy_history();
	}

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Buy_history> selectList(String whereOption, int page_no, int page_cnt) {
		List<Buy_history> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);
		
		list = (List<Buy_history>)(Object)im.getList(prmMap, "BUY_HISTORY.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Buy_history> selectList(String whereOption) {
		List<Buy_history> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Buy_history>)(Object)im.getList(prmMap, "BUY_HISTORY.getList");

		return list;
	}
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Buy_history select(long user_id, String item_id, int seq_no) {
		Buy_history mst = new Buy_history(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("USER_ID", user_id );
		prmMap.put("ITEM_ID", item_id );
		prmMap.put("seq_no", seq_no );
		
		list = im.getList(prmMap, "BUY_HISTORY.getView");
		if( list.size() > 0 ) mst = (Buy_history)list.get(0); 
		
		return mst;
	}


}