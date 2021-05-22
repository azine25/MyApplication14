package com.geek.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geek.myapplication.databinding.ActivitySettings2Binding;

public class SettingsActivity2 extends AppCompatActivity {

    private ActivitySettings2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettings2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}