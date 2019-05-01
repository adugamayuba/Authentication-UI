// Generated code from Butter Knife. Do not modify!
package com.vpaliy.flip_concept;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthFragment_ViewBinding implements Unbinder {
  private AuthFragment target;

  private View view2131230763;

  @UiThread
  public AuthFragment_ViewBinding(final AuthFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.controller, "field 'controller' and method 'makeTransition'");
    target.controller = Utils.castView(view, R.id.controller, "field 'controller'", TextView.class);
    view2131230763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.makeTransition();
      }
    });
    target.parent = Utils.findRequiredViewAsType(source, R.id.parent, "field 'parent'", ViewGroup.class);
    target.first = Utils.findRequiredView(source, R.id.first, "field 'first'");
    target.second = Utils.findRequiredView(source, R.id.second, "field 'second'");
    target.last = Utils.findRequiredView(source, R.id.last, "field 'last'");
    target.logo = Utils.findRequiredView(source, R.id.focus_hider, "field 'logo'");
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.controller = null;
    target.parent = null;
    target.first = null;
    target.second = null;
    target.last = null;
    target.logo = null;

    view2131230763.setOnClickListener(null);
    view2131230763 = null;
  }
}
