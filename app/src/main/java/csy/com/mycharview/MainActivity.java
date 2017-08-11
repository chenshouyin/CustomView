package csy.com.mycharview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import csy.com.mycharview.base.BaseActivity;
import csy.com.mycharview.utils.Dbug;
import csy.com.mycharview.waveformline.WaveActivity;
import csy.com.mycharview.waveformline.WaveWithLargeDataActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.btDrawData1)
    Button btDrawData1;
    @BindView(R.id.btDrawData2)
    Button btDrawData2;
    @BindView(R.id.btWaveActivity)
    Button btWaveActivity;
    @BindView(R.id.btWaveActivity2)
    Button btWaveActivity2;


//    @BindView(R.id.btWaveActivity2)
//    Button btWaveActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addAction();
    }

    @Override
    public void addAction() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.btDrawData1, R.id.btDrawData2, R.id.btWaveActivity, R.id.btWaveActivity2,R.id.btWaveActivity3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btDrawData1:
                Intent intent1 = new Intent(MainActivity.this, CustomViewWithoutBufferActivity.class);
                startActivity(intent1);
                break;
            case R.id.btDrawData2:
                Intent intent2 = new Intent(MainActivity.this, CustomViewBufferActivity.class);
                startActivity(intent2);
                break;
            case R.id.btWaveActivity:
                Intent intent = new Intent(MainActivity.this, WaveActivity.class);
                startActivity(intent);

                break;
            case R.id.btWaveActivity2:
                Intent intent4 = new Intent(MainActivity.this, WaveWithLargeDataActivity.class);
                startActivity(intent4);
                break;

            case R.id.btWaveActivity3:
                Intent intent5 = new Intent(MainActivity.this, MyWaveViewActivity1.class);
                startActivity(intent5);
                break;

        }
    }


}
