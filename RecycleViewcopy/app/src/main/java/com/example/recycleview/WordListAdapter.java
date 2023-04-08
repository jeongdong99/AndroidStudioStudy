package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LayoutInflater mInflater;
    private final ArrayList<String> mWordList;

    public WordListAdapter(Context context,
                           ArrayList<String> wordList){
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    //중요
    public class WordViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;


        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            // findViewById 앞에 itemView가 붙은 이유
            // viewHolder 하나를 보여주기 위한 화면 설계를 하였고 viewHold의 textView 객체를 받아오는 방법으로
            // 즉, viewHolder의 itemView의 item 하나에 대해서 가져오기 위해
            // 그래서 parameter에서도 View itemView임
            wordItemView = itemView.findViewById(R.id.word);
            // 만약에 버튼 하나를 가져온다고 하면
            // wordButtonView = itemView.findViewById(R.id.btn);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // get the position of the item that was clicked
            int mPosition = getLayoutPosition();
            //use that tp access tje affected item in wordlist
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition,"Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }
    }//

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //oncreate
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false); //main이랑 비슷
        return new WordViewHolder(mItemView, this);
    } //뷰 객체 하나

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) { //data와 연결
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent); //데이터를 채워줌
        // (바로 위 라인에 대하여) 앞에 holder 객체를 반드시 넣어줘야 된다.
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}