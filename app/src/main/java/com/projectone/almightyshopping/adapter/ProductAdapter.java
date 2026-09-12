package com.projectone.almightyshopping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projectone.almightyshopping.R;
import com.projectone.almightyshopping.modelclasses.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvProductPrice.setText(String.valueOf(product.getPrice()));
        holder.tvProductName.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProduct;
        TextView tvProductName, tvProductPrice;
        public ProductViewHolder(@NonNull View item){
            super(item);

            imgProduct = item.findViewById(R.id.imgProduct);
            tvProductName = item.findViewById(R.id.tvProductName);
            tvProductPrice = item.findViewById(R.id.tvProductPrice);

        }
    }
}
