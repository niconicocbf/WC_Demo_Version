package com.waitur.app.customer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView.OnHeaderClickListener;
import com.waitur.app.customer.adapter.ExpandableListAdapter;
import com.waitur.app.customer.adapter.MaketTitleListViewAdapter;
import com.waitur.app.customer.adapter.TestBaseAdapter;


public class MaketMainMenuInfoActivity extends Activity implements
		OnScrollListener, AdapterView.OnItemClickListener,
		OnHeaderClickListener {

	private static final String KEY_LIST_POSITION = "KEY_LIST_POSITION";
	private int firstVisible;
	private TestBaseAdapter adapter;
	ExpandableListView expandableListView;
	ExpandableListAdapter expandableListAdapter;
	RelativeLayout sending_order, send_order;
	LinearLayout menu_title, title_list;
	ListView titlelistview;
	boolean flag = true;
	boolean istitleListviewShow = false;
	TextView title_menu_up_down, pay_num, pay_price;
	StickyListHeadersListView stickyList;
	HorizontalScrollView scrollView;
	LinearLayout container;
	boolean isExpandPadShowable = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_menu_info);
		expandableListView = (ExpandableListView) findViewById(R.id.expandble);
		sending_order = (RelativeLayout) findViewById(R.id.sending_order);
		menu_title = (LinearLayout) findViewById(R.id.menu_title);
		expandableListAdapter = new ExpandableListAdapter(this);
		title_list = (LinearLayout) findViewById(R.id.title_list);
		expandableListView.setAdapter(expandableListAdapter);
		title_menu_up_down = (TextView) findViewById(R.id.title_menu_up_down);
		titlelistview = (ListView) findViewById(R.id.title_listview);
		pay_num = (TextView) findViewById(R.id.pay_num);
		pay_price = (TextView) findViewById(R.id.pay_price);
		send_order = (RelativeLayout) findViewById(R.id.send_order);
		expandableListView.setGroupIndicator(null);

		stickyList = (StickyListHeadersListView) findViewById(R.id.maket_main_listview);
		stickyList.setOnScrollListener(this);
		stickyList.setOnItemClickListener(this);
		stickyList.setOnHeaderClickListener(this);
		stickyList.setSelection(10);
		if (savedInstanceState != null) {
			firstVisible = savedInstanceState.getInt(KEY_LIST_POSITION);
		}
		stickyList.setEmptyView(findViewById(R.id.empty));
		adapter = new TestBaseAdapter(this);
		stickyList.setAdapter(adapter);
		firstVisible = 0;
		stickyList.setSelection(firstVisible);
		stickyList.setDrawingListUnderStickyHeader(true);
		findViewById(R.id.exit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		sending_order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (flag) {
					if (isExpandPadShowable) {
						expandableListView.setVisibility(View.VISIBLE);
						expandableListAdapter.updateData();
						Animation animation = new AlphaAnimation(0.0f, 1.0f);
						animation.setDuration(500);
						animation = new TranslateAnimation(
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 0.0f,
								Animation.RELATIVE_TO_SELF, 1.0f,
								Animation.RELATIVE_TO_SELF, 0.0f);
						animation.setDuration(500);
						expandableListView.startAnimation(animation);

						findViewById(R.id.blackgroud).setVisibility(
								View.VISIBLE);
						findViewById(R.id.maket_menu_up_down)
								.setBackgroundResource(
										R.drawable.maket_menu_down);
					} else {
						return;
					}
				} else {
					Animation animation = new AlphaAnimation(0.0f, 1.0f);
					animation.setDuration(500);
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 1.0f);
					animation.setDuration(500);
					expandableListView.startAnimation(animation);
					animation.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {
						}

						@Override
						public void onAnimationRepeat(Animation animation) {
						}

						@Override
						public void onAnimationEnd(Animation animation) {
							expandableListView.setVisibility(View.GONE);
							adapter.notifyDataSetChanged();
							findViewById(R.id.blackgroud).setVisibility(
									View.GONE);
							findViewById(R.id.maket_menu_up_down)
									.setBackgroundResource(
											R.drawable.maket_menu_up);
						}
					});
				}
				flag = !flag;
			}
		});
		send_order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MaketMainMenuInfoActivity.this,
						CartConnfirmationActivity.class);
				startActivity(intent);
			}
		});
		menu_title.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				istitleListviewShow = !istitleListviewShow;
				if (istitleListviewShow) {
					title_list.setVisibility(View.VISIBLE);
					title_menu_up_down
							.setBackgroundResource(R.drawable.title_menu_up);

					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, -1.0f,
							Animation.RELATIVE_TO_SELF, 0.0f);
					animation.setDuration(250);
					titlelistview.startAnimation(animation);

				} else {
					Animation animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, -1.0f);
					animation.setDuration(250);
					titlelistview.startAnimation(animation);
					animation.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {

						}

						@Override
						public void onAnimationRepeat(Animation animation) {

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							title_list.setVisibility(View.GONE);
							title_menu_up_down
									.setBackgroundResource(R.drawable.title_menu_down);

						}
					});

				}

			}
		});
		findViewById(R.id.blackgroud).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sending_order.performClick();
			}
		});
		titlelistview.setAdapter(new MaketTitleListViewAdapter(this));
		title_list.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				menu_title.performClick();
			}
		});
		scrollView = (HorizontalScrollView) findViewById(R.id.maket_info_scrollView);
		container = (LinearLayout) findViewById(R.id.container);
		container.removeAllViews();
		LayoutInflater mLi = LayoutInflater.from(this);
		for (int i = 0; i < adapter.getSection().size(); i++) {
			View view1 = mLi.inflate(R.layout.viewpager_dishes_type, null);
			if (i == 0) {
				view1.findViewById(R.id.pager_item).setVisibility(View.VISIBLE);
				((TextView) view1.findViewById(R.id.type_content))
						.setTextColor(this.getResources().getColor(
								R.color.title));
			}
			((TextView) view1.findViewById(R.id.type_content)).setText(adapter
					.getSection().get(i));
			final int index = i;
			view1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					changeChildView(v);
					stickyList.setSelection(adapter
							.getPositionForSection(index));
				}
			});
			container.addView(view1, i);
		}

	}

	@Override
	protected void onResume() {
		super.onResume();
		adapter.notifyDataSetChanged();
		adapter.setPay(false);
	}

	public void setPay_num(String pay_num, String pay_price,
			boolean isNeedAnimation) {
		if (isNeedAnimation) {

			Animation animation = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, 0.0f,
					Animation.RELATIVE_TO_SELF, -0.6f);
			animation.setDuration(80);
			animation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {

				}

				@Override
				public void onAnimationRepeat(Animation animation) {

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					Animation animation1 = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, -0.6f,
							Animation.RELATIVE_TO_SELF, 0.5f);
					animation1.setDuration(100);
					MaketMainMenuInfoActivity.this.pay_num
							.startAnimation(animation1);
					animation1.setAnimationListener(new AnimationListener() {

						@Override
						public void onAnimationStart(Animation animation) {

						}

						@Override
						public void onAnimationRepeat(Animation animation) {

						}

						@Override
						public void onAnimationEnd(Animation animation) {
							Animation animation1 = new TranslateAnimation(
									Animation.RELATIVE_TO_SELF, 0.0f,
									Animation.RELATIVE_TO_SELF, 0.0f,
									Animation.RELATIVE_TO_SELF, 0.5f,
									Animation.RELATIVE_TO_SELF, 0.0f);
							animation1.setDuration(20);
							MaketMainMenuInfoActivity.this.pay_num
									.startAnimation(animation1);
						}
					});

				}
			});
			this.pay_num.startAnimation(animation);
		}
		this.pay_num.setText(pay_num);
		if (pay_num.equals("0")) {
			isExpandPadShowable = false;
		} else {
			isExpandPadShowable = true;
		}
		this.pay_price.setText("$" + pay_price + ".00");
	}

	private void changeChildView(View view) {
		for (int i = 0; i < container.getChildCount(); i++) {
			View view1 = container.getChildAt(i);
			view1.findViewById(R.id.pager_item).setVisibility(View.GONE);
			((TextView) view1.findViewById(R.id.type_content))
					.setTextColor(this.getResources().getColor(
							R.color.textcolor1));
		}
		view.findViewById(R.id.pager_item).setVisibility(View.VISIBLE);
		((TextView) view.findViewById(R.id.type_content)).setTextColor(this
				.getResources().getColor(R.color.title));

	}

	private void changeChildViewbyPosition(int position) {
		for (int i = 0; i < container.getChildCount(); i++) {
			View view1 = container.getChildAt(i);
			view1.findViewById(R.id.pager_item).setVisibility(View.GONE);
			((TextView) view1.findViewById(R.id.type_content))
					.setTextColor(this.getResources().getColor(
							R.color.textcolor1));
		}
		View view = container.getChildAt(position);
		view.findViewById(R.id.pager_item).setVisibility(View.VISIBLE);
		((TextView) view.findViewById(R.id.type_content)).setTextColor(this
				.getResources().getColor(R.color.title));
		if (position == 0) {
			scrollView.scrollTo(0, 0);
		}
		if (position == 4) {
			scrollView.scrollTo(view.getWidth(), 0);
		}

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_LIST_POSITION, firstVisible);
	}

	@Override
	public void onHeaderClick(StickyListHeadersListView arg0, View arg1,
			int arg2, long arg3, boolean arg4) {

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// Log.d("wangyong", "stickyList.getFirstVisiblePosition()" +
		// stickyList.getFirstVisiblePosition()+"scrollState"+scrollState);

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		if (firstVisible != firstVisibleItem) {
			changeChildViewbyPosition((adapter
					.getSectionForPosition(firstVisibleItem / 2)));
		}
		this.firstVisible = firstVisibleItem;

	}

	public void setExpandbleListExpand() {
		for (int i = 0; i < expandableListAdapter.getGroupCount(); i++) {
			expandableListView.expandGroup(i);
		}

	}

}
