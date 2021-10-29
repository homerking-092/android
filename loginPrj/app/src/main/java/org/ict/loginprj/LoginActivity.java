package org.ict.loginprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LoginActivity extends Activity {

    Button moveLogin;
    TextView successText, idText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ArrayList<String> idList = new ArrayList<>();
        idList.add("aaa");
        idList.add("bbb");
        idList.add("ccc");

        moveLogin = findViewById(R.id.moveLogin);
        successText = findViewById(R.id.successText);
        idText = findViewById(R.id.idText);

        // 인텐트 받기
        Intent intent = getIntent();
        String uId = intent.getStringExtra("uId");
        String uPw = intent.getStringExtra("uPw");

        if (idList.contains(uId) && uPw.equals("android")) {
            idText.setText(uId + "님 환영합니다");
            successText.setVisibility(View.VISIBLE);
//            Toast.makeText(getApplicationContext(), "로그인에 성공했습니다", Toast.LENGTH_SHORT);
        } else {
            Intent intent1 = new Intent(getApplicationContext(), loginFailActivity.class);
            startActivity(intent1);
        }

        moveLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
            }
        });


    }
}


