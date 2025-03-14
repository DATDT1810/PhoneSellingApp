package fpt.edu.vn.tingstoreapp.networking.product;

import io.reactivex.Observable;

import java.util.ArrayList;

import fpt.edu.vn.tingstoreapp.models.Product;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductService {
    @GET("GetProductByBrand/phone")
    Observable<ArrayList<Product>> getProducts();

    @GET("GetProductById/{id}")
    Observable<Product> getProductById(@Path("id") String id);
}
