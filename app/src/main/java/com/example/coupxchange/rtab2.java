package com.example.coupxchange;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class rtab2 extends Fragment {

    private RecyclerView recvieww;
    recommended_recycleradapter adapterr;


    public rtab2() {
        //required constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rtab2, container, false);
        recvieww = (RecyclerView) view.findViewById(R.id.recommended_coupons_list);
        recvieww.setLayoutManager(new LinearLayoutManager(getContext()));




        FirebaseRecyclerOptions optionss=new FirebaseRecyclerOptions.Builder<Token>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Tokens"),Token.class)
                .build();
        adapterr=new recommended_recycleradapter(optionss);
        recvieww.setAdapter(adapterr);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapterr.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        adapterr.stopListening();
    }



}


