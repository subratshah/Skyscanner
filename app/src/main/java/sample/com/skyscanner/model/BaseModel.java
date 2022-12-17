
package sample.com.skyscanner.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseModel {

    @SerializedName("Quotes")
    private List<Quote> quotes;

    @SerializedName("Places")
    private List<Place> places;

    @SerializedName("Carriers")
    private List<Carrier> carriers;

    @SerializedName("Currencies")
    private List<Currency> currencies;

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

}
