package com.waitur.app.customer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

public class AddCardActivity extends Activity {

	LinearLayout city;
	EditText card_id, card_data, card_name;

	@SuppressLint("ResourceAsColor")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.actvitity_add_card);
		city = (LinearLayout) findViewById(R.id.city);
		card_id = (EditText) findViewById(R.id.card_id);
		card_data = (EditText) findViewById(R.id.card_data);
		card_name = (EditText) findViewById(R.id.card_name);
		city.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AddCardActivity.this,
						ChangeCityActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
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

		card_id.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					card_id.setText("");
				}
			}
		});

		card_id.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String text = s.toString();
				if (start == 3 || start == 8 || start == 13) {
					if (text.length() == 4 || text.length() == 9
							|| text.length() == 14) {
						card_id.setText(text + " ");
						card_id.setSelection(card_id.getText().length());
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		card_data.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// card_data.setText("");
				if (hasFocus) {
					card_data.setText("");
					// card_data.setTextColor(Color.BLACK);
					InputMethodManager inputManager =

					(InputMethodManager) card_data.getContext()
							.getSystemService(Context.INPUT_METHOD_SERVICE);

					inputManager.showSoftInput(card_data, 0);
				}

			}
		});
		card_data.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				String text = s.toString();
				if (start == 1) {
					if (text.length() == 2) {
						card_data.setText(text + "/");
						card_data.setSelection(card_data.getText().length());
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			boolean error = true;

			@Override
			public void afterTextChanged(Editable s) {
				String text = s.toString();

				int num;
				if (text.length() >= 2) {
					num = Integer.parseInt(text.substring(0, 2));
					if (num > 12 || num < 0) {
						error = false;
					} else {
						error = true;
					}
				}
				if (text.length() == 5) {
					String text2 = text.substring(3, 5);
					if (text2.length() == 2) {
						num = Integer.parseInt(text2);
						if (num > 31 || num < 0) {
							error = false;
						} else {
							if (error) {
								error = true;
							}
						}
					}
				}
				if (error) {
					card_data.setTextColor(R.color.textcolor);
					findViewById(R.id.error).setVisibility(View.GONE);
				} else {
					card_data.setTextColor(Color.RED);
					findViewById(R.id.error).setVisibility(View.VISIBLE);
				}

			}
		});
	}
}
