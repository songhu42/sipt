package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.Board_ann;

import frame.ibatis.dao.IbatisManager;

public class Board_annService {

	private IbatisManager im = null; 
	
	public Board_annService() {
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
		
		rtn = im.getInt(prmMap, "BOARD_ANN.getCount");

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
		
		rtn = im.getInt(prmMap, "BOARD_ANN.getLastSeqNo");

		return rtn;
	}

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Board_ann> selectList(String whereOption, int page_no, int page_cnt) {
		List<Board_ann> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Board_ann>)(Object)im.getList(prmMap, "BOARD_ANN.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Board_ann> selectList(String whereOption) {
		List<Board_ann> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Board_ann>)(Object)im.getList(prmMap, "BOARD_ANN.getList");

		return list;
	}
	

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Board_ann select(long seq_no) {
		Board_ann mst = new Board_ann(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", seq_no );
		
		list = im.getList(prmMap, "BOARD_ANN.getView");
		if( list.size() > 0 ) mst = (Board_ann)list.get(0); 
		
		return mst;
	}

	public int insert(Board_ann vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("TITLE", vo.getTitle());
		prmMap.put("CONTENT", vo.getContent());
		prmMap.put("DEL_YN", vo.getDel_yn());
		prmMap.put("VALID_DT", vo.getValid_dt());
		prmMap.put("IS_POPUP", vo.getIs_popup());
		prmMap.put("GAME_TYPE", vo.getGame_type());
		prmMap.put("ANN_TYPE", vo.getAnn_type());
		prmMap.put("USER_ID", vo.getUser_id());
		prmMap.put("REG_ID", vo.getReg_id());

		rtn = im.Insert(prmMap, "BOARD_ANN.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Board_ann vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("TITLE", vo.getTitle());
		prmMap.put("CONTENT", vo.getContent());
		prmMap.put("DEL_YN", vo.getDel_yn());
		prmMap.put("VALID_DT", vo.getValid_dt());
		prmMap.put("IS_POPUP", vo.getIs_popup());
		prmMap.put("GAME_TYPE", vo.getGame_type());
		prmMap.put("ANN_TYPE", vo.getAnn_type());
		prmMap.put("USER_ID", vo.getUser_id());
		prmMap.put("REG_ID", vo.getReg_id());


		rtn = im.Update(prmMap, "BOARD_ANN.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Board_ann vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", vo.getSeq_no());
		
		rtn = im.Update(prmMap, "BOARD_ANN.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}