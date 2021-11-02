package org.ict.movieprj.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ict.movieprj.R;
import org.ict.movieprj.VO.DailyBoxOffice;

import java.util.List;

// 리사이클러뷰의 어댑터 관련 내용을 정의하는 클래스입니다
// RecyclerView 클래스 내부의 Adapter를 상속해 만듭니다
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    // 반복해서 뷰올 깔아줄 요소를 선언
    List<DailyBoxOffice> items;

    // 생성자에 뷰로 깔아줄 요소를 입력해야만 실행되도록 파라미터 처리합니다
    public MovieAdapter(List<DailyBoxOffice> items) {
        this.items = items;
    }

    // Override Methods 를 활용해 onCreateViewHolder를 선언해주세요
    // 이 메서드는 layout 폴더 내에 있는 리사이클러 뷰의 본체로 활용될
    // 현 프로젝트의 card.xml을 불러옵니다
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new ViewHolder(itemView);
    }

    // 위에서 불러온 card.xml 내부의 카드 한장 한장에 DailyBoxOffice에 해당하는
    // 영화정보를 하나하나 붙여줘야 합니다
    // onBindViewHolder를 오버라이드합니다
/////////////////////////////////////////////////////////

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // holder 각각 하나하나의 영화정보를 바인딩합니다
        DailyBoxOffice item = items.get(position);
        holder.setItem(item);
    }

//    @Override
//    public void onBindViewHolder(@NonNull MovieAdapter holder, int position) {
//
//    }

    // 출력할 영화 갯수 체크
    public int getItemCount() {
        return items.size();
    }

    // 클래스의 내부에 viewHolder 클래스 선언을 하는데
    // card.xml 내부 TextView 3개에 대한 설절을 할 수 있도록 처리해 줍니다
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // card.xml 내부에 뚫려있는 구멍을 전부 부품 선언
        private TextView rankNum, title, mDate;

        // 생성자에서 card.xml 내부 부품들 연결하기
        public ViewHolder(View itemView) {
            super(itemView);
            rankNum = itemView.findViewById(R.id.rankNum);
            title = itemView.findViewById(R.id.title);
            mDate = itemView.findViewById(R.id.mDate);
        }

        // 연결된 아이템 요소들 텍스트 세팅하기
        public void setItem(DailyBoxOffice item) {
            rankNum.setText(item.getRank() + "위");
            title.setText("영화제목" + item.getMovieNm());
            mDate.setText("개봉날짜" + item.getMovieCd());
        }

    }
}// end class
