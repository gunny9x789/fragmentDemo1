package com.example.ad41_daongochai_fragment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhoneNumberListAdapter extends RecyclerView.Adapter<PhoneNumberListAdapter.ViewHoder> {

    List<ListPhoneItem> listItems;

    public PhoneNumberListAdapter(List<ListPhoneItem> listItems) {
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public PhoneNumberListAdapter.ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);

        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneNumberListAdapter.ViewHoder holder, int position) {
        ListPhoneItem phoneItem = listItems.get(position);

        holder.tvName.setText(phoneItem.getName());
        holder.tvPhone.setText(phoneItem.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
