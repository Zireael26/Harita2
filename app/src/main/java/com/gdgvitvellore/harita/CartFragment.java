package com.gdgvitvellore.harita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    private View rootView;

    private ArrayList<Item> newItemList = new ArrayList<>();

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


        newItemList.add(new Item("Tomato", 20));
        newItemList.add(new Item("Potato", 15));
        newItemList.add(new Item("Onion", 12));
        newItemList.add(new Item("Cabbage", 30));
        newItemList.add(new Item("Carrot", 35));

        RecyclerView cartRecyclerView = (RecyclerView) rootView.findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CartAdapter mAdapter = new CartAdapter(newItemList);
        cartRecyclerView.setAdapter(mAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }

}
