package site.duqian.weex.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.taobao.weex.WXSDKInstance;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import site.duqian.weex.Constants;
import site.duqian.weex.R;

public class NetworkActivity extends BaseActivity {


    @BindView(R.id.et_js_url)
    EditText etJsUrl;
    @BindView(R.id.tv_result)
    TextView tv_result;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_network;
    }

    @Override
    protected void initView() {
        super.initView();
        etJsUrl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                startRenderPage();
            }
        });
    }

    @Override
    protected void startRenderPage() {
        String url = etJsUrl.getText().toString().trim();
        if (TextUtils.isEmpty(url) || !url.startsWith("http")) {
            renderNetWeexPage(Constants.URL_NET_JS);
            Toast.makeText(mContext, "Please input right and valid url", Toast.LENGTH_LONG).show();
        } else {
            renderNetWeexPage(url);
        }
    }

    @Override
    protected void handlerRenderError(WXSDKInstance instance, String errCode, String msg) {
        tv_result.setText("请检查网络或URL，render state:"+errCode);
    }
    @Override
    protected void handleRenderSuccess(WXSDKInstance instance, int width, int height) {
        tv_result.setText("render success!w="+width+",h="+height);
    }
    @OnClick(R.id.tv_result)
    public void render() {
        startRenderPage();
    }

    @OnClick(R.id.tv_tips)
    public void clear() {
        etJsUrl.setText("http://192.168.0.68:8081/dist/hello.js");
    }

    @OnLongClick(R.id.tv_tips)
    public boolean reset() {
        etJsUrl.setText("");
        return true;
    }

}
