package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.RegisterAddressActivity;

public class OTPVerificationActivity extends AppCompatActivity {

    private Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        btnVerify = (Button)findViewById(R.id.btnVerify);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OTPVerificationActivity.this,  RegisterAddressActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });
    }
}
