package com.waitur.app.customer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MyAccountActivity extends Activity {

	EditText my_account_edit0, my_account_edit1, my_account_edit2,
			my_account_edit3;
	LinearLayout my_account_delete0, my_account_delete1, my_account_delete2,
			my_account_delete3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_my_account);
		my_account_edit0 = (EditText) findViewById(R.id.my_account_edit0);
		my_account_edit1 = (EditText) findViewById(R.id.my_account_edit1);
		my_account_edit2 = (EditText) findViewById(R.id.my_account_edit2);
		my_account_edit3 = (EditText) findViewById(R.id.my_account_edit3);
		my_account_delete0 = (LinearLayout) findViewById(R.id.my_account_delete0);
		my_account_delete1 = (LinearLayout) findViewById(R.id.my_account_delete1);
		my_account_delete2 = (LinearLayout) findViewById(R.id.my_account_delete2);
		my_account_delete3 = (LinearLayout) findViewById(R.id.my_account_delete3);

		my_account_edit0.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					my_account_delete0.setVisibility(View.VISIBLE);
				} else {
					my_account_delete0.setVisibility(View.GONE);
				}

			}
		});
		my_account_delete0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				my_account_edit0.setText("");
			}
		});
		my_account_edit1.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					my_account_delete1.setVisibility(View.VISIBLE);
				} else {
					my_account_delete1.setVisibility(View.GONE);
				}

			}
		});
		my_account_delete1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				my_account_edit1.setText("");
			}
		});
		my_account_edit2.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					my_account_delete2.setVisibility(View.VISIBLE);
				} else {
					my_account_delete2.setVisibility(View.GONE);
				}
			}
		});
		my_account_delete2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				my_account_edit2.setText("");
			}
		});
		my_account_edit3.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					my_account_delete3.setVisibility(View.VISIBLE);
				} else {
					my_account_delete3.setVisibility(View.GONE);
				}

			}
		});
		my_account_delete3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				my_account_edit3.setText("");
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
}
