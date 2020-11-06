package com.example.ad41_daongochai_fragment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.ad41_daongochai_fragment1.databinding.AddFragmenrBinding;

public class AddFragment extends Fragment implements ListData {
    AddFragmenrBinding binding;

    public static AddFragment newInstance() {

        Bundle args = new Bundle();

        AddFragment fragment = new AddFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.add_fragmenr, container, false);


        binding.btnAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(binding.etName.getText());
                String phone = String.valueOf(binding.etPhone.getText());
                Intent intent = new Intent(getActivity(), ListPhoneFragment.class);
                intent.putExtra("_KEY", 2);
                addListPhoneItem.add(new ListPhoneItem(name,phone));
                getFragment(ListPhoneFragment.newInstance());


            }
        });

        return binding.getRoot();
    }

    public void getFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmenLayout, fragment).commit();
    }
}
