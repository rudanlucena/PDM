package com.example.rudan.amadoresfc.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.model.Clube;
import com.example.rudan.amadoresfc.model.Liga;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdicionarClubeActivity extends AppCompatActivity {
    private TextView campoNome;
    private String keyLiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_clube);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        keyLiga = getIntent().getStringExtra("keyLiga");
        campoNome = findViewById(R.id.nomeClube);
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

    public void addClube(View view){
        String nome = campoNome.getText().toString();
        Clube clube = new Clube(nome);

        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("estados").child("CE").child("cidades").child("Mauriti").child("ligas").child(keyLiga).child("clubes");

        dr.push().setValue(clube);

        Toast.makeText(this, "Clube Adicionado com Sucesso", Toast.LENGTH_SHORT).show();
        campoNome.setText("");

        //Intent intent = new Intent(this, GerenciarClubesActivity.class);
        //intent.putExtra("keyLiga", keyLiga);
        //startActivity(intent);

//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        String admin = auth.getCurrentUser().getUid();
//
//
//
//        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("estados");
//        //DatabaseReference ligas = dr.child("ligas");
//        DatabaseReference clubes = dr.child(estado).child("cidades").child(cidade).child("ligas");
//
//

    }
}
