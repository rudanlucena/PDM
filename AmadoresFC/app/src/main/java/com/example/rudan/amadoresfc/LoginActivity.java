package com.example.rudan.amadoresfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rudan.amadoresfc.admin.GerenciarLigasActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText campoUsuario;
    private EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        campoUsuario = findViewById(R.id.editUsuario);
        campoSenha = findViewById(R.id.editSenha);
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

    public void entrar(View view){
        String usuario = campoUsuario.getText().toString();
        String senha = campoSenha.getText().toString();
        if(usuario.equals("rudan") && senha.equals("2018")){
            Intent intent = new Intent(getApplicationContext(), GerenciarLigasActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Usuario ou Senha Invalidos", Toast.LENGTH_LONG).show();
        }
    }

    public void solicitarCadastro(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
