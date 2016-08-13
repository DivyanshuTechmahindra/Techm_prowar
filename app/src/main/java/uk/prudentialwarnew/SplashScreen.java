package uk.prudentialwarnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import uk.prudentialwarnew.CalendarExmp.CalandarSample;

/**
 * Created by user on 8/12/2016.
 */
public class SplashScreen extends Activity {
    Shimmer shimmer;
    ShimmerTextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splashscreen);


        Thread timerThread = new Thread() {
            public void run() {
                try {

                    sleep(5000);
                    // Test for commit

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, Dashboard.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();

    }

}
