package com.gdgvitvellore.harita;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhis on 7/23/2017.
 */

class CartAdapter extends RecyclerView.Adapter<CartAdapter.ItemViewHolder> {

    public CartAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    private ArrayList<Item> itemArrayList = new ArrayList<>();

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.cart_item_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachParentToImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachParentToImmediately);
        ItemViewHolder viewHolder = new ItemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.priceTextView.setText("₹"+itemArrayList.get(position).getPrice());
        holder.nameTextView.setText(itemArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView priceTextView, nameTextView;
        ImageButton removeButton;

        public ItemViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.itemNameCartTV);
            priceTextView =(TextView) itemView.findViewById(R.id.itemPriceCartTV);
            removeButton =(ImageButton) itemView.findViewById(R.id.removeItemButton);
        }
    }
}

