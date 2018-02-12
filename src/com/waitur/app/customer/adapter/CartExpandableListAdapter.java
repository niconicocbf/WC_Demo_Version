package com.waitur.app.customer.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.waitur.app.customer.CartConnfirmationActivity;
import com.waitur.app.customer.R;
import com.waitur.app.customer.Bean.DishInfo;

public class CartExpandableListAdapter extends BaseExpandableListAdapter {
	List<String> heard = new ArrayList<String>();;
	Map<String, List<DishInfo>> maps = new HashMap<String, List<DishInfo>>();
	Context context;

	public CartExpandableListAdapter(Context context) {
		this.context = context;

	}

	public void updateData() {
		maps = new HashMap<String, List<DishInfo>>();
		heard = new ArrayList<String>();
		int size = TestBaseAdapter.list.size();
		List<DishInfo> list = null;

		for (int i = 0; i < size; i++) {
			DishInfo dishInfo = TestBaseAdapter.list.get(i);
			TestBaseAdapter.list.get(i).setWhich(i);
			if (dishInfo.getCount() != 0) {
				if (!heard.contains(dishInfo.getType())) {
					if (heard.size() > maps.size()) {
						maps.put(heard.get(heard.size() - 1), list);
					}
					heard.add(dishInfo.getType());
					list = new ArrayList<DishInfo>();
				}
				list.add(dishInfo);
			}
		}
		if (heard.size() > maps.size()) {
			maps.put(heard.get(heard.size() - 1), list);
		}
		this.notifyDataSetChanged();
		((CartConnfirmationActivity) context).setExpandbleListExpand();
		setPay(false);
	}

	@Override
	public int getGroupCount() {
		return heard.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		List<DishInfo> list = maps.get(heard.get(groupPosition));
		if (heard.size() == 0) {
			return 0;
		}
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.expandablelistview_group_item, null);
		((TextView) convertView.findViewById(R.id.text)).setText(heard
				.get(groupPosition));
		return convertView;
	}

	// ExpandableListBean bean;

	@Override
	public View getChildView(final int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.expandablelistview_child_item, null);
		TextView dishes_add = (TextView) convertView
				.findViewById(R.id.dishes_add);
		final TextView content_middle = (TextView) convertView
				.findViewById(R.id.content_middle);
		TextView dishes_subtract = (TextView) convertView
				.findViewById(R.id.dishes_subtract);
		final TextView text_count = (TextView) convertView
				.findViewById(R.id.text_count);
		final View view = convertView.findViewById(R.id.pad);
		// ///////////////////////////
		final DishInfo dishInfo = maps.get(heard.get(groupPosition)).get(
				childPosition);

		if (dishInfo.isCartPadShow()) {
			view.setVisibility(View.VISIBLE);
			text_count.setVisibility(View.GONE);
		} else {
			view.setVisibility(View.GONE);
			text_count.setVisibility(View.VISIBLE);
		}
		text_count.setText("" + dishInfo.getCount());
		content_middle.setText("" + dishInfo.getCount());
		// /////////////////////////////////////////
		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				view.setVisibility(View.VISIBLE);
				for (int i = 0; i < heard.size(); i++) {
					for (DishInfo element : maps.get(heard.get(i))) {
						element.setCartPadShow(false);
					}
				}
				dishInfo.setCartPadShow(true);
				CartExpandableListAdapter.this.notifyDataSetChanged();
				((CartConnfirmationActivity) context).setExpandbleListExpand();
			}
		});

		dishes_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				content_middle.setText(dishInfo.getCount() + 1 + "");
				text_count.setText(dishInfo.getCount() + 1 + "");
				TestBaseAdapter.list.get(dishInfo.getWhich()).setCount(
						dishInfo.getCount());
				maps.get(heard.get(groupPosition)).get(childPosition)
						.setCount(dishInfo.getCount() + 1);
				setPay(true);
			}
		});
		dishes_subtract.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (dishInfo.getCount() == 1) {
					TestBaseAdapter.list.get(dishInfo.getWhich()).setCount(0);
					for (int i = 0; i < heard.size(); i++) {
						for (DishInfo element : maps.get(heard.get(i))) {
							element.setCartPadShow(false);
						}
					}
					setPay(true);
					updateData();
					return;
				}
				content_middle.setText(dishInfo.getCount() - 1 + "");
				text_count.setText(dishInfo.getCount() - 1 + "");
				maps.get(heard.get(groupPosition)).get(childPosition)
						.setCount(dishInfo.getCount() - 1);
				setPay(true);
			}
		});
		return convertView;
	}

	private void setPay(boolean isNeedAnimation) {
		int index = 0, price = 0;
		for (int i = 0; i < TestBaseAdapter.list.size(); i++) {
			if (TestBaseAdapter.list.get(i).getCount() != 0) {
				index = index + TestBaseAdapter.list.get(i).getCount();
				price = price + TestBaseAdapter.list.get(i).getCount() * 12;
			}
		}
//		((MaketMainMenuInfoActivity) context).setPay_num("" + index,
//				price + "", isNeedAnimation);
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

}
