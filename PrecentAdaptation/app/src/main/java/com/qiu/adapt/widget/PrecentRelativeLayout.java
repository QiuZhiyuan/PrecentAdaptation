package com.qiu.adapt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.qiu.adapt.util.PrecentHandleAttrs;
import com.qiu.adapt.util.PrecentHelper;

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
        LayoutParams params = new PrecentLayoutParams(getContext(), attrs);
        return params;
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        PrecentHelper.i().adaptView(child);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        precentHandleAttrs.modifyView(this);
    }

    public static class PrecentLayoutParams extends LayoutParams implements PrecentHelper.HandleParams {

        private PrecentHandleAttrs handleAttrs;

        public PrecentLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            handleAttrs = new PrecentHandleAttrs(c, attrs);
            handleAttrs.modifyLayoutParams(this);

        }

        @Override
        public PrecentHandleAttrs getHandleAttrs() {
            return handleAttrs;
        }
    }
}
