package com.humanval.sipt.dao;

import java.util.Date;

public class Admin_menu  {
	private String menu_id="";
	private String menu_nm="";
	private String grp_nm="";
	private int grp_sorts=1;
	private int sorts=1;
	private String cont_type="";
	private String content="";
	private String auth_level="";
	private int is_used=1;
	private String open_area="";
	private String popup_opt="";
	private String remrks="";
	private Date reg_dt;
	
	private String cont_type_nm;
	private String auth_level_nm;
	private String open_area_nm;
	
	
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getGrp_nm() {
		return grp_nm;
	}
	public void setGrp_nm(String grp_nm) {
		this.grp_nm = grp_nm;
	}
	public int getGrp_sorts() {
		return grp_sorts;
	}
	public void setGrp_sorts(int grp_sorts) {
		this.grp_sorts = grp_sorts;
	}
	public int getSorts() {
		return sorts;
	}
	public void setSorts(int sorts) {
		this.sorts = sorts;
	}
	public String getCont_type() {
		return cont_type;
	}
	public void setCont_type(String cont_type) {
		this.cont_type = cont_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuth_level() {
		return auth_level;
	}
	public void setAuth_level(String auth_level) {
		this.auth_level = auth_level;
	}
	public int getIs_used() {
		return is_used;
	}
	public void setIs_used(int is_used) {
		this.is_used = is_used;
	}
	public String getOpen_area() {
		return open_area;
	}
	public void setOpen_area(String open_area) {
		this.open_area = open_area;
	}
	public String getPopup_opt() {
		return popup_opt;
	}
	public void setPopup_opt(String popup_opt) {
		this.popup_opt = popup_opt;
	}
	public String getRemrks() {
		return remrks;
	}
	public void setRemrks(String remrks) {
		this.remrks = remrks;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getCont_type_nm() {
		return cont_type_nm;
	}
	public void setCont_type_nm(String cont_type_nm) {
		this.cont_type_nm = cont_type_nm;
	}
	public String getAuth_level_nm() {
		return auth_level_nm;
	}
	public void setAuth_level_nm(String auth_level_nm) {
		this.auth_level_nm = auth_level_nm;
	}
	public String getOpen_area_nm() {
		return open_area_nm;
	}
	public void setOpen_area_nm(String open_area_nm) {
		this.open_area_nm = open_area_nm;
	}

	
} 