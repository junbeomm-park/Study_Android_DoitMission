package com.example.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {
    Button customer;
    Button sales;
    Button product;
    public static final int INPUT_DATA_CUSTOMER = 1;
    public static final int INPUT_DATA_SALES = 2;
    public static final int INPUT_DATA_PRODUCT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        //객체연결
        customer = findViewById(R.id.customerBtn);
        sales = findViewById(R.id.salesBtn);
        product = findViewById(R.id.productBtn);
        //Intent 받기
        Intent intent = getIntent();

        //Intent 보내기 - 고객관리
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, CustomerActivity.class);
                startActivityForResult(intent, INPUT_DATA_CUSTOMER);
            }
        });
        //Intent 보내기 - 매출관리
        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, SalesActivity.class);
                startActivityForResult(intent, INPUT_DATA_SALES);
            }
        });
        //Intent 보내기 - 상품관리
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, ProductActivity.class);
                startActivityForResult(intent, INPUT_DATA_PRODUCT);
            }
        });



    }
    //Toast 출력
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnintent) {
        super.onActivityResult(requestCode, resultCode, returnintent);
        Log.d("park",requestCode+"");
        switch (requestCode){
            case INPUT_DATA_CUSTOMER:
                if(resultCode==RESULT_OK){
                    String returndata = returnintent.getStringExtra("customer");
                    Toast.makeText(this,"고객관리 "+returndata, Toast.LENGTH_LONG).show();
                }
                break;
            case INPUT_DATA_SALES:
                if(resultCode==RESULT_OK){
                    String returndata = returnintent.getStringExtra("sales");
                    Toast.makeText(this,"매출관리 "+returndata, Toast.LENGTH_LONG).show();
                }
                break;
            case INPUT_DATA_PRODUCT:
                if(resultCode==RESULT_OK){
                    String returndata = returnintent.getStringExtra("product");
                    Toast.makeText(this,"상품관리 "+returndata,Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
