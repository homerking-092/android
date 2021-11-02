package org.ict.movieprj.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // 필요 변수들 선언
    private static RetrofitClient instance = null;
    private static RetrofitInterface retrofitInterface;
    private static String baseUrl = "http://www.kobis.or.kr";

    // 싱글턴 패턴으로 레트로핏 클라이언트 생성 및 활용
    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                // baseUrl 에는 or.kr이나 .com등으로 끝나는 주소까지만 기입
                .baseUrl(baseUrl)
                // 받아온 데이터를 JSON에서 자바에 맞게 변환
                .addConverterFactory(GsonConverterFactory.create())
                // 변환된 데이터 저장
                .build();
        // 레트로핏 인터페이스 구현
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }
}
