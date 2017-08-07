package com.gdgvitvellore.harita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    private View rootView;
    private DatabaseReference databaseReference;


    private ArrayList<Item> newItemList = new ArrayList<>();

    public ShopFragment() {
        // Required empty public constructor
    }

    public static ShopFragment newInstance() {
        return new ShopFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_shop, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("Selected List");


//        newItemList.add(new Item("Tomato", 20));
//        newItemList.add(new Item("Potato", 15));
//        newItemList.add(new Item("Onion", 12));
//        newItemList.add(new Item("Cabbage", 30));
//        newItemList.add(new Item("Carrot", 35));
//
//        for (Item i : newItemList) {
//            databaseReference.push().setValue(i);
//        }

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        // Attach a listener to read the data at our posts reference
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    Item item = itemSnapshot.getValue(Item.class);
                    newItemList.add(item);
                }

                RecyclerView shopRecyclerView = rootView.findViewById(R.id.shopRecyclerView);
                shopRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                ShopAdapter mAdapter = new ShopAdapter(newItemList);
                shopRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("Read Status", "The read failed: " + databaseError.getCode());
            }
        });

    }
}
