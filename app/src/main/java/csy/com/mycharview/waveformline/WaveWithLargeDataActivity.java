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

public class WaveWithLargeDataActivity extends AppCompatActivity {

    private List<WavePoint> pointsList;
    private ArrayList<WavePoint> pointsList3;


    @BindView(R.id.waveLine3)
    WaveLineViewWithLargeData waveLine3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_with_large_data);
        ButterKnife.bind(this);

        Dbug.d("WaveWithLargeDataActivity","onCreate");

        pointsList3 = new ArrayList<>();
        for (int i = 0; i < 4000; i+=2) {//模拟100个数据
            Random random = new Random();
            WavePoint wavePoint = new WavePoint();
            wavePoint.setX(i);
            wavePoint.setY(random.nextInt(20));
            pointsList3.add(wavePoint);
        }
        waveLine3.setPerPointXSpase(2);
        //waveLine.setPerPointYSpase(2); Y的间隔不是连续的
        waveLine3.setBaseLine(ScreenUtils.getScreenHeightWithoutStatiusBar(WaveWithLargeDataActivity.this));
        waveLine3.setPoints(pointsList3);

    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Dbug.d(getClass().getSimpleName(),"==ACTION_DOWN=="+event.getX() +"==="+event.getY());
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                Dbug.d(getClass().getSimpleName(),"==ACTION_MOVE=="+event.getX() +"==="+event.getY());
//                break;
//
//            case MotionEvent.ACTION_UP:
//                Dbug.d(getClass().getSimpleName(),"==ACTION_UP=="+event.getX() +"==="+event.getY());
//                break;
//
//            default:
//                break;
//        }
////        return super.onTouchEvent(event);
//        return false;//super和false代表该事件没被消费 会继续往下传递  此处  ACTION_MOVE和 ACTION_UP不会被执行
//
////        return true;//返回true 或者 false 事件就被消费了（终止传递） 此处  ACTION_MOVE和 ACTION_UP会执行
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Dbug.d(getClass().getSimpleName(),"==dispatchTouchEvent==");
//        return super.dispatchTouchEvent(ev);
//    }
    //viewgroup才有
    //onInterceptTouchEvent
}
