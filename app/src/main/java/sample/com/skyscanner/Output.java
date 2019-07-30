package sample.com.skyscanner;

import java.util.Comparator;

public class Output {
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

    public static Comparator<Output> PriceComparator = new Comparator<Output>() {

        @Override
        public int compare(Output o1, Output o2) {
            return o1.getPrice().compareTo(o2.getPrice());
        }
    };
    public static Comparator<Output> DirectComparator = new Comparator<Output>() {

        @Override
        public int compare(Output o1, Output o2) {
            return o1.getDirect().compareTo(o2.getDirect());
        }
    };
}
