package com.geek.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.myapplication.databinding.FragmentDashBinding;
import com.geek.myapplication.databinding.FragmentHomeBinding;


public class DashFragment extends Fragment {

    private FragmentDashBinding binding;
    public DashFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentDashBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}