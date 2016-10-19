// Generated code from Butter Knife. Do not modify!
package com.example.androidtest.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ScrollingActivity$$ViewBinder<T extends com.example.androidtest.activity.ScrollingActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493001, "field 'actionBarBg'");
    target.actionBarBg = finder.castView(view, 2131493001, "field 'actionBarBg'");
    view = finder.findRequiredView(source, 2131493002, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131493002, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131493000, "field 'toolbarLayout'");
    target.toolbarLayout = finder.castView(view, 2131493000, "field 'toolbarLayout'");
    view = finder.findRequiredView(source, 2131492999, "field 'appBar'");
    target.appBar = finder.castView(view, 2131492999, "field 'appBar'");
    view = finder.findRequiredView(source, 2131493004, "field 'fab'");
    target.fab = finder.castView(view, 2131493004, "field 'fab'");
    view = finder.findRequiredView(source, 2131492993, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131492993, "field 'viewPager'");
    view = finder.findRequiredView(source, 2131493003, "field 'tablayout'");
    target.tablayout = finder.castView(view, 2131493003, "field 'tablayout'");
  }

  @Override public void unbind(T target) {
    target.actionBarBg = null;
    target.toolbar = null;
    target.toolbarLayout = null;
    target.appBar = null;
    target.fab = null;
    target.viewPager = null;
    target.tablayout = null;
  }
}
