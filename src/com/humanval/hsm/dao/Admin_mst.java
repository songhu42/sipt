package com.humanval.hsm.dao;

import java.util.Date;

public class Admin_mst  {
	private String admin_id;
	private String admin_nm;
	private String auth_level;
	private String tel_no;
	private String device_token;
	private String passwd;
	private String email;
	private String image;
	private String state;
	private String auto_login_key;
	private Date reg_dt;
	
	private String auth_level_nm;
	private String state_nm;
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
	public String getAuth_level() {
		return auth_level;
	}
	public void setAuth_level(String auth_level) {
		this.auth_level = auth_level;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getAuth_level_nm() {
		return auth_level_nm;
	}
	public void setAuth_level_nm(String auth_level_nm) {
		this.auth_level_nm = auth_level_nm;
	}
	public String getState_nm() {
		return state_nm;
	}
	public void setState_nm(String state_nm) {
		this.state_nm = state_nm;
	}
	

} 