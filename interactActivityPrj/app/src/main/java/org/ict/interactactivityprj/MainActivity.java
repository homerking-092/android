package org.ict.interactactivityprj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        submitBtn = findViewById(R.id.submitBtn);

        // 제출버튼 클릭시
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);

                intent.putExtra("edit1", Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("edit2", Integer.parseInt(edit2.getText().toString()));

//                startActivity(intent);
                // 돌아오기를 했을때 추가로 돌려받을 값이 존재할때 사용
                startActivityForResult(intent, 0);
            }
        });

    }// end onCreate()

    // 어플을 처음 켜서 메인화면에 접근된 것이 아니라
    // 계산기 기능을 활용해서 다른 액티비티에 갔다가 결과값을 전닯다아 오는경우를 처리하는 코드
    // onAvtivityResult를 오버라이딩해서 만듦
    // onCreate와 동등한 계층으로 생성
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // RESULT_OK가 들어오는 경우만 화면에 결과값을 표기하도록 처리
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // onActivityResult의 파라미터로 선언된 Intent data라는 명칭으로
            // 아까전 호출한 setResult() 호출시 같이 넘어옴
            int resultNum = data.getIntExtra("resultNum", 0);
            // 가져온 결과물 토스트로 띄우기
            Toast.makeText(getApplicationContext(), resultNum + "", Toast.LENGTH_SHORT).show();

        }

    }

}