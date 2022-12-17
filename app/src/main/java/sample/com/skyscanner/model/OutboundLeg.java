
package sample.com.skyscanner.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OutboundLeg {

    @SerializedName("CarrierIds")
    private List<String> carrierIds = null;

    @SerializedName("OriginId")
    private String originId;

    @SerializedName("DestinationId")
    private String destinationId;

    @SerializedName("DepartureDate")
    private String departureDate;

    public List<String> getCarrierIds() {
        return carrierIds;
    }

    public void setCarrierIds(List<String> carrierIds) {
        this.carrierIds = carrierIds;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

}
