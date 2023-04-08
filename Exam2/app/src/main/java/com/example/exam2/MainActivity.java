package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private WordListAdapter wordListAdapter;

    private List<Items> itemsList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        itemsList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recycleView);



        wordListAdapter = new WordListAdapter(this, itemsList);

        //recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(wordListAdapter);



        prepareItems();

        wordListAdapter.notifyDataSetChanged();

    }



    int flowerId[] = {

            R.drawable.s1,

            R.drawable.s2,

            R.drawable.s3,

            R.drawable.s4,

            R.drawable.s5,



            R.drawable.s6,

            R.drawable.s7,

            R.drawable.s8,

            R.drawable.s9,


    };

    int flowerId2[] = {

            R.drawable.b1,

            R.drawable.b2,

            R.drawable.b3,

            R.drawable.b4,

            R.drawable.b5,



            R.drawable.b6,

            R.drawable.b7,

            R.drawable.b8,

            R.drawable.b9,


    };

    private void prepareItems(){

        for(int i = 0; i < flowerId.length; i++) {

            Items items = new Items(flowerId[i],flowerId2[i]);

            itemsList.add(items);

        }

    }
}






