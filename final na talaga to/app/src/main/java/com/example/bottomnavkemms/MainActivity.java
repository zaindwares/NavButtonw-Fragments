package com.example.bottomnavkemms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId())

            {

                case R.id.nav_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.nav_message:
                    fragment = new MessageFragment();
                    break;

                case R.id.nav_notification:
                    fragment = new NotificationsFragment();
                    break;

                case R.id.nav_account:
                    fragment = new AccountFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();


                return true;
            }
        });

    }
}