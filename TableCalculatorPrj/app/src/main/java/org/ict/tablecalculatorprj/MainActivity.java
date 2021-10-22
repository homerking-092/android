package org.ict.tablecalculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언하기
    // 숫자버튼은 인덱스번호 = 실제 버튼에 적힌 번호값이므로
    // 배열로 저장한다

    Button[] numBtns = new Button[10];
    Integer[] numBtnIDs
            = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    // 이외 나머지 요소 선언
    EditText et1, et2;
    TextView result;
    Button plus, minus, mul, div;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 10개 버튼이 0~9까지 숫자로 배정되어 있으므로 반복문 배정
        for(int i = 0; i < 10; i++){
            numBtns[i] = (Button) findViewById(numBtnIDs[i]);
        }

        // 연결하기
        et1 = findViewById(R.id.text1);
        et2 = findViewById(R.id.text2);
        result = findViewById(R.id.result1);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        // 더하기
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String re1 = et1.getText().toString();
                String re2 = et2.getText().toString();

                result.setText(re1 + re2);

            }
        });

        // 빼기
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // 곱하기
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // 나누기
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // 부품 배열에 대해서는 이벤트까지 반복문으로 겁니다
        for (int i = 0; i < numBtns.length; i++){
            final int index;    // 상수를 하나 선언해줘야 이벤트가 정상적으로 걸림
            index = i;

            numBtns[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("눌린버튼: ",numBtns[index].getText() + "");

                    // 포커스된 EditText에 숫자 입력하기
                    if (et1.isFocused()){
                        // et1에 커서가 깜빡이는(즉 선택된) 경우
                        et1.setText(numBtns[index].getText());
                    } else if (et2.isFocused()){
                        // et2에 커서가 깜빡이는(즉 선택된) 경우
                        et2.setText(numBtns[index].getText());
                    }
                }
            });

        }

    }// end onCreate()
}