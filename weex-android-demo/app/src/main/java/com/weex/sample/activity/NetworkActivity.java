package com.weex.sample.activity;

import com.weex.sample.Constants;
import com.weex.sample.R;

public class NetworkActivity extends BaseActivity {

    @Override
    protected void startRenderPage() {
        renderNetWeexPage(Constants.URL_NET_JS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_network;
    }
}
