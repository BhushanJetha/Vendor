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
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.login.LoginActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration.RegistrationActivity;

public class MobileVerificationActivity extends BaseActivity implements IResponse {

    private Button btnGetOTP;
    private EditText etMobileNumber;
    private String strMobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);

        init();
        onClick();
    }

    private void init(){
        try{
            etMobileNumber = (EditText)findViewById(R.id.etMobileNumber);
            btnGetOTP =(Button)findViewById(R.id.btnGetOTP);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void onClick(){

        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    JSONObject jsonObject=new JSONObject();
                    strMobileNumber = etMobileNumber.getText().toString();

                    if(strMobileNumber.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Mobile Number !", Toast.LENGTH_LONG).show();
                    }else if(strMobileNumber.length() != 10){
                        Toast.makeText(getApplicationContext(), "Please 10 Digit Mobile Number !", Toast.LENGTH_LONG).show();
                    }else {
                        jsonObject.put("mobile",strMobileNumber);

                        Log.d("Json-->",jsonObject.toString());
                        CommunicationChanel communicationChanel =new CommunicationChanel();
                        communicationChanel.communicateWithServer(MobileVerificationActivity.this,
                                Constant.POST, Constant.mobileRegistrationAPI,jsonObject,"MobileRegistration");
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
            if(response.equals("otp sent to your mobile number")){
                  Intent i = new Intent(MobileVerificationActivity.this, OTPVerificationActivity.class);
                  i.putExtra("mobile",strMobileNumber);
                  startActivity(i);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
