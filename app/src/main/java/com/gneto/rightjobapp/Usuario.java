package com.gneto.rightjobapp;

public class Usuario {

    private String nome;
    private String sobrenome;
    private String estado;
    private String cidade;
    private String bairro;
    private Integer telefone;
    private String tipoServicoPrestado;
    private String descricaoTrabalhos;
    private String email;
    private String senha;
    //private String avatar;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private int id;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getTipoServicoPrestado() {
        return tipoServicoPrestado;
    }

    public void setTipoServicoPrestado(String tipoServicoPrestado) {
        this.tipoServicoPrestado = tipoServicoPrestado;
    }

    public String getDescricaoTrabalhos() {
        return descricaoTrabalhos;
    }

    public void setDescricaoTrabalhos(String descricaoTrabalhos) {
        this.descricaoTrabalhos = descricaoTrabalhos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString() {
        return "idCli" + getId() + "\nNome do Cliente: " + getNome() + "\nSobrenome: " + getSobrenome() + getEstado() + "\nEstado de residência: " +getCidade() + "\nCidade onde mora" + getBairro() + "\nBairro: " + getTelefone() + "\nSeu telefone para contato: " + getEmail() + "\nSeu email para login ";
    }
}