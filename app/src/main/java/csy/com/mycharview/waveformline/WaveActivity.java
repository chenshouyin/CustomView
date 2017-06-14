package csy.com.mycharview.waveformline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import csy.com.mycharview.R;
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
        for (int i = 0; i < 100; i++) {//模拟100个数据
            Random random = new Random();
            WavePoint wavePoint = new WavePoint();
            wavePoint.setX(i);
            wavePoint.setY(random.nextInt(20));
            pointsList.add(wavePoint);
        }
        waveLine.setPoints(pointsList);

    }
}
