package org.ict.widgetprj7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer ch;
    Button start, stop, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ch = findViewById(R.id.cm);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);

        // 시작버튼
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.start();
            }
        });

        // 정지버튼
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.stop();
            }
        });

        // 초기화버튼
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.stop();  //초기화 후 정지까지
            }
        });

    }// end onCreate()
}