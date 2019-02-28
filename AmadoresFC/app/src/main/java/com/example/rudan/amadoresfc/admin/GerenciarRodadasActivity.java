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
import com.example.rudan.amadoresfc.adapter.RodadaAdapter;
import com.example.rudan.amadoresfc.model.Clube;
import com.example.rudan.amadoresfc.model.Partida;
import com.example.rudan.amadoresfc.model.Rodada;
import com.example.rudan.amadoresfc.service.RankingService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GerenciarRodadasActivity extends AppCompatActivity {

    private ListView listRodadas;
    public static List<Rodada> rodadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_rodadas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listRodadas = findViewById(R.id.listRodadas);
        rodadas = new ArrayList<>();

        List<Partida> partidas = new ArrayList<>();

        Clube vasco = new Clube("vasco");
        Clube flamengo = new Clube("flamengo");
        Clube botafogo = new Clube("botafogo");
        Clube fluminense = new Clube("fluminense");

        Partida p1 = new Partida(vasco, flamengo, "23/02/2019");
        p1.setPlacarMandante(1);
        p1.setPlacarVisitante(0);
        Partida p2 = new Partida(botafogo, fluminense, "23/02/2019");
        p2.setPlacarMandante(1);
        p2.setPlacarVisitante(0);

        Rodada rodada1 = new Rodada(1);
        rodada1.addPartida(p1);
        rodada1.addPartida(p2);

        Partida p3 = new Partida(vasco, fluminense, "26/02/2019");
        p3.setPlacarMandante(1);
        p3.setPlacarVisitante(0);
        Partida p4 = new Partida(botafogo, flamengo, "26/02/2019");
        p4.setPlacarMandante(1);
        p4.setPlacarVisitante(0);

        Rodada rodada2 = new Rodada(2);
        rodada2.addPartida(p3);
        rodada2.addPartida(p4);

        rodadas.add(rodada1);
        rodadas.add(rodada2);


        //adapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                rodadas
//        );

        //Add adapter to list
        listRodadas.setAdapter(new RodadaAdapter(this, rodadas));

        listRodadas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listRodadas.getItemAtPosition(position).toString();
                Toast.makeText(GerenciarRodadasActivity.this, valorSelecionado, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), GerenciarPartidasActivity.class);
                //passar minha lista de partidas
                Rodada rodada = (Rodada) listRodadas.getItemAtPosition(position);
                List<Partida> partidas = rodada.getPartidas();
                intent.putExtra("partidas", (Serializable) partidas);
                startActivity(intent);
            }

        });

        listRodadas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GerenciarRodadasActivity.this, "Longo click", Toast.LENGTH_SHORT).show();
                //rodada a ser excluida
                Rodada rodada = (Rodada) listRodadas.getItemAtPosition(position);
                rodadas.remove(rodada);
                List<Rodada> r = new ArrayList<>();
                r.addAll(rodadas);

                atualizarLista(r);
                return false;
            }
        });
    }

    public void atualizarLista(List<Rodada> rodadasAtualizadas){
        rodadas.clear();
        listRodadas.setAdapter(new RodadaAdapter(this, rodadasAtualizadas));

        //chamar Service Ranking
        startService(new Intent(this, RankingService.class));
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
