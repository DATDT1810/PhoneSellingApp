package fpt.edu.vn.tingstoreapp.networking.product;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductRetrofitClient {
    private final String BASE_URL = "http://172.25.240.1:5001/apigateway/product/";
    private Retrofit retrofit;

    public ProductService getProductApiService() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }
        return retrofit.create(ProductService.class);
    }
}
