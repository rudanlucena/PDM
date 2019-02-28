package com.example.rudan.amadoresfc.model;

import java.io.Serializable;

public class Clube implements Serializable, Comparable<Clube> {
    private String nome;
    private int pontuacao;
    private transient String keyClube;

    public Clube(){

    }

    public  Clube(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getKeyClube() {
        return keyClube;
    }

    @Override
    public String toString() {
        return "Clube{" +
                "nome='" + nome + '\'' +
                ", pontuacao=" + pontuacao +
                ", keyClube='" + keyClube + '\'' +
                '}';
    }

    public void setKeyClube(String keyClube) {
        this.keyClube = keyClube;
    }

    @Override
    public int compareTo(Clube o) {
        if (this.pontuacao > o.getPontuacao()) {
            return -1;
        }
        if (this.pontuacao < o.getPontuacao()) {
            return 1;
        }
        return 0;
    }
}
