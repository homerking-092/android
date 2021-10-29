package org.ict.explicitlntenprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SubActivity2 extends Activity {

    TextView message2;
    Button moveMain, cancelBtn2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        // 부품 연결
//        cancelBtn = findViewById(R.id.cancelBtn);
        message2 = findViewById(R.id.message2);
        moveMain = findViewById(R.id.moveMain);
        cancelBtn2 = findViewById(R.id.cancelBtn2);

        // 보내온 인텐트를 받는 순서는
        // 1. 인텐트 자체를 변수에 저장합니다
        // getIntent()를 하면 보내온 인텐트를 받아올 수 있습니다
        Intent intent = getIntent();

        // 2. 인텐트 내부에 실려서 같이 들어온 데이터를 뽑아냅니다
        // intent.get자료형Extra("호출명")을 적으면 됩니다
        String getData = intent.getStringExtra("message");

        // 3. 받아온 데이터를 활용합니다
        message2.setText(getData);

        moveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        cancelBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }
}
