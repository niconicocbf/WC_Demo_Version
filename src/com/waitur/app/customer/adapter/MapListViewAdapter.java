package com.waitur.app.customer.adapter;

import android.content.Context;
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
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.waitur.app.customer.R;

public class MapListViewAdapter extends BaseAdapter {
	Context context;

	public MapListViewAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 25;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	class HomeViewHolder {
		private ImageView home_headicon;
//		private View pad;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HomeViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_map_item, null);
			viewHolder = new HomeViewHolder();
			viewHolder.home_headicon = (ImageView) convertView
					.findViewById(R.id.item_image_context);
//			viewHolder.pad = convertView.findViewById(R.id.space);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (HomeViewHolder) convertView.getTag();
		}
//		if (position != 0) {
//			viewHolder.pad.setVisibility(View.GONE);
//		}
		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.pic03);
		viewHolder.home_headicon.setImageBitmap(toRoundCorner(bmp, 20));

		return convertView;
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
