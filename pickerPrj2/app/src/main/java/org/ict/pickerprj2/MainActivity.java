package org.ict.pickerprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TimePicker tPicker;
    DatePicker dPicker;
    Button btn1, btn2;
    TextView text1, text2;

//    int yearInt, month, day, hour, minuteInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tPicker = findViewById(R.id.tPicker);
        dPicker = findViewById(R.id.dPicker);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

//        dPicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view,
//                                      int year,
//                                      int monthOfYear,
//                                      int dayOfMonth) {
//                yearInt = year;
//                month = monthOfYear + 1;
//                day = dayOfMonth;
//                int days = yearInt + month + day;
//                Log.d("날짜", year + "년/" + (monthOfYear + 1) + "월/" + dayOfMonth + "일");
//
//            }
//        });

//        tPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                hour = hourOfDay;
//                minuteInt = minute;
//            }
//        });

        // 출근
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 시간을 얻어서 text1에 출력(연월일시분)
                int year = dPicker.getYear();
                int month = (dPicker.getMonth() + 1);
                int day = dPicker.getDayOfMonth();
                int hour = tPicker.getHour();
                int minute = tPicker.getMinute();

                text1.setText(year + "년/" + (month + 1) + "월/" + day + "일/" + hour + "시/" + minute + "분" );
                // 2, btn2와 활상화상태로 만들고, btn1은 못쓰게 만들어야함
                btn2.setEnabled(true);
                btn1.setEnabled(false);
            }
        });

        // 퇴근
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 현재 시간 얻어오기
                long now = System.currentTimeMillis();
                Date date = new Date(now);

                // 1. 시간을 얻어서 dPicker, tPicker에 갱신
                dPicker.updateDate((date.getYear()+ 1900),
                                  (date.getMonth()),
                                    date.getDate());
                tPicker.setHour(date.getHours());
                tPicker.setMinute(date.getMinutes());

                int year = dPicker.getYear();
                int month = (dPicker.getMonth() + 1);
                int day = dPicker.getDayOfMonth();
                int hour = tPicker.getHour();
                int minute = tPicker.getMinute();

                text2.setText(year + "년/" + (month ) + "월/" + day + "일/" + hour + "시/" + minute + "분" );
                // 2, btn2와 활상화상태로 만들고, btn1은 못쓰게 만들어야함
                btn2.setEnabled(false);

            }
        });

    }
}