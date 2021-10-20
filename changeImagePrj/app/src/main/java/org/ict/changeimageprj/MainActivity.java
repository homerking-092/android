package org.ict.changeimageprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    TextView text1, text2;
    CheckBox check;
    RadioGroup group;
    RadioButton son1,son2;
    Button btn;
    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);

        check = findViewById(R.id.check);

        group = findViewById(R.id.rg1);

        btn = findViewById(R.id.btn);
        son1 = findViewById(R.id.son1);
        son2 = findViewById(R.id.son2);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // true. false 여부를 체크해야됨
                Log.i("테스트", buttonView.toString());
                Log.i("isChecked",isChecked + "");

                // 클릭해서 true면 어플이 보이게, false면 안보이게 하기 위해
                // if ~ else분기를 작성
                if (isChecked){
                    // ImageView를 제외한 창부품을 보이도록 전환
                    // android:text=""의 기입내용을 바꿀때는 setText()를 썼습니다
                    // android:visibility를 바꿀떄는 setVisibility()를 씁니다
                    text2.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    son1.setVisibility(View.VISIBLE);
                    son2.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                } else {
                    // 창부품이 보이지 않도록 전환
                    text2.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    son1.setVisibility(View.INVISIBLE);
                    son2.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    // 이미지까지 안보이게
                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    // 라디오버튼 선택 해제
                    // 라이도그룹의 모든 선택사항 해체 명령으로 처리가능
                    group.clearCheck();
                }
            }
        });

        // 어떤 사진을 보여줄지는, 위의 어플 요소와는 별개로
        // RadioButton에 뭐가 선택되었나만 가지고 판단해야하기 때문에 따라 지정합니다
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // son1을 찍었나 son2를 찍었나 확인
                // RadioGroup 내부의 RadioButton을 감지할 때는
                // RadioGroup변수.getCheckedRadioButtonId()를 쓰면 선택한 버튼의 ID값이 잡혀옵니다
                int checked = group.getCheckedRadioButtonId();
                Log.i("선택된 버튼: ",checked +"");

                if (checked == 2131231095){
                    Log.i("클릭 대상: ","son1 사진버튼 클릭");
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.INVISIBLE);

                }else if (checked == 2131231096){
                    Log.i("클릭 대상: ","son2 사진버튼 클릭");
                    img2.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}