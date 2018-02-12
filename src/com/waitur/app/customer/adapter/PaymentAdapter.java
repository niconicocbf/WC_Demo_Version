package com.waitur.app.customer.adapter;

import com.waitur.app.customer.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PaymentAdapter extends BaseAdapter {

	Context context;

	public PaymentAdapter(Context context) {
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position == 4) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_payment_footer, null);
			return convertView;
		}
		convertView = LayoutInflater.from(context).inflate(
				R.layout.listview_payment_item, null);
		if (position == 3) {
			convertView.findViewById(R.id.line).setVisibility(View.GONE);
		}
		return convertView;
	}

}
