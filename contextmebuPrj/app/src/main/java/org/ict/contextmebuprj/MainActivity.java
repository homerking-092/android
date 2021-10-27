package org.ict.contextmebuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    LinearLayout bgl;
    Button backBtn, changeBtn;
    float degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        bgl = findViewById(R.id.bgl);
        backBtn = findViewById(R.id.backBtn);
        changeBtn = findViewById(R.id.changeBtn);

        // backBtn, changeBtn을 클릭했을때 컨텍스트 메뉴가 뜨도록 연결
        registerForContextMenu(backBtn);
        registerForContextMenu(changeBtn);

    }// end onCreate()

    // 각각 버튼을 클릭했을때 menu1, menu2가 조건에 맞게 표출되도록 설정
    // onCreateContextMenu를 Override를 통해 구현
    // 상단 code -> Override Methods
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // 메뉴 생성을 위해 Inflater 생성
        MenuInflater mInflater = getMenuInflater();
        Log.d("태그: ", v + "");

        // v는 추가한 registerForContextMenu에 등록된 요소입니다
        // 롱클릭이므로 길게 눌러야 메뉴가 나옴
        if (v == backBtn){
            // backBtn에는
            mInflater.inflate(R.menu.menu1, menu);
        }else  if (v == changeBtn){
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    // menu1, menu2 내부의 옵션을 클릭했을때 실행한 내용들은
    // onContextItemSeleted를 Override를 통해 구현
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);

        if (item.getItemId() == R.id.backRed){
            bgl.setBackgroundColor(Color.RED);
        }else if (item.getItemId() == R.id.backBlue){
            bgl.setBackgroundColor(Color.BLUE);
        }else if (item.getItemId() == R.id.backGreen){
            bgl.setBackgroundColor(Color.GREEN);
        }else if (item.getItemId() == R.id.backYellow){
            bgl.setBackgroundColor(Color.YELLOW);
        }else if (item.getItemId() == R.id.upSize){
            changeBtn.setScaleX(2);
        }else if (item.getItemId() == R.id.rotate){
            degree = degree + 45;
            changeBtn.setRotation(degree);
        }


        return true;
    }
}