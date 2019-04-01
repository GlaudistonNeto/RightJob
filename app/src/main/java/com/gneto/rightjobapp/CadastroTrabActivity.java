package com.gneto.rightjobapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroTrabActivity extends AppCompatActivity {

    BancoDadosRightJobHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_trab);
        bd = new BancoDadosRightJobHelper(this);

        final EditText nome = (EditText) findViewById(R.id.edtNameTrab);
        final EditText sobrenome = (EditText) findViewById(R.id.edtSobrenomeTrab);
        final EditText estado = (EditText) findViewById(R.id.edtEstadoTrab);
        final EditText cidade = (EditText) findViewById(R.id.edtCidadeTrab);
        final EditText bairro = (EditText) findViewById(R.id.edtBairroTrab);
        final EditText telefone = (EditText) findViewById(R.id.edtTelefoneTrab);
        final EditText tipoServicoPrestado = (EditText) findViewById(R.id.edtTipoServicoPrestado);
        final EditText descricaoTrabalhos = (EditText) findViewById(R.id.edtDescricaoServicos);
        final EditText email = (EditText) findViewById(R.id.edtEmailTrab);
        final EditText senha = (EditText) findViewById(R.id.edtSenhaTrab);
        final EditText confSenha = (EditText) findViewById(R.id.edtConfSenhaTrab);
        final Button btnCadastroTrab = (Button)findViewById(R.id.btnRegistrarTrab);
        final Button btnLoginTrab = (Button)findViewById(R.id.btnIrLoginTrab);

        btnLoginTrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCadastroTrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario trabalhador = new Usuario();
                trabalhador.setNome(nome.getText().toString());
                trabalhador.setSobrenome(sobrenome.getText().toString());
                trabalhador.setEstado(estado.getText().toString());
                trabalhador.setCidade(cidade.getText().toString());
                trabalhador.setBairro(bairro.getText().toString());
                trabalhador.setTelefone(Integer.parseInt(telefone.getText().toString()));
                trabalhador.setTipoServicoPrestado(tipoServicoPrestado.getText().toString());
                trabalhador.setDescricaoTrabalhos(descricaoTrabalhos.getText().toString());
                trabalhador.setEmail(email.getText().toString());
                trabalhador.setSenha(senha.getText().toString());
                bd.addUsuarios(trabalhador);
                Toast.makeText(getApplicationContext(), "Trabalhador inserido com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}