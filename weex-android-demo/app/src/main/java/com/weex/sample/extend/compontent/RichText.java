package com.weex.sample.extend.compontent;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.widget.TextView;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;

/**
 * Created by lixinke on 2017/2/17.
 */

public class RichText extends WXComponent<TextView> {

  public RichText(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
    super(instance, dom, parent);
  }

  @Override
  protected TextView initComponentHostView(@NonNull Context context) {
    TextView textView = new TextView(context);
    textView.setTextSize(30);
    textView.setTextColor(Color.BLACK);
    return textView;
  }

  @WXComponentProp(name = "tel")
  public void setTel(String number) {
    SpannableString spannableString=new SpannableString(number);
    spannableString.setSpan(new URLSpan("tel:"+number), 0, number.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    getHostView().setText(spannableString);
  }
}
