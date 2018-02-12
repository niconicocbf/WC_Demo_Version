package com.waitur.app.customer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.waitur.app.customer.adapter.ChooseToppingAdapter;

public class ChooseToppingActivity extends Activity {
	ListView listView;
	ChooseToppingAdapter adapter;
	RelativeLayout maket_goto_order;
	int price = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chooses_topping);
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(250);
		findViewById(R.id.side_pad).startAnimation(animation);
		listView = (ListView) findViewById(R.id.side_listview);
		maket_goto_order = (RelativeLayout) findViewById(R.id.maket_goto_order);
		adapter = new ChooseToppingAdapter(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				boolean flag = !adapter.getisclicked().get(position);
				if (flag) {
					view.findViewById(R.id.isclicked).setBackgroundResource(
							R.drawable.side_item_sel);
					price = price + 5;
				} else {
					view.findViewById(R.id.isclicked).setBackgroundResource(
							R.drawable.side_item);
					price = price - 5;
				}
				adapter.getisclicked().set(position, flag);

			}
		});
		maket_goto_order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AddToCartActivity.price = AddToCartActivity.price + price;
				finish();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);
			}
		});
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);
			}
		});
	}

	@Override
	protected void onStop() {
		price = 0;
		super.onStop();
	}
}
