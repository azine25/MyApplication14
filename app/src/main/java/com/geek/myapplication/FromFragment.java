package com.geek.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.myapplication.databinding.FragmentFromBinding;
import com.geek.myapplication.databinding.FragmentHomeBinding;


public class FromFragment extends Fragment {
    MainActivity mainActivity;
    private FragmentManager fm;
    FragmentFromBinding binding_ff;
    Model model;

    public FromFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
        mainActivity = (MainActivity) requireActivity();
        if (getArguments() != null) {
            model = (Model) getArguments().getSerializable("azine");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding_ff = FragmentFromBinding.inflate(inflater, container, false);

        if (model != null) {
            binding_ff.etName.setText(model.getName());
            binding_ff.etPhoneNum.setText(model.getPhone());
        }

        binding_ff.btnSave.setOnClickListener(v -> {
            String name = binding_ff.etName.getText().toString().trim();
            String phoneNum = binding_ff.etPhoneNum.getText().toString().trim();


            if (name.isEmpty() && phoneNum.isEmpty()) {
                binding_ff.etName.setError("Ввведите имя");
                binding_ff.etPhoneNum.setError("Ввведите номер");
            } else {
                Bundle bundle = new Bundle();
                if (model != null) {
                    model.setName(name);
                    model.setPhone(phoneNum);
                    bundle.putSerializable("look", model);
                } else {
                    model = new Model(name, phoneNum);
                    bundle.putSerializable("no", model);
                }
                mainActivity.hide_Visible();
                fm.setFragmentResult("yes", bundle);
                fm.popBackStack();
            }
        });

        return binding_ff.getRoot();

    }
}