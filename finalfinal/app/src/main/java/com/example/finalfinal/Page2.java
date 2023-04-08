package com.example.finalfinal;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Console;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Page2 extends Fragment {

    // XML Node names
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONE = "phone";

    private ArrayList<HashMap<String,String>> contactList;

    private RecyclerView recyclerView;

    private WordListAdapter wordListAdapter;

    private List<Items> itemsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.slide_page2, container, false);
        //Hashmap for List
        contactList = new ArrayList<HashMap<String,String>>();

        //xml읽기
        try {
            InputStream is = getContext().getAssets().open("file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            // Query by tag name
            NodeList empNodesList = doc.getElementsByTagName("contacts");

            for (int i = 0; i < empNodesList.getLength(); i++) {
                Element itemTag = (Element)empNodesList.item(i);

                NodeList data1List = itemTag.getElementsByTagName("name");
                NodeList data2List = itemTag.getElementsByTagName("email");
                NodeList data3List = itemTag.getElementsByTagName("phone");

                Element data1Tag = (Element) data1List.item(0);
                Element data2Tag = (Element) data2List.item(0);
                Element data3Tag = (Element) data3List.item(0);
                HashMap<String, String> map = new HashMap<String, String>();

                String name = data1Tag.getTextContent();
                String email = data2Tag.getTextContent();
                String phone = data3Tag.getTextContent();

                map.put(TAG_NAME,name);
                map.put(TAG_EMAIL,email);
                map.put(TAG_PHONE,phone);

                contactList.add(map);
            }

        } catch (Exception e) {e.printStackTrace();}

        itemsList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recycleView);

        wordListAdapter = new WordListAdapter(getContext(), itemsList);

        //recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());

        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(wordListAdapter);

        prepareItems();
        return view;
    }


    private void prepareItems(){

        for(int i = 0; i < contactList.size(); i++) {
            HashMap<String, String> listMap = contactList.get(i);

            Items items = new Items(listMap.get(TAG_NAME),listMap.get(TAG_EMAIL),listMap.get(TAG_PHONE));
            Log.d("msg",listMap.get(TAG_EMAIL)+contactList.size());

            itemsList.add(items);

        }

    }
}