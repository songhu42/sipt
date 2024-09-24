package com.humanval.sipt.dao;

import java.util.Date;

public class Word_sync_his {
	private long seq_no; 
	private String sql_str="";
	private int exe_yn = 0; 
	private int db_ver = 0; 
	private Date reg_dt;
	public long getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(long seq_no) {
		this.seq_no = seq_no;
	}
	public String getSql_str() {
		return sql_str;
	}
	public void setSql_str(String sql_str) {
		this.sql_str = sql_str;
	}
	public int getExe_yn() {
		return exe_yn;
	}
	public void setExe_yn(int exe_yn) {
		this.exe_yn = exe_yn;
	}
	public int getDb_ver() {
		return db_ver;
	}
	public void setDb_ver(int db_ver) {
		this.db_ver = db_ver;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	
	
} 