package fpt.edu.vn.tingstoreapp.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import fpt.edu.vn.tingstoreapp.models.Product;
import fpt.edu.vn.tingstoreapp.repository.ProductRepository;

public class ProductDetailViewModel extends ViewModel {
    ProductRepository productRepository = new ProductRepository();

    public LiveData<Product> getProductDetail(String id) {
        return productRepository.getProductDetail(id);
    }
    public void clearComposite() {
        productRepository.clearComposite();
    }
}
