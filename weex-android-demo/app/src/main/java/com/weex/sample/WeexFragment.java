package com.weex.sample;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import java.util.HashMap;


public class WeexFragment extends Fragment implements IWXRenderListener {


  private String mBundleUrl;
  private FrameLayout mContainer;
  private WXSDKInstance mWXSDKInstance;

  public WeexFragment() {
  }

  public static WeexFragment newInstance(String bundleUrl) {
    WeexFragment fragment = new WeexFragment();
    Bundle args = new Bundle();
    args.putString(WXSDKInstance.BUNDLE_URL, bundleUrl);
    fragment.setArguments(args);
    return fragment;
  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View view = View.inflate(getActivity(), R.layout.fragment_weex, null);
    mContainer = (FrameLayout) view.findViewById(R.id.fragment_container);

    mBundleUrl = getArguments() != null ? getArguments().getString(WXSDKInstance.BUNDLE_URL) : null;
    mWXSDKInstance = new WXSDKInstance(getActivity());
    mWXSDKInstance.registerRenderListener(this);
    HashMap<String, Object> options = new HashMap<>();
    options.put(WXSDKInstance.BUNDLE_URL, mBundleUrl);
    mWXSDKInstance.renderByUrl("Weex Fragment Sample", mBundleUrl,options, null, WXRenderStrategy.APPEND_ASYNC);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    if (mContainer.getParent() != null) {
      ((ViewGroup) mContainer.getParent()).removeView(mContainer);
    }
    return mContainer;
  }

  @Override
  public void onStart() {
    super.onStart();
    if(mWXSDKInstance!=null){
      mWXSDKInstance.onActivityStart();
    }
  }

  @Override
  public void onResume() {
    super.onResume();
    if(mWXSDKInstance!=null){
      mWXSDKInstance.onActivityResume();
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    if(mWXSDKInstance!=null){
      mWXSDKInstance.onActivityPause();
    }
  }

  @Override
  public void onStop() {
    super.onStop();
    if(mWXSDKInstance!=null){
      mWXSDKInstance.onActivityStop();
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if(mWXSDKInstance!=null){
      mWXSDKInstance.onActivityDestroy();
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }

  @Override
  public void onViewCreated(WXSDKInstance instance, View view) {
    mContainer.addView(view);
  }

  @Override
  public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

  }

  @Override
  public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

  }

  @Override
  public void onException(WXSDKInstance instance, String errCode, String msg) {

  }
}
