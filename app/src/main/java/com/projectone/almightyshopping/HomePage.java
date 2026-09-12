package com.projectone.almightyshopping;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.projectone.almightyshopping.databinding.ActivityHomePageBinding;
import com.projectone.almightyshopping.fragments.CategoryFragment;
import com.projectone.almightyshopping.fragments.HomeFragment;
import com.projectone.almightyshopping.fragments.ProfileFragment;

public class HomePage extends AppCompatActivity {

    ActivityHomePageBinding activityHomePageBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        activityHomePageBinding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(activityHomePageBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(activityHomePageBinding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setCurrentFragment(new HomeFragment());

        activityHomePageBinding.bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.homeIcon) {
                setCurrentFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.categoryIcon) {
                setCurrentFragment(new CategoryFragment());
                return true;
            } else if (itemId == R.id.profileIcon) {
                setCurrentFragment(new ProfileFragment());
                return true;
            }
            return false;
        });
    }

    public void setCurrentFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(activityHomePageBinding.fragmentContainer.getId(), fragment)
                .commit();
    }
}