package com.ls.domain;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private byte isAgent;
	private String referee;
	private byte isTake;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReferee() {
		return referee;
	}
	public void setReferee(String referee) {
		this.referee = referee;
	}
	public byte getIsAgent() {
		return isAgent;
	}
	public void setIsAgent(byte isAgent) {
		this.isAgent = isAgent;
	}
	public byte getIsTake() {
		return isTake;
	}
	public void setIsTake(byte isTake) {
		this.isTake = isTake;
	}
	
}
