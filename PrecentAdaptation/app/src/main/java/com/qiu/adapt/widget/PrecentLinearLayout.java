package com.qiu.adapt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.qiu.adapt.util.PrecentHandleAttrs;
import com.qiu.adapt.util.PrecentHelper;

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
        super.generateLayoutParams(attrs);
        return new PrecentLayoutParams(getContext(), attrs);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        PrecentHelper.i().adaptView(child);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if (!isInEditMode()) {
//            PrecentHelper.i().adaptChildren(this);
//        }
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        precentAttrs.modifyView(this);
    }

    public class PrecentLayoutParams extends LayoutParams implements PrecentHelper.HandleParams {

        private PrecentHandleAttrs handleAttrs;

        public PrecentLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            handleAttrs = new PrecentHandleAttrs(getContext(), attrs);
            handleAttrs.modifyLayoutParams(this);
        }

        @Override
        public PrecentHandleAttrs getHandleAttrs() {
            return handleAttrs;
        }
    }
}
