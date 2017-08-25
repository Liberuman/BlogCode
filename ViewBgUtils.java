//package com.sxu.simpleemail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.view.View;

/**
 *
 * 设置View的背景的工具类
 *
 * @author Freeman
 * @date 17/8/25
 */


public class ViewBgUtils {

	public static void setShapeBg(View view, int shape, int bgColor, int radius) {
		Log.i("out", "classLoader==" + ViewBgUtils.class.getClassLoader());
		setShapeBg(view, shape, bgColor, 0, 0, radius);
	}

	public static void setShapeBg(View view, int shape, int bgColor, float[] radius) {
		setShapeBg(view, shape, bgColor, 0, 0, radius);
	}

	/**
	 * 适用于有边框且背景为纯色 -> 具有相同圆角的场景
	 * @param view
	 * @param shape
	 *      public static final int RECTANGLE = 0;  //矩形
			public static final int OVAL = 1;       // 圆形
			public static final int LINE = 2;       // 线条
			public static final int RING = 3;       // 圆环
	 * @param bgColor
	 * @param borderColor
	 * @param borderWidth
	 * @param radius
	 */
	public static void setShapeBg(View view, int shape, int bgColor, int borderColor,
	                              int borderWidth, int radius) {
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(shape);
		drawable.setColor(bgColor);
		drawable.setStroke(borderWidth, borderColor);
		drawable.setCornerRadius(radius);
		view.setBackground(drawable);
	}

	/**
	 * 适用于有边框且背景为纯色 -> 圆角有差异的场景
	 * @param view
	 * @param shape
	 * @param bgColor
	 * @param borderColor
	 * @param borderWidth
	 * @param radius
	 */
	public static void setShapeBg(View view, int shape, int bgColor, int borderColor,
	                              int borderWidth, float[] radius) {
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(shape);
		drawable.setColor(bgColor);
		drawable.setStroke(borderWidth, borderColor);
		drawable.setCornerRadii(radius);
		view.setBackground(drawable);
	}

	public static void setShapeBg(View view, int shape, GradientDrawable.Orientation orientation,
	                              int[] bgColor, int radius) {
		setShapeBg(view, shape, orientation, bgColor, 0, 0, radius);
	}

	public static void setShapeBg(View view, int shape, GradientDrawable.Orientation orientation,
	                              int[] bgColor, float[] radius) {
		setShapeBg(view, shape, orientation, bgColor, 0, 0, radius);
	}

	/**
	 * 适用于渐变背景 -> 具有相同圆角的场景
	 * @param view
	 * @param shape
	 * @param orientation
	 * @param bgColor
	 * @param radius
	 */
	public static void setShapeBg(View view, int shape, GradientDrawable.Orientation orientation,
	                              int[] bgColor, int borderColor, int borderWidth, int radius) {
		GradientDrawable drawable = new GradientDrawable(orientation, bgColor);
		drawable.setShape(shape);
		drawable.setStroke(borderWidth, borderColor);
		drawable.setCornerRadius(radius);
		view.setBackground(drawable);
	}

	/**
	 * 适用于渐变背景 -> 圆角有差异的场景
	 * @param view
	 * @param shape
	 * @param orientation
	 * @param bgColor
	 * @param radius
	 */
	public static void setShapeBg(View view, int shape, GradientDrawable.Orientation orientation,
	                              int[] bgColor, int borderColor, int borderWidth, float[] radius) {
		GradientDrawable drawable = new GradientDrawable(orientation, bgColor);
		drawable.setShape(shape);
		drawable.setStroke(borderWidth, borderColor);
		drawable.setCornerRadii(radius);
		view.setBackground(drawable);
	}

	public static Drawable getDrawable(int shape, int bgColor, int radius) {
		return getDrawable(shape, bgColor, 0, 0, radius);
	}

	public static Drawable getDrawable(int shape, int bgColor, float[] radius) {
		return getDrawable(shape, bgColor, 0, 0, radius);
	}

	/**
	 * 获取构造的背景 -> 具有相同圆角的场景
	 * @param shape
	 * @param bgColor
	 * @param borderColor
	 * @param borderWidth
	 * @param radius
	 * @return
	 */
	public static Drawable getDrawable(int shape, int bgColor, int borderColor,
	                                   int borderWidth, int radius) {
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(shape);
		drawable.setColor(bgColor);
		drawable.setStroke(borderWidth, borderColor);
		drawable.setCornerRadius(radius);
		return drawable;
	}

