package sample.com.skyscanner.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import sample.com.skyscanner.Model;

public interface WeatherService {

    @Headers({"X-RapidAPI-Host: skyscanner-skyscanner-flight-search-v1.p.rapidapi.com",
            "X-RapidAPI-Key: 08aa8a2995msh3494129b67c7601p1d69bdjsn3599b96f027b"})

    @GET("/weather")
    Call<Model> getWeather(@Query("units") String unit,
                           @Query("q") String location);
}
