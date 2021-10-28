package org.ict.dialogprj2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 창부품 추가
    TextView userNameTv, userEmailTv;
    Button btn1;
    EditText userName, userEmail;
    View model;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 부품 연결
        userNameTv = findViewById(R.id.userNameTv);
        userEmailTv = findViewById(R.id.userEmailTv);
        btn1 = findViewById(R.id.btn1);
        ///
//        userName = findViewById(R.id.userName);
//        userEmail = findViewById(R.id.userEmail);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭하면 모달창 같이 userinfo.xml이 열려야 합니다
                // 다이얼로그 생성및 설정 후 .show()로 보여주는데
                // 단, dialog의 형태를 userinfo.xml에 정의해 뒀으므로
                // xml파일을 화면으로 가져오는 inflate() 기능을 활용합니다
                // View 타입을 이용해야 추가 커스텀 창을 정의할 수 있습니다
                model = View.inflate(MainActivity.this, R.layout.userinfo, null);   // userinfo.xml을 Main에 처리

                // View를 다이어로그로 변환
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(model);
                // 확인, 취소버튼 추가
                // 1. Negative버튼(확인버튼) 클릭시 이벤트 발동
                // 2. EditText 2개를 MainActivity에 연결
                // 3. EditText에 있던 요소를 .getText()로 가져와서
                // 4. TextView에 찍히게 ㄱㄱ
                dlg.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소됨", Toast.LENGTH_LONG).show();

                    }
                });
                // 확인
                dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // inflate로 만든 커스텀 창의 위젯은
                        // model 명의로 연결해야 합니다
                        userName = (EditText) model.findViewById(R.id.userName);
                        userEmail = (EditText) model.findViewById(R.id.userEmail);

                        String a = userName.getText().toString();
                        String b = userEmail.getText().toString();
                        userNameTv.setText(a);
                        userEmailTv.setText(b);

                        Toast.makeText(MainActivity.this, "확인됨", Toast.LENGTH_LONG).show();

                    }
                });

                dlg.show();
            }
        });


    }// end onCreate()
}