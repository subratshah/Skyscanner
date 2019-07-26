package sample.com.skyscanner.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import sample.com.skyscanner.model.BaseModel;

public interface ScannerService {

    @Headers("X-RapidAPI-Host: skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")

    @GET("browsequotes/v1.0//{country}/{currency}/en-US/{origin}/{dest}/{date}")
    Observable<BaseModel> getQuotes(@Path("country") String country,
                                    @Path("currency") String currency,
                                    @Path("origin") String origin,
                                    @Path("dest") String dest,
                                    @Path("date") String date,
                                    @Query("inDate") String inDate);

    @GET("browseroutes/v1.0//{country}/{currency}/en-US/{origin}/{dest}/{date}")
    Observable<BaseModel> getRoutes(@Path("country") String country,
                                    @Path("currency") String currency,
                                    @Path("origin") String origin,
                                    @Path("dest") String dest,
                                    @Path("date") String date,
                                    @Query("inDate") String inDate);
}
