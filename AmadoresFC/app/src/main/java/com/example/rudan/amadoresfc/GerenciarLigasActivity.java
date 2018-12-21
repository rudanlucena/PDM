package com.example.rudan.amadoresfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GerenciarLigasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_ligas);
    }

    public void adicionarLiga(View view){
        Intent intent = new Intent(getApplicationContext(), AdicionarLigaActivity.class);
        startActivity(intent);
    }
}
