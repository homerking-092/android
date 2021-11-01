package org.ict.listview2prj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    Button btn1;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        btn1 = findViewById(R.id.btn1);
        lv1 = findViewById(R.id.lv1);

        // 리스트 생성
        // 리스트로 올 수 있는것은 배열([]), ArrayList등
        // 라변적으로 변동을 주기 위해서는 ArrayList가 옵니다
        final ArrayList<String> trips = new ArrayList<String>();

        // 위의 목록을 토대로 자료가 들어갈 Adapter 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, trips);

        lv1.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn1 클릭시, edit1에 있던 요소를 ArrayList에 .add()로 넣습니다
                String add = edit1.getText().toString();
                Log.d("추가목록: ", add);
                trips.add(add);
                Log.d("목록", trips.toString());

                // 어댑터에 추가된 리스트로 갱신 반영해주기
                Log.d("어댑터", adapter.toString());
                adapter.notifyDataSetChanged();
            }
        });

        // 삭제는 추가된 요소를 길게 클릭하면(Long click) 삭제되도록 처리
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 위쪽 파라미터들을 토대로 trips.remove()를 이용해
                // 길게 클릭한 요소가 삭제되게 완성
                trips.remove(position);
                adapter.notifyDataSetChanged();     // 삭제된 리스트를 어댑터에 반영
                edit1.setText(null);        // editText 초기화

//                edit1.getText().clear();
                // false로 두면 됨
                return false;
            }
        });

    } // end onCreate()
}