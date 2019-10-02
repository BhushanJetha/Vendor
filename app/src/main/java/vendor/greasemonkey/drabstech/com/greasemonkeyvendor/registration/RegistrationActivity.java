package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.login.LoginActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification.OTPVerificationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.RegisterAddressActivity;

public class RegistrationActivity extends AppCompatActivity {

    private Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegistration = (Button)findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrationActivity.this, RegisterAddressActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });
    }
}
