package com.gdgvitvellore.harita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
public class CartFragment extends Fragment {

    private View rootView;

    private ArrayList<Item> newItemList = new ArrayList<>();
    private DatabaseReference databaseReference;


    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance() {
        return new CartFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference("Cart List");


//        newItemList.add(new Item("Tomato", 20));
//        newItemList.add(new Item("Potato", 15));
//        newItemList.add(new Item("Onion", 12));
//        newItemList.add(new Item("Cabbage", 30));
//        newItemList.add(new Item("Carrot", 35));
//
//        for (Item i : newItemList) {
//            databaseReference.push().setValue(i);
//        }



        // Inflate the layout for this fragment
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

                RecyclerView cartRecyclerView = rootView.findViewById(R.id.cartRecyclerView);
                cartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                CartAdapter mAdapter = new CartAdapter(newItemList);
                cartRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("Read Status", "The read failed: " + databaseError.getCode());
            }
        });

    }
}
