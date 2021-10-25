package org.ict.pickerprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    DatePicker calendar;
    Button btn1, btn2;
    TextView text1, text2;

    // 전역변수 날짜정보
    Integer yearInt, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        calendar = findViewById(R.id.calendar);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        // 날짜 처리는 날짜가 변할때마다 변수에 담는것으로 처리힙니다
        // 창이 열리자마자 가져오게 할떄는 calendar.getYear(), /getMonthOfYear()등을 활용

        calendar.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view,
                                      int year,
                                      int monthOfYear,
                                      int dayOfMonth) {
                yearInt = year;
                month = monthOfYear + 1;
                day = dayOfMonth;
                int days = yearInt + month + day;
                Log.d("날짜", year + "년/" + (monthOfYear + 1) + "월/" + dayOfMonth + "일");

            }
        });

        // 체크인 버튼
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text1.setText(yearInt+"/" +month + "/" + day);
            }
        });

        // 체크아웃 버튼
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int year = calendar.getYear();
//                int mon = calendar.getMonth() + 1;
//                int day = calendar.getDayOfMonth();

                text2.setText(yearInt+"/" +month + "/" + day);
            }
        });


    }// end onCreate()
}