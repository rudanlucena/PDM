package com.example.rudan.amadoresfc.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.service.RankingService;
import com.example.rudan.amadoresfc.user.CadastroActivity;

public class MenuActivity extends AppCompatActivity {
    String keyLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        keyLiga = intent.getStringExtra("keyLiga");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Toast.makeText(this, GerenciarRodadasActivity.rodadas.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==android.R.id.home){
            finish();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gerenciarClubes(View view){
        Intent intent = new Intent(this, GerenciarClubesActivity.class);
        intent.putExtra("keyLiga", keyLiga);
        startActivity(intent);
    }

    public void gerenciarRodadas(View view){
        Intent intent = new Intent(this, GerenciarRodadasActivity.class);
        startActivity(intent);
    }

    public void gerenciarRanking(View view){
        Intent intent = new Intent(this, GerenciarRankingActivity.class);
        startActivity(intent);
        startService(new Intent(this, RankingService.class));
    }
}
