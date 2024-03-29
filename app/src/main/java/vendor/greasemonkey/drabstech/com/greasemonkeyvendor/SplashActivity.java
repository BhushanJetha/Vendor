package vendor.greasemonkey.drabstech.com.greasemonkeyvendor;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.helpscreen.WelcomeActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.login.LoginActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.BikeListActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.RegisterAddressActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.ServiceDetailActivity;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
