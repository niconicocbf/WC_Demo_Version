package com.waitur.app.customer.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.waitur.app.customer.R;

public class CartTitleListViewAdapter extends BaseAdapter {
	Context context;
	List<Boolean> list = new ArrayList<Boolean>();

	public CartTitleListViewAdapter(Context context) {
		this.context = context;
		for (int i = 0; i < 101; i++) {
			Boolean boolean1 = false;
			list.add(boolean1);
		}
		list.set(18, true);
	}

	@Override
	public int getCount() {
		return 101;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public List<Boolean> getisclicked() {
		return list;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.listview_cart_title, null);
		((TextView) convertView.findViewById(R.id.distence)).setText(position+"%");
		if (list.get(position)) {
			((TextView) convertView.findViewById(R.id.distence))
					.setTextColor(context.getResources()
							.getColor(R.color.title));
		}
		return convertView;
	}
}
