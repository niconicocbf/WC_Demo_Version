package com.waitur.app.customer.Bean;

public class DishInfo {

	int id = 0;
	int count = 0;
	String name = "wangyong";
	String price = "wangyong";
	String img = "wangyong";
	String score = "wangyong";
	String type = "wangyong";
	// 控制购物车pad显示
	boolean isCartPadShow = false;
	int which;

	boolean isHasOption = false;

	public DishInfo() {
	}

	public DishInfo(String type, int id, boolean isHasOption) {
		this.type = type;
		this.id = id;
		this.isHasOption = isHasOption;
	}

	public DishInfo(int count, String name, String price, String img,
			String score, String type) {
		super();
		this.count = count;
		this.name = name;
		this.price = price;
		this.img = img;
		this.score = score;
		this.type = type;
	}

	public boolean isHasOption() {
		return isHasOption;
	}

	public void setHasOption(boolean isHasOption) {
		this.isHasOption = isHasOption;
	}

	public boolean isCartPadShow() {
		return isCartPadShow;
	}

	public void setCartPadShow(boolean isCartPadShow) {
		this.isCartPadShow = isCartPadShow;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getWhich() {
		return which;
	}

	public void setWhich(int which) {
		this.which = which;
	}

}
