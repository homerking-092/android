package org.ict.implicitlntentprj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // 창부품 선언
    Button btnCall, btnWeb, btnGoo, btnSearch, btnSms, btnPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 창부품 연결
        btnCall = findViewById(R.id.btnCall);
        btnWeb = findViewById(R.id.btnWeb);
        btnGoo = findViewById(R.id.btnGoo);
        btnSearch = findViewById(R.id.btnSearch);
        btnSms = findViewById(R.id.btnSms);
        btnPhoto = findViewById(R.id.btnPhoto);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                // 보낸적 없는 전화번호가 같이 달려서 넘어갑니다
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnGoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("버튼클릭: ","구글열기");
                Uri uri = Uri.parse("https://www.google.com/maps/place/%ED%95%9C%EA%B5%ADICT%EC%9D%B8%EC%9E%AC%EA%B0%9C%EB%B0%9C%EC%9B%90/@37.5548129,126.918354,17z/data=!3m1!4b1!4m5!3m4!1s0x357c99b56609aa51:0xa1bd0b6d813b1eda!8m2!3d37.5548129!4d126.9205427");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("버튼클릭: ","검색하기");
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세요");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-5678")));
                startActivity(intent);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

    } // end onCreate()
}