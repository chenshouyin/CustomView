package csy.com.mycharview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.btLineChartActivityMore)
    Button btLineChartActivityMore;
    @BindView(R.id.btLineChartActivityOne)
    Button btLineChartActivityOne;
    @BindView(R.id.btLineChartActivityDynamic)
    Button btLineChartActivityDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        btLineChartActivityMore.setOnClickListener(this);
        btLineChartActivityOne.setOnClickListener(this);
        btLineChartActivityDynamic.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view==btLineChartActivityMore){
            Intent intent = new Intent(MainActivity.this,LineChartActivityMore.class);
            startActivity(intent);
        }else if (view==btLineChartActivityOne){
            Intent intent = new Intent(MainActivity.this,LineChartActivityOne.class);
            startActivity(intent);
        }else if (view == btLineChartActivityDynamic){
            Intent intent = new Intent(MainActivity.this,LineChartActivityDynamic.class);
            startActivity(intent);
        }
    }
}
