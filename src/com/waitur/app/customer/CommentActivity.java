package com.waitur.app.customer;

import com.waitur.app.customer.adapter.CommentAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class CommentActivity extends Activity {
	ListView listView;
	CommentAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_comment);
		listView = (ListView) findViewById(R.id.maket_info_listview);
		adapter = new CommentAdapter(this);
		listView.setAdapter(adapter);
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

}
