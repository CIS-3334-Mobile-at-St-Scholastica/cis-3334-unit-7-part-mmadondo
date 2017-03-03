package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView tvHeartRate, tvPulse, tvRange;
    String strPulse, strRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvHeartRate = (TextView) findViewById(R.id.textViewHeartRate);
        tvPulse = (TextView) findViewById(R.id.textViewPulse);
        tvRange = (TextView) findViewById(R.id.textViewRange);

        Bundle extras = getIntent().getExtras();

        strPulse = extras.getSerializable("Pulse").toString();
        strRange = extras.getSerializable("range").toString();

       // HeartRate hr =(HeartRate) extras.getSerializable("HeartRate");
       // tvHeartRate.setText(hr.toString());

        tvPulse.setText("Pulse:" + strPulse);
        tvRange.setText("Range:" + strRange);



    }
}
