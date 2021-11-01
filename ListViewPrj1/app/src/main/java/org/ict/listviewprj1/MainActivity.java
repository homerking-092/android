package org.ict.listviewprj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 리스트뷰 선언
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리스트뷰 연결
        lv1 = findViewById(R.id.lv1);

        // 리스트뷰에 적용할 목록
        // 여행지 15개
        final String[] trips = {"마드리드", "밀라노", "런던", "더블린", "괌", "시드니", "후쿠오카", "세부",
                "방콕", "제주도", "발리", "베이거스", "토론토", "베를린", "뮌헨"};

        // 리스트뷰는 AdapterView를 상속해 만들어졌음
        // 생성시 .xml화면(this를 주면 자동으로 setContentView에서 설정파일로 잡힙니다)
        // 스타일, 그리고 출력자료를 파라미터로 순서대로 넣습니다
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, trips);

        // lv1에 adapter 내용을 적용
        lv1.setAdapter(adapter);

        // 위임식 클릭 이벤트 처리
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("parent 확인: ", parent + "");
//                Log.d("view 확인: ", view + "");
                Log.d("position 확인: ", position + "");
//                Log.d("id 확인: ", id + "");

                // 인덱스번호를 이용해 클릭하면 Toast 형태로
                // 클릭한 도시명이 뜨도록 ㄱㄱ
                Toast.makeText(getApplicationContext(), trips[position] + "", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("trip", trips[position]);
                intent.putExtra("position", position);      // 국기

                startActivity(intent);
            }
        }); // end lv.1 event


    } // end onCreate()
}