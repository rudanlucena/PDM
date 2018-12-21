package com.example.rudan.amadoresfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinnerEstados =  findViewById(R.id.spinnerEstados);
        Spinner spinnerCidades =  findViewById(R.id.spinnerCidades);
        Spinner spinnerLigas =  findViewById(R.id.spinnerLigas);

        ArrayAdapter<CharSequence> adapterEstados = ArrayAdapter.createFromResource(this,
                R.array.estados_array, android.R.layout.simple_spinner_item);
        adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstados.setAdapter(adapterEstados);

        ArrayAdapter<CharSequence> adapterCidades = ArrayAdapter.createFromResource(this,
                R.array.cidades_array, android.R.layout.simple_spinner_item);
        adapterCidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCidades.setAdapter(adapterCidades);

        ArrayAdapter<CharSequence> adapterLigas = ArrayAdapter.createFromResource(this,
                R.array.ligas_array, android.R.layout.simple_spinner_item);
        adapterLigas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLigas.setAdapter(adapterLigas);
    }

    public void entrar(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
