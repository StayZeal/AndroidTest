// Generated code from Butter Knife. Do not modify!
package com.example.androidtest.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RecycleHelperActivity$$ViewBinder<T extends com.example.androidtest.activity.RecycleHelperActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493023, "field 'recycleView'");
    target.recycleView = finder.castView(view, 2131493023, "field 'recycleView'");
  }

  @Override public void unbind(T target) {
    target.recycleView = null;
  }
}
