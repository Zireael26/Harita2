package com.gdgvitvellore.harita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {
    private View rootView;

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

        newItemList.add(new Item("Tomato", 20));
        newItemList.add(new Item("Potato", 15));
        newItemList.add(new Item("Onion", 12));
        newItemList.add(new Item("Cabbage", 30));
        newItemList.add(new Item("Carrot", 35));

        RecyclerView shopRecyclerView = (RecyclerView) rootView.findViewById(R.id.shopRecyclerView);
        shopRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ShopAdapter mAdapter = new ShopAdapter(newItemList);
        shopRecyclerView.setAdapter(mAdapter);


        return rootView;
    }

}
