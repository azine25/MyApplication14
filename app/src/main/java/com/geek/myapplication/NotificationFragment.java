package com.geek.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.myapplication.databinding.FragmentHomeBinding;
import com.geek.myapplication.databinding.FragmentNotificationBinding;


public class NotificationFragment extends Fragment {

   FragmentNotificationBinding binding;

    public NotificationFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}