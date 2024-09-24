package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.Word_sel;

import frame.ibatis.dao.IbatisManager;

public class Word_selService {

	private IbatisManager im = null; 
	
	public Word_selService() {
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
		
		rtn = im.getInt(prmMap, "WORD_SEL.getCount");

		return rtn;
	}
	

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_sel> selectList(String whereOption, int page_no, int page_cnt) {
		List<Word_sel> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Word_sel>)(Object)im.getList(prmMap, "WORD_SEL.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_sel> selectList(String whereOption) {
		List<Word_sel> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Word_sel>)(Object)im.getList(prmMap, "WORD_SEL.getList");

		return list;
	}
	

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Word_sel select(String word_id, int seq_no) {
		Word_sel mst = new Word_sel(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WORD_ID", word_id );
		prmMap.put("SEQ_NO", seq_no );
		
		list = im.getList(prmMap, "WORD_SEL.getView");
		if( list.size() > 0 ) mst = (Word_sel)list.get(0); 
		
		return mst;
	}

	public int insert(Word_sel vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("WORD_ID", vo.getWord_id());
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("ENG", vo.getEng());
		prmMap.put("KOR", vo.getKor());
		prmMap.put("TYPE", vo.getType());

		rtn = im.Insert(prmMap, "WORD_SEL.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Word_sel vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("WORD_ID", vo.getWord_id());
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("ENG", vo.getEng());
		prmMap.put("KOR", vo.getKor());
		prmMap.put("TYPE", vo.getType());

		rtn = im.Update(prmMap, "WORD_SEL.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Word_sel vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WORD_ID", vo.getWord_id());
		prmMap.put("SEQ_NO", vo.getSeq_no());
		
		rtn = im.Update(prmMap, "WORD_SEL.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}