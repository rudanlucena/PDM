package com.example.rudan.amadoresfc.admin;

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
import com.example.rudan.amadoresfc.adapter.PartidaAdapter;
import com.example.rudan.amadoresfc.model.Clube;
import com.example.rudan.amadoresfc.model.Partida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GerenciarPartidasActivity extends AppCompatActivity {
    private ListView listPartidas;
//    private String[] partidas={
//            "Vasco x Flamengo", "Vasco x Flamengo", "Vasco x Flamengo"
//    };

    Clube vasco = new Clube("vasco");
    Clube flamengo = new Clube("flamengo");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Partida> partidas;

        partidas  = (ArrayList<Partida>) getIntent().getSerializableExtra("partidas");
        setContentView(R.layout.activity_gerenciar_partidas);
        listPartidas = findViewById(R.id.listPartidas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        Partida p1 = new Partida(vasco, flamengo, "23/02/2019");
//        Partida p2 = new Partida(vasco, flamengo, "27/02/2019");
//        partidas.add(p1);
//        partidas.add(p2);
//        partidas.add(p1);
//        partidas.add(p2);
//        partidas.add(p1);
//        partidas.add(p2);
//        partidas.add(p1);
//        partidas.add(p2);
//        partidas.add(p1);
//        partidas.add(p2);
//        partidas.add(p1);
//        partidas.add(p2);

        //Add adapter to list
        listPartidas.setAdapter(new PartidaAdapter(this, partidas));

        listPartidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String valorSelecionado = listPartidas.getItemAtPosition(position).toString();
                Partida valorSelecionado = (Partida)listPartidas.getItemAtPosition(position);
                Toast.makeText(GerenciarPartidasActivity.this, valorSelecionado.getDataPartida(), Toast.LENGTH_SHORT).show();

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
