package com.gneto.rightjobapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroCliActivity extends AppCompatActivity {

    BancoDadosRightJobHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_trab);
        bd = new BancoDadosRightJobHelper(this);

        final EditText nome = (EditText) findViewById(R.id.edtNomeCli);
        final EditText sobrenome = (EditText) findViewById(R.id.edtSobrenomeCli);
        final EditText estado = (EditText) findViewById(R.id.edtEstadoCli);
        final EditText cidade = (EditText) findViewById(R.id.edtCidadeCli);
        final EditText bairro = (EditText) findViewById(R.id.edtBairroCli);
        final EditText telefone = (EditText) findViewById(R.id.edtTelefoneCli);
        final EditText email = (EditText) findViewById(R.id.edtEmailCli);
        final EditText senha = (EditText) findViewById(R.id.edtSenhaCli);
        final EditText confSenha = (EditText) findViewById(R.id.edtConfSenhaCli);
        final Button btnCadastroCli = (Button)findViewById(R.id.btnRegistrarCli);
        final Button btnLoginCli = (Button)findViewById(R.id.btnIrLoginCli);

        btnLoginCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCadastroCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario cliente = new Usuario();
                cliente.setNome(nome.getText().toString());
                cliente.setSobrenome(sobrenome.getText().toString());
                cliente.setEstado(estado.getText().toString());
                cliente.setCidade(cidade.getText().toString());
                cliente.setBairro(bairro.getText().toString());
                cliente.setTelefone(Integer.parseInt(telefone.getText().toString()));
                cliente.setEmail(email.getText().toString());
                cliente.setSenha(senha.getText().toString());
                bd.addUsuarios(cliente);
                Toast.makeText(getApplicationContext(), "Cliente inserido com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}