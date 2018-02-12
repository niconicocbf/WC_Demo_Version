package com.waitur.app.customer.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.waitur.app.customer.CommentActivity;
import com.waitur.app.customer.MainMaketActivity;
import com.waitur.app.customer.MaketMapActivity;
import com.waitur.app.customer.R;
import com.waitur.app.customer.RewardActivity;

public class MaketInfoMainListViewAdapter extends BaseAdapter {
	Context context;

	// Gallery gallery;
	// MaketInfoGalleryAdpter adpter;
	int type;

	public MaketInfoMainListViewAdapter(Context context) {
		this.context = context;
		type = 3;
	}

	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position == 0) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.activity_maket_info, null);
			LinearLayout layout = (LinearLayout) convertView
					.findViewById(R.id.maket_dishes_img);
			View view = LayoutInflater.from(context).inflate(
					R.layout.gallery_image, null);
			Bitmap bmp = BitmapFactory.decodeResource(context.getResources(),
					R.drawable.pic03);
			((ImageView) view.findViewById(R.id.img))
					.setImageBitmap(toRoundCorner(bmp, 20));
			layout.addView(view);
			convertView.findViewById(R.id.maket_map).setOnClickListener(
					new OnClickListener() {

						@Override
						public void onClick(View v) {
							Intent intent = new Intent(context,
									MaketMapActivity.class);
							context.startActivity(intent);
						}
					});

			LinearLayout maket_point = (LinearLayout) convertView
					.findViewById(R.id.maket_point);
			maket_point.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// ((MainMaketActivity) context).showPointPad(true);
					Intent intent = new Intent(context, RewardActivity.class);
					context.startActivity(intent);
				}
			});
			convertView.findViewById(R.id.point_time).setOnClickListener(
					new OnClickListener() {

						@Override
						public void onClick(View v) {
							((MainMaketActivity) context).showPointPad(true);
						}
					});
			convertView.findViewById(R.id.comment).setOnClickListener(
					new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent intent = new Intent(context,
									RewardActivity.class);
							context.startActivity(intent);
						}
					});
			final TextView dot01, dot02, dot03, dot04, dot05;
			final TextView trangle01, trangle02, trangle03, trangle04, trangle05, an, an1;
			dot01 = (TextView) convertView.findViewById(R.id.dot01);
			dot02 = (TextView) convertView.findViewById(R.id.dot02);
			dot03 = (TextView) convertView.findViewById(R.id.dot03);
			dot04 = (TextView) convertView.findViewById(R.id.dot04);
			dot05 = (TextView) convertView.findViewById(R.id.dot05);
			trangle01 = (TextView) convertView.findViewById(R.id.trangle01);
			trangle02 = (TextView) convertView.findViewById(R.id.trangle02);
			trangle03 = (TextView) convertView.findViewById(R.id.trangle03);
			trangle04 = (TextView) convertView.findViewById(R.id.trangle04);
			trangle05 = (TextView) convertView.findViewById(R.id.trangle05);
			an = (TextView) convertView.findViewById(R.id.animotion);
			an1 = (TextView) convertView.findViewById(R.id.animotion1);
			dot01.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					trangle01.setVisibility(View.VISIBLE);
					trangle02.setVisibility(View.GONE);
					trangle03.setVisibility(View.GONE);
					trangle04.setVisibility(View.GONE);
					trangle05.setVisibility(View.GONE);
					if (type == 1) {
						return;
					}
					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 2.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(500);
					an.startAnimation(animation);

					Animation animation1 = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, -2.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation1.setDuration(500);
					animation1.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationRepeat(Animation animation) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							an1.setVisibility(View.GONE);
						}
					});
					an1.startAnimation(animation1);
					type = 1;
				}
			});
			dot02.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					trangle01.setVisibility(View.GONE);
					trangle02.setVisibility(View.VISIBLE);
					trangle03.setVisibility(View.GONE);
					trangle04.setVisibility(View.GONE);
					trangle05.setVisibility(View.GONE);
					if (type > 2) {
						Animation animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						an.startAnimation(animation);

						Animation animation1 = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, -2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation1.setDuration(500);
						animation1
								.setAnimationListener(new AnimationListener() {

									@Override
									public void onAnimationStart(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											Animation animation) {
										an1.setVisibility(View.GONE);
									}
								});
						an1.startAnimation(animation1);
					} else {
						Animation animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, -2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						an.startAnimation(animation);

						Animation animation1 = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation1.setDuration(500);
						animation1
								.setAnimationListener(new AnimationListener() {

									@Override
									public void onAnimationStart(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											Animation animation) {
										an1.setVisibility(View.GONE);
									}
								});
						an1.startAnimation(animation1);
					}
					type = 2;
				}
			});
			dot03.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					trangle01.setVisibility(View.GONE);
					trangle02.setVisibility(View.GONE);
					trangle03.setVisibility(View.VISIBLE);
					trangle04.setVisibility(View.GONE);
					trangle05.setVisibility(View.GONE);
					if (type > 3) {
						Animation animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						an.startAnimation(animation);

						Animation animation1 = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, -2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation1.setDuration(500);
						animation1
								.setAnimationListener(new AnimationListener() {

									@Override
									public void onAnimationStart(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											Animation animation) {
										an1.setVisibility(View.GONE);
									}
								});
						an1.startAnimation(animation1);
					} else {
						Animation animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, -2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						an.startAnimation(animation);

						Animation animation1 = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation1.setDuration(500);
						animation1
								.setAnimationListener(new AnimationListener() {

									@Override
									public void onAnimationStart(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											Animation animation) {
										an1.setVisibility(View.GONE);
									}
								});
						an1.startAnimation(animation1);
					}
					type = 3;
				}
			});
			dot04.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					trangle01.setVisibility(View.GONE);
					trangle02.setVisibility(View.GONE);
					trangle03.setVisibility(View.GONE);
					trangle04.setVisibility(View.VISIBLE);
					trangle05.setVisibility(View.GONE);
					if (type > 4) {
						Animation animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						an.startAnimation(animation);

						Animation animation1 = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, -2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation1.setDuration(500);
						animation1
								.setAnimationListener(new AnimationListener() {

									@Override
									public void onAnimationStart(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											Animation animation) {
										an1.setVisibility(View.GONE);
									}
								});
						an1.startAnimation(animation1);
					} else {
						Animation animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, -2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						an.startAnimation(animation);

						Animation animation1 = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation1.setDuration(500);
						animation1
								.setAnimationListener(new AnimationListener() {

									@Override
									public void onAnimationStart(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											Animation animation) {
										an1.setVisibility(View.GONE);
									}
								});
						an1.startAnimation(animation1);
					}
					type = 4;
				}
			});
			dot05.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					trangle01.setVisibility(View.GONE);
					trangle02.setVisibility(View.GONE);
					trangle03.setVisibility(View.GONE);
					trangle04.setVisibility(View.GONE);
					trangle05.setVisibility(View.VISIBLE);
					if (type == 5) {
						return;
					} else {
						Animation animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, -2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						an.startAnimation(animation);

						Animation animation1 = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 2.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation1.setDuration(500);
						animation1
								.setAnimationListener(new AnimationListener() {

									@Override
									public void onAnimationStart(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											Animation animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											Animation animation) {
										an1.setVisibility(View.GONE);
									}
								});
						an1.startAnimation(animation1);
					}
					type = 5;
				}
			});

			return convertView;
		} else if (position == 5) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_main_maket_footer, null);
			convertView.findViewById(R.id.comment).setOnClickListener(
					new OnClickListener() {

						@Override
						public void onClick(View v) {
							Intent intent = new Intent(context,
									CommentActivity.class);
							context.startActivity(intent);
						}
					});

			return convertView;
		} else {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_main_maket_info_item, null);
			if (position == 1) {
				convertView.findViewById(R.id.space).setVisibility(View.GONE);
			}
			return convertView;
		}

	}

	// Éú³ÉÔ²½ÇÍ¼Æ¬

	public static Bitmap toRoundCorner(Bitmap bitmap, int pixels) {

		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = pixels;
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;

	}

}
