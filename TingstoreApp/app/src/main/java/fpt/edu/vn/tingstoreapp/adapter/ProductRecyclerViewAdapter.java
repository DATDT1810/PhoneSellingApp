package fpt.edu.vn.tingstoreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fpt.edu.vn.tingstoreapp.actionInterface.OnItemClickListener;
import fpt.edu.vn.tingstoreapp.databinding.ListItemProductBinding;
import fpt.edu.vn.tingstoreapp.models.Product;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder> {
    private ArrayList<Product> productArrayList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public ProductRecyclerViewAdapter(ArrayList<Product> productArrayList, Context context, OnItemClickListener onItemClickListener) {
        this.productArrayList = productArrayList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemProductBinding binding = ListItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product productItem = productArrayList.get(position);
        holder.bind(productItem, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return this.productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private final ListItemProductBinding binding;

        public ProductViewHolder(ListItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Product product, final OnItemClickListener clickListener) {
            binding.nameProduct.setText(product.getName());
            binding.productPrice.setText(product.getPrice() + "");
            Glide.with(context).load(product.getProductImage()).into(binding.imgPic);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(product);
                }
            });
        }
    }
}
