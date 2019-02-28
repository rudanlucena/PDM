package com.example.rudan.amadoresfc.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.adapter.ClubeAdapter;
import com.example.rudan.amadoresfc.admin.GerenciarPartidasActivity;
import com.example.rudan.amadoresfc.admin.GerenciarRodadasActivity;
import com.example.rudan.amadoresfc.model.Clube;

import java.util.ArrayList;
import java.util.List;

public class ClassificacaoActivity extends AppCompatActivity {

    private ListView listClassificacao;

    List<Clube> clubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classificacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clubes = new ArrayList<>();
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));
        clubes.add(new Clube("vasco"));

        listClassificacao = findViewById(R.id.listRanking);


        //Add adapter to list
        listClassificacao.setAdapter(new ClubeAdapter(this, clubes));

        listClassificacao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listClassificacao.getItemAtPosition(position).toString();

                Toast.makeText(ClassificacaoActivity.this, valorSelecionado, Toast.LENGTH_SHORT).show();
            }

        });
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
}
