package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.notification;

/**
 * Created by dell on 10/5/2019.
 */

public class NotificationModel {
    private String userName, serviceType, amcType, date;

    public NotificationModel(String userName, String serviceType, String amcType, String date) {
        this.userName = userName;
        this.serviceType = serviceType;
        this.amcType = amcType;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAmcType() {
        return amcType;
    }

    public void setAmcType(String amcType) {
        this.amcType = amcType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
