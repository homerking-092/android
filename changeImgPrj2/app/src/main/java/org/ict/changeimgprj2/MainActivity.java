package org.ict.changeimgprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    TextView tv1;           // 텍스트 "사진목록"
    Switch sch;             // off/on 스위치
    RadioGroup group;       // 라디오버튼 그룹
    RadioButton btn1, btn2; // 라디오버튼 1, 2
    ImageView img1;         // 이미지뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        tv1 = findViewById(R.id.content1);
        sch = findViewById(R.id.switch1);
        group = findViewById(R.id.group);
        btn1 = findViewById(R.id.rb1);
        btn2 = findViewById(R.id.rb2);
        img1 = findViewById(R.id.img1);


        sch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("디버깅",isChecked +"");

                // 스위치가 on이라면 요소들 보이기
                if (isChecked){
                    tv1.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.VISIBLE);

                } else {
                    // 스위치 off라면 요소들 안보이기
                    tv1.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                }

                // 1. btn1, btn2에 onclick 이벤트를 걸어서 처리
                // 2. rg1을 이용해서 btn1, btn2중 어떤게 클릭되었는지 감지해 처리
                // 밑 로직은 2를 이용 cf> 1은 changeImgPrj 참고
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        img1.setImageResource(R.drawable.a);
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        img1.setImageResource(R.drawable.b);
                    }
                });




            }
        });

    }
}