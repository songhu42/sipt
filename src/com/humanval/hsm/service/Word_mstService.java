package com.humanval.hsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import com.humanval.hsm.dao.Word_mst;

import frame.ibatis.dao.IbatisManager;

public class Word_mstService {

	private IbatisManager im = null; 
	
	public Word_mstService() {
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
		
		rtn = im.getInt(prmMap, "WORD_MST.getCount");

		return rtn;
	}
	

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_mst> selectList(String whereOption, int page_no, int page_cnt) {
		List<Word_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Word_mst>)(Object)im.getList(prmMap, "WORD_MST.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_mst> selectList(String whereOption) {
		List<Word_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Word_mst>)(Object)im.getList(prmMap, "WORD_MST.getList");

		return list;
	}
	

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Word_mst select(String word_id) {
		Word_mst mst = new Word_mst(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WORD_ID", word_id );
		
		list = im.getList(prmMap, "WORD_MST.getView");
		if( list.size() > 0 ) mst = (Word_mst)list.get(0); 
		
		return mst;
	}

	public int insert(Word_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("WORD_ID", vo.getWord_id());
		prmMap.put("ENG", vo.getEng());
		prmMap.put("KOR", vo.getKor());

		rtn = im.Insert(prmMap, "WORD_MST.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Word_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("WORD_ID", vo.getWord_id());
		prmMap.put("ENG", vo.getEng());
		prmMap.put("KOR", vo.getKor());

		rtn = im.Update(prmMap, "WORD_MST.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Word_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WORD_ID", vo.getWord_id());
		
		rtn = im.Update(prmMap, "WORD_MST.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}