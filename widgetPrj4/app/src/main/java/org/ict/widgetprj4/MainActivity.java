package org.ict.widgetprj4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    EditText edit1;
    Button btn1;
    TextView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        edit1 = (EditText)findViewById(R.id.edit1);
        btn1 = (Button)findViewById(R.id.btn1);
        view1 = (TextView)findViewById(R.id.view1);

        // 버튼에 온클릭 설정까지
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println("버튼 클릭됨");
                Log.i("버튼 클릭여부", "클릭됨");

                // EditText 내부 부품값 얻어오기
                 String str = edit1.getText().toString();

                // 얻어온 값 로그로 찍기
                Log.i("editText 값",str);

                // 얻어온 값 토스트로 ㄱㄱ
//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

                // 텍스트뷰에 result 변수에 담긴 값 표출
                view1.setText(str);

            }
        });



    }// end onCreate()
}