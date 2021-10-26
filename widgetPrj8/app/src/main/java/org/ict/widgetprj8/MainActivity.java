package org.ict.widgetprj8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 자동완성 관련 부품 선언
    AutoCompleteTextView acv;
    MultiAutoCompleteTextView macv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 자동완성 부품 연결
        acv = (AutoCompleteTextView) findViewById(R.id.acv);
        macv = (MultiAutoCompleteTextView) findViewById(R.id.macv);

        // 검색창에 띄울 아이템들 나열
        String[] items = {"aos", "fps", "survival", "battle", "action", "strategy"};

        // 부품과 데이터를 연결하기 위해 "어댑터"라는 개념이 등장
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);

        // setAdapter() 기능을 이용해 ArrayAdapter와 부품 연결
        acv.setAdapter(adp);

        // mac 연결해서 확인 ㄱㄱ
        // String 배열 내부 자료들을 ,로 하나하나 구분해 인식할 수 있도록 토크나이저를 같이 세팅해줘야 장성적으로 작동
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        macv.setTokenizer(token);

        // 토크나이징을 통해 쉼표로 자료등을 구분한다
        macv.setAdapter(adp);
    }
}