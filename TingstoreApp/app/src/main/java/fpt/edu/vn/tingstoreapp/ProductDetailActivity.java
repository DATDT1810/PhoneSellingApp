package fpt.edu.vn.tingstoreapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import fpt.edu.vn.tingstoreapp.adapter.PhotoAdapter;
import fpt.edu.vn.tingstoreapp.databinding.ActivityProductDetailBinding;
import fpt.edu.vn.tingstoreapp.models.Product;
import fpt.edu.vn.tingstoreapp.viewModels.ProductDetailViewModel;
import me.relex.circleindicator.CircleIndicator3;

public class ProductDetailActivity extends AppCompatActivity {
    private ActivityProductDetailBinding binding;
    private String productid;
    private ProductDetailViewModel productDetailViewModel;
    private Product product;
    PhotoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        productDetailViewModel = new ViewModelProvider(this).get(ProductDetailViewModel.class);
        productid = (String) getIntent().getSerializableExtra("productId");
        productDetailViewModel.getProductDetail(productid).observe(this, product -> {
                    binding.productName.setText(product.getName());
                    binding.productDescription.setText(product.getDescription());
                    binding.productPrice.setText(String.valueOf(product.getPrice()));
                    binding.productStock.setText(String.valueOf(product.getStock()));
                    this.product = product;
                    adapter = new PhotoAdapter(this ,product.getImages());
                    binding.slideProductImage.setAdapter(adapter);
                    binding.circleIndicator.setViewPager(binding.slideProductImage);
                });

        binding.backButton.setOnClickListener(v -> finish());
    }
}