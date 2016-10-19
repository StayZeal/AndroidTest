// Generated code from Butter Knife. Do not modify!
package com.example.androidtest.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RecycleDemoActivity$$ViewBinder<T extends com.example.androidtest.activity.RecycleDemoActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492994, "field 'list'");
    target.list = finder.castView(view, 2131492994, "field 'list'");
  }

  @Override public void unbind(T target) {
    target.list = null;
  }
}
