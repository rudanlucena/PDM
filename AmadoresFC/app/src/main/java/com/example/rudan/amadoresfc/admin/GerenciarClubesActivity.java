package com.example.rudan.amadoresfc.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.adapter.ClubeAdapter;
import com.example.rudan.amadoresfc.adapter.LigaAdapter;
import com.example.rudan.amadoresfc.model.Clube;
import com.example.rudan.amadoresfc.model.Liga;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GerenciarClubesActivity extends AppCompatActivity {
    String keyLiga;

    private ListView listClubes;
    private List<Clube> clubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_clubes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        keyLiga = getIntent().getStringExtra("keyLiga");
        clubes = new ArrayList<>();

        Toast.makeText(this, keyLiga, Toast.LENGTH_SHORT).show();
        listClubes = findViewById(R.id.listClubes);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("estados").child("CE").child("cidades").child("Mauriti").child("ligas").child(keyLiga).child("clubes");

        //Query ligaPesquisa = dr.orderByChild("admin").equalTo(auth.getCurrentUser().getUid());

        dr.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                clubes.clear();
                //Log.d("Firebase: ", dataSnapshot.getValue().toString());
                //ligas.add(dataSnapshot.getValue().toString());

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Clube clube = postSnapshot.getValue(Clube.class);
                    clube.setKeyClube(postSnapshot.getKey());
                    Log.d("Keys", postSnapshot.getKey());
                    clubes.add(clube);
                    Log.d("Get Data", clube.toString());
                }
                exibirClubes();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void exibirClubes(){

        listClubes.setAdapter(new ClubeAdapter(this, clubes));

        listClubes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Clube clube = (Clube) listClubes.getItemAtPosition(position);
                String key = clube.getKeyClube();
                Toast.makeText(GerenciarClubesActivity.this, key, Toast.LENGTH_SHORT).show();
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

    public void adicionarClube(View view){
        Intent intent = new Intent(this, AdicionarClubeActivity.class);
        intent.putExtra("keyLiga", keyLiga);
        startActivity(intent);
    }
}
