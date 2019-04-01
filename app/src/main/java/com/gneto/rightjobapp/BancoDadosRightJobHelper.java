package com.gneto.rightjobapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.widget.TextView;

import java.util.ArrayList;

public class BancoDadosRightJobHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = '1';
    private static final String DATABASE_NAME = "UsuarioBD";

    private static final String TABELA_USUARIOS = "Usuarios";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String SOBRENOME = "sobrenome";
    private static final String ESTADO = "estado";
    private static final String CIDADE = "cidade";
    private static final String BAIRRO = "bairro";
    private static final String TELEFONE = "telefone";
    private static final String TIPOSERVICOPRESTADO = "tipoServicoPrestado";
    private static final String DESCRICAOTRABALHOS = "descricaoTrabalhos";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";

    private static final String[] COLUNAS = {ID, NOME, SOBRENOME, ESTADO, CIDADE, BAIRRO, TELEFONE, TIPOSERVICOPRESTADO, DESCRICAOTRABALHOS, EMAIL, SENHA};

    public BancoDadosRightJobHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USUARIOS = "CREATE TABLE Usuarios(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome text," +
                "sobrenome text," +
                "estado text," +
                "cidade text," +
                "bairro text," +
                "telefone text," +
                "tipoServicoPrestado text,"  +
                "descricaoTrabalhos text," +
                "email text," +
                "senha text)";
        db.execSQL(CREATE_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
    }

    public void addUsuarios(Usuario usuario) {
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, usuario.getNome());
        values.put(SOBRENOME, usuario.getSobrenome());
        values.put(ESTADO, usuario.getEstado());
        values.put(CIDADE, usuario.getCidade());
        values.put(BAIRRO, usuario.getBairro());
        values.put(TELEFONE, usuario.getTelefone());
        values.put(TIPOSERVICOPRESTADO, usuario.getTipoServicoPrestado());
        values.put(DESCRICAOTRABALHOS, usuario.getDescricaoTrabalhos());
        values.put(EMAIL, usuario.getEmail());
        values.put(SENHA, usuario.getSenha());
        bd.insert(TABELA_USUARIOS, null, values);
        bd.close();
    }

    public Usuario getUsuario(int id) {
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor cursor = bd.query(
                TABELA_USUARIOS,
                COLUNAS,
                "id = ?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            Usuario usuario = cursorToUsuario(cursor);
            return usuario;
        }
    }

        private Usuario cursorToUsuario(Cursor cursor) {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(cursor.getString(0)));
            usuario.setNome(cursor.getString(1));
            usuario.setSobrenome(cursor.getString(2));
            usuario.setEstado(cursor.getString(3));
            usuario.setCidade(cursor.getString(4));
            usuario.setBairro(cursor.getString(5));
            usuario.setTelefone(Integer.parseInt(cursor.getString(6)));
            usuario.setTipoServicoPrestado(cursor.getString(7));
            usuario.setDescricaoTrabalhos(cursor.getString(8));
            usuario.setEmail(cursor.getString(9));
            usuario.setSenha(cursor.getString(10));
            return usuario;
        }



    public ArrayList<Usuario> getAllTrabalhadores() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String query = "SELECT    *  FROM  " + TABELA_USUARIOS;
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor cursor = bd.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = cursorToUsuario(cursor);
                listaUsuarios.add(usuario);

            } while
            (cursor.moveToNext());
        }
        return listaUsuarios;
    }

    public Cursor carregaDados() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String query = "SELECT    *  FROM  " + TABELA_USUARIOS;
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor cursor = bd.rawQuery(query, null);
        return  cursor;
    }

    public  int updateUsuario(Usuario usuario) {
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, usuario.getNome());
        values.put(SOBRENOME, usuario.getSobrenome());
        values.put(ESTADO, usuario.getEstado());
        values.put(CIDADE, usuario.getCidade());
        values.put(BAIRRO, usuario.getBairro());
        values.put(TELEFONE, usuario.getTelefone());
        values.put(TIPOSERVICOPRESTADO, usuario.getTipoServicoPrestado());
        values.put(DESCRICAOTRABALHOS, usuario.getDescricaoTrabalhos());
        values.put(EMAIL, usuario.getEmail());
        values.put(SENHA, usuario.getSenha());
        int i = bd.update(TABELA_USUARIOS,  //tabela
                values,  //  valores
                ID + "  =  ?",  //  colunasparacomparar
                new String[]{String.valueOf(usuario.getId())});  //parÃ¢metros
        bd.close();
        return i;  //  nÃºmero de  linhas modificadas
    }

    public  int deleteUsuario(Usuario usuario) {
        SQLiteDatabase bd = this.getWritableDatabase();
        int i = bd.delete(TABELA_USUARIOS,  //tabela
                ID + "  =  ?",    //  colunasparacomparar
                new String[]{String.valueOf(usuario.getId())});
        bd.close();
        return i;  //  número de  linhasexcluídas
    }
}