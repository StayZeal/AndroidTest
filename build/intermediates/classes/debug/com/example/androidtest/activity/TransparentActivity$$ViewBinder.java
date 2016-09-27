// Generated code from Butter Knife. Do not modify!
package com.example.androidtest.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TransparentActivity$$ViewBinder<T extends com.example.androidtest.activity.TransparentActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493001, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131493001, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131492996, "field 'titleImage'");
    target.titleImage = finder.castView(view, 2131492996, "field 'titleImage'");
    view = finder.findRequiredView(source, 2131492997, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131492997, "field 'viewPager'");
  }

  @Override public void unbind(T target) {
    target.toolbar = null;
    target.titleImage = null;
    target.viewPager = null;
  }
}
