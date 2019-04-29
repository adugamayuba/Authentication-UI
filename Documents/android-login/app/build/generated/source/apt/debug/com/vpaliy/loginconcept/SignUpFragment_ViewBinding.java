// Generated code from Butter Knife. Do not modify!
package com.vpaliy.loginconcept;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignUpFragment_ViewBinding extends AuthFragment_ViewBinding {
  private SignUpFragment target;

  @UiThread
  public SignUpFragment_ViewBinding(SignUpFragment target, View source) {
    super(target, source);

    this.target = target;

    target.views = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.email_input_edit, "field 'views'", TextInputEditText.class), 
        Utils.findRequiredViewAsType(source, R.id.password_input_edit, "field 'views'", TextInputEditText.class), 
        Utils.findRequiredViewAsType(source, R.id.confirm_password_edit, "field 'views'", TextInputEditText.class));
  }

  @Override
  public void unbind() {
    SignUpFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.views = null;

    super.unbind();
  }
}
