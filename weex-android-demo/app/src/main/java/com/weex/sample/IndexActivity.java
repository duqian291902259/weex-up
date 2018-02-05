package com.weex.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.weex.sample.activity.MessageActivity;
import com.weex.sample.activity.FullscreenActivity;
import com.weex.sample.activity.LocalActivity;
import com.weex.sample.activity.MultiInstanceActivity;
import com.weex.sample.activity.NetworkActivity;
import com.weex.sample.activity.WeexUIActivity;
import com.weex.sample.fragment.WXFragmentActivity;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        findViewById(R.id.btn_weex_ui).setOnClickListener(this);
        findViewById(R.id.btn_local).setOnClickListener(this);
        findViewById(R.id.btn_network).setOnClickListener(this);
        findViewById(R.id.btn_fragment).setOnClickListener(this);
        findViewById(R.id.btn_multi_instance).setOnClickListener(this);
        findViewById(R.id.btn_message).setOnClickListener(this);
        findViewById(R.id.btn_dusan_demo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_weex_ui:
                startActivity(WeexUIActivity.class);
                break;
            case R.id.btn_message:
                startActivity(MessageActivity.class);
                break;
            case R.id.btn_dusan_demo:
                startActivity(FullscreenActivity.class);
                break;
            case R.id.btn_multi_instance:
                startActivity(MultiInstanceActivity.class);
                break;
            case R.id.btn_local:
                startActivity(LocalActivity.class);
                break;
            case R.id.btn_network:
                startActivity(NetworkActivity.class);
                break;
            case R.id.btn_fragment:
                startActivity(WXFragmentActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(IndexActivity.this, cls));
    }
}
