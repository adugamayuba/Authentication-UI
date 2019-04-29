// Generated code from Butter Knife. Do not modify!
package com.vpaliy.flip_concept;

import android.support.annotation.UiThread;
import android.view.View;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LogInFragment_ViewBinding extends AuthFragment_ViewBinding {
  private LogInFragment target;

  @UiThread
  public LogInFragment_ViewBinding(LogInFragment target, View source) {
    super(target, source);

    this.target = target;

    target.views = Utils.listOf(
        Utils.findRequiredView(source, R.id.email_input_edit, "field 'views'"), 
        Utils.findRequiredView(source, R.id.password_input_edit, "field 'views'"));
  }

  @Override
  public void unbind() {
    LogInFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.views = null;

    super.unbind();
  }
}
