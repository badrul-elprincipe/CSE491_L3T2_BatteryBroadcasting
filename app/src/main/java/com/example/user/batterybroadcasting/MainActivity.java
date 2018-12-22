package com.example.user.batterybroadcasting;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    IntentFilter ifilter;
    Intent batteryStatus;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.button);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                batteryStatus = registerReceiver(null, ifilter);
                // Are we charging / charged?
                int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

                if(status==BatteryManager.BATTERY_STATUS_CHARGING ){
                    String s="charging";
                    Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                }
                else{
                    String t="not charging";
                    Toast.makeText(MainActivity.this,t,Toast.LENGTH_LONG).show();
                }
            }
        });
    }


// How are we charging?
//        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
//        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
//        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

}
