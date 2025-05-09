package fpt.edu.vn.tingstoreapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import fpt.edu.vn.tingstoreapp.models.Product;
import fpt.edu.vn.tingstoreapp.repository.ProductRepository;

public class HomeViewModel extends ViewModel {
    ProductRepository productRepository = new ProductRepository();

    public HomeViewModel() {

    }

    public LiveData<ArrayList<Product>> getAllProduct() {
        return productRepository.getProducts();
    }
    public void clearComposite() {
        productRepository.clearComposite();
    }
}