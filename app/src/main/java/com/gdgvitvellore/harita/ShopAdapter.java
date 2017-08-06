package com.gdgvitvellore.harita;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhis on 7/23/2017.
 */

class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ItemViewHolder> {

    int itemWeight, num = 0;
    private ArrayList<Item> itemArrayList = new ArrayList<>();

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
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.rateTextView.setText("₹" + itemArrayList.get(position).getmPrice());
        holder.nameTextView.setText(itemArrayList.get(position).getmName());
        holder.decWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemArrayList.get(position).setmWeight(Double.parseDouble(holder.weightEditText.getText().toString()));
                itemArrayList.get(position).setmWeight(itemArrayList.get(position).getmWeight() - 5);
                holder.weightEditText.setText("" + itemArrayList.get(position).getmWeight());
            }
        });

        holder.incWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemArrayList.get(position).setmWeight(itemArrayList.get(position).getmWeight() + 5);
                holder.weightEditText.setText("" + itemArrayList.get(position).getmWeight());
            }
        });
        holder.cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num % 2 == 1) {
                    holder.cartButton.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                    num++;
                } else {
                    holder.cartButton.setImageResource(R.drawable.ic_remove_shopping_cart_black_24dp);
                    num++;
                }
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
        ImageButton cartButton;

        public ItemViewHolder(View itemView) {
            super(itemView);

            rateTextView = itemView.findViewById(R.id.itemRateShopTV);
            nameTextView = itemView.findViewById(R.id.itemNameShopTV);
            weightEditText = itemView.findViewById(R.id.itemWeightShopET);
            decWeight = itemView.findViewById(R.id.decreaseWeightButton);
            incWeight = itemView.findViewById(R.id.increaseWeightButton);
            cartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }
}
