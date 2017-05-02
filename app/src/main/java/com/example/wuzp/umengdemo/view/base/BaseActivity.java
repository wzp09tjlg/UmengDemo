package com.example.wuzp.umengdemo.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgent.EScenarioType;

/**
 * Created by wuzp on 2017/5/2.
 * Activity 的基类 在基类中可以做友盟的处理
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //以下的开关是打开测试模式的
        MobclickAgent.setDebugMode(false);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.setScenarioType(this, EScenarioType.E_UM_NORMAL);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MobclickAgent.onPageStart(TAG);
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MobclickAgent.onPageEnd(TAG);
        MobclickAgent.onPause(this);
    }
}
