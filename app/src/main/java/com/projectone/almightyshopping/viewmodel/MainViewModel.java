package com.projectone.almightyshopping.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.projectone.almightyshopping.modelclasses.Categories;
import com.projectone.almightyshopping.modelclasses.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Categories>> categories;

    private MutableLiveData<List<Product>> products;

    public MainViewModel() {

        categories = new MutableLiveData<>();
        products = new MutableLiveData<>();
        List<Categories> categoryList = new ArrayList<>(List.of(new Categories("1", "T-Shirt", ""),
                new Categories("2", "Shirts", ""),
                new Categories("3", "Polos", ""),
                new Categories("4", "Jeans", ""),
                new Categories("5", "Pants", ""),
                new Categories("6", "Joggers", ""),
                new Categories("7", "Sneakers", ""),
                new Categories("8", "Linen", ""),
                new Categories("9","View All", "")));
        List<Product> productList = Arrays.asList(
                new Product(1, "Nike Shoes", 999, "", "Footwear"),
                new Product(2, "Adidas T-Shirt", 799, "", "Men"),
                new Product(3, "Puma Bag", 1299, "", "Bags")
        );

        categories.setValue(categoryList);
        products.setValue(productList);
    }

    public LiveData<List<Categories>> getCategories() {
        return categories;
    }

    public LiveData<List<Product>> getProducts(){
        return products;
    }
}
