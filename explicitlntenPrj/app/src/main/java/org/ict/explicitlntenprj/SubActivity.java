package org.ict.explicitlntenprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SubActivity extends Activity {

    // 부품선언
    Button cancelBtn, moveSub2;
    TextView message;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        // 부품 연결
        cancelBtn = findViewById(R.id.cancelBtn);
        message = findViewById(R.id.message);
        moveSub2 = findViewById(R.id.moveSub2);

        // 보내온 인텐트를 받는 순서는
        // 1. 인텐트 자체를 변수에 저장합니다
        // getIntent()를 하면 보내온 인텐트를 받아올 수 있습니다
        Intent intent = getIntent();

        // 2. 인텐트 내부에 실려서 같이 들어온 데이터를 뽑아냅니다
        // intent.get자료형Extra("호출명")을 적으면 됩니다
        String getData = intent.getStringExtra("et1");

        // 3. 받아온 데이터를 활용합니다
        message.setText(getData);

        intent.putExtra("message", message.getText().toString());

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        moveSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SubActivity2.class);
                // Intent는 이미 새성되어 있으므로 new로 매번 항당하는것이 메모리 낭비
                // 따라서, 아래와 같이 기존 인텐트의 목적지만 수정해서 사용하는것이 효율적
                intent.setClass(getApplicationContext(), SubActivity2.class);

                intent.putExtra("message", message.getText().toString());
                startActivity(intent);
            }
        });


    }
}
