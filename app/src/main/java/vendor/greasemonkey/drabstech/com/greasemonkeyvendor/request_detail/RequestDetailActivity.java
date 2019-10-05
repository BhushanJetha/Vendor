package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.BaseActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;

public class RequestDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail2);

        setToolbar();
        setBackArrow(true);
        setTitle("Request Detail");
    }
}
