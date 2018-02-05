package com.weex.sample.activity;

import com.weex.sample.R;

public class WeexUIActivity extends BaseActivity {

    @Override
    protected void startRenderPage() {
        renderLocalWeexPage("home.js");
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_weex_ui;
    }
}
