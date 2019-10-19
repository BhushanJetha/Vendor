package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.common;

/**
 * Created by dell on 12/13/2017.
 */
public class Constant {
    public static final int GET=0;
    public static final int POST=1;

    public static final String strHost="http://157.245.99.66:9000/";

    public static final String loginAPI=strHost+"api/vendorLogin";

    public static final String mobileRegistrationAPI = strHost+"api/mobileVerification";

    public static final String otpValidationAPI=strHost+"api/otpVerification";

    public static final String vendorPersonalDetail=strHost+"api/vendorPersonalDetail";

    public static final String garageAddressDetail=strHost+"api/garageAddressDetail";

    public static final String stateAPI=strHost+"masters/state";

    public static final String cityAPI=strHost+"masters/city";

    public static final String servicesListAPI=strHost+"masters/serviceList";

    public static final String manufacturerAPI=strHost+"masters/manufacture";

    public static final String registerServicesAPI=strHost+"api/providedServices";

    public static final String registerManufacturereAPI=strHost+"api/providedServices";

    public static final String strCreateUser=strHost+"createUser.php ";

    public static final String strEngineerActivity=strHost+"create_engineer_activity.php ";

    public static final String strEngineerActivityHistory=strHost+"engineer_activity_history.php ";

    public static final String strGetEnginnerList=strHost+"getEngineerList.php";

    public static final String strGetPrincipalList=strHost+"getPrincipalList.php ";

    public static final String strAllHistoryOfEngineer=strHost+"allHistoryOfEngineer.php ";
}
