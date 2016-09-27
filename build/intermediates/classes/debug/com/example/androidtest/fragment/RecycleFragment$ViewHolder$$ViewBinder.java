// Generated code from Butter Knife. Do not modify!
package com.example.androidtest.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RecycleFragment$ViewHolder$$ViewBinder<T extends com.example.androidtest.fragment.RecycleFragment.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 16908308, "field 'content'");
    target.content = finder.castView(view, 16908308, "field 'content'");
  }

  @Override public void unbind(T target) {
    target.content = null;
  }
}
