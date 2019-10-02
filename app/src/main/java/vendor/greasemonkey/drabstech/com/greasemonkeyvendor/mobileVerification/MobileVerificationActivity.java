package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration.RegistrationActivity;

public class MobileVerificationActivity extends AppCompatActivity {

    private Button btnGetOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);

        btnGetOTP =(Button)findViewById(R.id.btnGetOTP);

        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MobileVerificationActivity.this, OTPVerificationActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });
    }
}
