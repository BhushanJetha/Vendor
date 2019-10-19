package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by bhushan on 20/12/16.
 */

public class UserPrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    String isPasswordChange;

    public String userType,accessibility;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "GreaseMonkey";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public UserPrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void saveUserNamePassword(String emailId, String password) {
        editor.putString("EmailId", emailId);
        editor.putString("Password", password);
        editor.commit();
    }

    public String getPassword(){
        return pref.getString("Password", "");
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void saveUserDetail(String jsonObject) {
        editor.putString("UserDetail", String.valueOf(jsonObject));
        editor.commit();
    }

    public String getUserDetail(){
        return pref.getString("UserDetail", "");
    }

    public void setUserProfile(){
        try{
            String strUser=getUserDetail();
            Log.d("User ID-->",strUser);

            JSONArray jsonArray=new JSONArray(strUser);
            JSONObject jsonObject=jsonArray.getJSONObject(0);
            String userId=jsonObject.getString("userId");
            setUserId(userId);
            String fullname=jsonObject.getString("fullname");
            setFullName(fullname);
            String mobilenumber=jsonObject.getString("mobilenumber");
            setMobileNumber(mobilenumber);
            String emailid=jsonObject.getString("emailid");
            setEmailId(emailid);
            String companyname=jsonObject.getString("companyname");
            setCompanyName(companyname);
            String city=jsonObject.getString("city");
            setCity(city);
            String addressline1=jsonObject.getString("addressline1");
            setAddressLine1(addressline1);
            String addressline2=jsonObject.getString("addressline2");
            setAddressLine2(addressline2);
            String userPasswordtype=jsonObject.getString("password_type");
            setUserPasswordType(userPasswordtype);

            String userType=jsonObject.getString("user_type");
            setUserType(userType);

            String accessibility=jsonObject.getString("accessiblevalue");
            setAccessibility(accessibility);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getUserId() {
        return pref.getString("userId", "");
    }

    public void setUserId(String userId) {
        editor.putString("userId",userId);
        editor.commit();
    }

    public String getFullName() {
        return pref.getString("fullName", "");
    }

    public void setFullName(String fullName) {
        editor.putString("fullName",fullName);
        editor.commit();
    }

    public String getMobileNumber() {
        return pref.getString("mobileNumber", "");
    }

    public void setMobileNumber(String mobileNumber) {
        editor.putString("mobileNumber",mobileNumber);
        editor.commit();
    }

    public String getEmailId(){
        return pref.getString("emailId", "");
    }

    public void setEmailId(String emailId) {
        editor.putString("emailId",emailId);
        editor.commit();
    }

    public String getCompanyName() {
        return pref.getString("companyName", "");
    }

    public void setCompanyName(String companyName) {
        editor.putString("companyName",companyName);
        editor.commit();
    }

    public String getCity() {
        return pref.getString("city", "");
    }

    public void setCity(String city) {
        editor.putString("city",city);
        editor.commit();
    }

    public String getAddressLine1() {
        return  pref.getString("addressLine1", "");
    }

    public void setAddressLine1(String addressLine1) {
        editor.putString("addressLine1",addressLine1);
        editor.commit();
    }

    public String getAddressLine2() {
        return  pref.getString("addressLine2", "");
    }

    public void setAddressLine2(String addressLine2) {
        editor.putString("addressLine2",addressLine2);
        editor.commit();
    }

    public String getUserPasswordType() {
        return  pref.getString("userPasswordType", "");
    }

    public void setUserPasswordType(String userType) {
        editor.putString("userPasswordType",userType);
        editor.commit();
    }

    public String getIsPasswordChange() {
        return pref.getString("changePassword", "");
    }

    public void setIsPasswordChange(String isPasswordChange) {
        this.isPasswordChange = isPasswordChange;
        editor.putString("changePassword", isPasswordChange);
        editor.commit();
    }


    public String getUserType() {
        return pref.getString("userType", "");
    }

    public void setUserType(String userType) {
        editor.putString("userType", userType);
        editor.commit();
    }

    public String getAccessibility() {
        return pref.getString("accessibility", "");
    }

    public void setAccessibility(String accessibility) {
        editor.putString("accessibility", accessibility);
        editor.commit();
    }
}
