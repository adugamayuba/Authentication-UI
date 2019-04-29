// Generated code from Butter Knife. Do not modify!
package com.vpaliy.loginconcept;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.sharedElements = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.logo, "field 'sharedElements'", ImageView.class), 
        Utils.findRequiredViewAsType(source, R.id.first, "field 'sharedElements'", ImageView.class), 
        Utils.findRequiredViewAsType(source, R.id.second, "field 'sharedElements'", ImageView.class), 
        Utils.findRequiredViewAsType(source, R.id.last, "field 'sharedElements'", ImageView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sharedElements = null;
  }
}
