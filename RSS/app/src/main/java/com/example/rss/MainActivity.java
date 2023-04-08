package com.example.rss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // this class represents the main GUI
    // TODO: use a resource file rather than hard-coding
    //       URLs into the array myUrlAddressCaption

    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context  context;
    SingleItem selectedNewsItem;

    String [][] myUrlAddressCaption = {
            {"https://feeds.bbci.co.uk/news/rss.xml", "Top Stories"},
            {"https://feeds.bbci.co.uk/news/world/rss.xml", "World"},
            {"https://feeds.bbci.co.uk/news/health/rss.xml", "Health"},
            {"https://feeds.bbci.co.uk/news/technology/rss.xml", "Technology"},
            {"https://feeds.bbci.co.uk/news/science_and_environment/rss.xml", "Science & Environment"},
            {"https://feeds.bbci.co.uk/news/education/rss.xml", "Eucation & Family"},
            {"https://biz.heraldm.com/rss/010000000000.xml", 	 "헤럴드경제"}
/*		{"https://rss.joins.com/joins_news_list.xml",   "전체기사"},
		{"https://rss.joins.com/joins_homenews_list.xml",   "주요기사"},
		{"https://rss.joins.com/joins_money_list.xml", 	 "경제"},
		{"https://rss.joins.com/joins_star_list.xml",   "연예전체"},
		{"https://rss.joins.com/joins_it_list.xml",   "IT과학"},
		{"https://rss.joins.com/joins_sports_list.xml", 	 "스포츠"},
		{"https://rss.joins.com/joins_culture_list.xml",   "문화"},
		{"https://rss.joins.com/joins_life_list.xml",   "사회"}*/

    };

    //define convenient URL and CAPTIONs arrays
    String [] myUrlCaption = new String[myUrlAddressCaption.length];
    String [] myUrlAddress = new String[myUrlAddressCaption.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0; i<myUrlAddressCaption.length; i++) {
            myUrlAddress[i] = myUrlAddressCaption[i][0];
            myUrlCaption[i] = myUrlAddressCaption[i][1];
        }
        // ---------------------------------------------------------------------

        context = getApplicationContext();
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy ", Locale.US);
        this.setTitle("News Service\n" + sdf.format(new Date() ) );

        myMainListView = (ListView)this.findViewById(R.id.myListView);
        myMainListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> _av, View _v,
                                    int _index, long _id) {
                String urlAddress = myUrlAddress[_index];
                String urlCaption = myUrlCaption[_index];

                //create an Intent to talk to Activity2
                Intent callShowHeadlines = new Intent(
                        MainActivity.this, ShowHeadlines.class);
                //prepare a Bundle and add the data pieces to be sent
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                callShowHeadlines.putExtras(myData);
                startActivity(callShowHeadlines);
            }
        });

        // bind main category list (Top News, ...) to the the listView
        // show list and get ready for user to click on a category

        adapterMainSubjects = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1 , myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);

    }//onCreate

}