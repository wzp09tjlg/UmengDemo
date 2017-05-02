package com.example.wuzp.umengdemo.view.other;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wuzp.umengdemo.R;
import com.example.wuzp.umengdemo.view.base.BaseActivity;
import com.example.wuzp.umengdemo.view.stats.EventFinal;
import com.example.wuzp.umengdemo.view.utils.UUID;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuzp on 2017/5/2.
 */

public class OtherActivity extends BaseActivity {
    private static final String TAG = OtherActivity.class.getSimpleName();
    private Button btnNull;
    private Context mContext = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Map<String,String> params = new HashMap<>();
        params.put("device_id", UUID.getInstance(this).getUUID());
        params.put("tag", TAG);
        MobclickAgent.onEvent(mContext, EventFinal.ACTIVITY_GLIDEACTIVITY, params);
    }

    private void initView(){
       btnNull = (Button)findViewById(R.id.btn_null);
        btnNull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OtherActivity.this,"other click",Toast.LENGTH_LONG).show();
                MobclickAgent.onEvent(OtherActivity.this, EventFinal.CLICK_GLIDEACTIVITY_CLICK);
            }
        });
    }
}
