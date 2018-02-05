package com.weex.sample.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.weex.sample.Constants;
import com.weex.sample.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class CommunicationActivity extends BaseActivity {

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //http://192.168.0.68:8081/dist/hello.js
    private static String BASE_HOST = "http://192.168.0.68:8081";
    private static String LOCAL_JS_URL = BASE_HOST + "/dist/index.js";

    @Override
    protected void initView() {
        super.initView();
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Native 向weex发送消息，事件", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                sendEvent2Js();
            }
        });
        registerWeexReceiver();
    }

    private void registerWeexReceiver() {
        registerReceiver(receiver, new IntentFilter(Constants.BC_ACTION));
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d("dq", "received " + action);
            String url = intent.getStringExtra("url");
            if (!TextUtils.isEmpty(url)) {
                renderNetWeexPage(url);
            }
        }
    };

    @Override
    protected void startRenderPage() {
        renderLocalWeexPage("index.js");
        //renderNetWeexPage(LOCAL_JS_URL);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_communication;
    }

    @OnClick(R.id.tv_tips)
    public void send() {
        startRenderPage();
        sendEvent2Js();
    }

    private void sendEvent2Js() {
        Map<String, Object> params = new HashMap<>();
        params.put("key", "杜乾duqian");
        mWXSDKInstance.fireGlobalEventCallback("testEvent", params);
    }
}
