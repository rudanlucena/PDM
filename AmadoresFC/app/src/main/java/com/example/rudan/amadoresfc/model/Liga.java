package com.example.rudan.amadoresfc.model;

public class Liga {
    private String nome;
    private String dataCriacao;
    private String estado;
    private String cidade;
    private String admin;
    private transient String key;

    public Liga(){

    }

    public Liga(String nome, String dataCriacao, String estado, String cidade, String admin){
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.estado = estado;
        this.cidade = cidade;
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCriacao() {
        return dataCriacao;
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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nome='" + nome + '\'' +
                ", dataCriacao='" + dataCriacao + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
