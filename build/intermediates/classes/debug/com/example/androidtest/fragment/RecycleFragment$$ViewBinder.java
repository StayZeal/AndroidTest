// Generated code from Butter Knife. Do not modify!
package com.example.androidtest.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RecycleFragment$$ViewBinder<T extends com.example.androidtest.fragment.RecycleFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493024, "field 'recycleView'");
    target.recycleView = finder.castView(view, 2131493024, "field 'recycleView'");
  }

  @Override public void unbind(T target) {
    target.recycleView = null;
  }
}
