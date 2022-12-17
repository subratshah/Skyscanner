
package sample.com.skyscanner.model;

import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("PlaceId")

    private int placeId;

    @SerializedName("IataCode")
    private String iataCode;

    @SerializedName("Name")
    private String name;

    @SerializedName("Type")
    private String type;

    @SerializedName("SkyscannerCode")
    private String skyscannerCode;

    @SerializedName("CityName")
    private String cityName;

    @SerializedName("CityId")
    private String cityId;

    @SerializedName("CountryName")
    private String countryName;

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSkyscannerCode() {
        return skyscannerCode;
    }

    public void setSkyscannerCode(String skyscannerCode) {
        this.skyscannerCode = skyscannerCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
