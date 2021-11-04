package com.example.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity {
    Button ctm_login;
    Button ctm_menu;
    public static final int INPUT_DATA_CUSTOMER = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);
        //객체연결
        ctm_login = findViewById(R.id.ctm_forLogin);
        ctm_menu = findViewById(R.id.ctm_forMenu);
        //Intent 받기
        Intent intent = getIntent();
        //메뉴클릭 리스너
        ctm_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("customer","액티비티에서 실행 ");
                setResult(RESULT_OK,intent);
                finish();
                Intent intent = new Intent(CustomerActivity.this,MainMenuActivity.class);

            }
        });
        //로그인클릭 리스너
        ctm_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("customer","고객관리 액티비티에서 실행");
                setResult(RESULT_OK,intent);
                Intent intent = new Intent(CustomerActivity.this,LoginActivity.class);
                startActivityForResult(intent,INPUT_DATA_CUSTOMER);

            }
        });
    }
}