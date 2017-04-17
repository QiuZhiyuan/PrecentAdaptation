package com.qiu.adapt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.qiu.adapt.util.PrecentHandleAttrs;

/**
 * Created by qiu on 17/4/13.
 */

public class PrecentRelativeLayout extends RelativeLayout {
    private PrecentHandleAttrs precentHandleAttrs;


    public PrecentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        precentHandleAttrs = new PrecentHandleAttrs(context, attrs);
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
        precentHandleAttrs.modifyLayoutParams(params);
        precentHandleAttrs.modifyPadding(this);
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams{

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);


        }
    }
}
