package com.waitur.app.customer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.waitur.app.customer.adapter.CartExpandableListAdapter;
import com.waitur.app.customer.adapter.CartTitleListViewAdapter;

public class CartConnfirmationActivity extends Activity {
	ExpandableListView expandableListView;
	CartExpandableListAdapter expandableListAdapter;
	RelativeLayout send_order, tips;
	ListView title_listview;
	LinearLayout space;
	boolean isSpaceShow = false;
	CartTitleListViewAdapter listviewAdapter;
	TextView tips_percent;
	View maket_menu_up_down;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_cart_connfirmation);
		expandableListView = (ExpandableListView) findViewById(R.id.expandble);
		View convertView = LayoutInflater.from(this).inflate(
				R.layout.expandable_footer, null);
		expandableListView.addFooterView(convertView);
		expandableListAdapter = new CartExpandableListAdapter(this);
		expandableListView.setAdapter(expandableListAdapter);
		expandableListView.setGroupIndicator(null);
		expandableListAdapter.updateData();
		title_listview = (ListView) findViewById(R.id.title_listview);
		listviewAdapter = new CartTitleListViewAdapter(this);
		title_listview.setAdapter(listviewAdapter);
		title_listview.setSelection(16);
		space = (LinearLayout) findViewById(R.id.title_list);
		tips = (RelativeLayout) findViewById(R.id.tips);
		send_order = (RelativeLayout) findViewById(R.id.send_order);
		tips_percent = (TextView) findViewById(R.id.tips_percent);
		maket_menu_up_down = findViewById(R.id.maket_menu_up_down);
		send_order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CartConnfirmationActivity.this,
						PaymentActivity.class);
				startActivity(intent);
			}
		});
		space.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tips.performClick();
			}
		});
		tips.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				isSpaceShow = !isSpaceShow;
				if (isSpaceShow) {
					space.setVisibility(View.VISIBLE);
					maket_menu_up_down
							.setBackgroundResource(R.drawable.maket_menu_down);
					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					title_listview.startAnimation(animation);
				} else {
					maket_menu_up_down
							.setBackgroundResource(R.drawable.maket_menu_up);
					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 1.0f);
					animation.setDuration(250);
					title_listview.startAnimation(animation);
					animation.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {

						}

						@Override
						public void onAnimationRepeat(Animation animation) {

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							space.setVisibility(View.GONE);

						}
					});

				}
			}
		});
		title_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long arg3) {
				for (int i = 0; i < listviewAdapter.getisclicked().size(); i++) {
					listviewAdapter.getisclicked().set(i, false);
				}
				listviewAdapter.getisclicked().set(position, true);
				listviewAdapter.notifyDataSetChanged();
				tips_percent.setText( position + "%");
				tips.performClick();
			}
		});

	}

	public void setExpandbleListExpand() {
		for (int i = 0; i < expandableListAdapter.getGroupCount(); i++) {
			expandableListView.expandGroup(i);
		}
	}
}
