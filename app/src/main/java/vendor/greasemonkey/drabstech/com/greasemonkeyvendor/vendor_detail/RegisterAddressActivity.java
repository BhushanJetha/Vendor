package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.BaseActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.common.Constant;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.CommunicationChanel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication.IResponse;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.mobileVerification.OTPVerificationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.registration.RegistrationActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.model.CityMaster;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.vendor_detail.model.StateMaster;

public class RegisterAddressActivity extends BaseActivity implements IResponse{

    private EditText etLandmark,etAddressLine1, etAddressLine2, etPincode;
    private Spinner spinnerState,spinnerCity;
    private Button btnNext;

    private String strStateId,strCityId,strLandmark,strAddressLine1,strAddressLine2,strPincode;
    private ArrayList<StateMaster> stateList;
    private ArrayList<CityMaster> cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_address_address);

        init();
        onClick();
        getState();
    }

    private void init(){
        spinnerState = (Spinner) findViewById(R.id.spinnerState);
        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);

        etLandmark = (EditText) findViewById(R.id.etLandmark);
        etAddressLine1 = (EditText) findViewById(R.id.etAddressLine1);
        etAddressLine2 = (EditText) findViewById(R.id.etAddressLine2);
        etPincode = (EditText) findViewById(R.id.etPincode);

        btnNext = (Button)findViewById(R.id.btnNext);

        stateList = new ArrayList<>();
        cityList = new ArrayList<>();

    }

    private void onClick(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    JSONObject jsonObject=new JSONObject();
                    strLandmark = etLandmark.getText().toString();
                    strAddressLine1 = etAddressLine1.getText().toString();
                    strAddressLine2 = etAddressLine2.getText().toString();
                    strPincode = etPincode.getText().toString();

                    if(strStateId.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Select State !", Toast.LENGTH_LONG).show();
                    }else  if(strCityId.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Select City !", Toast.LENGTH_LONG).show();
                    }else  if(strLandmark.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Landmark !", Toast.LENGTH_LONG).show();
                    }else  if(strAddressLine1.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Address Line1 !", Toast.LENGTH_LONG).show();
                    }else  if(strAddressLine2.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Address Line2 !", Toast.LENGTH_LONG).show();
                    }else  if(strPincode.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please Enter Pincode !", Toast.LENGTH_LONG).show();
                    }else  if(strPincode.length() != 6){
                        Toast.makeText(getApplicationContext(), "Please Enter 6 Digit Pincode !", Toast.LENGTH_LONG).show();
                    }
                    else {

                        jsonObject.put("vendorId","1");
                        jsonObject.put("addressLine1",strAddressLine1);
                        jsonObject.put("addressLine2",strAddressLine2);
                        jsonObject.put("landmark",strLandmark);
                        jsonObject.put("pincode",strPincode);
                        jsonObject.put("stateId",strStateId);
                        jsonObject.put("cityId",strCityId);
                        jsonObject.put("longitude","12.6789999");
                        jsonObject.put("latitude","13.567878");

                        Log.d("Json-->",jsonObject.toString());
                        CommunicationChanel communicationChanel =new CommunicationChanel();
                        communicationChanel.communicateWithServer(RegisterAddressActivity.this,
                                Constant.POST, Constant.garageAddressDetail,jsonObject,"AddressDetail");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                StateMaster stateMaster = stateList.get(position);
                //strStateId = parent.getItemAtPosition(position).toString();
                strStateId = stateMaster.getStateId();
                getCity(stateMaster.getStateId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                //strCityId = parent.getItemAtPosition(position).toString();

                CityMaster cityMaster = cityList.get(position);
                strCityId = cityMaster.getCityId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void getState(){
        CommunicationChanel communicationChanel =new CommunicationChanel();
        communicationChanel.communicateWithServer(RegisterAddressActivity.this,
                Constant.GET, Constant.stateAPI,null,"state");
    }

    private void getCity(){
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("stateId","1");
        }catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        CommunicationChanel communicationChanel =new CommunicationChanel();
        communicationChanel.communicateWithServer(RegisterAddressActivity.this,
                Constant.POST, Constant.cityAPI,jsonObject,"city");
    }

    private void getCity(String stateId){

        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put("stateId",stateId);
        }catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        CommunicationChanel communicationChanel =new CommunicationChanel();
        communicationChanel.communicateWithServer(RegisterAddressActivity.this,
                Constant.POST, Constant.cityAPI,jsonObject,"city");
    }

    @Override
    public void onRequestComplete(JSONObject jsonObject, String entity) {
        try {
            Log.d("State Response-->",jsonObject.toString());

            if(entity.equals("state")){
                String response = jsonObject.getString("data");
                Log.d("Response ##-->",response);


                JSONArray jsonArray=new JSONArray(response);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject userDetail= (JSONObject) jsonArray.get(i);
                    String stateId=userDetail.getString("stateId");
                    String stateName=userDetail.getString("stateName");

                    StateMaster stateMaster=new StateMaster(stateId,stateName);
                    stateList.add(stateMaster);
                }

                ArrayAdapter<StateMaster> stateAdapter = new ArrayAdapter<StateMaster>(this, android.R.layout.simple_spinner_item, stateList);
                stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerState.setAdapter(stateAdapter);
                spinnerState.setSelection(stateAdapter.getPosition(stateList.get(0)));
                getCity();
            }else if(entity.equals("city")){
                String response = jsonObject.getString("data");
                Log.d("Response ##-->",response);

                cityList.clear();
                JSONArray jsonArray=new JSONArray(response);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject cityDetail= (JSONObject) jsonArray.get(i);
                    String stateId=cityDetail.getString("stateId");
                    String cityId=cityDetail.getString("cityId");
                    String cityName=cityDetail.getString("cityName");

                    CityMaster cityMaster=new CityMaster(stateId,cityId,cityName);
                    cityList.add(cityMaster);
                }

                ArrayAdapter<CityMaster> stateAdapter = new ArrayAdapter<CityMaster>(this, android.R.layout.simple_spinner_item, cityList);
                stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCity.setAdapter(stateAdapter);
                spinnerCity.setSelection(stateAdapter.getPosition(cityList.get(0)));
            }else if(entity.equals("AddressDetail")) {
                String response = jsonObject.getString("message");
                if (response.equals("Address saved successfully")) {
                    Intent i = new Intent(RegisterAddressActivity.this, ServiceDetailActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"Something went wrong, Please try again !",Toast.LENGTH_LONG).show();
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
