package com.humanval.hsm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import javax.servlet.http.HttpServletRequest;

import com.humanval.hsm.dao.Admin_mst;

import frame.ibatis.dao.IbatisManager;

public class Admin_mstService {

	private IbatisManager im = null; 
	
	public Admin_mstService() {
		im = new IbatisManager();
	}	
	
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public List<?> selectList(String whereOption) {
		List<?> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = im.getList(prmMap, "ADMIN_MST.getList");

		return list;
	}

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	public Admin_mst select(String admin_id) {
		Admin_mst mst = new Admin_mst(); 
		List<?> list = null;

		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("ADMIN_ID", admin_id );
		
		list = im.getList(prmMap, "ADMIN_MST.getView");
		if( list.size() > 0 ) mst = (Admin_mst)list.get(0); 
		
		return mst;
	}

	/**
	 * 로그인 유져 정보 취득
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public Admin_mst isAdminMobile(HttpServletRequest req) throws Exception {
	    Admin_mst user = null;
	    
    	user = isAdmin(req.getParameter("input_id"));

    	return user;
	}
	
	/**
	 * 로그인 유져 정보 취득
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public Admin_mst isAdmin(HttpServletRequest req) throws Exception {
	    Admin_mst user = null;
	    
    	user = isAdmin(req.getParameter("loginId"));

    	return user;
	}

	/**
	 * is User
	 * @param loginId
	 * @return
	 */
	public Admin_mst isAdmin(String loginId){
		
		// user 없는 경우 걍 return null.. 
		if( countUser(loginId) == 0 ) return null; 
		
		Admin_mst user = select(loginId);

		return user;
	}

	/**
	 * 사용자 존재여부 확인
	 * @param loginId
	 * @return
	 */
	public int countUser(String loginId){
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		prmMap.put("ADMIN_ID", loginId);
		
		try {
			rtn = im.getInt(prmMap, "ADMIN_MST.getCount");
		} catch( Exception e ) {
			rtn = 0; 
			System.out.println("songhu exception ................. ");
			e.printStackTrace(); 
		}
		return rtn;
	}

	public int updatePasswd(Admin_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		prmMap.put("PASSWD", vo.getPasswd());

		rtn = im.Update(prmMap, "ADMIN_MST.updatePasswd");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
	
	public int insert(Admin_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		prmMap.put("ADMIN_NM", vo.getAdmin_nm());
		prmMap.put("AUTH_LEVEL", vo.getAuth_level());
		prmMap.put("TEL_NO", vo.getTel_no());
		prmMap.put("DEVICE_TOKEN", vo.getDevice_token());
		prmMap.put("PASSWD", vo.getPasswd());
		prmMap.put("EMAIL", vo.getEmail());
		prmMap.put("IMAGE", vo.getImage());
		prmMap.put("STATE", vo.getState());

		rtn = im.Insert(prmMap, "ADMIN_MST.insert");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	public int update(Admin_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		prmMap.put("ADMIN_NM", vo.getAdmin_nm());
		prmMap.put("AUTH_LEVEL", vo.getAuth_level());
		prmMap.put("TEL_NO", vo.getTel_no());
		prmMap.put("DEVICE_TOKEN", vo.getDevice_token());
		prmMap.put("PASSWD", vo.getPasswd());
		prmMap.put("EMAIL", vo.getEmail());
		prmMap.put("IMAGE", vo.getImage());
		prmMap.put("STATE", vo.getState());

		rtn = im.Update(prmMap, "ADMIN_MST.update");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}

	
	public int delete(Admin_mst vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("ADMIN_ID", vo.getAdmin_id());
		
		rtn = im.Update(prmMap, "ADMIN_MST.delete");
		if( rtn <= 0 ) throw new Exception("SQL Exception"); 

		return rtn;
		
	}
		

	/**
	 * 자동로그인 키값 얻어옴.. 
	 * @param loginId
	 * @return
	 */
	public List<?> getAutoLoginKey(String admin_id){
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		List<?> list = null;
		
		prmMap.put("ADMIN_ID", admin_id);
		
		list = im.getList(prmMap, "ADMIN_MST.getAutoLoginKey");
		
		return list; 
	}
	

	/**
	 * 자동 로그인 플래그 갱신: mobile SVS 에서 접속시 Cookie 이용 자동 로그인 .. 
	 * @param loginId
	 * @param onoff
	 * @return
	 */
	public int insertAutoLoginKey(String admin_id, String encKey, String remote_addr){
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("ADMIN_ID", admin_id);
		prmMap.put("AUTO_LOGIN_KEY", encKey);
		prmMap.put("REMOTE_ADDR", remote_addr);
		
		rtn = im.Update(prmMap, "ADMIN_MST.insertAutoLoginKey");
		
		return rtn;
	}


	/**
	 * 패스워드/locale 정보 수정(ibatis)
	 * @param loginId
	 * @param onoff
	 * @return
	 */
	public int updatePasswd(String admin_id, String oldpw, String newpw){
		int rtn = 0;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("ADMIN_ID", admin_id);
		prmMap.put("PASSWD", newpw); 
		
		rtn = im.Update(prmMap, "ADMIN_MST.updatePasswd");
		
		return rtn;
	}

	/**
	 * 로그인 유저 정보 취득(ibatis)
	 * @param loginId
	 * @return
	 */
	public String getPassword(String admin_id){
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		Map<?, ?> map = null;
		
		prmMap.put("ADMIN_ID", admin_id);
		
		map = im.getView(prmMap, "ADMIN_MST.getPassword");

		return (String) map.get("PASSWORD");
	}

	/**
	 * device token 저장, 앱으로 실행시 가능.. 
	 * @return
	 */
	public int updateDeviceToken(String admin_id, String device_token){
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		int rtn = 0; 
		
		prmMap.put("ADMIN_ID", admin_id);
		prmMap.put("DEVICE_TOKEN", device_token);
		
		rtn = im.Update(prmMap, "ADMIN_MST.updateDeviceToken");

		return rtn; 
	}


}