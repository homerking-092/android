package org.ict.photomenuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 부품 선언
//    LinearLayout outLayout;
    ImageView image;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 부품 연결
//        outLayout = findViewById(R.id.outLayout);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);

        setTitle("FA 명단");
    }

    // 창 생성시 처리할 옵션
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

//         menu.add(0,1,0,"손흥민");
//         menu.add(0,2,0,"음바페");
//         menu.add(0,3,0,"홀란드");

        // 현 레이아웃에 메뉴적용을 위해 인플레이터 생성
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);

         return true;
    }

    // 메뉴 클릭시 반응하게 만들기
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        Log.d("버튼 아이디: ",item.getItemId() + "");

        // 자바코드
//        if (item.getItemId() == 1){
//            image.setImageResource(R.drawable.a);
////            name.setText("손흥민");
//        }else if (item.getItemId() == 2){
//            image.setImageResource(R.drawable.d);
////            name.setText("음바페");
//        }else if (item.getItemId() == 3){
//            image.setImageResource(R.drawable.e);
////            name.setText("홀란드");
//        }

        if (item.getItemId() == R.id.son){
            image.setImageResource(R.drawable.a);
//            name.setText("손흥민");
        }else if (item.getItemId() == R.id.mb){
            image.setImageResource(R.drawable.d);
//            name.setText("음바페");
        }else if (item.getItemId() == R.id.haal){
            image.setImageResource(R.drawable.e);
//            name.setText("홀란드");
        }

        return true;
    }
}