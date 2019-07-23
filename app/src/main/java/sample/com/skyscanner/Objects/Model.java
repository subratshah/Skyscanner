package sample.com.skyscanner.Objects;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//-----------------------------------com.example.Example.java-----------------------------------

public class Model {

    @SerializedName("Quotes")
    private List<Quote> quotes = null;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("Quotes")
    public List<Quote> getQuotes() {
        return quotes;
    }

    @SerializedName("Quotes")
    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

//-----------------------------------com.example.sample.com.skyscanner.Objects.OutboundLeg.java-----------------------------------
class OutboundLeg {

    @SerializedName("CarrierIds")
    private List<Integer> carrierIds = null;
    @SerializedName("OriginId")
    private Integer originId;
    @SerializedName("DestinationId")
    private Integer destinationId;
    @SerializedName("DepartureDate")
    private String departureDate;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("CarrierIds")
    public List<Integer> getCarrierIds() {
        return carrierIds;
    }

    @SerializedName("CarrierIds")
    public void setCarrierIds(List<Integer> carrierIds) {
        this.carrierIds = carrierIds;
    }

    @SerializedName("OriginId")
    public Integer getOriginId() {
        return originId;
    }

    @SerializedName("OriginId")
    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    @SerializedName("DestinationId")
    public Integer getDestinationId() {
        return destinationId;
    }

    @SerializedName("DestinationId")
    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    @SerializedName("DepartureDate")
    public String getDepartureDate() {
        return departureDate;
    }

    @SerializedName("DepartureDate")
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
//-----------------------------------com.example.sample.com.skyscanner.Objects.Quote.java-----------------------------------

class Quote {

    @SerializedName("QuoteId")
    private Integer quoteId;
    @SerializedName("MinPrice")
    private Integer minPrice;
    @SerializedName("Direct")
    private Boolean direct;
    @SerializedName("sample.com.skyscanner.Objects.OutboundLeg")
    private OutboundLeg outboundLeg;
    @SerializedName("QuoteDateTime")
    private String quoteDateTime;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("QuoteId")
    public Integer getQuoteId() {
        return quoteId;
    }

    @SerializedName("QuoteId")
    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    @SerializedName("MinPrice")
    public Integer getMinPrice() {
        return minPrice;
    }

    @SerializedName("MinPrice")
    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    @SerializedName("Direct")
    public Boolean getDirect() {
        return direct;
    }

    @SerializedName("Direct")
    public void setDirect(Boolean direct) {
        this.direct = direct;
    }

    @SerializedName("sample.com.skyscanner.Objects.OutboundLeg")
    public OutboundLeg getOutboundLeg() {
        return outboundLeg;
    }

    @SerializedName("sample.com.skyscanner.Objects.OutboundLeg")
    public void setOutboundLeg(OutboundLeg outboundLeg) {
        this.outboundLeg = outboundLeg;
    }

    @SerializedName("QuoteDateTime")
    public String getQuoteDateTime() {
        return quoteDateTime;
    }

    @SerializedName("QuoteDateTime")
    public void setQuoteDateTime(String quoteDateTime) {
        this.quoteDateTime = quoteDateTime;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
