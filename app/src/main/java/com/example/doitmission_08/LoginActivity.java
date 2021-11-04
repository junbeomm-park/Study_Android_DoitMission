package com.example.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText id;
    EditText pass;
    Button btn;

    public static final int INPUT_DATA_CUSTOMER = 1;
    public static final int INPUT_DATA_SALES = 2;
    public static final int INPUT_DATA_PRODUCT = 3;
    public static final int INPUT_DATA_MAINMENU = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        id = findViewById(R.id.idtxt);
        pass = findViewById(R.id.passtxt);
        btn = findViewById(R.id.loginbtn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                intent.putExtra("id","");
                intent.putExtra("pass","");
                startActivityForResult(intent,INPUT_DATA_MAINMENU);

                if(id.getText()==null || pass.getText()==null){
                    Toast.makeText(this,"ID 또는 비밀번호를 입력하세요 ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
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
                    String returndata = returnintent.getStringExtra("product2");
                    Toast.makeText(this,"상품관리 "+returndata,Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}