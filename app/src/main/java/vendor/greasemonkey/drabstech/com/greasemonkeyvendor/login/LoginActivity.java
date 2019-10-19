package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.DashobardActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.HomeActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.SplashActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.common.Constant;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.CommunicationChanel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.IResponse;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.helpscreen.WelcomeActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification.MobileVerificationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification.OTPVerificationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity implements IResponse {

    private EditText etMobileNumber,etPassword;
    private String strMobileNumber, strPassword;
    private TextView registartionLink, forgotPasswordLink;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        onClick();



        forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.forgot_password_dialog, null);
                //final EditText etUsername = alertLayout.findViewById(R.id.et_username);
                final EditText etEmail = alertLayout.findViewById(R.id.et_email);
                //final CheckBox cbToggle = alertLayout.findViewById(R.id.cb_show_pass);

                AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                alert.setTitle("Info");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(false);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // String user = etUsername.getText().toString();
                        String pass = etEmail.getText().toString();
                        Toast.makeText(getBaseContext(),  " Email: " + pass, Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
    }

    private void init(){
        etMobileNumber = (EditText) findViewById(R.id.etMobileNumber);
        etPassword = (EditText) findViewById(R.id.etPassword);
        registartionLink = (TextView) findViewById(R.id.registrationLink);
        forgotPasswordLink = (TextView) findViewById(R.id.forgotPasswordLink);
        btnLogin = (Button) findViewById(R.id.loginBtn);
    }

    private void onClick(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    JSONObject jsonObject=new JSONObject();

                    strMobileNumber = etMobileNumber.getText().toString();
                    strPassword = etPassword.getText().toString();

                    if(strMobileNumber.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Register Mobile Number !", Toast.LENGTH_LONG).show();
                    }else if(strPassword.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Your Password !", Toast.LENGTH_LONG).show();
                    }else {
                        jsonObject.put("mobile",strMobileNumber);
                        jsonObject.put("password",strPassword);

                    Log.d("Json-->",jsonObject.toString());
                    CommunicationChanel communicationChanel =new CommunicationChanel();
                    communicationChanel.communicateWithServer(LoginActivity.this,
                    Constant.POST, Constant.loginAPI,jsonObject,"Login");

                  /*  Intent i = new Intent(LoginActivity.this, DashobardActivity.class);
                    startActivity(i);
                    finish();*/
                }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        registartionLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MobileVerificationActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onRequestComplete(JSONObject jsonObject, String entity) {
        try {

            String response = jsonObject.getString("message");
            Log.d("Response ##-->",response);
            if(response.equals("Vendor Not Found.")){
               Toast.makeText(getApplicationContext(),"Please register first!",Toast.LENGTH_LONG).show();
            }else {
                Intent i = new Intent(LoginActivity.this, DashobardActivity.class);
                startActivity(i);
                finish();
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
