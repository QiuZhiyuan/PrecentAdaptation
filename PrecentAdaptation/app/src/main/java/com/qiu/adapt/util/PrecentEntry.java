package com.qiu.adapt.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.qiu.adapt.R;

/**
 * Created by qiu on 17/4/12.
 */

public class PrecentEntry {

    private int width;

    private int height;

    private int marginTop;

    private int marginLeft;

    private int marginRight;

    private int marginBottom;

    private int paddingTop;

    private int paddingLeft;

    private int paddingRight;

    private int paddingBottom;

    private static int DV = -1;


    public PrecentEntry(Context context, AttributeSet attrs) {
        if (context == null || attrs == null) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.adaptation);
        if (typedArray == null) {
            return;
        }
        width = typedArray.getInt(R.styleable.adaptation_p_layout_width, DV);
        if (checkNum(width)) {
            width = PrecentSizeUtil.i().getPrecentByWidth(width);
        }
        height = typedArray.getInt(R.styleable.adaptation_p_layout_height, DV);
        if (checkNum(height)) {
            height = PrecentSizeUtil.i().getPrecentByHeight(height);
        }

        paddingLeft = typedArray.getInt(R.styleable.adaptation_p_padding_left, DV);
        if (checkNum(paddingLeft)) {
            paddingLeft = PrecentSizeUtil.i().getPrecentByWidth(paddingLeft);
        }
        paddingRight = typedArray.getInt(R.styleable.adaptation_p_padding_right, DV);
        if (checkNum(paddingRight)) {
            paddingRight = PrecentSizeUtil.i().getPrecentByWidth(paddingLeft);
        }

        paddingTop = typedArray.getInt(R.styleable.adaptation_p_padding_top, DV);
        if (checkNum(paddingTop)) {
            paddingTop = PrecentSizeUtil.i().getPrecentByHeight(paddingTop);
        }

        paddingBottom = typedArray.getInt(R.styleable.adaptation_p_padding_bottom, DV);
        if (checkNum(paddingBottom)) {
            paddingBottom = PrecentSizeUtil.i().getPrecentByHeight(paddingBottom);
        }

        marginLeft = typedArray.getInt(R.styleable.adaptation_p_margin_left, DV);
        if (checkNum(marginLeft)) {
            marginLeft = PrecentSizeUtil.i().getPrecentByWidth(marginLeft);
        }

        marginRight = typedArray.getInt(R.styleable.adaptation_p_margin_right, DV);
        if (checkNum(marginRight)) {
            marginRight = PrecentSizeUtil.i().getPrecentByWidth(marginRight);
        }

        marginTop = typedArray.getInt(R.styleable.adaptation_p_margin_top, DV);
        if (checkNum(marginTop)) {
            marginTop = PrecentSizeUtil.i().getPrecentByHeight(marginTop);
        }

        marginBottom = typedArray.getInt(R.styleable.adaptation_p_margin_bottom, DV);
        if (checkNum(marginBottom)) {
            marginBottom = PrecentSizeUtil.i().getPrecentByHeight(marginBottom);
        }

        typedArray.recycle();

    }

    public void modifyLayoutParams(ViewGroup.LayoutParams params) {
        if (params == null) {
            return;
        }
        if (checkNum(width) && params.width != ViewGroup.LayoutParams.WRAP_CONTENT && params.width != ViewGroup.LayoutParams.MATCH_PARENT) {
            params.width = width;
        }
        if (checkNum(height) && params.height != ViewGroup.LayoutParams.WRAP_CONTENT && params.height != ViewGroup.LayoutParams.MATCH_PARENT) {
            params.height = height;
        }

        if (params instanceof ViewGroup.MarginLayoutParams) {

            int left, top, right, bottom;
            if (checkNum(marginLeft)) {
                left = marginLeft;
            } else {
                left = ((ViewGroup.MarginLayoutParams) params).leftMargin;
            }
            if (checkNum(marginTop)) {
                top = marginTop;
            } else {
                top = ((ViewGroup.MarginLayoutParams) params).topMargin;
            }
            if (checkNum(marginRight)) {
                right = marginRight;
            } else {
                right = ((ViewGroup.MarginLayoutParams) params).rightMargin;
            }
            if (checkNum(marginBottom)) {
                bottom = marginBottom;
            } else {
                bottom = ((ViewGroup.MarginLayoutParams) params).bottomMargin;
            }

            ((ViewGroup.MarginLayoutParams) params).setMargins(left, top, right, bottom);
        }
    }

    public void modifyPadding(View view) {
        int left, top, right, bottom;
        if (paddingLeft > 0) {
            left = paddingLeft;
        } else {
            left = view.getPaddingLeft();
        }
        if (paddingTop > 0) {
            top = paddingTop;
        } else {
            top = view.getPaddingTop();
        }
        if (paddingRight > 0) {
            right = paddingRight;
        } else {
            right = view.getPaddingRight();
        }
        if (paddingBottom > 0) {
            bottom = paddingBottom;
        } else {
            bottom = view.getPaddingBottom();
        }
        view.setPadding(left, top, right, bottom);
    }

    private boolean checkNum(int num) {
        if (num > 0) {
            return true;
        }
        return false;
    }
}