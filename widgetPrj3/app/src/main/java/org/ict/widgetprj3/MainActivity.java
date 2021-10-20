package org.ict.widgetprj3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    TextView view;
    Button btn;
    Boolean bool;   // z클릭할 때마다 색상변경을 위한 if문 처리용 논리변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 초기화
        bool = true;

        // 선언된 창부품
        view = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.btn);

        // 버튼 클릭시, 클자크기는 50, 색상은 파란색, 글꼴 serif
        // 문장은 본인 이름에서 -> xxx조 이름
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 콘솔 디버깅1
                System.out.println("버튼 클릭됨");

                // 콘솔 디버깅2
                Log.i("태그명", "로깅할내용");
                // 토스트 디버깅
                Toast.makeText(getApplicationContext(), "버튼 클릭됨", Toast.LENGTH_SHORT).show();

                if (bool) {
                    view.setText("GAMMA 김영훈");
                    view.setTextSize(50);
                    view.setTextColor(Color.BLUE);
                    view.setTypeface(Typeface.SERIF, Typeface.ITALIC);

                    // 각 로직이 끝날떄마다 반대 논리식으로 바꿔줘야 교대로 실행
                    bool = false;
                }else{

                    view.setTextColor(Color.GREEN);

                    // 각 로직이 끝날떄마다 반대 논리식으로 바꿔줘야 교대로 실행
                    bool = true;
                }
            }
        });





    }
}