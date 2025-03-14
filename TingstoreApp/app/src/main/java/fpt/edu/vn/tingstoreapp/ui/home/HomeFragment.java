package fpt.edu.vn.tingstoreapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import fpt.edu.vn.tingstoreapp.ProductDetailActivity;
import fpt.edu.vn.tingstoreapp.R;
import fpt.edu.vn.tingstoreapp.adapter.ProductRecyclerViewAdapter;
import fpt.edu.vn.tingstoreapp.databinding.FragmentHomeBinding;
import fpt.edu.vn.tingstoreapp.models.Product;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    ProductRecyclerViewAdapter productAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (getActivity() instanceof AppCompatActivity) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        }
        load();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void load() {
        binding.rvProduct.setHasFixedSize(true);
        binding.rvProduct.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        binding.progressBar.setVisibility(View.VISIBLE);
        homeViewModel.getAllProduct().observe(getViewLifecycleOwner(), products -> {
            productAdapter = new ProductRecyclerViewAdapter(products, requireContext(), this::listItemClicked);
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation);
            binding.rvProduct.setLayoutAnimation(controller);
            binding.rvProduct.setAdapter(productAdapter);
            binding.progressBar.setVisibility(View.GONE);
        });
    }

    private void listItemClicked(Product product) {
        Intent intent = new Intent(requireContext(), ProductDetailActivity.class);
//        intent.putExtra("product", product);
        intent.putExtra("productId", product.getId());
        startActivity(intent);
    }
}