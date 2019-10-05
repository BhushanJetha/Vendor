package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.servicing_request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.BaseActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;

public class RequestStatusActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_detail);

        setToolbar();
        setBackArrow(true);
        setTitle("Request Status");
    }
}
