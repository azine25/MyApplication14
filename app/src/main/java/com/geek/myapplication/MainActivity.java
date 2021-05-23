package com.geek.myapplication;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.geek.myapplication.databinding.ActivityMainBinding;
import com.geek.myapplication.databinding.ActivitySettings2Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.Normalizer;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HomeFragment homeFragment = new HomeFragment();
    private DashFragment dashFragment = new DashFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();
    Fragment active = homeFragment;
    private FragmentManager fm = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener listener = item -> {

        switch (item.getItemId()) {
                    case R.id.home_fragment:
                        fm.beginTransaction().hide(active).show(homeFragment).commit();
                        getSupportActionBar().setTitle("Home Fragment");
                        active = homeFragment;
                        return true;
                    case R.id.dashboard_fragment:
                        fm.beginTransaction().hide(active).show(dashFragment).commit();
                        active = dashFragment;
                        getSupportActionBar().setTitle("Dash Fragment");

                        return true;
                    case R.id.notification_fragment:
                        fm.beginTransaction().hide(active).show(notificationFragment).commit();
                        getSupportActionBar().setTitle("Not Fragment");
                        active = notificationFragment;
                        return true;
                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbarAm);

        binding.bottomNav.setOnNavigationItemSelectedListener(listener);
        fm.beginTransaction().add(R.id.fm_fl,notificationFragment,"notif").hide(notificationFragment).commit();
        fm.beginTransaction().add(R.id.fm_fl,dashFragment,"dash").hide(dashFragment).commit();
        fm.beginTransaction().add(R.id.fm_fl,homeFragment,"Home").commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings){
            startActivity(new Intent(MainActivity.this, ActivitySettings2Binding.class));

        }
        return super.onOptionsItemSelected(item);
    }
    public void hideBottomNav (){
        binding.bottomNav.setVisibility(View.GONE);
    }
    public void hide_Visible(){
        binding.bottomNav.setVisibility(View.VISIBLE);
    }
}