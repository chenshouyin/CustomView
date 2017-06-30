package csy.com.mycharview.waveformline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import csy.com.mycharview.R;
import csy.com.mycharview.utils.Dbug;
import csy.com.mycharview.utils.ScreenUtils;
import csy.com.mycharview.waveformline.bean.WavePoint;

/**
 * Created by user on 2017-6-14.
 */

public class WaveActivity extends AppCompatActivity {

    private List<WavePoint> pointsList;

    @BindView(R.id.waveLine)
    WaveLineView waveLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        ButterKnife.bind(this);
        pointsList = new ArrayList<>();
        for (int i = 0; i < 400; i+=1) {//模拟100个数据
            Random random = new Random();
            WavePoint wavePoint = new WavePoint();
            wavePoint.setX(i);
            wavePoint.setY(random.nextInt(20));
            pointsList.add(wavePoint);
        }
        waveLine.setPerPointXSpase(1);
        //waveLine.setPerPointYSpase(2); Y的间隔不是连续的
        waveLine.setBaseLine(ScreenUtils.getScreenHeightWithoutStatiusBar(WaveActivity.this));
        waveLine.setPoints(pointsList);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Dbug.d(getClass().getSimpleName(),"==ACTION_DOWN=="+event.getX() +"==="+event.getY());
                break;

            case MotionEvent.ACTION_MOVE:
                Dbug.d(getClass().getSimpleName(),"==ACTION_MOVE=="+event.getX() +"==="+event.getY());
                break;

            case MotionEvent.ACTION_UP:
                Dbug.d(getClass().getSimpleName(),"==ACTION_UP=="+event.getX() +"==="+event.getY());
                break;

            default:
                break;
        }
//        return super.onTouchEvent(event);
        return false;//super和false代表该事件没被消费 会继续往下传递  此处  ACTION_MOVE和 ACTION_UP不会被执行

//        return true;//返回true 或者 false 事件就被消费了（终止传递） 此处  ACTION_MOVE和 ACTION_UP会执行
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Dbug.d(getClass().getSimpleName(),"==dispatchTouchEvent==");
        return super.dispatchTouchEvent(ev);
    }
    //viewgroup才有
    //onInterceptTouchEvent
}
