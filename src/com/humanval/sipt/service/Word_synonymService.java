package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.Word_synonym;

import frame.ibatis.dao.IbatisManager;

public class Word_synonymService {

	private IbatisManager im = null; 
	
	public Word_synonymService() {
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
		
		rtn = im.getInt(prmMap, "WORD_SYNONYM.getCount");

		return rtn;
	}
	
	public int getNextSeq() {
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>(); 
		
		rtn = im.getInt(prmMap, "WORD_SYNONYM.getNextSeq");

		return rtn;
	}

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_synonym> selectList(String whereOption, int page_no, int page_cnt) {
		List<Word_synonym> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Word_synonym>)(Object)im.getList(prmMap, "WORD_SYNONYM.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_synonym> selectList(String whereOption) {
		List<Word_synonym> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Word_synonym>)(Object)im.getList(prmMap, "WORD_SYNONYM.getList");

		return list;
	}
	

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Word_synonym select(long seq_no) {
		Word_synonym mst = new Word_synonym(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", seq_no );
		
		list = im.getList(prmMap, "WORD_SYNONYM.getView");
		if( list.size() > 0 ) mst = (Word_synonym)list.get(0); 
		
		return mst;
	}

	public int insert(Word_synonym vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("KOR1", vo.getKor1());
		prmMap.put("KOR2", vo.getKor2());
		prmMap.put("KOR3", vo.getKor3());
		prmMap.put("KOR4", vo.getKor4());
		prmMap.put("KOR5", vo.getKor5());
		prmMap.put("KOR6", vo.getKor6());
		prmMap.put("KOR7", vo.getKor7());

		rtn = im.Insert(prmMap, "WORD_SYNONYM.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Word_synonym vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("KOR1", vo.getKor1());
		prmMap.put("KOR2", vo.getKor2());
		prmMap.put("KOR3", vo.getKor3());
		prmMap.put("KOR4", vo.getKor4());
		prmMap.put("KOR5", vo.getKor5());
		prmMap.put("KOR6", vo.getKor6());
		prmMap.put("KOR7", vo.getKor7());

		rtn = im.Update(prmMap, "WORD_SYNONYM.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Word_synonym vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", vo.getSeq_no());
		
		rtn = im.Update(prmMap, "WORD_SYNONYM.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}