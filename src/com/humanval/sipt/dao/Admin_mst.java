package com.humanval.sipt.dao;

import java.util.Date;

public class Admin_mst  {
	private String admin_id;
	private String admin_nm;
	private String email;
	private String tel_no;
	private int auto_login;
	private String passwd;
	private String auth_level; 
	private String auto_login_key;
	private Date reg_dt;
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_nm() {
		return admin_nm;
	}
	public void setAdmin_nm(String admin_nm) {
		this.admin_nm = admin_nm;
	}
	
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAuto_login() {
		return auto_login;
	}
	public void setAuto_login(int auto_login) {
		this.auto_login = auto_login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getAuth_level() {
		return auth_level;
	}
	public void setAuth_level(String auth_level) {
		this.auth_level = auth_level;
	}
	public String getAuto_login_key() {
		return auto_login_key;
	}
	public void setAuto_login_key(String auto_login_key) {
		this.auto_login_key = auto_login_key;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	

} 