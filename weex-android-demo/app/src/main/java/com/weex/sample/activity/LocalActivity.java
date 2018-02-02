package com.weex.sample.activity;

import com.weex.sample.R;

public class LocalActivity extends BaseActivity {

    @Override
    protected void startRenderPage() {
        renderLocalWeexPage(JS_NAME);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }
}
