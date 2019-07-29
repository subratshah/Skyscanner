package sample.com.skyscanner.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import sample.com.skyscanner.model.BaseModel;

public interface ScannerService {

    @Headers("X-RapidAPI-Host: skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")

    @GET("browsequotes/v1.0/US/{currency}/en-US/{origin}/{dest}/{outDate}")
    Observable<BaseModel> getQuotes(@Path("currency") String currency,
                                    @Path("origin") String origin,
                                    @Path("dest") String dest,
                                    @Path("outDate") String outDate);

    @GET("browseroutes/v1.0/US/{currency}/en-US/{origin}/{dest}/{outDate}")
    Observable<BaseModel> getRoutes(@Path("currency") String currency,
                                    @Path("origin") String origin,
                                    @Path("dest") String dest,
                                    @Path("outDate") String outDate);
}
