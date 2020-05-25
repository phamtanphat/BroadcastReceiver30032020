package com.example.broastcasereceiver30032020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Cach 1 : Dang ky nhan broadcast theo vong doi activity
        IntentFilter intent = new IntentFilter();
        intent.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(broadcastReceiver, intent);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null){
                if (networkInfo.isConnected() && networkInfo.isAvailable()) {
                    if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                        Toast.makeText(context, "Da ket noi wifi", Toast.LENGTH_SHORT).show();
                    }
                    if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                        Toast.makeText(context, "Da ket noi 3g", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    };

}
