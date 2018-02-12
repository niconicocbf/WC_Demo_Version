package com.waitur.app.customer.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.waitur.app.customer.R;

public class MaketInfoGalleryAdpter extends BaseAdapter {
	Context context;
	List<Integer> list = new ArrayList<Integer>();

	public MaketInfoGalleryAdpter(Context context) {
		this.context = context;
		list.add(R.drawable.pic01);
		list.add(R.drawable.pic02);
		list.add(R.drawable.pic03);
		list.add(R.drawable.pic04);
		list.add(R.drawable.pic01);
		list.add(R.drawable.pic02);
		list.add(R.drawable.pic03);
		list.add(R.drawable.pic04);
	}

	@Override
	public int getCount() {
		return list.size();
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
		LayoutInflater mInflater = LayoutInflater.from(context);
		convertView = mInflater.inflate(R.layout.gallery_image, null);
		// ImageView imageView =(ImageView)
		// convertView.findViewById(R.id.maket_info);
		// imageView.setBackgroundResource(list.get(position));
		// return convertView; 85*85TODO
		ImageView imageView = (ImageView) convertView.findViewById(R.id.img);
		imageView.setImageResource(list.get(position));
		return convertView;

	}

}
