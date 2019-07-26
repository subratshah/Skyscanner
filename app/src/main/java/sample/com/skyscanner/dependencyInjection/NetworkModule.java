package sample.com.skyscanner.dependencyInjection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sample.com.skyscanner.network.ScannerService;

@Module
public class NetworkModule {
    private static final String BASE_URL = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/";

    @Singleton
    @Provides
    ScannerService providesRetrofitInstance() {

        Interceptor headerInterceptor = chain -> {
            Request request = chain.request();
            Headers headers = request.headers()
                    .newBuilder()
                    .add("X-RapidAPI-Key", "08aa8a2995msh3494129b67c7601p1d69bdjsn3599b96f027b")
                    .build();
            request = request.newBuilder().headers(headers).build();
            return chain.proceed(request);
        };

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .build();

        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ScannerService.class);
    }
}
