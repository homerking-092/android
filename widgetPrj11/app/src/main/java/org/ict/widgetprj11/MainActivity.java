package org.ict.widgetprj11;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

// 액션바는 java 코드로만 구현하기 떄문에 activity_main.xml 파일이 필요없다
// MainActivity 에서는 탭만 구현하고
// TCustomTabFragment 클래스를 만드렁 거기서 탭별 화면을 구현합니다
// MainActivity는 AppCompatActivity를 상속하고 ActinBar를 구현합니다
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    // 탭 갯수만킄 변수 선언(3개)
    ActionBar.Tab tabSon, tabMb, tabHaal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main은 안쓰므로 필요없음
//        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSon = bar.newTab();
        tabSon.setText("손흥민");
        tabSon.setTabListener(this);
        bar.addTab(tabSon);

        tabMb = bar.newTab();
        tabMb.setText("음바페");
        tabMb.setTabListener(this);
        bar.addTab(tabMb);

        tabHaal = bar.newTab();
        tabHaal.setText("홀란드");
        tabHaal.setTabListener(this);
        bar.addTab(tabHaal);
    }

    // 탭이 선택될 떄마다 바뀌는 내용을 처리해야 하므로
    // onTabSelected 를 재정의해줍니다
    // CustomFragment 3개를 선언합니다
    CustomTabFragment customFrags[] = new CustomTabFragment[3];
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 아까 만든 커스텀 프래그먼트를 먼저 선언합니다
        CustomTabFragment cFrag = null;

        // 탭 선택이 된적이 없다면, 새로 탭을 생성
        if (customFrags[tab.getPosition()] == null){
            cFrag = new CustomTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            cFrag.setArguments(data);
            customFrags[tab.getPosition()] = cFrag;
        } else {
            // 선택이 된적이 있다면 선택된 탭으로 교체
            cFrag = customFrags[tab.getPosition()];
        }
        // 화면교체
        ft.replace(android.R.id.content, cFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}