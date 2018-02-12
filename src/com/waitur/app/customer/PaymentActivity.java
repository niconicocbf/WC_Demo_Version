package com.waitur.app.customer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.waitur.app.customer.adapter.PaymentSelectAdapter;

public class PaymentActivity extends Activity {
	RelativeLayout payment_process, payment_select, change_card;
	TextView payment_text, my_payment, payment_check, title, bottom,
			progress_text;
	ListView payment_listview;
	PaymentSelectAdapter adapter;
	LinearLayout select_pan, payment_type, payment_loading_bg, payment_loading,
			Confirmation, bar;
	RotateAnimation rAnimation;
	TextView star1, star2, star3, star4, star5;
	SeekBar seekBar;
	private float rate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_payment);
		payment_process = (RelativeLayout) findViewById(R.id.payment_process);
		payment_select = (RelativeLayout) findViewById(R.id.payment_select);
		change_card = (RelativeLayout) findViewById(R.id.change_card);
		payment_text = (TextView) findViewById(R.id.payment_text);
		payment_listview = (ListView) findViewById(R.id.payment_listview);
		select_pan = (LinearLayout) findViewById(R.id.select_pan);
		payment_type = (LinearLayout) findViewById(R.id.payment_type);
		payment_loading = (LinearLayout) findViewById(R.id.payment_loading);
		progress_text = (TextView) findViewById(R.id.progress_text);
		my_payment = (TextView) findViewById(R.id.my_payment);
		payment_check = (TextView) findViewById(R.id.payment_check);
		bar = (LinearLayout) findViewById(R.id.bar);
		seekBar = (SeekBar) findViewById(R.id.seekbar);
		star1 = (TextView) findViewById(R.id.star1);
		star2 = (TextView) findViewById(R.id.star2);
		star3 = (TextView) findViewById(R.id.star3);
		star4 = (TextView) findViewById(R.id.star4);
		star5 = (TextView) findViewById(R.id.star5);
		title = (TextView) findViewById(R.id.title);
		bottom = (TextView) findViewById(R.id.bottom);
		payment_loading_bg = (LinearLayout) findViewById(R.id.payment_loading_bg);
		Confirmation = (LinearLayout) findViewById(R.id.Confirmation);
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);
			}
		});
		payment_process.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				payment_text.setText("Processing...");
				handler.sendEmptyMessageDelayed(2, 5000);

				// ������ת����,��һ����������ʼ��ת����(��Ҫ����360),�ڶ�����ת���ٶ�,���������ĸ�Ϊ��������.
				payment_loading.setVisibility(View.VISIBLE);
				rAnimation = new RotateAnimation(0f, 360f,
						Animation.RELATIVE_TO_SELF, 0.5f,
						Animation.RELATIVE_TO_SELF, 0.5f);
				// ����ѭ������
				rAnimation.setRepeatCount(-1);
				// ���ö���ִ�й����õ�ʱ��,��λ����
				rAnimation.setDuration(1000);
				// �������ٶ���Ч��
				LinearInterpolator lin = new LinearInterpolator();
				rAnimation.setInterpolator(lin);
				// imageView��Ҫ��ת�Ŀؼ�������.
				payment_loading.startAnimation(rAnimation);
			}
		});
		adapter = new PaymentSelectAdapter(this);
		payment_listview.setAdapter(adapter);
		change_card.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				select_pan.setVisibility(View.VISIBLE);
				findViewById(R.id.gray_bg).setVisibility(View.VISIBLE);
			}
		});
		payment_select.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				select_pan.setVisibility(View.GONE);
				findViewById(R.id.gray_bg).setVisibility(View.GONE);
			}
		});
		findViewById(R.id.gray_bg).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				select_pan.setVisibility(View.GONE);
				findViewById(R.id.gray_bg).setVisibility(View.GONE);
			}
		});
		payment_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				adapter.setIndex(position);
			}
		});
		star1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				star1.setBackgroundResource(R.drawable.maket_star1);
				star2.setBackgroundResource(R.drawable.maket_star0);
				star3.setBackgroundResource(R.drawable.maket_star0);
				star4.setBackgroundResource(R.drawable.maket_star0);
				star5.setBackgroundResource(R.drawable.maket_star0);
			}
		});
		star2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				star1.setBackgroundResource(R.drawable.maket_star1);
				star2.setBackgroundResource(R.drawable.maket_star1);
				star3.setBackgroundResource(R.drawable.maket_star0);
				star4.setBackgroundResource(R.drawable.maket_star0);
				star5.setBackgroundResource(R.drawable.maket_star0);
			}
		});

		star3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				star1.setBackgroundResource(R.drawable.maket_star1);
				star2.setBackgroundResource(R.drawable.maket_star1);
				star3.setBackgroundResource(R.drawable.maket_star1);
				star4.setBackgroundResource(R.drawable.maket_star0);
				star5.setBackgroundResource(R.drawable.maket_star0);
			}
		});
		star4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				star1.setBackgroundResource(R.drawable.maket_star1);
				star2.setBackgroundResource(R.drawable.maket_star1);
				star3.setBackgroundResource(R.drawable.maket_star1);
				star4.setBackgroundResource(R.drawable.maket_star1);
				star5.setBackgroundResource(R.drawable.maket_star0);
			}
		});
		star5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				star1.setBackgroundResource(R.drawable.maket_star1);
				star2.setBackgroundResource(R.drawable.maket_star1);
				star3.setBackgroundResource(R.drawable.maket_star1);
				star4.setBackgroundResource(R.drawable.maket_star1);
				star5.setBackgroundResource(R.drawable.maket_star1);
			}
		});
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, final int progress,
					boolean fromUser) {
				// ��TextView����Thumb��̬�ƶ�
				rate = (float) progress / seekBar.getMax();
				seekBar.post(new Runnable() {

					@Override
					public void run() {
						progress_text.setText(progress + "");
						bar.setPadding((int) ((bar.getWidth() * rate) - dip2px(PaymentActivity.this, 25)), 0,
								0, 0);
						progress_text.invalidate();
					}
				});
			}
		});

	}
	/**
	* �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊ px(����)
	*/
	public static int dip2px(Context context, float dpValue) {
	  final float scale = context.getResources().getDisplayMetrics().density;
	  return (int) (dpValue * scale + 0.5f);
	}
	@Override
	protected void onResume() {
		super.onResume();
		// my_payment.setVisibility(View.VISIBLE);
		// payment_loading.setVisibility(View.VISIBLE);
	}

	int progress = 10;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			int what = msg.what;
			switch (what) {
			case 1:
				// Intent intent = new Intent(PaymentActivity.this,
				// ConfirmationActivity.class);
				// startActivity(intent);

				break;
			case 1000:
				if (progress < 100) {
					progress = progress + 2;
					seekBar.setProgress(progress);
					handler.sendEmptyMessageDelayed(1000, 1);
				}

				break;
			case 2:
				payment_loading.clearAnimation();
				payment_loading.setVisibility(View.GONE);
				my_payment.setVisibility(View.GONE);
				findViewById(R.id.space).setVisibility(View.GONE);
				payment_loading_bg
						.setBackgroundResource(R.drawable.payment_text_bg3);
				payment_check.setVisibility(View.VISIBLE);
				payment_text.setText("Thank You");
				Animation translateanimation = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 1.0f,
						Animation.RELATIVE_TO_SELF, 0.0f);
				translateanimation.setDuration(500);
				Confirmation.startAnimation(translateanimation);
				Confirmation.setVisibility(View.VISIBLE);
				change_card.setVisibility(View.GONE);
				title.setText("Confirmation");
				bottom.setText("Done");
				handler.sendEmptyMessageDelayed(1000, 500);
				translateanimation
						.setAnimationListener(new AnimationListener() {

							@Override
							public void onAnimationEnd(Animation animation) {

							}

							@Override
							public void onAnimationRepeat(Animation animation) {

							}

							@Override
							public void onAnimationStart(Animation animation) {

							}
						});

				// ͬ������Ч��
				Animation translateanimation1 = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 0.0f,
						Animation.RELATIVE_TO_SELF, 0.3f,
						Animation.RELATIVE_TO_SELF, 0.0f);
				translateanimation1.setDuration(500);
				findViewById(R.id.payment_content).startAnimation(
						translateanimation1);

				break;
			default:
				break;
			}

		}
	};
}
