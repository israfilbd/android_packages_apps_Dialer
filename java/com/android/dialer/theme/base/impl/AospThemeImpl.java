/*
 * Copyright (C) 2018 The Android Open Source Project
 * Copyright (C) 2023-2025 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.dialer.theme.base.impl;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;

import com.android.dialer.R;
import com.android.dialer.common.Assert;
import com.android.dialer.theme.base.Theme;
import com.android.dialer.util.DialerUtils;

import javax.inject.Singleton;

/** Utility for fetching dynamic theme attributes. */
@SuppressWarnings("unused")
@Singleton
public class AospThemeImpl implements Theme {

  private final Context appContext;

  public AospThemeImpl(Context context) {
    this.appContext = context.getApplicationContext();
  }

  @Override
  public @Type int getTheme() {
    return LIGHT;
  }

  @Override
  public @StyleRes int getApplicationThemeRes() {
    return R.style.Dialer_ThemeBase_NoActionBar;
  }

  @Override
  public Context getThemedContext(Context context) {
    return new ContextThemeWrapper(context, getApplicationThemeRes());
  }

  @Override
  public LayoutInflater getThemedLayoutInflator(LayoutInflater inflater) {
    return inflater.cloneInContext(getThemedContext(inflater.getContext()));
  }

  @Override
  public @ColorInt int getColorIcon() {
    return DialerUtils.resolveColor(appContext, R.attr.colorIcon);
  }

  @Override
  public @ColorInt int getColorIconSecondary() {
    return DialerUtils.resolveColor(appContext, R.attr.colorIconSecondary);
  }

  @Override
  public @ColorInt int getColorPrimary() {
    return DialerUtils.resolveColor(appContext, android.R.attr.colorPrimary);
  }

  @Override
  public int getColorPrimaryDark() {
    return DialerUtils.resolveColor(appContext, android.R.attr.colorPrimaryDark);
  }

  @Override
  public @ColorInt int getColorAccent() {
    return DialerUtils.resolveColor(appContext, android.R.attr.colorAccent);
  }

  @Override
  public @ColorInt int getTextColorSecondary() {
    return DialerUtils.resolveColor(appContext, android.R.attr.textColorSecondary);
  }

  @Override
  public @ColorInt int getTextColorPrimary() {
    return DialerUtils.resolveColor(appContext, android.R.attr.textColorPrimary);
  }

  @Override
  public @ColorInt int getColorTextOnUnthemedDarkBackground() {
    return 0xFFFFFFFF;
  }

  @Override
  public @ColorInt int getColorIconOnUnthemedDarkBackground() {
    return 0xFFFFFFFF;
  }

  @Override
  public @ColorInt int getColorCallNotificationBackground() {
    return DialerUtils.resolveColor(appContext, R.attr.colorCallNotificationBackground);
  }
}
