package org.ict.dialogprj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 부품 연결
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 선택지는 리스트로 관리합니다
                final String[] sList = new String[]{"sony", "mbappe", "haaland"};
                // 대화상자 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                // 설정
                dlg.setTitle("FA 명단");
                dlg.setIcon(R.drawable.ic_launcher_background);
                // 선택지는 위의 list를 반복문으로 반복해서 넣어줍니다
                // setItems는 단순 선택지이기 때문에 선택해야 할것처럼 안보입니다
                dlg.setItems(sList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 눌린것은 int which로 감지합니다
                        Toast.makeText(MainActivity.this, sList[which] + "", Toast.LENGTH_SHORT).show();
                    }
                });

                // setSIngleChoiceItems는 라디오 버튼입니다
//                dlg.setSingleChoiceItems(sList, 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, sList[which]+"", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dlg.setPositiveButton("닫기", null);
//                // .show()로 화면 출력
//                dlg.show();
//            }
//        });

                // 체크박스 형식은 선택됨/안됨 여부를 true/false로 처리
                final boolean[] checkArray = {true, true, false};
                dlg.setMultiChoiceItems(sList, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // ~~체크됨, ~~체크해제됨 이라고 뜨도록 토스트 설정
                        Log.d("클릭요소상태", sList[which] + "," + isChecked);
                        if (isChecked) {
                            Toast.makeText(MainActivity.this, sList[which] + "체크됨", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, sList[which] + "체크해제됨", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });


        // 선택지 없는 안내창   ////////////////////////
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 다이얼로그 생성
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//
//                dlg.setTitle("제목을 적으세요");
//                dlg.setMessage("띄울 메세지를 적으세요");
//                dlg.setIcon(R.drawable.ic_launcher_background);
//
//                // 확인버튼 추가
//                // dlg.setPositiveButton("확인", null);
//                // 확인버튼 눌렀을 떄 이벤트까지 거는 겨웅 두번쨰 파라미터에 new D까지 적고
//                // 자동완성하면 온클릭 이벤트를 추가로 걸수 있습니다
//                dlg.setNegativeButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "확인함", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                // 취소버튼 추가
//                dlg.setPositiveButton("취소", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "취소됨", Toast.LENGTH_LONG).show();;
//                    }
//                });
//
//                // 모든 세팅이 끝나면 화면출력
//                dlg.show();
//            }
//        });

    }// end onCreate()
}