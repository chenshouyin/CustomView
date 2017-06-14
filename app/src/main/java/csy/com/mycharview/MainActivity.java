package csy.com.mycharview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import csy.com.mycharview.base.BaseActivity;
import csy.com.mycharview.waveformline.WaveActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{


    @BindView(R.id.btWaveActivity)
    Button btWaveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addAction();
    }

    @Override
    public void addAction() {
        btWaveActivity.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btWaveActivity :
                Intent intent = new Intent(MainActivity.this, WaveActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
