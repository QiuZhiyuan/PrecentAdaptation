package com.qiu.adapt;

import android.app.Activity;
import android.os.Bundle;

import com.qiu.adapt.util.PrecentHelper;

/**
 * Created by qiu on 17/4/12.
 */

public class PrecentLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PrecentHelper.i().init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precent_layout);
    }
}
