package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.BaseActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.common.Constant;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.CommunicationChanel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.IResponse;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration.RegistrationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.RegisterAddressActivity;

public class OTPVerificationActivity extends BaseActivity implements IResponse {

    private Button btnVerify;
    private EditText etOTP;
    private String strOTP, strMobileNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        init();
        onClick();
    }

    private void init(){
        try {
            etOTP = (EditText) findViewById(R.id.etOTP);
            btnVerify = (Button) findViewById(R.id.btnVerify);

            Bundle bundle = getIntent().getExtras();
            strMobileNumber = bundle.getString("mobile");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void onClick(){

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    JSONObject jsonObject=new JSONObject();
                    strOTP = etOTP.getText().toString();

                    if(strOTP.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter OTP !", Toast.LENGTH_LONG).show();
                    }else if(strOTP.length() != 4){
                        Toast.makeText(getApplicationContext(), "Please 4 Digit OTP !", Toast.LENGTH_LONG).show();
                    }else {
                        jsonObject.put("mobile",strMobileNumber);
                        jsonObject.put("otp",strOTP);
                        Log.d("Json-->",jsonObject.toString());

                        CommunicationChanel communicationChanel =new CommunicationChanel();
                        communicationChanel.communicateWithServer(OTPVerificationActivity.this,
                                Constant.POST, Constant.otpValidationAPI,jsonObject,"OTPVerification");

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onRequestComplete(JSONObject jsonObject, String entity) {
        try {
            Log.d("Mobile Reg Response-->",jsonObject.toString());
            String response = jsonObject.getString("message");
            Log.d("Response ##-->",response);

            Intent i = new Intent(OTPVerificationActivity.this,  RegistrationActivity.class);
            i.putExtra("mobile",strMobileNumber);
            startActivity(i);
           /* if(response=="otp sent to your mobile number"){
                Intent i = new Intent(OTPVerificationActivity.this,  RegistrationActivity.class);
                i.putExtra("mobile",strMobileNumber);
                startActivity(i);
            }*/
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
