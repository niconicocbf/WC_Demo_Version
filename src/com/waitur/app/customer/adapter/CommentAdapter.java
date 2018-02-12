package com.waitur.app.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.waitur.app.customer.R;

public class CommentAdapter extends BaseAdapter {

	Context context;

	public CommentAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 24;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.listview_main_maket_info_item, null);
		return convertView;
	}
}
