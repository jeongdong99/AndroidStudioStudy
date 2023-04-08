package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener { //adapterview 상속받기, 함수 import 해야됨
    TextView txtview;
    /*list관련 데이터셋*/
    String localDataSet[] = {
            "What",
            "Next",
            "week",
            "mid-term",
            "exam",
            "I do not",
            "Wow",
            "painful",
            "forget"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spnChoice);
        txtview = findViewById(R.id.txtResult);

        if(spinner!=null){
            spinner.setOnItemSelectedListener(this); //spinner는 itemSelectedListener!!를 써야됨
        }
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource( //arrayAdapter 초기 설정
                        this,R.array.label_array, //배열 넣기
                        android.R.layout.simple_spinner_item); //배열띄워줄 화면 구성

        // R.layout.spinner_radio도 가능 spinner 레이아웃 바꿀수 있음
        // adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        // 한개만 고르기
                spinner.setAdapter(adapter); //spinner에 adapter 적용

    /*list관련*/
    ListView listview = findViewById(R.id.listview);
    TextView listResult = findViewById(R.id.listResult);

    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //list는 setOnItemClickListener!!를 사용해야됨
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            listResult.setText("You selected " + localDataSet[i]);

        }
    });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item,localDataSet);
        listview.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();
    }


    /* checkmode
    lstView.setChoiceMode(2);  //oncreate
   listview.setItemChecked(position, listview.isItemChecked(position)); //onclick
    setListAdapter(new ArrayAdapter<String>(this,     //adapter
 android.R.layout.simple_list_item_checked, presidents));
     */


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
    String spinner_item =
            adapterView.getItemAtPosition(pos).toString();
    txtview.setText(spinner_item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
