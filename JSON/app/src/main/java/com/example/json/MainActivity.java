package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

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
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // JSON Node names
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONE = "phone";

    // contacts JSONArray
    JSONArray contacts = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hashmap for List
        ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();

        // getting JSON string from text file
        JSONObject json = null;

        String ret = "";

        try {
            //InputStream inputStream = openFileInput("json1.txt");
            InputStream inputStream = getResources().openRawResource(R.raw.json1);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
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
            contacts = json.getJSONArray(TAG_CONTACTS);

            // looping through All Contacts
            for(int i = 0; i < contacts.length(); i++){
                JSONObject c = contacts.getJSONObject(i);

                // Storing each json item in variable

                String name = c.getString(TAG_NAME);
                String email = c.getString(TAG_EMAIL);
                String phone = c.getString(TAG_PHONE);

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

        //Now put parsed result to TextView
        TextView res = findViewById(R.id.txtResult);
        String ss = "";
        for(int i=0; i<contactList.size(); i++) {
            ss += "<h1>";
            ss += contactList.get(i).get(TAG_NAME);
            ss += "<h3>";
            ss += contactList.get(i).get(TAG_EMAIL);
            ss += "<br><br><br>";
        }
        res.setMovementMethod(new ScrollingMovementMethod()); //enable scrolling
        res.setText(HtmlCompat.fromHtml(ss, HtmlCompat.FROM_HTML_MODE_COMPACT)); //html text
    }
}