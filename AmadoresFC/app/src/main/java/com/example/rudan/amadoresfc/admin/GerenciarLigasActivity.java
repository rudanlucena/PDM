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
import com.example.rudan.amadoresfc.adapter.LigaAdapter;
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

public class GerenciarLigasActivity extends AppCompatActivity {

    private ListView listLigas;
    private List<Liga> ligas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_ligas);
        listLigas = findViewById(R.id.listLigas);
        ligas = new ArrayList<>();

        FirebaseAuth auth = FirebaseAuth.getInstance();
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference("estados").child("CE").child("cidades").child("Mauriti").child("ligas");
        Query ligaPesquisa = dr.orderByChild("admin").equalTo(auth.getCurrentUser().getUid());

        ligaPesquisa.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Log.d("Firebase: ", dataSnapshot.getValue().toString());
                //ligas.add(dataSnapshot.getValue().toString());
                ligas.clear();

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Liga liga = postSnapshot.getValue(Liga.class);
                    liga.setKey(postSnapshot.getKey());
                    Log.d("Keys", postSnapshot.getKey());
                    ligas.add(liga);
                    Log.d("Get Data", liga.toString());
                }
                exibirLigas();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void exibirLigas(){

        listLigas.setAdapter(new LigaAdapter(this, ligas));

        listLigas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Liga liga = (Liga) listLigas.getItemAtPosition(position);
                String key = liga.getKey();
                Toast.makeText(GerenciarLigasActivity.this, key, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("keyLiga", key);
                startActivity(intent);
            }

        });

    }

    public void adicionarLiga(View view){
        Intent intent = new Intent(getApplicationContext(), AdicionarLigaActivity.class);
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
