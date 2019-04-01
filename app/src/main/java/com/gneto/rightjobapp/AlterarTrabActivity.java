package com.gneto.rightjobapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarTrabActivity extends AppCompatActivity {

    BancoDadosRightJobHelper bd;
    Usuario trabalhador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_trab);

        bd = new BancoDadosRightJobHelper(this);

        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);

        final EditText edtNomeAlTrab = (EditText) findViewById(R.id.edtNomeAlTrab);
        final EditText edtSobrenomeAlTrab = (EditText) findViewById(R.id.edtSobrenomeAlTrab);
        final EditText edtEstadoAlTrab = (EditText) findViewById(R.id.edtEstadoAlTrab);
        final EditText edtCidadeAlTrab = (EditText) findViewById(R.id.edtCidadeAlTrab);
        final EditText edtBairroAlTrab = (EditText) findViewById(R.id.edtBairroAlTrab);
        final EditText edtTelefoneAlTrab = (EditText) findViewById(R.id.edtTelefoneAlTrab);
        final EditText edtTipoServAlTrab = (EditText) findViewById(R.id.edtTipoServicoAl);
        final EditText edtDescServPresAlTrab = (EditText) findViewById(R.id.edtDescricaoServAlTrab);
        final EditText edtEmailAlTrab = (EditText) findViewById(R.id.edtEmailAlTrab);
        final EditText edtSenhaAlTrab = (EditText) findViewById(R.id.edtSenhaAlTrab);

        trabalhador = new Usuario();
        final int id = getIntent().getIntExtra("id", 0);
        trabalhador = bd.getUsuario(id);

        edtNomeAlTrab.setText(trabalhador.getNome());
        edtSobrenomeAlTrab.setText(trabalhador.getSobrenome());
        edtEstadoAlTrab.setText(String.valueOf (trabalhador.getEstado()));
        edtCidadeAlTrab.setText(String.valueOf(trabalhador.getCidade()));
        edtBairroAlTrab.setText(String.valueOf(trabalhador.getBairro()));
        edtTelefoneAlTrab.setText(String.valueOf(trabalhador.getTelefone()));
        edtTipoServAlTrab.setText(String.valueOf(trabalhador.getTipoServicoPrestado()));
        edtDescServPresAlTrab.setText(String.valueOf(trabalhador.getDescricaoTrabalhos()));
        edtEmailAlTrab.setText(String.valueOf(trabalhador.getEmail()));
        edtSenhaAlTrab.setText(String.valueOf(trabalhador.getSenha()));

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                trabalhador.setNome((edtNomeAlTrab.getText().toString()));
                trabalhador.setSobrenome(edtTipoServAlTrab.getText().toString());
                trabalhador.setSobrenome(edtEstadoAlTrab.getText().toString());
                trabalhador.setEstado(edtEstadoAlTrab.getText().toString());
                trabalhador.setCidade(edtCidadeAlTrab.getText().toString());
                trabalhador.setBairro(edtBairroAlTrab.getText().toString());
                trabalhador.setTelefone(Integer.parseInt(edtTelefoneAlTrab.getText().toString()));
                trabalhador.setTipoServicoPrestado(edtTipoServAlTrab.getText().toString());
                trabalhador.setDescricaoTrabalhos(edtDescServPresAlTrab.getText().toString());
                trabalhador.setEmail(edtEmailAlTrab.getText().toString());
                trabalhador.setSenha(edtSenhaAlTrab.getText().toString());
                trabalhador.setId(id);
                bd.updateUsuario(trabalhador);
                Toast.makeText(getBaseContext(), "Livro alterado com sucesso",
                        Toast.LENGTH_LONG).show();
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}