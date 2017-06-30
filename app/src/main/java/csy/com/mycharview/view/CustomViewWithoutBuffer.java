package csy.com.mycharview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import csy.com.mycharview.utils.Dbug;
import csy.com.mycharview.waveformline.BaseWaveLineView;
import csy.com.mycharview.waveformline.bean.WavePoint;

/**
 * Created by user on 2017-6-30.
 */

public class CustomViewWithoutBuffer extends BaseWaveLineView {

    private List<WavePoint> listData;
    public CustomViewWithoutBuffer(Context context) {
        this(context, null);
    }

    public CustomViewWithoutBuffer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomViewWithoutBuffer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);//获取一些自定义属性
        initData();
    }

    @Override
    public void initData() {
        listData = new ArrayList<WavePoint>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i=0;i<listData.size();i++){
            getmPaint().setStrokeWidth(3);
            getmPaint().setColor(Color.GREEN);
            canvas.drawCircle(listData.get(i).getX(),listData.get(i).getY(),100,getmPaint());
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                WavePoint point = new WavePoint();
                point.setY(event.getY());
                point.setX(event.getX());
                listData.add(point);
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;
        }
//        return super.onTouchEvent(event);
        return true;
    }
}
