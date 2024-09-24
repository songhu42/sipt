package com.humanval.sipt.dao;

import java.util.Date;

public class Sync_data_info {
	private int db_ver; 
	private int seq_no; 
	private int db_type = 1; 
	private String sql_str="";
	private Date reg_dt;
	
	public int getDb_ver() {
		return db_ver;
	}
	public void setDb_ver(int db_ver) {
		this.db_ver = db_ver;
	}
	public int getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}
	public int getDb_type() {
		return db_type;
	}
	public void setDb_type(int db_type) {
		this.db_type = db_type;
	}
	public String getSql_str() {
		return sql_str;
	}
	public void setSql_str(String sql_str) {
		this.sql_str = sql_str;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	
	
} 