package com.example.myapplication1;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication1.Fragments.activityFragment;
import com.example.myapplication1.Fragments.homeFragment;
import com.example.myapplication1.Fragments.mapFragment;
import com.example.myapplication1.Fragments.profileFragment;
import com.example.myapplication1.Fragments.searchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;  // Import this for NavigationBarView

public class bttmnvgtn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bttmnvgtn);

        // Apply window insets to adjust for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up BottomNavigationView and its listener
        BottomNavigationView btmnav = findViewById(R.id.bottomNavigationView);
        btmnav.setSelectedItemId(R.id.nav_home);  // Corrected method name
        btmnav.setOnItemSelectedListener(navListener);  // Corrected method name

        Fragment selectedFragment = new homeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
    }

    private final NavigationBarView.OnItemSelectedListener navListener = item -> {
        int itemId = item.getItemId();  // Corrected method to get item ID
        Fragment selected = null;

        if (itemId == R.id.nav_home) {
            selected = new homeFragment();
        } else if (itemId == R.id.nav_map) {
            selected = new mapFragment();
        } else if (itemId == R.id.nav_search) {
            selected = new searchFragment();
        } else if (itemId == R.id.nav_activity) {
            selected = new activityFragment();
        } else if (itemId == R.id.nav_profile) {
            selected = new profileFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selected).commit();
        return true;
    };
}
