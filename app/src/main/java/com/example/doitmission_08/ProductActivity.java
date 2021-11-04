package com.example.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductActivity extends AppCompatActivity {
    Button pd_login;
    Button pd_menu;
    public static final int INPUT_DATA_PRODUCT = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        pd_login = (Button) findViewById(R.id.pd_forLogin);
        pd_menu = (Button) findViewById(R.id.pd_forMenu);

        Intent intent = getIntent();

        pd_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("product", "액티비티에서 실행 ");
                setResult(RESULT_OK, intent);
                finish();
                Intent intent = new Intent(ProductActivity.this, MainMenuActivity.class);
                /*startActivityForResult(intent,INPUT_DATA_PRODUCT);*/   // 연결되는 메소드인데 왜 주석처리해도 연결?????
                                                                         // setResult 가 연결 ????
            }
        });

        pd_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("product2", "상품관리 액티비티에서 실행 2");
                setResult(RESULT_OK, intent);
                Intent intent = new Intent(ProductActivity.this, LoginActivity.class);
                startActivityForResult(intent,INPUT_DATA_PRODUCT);
            }
        });

    }
}