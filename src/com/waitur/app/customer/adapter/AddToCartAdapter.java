package com.waitur.app.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.waitur.app.customer.R;

public class AddToCartAdapter extends BaseAdapter {

	Context context;

	public AddToCartAdapter(Context context) {
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

	EditText editText;

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position == 0) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.add_to_cart_item1, null);
		} else if (position == 1) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.add_to_cart_item2, null);
		} else if (position == 2) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.add_to_cart_item3, null);
		} else if (position == 3) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.add_to_cart_item4, null);
			editText = (EditText) convertView.findViewById(R.id.edit_intr);
			// final EditText editText = ((EditText) convertView
			// .findViewById(R.id.edit_intr));
			// editText.setOnFocusChangeListener(new OnFocusChangeListener() {
			//
			// @Override
			// public void onFocusChange(View v, boolean hasFocus) {
			// if (hasFocus) {
			// // editText.setSelection(0);
			//
			// }
			//
			// }
			// });
		}

		return convertView;
	}

	public EditText getEditText() {
		return editText;
	}
}