	/**
	 * 获取构造的背景 -> 圆角有差异的场景
	 * @param shape
	 * @param bgColor
	 * @param borderColor
	 * @param borderWidth
	 * @param radius
	 * @return
	 */
	public static Drawable getDrawable(int shape, int bgColor, int borderColor,
	                                   int borderWidth, float[] radius) {
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(shape);
		drawable.setColor(bgColor);
		drawable.setStroke(borderWidth, borderColor);
		drawable.setCornerRadii(radius);
		return drawable;
	}


	public static void setSelectorBg(View view, int state, int shape, int[] bgColor, int radius) {
		setSelectorBg(view, state, shape, bgColor, new int[2], 0, radius);
	}

	public static void setSelectorBg(View view, int state, int shape, int[] bgColor, float[] radius) {
		setSelectorBg(view, state, shape, bgColor, null, 0, radius);
	}

	/**
	 * 根据View的状态加载背景 -> <selector></selector>的代码实现 -> 具有相同圆角的场景
	 * @param view
	 * @param state 取值：android.R.attr.*
	 *      public static final int state_above_anchor = 16842922;
	public static final int state_accelerated = 16843547;
	public static final int state_activated = 16843518;
	public static final int state_active = 16842914;
	public static final int state_checkable = 16842911;
	public static final int state_checked = 16842912;
	public static final int state_drag_can_accept = 16843624;
	public static final int state_drag_hovered = 16843625;
	public static final int state_empty = 16842921;
	public static final int state_enabled = 16842910;
	public static final int state_expanded = 16842920;
	public static final int state_first = 16842916;
	public static final int state_focused = 16842908;
	public static final int state_hovered = 16843623;
	public static final int state_last = 16842918;
	public static final int state_long_pressable = 16843324;
	public static final int state_middle = 16842917;
	public static final int state_multiline = 16843597;
	public static final int state_pressed = 16842919;
	public static final int state_selected = 16842913;
	public static final int state_single = 16842915;
	public static final int state_window_focused = 16842909;
	 *
	 * @param shape
	 * @param bgColor
	 * @param borderColor
	 * @param borderWidth
	 * @param radius
	 */
	public static void setSelectorBg(View view, int state, int shape, int[] bgColor, int[] borderColor,
	                              int borderWidth, int radius) {
		if (bgColor == null || bgColor.length < 2) {
			throw new IllegalArgumentException();
		}
		int normalBorderColor = 0;
		int stateBorderColor = 0;
		if (borderColor != null && borderColor.length == 2) {
			normalBorderColor = borderColor[0];
			stateBorderColor = borderColor[1];
		}
		StateListDrawable drawable = new StateListDrawable();
		drawable.addState(new int[] {state}, getDrawable(shape, bgColor[1], stateBorderColor, borderWidth, radius));
		drawable.addState(new int[] {}, getDrawable(shape, bgColor[0], normalBorderColor, borderWidth, radius));
		view.setBackground(drawable);
	}

	/**
	 * 根据View的状态加载背景 -> <selector></selector>的代码实现 -> 圆角不同的场景
	 * @param view
	 * @param state addState第一个参数设置为new int[]{}或者new int[] {-state}表示默认状态
	 * @param shape
	 * @param bgColor
	 * @param borderColor
	 * @param borderWidth
	 * @param radius
	 */
	public static void setSelectorBg(View view, int state, int shape, int[] bgColor, int[] borderColor,
	                                 int borderWidth, float[] radius) {
		if (bgColor == null || bgColor.length < 2) {
			throw new IllegalArgumentException();
		}
		int normalBorderColor = 0;
		int stateBorderColor = 0;
		if (borderColor != null && borderColor.length == 2) {
			normalBorderColor = borderColor[0];
			stateBorderColor = borderColor[1];
		}
		StateListDrawable drawable = new StateListDrawable();
		drawable.addState(new int[] {state}, getDrawable(shape, bgColor[1], stateBorderColor, borderWidth, radius));
		drawable.addState(new int[] {}, getDrawable(shape, bgColor[0], normalBorderColor, borderWidth, radius));
		view.setBackground(drawable);
	}

	/**
	 * 根据View状态设置不同的背景
	 * @param context
	 * @param view
	 * @param state
	 * @param resId 可为color, drawable
	 */
	public static void setSelectorBg(Context context, View view, int state, int[] resId) {
		if (resId == null || resId.length < 2) {
			throw new IllegalArgumentException();
		}
		if (view.getContext() != null && view.getContext().getResources() != null) {
			StateListDrawable drawable = new StateListDrawable();
			drawable.addState(new int[]{state}, view.getContext().getResources().getDrawable(resId[1]));
			drawable.addState(new int[]{}, view.getContext().getResources().getDrawable(resId[0]));
			view.setBackground(drawable);
		}
	}
}
