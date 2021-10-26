package org.ict.widgetprj9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    // 부품생성

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // 부품 연경
        // 뷰플리퍼는 final로 선언해야 제대로 돌아가기 떄문에 onCreate 안쪽에 선언
        // 다른 부품들은 일반적으로 선언 위치를 따로 정해져 있지 않습니다
        final ViewFlipper vf1;
        vf1 = findViewById(R.id.vf1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf1.showPrevious();     // 전 페이지 넘어가기
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf1.showNext();     // 다음페이지 이동
            }
        });

    }// end onCreate()
}