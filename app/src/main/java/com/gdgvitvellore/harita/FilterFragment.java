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
 * Use the {@link FilterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterFragment extends Fragment {


    View rootView;
    private ArrayList<Item> newItemList = new ArrayList<>();
    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private FilterAdapter filterAdapter;
    private String key;
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
        rootView = inflater.inflate(R.layout.fragment_filter, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference("Full List");

        // Attach a listener to read the data at our posts reference
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    Item item = itemSnapshot.getValue(Item.class);
                    newItemList.add(item);
                }
                Log.v("onCreate method", "says Hello");

                recyclerView = rootView.findViewById(R.id.filterRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                filterAdapter = new FilterAdapter(newItemList);
                filterAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(filterAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("Read Status", "The read failed: " + databaseError.getCode());
            }
        });

//        newItemList.add(new Item("Tomato", 0));
//        newItemList.add(new Item("Potato", 0));
//        newItemList.add(new Item("Onion", 0));
//        newItemList.add(new Item("Cabbage", 0));
//        newItemList.add(new Item("Carrot", 0));
//        newItemList.add(new Item("Broccoli", 0));
//        newItemList.add(new Item("Beetroot", 0));
//        newItemList.add(new Item("Grapes", 0));
//        newItemList.add(new Item("Apples", 0));
//
//        for (Item i : newItemList) {
//            key = databaseReference.push().getKey();
//            i.setuID(key);
//            databaseReference.child(key).setValue(i);
//        }



        return rootView;
    }

}
