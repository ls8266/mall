package com.ls.domain;

public class Goods {
	private int id;
	private String name;
	private int number;
	private float money;
	private float realMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public float getRealMoney() {
		return realMoney;
	}
	public void setRealMoney(float realMoney) {
		this.realMoney = realMoney;
	}
	
}
