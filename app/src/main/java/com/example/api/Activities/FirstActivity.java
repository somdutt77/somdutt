package com.example.api.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.api.Fragments.FavouriteFragment;
import com.example.api.Fragments.HomeFragment;
import com.example.api.Fragments.UserFragment;
import com.example.api.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FirstActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FrameLayout frame_layout;
    BottomNavigationView bottomnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        first();

        bottomnav.setOnNavigationItemSelectedListener(this);

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment, "");
        fragmentTransaction.commit();


    }

    private void first() {
        frame_layout = findViewById(R.id.frame_layout);
        bottomnav = findViewById(R.id.bottomnav);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.home:
                HomeFragment fragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, fragment, "");
                fragmentTransaction.commit();
                return true;

            case R.id.favourite:
                FavouriteFragment fragment1 = new FavouriteFragment();
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout, fragment1);
                fragmentTransaction1.commit();
                return true;

            case R.id.user:
                UserFragment fragment3 = new UserFragment();
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.frame_layout, fragment3);
                fragmentTransaction3.commit();
                return true;
        }
        return false;

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    ;
}