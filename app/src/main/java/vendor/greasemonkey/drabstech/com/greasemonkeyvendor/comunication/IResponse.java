package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.comunication;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by dell on 12/14/2017.
 */
public interface IResponse {

    void onRequestComplete(JSONObject jsonObject, String entity);
}
