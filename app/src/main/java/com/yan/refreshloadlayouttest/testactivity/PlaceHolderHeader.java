package com.yan.refreshloadlayouttest.testactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.wang.avi.AVLoadingIndicatorView;
import com.yan.pullrefreshlayout.PullRefreshLayout;
import com.yan.refreshloadlayouttest.R;

/**
 * Created by Administrator on 2017/7/16 0016.
 */

public class PlaceHolderHeader extends FrameLayout implements PullRefreshLayout.OnPullListener {
    public PlaceHolderHeader(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.refresh_view_big, this, true);
    }

    @Override
    public void onPullChange(float percent) {
        if (percent > 1.2) {
            findViewById(R.id.iv_bg).setScaleY(1 + (percent - 1.2f) * 0.2f);
        } else {
            findViewById(R.id.iv_bg).setScaleY(1f);
        }
    }

    @Override
    public void onPullHoldTrigger() {

    }

    @Override
    public void onPullHoldUnTrigger() {

    }

    @Override
    public void onPullHolding() {
        ((AVLoadingIndicatorView) findViewById(R.id.loading_view)).smoothToShow();
    }

    @Override
    public void onPullFinish() {
        ((AVLoadingIndicatorView) findViewById(R.id.loading_view)).smoothToHide();

    }

    @Override
    public void onPullReset() {
        AVLoadingIndicatorView avLoadingIndicatorView = ((AVLoadingIndicatorView) findViewById(R.id.loading_view));
        if (avLoadingIndicatorView.getVisibility()==VISIBLE){
            avLoadingIndicatorView.smoothToHide();
        }
    }
}
