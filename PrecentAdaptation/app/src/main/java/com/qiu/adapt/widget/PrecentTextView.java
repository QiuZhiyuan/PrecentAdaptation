package com.qiu.adapt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiu.adapt.util.PrecentEntry;

/**
 * Created by qiu on 16/11/23.
 */

public class PrecentTextView extends TextView {

    private PrecentEntry precentEntry;

    public PrecentTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        precentEntry = new PrecentEntry(context,attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        precentEntry.modifyLayoutParams(params);

    }
}
