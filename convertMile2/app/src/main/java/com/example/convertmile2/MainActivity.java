package com.example.convertmile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt = findViewById(R.id.editText);
        Button btn= findViewById(R.id.btnconvert);
        TextView result = findViewById(R.id.result);

        edt.setHint("Your name here"); //빈칸에 힌트

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = Float.parseFloat(edt.getText().toString()) * 1.6f; //float형태로
                result.setText(Float.toString(input)); //float형태의 매개변수를 string형태로
            }
        });





    }
}