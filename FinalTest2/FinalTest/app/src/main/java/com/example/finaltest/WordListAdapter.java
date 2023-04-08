package com.example.finaltest;
import android.app.SearchManager;
import android.content.Context;

import android.content.Intent;
import android.graphics.drawable.Drawable;

import android.net.Uri;
import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;

import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.MyViewHolder> {

    private List<Items> itemsList;
    Context mContext;

    WordListAdapter(Context cxt, List<Items> mItemList){

        mContext = cxt;

        this.itemsList = mItemList;

    }


    @Override

    public WordListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_row,parent,false);

        return new MyViewHolder(view);

    }



    @Override

    public void onBindViewHolder(WordListAdapter.MyViewHolder holder, int position) {
        final Items item = itemsList.get(position);

        holder.name.setText(item.getNameStr()); //
        holder.email.setText(item.getEmailStr());
        holder.phone.setText(item.getPhoneStr());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public TextView name;
        public TextView email;
        public TextView phone;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameText); //텍스트전체
            email = itemView.findViewById(R.id.emailText);
            phone = itemView.findViewById(R.id.phoneText); //이미지뷰
            //itemView.setOnClickListener(this); 아이템 전체에 대한 리스너
            name.setOnClickListener(this);
            email.setOnClickListener(this);
            phone.setOnClickListener(this);
        }

        @Override

        public void onClick(View view) {
            //String ss="";
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            switch ( view.getId() ) {
                case R.id.nameText: // ss = "name";
                    /*
                    // search method 1
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, itemsList.get(mPosition).getTitle()); // query contains search string
                    // search method 2
                    try {
                        String eQuery = URLEncoder.encode(itemsList.get(mPosition).getTitle(), "UTF-8");
                        Uri uri = Uri.parse("http://www.google.com/search?q=" + eQuery);
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    mContext.startActivity(intent);*/
                    break;

                case R.id.emailText: //) ss = "image ";
                    /*
                    Intent sintent=new Intent(mContext,ImageActivity.class);
                    sintent.putExtra("image", itemsList.get(mPosition).getImageID());
                    sintent.putExtra("mydata", "if you need more");

                    mContext.startActivity(sintent);*/
                    break;
                case R.id.phoneText: // ss = "name";
                    /*
                    // search method 1
                    Intent kintent = new Intent(Intent.ACTION_WEB_SEARCH);
                    kintent.putExtra(SearchManager.QUERY, itemsList.get(mPosition).getTitle()); // query contains search string
                    // search method 2
                    try {
                        String eQuery = URLEncoder.encode(itemsList.get(mPosition).getTitle(), "UTF-8");
                        Uri uri = Uri.parse("http://www.google.com/search?q=" + eQuery);
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    mContext.startActivity(kintent);*/
                    break;
            }
        }
    }
}
