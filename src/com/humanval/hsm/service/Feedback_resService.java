package com.humanval.hsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import com.humanval.hsm.dao.Feedback_res;
import com.humanval.hsm.dao.Feedback_sum;

import frame.ibatis.dao.IbatisManager;

public class Feedback_resService {

	private IbatisManager im = null; 
	
	public Feedback_resService() {
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
		
		rtn = im.getInt(prmMap, "FEEDBACK_RES.getCount");

		return rtn;
	}

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Feedback_res> selectList(String whereOption, int page_no, int page_cnt) {
		List<Feedback_res> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);
		
		list = (List<Feedback_res>)(Object)im.getList(prmMap, "FEEDBACK_RES.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Feedback_sum selectFeedbackSum(String whereOption) {
		List<Feedback_sum> list = null;
		Feedback_sum sum = new Feedback_sum(); 
		
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Feedback_sum>)(Object)im.getList(prmMap, "FEEDBACK_RES.getFeedbackSum");
		if( list.size() > 0 ) sum = list.get(0); 
		
		return sum;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Feedback_res> selectList(String whereOption) {
		List<Feedback_res> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Feedback_res>)(Object)im.getList(prmMap, "FEEDBACK_RES.getList");

		return list;
	}
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Feedback_res select(long seq_no, long user_id) {
		Feedback_res mst = new Feedback_res(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", seq_no );
		prmMap.put("USER_ID", user_id );
		
		list = im.getList(prmMap, "FEEDBACK_RES.getView");
		if( list.size() > 0 ) mst = (Feedback_res)list.get(0); 
		
		return mst;
	}

	public int update(Feedback_res vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("USER_ID", vo.getUser_id());
		prmMap.put("RES_TYPE", vo.getRes_type());
		prmMap.put("RES_SEQ", vo.getRes_seq());
		prmMap.put("RES_ST", vo.getRes_st());

		rtn = im.Update(prmMap, "FEEDBACK_RES.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}


	public int updateResType(Feedback_res vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("USER_ID", vo.getUser_id());
		prmMap.put("RES_TYPE", vo.getRes_type());
		prmMap.put("RES_ST", vo.getRes_st());

		rtn = im.Update(prmMap, "FEEDBACK_RES.updateResType");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Feedback_res vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("USER_ID", vo.getUser_id());

		rtn = im.Update(prmMap, "FEEDBACK_RES.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}