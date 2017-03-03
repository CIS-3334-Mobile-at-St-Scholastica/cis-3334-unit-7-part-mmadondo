package css.cis3334.heartratetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Tom Gibbons in Feb 2017.
 * Revised by Malvern Madondo and Evan Mumbleau
 * For the CIS 3334 class at St. Scholastica
 */

public class MainActivity extends AppCompatActivity {

    ListView lvHeartRates;
    TextView tvSelect;
    HeartRateList heartRateList;
    ArrayAdapter<HeartRate> hrAdapter;

    //ArrayList<HeartRate> basicheartRateList;

    // constant to determine which sub-activity returns
   // private static final int HR_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // call the super class onCreate to complete the creation of activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelect = (TextView) findViewById(R.id.textViewSelect);
        lvHeartRates = (ListView) findViewById(R.id.listViewHeartRates);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        //ArrayAdapter<HeartRate> planetAdapter = new ArrayAdapter<HeartRate>(this, android.R.layout.simple_list_item_1, basicheartRateList);
        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewPulse, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);

        lvHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
              //  tvSelect.setText("You selected: " + hr.toString());

                Double pulse = Double.parseDouble(hr.getPulse().toString());
                String range = hr.getRange().toString();

                //when the user selects a heartrate from the list, starts new activity using an intent
                Intent newIntent = new Intent(MainActivity.this, Main2Activity.class);

                //passing selected heart rate obkect from main to the new activity
                newIntent.putExtra("Pulse", pulse);
                newIntent.putExtra("Range", range);

                //startActivityForResult(secActIntent, HR_REQUEST_CODE);
                startActivity(newIntent);

            }
        });

    }

}
