package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.BaseActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification.OTPVerificationActivity;

public class RegisterAddressActivity extends BaseActivity {

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_address_address);

        btnNext = (Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterAddressActivity.this,  ServiceDetailActivity.class);
                startActivity(i);

            }
        });
    }
}
