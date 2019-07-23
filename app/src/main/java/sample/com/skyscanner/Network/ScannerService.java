package sample.com.skyscanner.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import sample.com.skyscanner.Objects.Model;

public interface ScannerService {

    @Headers({"X-RapidAPI-Host: skyscanner-skyscanner-flight-search-v1.p.rapidapi.com",
            "X-RapidAPI-Key: 08aa8a2995msh3494129b67c7601p1d69bdjsn3599b96f027b"})

    @GET("/{country}/{currency}/{locale}/{origin}/{dest}/{date}")
    Call<Model> getQoutes(@Query("country") String country,
                          @Query("currency") String currency,
                          @Query("locale") String locale,
                          @Query("origin") String origin,
                          @Query("dest") String dest,
                          @Query("date") String date);
}
