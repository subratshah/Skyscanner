
package sample.com.skyscanner.model;

import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("QuoteId")
    private int quoteId;

    @SerializedName("MinPrice")
    private String minPrice;

    @SerializedName("Direct")
    private Boolean direct;

    @SerializedName("OutboundLeg")
    private OutboundLeg outboundLeg;

    @SerializedName("QuoteDateTime")
    private String quoteDateTime;

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public Boolean getDirect() {
        return direct;
    }

    public void setDirect(Boolean direct) {
        this.direct = direct;
    }

    public OutboundLeg getOutboundLeg() {
        return outboundLeg;
    }

    public void setOutboundLeg(OutboundLeg outboundLeg) {
        this.outboundLeg = outboundLeg;
    }

    public String getQuoteDateTime() {
        return quoteDateTime;
    }

    public void setQuoteDateTime(String quoteDateTime) {
        this.quoteDateTime = quoteDateTime;
    }

}
