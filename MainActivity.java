package com.example.dbimport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.view.View;

//버튼 2개.
// 한개는 로또번호 입력
// 한개는 로또 번호 출력
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclick_Add(View view){
        Intent intent_AddLotto = new Intent(this, AddLottoActi.class);
        startActivity(intent_AddLotto);
    }

    public void onclick_NC(View view){
        Intent intent_NCView = new Intent(this,ListViewCount.class);
        startActivity(intent_NCView);
    }

    public void onclick_List(View view){
        Intent intent_ListView = new Intent(this, ListViewT.class);
        startActivity(intent_ListView);
    }
}



