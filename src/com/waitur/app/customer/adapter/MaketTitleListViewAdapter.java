package com.waitur.app.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.waitur.app.customer.R;

public class MaketTitleListViewAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;

	public MaketTitleListViewAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return 2;
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
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.listview_maket_title,
					parent, false);
			holder.text = (TextView) convertView
					.findViewById(R.id.text_context);
			holder.item_image = (TextView) convertView
					.findViewById(R.id.text_icon);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		switch (position) {
		case 0:
			holder.text.setText("2500 Mket St.San Francisco");
			holder.item_image
					.setBackgroundResource(R.drawable.maket_title_num1);
			break;
		case 1:
			holder.text.setText("217-989-8989");
			holder.item_image
					.setBackgroundResource(R.drawable.maket_title_num2);
			break;
		case 2:
			holder.text.setText("2500 Mket St.San Francisco");
			holder.item_image
					.setBackgroundResource(R.drawable.maket_title_num1);
			break;
		case 3:
			holder.text.setText("217-989-8989");
			holder.item_image
					.setBackgroundResource(R.drawable.maket_title_num2);
			break;

		default:
			break;
		}

		return convertView;
	}

	class ViewHolder {
		TextView text;
		TextView item_image;
	}
}
