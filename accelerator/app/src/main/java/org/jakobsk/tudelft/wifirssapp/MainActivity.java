package org.jakobsk.tudelft.wifirssapp;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button enableButton,disableButton, getMeasurementButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        enableButton=(Button)findViewById(R.id.button1);
        disableButton=(Button)findViewById(R.id.button2);
        getMeasurementButton = (Button) findViewById(R.id.stopButton);

        enableButton.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
            }
        });

        disableButton.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
            }
        });

        getMeasurementButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                int rssi = wifi.getConnectionInfo().getRssi();
                String ssid = wifi.getConnectionInfo().getSSID();
                int connectionInfo = wifi.getConnectionInfo().describeContents();
                TextView resultTextView = (TextView)findViewById(R.id.rssiText);
                resultTextView.setText("rssi value: " + Integer.toString(rssi)+" connection info: "
                        +Integer.toString(connectionInfo)+" ssid: "+ssid);
            }
        });



    }
}