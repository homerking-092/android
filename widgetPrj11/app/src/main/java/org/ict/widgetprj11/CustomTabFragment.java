package org.ict.widgetprj11;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

// androidx.fragment.app.Fragment를 상속합니다
public class CustomTabFragment extends androidx.fragment.app.Fragment {
    // 탭 이름을 감지해 어떤 탭을 보여줘야 하는지 확인을 위한 변수
    String tabName;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // 탭 이름 감지 관련 코드세팅
        Bundle data = getArguments();
        tabName = data.getString("tabName");
    }

    // 화면에 변경될떄마다 처리할 로직 작성
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        // "baseLayout"은 탭 하단에 실제로 바뀔 화면
        LinearLayout baseLayout = new LinearLayout(super.getActivity());
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        // 이미지 넣기
        // 위젯 생성
        ImageView img = new ImageView(super.getActivity());
        // 위젯에 필요한 경로 등을 지정
        if (tabName == "손흥민"){
            img.setImageResource(R.drawable.a);
            baseLayout.setBackgroundColor(Color.WHITE);
        } else if (tabName == "음바페"){
            img.setImageResource(R.drawable.d);
            baseLayout.setBackgroundColor(Color.BLUE);
        } else if (tabName == "홀란드"){
            img.setImageResource(R.drawable.e);
            baseLayout.setBackgroundColor(Color.YELLOW);
        }

        baseLayout.addView(img);

        return baseLayout;
    }
}
