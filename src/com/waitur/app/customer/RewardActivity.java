package com.waitur.app.customer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.waitur.app.customer.adapter.RewardtAdapter;

public class RewardActivity extends Activity {
	ListView listView;
	RewardtAdapter adapter;
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_reward);
		listView = (ListView) findViewById(R.id.listview);
		adapter = new RewardtAdapter(this);
		listView.setAdapter(adapter);
		textView = (TextView) findViewById(R.id.text);
		// listView = (ListView) findViewById(R.id.maket_info_listview);
		// adapter = new CommentAdapter(this);
		// listView.setAdapter(adapter);
		// findViewById(R.id.exit).setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// finish();
		// }
		// });
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});
		handler.sendEmptyMessage(1);
	}

	int progress = 10;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int what = msg.what;
			switch (what) {
			case 1:
				if (progress < 150) {
					progress = progress + 2;
					textView.setText("" + progress);
					handler.sendEmptyMessageDelayed(1, 1);
				}
				break;
			}
		};
	};
}
