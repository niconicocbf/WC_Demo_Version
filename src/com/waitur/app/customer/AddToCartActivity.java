package com.waitur.app.customer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.waitur.app.customer.adapter.AddToCartAdapter;
import com.waitur.app.customer.adapter.TestBaseAdapter;

public class AddToCartActivity extends Activity {

	// RelativeLayout dishes_sides, dishes_toppings, dishes_other;
	LinearLayout dishes_dot1, dishes_dot2, dishes_dot3;
	ListView listView;
	ListView avtiveListView;
	TextView dishes_mut, dishes_content, dishes_add, option_price;
	int count = 1;
	int position;
	RelativeLayout maket_goto_order;
	public static int price = 15;
	AddToCartAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_item_option);
		// dishes_sides = (RelativeLayout) findViewById(R.id.dishes_sides);
		// dishes_toppings = (RelativeLayout)
		// findViewById(R.id.dishes_toppings);
		// dishes_other = (RelativeLayout) findViewById(R.id.dishes_other);
		dishes_dot1 = (LinearLayout) findViewById(R.id.dishes_dot1);
		dishes_dot2 = (LinearLayout) findViewById(R.id.dishes_dot2);
		dishes_dot3 = (LinearLayout) findViewById(R.id.dishes_dot3);
		dishes_mut = (TextView) findViewById(R.id.dishes_mut);
		dishes_content = (TextView) findViewById(R.id.dishes_content);
		dishes_add = (TextView) findViewById(R.id.dishes_add);
		option_price = (TextView) findViewById(R.id.option_price);
		listView = (ListView) findViewById(R.id.side_listview);
		avtiveListView = (ListView) findViewById(R.id.listview);
		adapter = new AddToCartAdapter(this);
		avtiveListView.setAdapter(adapter);
		position = getIntent().getIntExtra("pay", 0);
		maket_goto_order = (RelativeLayout) findViewById(R.id.maket_goto_order);
		Animation animation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(250);
		findViewById(R.id.dishes_pad).startAnimation(animation);
		avtiveListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(AddToCartActivity.this,
							ChooseSideActivity.class);
					startActivity(intent);
				} else if (position == 1) {
					Intent intent = new Intent(AddToCartActivity.this,
							ChooseToppingActivity.class);
					startActivity(intent);
				} else if (position == 2) {

				}
			}
		});
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Animation animation = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 1.0f,
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 0.0f);
				animation.setDuration(250);
				findViewById(R.id.dishes_pad).startAnimation(animation);
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {

					}

					@Override
					public void onAnimationRepeat(Animation animation) {

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						findViewById(R.id.dishes_pad).setVisibility(View.GONE);
						finish();
					}
				});

			}
		});
		dishes_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				count++;
				dishes_content.setText("" + count);
				option_price.setText("$" + (price * count) + ".00");
			}
		});
		dishes_mut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (count != 1) {
					count--;
					dishes_content.setText("" + count);
					option_price.setText("$" + (price * count) + ".00");
				}
			}
		});
		maket_goto_order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				TestBaseAdapter.list.get(position).setCount(
						TestBaseAdapter.list.get(position).getCount() + count);
				Animation animation = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 1.0f,
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 0.0f);
				animation.setDuration(250);
				findViewById(R.id.dishes_pad).startAnimation(animation);
				animation.setAnimationListener(new AnimationListener() {

					@Override
					public void onAnimationStart(Animation animation) {

					}

					@Override
					public void onAnimationRepeat(Animation animation) {

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						findViewById(R.id.dishes_pad).setVisibility(View.GONE);
						finish();
					}
				});
				// Animation animation = new TranslateAnimation(
				// Animation.RELATIVE_TO_SELF, 0.0f,
				// Animation.RELATIVE_TO_SELF, 1.0f,
				// Animation.RELATIVE_TO_SELF, 0.0f,
				// Animation.RELATIVE_TO_SELF, 0.0f);
				// animation.setDuration(250);
				// findViewById(R.id.dishes_pad).startAnimation(animation);
				// animation.setAnimationListener(new AnimationListener() {
				//
				// @Override
				// public void onAnimationStart(Animation animation) {
				// // TODO Auto-generated method stub
				//
				// }
				//
				// @Override
				// public void onAnimationRepeat(Animation animation) {
				// // TODO Auto-generated method stub
				//
				// }
				//
				// @Override
				// public void onAnimationEnd(Animation animation) {
				// finish();
				//
				// }
				// });
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (adapter.getEditText() != null) {
			adapter.getEditText().clearFocus();
		}
	}

	@Override
	protected void onStop() {
		price = 0;
		super.onStop();
	}
}
