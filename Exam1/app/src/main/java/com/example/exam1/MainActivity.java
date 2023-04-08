package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{
    int count = 0;
    TextView countResult;
    String orderText;
    String Menu;
    int sum= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spnChoice);
        countResult = findViewById(R.id.countResult);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        CheckBox coke = findViewById(R.id.plusCoke);
        Button order = findViewById(R.id.orderBtn);
        TextView totalOrder = findViewById(R.id.totalResult);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<5)
                count++;
                countResult.setText(Integer.toString(count));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>1){
                count--;
                countResult.setText(Integer.toString(count));
            }
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderText = "";
                sum = 0;
                if(coke.isChecked()){
                    orderText+="(콜라 추가)";
                    sum+=1000;
                }else{
                    orderText+="(콜라 없음)";
                }

                if(Menu.equals("라면")){
                    sum+=(2000*count);
                }
                else if(Menu.equals("스파게티")){
                   sum+=(3000*count);
                }
                else if(Menu.equals("햄버거")){
                    sum+=(4000*count);
                }
                String strsum = Integer.toString(sum);
                totalOrder.setText(Menu+" "+count+"개"+orderText+"를 주문했습니다.\n 총액은 "+strsum+"원입니다.");
            }
        });

        if(spinner!=null){
            spinner.setOnItemSelectedListener(this); //spinner는 itemSelectedListener!!를 써야됨
        }

    ArrayAdapter<CharSequence> adapter =
            ArrayAdapter.createFromResource(
                    this,R.array.label_array,
                    android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       Menu="";
        if (i == 0) {
           Menu = adapterView.getItemAtPosition(i).toString();
        }
        else if (i == 1) {
            Menu = adapterView.getItemAtPosition(i).toString();
        }
        else if (i == 2) {
            Menu = adapterView.getItemAtPosition(i).toString();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}