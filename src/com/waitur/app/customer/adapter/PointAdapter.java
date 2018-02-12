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

public class PointAdapter extends BaseAdapter {

	Context context;
	List<String> list = new ArrayList<String>();

	public PointAdapter(Context context) {
		this.context = context;
		list.add("Monday");
		list.add("Tuesday");
		list.add("Wednesday");
		list.add("Thursday");
		list.add("Friday");
		list.add("Saturday");
		list.add("Sunday");
	}

	@Override
	public int getCount() {
		return 8;
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

	TextView point_data;

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position == 7) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.point_item1, null);
			return convertView;
		}
		convertView = LayoutInflater.from(context).inflate(R.layout.point_item,
				null);
		point_data = (TextView) convertView.findViewById(R.id.point_data);
		point_data.setText(list.get(position));

		return convertView;
	}
}
