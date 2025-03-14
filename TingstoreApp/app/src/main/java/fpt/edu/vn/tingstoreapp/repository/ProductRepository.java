package fpt.edu.vn.tingstoreapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import fpt.edu.vn.tingstoreapp.models.Image;
import fpt.edu.vn.tingstoreapp.models.Product;
import fpt.edu.vn.tingstoreapp.networking.product.ProductRetrofitClient;
import fpt.edu.vn.tingstoreapp.networking.product.ProductService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProductRepository {
    private ArrayList<Product> ProductArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<Product>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Product> productMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void clearComposite() {
        compositeDisposable.clear();
    }
    public MutableLiveData<ArrayList<Product>> getProducts() {
        ProductService apiProductService = new ProductRetrofitClient().getProductApiService();

        compositeDisposable.add(apiProductService.getProducts()
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(products -> {
                            if(products != null && products.size() > 0) {
                                mutableLiveData.setValue(products);
                            }
                        }, error -> Log.e("API_ERROR", "Lỗi API: " + error.getMessage())
                ));
        return mutableLiveData;
    }

    public LiveData<Product> getProductDetail(String productId) {
        MutableLiveData<Product> productLiveData = new MutableLiveData<>();
        ProductService apiProductService = new ProductRetrofitClient().getProductApiService();

        compositeDisposable.add(apiProductService.getProductById(productId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(product -> {
                            if (product != null) {
                                productLiveData.setValue(product);
                            }
                        }, error -> Log.e("API_ERROR", "Lỗi khi lấy chi tiết sản phẩm: " + error.getMessage())
                ));
        return productLiveData;
    }


}

