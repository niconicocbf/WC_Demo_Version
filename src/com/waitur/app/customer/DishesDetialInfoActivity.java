package com.waitur.app.customer;

import java.util.ArrayList;
import java.util.List;

import com.waitur.app.customer.adapter.TestBaseAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DishesDetialInfoActivity extends Activity {
	LinearLayout space;
	RelativeLayout content;
	ViewPager dishes_viewpager;
	int which;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.acitivity_deshes_detial);
		space = (LinearLayout) findViewById(R.id.space);
		dishes_viewpager = (ViewPager) findViewById(R.id.dishes_viewpager);
		space.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		LayoutInflater mLi = LayoutInflater.from(this);
		final ArrayList<View> views = new ArrayList<View>();
		for (int i = 0; i < TestBaseAdapter.list.size(); i++) {
			View view1 = mLi.inflate(R.layout.viewpaper_dishes_item, null);
			setonclick(view1, i);
			views.add(view1);
		}
		which = getIntent().getIntExtra("wangyong", 0);
		// Ìî³äViewPagerµÄÊý¾ÝÊÊÅäÆ÷
		PagerAdapter mPagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(views.get(position));
			}

			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}
		};
		dishes_viewpager.setAdapter(mPagerAdapter);
		dishes_viewpager.setCurrentItem(which);
	}

	List<Integer> count = new ArrayList<Integer>();

	private void setonclick(View view, final int index) {
		final TextView dishes_subtract, dishes_number, dishes_add;
		dishes_subtract = (TextView) view.findViewById(R.id.dishes_subtract);
		dishes_number = (TextView) view.findViewById(R.id.dishes_number);
		dishes_add = (TextView) view.findViewById(R.id.dishes_add);
		if (TestBaseAdapter.list.get(index).getCount() > 0) {
			dishes_subtract.setVisibility(View.VISIBLE);
			dishes_number.setVisibility(View.VISIBLE);
			dishes_number.setText(""
					+ TestBaseAdapter.list.get(index).getCount());
			count.add(TestBaseAdapter.list.get(index).getCount());
		} else {

			count.add(0);
		}
		dishes_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int temp = count.get(index);
				count.set(index, temp + 1);
				if (temp == 0) {
					dishes_subtract.setVisibility(View.VISIBLE);
					dishes_number.setVisibility(View.VISIBLE);
					dishes_number.setText(temp + 1 + "");
					Animation animation = new AlphaAnimation(0.0f, 1.0f);
					animation.setDuration(500);

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					dishes_number.startAnimation(animation);

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 2.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(500);
					dishes_subtract.startAnimation(animation);

				} else {
					dishes_number.setText(temp + 1 + "");
				}
				TestBaseAdapter.list.get(index).setCount(count.get(index));
			}
		});
		dishes_subtract.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int temp = count.get(index);
				if (temp == 1) {
					dishes_number.setText(temp - 1 + "");
					Animation animation;

					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					animation.setFillAfter(true);
					dishes_number.startAnimation(animation);

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
							dishes_subtract.setVisibility(View.GONE);
							dishes_number.setVisibility(View.GONE);
						}
					});
					dishes_subtract.startAnimation(animation);
				}
				dishes_number.setText(temp - 1 + "");
				count.set(index, temp - 1);
				TestBaseAdapter.list.get(index).setCount(count.get(index));
			}
		});

	}

}
