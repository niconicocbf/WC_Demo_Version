package com.waitur.app.customer;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.waitur.app.customer.scan.MipcaActivityCapture;

public class MainTabActivity extends TabActivity {

	public static final String TAB_HOME = "TabHome";
	public static final String TAB_MSG = "TabMSG";
	public static final String TAB_MORE = "TabMORE";
	public RadioGroup mainbtGroup;
	public static TabHost mth;
	LinearLayout layout1;
	LinearLayout layout2;
	LinearLayout layout3;
	private final static int SCANNIN_GREQUEST_CODE = 1;
	static TextView radio_button0, radio_button1, radio_button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_tab);
		layout1 = (LinearLayout) findViewById(R.id.radio_button_bg1);
		layout2 = (LinearLayout) findViewById(R.id.radio_button_bg2);
		layout3 = (LinearLayout) findViewById(R.id.radio_button_bg3);
		radio_button0 = (TextView) findViewById(R.id.radio_button0);
		radio_button1 = (TextView) findViewById(R.id.radio_button1);
		radio_button2 = (TextView) findViewById(R.id.radio_button2);

		mth = getTabHost();
		TabSpec ts1 = mth.newTabSpec(TAB_HOME).setIndicator(TAB_HOME);
		ts1.setContent(new Intent(MainTabActivity.this, MianMenuActivity.class));
		mth.addTab(ts1);

		TabSpec ts2 = mth.newTabSpec(TAB_MSG).setIndicator(TAB_MSG);
		ts2.setContent(new Intent(MainTabActivity.this, MyProfileActivity.class));
		mth.addTab(ts2);

		TabSpec ts3 = mth.newTabSpec(TAB_MORE).setIndicator(TAB_MORE);
		ts3.setContent(new Intent(MainTabActivity.this, MianMenuActivity.class));
		mth.addTab(ts3);
		layout1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mth.setCurrentTabByTag(TAB_HOME);
				clearAllTab();
				radio_button0
						.setBackgroundResource(R.drawable.home_icon_selected);
			}
		});
		layout2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainTabActivity.this,
						MipcaActivityCapture.class);
				// startActivity(intent);
				startActivityForResult(intent, SCANNIN_GREQUEST_CODE);

				clearAllTab();
				radio_button1
						.setBackgroundResource(R.drawable.scan_icon_selected);
			}
		});
		layout3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mth.setCurrentTabByTag(TAB_MORE);
				Intent intent = new Intent();
				intent.setClass(MainTabActivity.this, MainMaketActivity.class);
				startActivity(intent);
				clearAllTab();
				radio_button2
						.setBackgroundResource(R.drawable.orders_icon_selected);
			}
		});

	}

	public static void clearAllTab() {
		radio_button0.setBackgroundResource(R.drawable.home_icon);
		radio_button1.setBackgroundResource(R.drawable.scan_icon);
		radio_button2.setBackgroundResource(R.drawable.orders_icon);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SCANNIN_GREQUEST_CODE:
			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				// 显示扫描到的内容
				String code = bundle.getString("result");
				Intent intent = new Intent(this, MainMaketActivity.class);
				startActivity(intent);
			}
			break;
		}
	}

}
