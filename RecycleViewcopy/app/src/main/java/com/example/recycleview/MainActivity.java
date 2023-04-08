package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WordListAdapter mAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateWords(); //메소드 선언 데이터준비

        //get a handle to the RecyclerView
        mRecyclerView = findViewById(R.id.recycler); //객체찾아오기

        //create an adapter and supply the data to be displayed
        mAdapter = new WordListAdapter(this, mWordList);

        //connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        //give the RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    String words[] = {
            "apple", "banana", "coffee", "diagram", "espresso", "fork", "golf", "help", "intel", "jock", "king", "lol", "money",
            "norm", "orange", "pork", "queen", "ramen", "starUML", "t-shirts", "um-jun-sik", "violet", "wing", "x-ray", "yaya","zzzz"
    };

    private final ArrayList<String> mWordList = new ArrayList<>();

    //create method
    private void populateWords(){
        for(int i=0; i<words.length; i++){
            mWordList.add(words[i]);
        }
    }
}