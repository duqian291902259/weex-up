package com.weex.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        findViewById(R.id.btn_local).setOnClickListener(this);
        findViewById(R.id.btn_network).setOnClickListener(this);
        findViewById(R.id.btn_fragment).setOnClickListener(this);
        findViewById(R.id.btn_multi_instance).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_local:
                startActivity(LocalActivity.class);
                break;
            case R.id.btn_network:
                startActivity(NetworkActivity.class);
                break;
            case R.id.btn_fragment:
                startActivity(WXFragmentActivity.class);
                break;
            case R.id.btn_multi_instance:
                startActivity(MultiInstanceActivity.class);
                break;
            default:
                break;
        }
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(IndexActivity.this, cls));
    }
}
