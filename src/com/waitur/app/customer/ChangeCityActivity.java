package com.waitur.app.customer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.waitur.app.customer.adapter.SelectCityAdapter;
import com.waitur.app.customer.view.SideBar;
import com.waitur.app.customer.view.SideBar.OnTouchingLetterChangedListener;

public class ChangeCityActivity extends Activity {
	ListView select_city_listview;
	private SideBar sideBar;
	SelectCityAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_city_change);
		select_city_listview = (ListView) findViewById(R.id.select_city_listview);
		sideBar = (SideBar) findViewById(R.id.sidrbar);
		sideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {
				// 该字母首次出现的位置
				int position = adapter.getPositionForSection(s.charAt(0));
				if (position != -1) {
					select_city_listview.setSelection(position);
				}

			}
		});
		adapter = new SelectCityAdapter(this);
		select_city_listview.setAdapter(adapter);
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);
			}
		});
	}
}
