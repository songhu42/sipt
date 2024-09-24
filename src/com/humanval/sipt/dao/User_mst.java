package com.humanval.sipt.dao;

import java.util.Date;

public class User_mst {
	private long user_id;
	private String admin_id;
	private String user_nm;
	private String user_nic;
	private String user_grade;
	private int user_lvl;
	private String tel_no;
	private String add_tel;
	private String email;
	private String image;
	private Date join_dt;
	private Date leave_dt;
	private String state;
	private Date reg_dt;
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUser_nic() {
		return user_nic;
	}
	public void setUser_nic(String user_nic) {
		this.user_nic = user_nic;
	}
	public String getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
	public int getUser_lvl() {
		return user_lvl;
	}
	public void setUser_lvl(int user_lvl) {
		this.user_lvl = user_lvl;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getAdd_tel() {
		return add_tel;
	}
	public void setAdd_tel(String add_tel) {
		this.add_tel = add_tel;
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
	public Date getJoin_dt() {
		return join_dt;
	}
	public void setJoin_dt(Date join_dt) {
		this.join_dt = join_dt;
	}
	public Date getLeave_dt() {
		return leave_dt;
	}
	public void setLeave_dt(Date leave_dt) {
		this.leave_dt = leave_dt;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	
	
}
