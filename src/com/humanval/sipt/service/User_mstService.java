package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.User_mst;

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

	

	public int insert(User_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		prmMap.put("USER_NM", vo.getUser_nm());
		prmMap.put("USER_NIC", vo.getUser_nic());
		prmMap.put("USER_GRADE", vo.getUser_grade());
		prmMap.put("USER_LVL", vo.getUser_lvl());
		prmMap.put("TEL_NO", vo.getTel_no());
		prmMap.put("ADD_TEL", vo.getAdd_tel());
		prmMap.put("EMAIL", vo.getEmail());
		prmMap.put("IMAGE", vo.getImage());
		prmMap.put("JOIN_DT", vo.getJoin_dt());
		prmMap.put("LEAVE_DT", vo.getLeave_dt());
		prmMap.put("STATE", vo.getState());

		rtn = im.Insert(prmMap, "USER_MST.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(User_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("USER_ID", vo.getUser_id());
		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		prmMap.put("USER_NM", vo.getUser_nm());
		prmMap.put("USER_NIC", vo.getUser_nic());
		prmMap.put("USER_GRADE", vo.getUser_grade());
		prmMap.put("USER_LVL", vo.getUser_lvl());
		prmMap.put("TEL_NO", vo.getTel_no());
		prmMap.put("ADD_TEL", vo.getAdd_tel());
		prmMap.put("EMAIL", vo.getEmail());
		prmMap.put("IMAGE", vo.getImage());
		prmMap.put("JOIN_DT", vo.getJoin_dt());
		prmMap.put("LEAVE_DT", vo.getLeave_dt());
		prmMap.put("STATE", vo.getState());

		rtn = im.Update(prmMap, "USER_MST.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(User_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("USER_ID", vo.getUser_id());
		
		rtn = im.Update(prmMap, "USER_MST.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		
	

}