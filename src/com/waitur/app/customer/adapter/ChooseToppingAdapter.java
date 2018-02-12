package com.waitur.app.customer.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.waitur.app.customer.R;

public class ChooseToppingAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	List<Boolean> list = new ArrayList<Boolean>();

	public ChooseToppingAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return 3;
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

	public void setclicked(int index, boolean ischecked) {
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		Boolean boolean1 = false;
		list.add(boolean1);
		ViewHolder holder = new ViewHolder();
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listview_topping_item,
					parent, false);
			holder.text = (TextView) convertView.findViewById(R.id.isclicked);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

	class ViewHolder {
		TextView text;
		TextView item_image;
	}
}
