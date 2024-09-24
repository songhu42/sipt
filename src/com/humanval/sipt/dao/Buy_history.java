package com.humanval.sipt.dao;

import java.util.Date;

public class Buy_history {
	private long user_id;
	private String item_id;
	private int seq_no;
	private long add_heart;
	private long add_max_heart;
	private Date reg_dt;
	private String receipt_id; 

	private String item_nm;
	private int item_price; 
	
	private String user_nic;
	private int stage;
	private int user_grade;
	private int user_lvl;
	private long user_gold;
	private long user_exp;
	private String wp_item;
	private String login_type;
	private String device_token;

	private Date join_dt;
	private int max_heart_cnt;
	private int heart_cnt;
	private int user_age;
	private String user_age_nm;

	private int buy_cnt = 0;
	private long buy_tot_amt = 0;
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public int getSeq_no() {
		return seq_no;
	}
	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}
	public long getAdd_heart() {
		return add_heart;
	}
	public void setAdd_heart(long add_heart) {
		this.add_heart = add_heart;
	}
	public long getAdd_max_heart() {
		return add_max_heart;
	}
	public void setAdd_max_heart(long add_max_heart) {
		this.add_max_heart = add_max_heart;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	public String getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}
	public String getItem_nm() {
		return item_nm;
	}
	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
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
	public int getBuy_cnt() {
		return buy_cnt;
	}
	public void setBuy_cnt(int buy_cnt) {
		this.buy_cnt = buy_cnt;
	}
	public long getBuy_tot_amt() {
		return buy_tot_amt;
	}
	public void setBuy_tot_amt(long buy_tot_amt) {
		this.buy_tot_amt = buy_tot_amt;
	}


	
}
