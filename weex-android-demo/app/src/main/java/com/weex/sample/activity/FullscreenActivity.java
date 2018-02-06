package com.weex.sample.activity;

import android.support.v7.app.ActionBar;

import com.weex.sample.R;

import butterknife.OnClick;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends BaseActivity {
    private boolean mVisible = true;

    @Override
    protected void initView() {
        hide();
    }

    @OnClick(R.id.container)
    public void display() {
        //toggle();
    }

    @Override
    protected void startRenderPage() {
        renderLocalWeexPage("weex/guide.js");
        //renderNetWeexPage("http://192.168.0.68:8081/dist/guide.js");
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_fullscreen;
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mVisible = false;

    }

    private void show() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
        mVisible = true;
    }

}
