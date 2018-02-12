package com.waitur.app.customer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MianMenuActivity extends Activity {
	private ViewPager mViewPager;
	private ImageView mPage0;
	private ImageView mPage1;
	private ImageView mPage2;
	private ImageView mPage3;
	private ImageView mPage4;
	private ImageView mPage5;
	private ImageView maket_map;
	// private int currIndex = 0;
	LinearLayout layout;
	TextView textView, my_info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_home);
		mViewPager = (ViewPager) findViewById(R.id.whatsnew_viewpager);
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
		layout = (LinearLayout) findViewById(R.id.dot);
		my_info = (TextView) findViewById(R.id.my_info);
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
//		int frameHeith = display.getHeight();
		int frameWith = display.getWidth();
		mViewPager.setLayoutParams(new FrameLayout.LayoutParams(frameWith,
				frameWith));
		mPage0 = (ImageView) findViewById(R.id.page0);
		mPage1 = (ImageView) findViewById(R.id.page1);
		mPage2 = (ImageView) findViewById(R.id.page2);
		mPage3 = (ImageView) findViewById(R.id.page3);
		mPage4 = (ImageView) findViewById(R.id.page4);
		mPage5 = (ImageView) findViewById(R.id.page5);
		maket_map = (ImageView) findViewById(R.id.maket_map);
		// ImageView imageView = (ImageView) findViewById(R.id.title_bg);
		// Bitmap image = ((BitmapDrawable)
		// imageView.getDrawable()).getBitmap();
		// StackBlurUtil blurUtil = new StackBlurUtil(image);
		// imageView.setImageBitmap(image);
		LayoutInflater mLi = LayoutInflater.from(this);
		View view1 = mLi.inflate(R.layout.whats1, null);
		View view2 = mLi.inflate(R.layout.whats1, null);
		View view3 = mLi.inflate(R.layout.whats1, null);
		View view4 = mLi.inflate(R.layout.whats1, null);
		View view5 = mLi.inflate(R.layout.whats1, null);
		View view6 = mLi.inflate(R.layout.whats1, null);
		// 每个页面的view数据
		final ArrayList<View> views = new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		views.add(view5);
		views.add(view6);
		// ImageView imageView=new ImageView(this);

		// 填充ViewPager的数据适配器
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

		mViewPager.setAdapter(mPagerAdapter);
		handler.obtainMessage();
		Message message = new Message();
		message.what = 1;
		handler.sendMessageDelayed(message, 5000);

		my_info.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Intent intent = new Intent(MianMenuActivity.this,
				// MyProfileActivity.class);
				// startActivity(intent);
				MainTabActivity.mth.setCurrentTabByTag(MainTabActivity.TAB_MSG);
				MainTabActivity.clearAllTab();
			}
		});
		maket_map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MianMenuActivity.this,
						MaketMapActivity.class);
				intent.putExtra("type", true);
				startActivity(intent);
			}
		});
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
			case 0:
				mPage5.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 1:
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 2:
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 3:
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 4:
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage5.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 5:
				mPage5.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			}
			// currIndex = arg0;
			// animation.setFillAfter(true);// True:图片停在动画结束位置
			// animation.setDuration(300);
			// mPageImg.startAnimation(animation);
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}
	}

	Handler handler = new Handler(new Callback() {

		@Override
		public boolean handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				int Current = mViewPager.getCurrentItem();
				if (Current == 5) {
					// mViewPager.setCurrentItem(0);
					mViewPager.setCurrentItem(0, true);
				} else {
					// mViewPager.setCurrentItem(Current + 1);
					mViewPager.setCurrentItem(Current + 1, true);
				}
				handler.obtainMessage();
				Message message = new Message();
				message.what = 1;
				handler.sendMessageDelayed(message, 5000);
				break;
			}
			return false;
		}
	});
}
