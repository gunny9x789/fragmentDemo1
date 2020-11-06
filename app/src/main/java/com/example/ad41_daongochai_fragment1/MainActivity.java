package com.example.ad41_daongochai_fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements ListData {
    private static final String TAG = "MainActivity";

    private Button btnUpdate, btnAdd;
    private Cursor cursor;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);

        getContactList();
        getFragment(ListPhoneFragment.newInstance());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContactList();
                Intent intent = new Intent(getBaseContext(),ListPhoneFragment.class);
                intent.putExtra("_KEY",1);
                getFragment(ListPhoneFragment.newInstance());
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(AddFragment.newInstance());
            }
        });

    }

    public void getFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmenLayout, fragment).commit();
    }

    private void getContactList() {
        //Set<ListPhoneItem> set = new HashSet<>(listPhoneItems);
        listPhoneItems.clear();
       // listPhoneItems.addAll(set);
        Uri contendUri = ContactsContract.Contacts.CONTENT_URI;
        String phone;
        String name;
        ContentResolver contentResolver = getContentResolver();
        cursor = contentResolver.query(contendUri, null, null, null, null);
        if ((cursor != null ? cursor.getCount() : 0) > 0) {
            count = 0;
            while (cursor != null && cursor.moveToNext()) {
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String id = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts._ID));
                int sizephone = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (sizephone > 0) {
                    Cursor phoneCur = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (phoneCur.moveToNext()) {
                        phone = phoneCur.getString(phoneCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        listPhoneItems.add(new ListPhoneItem(phone, name));
                    }
                    phoneCur.close();
                }
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        listPhoneItems.addAll(addListPhoneItem);
    }


}