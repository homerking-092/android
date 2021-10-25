package org.ict.tablecalculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    Button plus, minus, mul, div, clear;



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
        clear = findViewById(R.id.clear);

        // 초기화
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("초기화버튼: ","눌림");
                et1.setText(null);
                et2.setText(null);
            }
        });

        // 더하기
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("더하기버튼","눌림");
                int front = Integer.parseInt(et1.getText()+ "");
                int back = Integer.parseInt(et2.getText()+ "");
                int resultCal = front + back;
                result.setText(resultCal + "");

            }
        });

        // 빼기
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("뺴기 버튼: ", "클릭됨");
                int front = Integer.parseInt(et1.getText()+ "");
                int back = Integer.parseInt(et2.getText()+ "");
                int resultCal = front - back;
                result.setText(resultCal + "");
            }
        });
        // 곱하기
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("곱하기버튼","눌림");
                int front = Integer.parseInt(et1.getText()+ "");
                int back = Integer.parseInt(et2.getText()+ "");
                int resultCal = front * back;
                result.setText(resultCal + "");
            }
        });
        // 나누기
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("나누기버튼","눌림");
                int front = Integer.parseInt(et1.getText()+ "");
                int back = Integer.parseInt(et2.getText()+ "");
                int resultCal = front / back;
                if (et2.getText().equals("0")){
                    Toast.makeText(getApplicationContext(),"0으로 나눌수 없습니다",Toast.LENGTH_SHORT);
                    result.setText(back);
                }else {
                    result.setText(resultCal + "");
                }
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
                        // 첫글자 0 방지
                        if ((et1.getText()+ "").equals("0")){
                            et1.setText(numBtns[index].getText());
                            Toast.makeText(getApplicationContext(),"첫번쨰는 0이 올수 없음",Toast.LENGTH_SHORT);
                        }else {
                            // et1에 커서가 깜빡이는(즉 선택된) 경우
                            et1.setText(et1.getText() + "" + numBtns[index].getText());

                        }
                    } else if (et2.isFocused()){
                        // 첫글자 0 방지
                        if ((et2.getText()+ "").equals("0")){
                            et2.setText(numBtns[index].getText());
                        }else {
                            // et2에 커서가 깜빡이는(즉 선택된) 경우
                            et2.setText(et2.getText() + "" + numBtns[index].getText());
                        }

                    }
                }
            });

        }

    }// end onCreate()
}