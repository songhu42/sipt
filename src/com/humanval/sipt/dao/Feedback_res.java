package com.humanval.sipt.dao;

import java.util.Date;

public class Feedback_res {
	private long seq_no;
	private long user_id;
	private String result;
	private int res_yn;
	private int res_type;
	private int res_st;
	private long res_seq;
	private Date reg_dt;

	private String title;
	private String content;
	private String target;
	private int cont_limit;
	
	private int rew_heart_cnt;
	private int rew_damon_cnt;
	private Date valid_dt;

	private String user_nic;
	private int stage;
	private int user_grade;
	private int user_lvl;
	private long user_gold;
	private long user_exp;
	private String wp_item;
	private int wp_lvl;
	private String login_type;
	private String device_token;

	private Date join_dt;
	private int max_heart_cnt;
	private int heart_cnt;
	private int pass_item_cnt;
	private int time_item_cnt;
	private int event_days;
	private Date event_dt;
	private String app_ver; 
	private int user_age;
	private String user_age_nm;
	private String res_type_nm;
	private String res_st_nm;

	private long invitor_id;
	private int buy_cnt;
	private int buy_tot_amt;
	private String result_content; 
	
	public long getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(long seq_no) {
		this.seq_no = seq_no;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getRes_yn() {
		return res_yn;
	}
	public void setRes_yn(int res_yn) {
		this.res_yn = res_yn;
	}
	public int getRes_type() {
		return res_type;
	}
	public void setRes_type(int res_type) {
		this.res_type = res_type;
	}
	public int getRes_st() {
		return res_st;
	}
	public void setRes_st(int res_st) {
		this.res_st = res_st;
	}
	public long getRes_seq() {
		return res_seq;
	}
	public void setRes_seq(long res_seq) {
		this.res_seq = res_seq;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
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
	public int getRew_heart_cnt() {
		return rew_heart_cnt;
	}
	public void setRew_heart_cnt(int rew_heart_cnt) {
		this.rew_heart_cnt = rew_heart_cnt;
	}
	public int getRew_damon_cnt() {
		return rew_damon_cnt;
	}
	public void setRew_damon_cnt(int rew_damon_cnt) {
		this.rew_damon_cnt = rew_damon_cnt;
	}
	public Date getValid_dt() {
		return valid_dt;
	}
	public void setValid_dt(Date valid_dt) {
		this.valid_dt = valid_dt;
	}
	public String getUser_nic() {
		return user_nic;
	}
	public void setUser_nic(String user_nic) {
		this.user_nic = user_nic;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}
	public int getUser_lvl() {
		return user_lvl;
	}
	public void setUser_lvl(int user_lvl) {
		this.user_lvl = user_lvl;
	}
	public long getUser_gold() {
		return user_gold;
	}
	public void setUser_gold(long user_gold) {
		this.user_gold = user_gold;
	}
	public long getUser_exp() {
		return user_exp;
	}
	public void setUser_exp(long user_exp) {
		this.user_exp = user_exp;
	}
	public String getWp_item() {
		return wp_item;
	}
	public void setWp_item(String wp_item) {
		this.wp_item = wp_item;
	}
	public int getWp_lvl() {
		return wp_lvl;
	}
	public void setWp_lvl(int wp_lvl) {
		this.wp_lvl = wp_lvl;
	}
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}
	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}
	public Date getJoin_dt() {
		return join_dt;
	}
	public void setJoin_dt(Date join_dt) {
		this.join_dt = join_dt;
	}
	public int getMax_heart_cnt() {
		return max_heart_cnt;
	}
	public void setMax_heart_cnt(int max_heart_cnt) {
		this.max_heart_cnt = max_heart_cnt;
	}
	public int getHeart_cnt() {
		return heart_cnt;
	}
	public void setHeart_cnt(int heart_cnt) {
		this.heart_cnt = heart_cnt;
	}
	public int getPass_item_cnt() {
		return pass_item_cnt;
	}
	public void setPass_item_cnt(int pass_item_cnt) {
		this.pass_item_cnt = pass_item_cnt;
	}
	public int getTime_item_cnt() {
		return time_item_cnt;
	}
	public void setTime_item_cnt(int time_item_cnt) {
		this.time_item_cnt = time_item_cnt;
	}
	public int getEvent_days() {
		return event_days;
	}
	public void setEvent_days(int event_days) {
		this.event_days = event_days;
	}
	public Date getEvent_dt() {
		return event_dt;
	}
	public void setEvent_dt(Date event_dt) {
		this.event_dt = event_dt;
	}
	
	public String getApp_ver() {
		return app_ver;
	}
	public void setApp_ver(String app_ver) {
		this.app_ver = app_ver;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_age_nm() {
		return user_age_nm;
	}
	public void setUser_age_nm(String user_age_nm) {
		this.user_age_nm = user_age_nm;
	}
	
	public String getRes_type_nm() {
		return res_type_nm;
	}
	public void setRes_type_nm(String res_type_nm) {
		this.res_type_nm = res_type_nm;
	}
	public String getRes_st_nm() {
		return res_st_nm;
	}
	public void setRes_st_nm(String res_st_nm) {
		this.res_st_nm = res_st_nm;
	}
	public long getInvitor_id() {
		return invitor_id;
	}
	public void setInvitor_id(long invitor_id) {
		this.invitor_id = invitor_id;
	}
	public int getBuy_cnt() {
		return buy_cnt;
	}
	public void setBuy_cnt(int buy_cnt) {
		this.buy_cnt = buy_cnt;
	}
	public int getBuy_tot_amt() {
		return buy_tot_amt;
	}
	public void setBuy_tot_amt(int buy_tot_amt) {
		this.buy_tot_amt = buy_tot_amt;
	}
	public String getResult_content() {
		return result_content;
	}
	public void setResult_content(String result_content) {
		this.result_content = result_content;
	}


	
}
