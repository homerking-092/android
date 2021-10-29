package org.ict.explicitlntenprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button moveSub;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveSub = findViewById(R.id.moveSub);
        et1 = findViewById(R.id.et1);

        moveSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);

                // Intent는 startActivity로 보내기 전에
                // intent.putExtra("호출명", 자료); 형식으로
                // model.addAttribute("호출명", 자료);와 같이
                // 데이터를 실어둔 다음 전송할 수 있습니다
                intent.putExtra("et1", et1.getText().toString());

                startActivity(intent);
            }
        });
    }
}