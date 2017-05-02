package com.example.wuzp.umengdemo.view.base;

import android.support.v4.app.Fragment;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by wuzp on 2017/5/2.
 */

public class BaseFragment extends Fragment {
   private static final String TAG = BaseFragment.class.getSimpleName();

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(TAG);
        //MobclickAgent.onResume(getContext()); //这个处理应该放置在承载碎片的activity中
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(TAG);
        //MobclickAgent.onPause(getContext());//这个处理应该放置在承载碎片的activity中
    }
}
