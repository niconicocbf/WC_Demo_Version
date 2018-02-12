package com.waitur.app.customer.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.emilsjolander.components.stickylistheaders.StickyListHeadersAdapter;
import com.waitur.app.customer.AddToCartActivity;
import com.waitur.app.customer.DishesDetialInfoActivity;
import com.waitur.app.customer.MaketMainMenuInfoActivity;
import com.waitur.app.customer.R;
import com.waitur.app.customer.Bean.DishInfo;

public class TestBaseAdapter extends BaseAdapter implements
		StickyListHeadersAdapter, SectionIndexer {
	Context context;
	private LayoutInflater inflater;
	public static List<DishInfo> list = new ArrayList<DishInfo>();
	List<String> sections;

	public TestBaseAdapter(Context context) {
		inflater = LayoutInflater.from(context);
		list = new ArrayList<DishInfo>();
		sections = new ArrayList<String>();
		this.context = context;
		List<DishInfo> dishInfos = new ArrayList<DishInfo>();
		for (int i = 0; i < 10; i++) {
			dishInfos.add(new DishInfo("Appitizer", 0, false));
		}
		sections.add("Appitizer");
		for (int i = 0; i < 10; i++) {
			dishInfos.add(new DishInfo("Entree", 1, true));
		}
		sections.add("Entree");
		for (int i = 0; i < 10; i++) {
			dishInfos.add(new DishInfo("Chinese", 2, false));
		}
		sections.add("Chinese");
		for (int i = 0; i < 10; i++) {
			dishInfos.add(new DishInfo("Drinks", 3, false));
		}
		sections.add("Drinks");
		for (int i = 0; i < 10; i++) {
			dishInfos.add(new DishInfo("Wangyong", 4, false));
		}
		list.addAll(dishInfos);
		sections.add("Wangyong");
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.test_list_item_layout,
					parent, false);
			holder.item_image = (ImageView) convertView
					.findViewById(R.id.item_image);
			holder.dishes_add = (TextView) convertView
					.findViewById(R.id.dishes_add);
			holder.dishes_number = (TextView) convertView
					.findViewById(R.id.dishes_number);
			holder.dishes_subtract = (TextView) convertView
					.findViewById(R.id.dishes_subtract);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.dishes_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int count = list.get(position).getCount() + 1;
				if (list.get(position).isHasOption()) {
					Intent intent = new Intent(context, AddToCartActivity.class);
					intent.putExtra("pay", position);
					context.startActivity(intent);
					return;
				}
				if (count == 1) {
					holder.dishes_subtract.setVisibility(View.VISIBLE);
					holder.dishes_number.setVisibility(View.VISIBLE);
					Animation animation = new AlphaAnimation(0.0f, 1.0f);
					animation.setDuration(500);

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					holder.dishes_number.startAnimation(animation);

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 2.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(500);
					holder.dishes_subtract.startAnimation(animation);

				}
				holder.dishes_number.setText(count + "");
				list.get(position).setCount(count);
				setPay(true);
			}
		});

		holder.dishes_subtract.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int count = list.get(position).getCount() - 1;
				if (count < 0) {
					return;
				}
				if (count == 0) {
					Animation animation;

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					animation.setFillAfter(true);
					holder.dishes_number.startAnimation(animation);

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 2.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(500);
					animation.setFillAfter(true);
					animation.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {

						}

						@Override
						public void onAnimationRepeat(Animation animation) {

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							holder.dishes_subtract.setVisibility(View.GONE);
							holder.dishes_number.setVisibility(View.GONE);
						}
					});
					holder.dishes_subtract.startAnimation(animation);
				}
				holder.dishes_number.setText(count + "");
				list.get(position).setCount(count);
				setPay(true);
			}
		});
		if (list.get(position).getCount() != 0) {
			holder.dishes_number.setVisibility(View.VISIBLE);
			holder.dishes_subtract.setVisibility(View.VISIBLE);
			holder.dishes_number.setText(list.get(position).getCount() + "");
		} else {
			holder.dishes_number.setVisibility(View.GONE);
			holder.dishes_subtract.setVisibility(View.GONE);
		}

		holder.item_image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context,
						DishesDetialInfoActivity.class);
				intent.putExtra("wangyong", position);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				context.startActivity(intent);
			}
		});
		return convertView;
	}

	@Override
	public int getPositionForSection(int section) {
		if (section >= sections.size()) {
			section = sections.size() - 1;
		} else if (section < 0) {
			section = 0;
		}
		int position = 0;
		for (int i = 0; i < list.size(); i++) {
			if (sections.get(section) == list.get(i).getType()) {
				position = i;
				break;
			}
		}
		return position;
	}

	@Override
	public int getSectionForPosition(int position) {
		if (position >= list.size()) {
			position = list.size() - 1;
		} else if (position < 0) {
			position = 0;
		}
		return list.get(position).getId();
	}

	@Override
	public Object[] getSections() {
		return sections.toArray(new String[sections.size()]);
	}

	@Override
	public long getHeaderId(int arg0) {
		return list.get(arg0).getId();
	}

	@Override
	public View getHeaderView(int position, View convertView, ViewGroup parent) {
		HeaderViewHolder holder;
		if (convertView == null) {
			holder = new HeaderViewHolder();
			convertView = inflater.inflate(R.layout.listview_maket_dishes,
					parent, false);
			holder.text = (TextView) convertView.findViewById(R.id.text);
			convertView.setTag(holder);
		} else {
			holder = (HeaderViewHolder) convertView.getTag();
		}
		holder.text.setText(list.get(position).getType());
		return convertView;
	}

	class HeaderViewHolder {
		TextView text;
	}

	class ViewHolder {
		ImageView item_image;
		TextView dishes_add;
		TextView dishes_number;
		TextView dishes_subtract;
	}

	public void setPay(boolean isNeedAnimation) {
		int index = 0, price = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCount() != 0) {
				index = index + list.get(i).getCount();
				price = price + list.get(i).getCount() * 12;
			}
		}

		((MaketMainMenuInfoActivity) context).setPay_num("" + index,
				price + "", isNeedAnimation);

	}

	public void clearAll() {
		list = new ArrayList<DishInfo>();
		sections.clear();
	}

	public List<String> getSection() {
		return sections;
	}
}
