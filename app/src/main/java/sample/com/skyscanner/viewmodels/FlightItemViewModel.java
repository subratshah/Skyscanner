package sample.com.skyscanner.viewmodels;

import java.util.Comparator;

public class FlightItemViewModel {
    String date;
    String time;
    String direct;
    String price;
    String airline;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public static Comparator<FlightItemViewModel> PriceComparator = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());

    public static Comparator<FlightItemViewModel> DirectComparator = (o1, o2) -> o1.getDirect().compareTo(o2.getDirect());

    public static Comparator<FlightItemViewModel> TimeComparator = (o1, o2) -> o1.getTime().compareTo(o2.getTime());
}
