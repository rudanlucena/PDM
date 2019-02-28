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
import com.example.rudan.amadoresfc.admin.GerenciarLigasActivity;

public class TabelaActivity extends AppCompatActivity {

    private ListView listJogos;
    private String[] jogos={
            "vasco x flamengo", "fluminense x botafogo", "ceara x fortaleza"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listJogos = findViewById(R.id.listJogos);

        //adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                jogos
        );

        //Add adapter to list
        listJogos.setAdapter(adapter);

        listJogos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listJogos.getItemAtPosition(position).toString();
                Toast.makeText(TabelaActivity.this, valorSelecionado, Toast.LENGTH_SHORT).show();
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

    public void getClassificacao(View view){
        Intent intent = new Intent(this, ClassificacaoActivity.class);
        startActivity(intent);
    }
}
