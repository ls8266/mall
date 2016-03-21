package com.ls.domain;

public class GoodsPhoto {
	private int id;
	private Goods goods;
	private String photoName;
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
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
}
