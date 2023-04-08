package com.example.finaltest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Page3 extends Fragment {

    private PageViewModel pageViewModel;
    private TextView txtName;
    private TextView txtStudentId;

    // XML Node names
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONE = "phone";

    private ArrayList<HashMap<String,String>> contactList;

    private RecyclerView recyclerView;

    private WordListAdapter wordListAdapter;

    private List<Items> itemsList;
    JSONArray contacts = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise ViewModel here
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(
                R.layout.slide_page3, container, false);

        JSONObject json = null;
        contactList = new ArrayList<HashMap<String,String>>();

        String ret = "";

        try {
            //InputStream inputStream = openFileInput("json1.txt");
            InputStream inputStream = getResources().openRawResource(R.raw.json1);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("JSON Parser", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("JSON Parser", "Can not read file: " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            json = new JSONObject(ret);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        try {
            // Getting Array of Contacts
            contacts = json.getJSONArray("contacts"); //TAG_CONTACTS

            // looping through All Contacts
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);

                // Storing each json item in variable

                String name = c.getString(TAG_NAME);//TAG_NAME
                String email = c.getString(TAG_EMAIL);//TAG_EMAIL
                String phone = c.getString(TAG_PHONE);//TAG_PHONE

                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                // adding each child node to HashMap key => value

                map.put(TAG_NAME, name);
                map.put(TAG_EMAIL, email);
                map.put(TAG_PHONE, phone);

                // adding HashList to ArrayList
                contactList.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*
        //Now put parsed result to TextView
        TextView res = findViewById(R.id.txtResult);
        String ss = "";
        for (int i = 0; i < contactList.size(); i++) {
            ss += "<h1>";
            ss += contactList.get(i).get(TAG_NAME);
            ss += "<h3>";
            ss += contactList.get(i).get(TAG_EMAIL);
            ss += "<h3>";
            ss += contactList.get(i).get(TAG_PHONE);
            ss += "<br><br><br>";
        }
        res.setMovementMethod(new ScrollingMovementMethod()); //enable scrolling
        res.setText(HtmlCompat.fromHtml(ss, HtmlCompat.FROM_HTML_MODE_COMPACT)); //html text
        */
        itemsList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recycleView2);

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.nameView2);
        txtStudentId = view.findViewById(R.id.studentIdView2);
        pageViewModel.getName().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtName.setText(s);
            }
        });
        pageViewModel.getId().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtStudentId.setText(s);
            }
        });

    }

    private void prepareItems(){

        for(int i = 0; i < contactList.size(); i++) {
            HashMap<String, String> listMap = contactList.get(i);

            Items items = new Items(listMap.get(TAG_NAME),listMap.get(TAG_EMAIL),listMap.get(TAG_PHONE));

            itemsList.add(items);

        }

    }
}
