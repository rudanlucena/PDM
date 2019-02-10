package com.example.rudan.amadoresfc.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.admin.GerenciarLigasActivity;

public class AdicionarLigaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_liga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinnerEstados =  findViewById(R.id.spinnerEstados);
        Spinner spinnerCidades =  findViewById(R.id.spinnerCidades);
        Spinner spinnerGrupos =  findViewById(R.id.spinnerGrupos);
        Spinner spinnerClubes =  findViewById(R.id.spinnerClubes);

        ArrayAdapter<CharSequence> adapterEstados = ArrayAdapter.createFromResource(this,
                R.array.estados_array, android.R.layout.simple_spinner_item);
        adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstados.setAdapter(adapterEstados);

        ArrayAdapter<CharSequence> adapterCidades = ArrayAdapter.createFromResource(this,
                R.array.cidades_array, android.R.layout.simple_spinner_item);
        adapterCidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCidades.setAdapter(adapterCidades);

        ArrayAdapter<CharSequence> adapterClubes = ArrayAdapter.createFromResource(this,
                R.array.clubes_array, android.R.layout.simple_spinner_item);
        adapterClubes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClubes.setAdapter(adapterClubes);

        ArrayAdapter<CharSequence> adapterGrupos = ArrayAdapter.createFromResource(this,
                R.array.grupos_array, android.R.layout.simple_spinner_item);
        adapterGrupos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrupos.setAdapter(adapterGrupos);
    }

    public void salvarLiga(View view){
        Toast.makeText(getApplicationContext(), "A Nova Liga Foi Criada Com Sucesso", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), GerenciarLigasActivity.class);
        startActivity(intent);
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
