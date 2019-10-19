package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.BaseActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.common.Constant;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.CommunicationChanel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.IResponse;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification.OTPVerificationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.RegisterAddressActivity;

public class RegistrationActivity extends BaseActivity implements IResponse{

    private Button btnRegistration;
    private TextView tvTermsAndCondition;
    private EditText etGarageName, etContactPersonName, etEmailId, etPancard, etGstNumber, etPassword, etConfirmPassword;
    private String strMobile, strGarageName, strContactPersonName, strEmailId, strPancard, strGstNumber, strPassword, strConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();
        onClick();

    }

    private void init(){

        try{
            etGarageName = (EditText)findViewById(R.id.etGarageName);
            etContactPersonName = (EditText)findViewById(R.id.etContactPersonName);
            etEmailId = (EditText)findViewById(R.id.etEmailId);
            etPancard = (EditText)findViewById(R.id.etPancard);
            etGstNumber = (EditText)findViewById(R.id.etGstNumber);
            etPassword = (EditText)findViewById(R.id.etPassword);
            etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);
            btnRegistration = (Button)findViewById(R.id.btnRegistration);

            Bundle bundle = getIntent().getExtras();
            strMobile = bundle.getString("mobile");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void onClick(){
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    JSONObject jsonObject=new JSONObject();

                    strGarageName = etGarageName.getText().toString();
                    strContactPersonName = etContactPersonName.getText().toString();
                    strEmailId = etEmailId.getText().toString();
                    strPancard = etPancard.getText().toString();
                    strGstNumber = etGstNumber.getText().toString();
                    strPassword = etPassword.getText().toString();
                    strConfirmPassword = etConfirmPassword.getText().toString();

                    if(strGarageName.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Garage Name !", Toast.LENGTH_LONG).show();
                    }else if(strContactPersonName.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Contact Person Name !", Toast.LENGTH_LONG).show();
                    }else if(strEmailId.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Email Id !", Toast.LENGTH_LONG).show();
                    }else if(strPancard.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Pancard Number !", Toast.LENGTH_LONG).show();
                    }else if(strGstNumber.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter GST Number !", Toast.LENGTH_LONG).show();
                    }else if(strPassword.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Password !", Toast.LENGTH_LONG).show();
                    }else if(strConfirmPassword.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Confirm Password !", Toast.LENGTH_LONG).show();
                    }else if(strPassword == strConfirmPassword){
                        Toast.makeText(getApplicationContext(), "Password And Confirm Password Not Matched !", Toast.LENGTH_LONG).show();
                    }
                    else {
                        jsonObject.put("contactPerson",strContactPersonName);
                        jsonObject.put("email",strEmailId);
                        jsonObject.put("password",strPassword);
                        jsonObject.put("garageName",strGarageName);
                        jsonObject.put("pancard",strPancard);
                        jsonObject.put("gstNumber",strGstNumber);
                        jsonObject.put("mobile",strMobile);

                        Log.d("Json-->",jsonObject.toString());
                        CommunicationChanel communicationChanel =new CommunicationChanel();
                        communicationChanel.communicateWithServer(RegistrationActivity.this,
                                Constant.POST, Constant.vendorPersonalDetail,jsonObject,"VendorRegistration");


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

            Intent i = new Intent(RegistrationActivity.this, RegisterAddressActivity.class);
            startActivity(i);
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
