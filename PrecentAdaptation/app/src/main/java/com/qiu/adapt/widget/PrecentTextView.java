package com.qiu.adapt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiu.adapt.util.PrecentHandleAttrs;

/**
 * Created by qiu on 16/11/23.
 */

public class PrecentTextView extends TextView {

    private PrecentHandleAttrs precentHandleAttrs;

    public PrecentTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        precentHandleAttrs = new PrecentHandleAttrs(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        precentHandleAttrs.modifyView(this);

    }
}
