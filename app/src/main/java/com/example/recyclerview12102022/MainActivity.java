package com.example.recyclerview12102022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvStore;
    StoreAdapter storeAdapter;
    List<Store> storeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvStore = findViewById(R.id.recycler_view_store);
        storeList = Store.getMock();
        storeAdapter = new StoreAdapter(storeList);
        rcvStore.setAdapter(storeAdapter);

        storeAdapter.setOnItemClickListener(new StoreAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("BBB",  storeList.get(position).getName());
            }
        });
    }
}
