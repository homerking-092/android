package org.ict.HelloAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 창부품
    Button button1, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼들 인식
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        // button1 클릭시 이벤트 연결
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            // 실제로 일어나는 이벤트는 onClick 메서드 내부에
            public void onClick(View v){
                Toast.makeText( getApplicationContext(), "버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
            }
        });

        // button2 클릭시 이벤트 연결
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            // 실제로 일어나는 이벤트는 onClick 메서드 내부에
            public void onClick(View v){
                Toast.makeText( getApplicationContext(), "버튼2을 눌렀습니다", Toast.LENGTH_SHORT).show();
            }
        });


    }// end onCreate2()
}