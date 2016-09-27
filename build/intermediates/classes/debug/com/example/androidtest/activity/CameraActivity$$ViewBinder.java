// Generated code from Butter Knife. Do not modify!
package com.example.androidtest.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CameraActivity$$ViewBinder<T extends com.example.androidtest.activity.CameraActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492969, "field 'mPreview'");
    target.mPreview = finder.castView(view, 2131492969, "field 'mPreview'");
    view = finder.findRequiredView(source, 2131492970, "field 'framlayout'");
    target.framlayout = finder.castView(view, 2131492970, "field 'framlayout'");
  }

  @Override public void unbind(T target) {
    target.mPreview = null;
    target.framlayout = null;
  }
}
