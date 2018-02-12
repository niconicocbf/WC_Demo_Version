package com.waitur.app.customer.Bean;

public class ExpandableListBean {
	boolean isPadShow;
	boolean isItemShow = true;
	int count;

	public ExpandableListBean(boolean isPadShow, int count) {
		super();
		this.isPadShow = isPadShow;
		this.count = count;
	}

	public boolean isPadShow() {
		return isPadShow;
	}

	public void setPadShow(boolean isPadShow) {
		this.isPadShow = isPadShow;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isItemShow() {
		return isItemShow;
	}

	public void setItemShow(boolean isItemShow) {
		this.isItemShow = isItemShow;
	}

}
