package com.humanval.sipt.dao;

import java.util.Date;

public class Board_ann  {
	private long seq_no;
	private String title="";
	private String content="";

	private String game_type="";
	private Date valid_dt;
	private int is_popup; 
	private String ann_type="";
	private String ann_type_nm="";
	private long user_id;
	private String user_nic; 

	private int del_yn=0;
	private long reg_id;
	private Date reg_dt;
	private Date mod_dt;
	
	public long getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(long seq_no) {
		this.seq_no = seq_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGame_type() {
		return game_type;
	}
	public void setGame_type(String game_type) {
		this.game_type = game_type;
	}
	public Date getValid_dt() {
		return valid_dt;
	}
	public void setValid_dt(Date valid_dt) {
		this.valid_dt = valid_dt;
	}

	public int getIs_popup() {
		return is_popup;
	}
	public void setIs_popup(int is_popup) {
		this.is_popup = is_popup;
	}
	public String getAnn_type() {
		return ann_type;
	}
	public void setAnn_type(String ann_type) {
		this.ann_type = ann_type;
	}
	public String getAnn_type_nm() {
		return ann_type_nm;
	}
	public void setAnn_type_nm(String ann_type_nm) {
		this.ann_type_nm = ann_type_nm;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_nic() {
		return user_nic;
	}
	public void setUser_nic(String user_nic) {
		this.user_nic = user_nic;
	}
	public int getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(int del_yn) {
		this.del_yn = del_yn;
	}
	public long getReg_id() {
		return reg_id;
	}
	public void setReg_id(long reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public Date getMod_dt() {
		return mod_dt;
	}
	public void setMod_dt(Date mod_dt) {
		this.mod_dt = mod_dt;
	}

	
	
} 