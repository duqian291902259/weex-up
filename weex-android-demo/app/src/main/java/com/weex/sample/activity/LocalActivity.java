package site.duqian.weex.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import site.duqian.weex.R;
import site.duqian.weex.fragment.WXFragmentActivity;
import site.duqian.weex.ui.LocalJsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LocalActivity extends BaseActivity {

    @BindView(R.id.tv_info)
    TextView tvInfo;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    private LocalJsAdapter mAdapter;

    private Context context;
    private List<String> localFiles = new ArrayList<>();

    @Override
    protected void startRenderPage() {
        //renderLocalWeexPage(JS_NAME);
    }

    @Override
    public int getLayoutResId() {
        this.context = this;
        return R.layout.activity_local;
    }

    @Override
    protected void initData() {
        super.initData();
        initFiles();
        new Thread() {
            @Override
            public void run() {
                getLocalJsFiles();
            }
        }.start();
    }

    private void initFiles() {
        if (localFiles.size() == 0) {
            localFiles.add("index.js");
            localFiles.add("hello.js");
            localFiles.add("home.js");
            localFiles.add("guide.js");
            localFiles.add("splash.js");
            localFiles.add("storage.js");
            localFiles.add("photo.js");
            localFiles.add("weex-ui.js");
        }
    }

    private void getLocalJsFiles() {
        try {
            String[] list = getAssets().list("weex");
            int length = list.length;
            if (length > 0) {
                localFiles.clear();
            }
            for (int i = 0; i < length; i++) {
                String js = list[i];
                localFiles.add(js);
                Log.d("dq", "file " + js);
            }

            handler.sendEmptyMessage(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView() {
        super.initView();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mAdapter = new LocalJsAdapter(context);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(new LocalJsAdapter.OnItemClickListener() {
            @Override
            protected void onItemClick(View view, int position) {
                Intent intent = new Intent(context, WXFragmentActivity.class);
                String jsName = localFiles.get(position);
                intent.putExtra("name", jsName);
                context.startActivity(intent);
            }
        });

        initRefresh();
    }

    private void initRefresh() {
        swipeRefresh.setDistanceToTriggerSync(500);
        swipeRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        swipeRefresh.setSize(SwipeRefreshLayout.LARGE);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                localFiles.clear();
                initData();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setRefreshing(false);
                    }
                }, 2000);
            }
        });

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (mAdapter != null) {
                mAdapter.updateData(localFiles);
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
