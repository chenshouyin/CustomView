package csy.com.mycharview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import csy.com.mycharview.waveformline.BaseWaveLineView;
import csy.com.mycharview.waveformline.bean.WavePoint;

/**
 * Created by user on 2017-6-30.
 */

public class CustomViewBuffer extends BaseWaveLineView {

    private Bitmap bufferBitmap;
    private Canvas bufferCanvas;
    private List<WavePoint> listData;
    public CustomViewBuffer(Context context) {
        this(context, null);
    }

    public CustomViewBuffer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomViewBuffer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);//获取一些自定义属性
        initData();
    }

    @Override
    public void initData() {
        listData = new ArrayList<WavePoint>();
        bufferBitmap = Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
        bufferCanvas = new Canvas(bufferBitmap);//缓冲画布
        getmPaint().setStrokeWidth(3);
        getmPaint().setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bufferBitmap,0,0,getmPaint());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                bufferCanvas.drawCircle(event.getX(),event.getY(),100,getmPaint());//先画在缓冲图片上
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
