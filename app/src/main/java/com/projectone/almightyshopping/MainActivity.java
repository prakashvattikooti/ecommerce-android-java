package com.projectone.almightyshopping;

import static android.widget.LinearLayout.HORIZONTAL;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projectone.almightyshopping.adapter.CategoryAdapter;
import com.projectone.almightyshopping.adapter.ProductAdapter;
import com.projectone.almightyshopping.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {


    MainViewModel mainViewModel;
    RecyclerView rvCategories;
    RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        rvCategories = findViewById(R.id.rvCategories);
       // rvProducts = findViewById(R.id.rvProducts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        GridLayoutManager linearLayoutManager1 = new GridLayoutManager(this,3);
        rvCategories.setLayoutManager(linearLayoutManager1);
       // rvProducts.setLayoutManager(linearLayoutManager1);


        mainViewModel.getCategories().observe(this,categoryList ->{
            Log.d("TAG", "onCreate: " + categoryList.toString());
            CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList);
            rvCategories.setAdapter(categoryAdapter);

        });

        mainViewModel.getProducts().observe(this,productsList -> {
            Log.d("TAG", "onCreate: " + productsList.toString());
            ProductAdapter productAdapter = new ProductAdapter(productsList);
            //rvProducts.setAdapter(productAdapter);
        });
    }
}