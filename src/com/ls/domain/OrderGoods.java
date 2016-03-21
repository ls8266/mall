package com.ls.domain;

public class OrderGoods {
	private int id;
	private Order order;
	private Goods goods;
	private int number;
	private float total;
	private float realTotal;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getRealTotal() {
		return realTotal;
	}
	public void setRealTotal(float realTotal) {
		this.realTotal = realTotal;
	}
	
	
}
