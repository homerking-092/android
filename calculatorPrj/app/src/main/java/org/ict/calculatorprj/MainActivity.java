package org.ict.calculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    TextView tv1, tv2;
    Button btn1, btn2, btn3, btn4;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.edit1);     // 숫자1
        edit2 = (EditText)findViewById(R.id.edit2);     // 숫자2

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);         // 계산결과

        btn1 = (Button)findViewById(R.id.btn1);         // 더하기
        btn2 = (Button)findViewById(R.id.btn2);         // 빼기
        btn3 = (Button)findViewById(R.id.btn3);         // 곱하기
        btn4 = (Button)findViewById(R.id.btn4);         // 나누기

        // 더하기
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("버튼 눌림: ","더하기");
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Log.i("num1: ",num1);
                Log.i("num2: ",num2);

                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                Log.i("결과: ",result.toString());
                tv2.setText(result.toString());
                edit1.setText(null);
                edit2.setText(null);
            }

        });

        // 뺴기
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("버튼 눌림: ","빼기");

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tv2.setText(result.toString());
                edit1.setText(null);
                edit2.setText(null);
            }
        });


        // 곱하기
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("버튼 눌림: ","곱하기");
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tv2.setText(result.toString());
                edit1.setText(null);
                edit2.setText(null);
            }
        });

        // 나누기
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("버튼 눌림: ","나누기");
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                tv2.setText(result.toString());
                edit1.setText(null);
                edit2.setText(null);
            }
        });

    }
}