package com.gdgvitvellore.harita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterFragment extends Fragment {


    private ArrayList<Item> newItemList = new ArrayList<>();

    public FilterFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FilterFragment newInstance() {
        return new FilterFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_filter, container, false);

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        for (Item item : newItemList) {
            mRef.push().setValue(item);
        }

        newItemList.add(new Item("Tomato", 13));
        newItemList.add(new Item("Potato", 15));
        newItemList.add(new Item("Onion", 12));
        newItemList.add(new Item("Cabbage", 30));
        newItemList.add(new Item("Carrot", 35));

        RecyclerView recyclerView = rootView.findViewById(R.id.filterRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FilterAdapter mAdapter = new FilterAdapter(newItemList);
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
