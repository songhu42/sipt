package com.humanval.hsm.dao;

import com.humanval.hsm.util.ComUtil;

public class DailySales  {
	private String date;
	private String game_type; 
	private String device_type; 
	private int year;
	private int mon; 
	private int day; 
	private int weekday; 
	
	private int new_user;
	private int buy_cnt;
	private long buy_amt;
	private int adv_cnt;
	private int share_tot;
	private int share_fb;
	private int share_cacao;
	private int share_story;
	private int feedback_cnt;
	private int game_user;
	private int game_cnt;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
		if( date.length() > 7 ) {
			year = Integer.parseInt(date.substring(0, 4)); 
			mon = Integer.parseInt(date.substring(4, 6)); 
			day = Integer.parseInt(date.substring(6, 8));
			weekday = ComUtil.getDayOfWeek(date, ""); 
		}
	}
	
	public String getGame_type() {
		return game_type;
	}
	public void setGame_type(String game_type) {
		this.game_type = game_type;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMon() {
		return mon;
	}
	public void setMon(int mon) {
		this.mon = mon;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getWeekday() {
		return weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}
	public int getNew_user() {
		return new_user;
	}
	public void setNew_user(int new_user) {
		this.new_user = new_user;
	}
	public int getBuy_cnt() {
		return buy_cnt;
	}
	public void setBuy_cnt(int buy_cnt) {
		this.buy_cnt = buy_cnt;
	}
	public long getBuy_amt() {
		return buy_amt;
	}
	public void setBuy_amt(long buy_amt) {
		this.buy_amt = buy_amt;
	}
	public int getAdv_cnt() {
		return adv_cnt;
	}
	public void setAdv_cnt(int adv_cnt) {
		this.adv_cnt = adv_cnt;
	}
	public int getShare_tot() {
		return share_tot;
	}
	public void setShare_tot(int share_tot) {
		this.share_tot = share_tot;
	}
	public int getShare_fb() {
		return share_fb;
	}
	public void setShare_fb(int share_fb) {
		this.share_fb = share_fb;
	}
	public int getShare_cacao() {
		return share_cacao;
	}
	public void setShare_cacao(int share_cacao) {
		this.share_cacao = share_cacao;
	}
	public int getShare_story() {
		return share_story;
	}
	public void setShare_story(int share_story) {
		this.share_story = share_story;
	}
	public int getFeedback_cnt() {
		return feedback_cnt;
	}
	public void setFeedback_cnt(int feedback_cnt) {
		this.feedback_cnt = feedback_cnt;
	}
	public int getGame_user() {
		return game_user;
	}
	public void setGame_user(int game_user) {
		this.game_user = game_user;
	}
	public int getGame_cnt() {
		return game_cnt;
	}
	public void setGame_cnt(int game_cnt) {
		this.game_cnt = game_cnt;
	}
	
	
} 