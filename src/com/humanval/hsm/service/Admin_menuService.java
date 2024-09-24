package com.humanval.hsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import com.humanval.hsm.dao.Admin_menu;

import frame.ibatis.dao.IbatisManager;

public class Admin_menuService {

	private IbatisManager im = null; 
	
	public Admin_menuService() {
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
		
		rtn = im.getInt(prmMap, "ADMIN_MENU.getCount");

		return rtn;
	}

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Admin_menu> selectList(String whereOption, int page_no, int page_cnt) {
		List<Admin_menu> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int start_no = page_cnt*(page_no-1); 
		
		prmMap.put("WHERE_OPTION", whereOption);
		prmMap.put("START_NO", start_no);
		prmMap.put("PAGE_CNT", page_cnt);

		list = (List<Admin_menu>)(Object)im.getList(prmMap, "ADMIN_MENU.getListPage");

		return list;
	}


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Admin_menu> selectList(String whereOption) {
		List<Admin_menu> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Admin_menu>)(Object)im.getList(prmMap, "ADMIN_MENU.getList");

		return list;
	}
	


	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Admin_menu> selectGroupList(String whereOption) {
		List<Admin_menu> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Admin_menu>)(Object)im.getList(prmMap, "ADMIN_MENU.selectGroupList");

		return list;
	}
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Admin_menu select(String menu_id) {
		Admin_menu mst = new Admin_menu(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("MENU_ID", menu_id );
		
		list = im.getList(prmMap, "ADMIN_MENU.getView");
		if( list.size() > 0 ) mst = (Admin_menu)list.get(0); 
		
		return mst;
	}

	public int insert(Admin_menu vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("MENU_ID", vo.getMenu_id());
		prmMap.put("MENU_NM", vo.getMenu_nm());
		prmMap.put("GRP_NM", vo.getGrp_nm());
		prmMap.put("GRP_SORTS", vo.getGrp_sorts());
		prmMap.put("SORTS", vo.getSorts());
		prmMap.put("CONT_TYPE", vo.getCont_type());
		prmMap.put("CONTENT", vo.getContent());
		prmMap.put("AUTH_LEVEL", vo.getAuth_level());
		prmMap.put("IS_USED", vo.getIs_used());
		prmMap.put("OPEN_AREA", vo.getOpen_area());
		prmMap.put("POPUP_OPT", vo.getPopup_opt());
		prmMap.put("REMRKS", vo.getRemrks());
        

		rtn = im.Insert(prmMap, "ADMIN_MENU.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Admin_menu vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
        
		prmMap.put("MENU_ID", vo.getMenu_id());
		prmMap.put("MENU_NM", vo.getMenu_nm());
		prmMap.put("GRP_NM", vo.getGrp_nm());
		prmMap.put("GRP_SORTS", vo.getGrp_sorts());
		prmMap.put("SORTS", vo.getSorts());
		prmMap.put("CONT_TYPE", vo.getCont_type());
		prmMap.put("CONTENT", vo.getContent());
		prmMap.put("AUTH_LEVEL", vo.getAuth_level());
		prmMap.put("IS_USED", vo.getIs_used());
		prmMap.put("OPEN_AREA", vo.getOpen_area());
		prmMap.put("POPUP_OPT", vo.getPopup_opt());
		prmMap.put("REMRKS", vo.getRemrks());


		rtn = im.Update(prmMap, "ADMIN_MENU.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Admin_menu vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("MENU_ID", vo.getMenu_id());
		
		rtn = im.Update(prmMap, "ADMIN_MENU.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

}