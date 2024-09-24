package com.humanval.hsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import com.humanval.hsm.dao.User_mst;

import frame.ibatis.dao.IbatisManager;

public class User_mstService {

	private IbatisManager im = null; 
	
	public User_mstService() {
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
		
		rtn = im.getInt(prmMap, "USER_MST.getCount");

		return rtn;
	}

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User_mst> selectList(String whereOption, int page_no, int page_cnt) {
		List<User_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);
		
		list = (List<User_mst>)(Object)im.getList(prmMap, "USER_MST.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User_mst> selectList(String whereOption) {
		List<User_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<User_mst>)(Object)im.getList(prmMap, "USER_MST.getList");

		return list;
	}
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public User_mst select(long user_id) {
		User_mst mst = new User_mst(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("USER_ID", user_id );
		
		list = im.getList(prmMap, "USER_MST.getView");
		if( list.size() > 0 ) mst = (User_mst)list.get(0); 
		
		return mst;
	}


}