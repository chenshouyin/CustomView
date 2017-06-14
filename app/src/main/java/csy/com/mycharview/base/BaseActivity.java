package csy.com.mycharview.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by user on 2017-6-14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 添加监听事件
     */
    public abstract void addAction();

    /**
     * 初始化
     */
    public abstract void initData();
}
