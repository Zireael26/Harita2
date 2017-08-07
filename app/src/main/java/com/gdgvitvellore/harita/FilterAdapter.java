package com.gdgvitvellore.harita;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by abhis on 7/24/2017.
 */

class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ItemViewHolder> {
    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private boolean checkBoxState;
    private DatabaseReference databaseReference;
    private int pos;

    public FilterAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.filter_item_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachParentToImmediately = false;

        databaseReference = FirebaseDatabase.getInstance().getReference("Selected List");
//        databaseReference.push().setValue(new Item("Tomato", 12));

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachParentToImmediately);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        pos = position;
        checkBoxState = holder.checkBox.isChecked();
        holder.nameTextView.setText(itemArrayList.get(pos).getmName());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(itemArrayList.get(pos));
                Log.v("Item Added, Item", "" + itemArrayList.get(pos).getmName());
            }
        });

    }

    @Override
    public int getItemCount() {

        return itemArrayList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        EditText editRateET;
        CheckBox checkBox;

        public ItemViewHolder(View itemView) {
            super(itemView);

            editRateET = itemView.findViewById(R.id.filterRateET);
            nameTextView = itemView.findViewById(R.id.filterNameTV);
            checkBox = itemView.findViewById(R.id.filterCheckBox);
        }
    }
}
