package org.ict.movieprj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import org.ict.movieprj.VO.DailyBoxOffice;
import org.ict.movieprj.VO.Example;
import org.ict.movieprj.retrofit.MovieAdapter;
import org.ict.movieprj.retrofit.RetrofitClient;
import org.ict.movieprj.retrofit.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // 비동기 요청을 담당하는 Retrofit 관련 변수들 선언
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    // 리사이클러뷰 부품 선언
    RecyclerView recyclerView;
    // 리사이클러 어댑터 부품 선언
    RecyclerView.Adapter mAdapter;

    // 비동기 요청 이벤트를 발동시킬 버튼 선언
//    Button asyncBtn;

    // 상수로 본인 key값을 저장
    final String KEY = "01f522d57ddd1ebf9dcba06271a540e4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼 연결
//        asyncBtn = findViewById(R.id.asyncBtn);

        // 레트로핏 요소들도 모두 연결
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = retrofitClient.getRetrofitInterface();

        // 라사이클러뷰 요소를 먼저 연결합니다
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        // 리사이클러뷰는 레이아웃 설정을 자바쪽에서 받아야 표현됩니다
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);


        // 화면이 켜졌을떄 비동기 요청으로 데이터를 받아오고,
        // 받아온 데이터를 리사이클러 뷰 내부에 세팅하도록 처리
        retrofitInterface.getBoxOffice(KEY, "20211101")
                .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        // 비동기 요청 성공시 처리할 내영
                        // 비동기 데이터 저장
                        Example result = response.body();
                        // result 내부의 영화정보를 얻어서 MovieAdapter 생성자에 전달
                        mAdapter = new MovieAdapter(result.getBoxOfficeResult().getDailyBoxOfficeList());
                        // 리사이클러 뷰에 MovieAdapter를 전달해서
                        // 카드뷰 양식으로 반복하도록 처리
                        recyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        // 비동기 요청 실패시 처리할 내역
                        Log.d("요청실패","요청실패했습니다");
                    }

                });



    }// end onCreate()
}