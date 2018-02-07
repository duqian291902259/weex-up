package site.duqian.weex.activity;

import site.duqian.weex.Constants;
import site.duqian.weex.R;

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
