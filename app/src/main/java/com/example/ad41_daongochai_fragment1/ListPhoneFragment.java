package com.example.ad41_daongochai_fragment1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ad41_daongochai_fragment1.databinding.PhoneNumberListBinding;

import java.util.List;

public class ListPhoneFragment extends Fragment implements ListData{
    private static final String TAG = "ListPhoneFragment";
    private RecyclerView rvPhoneList;
    private PhoneNumberListAdapter phoneNumberListAdapter;

    PhoneNumberListBinding binding;

    public static ListPhoneFragment newInstance() {

        Bundle args = new Bundle();

        ListPhoneFragment fragment = new ListPhoneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.phone_number_list, container, false);

        Intent intent = getActivity().getIntent();
        int key = intent.getIntExtra("_KEY",1);
        phoneNumberListAdapter = new PhoneNumberListAdapter(listPhoneItems);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        binding.listNumberPhone.setLayoutManager(layoutManager);
        binding.listNumberPhone.setAdapter(phoneNumberListAdapter);

        if (key == 1){
            phoneNumberListAdapter.notifyDataSetChanged();
        }else if (key ==2 ){
            listPhoneItems.addAll(addListPhoneItem);
            phoneNumberListAdapter.notifyDataSetChanged();
        }


        return binding.getRoot();
    }




}
