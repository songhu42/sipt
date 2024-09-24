package com.humanval.sipt.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.humanval.sipt.dao.Com_code;
import com.humanval.sipt.dao.Word_mst;
import com.humanval.sipt.service.Com_codeService;
import com.humanval.sipt.util.NaverCloudAPI;

import frame.ibatis.dao.IbatisManager;

public class Com_codeService {

	private IbatisManager im = null; 
	
	public Com_codeService() {
		im = new IbatisManager();
	}	
	

	/**
	 * Sound Url �� �̼����� WORD_MST ����Ʈ�� �����ͼ� Naver Cloud API���� mp3���Ϸ� �����Ѵ�. 
	 * @param whereOption
	 * @return
	 */
	public void convertWordToMp3() {
		List<Word_mst> list = selectWordMstList("WHERE src_id != 'U' and ( sound_url = 'fsTLab/jJmhw0dz/+Wqv4w=='  or ifnull(sound_url,'') = '' ) and eng like '%''%' ");
		for( int i=0; i<list.size(); i++ ) {
			Word_mst mst = (Word_mst)list.get(i); 
			String fileNm = "C:\\ProjectLuna\\hsm\\WebContent\\mp3\\" + mst.getWord_id() + ".mp3";
			System.out.println("TextToVoice : " + fileNm); 
			
			try {
				NaverCloudAPI.writeVoiceMP3(mst.getEng(), fileNm);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Word_mst> selectWordMstList(String whereOption) {
		List<Word_mst> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Word_mst>)(Object)im.getList(prmMap, "COM_CODE.selectWordMstList");

		return list;
	}
	
	
	/**
	 * @param whereOption
	 * @return
	 */
	public void resetAddCode() {
		Com_codeService codeService = new Com_codeService(); 
		
		String authUrl = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json?consumer_key=bb9771a73c53434f8df9&consumer_secret=7fb0bcca8e3e43739faa"; 
		
		String retStr = callApi(authUrl); 
		
		JSONParser jsonParser = new JSONParser();
		
		try {
	    	JSONObject jsonObj = (JSONObject) jsonParser.parse(retStr);
	        JSONObject resObj = (JSONObject)jsonObj.get("result");
	        String access_token = (String)resObj.get("accessToken");
	        
	        String callUrl = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json?accessToken=" + access_token + ""; 
	        retStr = callApi(callUrl); 
	        
	        deleteAllAddCode("ADD_CODE"); 
	        
	        JSONObject sidoObj = (JSONObject) jsonParser.parse(retStr);
	        JSONArray sidoArray = (JSONArray) sidoObj.get("result");
	        
	        Com_code sidoCom = new Com_code(); 
	        sidoCom.setGroup_id("B01");
	        sidoCom.setGroup_nm("WhatIsThis");
	        sidoCom.setRemrk("ADD_CODE");

	        Com_code gugunCom = new Com_code(); 
	        gugunCom.setRemrk("ADD_CODE");

	        
	        for(int i=0 ; i<sidoArray.size() ; i++){
	            JSONObject tempObj = (JSONObject) sidoArray.get(i);
	            String sido_cd = (String)tempObj.get("cd");
	            String sido_nm = (String)tempObj.get("addr_name");
	            
		        sidoCom.setCode_id(sido_cd);
		        sidoCom.setCode_nm(sido_nm);
		        sidoCom.setSorts(i+1);
		        
		        codeService.insertAddr(sidoCom);
		        
	            System.out.println("----------------------------");
	            
		        callUrl = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json?accessToken=" + access_token + "&cd=" + sido_cd; 
		        retStr = callApi(callUrl); 
		        
		        JSONObject gugunObj = (JSONObject) jsonParser.parse(retStr);
		        
		        JSONArray gugunArray = (JSONArray) gugunObj.get("result");
		
		        for(int j=0 ; j<gugunArray.size() ; j++) {
		            JSONObject guObj = (JSONObject) gugunArray.get(j);
		            String gu_cd = (String)guObj.get("cd");
		            String gu_nm = (String)guObj.get("addr_name");
		            
			        gugunCom.setGroup_id(sido_cd);
			        gugunCom.setGroup_nm(sido_nm);
			        gugunCom.setCode_id(gu_cd);
			        gugunCom.setCode_nm(gu_nm);
			        gugunCom.setSorts(j+1);
			        
			        codeService.insertAddr(gugunCom);
		            
		        }
		        
	        }
		} catch(Exception pe) {
			pe.printStackTrace(); 
		}

	}

	public String callApi(String _url) {
		BufferedReader in = null; 
		StringBuffer sb = new StringBuffer(); 
		
		try { 
			URL obj = new URL(_url); 
			 
			HttpURLConnection con = (HttpURLConnection)obj.openConnection(); 
			con.setRequestMethod("GET"); 
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8")); 
			String line; 
			while((line = in.readLine()) != null) { 
				sb.append(line); 
				System.out.println(line); 
			} 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); } 
		}
		return sb.toString(); 
	}
			 
