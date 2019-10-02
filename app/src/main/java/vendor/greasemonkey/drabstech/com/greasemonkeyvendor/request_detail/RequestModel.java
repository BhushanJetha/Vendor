package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail;

/**
 * Created by dell on 9/29/2019.
 */

public class RequestModel {
    private String name,date,serviceType,amcType,status;

    public RequestModel(String name, String date, String serviceType, String amcType, String status) {
        this.name = name;
        this.date = date;
        this.serviceType = serviceType;
        this.amcType = amcType;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
