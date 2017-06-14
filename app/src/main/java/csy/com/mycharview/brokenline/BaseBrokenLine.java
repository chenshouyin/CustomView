package csy.com.mycharview.brokenline;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by user on 2017-6-14.
 */

/**
 * 折线基类
 */
public class BaseBrokenLine {

    private Paint mPaint;//点画笔

    public Paint getmPaint() {
        if (mPaint==null)
            mPaint = new Paint();
        return mPaint;
    }
}
