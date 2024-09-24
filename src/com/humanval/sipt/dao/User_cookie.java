package com.humanval.sipt.dao;

import java.util.Date;

public class User_cookie {
	private String admin_id;
	private String auto_login_key;
	private String remote_addr;
	private Date reg_dt;
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAuto_login_key() {
		return auto_login_key;
	}
	public void setAuto_login_key(String auto_login_key) {
		this.auto_login_key = auto_login_key;
	}
	public String getRemote_addr() {
		return remote_addr;
	}
	public void setRemote_addr(String remote_addr) {
		this.remote_addr = remote_addr;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	
}
