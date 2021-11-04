package com.example.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalesActivity extends AppCompatActivity {
    Button sa_login;
    Button sa_menu;
    public static final int INPUT_DATA_CUSTOMER = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales);
        sa_login = findViewById(R.id.sa_forLogin);
        sa_menu = findViewById(R.id.sa_forMenu);

        Intent intent = getIntent();

        sa_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("sales","액티비티에서 실행");
                setResult(RESULT_OK,intent);
                finish();
                Intent intent = new Intent(SalesActivity.this,MainMenuActivity.class);

            }
        });

        sa_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("sales","매출관리 액티비티에서 실행");
                setResult(RESULT_OK,intent);
                Intent intent = new Intent(SalesActivity.this, LoginActivity.class);
                startActivityForResult(intent,INPUT_DATA_CUSTOMER);
            }
        });
    }
}