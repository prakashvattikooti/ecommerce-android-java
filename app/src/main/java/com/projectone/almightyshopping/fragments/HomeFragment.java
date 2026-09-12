package com.projectone.almightyshopping.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectone.almightyshopping.adapter.CategoryAdapter;
import com.projectone.almightyshopping.databinding.FragmentHomeBinding;
import com.projectone.almightyshopping.viewmodel.HomePageViewModel;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private FragmentHomeBinding binding;
    private HomePageViewModel mainViewModel;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
        AppCompatActivity appCompatActivity = (AppCompatActivity) requireActivity();
        appCompatActivity.setSupportActionBar(binding.toolbar);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3);
        binding.rvCategories.setLayoutManager(gridLayoutManager);

        mainViewModel.getCategories().observe(getViewLifecycleOwner(), categoryList -> {
            if (categoryList != null) {
                Log.d(TAG, "Categories loaded: " + categoryList.size());
                CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList);
                binding.rvCategories.setAdapter(categoryAdapter);
            }
        });

        mainViewModel.getProducts().observe(getViewLifecycleOwner(), productsList -> {
            if (productsList != null) {
                Log.d(TAG, "Products loaded: " + productsList.size());
                // ProductAdapter productAdapter = new ProductAdapter(productsList);
                // binding.rvProducts.setAdapter(productAdapter);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}