package org.ict.lottoprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> list = new ArrayList<>(); // 번호담은 배열
                Integer num = 0;                        // 번호 초기화

                while (list.size() < 6){
                    /// 처음 하나 뽑고
                    num = (int)(Math.random() * 45) + 1;
                    if (!list.contains(num)){   /// 처음 뽑은 숫자가 아니면
                        list.add(num);          /// 추가
                    }
                }
                Collections.sort(list);     /// 리스트 그대로 정렬
//                String str = Arrays.toString(list.toArray());
//                for (int i =0; i < str.length(); i++){
//                    text1.setText(str);
//                }
                String str = list.toString();
                str = str.replace("[","");
                str = str.replace("]","");
                text1.setText("추첨번호: " + str);


                ////////////////////////// 2등 번호
                boolean bl = true;
                while (bl){
                    num = (int)(Math.random() * 45) + 1;
                    if (!list.contains(num)){
                        text2.setText("2등 번호: "+num.toString());
                        bl = false;
                    }
                }
            }
        });



    }
}