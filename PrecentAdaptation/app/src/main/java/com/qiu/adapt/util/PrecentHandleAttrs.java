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

public class PrecentHandleAttrs {

    private int width;

    private int height;

    private int paddingTop;

    private int paddingLeft;

    private int paddingRight;

    private int paddingBottom;

    private int marginTop;

    private int marginLeft;

    private int marginRight;

    private int marginBottom;

    private static int DV = -1;


    public PrecentHandleAttrs(Context context, AttributeSet attrs) {
        if (context == null || attrs == null) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.adaptation);
        initParams(typedArray);
        typedArray.recycle();
    }

    protected void initParams(TypedArray typedArray) {
        if (typedArray == null) {
            return;
        }
        width = typedArray.getInt(R.styleable.adaptation_p_layout_width, DV);
        if (checkNum(width)) {
            width = PrecentHelper.i().getPrecentByWidth(width);
        }
        height = typedArray.getInt(R.styleable.adaptation_p_layout_height, DV);
        if (checkNum(height)) {
            height = PrecentHelper.i().getPrecentByHeight(height);
        }

        initPaddings(typedArray);
        initMargins(typedArray);

    }

    private void initPaddings(TypedArray typedArray) {
        paddingLeft = typedArray.getInt(R.styleable.adaptation_p_padding_left, DV);
        if (checkNum(paddingLeft)) {
            paddingLeft = PrecentHelper.i().getPrecentByWidth(paddingLeft);
        }
        paddingRight = typedArray.getInt(R.styleable.adaptation_p_padding_right, DV);
        if (checkNum(paddingRight)) {
            paddingRight = PrecentHelper.i().getPrecentByWidth(paddingLeft);
        }

        paddingTop = typedArray.getInt(R.styleable.adaptation_p_padding_top, DV);
        if (checkNum(paddingTop)) {
            paddingTop = PrecentHelper.i().getPrecentByHeight(paddingTop);
        }

        paddingBottom = typedArray.getInt(R.styleable.adaptation_p_padding_bottom, DV);
        if (checkNum(paddingBottom)) {
            paddingBottom = PrecentHelper.i().getPrecentByHeight(paddingBottom);
        }
    }


    private void initMargins(TypedArray typedArray) {
        marginLeft = typedArray.getInt(R.styleable.adaptation_p_layout_margin_left, DV);
        if (checkNum(marginLeft)) {
            marginLeft = PrecentHelper.i().getPrecentByWidth(marginLeft);
        }

        marginRight = typedArray.getInt(R.styleable.adaptation_p_layout_margin_right, DV);
        if (checkNum(marginRight)) {
            marginRight = PrecentHelper.i().getPrecentByWidth(marginRight);
        }

        marginTop = typedArray.getInt(R.styleable.adaptation_p_layout_margin_top, DV);
        if (checkNum(marginTop)) {
            marginTop = PrecentHelper.i().getPrecentByHeight(marginTop);
        }

        marginBottom = typedArray.getInt(R.styleable.adaptation_p_layout_margin_bottom, DV);
        if (checkNum(marginBottom)) {
            marginBottom = PrecentHelper.i().getPrecentByHeight(marginBottom);
        }
    }

    public void modifyView(View view) {
        modifyPadding(view);
    }

    private void modifyPadding(View view) {
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

    protected boolean checkNum(float num) {
        if (num > 0) {
            return true;
        }
        return false;
    }
}