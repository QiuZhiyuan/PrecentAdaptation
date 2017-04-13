package com.qiu.adapt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.qiu.adapt.util.PrecentEntry;

/**
 * Created by qiu on 17/4/13.
 */

public class PrecentRelativeLayout extends RelativeLayout {
    private PrecentEntry precentEntry;


    public PrecentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        precentEntry = new PrecentEntry(context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams params = new LayoutParams(getContext(), attrs);
        PrecentEntry itemPrecentEntry = new PrecentEntry(getContext(), attrs);
        itemPrecentEntry.modifyLayoutParams(params);
        return params;
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        precentEntry.modifyLayoutParams(params);
        precentEntry.modifyPadding(this);
    }
}
