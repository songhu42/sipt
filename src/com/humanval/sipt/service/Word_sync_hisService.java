package com.humanval.sipt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.humanval.sipt.dao.Word_sync_his;

import frame.ibatis.dao.IbatisManager;

public class Word_sync_hisService {

	private IbatisManager im = null; 
	
	public Word_sync_hisService() {
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
		
		rtn = im.getInt(prmMap, "WORD_SYNC_HIS.getCount");

		return rtn;
	}
	

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_sync_his> selectList(String whereOption, int page_no, int page_cnt) {
		List<Word_sync_his> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Word_sync_his>)(Object)im.getList(prmMap, "WORD_SYNC_HIS.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_sync_his> selectList(String whereOption) {
		List<Word_sync_his> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Word_sync_his>)(Object)im.getList(prmMap, "WORD_SYNC_HIS.getList");

		return list;
	}
	

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Word_sync_his select(long seq_no) {
		Word_sync_his mst = new Word_sync_his(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", seq_no );
		
		list = im.getList(prmMap, "WORD_SYNC_HIS.getView");
		if( list.size() > 0 ) mst = (Word_sync_his)list.get(0); 
		
		return mst;
	}

	public int insert(Word_sync_his vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("SQL_STR", vo.getSql_str());
		prmMap.put("EXE_YN", vo.getExe_yn());
		prmMap.put("DB_VER", vo.getDb_ver());

		rtn = im.Insert(prmMap, "WORD_SYNC_HIS.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Word_sync_his vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("SQL_STR", vo.getSql_str());
		prmMap.put("EXE_YN", vo.getExe_yn());
		prmMap.put("DB_VER", vo.getDb_ver());

		rtn = im.Update(prmMap, "WORD_SYNC_HIS.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Word_sync_his vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("SEQ_NO", vo.getSeq_no());
		
		rtn = im.Update(prmMap, "WORD_SYNC_HIS.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}