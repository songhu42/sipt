package com.humanval.sipt.dao;

import java.util.Date;

public class Feedback_mst  {
	private long seq_no;
	private String title="";
	private String content="";
	
	private String target="";
	private int cont_limit=0;
	private int heart_cnt=0;
	private int damon_cnt=0;
	
	private String game_type="";
	private Date valid_dt;
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
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getCont_limit() {
		return cont_limit;
	}
	public void setCont_limit(int cont_limit) {
		this.cont_limit = cont_limit;
	}
	public int getHeart_cnt() {
		return heart_cnt;
	}
	public void setHeart_cnt(int heart_cnt) {
		this.heart_cnt = heart_cnt;
	}
	public int getDamon_cnt() {
		return damon_cnt;
	}
	public void setDamon_cnt(int damon_cnt) {
		this.damon_cnt = damon_cnt;
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