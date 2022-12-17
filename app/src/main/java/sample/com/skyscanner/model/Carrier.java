
package sample.com.skyscanner.model;

import com.google.gson.annotations.SerializedName;

public class Carrier {

    @SerializedName("CarrierId")
    private int carrierId;

    @SerializedName("Name")
    private String name;

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
