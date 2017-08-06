package com.gdgvitvellore.harita;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhis on 7/24/2017.
 */

class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ItemViewHolder> {
    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private boolean checkBoxState;
    public FilterAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.filter_item_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachParentToImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachParentToImmediately);
        ItemViewHolder viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.nameTextView.setText(itemArrayList.get(position).getmName());
        checkBoxState = holder.checkBox.isChecked();

        if(checkBoxState) {
            itemArrayList.get(position).setmRate(Double.parseDouble(holder.editRateET.getText().toString()));
        } else {
            holder.editRateET.setText("₹" + itemArrayList.get(position).getmRate());
        }
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
