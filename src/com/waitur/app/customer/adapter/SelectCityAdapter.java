package com.waitur.app.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.waitur.app.customer.R;

public class SelectCityAdapter extends BaseAdapter {

	private String[] countries;
	// private LayoutInflater inflater;
	Context context;

	public SelectCityAdapter(Context context) {
		// inflater = LayoutInflater.from(context);
		this.context = context;
		countries = context.getResources().getStringArray(R.array.countries);
	}

	@Override
	public int getCount() {
		return countries.length;
	}

	@Override
	public Object getItem(int position) {
		return countries[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.listview_select_city, null);
		TextView textView = (TextView) convertView.findViewById(R.id.city_name);
		textView.setText(countries[position]);
		return convertView;
	}

	public int getPositionForSection(char section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = countries[i];
			char firstChar = sortStr.toUpperCase().charAt(0);
			if (firstChar == section) {
				return i;
			}
		}

		return -1;
	}

}
