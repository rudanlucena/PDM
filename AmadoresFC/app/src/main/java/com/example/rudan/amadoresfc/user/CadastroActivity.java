package com.example.rudan.amadoresfc.user;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.admin.GerenciarLigasActivity;
import com.example.rudan.amadoresfc.model.UserAdmin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CadastroActivity extends AppCompatActivity {

    private TextView campoUsuario;
    private TextView campoEmail;
    private TextView campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        campoUsuario = findViewById(R.id.textUsuario);
        campoEmail = findViewById(R.id.textEmail);
        campoSenha = findViewById(R.id.textSenha);
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

    public void enviar(View view){

        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();
        if(email.isEmpty() || senha.isEmpty()){
            Toast.makeText(this, "Os Campos São Obrigatorios", Toast.LENGTH_SHORT).show();
        }else {

            DatabaseReference dr = FirebaseDatabase.getInstance().getReference();

            FirebaseAuth auth = FirebaseAuth.getInstance();

            //autentica o usuario
            auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(getApplicationContext(), GerenciarLigasActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(CadastroActivity.this, "Não foi possivel realizar o seu cadastro", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        //metodo antigo de cadastro de usuario
        /*UserAdmin usuario = new UserAdmin();
        usuario.setUsuario(campoUsuario.getText().toString());
        usuario.setEmail(campoEmail.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usuarios = dr.child("usuarios");

        usuarios.push().setValue(usuario);*/





        //DatabaseReference db = FirebaseDatabase.getInstance().getReference("usuaios");

        //filtrando um usuario pelo nome
        //Query usuarioPesquisa = db.orderByChild("nome").equalTo("nome");

        //realizando filtros com limites
        //Query usuarioPesquisaLimit = db.orderByKey().limitToFirst(2);

        //maior ou igual
        //Query usuarioIdade = db.orderByChild("idade").startAt(40);
        //menor ou igaul
        //Query usuarioidadeMenor = db.orderByChild("idade").endAt(22);
        //filtrar palavras
        //Query usuarioPalavras = db.orderByChild("nome").startAt("j").endAt("j");

//        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Usuario usuario = dataSnapshot.getValue(UserAdmin.class);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });



    }
}
