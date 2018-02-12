package com.waitur.app.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.waitur.app.customer.R;

public class RewardtAdapter extends BaseAdapter {

	Context context;

	public RewardtAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 4;
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
		if (position == 0) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_reward, null);
		} else if (position == 1) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_reward, null);
		} else if (position == 2) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_reward, null);
			convertView.findViewById(R.id.text_line).setVisibility(View.INVISIBLE);
			return convertView;
		} else if (position == 3) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_rewardfooter, null);
		}

		return convertView;
	}
}
