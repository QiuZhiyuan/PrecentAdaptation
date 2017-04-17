package com.qiu.adapt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.qiu.adapt.util.PrecentHandleAttrs;

/**
 * Created by qiu on 17/4/12.
 */

public class PrecentLinearLayout extends LinearLayout {

    private PrecentHandleAttrs precentAttrs;

    public PrecentLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        precentAttrs = new PrecentHandleAttrs(context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams params = new LayoutParams(getContext(), attrs);
        PrecentHandleAttrs itemPrecentHandleAttrs = new PrecentHandleAttrs(getContext(), attrs);
        itemPrecentHandleAttrs.modifyLayoutParams(params);
        return params;
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        precentAttrs.modifyLayoutParams(params);
        precentAttrs.modifyPadding(this);
    }
}
