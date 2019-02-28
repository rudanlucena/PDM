package com.example.rudan.amadoresfc.model;

public class UserAdmin {
    private  String usuario;
    private String email;
    private String senha;

    public UserAdmin(String email, String senha, String usuario) {
        this.email = email;
        this.senha = senha;
        this.usuario = usuario;
    }

    public UserAdmin(){

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