	/**
	 * 
	 * @param String group_id, String code_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getCodeName(String group_id, String code_id) {
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("GROUP_ID", group_id);
		prmMap.put("CODE_ID", code_id);
		String rtn = ""; 
		List<String> list = (List<String>)(Object)im.getList(prmMap, "COM_CODE.getCodeName");
		if( list.size() > 0 ) rtn = (String)list.get(0); 

		return rtn;
	}
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Com_code> selectList(String group_id) {
		List<Com_code> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		
		prmMap.put("GROUP_ID", group_id);
		
		list = (List<Com_code>)(Object)im.getList(prmMap, "COM_CODE.selectList");

		return list;
	}

	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Com_code> selectListWhere(String group_id, String whereOption) {
		List<Com_code> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		
		prmMap.put("GROUP_ID", group_id);
		prmMap.put("WHERE_OPTION", whereOption);
		
		list = (List<Com_code>)(Object)im.getList(prmMap, "COM_CODE.selectListWhere");

		return list;
	}

	
	
	/**
	 * 
	 * @param whereOption
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Com_code> selectGroupList() {
		List<Com_code> list = null;
		Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		
		list = (List<Com_code>)(Object)im.getList(prmMap, "COM_CODE.selectGroupList");

		return list;
	}
	
	

	public int insertAddr(Com_code vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("GROUP_ID", vo.getGroup_id());
		prmMap.put("GROUP_NM", vo.getGroup_nm());
		prmMap.put("CODE_ID", vo.getCode_id());
		prmMap.put("CODE_NM", vo.getCode_nm());
		prmMap.put("SORTS", vo.getSorts());
		prmMap.put("REMRK", "ADD_CODE");
        
		rtn = im.Insert(prmMap, "COM_CODE.insert");

		return rtn;
		
	}
	public int insert(Com_code vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("GROUP_ID", vo.getGroup_id());
		prmMap.put("GROUP_NM", vo.getGroup_nm());
		prmMap.put("CODE_ID", vo.getCode_id());
		prmMap.put("CODE_NM", vo.getCode_nm());
		prmMap.put("SORTS", vo.getSorts());
		prmMap.put("REMRK", vo.getRemrk());
        
		rtn = im.Insert(prmMap, "COM_CODE.insert");

		return rtn;
		
	}
	


	public int update(Com_code vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();

		prmMap.put("GROUP_ID", vo.getGroup_id());
		prmMap.put("GROUP_NM", vo.getGroup_nm());
		prmMap.put("CODE_ID", vo.getCode_id());
		prmMap.put("CODE_NM", vo.getCode_nm());
		prmMap.put("SORTS", vo.getSorts());
		prmMap.put("REMRK", vo.getRemrk());
        
		rtn = im.Insert(prmMap, "COM_CODE.update");

		return rtn;
		
	}

	public int delete(Com_code vo) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("GROUP_ID", vo.getGroup_id());
		prmMap.put("CODE_ID", vo.getCode_id());
		
		rtn = im.Update(prmMap, "COM_CODE.delete");
		
		return rtn;
		
	}
		

	public int deleteAllAddCode(String remrk) throws Exception  {
		int rtn = 0;
        Map<Object, Object> prmMap = new HashMap<Object, Object>();
		
		prmMap.put("REMRK", remrk);
		
		rtn = im.Update(prmMap, "COM_CODE.deleteAllAddCode"); 

		return rtn;
		
	}
}