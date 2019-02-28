package com.example.rudan.amadoresfc.user;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.admin.GerenciarLigasActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail;
    private EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        campoEmail = findViewById(R.id.editEmail);
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

        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        if(email.isEmpty() || senha.isEmpty()){
            Toast.makeText(this, "Os Campos São Obrigatorios", Toast.LENGTH_SHORT).show();
        }else {

            FirebaseAuth auth = FirebaseAuth.getInstance();

            //autentica o usuario
            auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(), GerenciarLigasActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Falha no Login", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



//        if(usuario.equals("rudan") && senha.equals("2018")){
//            Intent intent = new Intent(getApplicationContext(), GerenciarLigasActivity.class);
//            startActivity(intent);
//        }
//        else{
//            Toast.makeText(getApplicationContext(), "Usuario ou Senha Invalidos", Toast.LENGTH_LONG).show();
//        }
    }

    public void solicitarCadastro(View view){
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }
}
