package com.example.ashad.automaticrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import hotchemi.android.rate.AppRate;
import hotchemi.android.rate.OnClickButtonListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        try{
            AppRate.with(MainActivity.this)
                    .setInstallDays(0) // default 10, 0 means install day.
                    .setLaunchTimes(5) // default 10
                    .setRemindInterval(2) // default 1
                    .setShowLaterButton(true) // default true
                    .setDebug(true) // default false
                    .setOnClickButtonListener(new OnClickButtonListener() { // callback listener.
                        @Override
                        public void onClickButton(int which) {
//                            Log.d(MainActivity.class.getName(), Integer.toString(which));
                        }
                    });

            // Show a dialog if meets conditions
            AppRate.showRateDialogIfMeetsConditions(MainActivity.this);
        }catch (Exception e){
            Log.i("PlayStore Exception", e.toString());
            Toast.makeText(MainActivity.this, "Error Opening PlayStore!", Toast.LENGTH_SHORT).show();
        }

    }
}
