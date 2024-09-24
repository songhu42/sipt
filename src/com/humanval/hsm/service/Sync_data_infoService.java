package com.humanval.hsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import com.humanval.hsm.dao.Sync_data_info;

import frame.ibatis.dao.IbatisManager;

public class Sync_data_infoService {

	private IbatisManager im = null; 
	
	public Sync_data_infoService() {
		im = new IbatisManager();
	}	

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public int getNextDbVer() {
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>(); 
		
		rtn = im.getInt(prmMap, "SYNC_DATA_INFO.getNextDbVer");

		return rtn;
	}
	
	public int count(String whereOption){
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		prmMap.put("WHERE_OPTION", whereOption);
		
		rtn = im.getInt(prmMap, "SYNC_DATA_INFO.getCount");

		return rtn;
	}
	


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Sync_data_info> selectList(String whereOption, int page_no, int page_cnt) {
		List<Sync_data_info> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Sync_data_info>)(Object)im.getList(prmMap, "SYNC_DATA_INFO.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Sync_data_info> selectList(String whereOption) {
		List<Sync_data_info> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Sync_data_info>)(Object)im.getList(prmMap, "SYNC_DATA_INFO.getList");

		return list;
	}
	

	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Sync_data_info select(int db_ver, int seq_no) {
		Sync_data_info mst = new Sync_data_info(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("DB_VER", db_ver );
		prmMap.put("SEQ_NO", seq_no );
		
		list = im.getList(prmMap, "SYNC_DATA_INFO.getView");
		if( list.size() > 0 ) mst = (Sync_data_info)list.get(0); 
		
		return mst;
	}

	public int insert(Sync_data_info vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("DB_VER", vo.getDb_ver());
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("DB_TYPE", vo.getDb_type());
		prmMap.put("SQL_STR", vo.getSql_str());

		rtn = im.Insert(prmMap, "SYNC_DATA_INFO.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Sync_data_info vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("DB_VER", vo.getDb_ver());
		prmMap.put("SEQ_NO", vo.getSeq_no());
		prmMap.put("DB_TYPE", vo.getDb_type());
		prmMap.put("SQL_STR", vo.getSql_str());

		rtn = im.Update(prmMap, "SYNC_DATA_INFO.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
	
	public int runQuery(String sql){
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		prmMap.put("SQL", sql);
		if( sql.indexOf("INSERT") == 0 ) rtn = im.Insert(prmMap, "SYNC_DATA_INFO.execute");
		else if( sql.indexOf("DELETE") == 0 ) rtn = im.Delete(prmMap, "SYNC_DATA_INFO.execute");
		else rtn = im.Update(prmMap, "SYNC_DATA_INFO.execute");
		
		System.out.println("runQuery : " + rtn); 

		return rtn;
	}
	
	public int delete(Sync_data_info vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("DB_VER", vo.getDb_ver());
		prmMap.put("SEQ_NO", vo.getSeq_no());
		
		rtn = im.Update(prmMap, "SYNC_DATA_INFO.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}