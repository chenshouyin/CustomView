package csy.com.mycharview.waveformline;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by user on 2017-6-14.
 */

public abstract class BaseWaveLineView extends View{
    private Paint mPaint;//画笔

    public BaseWaveLineView(Context context) {
        super(context);
    }

    public BaseWaveLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseWaveLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public Paint getmPaint() {
        if (mPaint==null)
            mPaint = new Paint();
        return mPaint;
    }

    /**
     * 初始化资源
     */
    public abstract void initData();
}
