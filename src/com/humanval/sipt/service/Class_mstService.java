package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.Class_mst;

import frame.ibatis.dao.IbatisManager;

public class Class_mstService {

	private IbatisManager im = null; 
	
	public Class_mstService() {
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
		
		rtn = im.getInt(prmMap, "CLASS_MST.getCount");

		return rtn;
	}

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Class_mst> selectList(String whereOption, int page_no, int page_cnt) {
		List<Class_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);
		
		list = (List<Class_mst>)(Object)im.getList(prmMap, "CLASS_MST.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Class_mst> selectList(String whereOption) {
		List<Class_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Class_mst>)(Object)im.getList(prmMap, "CLASS_MST.getList");

		return list;
	}
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Class_mst select(long class_id) {
		Class_mst mst = new Class_mst(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("CLASS_ID", class_id );
		
		list = im.getList(prmMap, "CLASS_MST.getView");
		if( list.size() > 0 ) mst = (Class_mst)list.get(0); 
		
		return mst;
	}

	

	public int insert(Class_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("CLASS_ID", vo.getClass_id());
		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		prmMap.put("USER_IDS", vo.getUser_ids());
		prmMap.put("CLASS_TP", vo.getClass_tp());
		prmMap.put("CLASS_WDS", vo.getClass_wds());
		prmMap.put("STR_TM", vo.getStr_tm());
		prmMap.put("END_TM", vo.getEnd_tm());
		prmMap.put("PRICE", vo.getPrice());
		prmMap.put("TOT_PRICE", vo.getTot_price());
		prmMap.put("REG_CNT", vo.getReg_cnt());
		prmMap.put("ADD_CNT", vo.getAdd_cnt());
		prmMap.put("CREAT_YN", vo.getCreat_yn());
		prmMap.put("START_DT", vo.getStart_dt());
		prmMap.put("CREATE_DT", vo.getCreate_dt());
		prmMap.put("STATE", vo.getState());

		rtn = im.Insert(prmMap, "CLASS_MST.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Class_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("CLASS_ID", vo.getClass_id());
		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		prmMap.put("USER_IDS", vo.getUser_ids());
		prmMap.put("CLASS_TP", vo.getClass_tp());
		prmMap.put("CLASS_WDS", vo.getClass_wds());
		prmMap.put("STR_TM", vo.getStr_tm());
		prmMap.put("END_TM", vo.getEnd_tm());
		prmMap.put("PRICE", vo.getPrice());
		prmMap.put("TOT_PRICE", vo.getTot_price());
		prmMap.put("REG_CNT", vo.getReg_cnt());
		prmMap.put("ADD_CNT", vo.getAdd_cnt());
		prmMap.put("CREAT_YN", vo.getCreat_yn());
		prmMap.put("START_DT", vo.getStart_dt());
		prmMap.put("CREATE_DT", vo.getCreate_dt());
		prmMap.put("STATE", vo.getState());

		rtn = im.Update(prmMap, "CLASS_MST.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Class_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("CLASS_ID", vo.getClass_id());
		
		rtn = im.Update(prmMap, "CLASS_MST.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		
	

}