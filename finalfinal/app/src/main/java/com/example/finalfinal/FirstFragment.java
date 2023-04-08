package com.example.finalfinal;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    View view;
    Button firstButton, secondButton;
    TextView firstTxt;
    int count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // 첫 번째 pram : 화면 설계 파일
        // 미리 설계한 파일을 가지고 inflation 을 통해 view 를 만듦
        // -> mainActivity 에서는 onCreate 에서 setContextView로 만듦

        view = inflater.inflate(R.layout.frag_first, container, false);
        // get the reference of Button

        // [[[[[[[[[[[[ inflation 으로 받아왔으면 밑에 방법으로 요소를 가져옴 ]]]]]]]]]]]]]
        // 원래는 this.findViewById(R.id.firstFragment);인데 this 는 생략 가능

        firstButton = view.findViewById(R.id.secondButton);
        secondButton = view.findViewById(R.id.btnReset);
        firstTxt =  view.findViewById(R.id.txtView);
        // perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                //Toast.makeText(getActivity(), "First Fragment", Toast.LENGTH_LONG).show();
                count++;
                firstTxt.setText("You clicked " + count);
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                firstTxt.setText("You clicked " + count);
            }
        });
        return view;
    }
}