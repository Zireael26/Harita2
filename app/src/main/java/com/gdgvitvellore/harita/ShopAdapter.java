package com.gdgvitvellore.harita;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhis on 7/23/2017.
 */

class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ItemViewHolder> {

    private ArrayList<Item> itemArrayList = new ArrayList<>();
    int itemWeight;

    public ShopAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.shop_item_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachParentToImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachParentToImmediately);
        ItemViewHolder viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.rateTextView.setText("₹"+itemArrayList.get(position).getPrice());
        holder.nameTextView.setText(itemArrayList.get(position).getName());
//        itemArrayList.get(position).setmWeight(Integer.parseInt(holder.weightEditText.getText().toString()));
        holder.decWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemArrayList.get(position).setmWeight(itemArrayList.get(position).getWeight()+ 5);
            }
        });

        holder.incWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemArrayList.get(position).setmWeight(itemArrayList.get(position).getWeight()- 5);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView rateTextView, nameTextView;
        EditText weightEditText;
        Button decWeight, incWeight;

        public ItemViewHolder(View itemView) {
            super(itemView);

            rateTextView = itemView.findViewById(R.id.itemRateShopTV);
            nameTextView = itemView.findViewById(R.id.itemNameShopTV);
            weightEditText = itemView.findViewById(R.id.itemWeightShopET);
            decWeight = itemView.findViewById(R.id.decreaseWeightButton);
            incWeight = itemView.findViewById(R.id.increaseWeightButton);
        }
    }
}
