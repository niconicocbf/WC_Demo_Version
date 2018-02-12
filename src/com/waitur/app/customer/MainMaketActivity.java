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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.waitur.app.customer.adapter.MaketInfoMainListViewAdapter;
import com.waitur.app.customer.adapter.PointAdapter;

public class MainMaketActivity extends Activity {
	ListView listView, maket_point_listview;
	RelativeLayout maket_goto_order;
	MaketInfoMainListViewAdapter adapter;
	LinearLayout share, space, share_control, point_pad;
	boolean isShareShow = false;
	PointAdapter adapter2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_maket);
		listView = (ListView) findViewById(R.id.maket_info_listview);
		share = (LinearLayout) findViewById(R.id.share);
		space = (LinearLayout) findViewById(R.id.space);
		point_pad = (LinearLayout) findViewById(R.id.point_pad);
		maket_goto_order = (RelativeLayout) findViewById(R.id.maket_goto_order);
		share_control = (LinearLayout) findViewById(R.id.share_control);
		adapter = new MaketInfoMainListViewAdapter(this);
		listView.setAdapter(adapter);
		maket_point_listview = (ListView) findViewById(R.id.maket_point_listview);
		adapter2 = new PointAdapter(this);
		maket_point_listview.setAdapter(adapter2);
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		maket_goto_order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMaketActivity.this,
						MaketMainMenuInfoActivity.class);
				startActivity(intent);
			}
		});
		findViewById(R.id.title_bg).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		share_control.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				isShareShow = !isShareShow;
				if (isShareShow) {
					share.setVisibility(View.VISIBLE);
					space.setVisibility(View.VISIBLE);
					Animation animation;

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					share.startAnimation(animation);
				} else {

					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 1.0f);
					animation.setDuration(250);
					share.startAnimation(animation);
					animation.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {

						}

						@Override
						public void onAnimationRepeat(Animation animation) {

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							share.setVisibility(View.GONE);
							space.setVisibility(View.GONE);
						}
					});
				}

			}
		});
		space.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				share_control.performClick();
			}
		});
		point_pad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showPointPad(false);
			}
		});
	}

	public void showPointPad(boolean isShow) {
		if (isShow) {
			point_pad.setVisibility(View.VISIBLE);
		} else {
			point_pad.setVisibility(View.GONE);
		}

	}
}
