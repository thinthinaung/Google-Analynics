package com.example.user.analyticsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {


    private Tracker mTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       DemoApp application = (DemoApp) getApplication();
        mTracker = application.getDefaultTracker();
        // starts a new session and notification to google analytics
        mTracker.send(new HitBuilders.ScreenViewBuilder()
                .setNewSession()
                .build());
    }

    /**
     * Function is called when activity comes to running state
     */
    @Override
    protected void onResume() {
        super.onResume();

        // sets screen name and send it to google analytics
        mTracker.setScreenName("Main Activity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mTracker.setScreenName("Main Activity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    /**
     * Function to generate a click event and send Event to Google Analytics
     * @param v View
     */
    public void clickEvent(View v){

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Click")
                .build());

        Toast.makeText(this, "Button is Clicked", Toast.LENGTH_SHORT).show();
    }


    /**
     * Function to send Execption or Crash reports to Google Analytics
     * @param v View
     */
    public void GenerateException(View v){

        mTracker.send(new HitBuilders.ExceptionBuilder()
                .setDescription("Sample")
                .setFatal(true)
                .build());

        Toast.makeText(this, "Exception event send", Toast.LENGTH_SHORT).show();
    }

}
