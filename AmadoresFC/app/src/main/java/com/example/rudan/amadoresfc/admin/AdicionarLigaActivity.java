package com.example.rudan.amadoresfc.admin;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.admin.GerenciarLigasActivity;
import com.example.rudan.amadoresfc.model.Liga;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdicionarLigaActivity extends AppCompatActivity {

    private TextView campoNome;
    private Spinner spinnerEstados;
    private Spinner spinnerCidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_liga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        campoNome = findViewById(R.id.campoNome);

        spinnerEstados =  findViewById(R.id.spinnerEstados);
        spinnerCidades =  findViewById(R.id.spinnerCidades);


        ArrayAdapter<CharSequence> adapterEstados = ArrayAdapter.createFromResource(this,
                R.array.estados_array, android.R.layout.simple_spinner_item);
        adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstados.setAdapter(adapterEstados);

        ArrayAdapter<CharSequence> adapterCidades = ArrayAdapter.createFromResource(this,
                R.array.cidades_array, android.R.layout.simple_spinner_item);
        adapterCidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCidades.setAdapter(adapterCidades);
    }

    public void salvarLiga(View view){
        String nome = campoNome.getText().toString();
        String estado = spinnerEstados.getSelectedItem().toString();
        String cidade = spinnerCidades.getSelectedItem().toString();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        String data =  formataData.format(new Date());

        FirebaseAuth auth = FirebaseAuth.getInstance();
        String admin = auth.getCurrentUser().getUid();

        Liga liga = new Liga(nome, data, estado, cidade, admin);

        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("estados");
        //DatabaseReference ligas = dr.child("ligas");
        DatabaseReference ligas = dr.child(estado).child("cidades").child(cidade).child("ligas");

        ligas.push().setValue(liga);

        Toast.makeText(getApplicationContext(), "A Nova Liga Foi Criada Com Sucesso", Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(getApplicationContext(), GerenciarLigasActivity.class);
//        startActivity(intent);
        finish();
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
