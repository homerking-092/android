package org.ict.menuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    // 리니어 레이아웃 1개, 버튼 1개
    LinearLayout outLayout;
    Button btn1;
    float degree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        outLayout = findViewById(R.id.outLayout);
        btn1 = findViewById(R.id.btn1);

        setTitle("화면상단 이름 바꾸기");
    }

    // 외부 xml파일 추가로등록하기
    // 커서를 onCreate 바깥에 둔 다음 상단의 code -> Override Methods를 선택하고,
    // onCreateOptionsMenu를 선택해 주세요

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 자바 코드로 처리하기 위해 기존 코드 주석
//        // 메뉴 추가를 위해 inflater를 활용
//        MenuInflater mInflater = getMenuInflater();
//        // 기존 레이아웃에 메뉴 삽입
//        // .inflate(리소스 폴더 내 xml파일 지정, menu);
//        mInflater.inflate(R.menu.menu1, menu);

        menu.add(0,1,0,"배경을 빨강으로 바꾸기");
        menu.add(0,2,0,"배경을 노랑으로 바꾸기");
        menu.add(0,3,0,"배경을 초록으로 바꾸기");
        menu.add(0,4,0,"배경을 파랑으로 바꾸기");
        menu.add(0,5,0,"배경을 보라로 바꾸기");


        // 서브메뉴 추가
        SubMenu sMenu = menu.addSubMenu("서브메뉴명");
        sMenu.add(0,6,0,"버튼 45도 회전");
        sMenu.add(0,7,0,"버튼 2배");



       return true;
    }

    // 옵션 요소가 선택되었을때 실행할 코드 추가
    // code -> override Methods를 선택하고
    // onOptionsItemSeleted()를 자동완성 시킨 후 item.getItemId() 디버깅 먼저 ㄱㄱ

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        Log.d("디버깅: ", item.getItemId() + "");

        if (item.getItemId() == 1){         // 디버깅해서 아이템 아이디 분별
            outLayout.setBackgroundColor(Color.RED);
        } else if (item.getItemId() == 2){    // 노란색 id 가져와서 분별별
           outLayout.setBackgroundColor(Color.YELLOW);

        } else if (item.getItemId() == 3){
            outLayout.setBackgroundColor(Color.GREEN);
        } else if (item.getItemId() == 4) {
            outLayout.setBackgroundColor(Color.BLUE);
        } else if (item.getItemId() == 5){
            outLayout.setBackgroundColor(Color.BLACK);
        } else if (item.getItemId() == 6){
//            btn1.setRotation(45);
            // 45도 고정이 아닌 45도씩 돌아가도록 로직 수정
            degree = degree + 45;
            btn1.setRotation(degree);


        } else if (item.getItemId()== 7){
            btn1.setScaleX(2);
        }

        return  true;
    }
}