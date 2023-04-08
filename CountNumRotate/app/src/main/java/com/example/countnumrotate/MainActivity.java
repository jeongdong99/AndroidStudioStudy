package com.example.countnumrotate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    TextView result; //outstate로 빼기 위해 밖에 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textcnt);
        Button Up = findViewById(R.id.btnCnt);
        Button reset = findViewById(R.id.btnreset);

        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                result.setText(Integer.toString(count));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                result.setText(Integer.toString(count));
            }
        });

            //rotate 할때 저장
        if(savedInstanceState!=null){ //저장값이 null이 아니라면?
            String strcount = savedInstanceState.getString("saveCount");
            //이전 저장값 key에서 뽑아오기
            if(result != null){
                result.setText(strcount); //textview에 이전 저장값 표현
                count = Integer.valueOf(strcount);
                //이전 저장값 string -> int 해서 count에 저장
            }
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState){ //외부에 저장
        super.onSaveInstanceState(outState);
        outState.putString("saveCount",
                String.valueOf(result.getText()));
    }


    //나갔다가 복구할때
    @Override
    protected void onPause() { //멈췄을때
        super.onPause();

        SharedPreferences myPrefs = getSharedPreferences("mySaveStateArea", MainActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit(); //editor 만들기
        editor.putString("Counter", result.getText().toString()); // editor에 result값 담기
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences myPrefs = getSharedPreferences("mySaveStateArea", MainActivity.MODE_PRIVATE);
        if(myPrefs!=null && myPrefs.contains("Counter")) {  //위에 Counter랑 똑같아야됨
            String uCount = myPrefs.getString("Counter", ""); //uCount에 값 담기
            count = Integer.valueOf(uCount); //count에 int값으로 변환하여 넣기
            result.setText(uCount); //result에 현재값 넣기
        }
    }
    //복구 끝



}