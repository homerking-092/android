package org.ict.toastprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 버튼 생성
    Button toastBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼 연결
        toastBtn = findViewById(R.id.toastBtn);

        // onClick 이벤트 걸기
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 토스트에 옵션을 걸려면 바로 화면에 .show()를 사용하지 않습니다
                Toast toast = Toast.makeText(getApplicationContext(), "토스트 옵션걸기", Toast.LENGTH_SHORT);

                // 화면 내부의 높이, 너비를 얻어올 수 있도록 display 설정
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)
                ).getDefaultDisplay();

                // 나온 좌표값
                int xOffset = (int)(Math.random()) * display.getWidth();
                int yOffset = (int)(Math.random()) * display.getHeight();

                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                // toast에 옵션을 모두 입력한 뒤 .show()로 호면 출력
                toast.show();
            }
        });

    }
}