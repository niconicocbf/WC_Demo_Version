package com.waitur.app.customer.adapter;

import com.waitur.app.customer.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PaymentSelectAdapter extends BaseAdapter {
	int index = 0;
	Context context;

	public PaymentSelectAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		this.notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position == 4) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_payment_footer, null);
			return convertView;
		}

		convertView = LayoutInflater.from(context).inflate(
				R.layout.listview_payment_select_item, null);
		if (position == index) {
			convertView.findViewById(R.id.selected).setBackgroundResource(
					R.drawable.side_item_sel);
		}
		return convertView;
	}

}
