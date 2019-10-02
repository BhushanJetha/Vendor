package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.HomeActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.SplashActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.helpscreen.WelcomeActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification.MobileVerificationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etMobileNumber,etPassword;
    private TextView registartionLink, forgotPasswordLink;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });

        registartionLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MobileVerificationActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        });

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
}
