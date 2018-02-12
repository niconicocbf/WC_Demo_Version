package com.waitur.app.customer;

import android.app.Activity;
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

import com.baidu.location.LocationClient;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapView;
import com.waitur.app.customer.adapter.MapListViewAdapter;
import com.waitur.app.customer.adapter.MapTitleListviewAdapter;

public class MaketMapActivity extends Activity {
	BMapManager mBMapMan = null;
	MapView mMapView = null;
	public LocationClient mLocationClient = null;
	TextView textView, title_bg, textview3, exit;
	ListView listView, title_listview;
	boolean mapOrList = true;
	MapListViewAdapter adapter;
	RelativeLayout closest;
	LinearLayout space;
	boolean isSpaceShow = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mLocationClient = new LocationClient(getApplicationContext()); // 声明LocationClient类s
		mBMapMan = new BMapManager(getApplication());
		mBMapMan.init("Yb6kiGGEQbgRb2U2mM6Yntma", null);
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
		// WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		setContentView(R.layout.activity_maket_map);
		listView = (ListView) findViewById(R.id.map_listview);
		mMapView = (MapView) findViewById(R.id.bmapsView);
		textView = (TextView) findViewById(R.id.maket_map_menu);
		title_bg = (TextView) findViewById(R.id.title_bg);
		textview3 = (TextView) findViewById(R.id.textview3);
		exit = (TextView) findViewById(R.id.exit);
		space = (LinearLayout) findViewById(R.id.space);
		title_listview = (ListView) findViewById(R.id.title_listview);

		closest = (RelativeLayout) findViewById(R.id.closest);
		// 交通图
		mMapView.setTraffic(true);
		adapter = new MapListViewAdapter(this);
		listView.setAdapter(adapter);
		// 卫星图
		// mMapView.setSatellite(true);

		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mapOrList) {
					textView.setBackgroundResource(R.drawable.maket_map);
					listView.setVisibility(View.VISIBLE);
					mMapView.setVisibility(View.GONE);

				} else {
					textView.setBackgroundResource(R.drawable.maket_map_menu);
					mMapView.setVisibility(View.VISIBLE);
					listView.setVisibility(View.GONE);
				}
				mapOrList = !mapOrList;
			}
		});
		if (getIntent().getBooleanExtra("type", false)) {
			textView.performClick();
		}
		// Bitmap bmp = BitmapFactory.decodeResource(this.getResources(),
		// R.drawable.pic01);
		// blur(bmp, title_bg, 10);
		closest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				isSpaceShow = !isSpaceShow;
				if (isSpaceShow) {
					space.setVisibility(View.VISIBLE);
					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, -1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					title_listview.startAnimation(animation);
				} else {
					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, -1.0f);
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
		exit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		final MapTitleListviewAdapter listviewAdapter = new MapTitleListviewAdapter(
				this);
		title_listview.setAdapter(listviewAdapter);
		title_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				view.findViewById(R.id.isclicked).setBackgroundResource(
						R.drawable.side_item_sel);
				((TextView) view.findViewById(R.id.distence))
						.setTextColor(MaketMapActivity.this.getResources()
								.getColor(R.color.title));
				for (int i = 0; i < listviewAdapter.getisclicked().size(); i++) {
					listviewAdapter.getisclicked().set(i, false);
				}
				listviewAdapter.getisclicked().set(position, true);
				listviewAdapter.notifyDataSetChanged();
				textview3.setText("500m");
				if (position == 0) {
					textview3.setText("closest");
				}
				closest.performClick();
			}
		});

		space.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				closest.performClick();
			}
		});

	}

	// @SuppressLint("NewApi")
	// private void blur(Bitmap bkg, View view, float radius) {
	// Bitmap overlay = Bitmap.createBitmap(view.getMeasuredWidth(),
	// view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
	// Canvas canvas = new Canvas(overlay);
	// canvas.drawBitmap(bkg, -view.getLeft(), -view.getTop(), null);
	// RenderScript rs = RenderScript.create(this);
	// Allocation overlayAlloc = Allocation.createFromBitmap(rs, overlay);
	// ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs,
	// overlayAlloc.getElement());
	// blur.setInput(overlayAlloc);
	// blur.setRadius(radius);
	// blur.forEach(overlayAlloc);
	// overlayAlloc.copyTo(overlay);
	// view.setBackground(new BitmapDrawable(getResources(), overlay));
	// rs.destroy();
	// }

	@Override
	protected void onDestroy() {
		mMapView.destroy();
		if (mBMapMan != null) {
			mBMapMan.destroy();
			mBMapMan = null;
		}
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		if (mBMapMan != null) {
			mBMapMan.stop();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		if (mBMapMan != null && !mapOrList) {
			mBMapMan.start();
		}
		super.onResume();
	}

}
