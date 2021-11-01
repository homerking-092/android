package org.ict.interactactivityprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SubActivity extends Activity {

    Button returnBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        returnBtn = findViewById(R.id.returnBtn);

        // 인텐트에 들어있는 숫자 2개를 변수에 저장
        // startActivityForResult는 defaultValue(값이 안들어오면 대신 받을값)을 설정해줘야 함
        Intent intent = getIntent();
        int edit1 = intent.getIntExtra("edit1", 0);
        int edit2 = intent.getIntExtra("edit2", 0);
//        int edit1 = Integer.parseInt(intent.getStringExtra("edit1"));
//        int edit2 = Integer.parseInt(intent.getStringExtra("edit2"));

        // Mainㅇ서 보낸 두 숫자를 합한 결과값을 Sub에서 처리
        int resultNum = edit1 + edit2;

        // return 버튼 클릭시
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 종료시 돌려보낼 값은, 목적지가 MainActivity인 인텐트를 다시 만들어서 보내줍니다
                Intent returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                returnIntent.putExtra("resultNum", resultNum);
                // 입력된 값은 setReulst로 보내고, RESULT_OK는 상수 -1 입니다
                // setResult에 감딘 인텐트는 뒤로가기시 main쪽에 연결됩니다
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }// end onCreate()




}
