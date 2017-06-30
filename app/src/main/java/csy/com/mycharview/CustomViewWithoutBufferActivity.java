package csy.com.mycharview;

import android.os.Bundle;
import android.support.annotation.Nullable;

import csy.com.mycharview.base.BaseActivity;

/**
 * Created by user on 2017-6-30.
 */

public class CustomViewWithoutBufferActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_buffer);
    }

    @Override
    public void addAction() {

    }

    @Override
    public void initData() {

    }
}
