package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.Feedback_mst;

import frame.ibatis.dao.IbatisManager;

public class Feedback_mstService {

	private IbatisManager im = null; 
	
	public Feedback_mstService() {
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
		
		rtn = im.getInt(prmMap, "FEEDBACK_MST.getCount");

		return rtn;
	}
	

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public long getLastSeqNo(){
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		rtn = im.getInt(prmMap, "FEEDBACK_MST.getLastSeqNo");

		return rtn;
	}

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Feedback_mst> selectList(String whereOption, int page_no, int page_cnt) {
		List<Feedback_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Feedback_mst>)(Object)im.getList(prmMap, "FEEDBACK_MST.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Feedback_mst> selectList(String whereOption) {
		List<Feedback_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Feedback_mst>)(Object)im.getList(prmMap, "FEEDBACK_MST.getList");

		return list;
	}
	

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Feedback_mst select(long seq_no) {
		Feedback_mst mst = new Feedback_mst(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", seq_no );
		
		list = im.getList(prmMap, "FEEDBACK_MST.getView");
		if( list.size() > 0 ) mst = (Feedback_mst)list.get(0); 
		
		return mst;
	}

	public int insert(Feedback_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("TITLE", vo.getTitle());
		prmMap.put("CONTENT", vo.getContent());
		prmMap.put("DEL_YN", vo.getDel_yn());
		prmMap.put("VALID_DT", vo.getValid_dt());
		prmMap.put("TARGET", vo.getTarget());
		prmMap.put("CONT_LIMIT", vo.getCont_limit());
		prmMap.put("HEART_CNT", vo.getHeart_cnt());
		prmMap.put("DAMON_CNT", vo.getDamon_cnt());
		prmMap.put("GAME_TYPE", vo.getGame_type());
		prmMap.put("REG_ID", vo.getReg_id());

		rtn = im.Insert(prmMap, "FEEDBACK_MST.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Feedback_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("SEQ_NO", vo.getSeq_no());

		prmMap.put("TITLE", vo.getTitle());
		prmMap.put("CONTENT", vo.getContent());
		prmMap.put("DEL_YN", vo.getDel_yn());
		prmMap.put("VALID_DT", vo.getValid_dt());
		prmMap.put("TARGET", vo.getTarget());
		prmMap.put("CONT_LIMIT", vo.getCont_limit());
		prmMap.put("HEART_CNT", vo.getHeart_cnt());
		prmMap.put("DAMON_CNT", vo.getDamon_cnt());
		prmMap.put("GAME_TYPE", vo.getGame_type());
		prmMap.put("REG_ID", vo.getReg_id());


		rtn = im.Update(prmMap, "FEEDBACK_MST.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Feedback_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", vo.getSeq_no());
		
		rtn = im.Update(prmMap, "FEEDBACK_MST.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}