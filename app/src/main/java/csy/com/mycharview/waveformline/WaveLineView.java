package csy.com.mycharview.waveformline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.List;

import csy.com.mycharview.waveformline.bean.WavePoint;

/**
 * Created by user on 2017-6-14.
 */

public class WaveLineView extends BaseWaveLineView {

    private int smallSpaceX = 20;//水平方向一小格代表多少像素
    private int smallSpaceY = 20;//垂直方向一小格代表多少像素
    private String gridPaintColor;//网格颜色
    private int gridPaintStrokeWidth;//网格画笔粗细
    private String dataPaintColor;//数据颜色
    private int dataPaintStrokeWidth;//数据粗细
    private int baseLine;//基线

    public void setPoints(List<WavePoint> pointsList) {
        this.pointsList = pointsList;
    }

    private List<WavePoint> pointsList;

    public WaveLineView(Context context) {
        this(context, null);
    }

    public WaveLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);//获取一些自定义属性
        initData();
    }

    @Override
    void initData() {
        gridPaintColor = "#ee934f";
        gridPaintStrokeWidth = 1;
        dataPaintColor = "#000000";
        dataPaintStrokeWidth = 2;
        baseLine = getHeight() / 2;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //高度一屏显示完,宽度自适应
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGrid(canvas);
        drawData(canvas);
    }

    //画数据 数据转换为像素 *smallSpace
    private void drawData(Canvas canvas) {
        if (pointsList == null && pointsList.size() == 0)
            return;
        getmPaint().setColor(Color.parseColor(dataPaintColor));
        getmPaint().setStrokeWidth(dataPaintStrokeWidth);
        getmPaint().setAntiAlias(true);// 消除锐化  不然线条毛糙
        getmPaint().setStyle(Paint.Style.STROKE);//一定要设置样式为STROKE 空心 不然默认为实心,画出来的一团黑
        //getmPaint().setStyle(Paint.Style.FILL);//实心填充
        //getmPaint().setStyle(Paint.Style.FILL_AND_STROKE);//实心填充

        Path dataPath = new Path();
        dataPath.moveTo(pointsList.get(0).getX(), pointsList.get(0).getY() * smallSpaceY);//移动画笔位置到第一个点位置,默认是从0,0开始的
        for (int i = 0; i < pointsList.size() && pointsList.get(i).getX() * smallSpaceX < getWidth(); i++) {
            //1小格代表数字1 x方向每小格多少像素  y轴方向每小格多少像素
            dataPath.lineTo(pointsList.get(i).getX() * smallSpaceX, pointsList.get(i).getY() * smallSpaceY);
        }
        //dataPath.close();//封闭  和不封闭 的图像相差大 一般用于比如三角形
        canvas.drawPath(dataPath, getmPaint());//绘制路径


    }

    /**
     * 画网格
     *
     * @param canvas
     */
    private void drawGrid(Canvas canvas) {
        getmPaint().setColor(Color.parseColor(gridPaintColor));
        getmPaint().setStrokeWidth(gridPaintStrokeWidth);
        for (int i = 0; i < getHeight(); i = i + smallSpaceX) {//画水平网格
            canvas.drawLine(0, i, getWidth(), i, getmPaint());
        }

        for (int j = 0; j < getWidth(); j = j + smallSpaceY) {//画垂直网格
            canvas.drawLine(j, 0, j, getHeight(), getmPaint());
        }
    }
}
