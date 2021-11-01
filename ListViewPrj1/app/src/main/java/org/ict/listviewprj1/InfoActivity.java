package org.ict.listviewprj1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class InfoActivity extends Activity {

    Button returnBtn;
    ImageView cView;
    TextView cInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countryinfo);

        returnBtn = findViewById(R.id.returnBtn);
        cView = findViewById(R.id.cView);
        cInfo = findViewById(R.id.cInfo);

        // 국기 고유 주소 저장
        int[] flagNum = {R.drawable.f0, R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,R.drawable.f6,R.drawable.f7,
                R.drawable.f8,R.drawable.f9, R.drawable.f10,R.drawable.f11,R.drawable.f12,R.drawable.f13,R.drawable.f14};

        Intent intent = getIntent();
        String trip = intent.getStringExtra("trip");
        cInfo.setText(trip);

        int position = intent.getIntExtra("position",0);
        cView.setImageResource(flagNum[position]);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("버튼: ", "뒤로가기");
                finish();
            }
        });



    }
}
