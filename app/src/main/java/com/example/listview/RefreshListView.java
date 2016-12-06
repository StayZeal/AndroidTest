package com.example.listview;

import com.example.androidtest.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;

public class RefreshListView extends ListView implements OnScrollListener {

	private static final String TAG = RefreshListView.class.getSimpleName();
	private Context context;
	private View headView;
	private ImageView headAdImage;
	private TextView headTime;
	private int headerContentHeight;
	private int eventY;
	private int moveY;
	private int firstVisiableItem;
	private DisplayMode currentState = DisplayMode.Pull_To_Refresh;
	private OnRefreshListener mOnRefreshListener;

	public enum DisplayMode {
		Pull_To_Refresh, // 未显示header
		Release_To_Refresh, // 显示header，但是手没有松开屏幕
		Refreshing// 正在刷洗，显示header
	}

	public RefreshListView(Context context) {
		super(context);
		this.context = context;
		init();
	}

	public RefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	private void init() {

		this.setOnScrollListener(this);
		headView = LayoutInflater.from(context).inflate( R.layout.list_header_view, null);
		headAdImage = (ImageView) headView.findViewById(R.id.head_ad_image);
		headTime = (TextView) headView.findViewById(R.id.head_time_text);
		measureView(headTime);
		headerContentHeight = headTime.getMeasuredHeight();
		headView.setPadding(0, -headerContentHeight, 0, 0);//隐藏headerView;

		//headAdImage.setVisibility(View.GONE);
		this.addHeaderView(headView);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {

		this.firstVisiableItem = firstVisibleItem;
//		System.out.println(this.firstVisiableItem);

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {

		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			eventY = (int) ev.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			moveY = (int) ev.getY() - eventY;
			System.out.println(TAG + " movey: " + moveY);
			if (currentState == DisplayMode.Refreshing) {// 如果正在刷新，则头部位置不变
				break;
			}
			int paddingTop = -headerContentHeight + (moveY / 2);

			if (firstVisiableItem == 0 && moveY > 0) {
				/*
				 * if (currentState == DisplayMode.Pull_To_Refresh) {
				 * 
				 * }
				 */

				refreshListByState();
				headView.setPadding(0, paddingTop, 0, 0);
				return true;
			}

			break;
		case MotionEvent.ACTION_UP:
			if (firstVisiableItem == 0 && currentState == DisplayMode.Release_To_Refresh) {
				headView.setPadding(0, 0, 0, 0);
				currentState = DisplayMode.Refreshing;
				refreshListByState();
			}
			if (firstVisiableItem == 0 && currentState == DisplayMode.Pull_To_Refresh) {
				headView.setPadding(0, -headerContentHeight, 0, 0);
			}
			if(firstVisiableItem ==0 && currentState == DisplayMode.Refreshing){
				if(mOnRefreshListener!=null){
					mOnRefreshListener.onRefresh();
				}
			}
			refreshListByState();

			break;

		default:
			break;
		}
		return super.onTouchEvent(ev);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
	}

	private void measureView(View child) {
		ViewGroup.LayoutParams params = child.getLayoutParams();
		if (params == null) {
			params = new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 ,
				params.width);
		int lpHeight = params.height;
		int childHeightSpec;
		if (lpHeight > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}
		child.measure(childWidthSpec, childHeightSpec);
	}

	private void refreshListByState() {
		if (currentState == DisplayMode.Pull_To_Refresh) {
			currentState = DisplayMode.Release_To_Refresh;
		}
		if (currentState == DisplayMode.Release_To_Refresh) {

			headTime.setText("释放刷新");
			// currentState = DisplayMode.Refreshing;
		}
		if (currentState == DisplayMode.Refreshing) {
			headTime.setText("正在刷新");
			// currentState = DisplayMode.Pull_To_Refresh;
		}
	}

	public void onRefreshFinish() {
		Log.i(TAG, "onRefreshFinish-->执行");
		currentState = DisplayMode.Pull_To_Refresh;
		headView.setPadding(0, -headerContentHeight, 0, 0);
	}

	public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
		this.mOnRefreshListener = onRefreshListener;
	}

	interface OnRefreshListener {
		/**
		 * 在刷新数据完成时调用，需手动调用用{@link #onRefresh()}方法.
		 */
		void onRefresh();
	}
}
