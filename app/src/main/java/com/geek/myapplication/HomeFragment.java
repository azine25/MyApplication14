package com.geek.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding_hf;
    MainActivity mainActivity;
    int tir;
    private Adapter home_adapter;
    private FragmentManager fm;

    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
        home_adapter = new Adapter(new Adapter.Listener() {
            @Override
            public void ItemClick(Model model, int position) {
                tir = position;
                FromFragment fr = new FromFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("fa", model);
                fr.setArguments(bundle);
                fm.beginTransaction().replace(R.id.fm_fl, fr).addToBackStack(null).commit();

            }
        });
        mainActivity = (MainActivity) requireActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding_hf = FragmentHomeBinding.inflate(inflater, container, false);


        binding_hf.rvTarget.setAdapter(home_adapter);

        binding_hf.fab.setOnClickListener(v -> {
            fm.beginTransaction().replace(R.id.fm_fl, new FromFragment()).addToBackStack(null).commit();
            mainActivity.   hideBottomNav();
        });

        fm.setFragmentResultListener("res", this, (requestKey, result) -> {
            Model model;
            if (result.getSerializable("update") != null) {
                model = (Model) result.getSerializable("update");
                home_adapter.update(model, tir);
            } else {
                model = (Model) result.getSerializable("add");
               home_adapter.adds(model);
            }
        });

        return binding_hf.getRoot();
    }
}