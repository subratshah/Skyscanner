
package sample.com.skyscanner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OutboundLeg {

    @SerializedName("CarrierIds")
    @Expose
    private List<Integer> carrierIds = null;
    @SerializedName("OriginId")
    @Expose
    private Integer originId;
    @SerializedName("DestinationId")
    @Expose
    private Integer destinationId;
    @SerializedName("DepartureDate")
    @Expose
    private String departureDate;

    public List<Integer> getCarrierIds() {
        return carrierIds;
    }

    public void setCarrierIds(List<Integer> carrierIds) {
        this.carrierIds = carrierIds;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

}
