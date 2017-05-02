package com.example.wuzp.umengdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wuzp.umengdemo.view.base.BaseActivity;
import com.example.wuzp.umengdemo.view.other.OtherActivity;
import com.example.wuzp.umengdemo.view.stats.EventFinal;
import com.example.wuzp.umengdemo.view.utils.UUID;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnOther;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Map<String,String> params = new HashMap<>();
        params.put("device_id", UUID.getInstance(this).getUUID());
        params.put("tag", TAG);
        MobclickAgent.onEvent(mContext, EventFinal.ACTIVITY_MAINACTIVITY, params);
    }

    private void initView(){
        btnOther = (Button)findViewById(R.id.btn_Other);
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OtherActivity.class);
                startActivity(intent);
                MobclickAgent.onEvent(MainActivity.this, EventFinal.CLICK_MAINACTIVITY_CLICK);
            }
        });
    }
}
