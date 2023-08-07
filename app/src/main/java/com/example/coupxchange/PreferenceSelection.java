package com.example.coupxchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class PreferenceSelection extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    private List<Website> websiteList;
    private RecyclerView recyclerView;
    private WebsiteAdapter adapter;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_selection);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String userEmail = mAuth.getCurrentUser().getEmail();

        websiteList = new ArrayList<>();
        websiteList.add(new Website("Amazon", R.drawable.amazon2));
        websiteList.add(new Website("Flipkart", R.drawable.flipkart));
        websiteList.add(new Website("Lenskart", R.drawable.flipkart));
        websiteList.add(new Website("Skullcandy", R.drawable.skullcandy));
        websiteList.add(new Website("Udemy", R.drawable.udemy));
        websiteList.add(new Website("Zomato", R.drawable.zomato));
        websiteList.add(new Website("Swiggy", R.drawable.swiggy));
        websiteList.add(new Website("Coursera", R.drawable.coursera));
        websiteList.add(new Website("Airtel", R.drawable.coursera));
        websiteList.add(new Website("Kotak", R.drawable.swiggy));

        recyclerView = findViewById(R.id.website_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new WebsiteAdapter(this, websiteList);
        recyclerView.setAdapter(adapter);

        saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Website> selectedWebsites = adapter.getSelectedWebsites();
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                StringBuilder websitesNames = new StringBuilder();
                for (Website website : selectedWebsites) {
                    websitesNames.append(website.getName()).append(",");
                }
                if (websitesNames.length() > 0) {
                    websitesNames.setLength(websitesNames.length() - 1);
                }

                if (user != null) {
                    String userId = user.getUid();
                    databaseReference.child("userInfo").child(userId).child("preferences").setValue(websitesNames.toString());
                    databaseReference.child("userInfo").child(userId).child("points").setValue(0)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(PreferenceSelection.this, "Selected websites saved", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(PreferenceSelection.this, "Failed to save selected websites", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

    }
}

