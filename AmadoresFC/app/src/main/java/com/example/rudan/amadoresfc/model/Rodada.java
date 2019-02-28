package com.example.rudan.amadoresfc.model;

import java.util.ArrayList;
import java.util.List;

public class Rodada {
    private int numero;
    private transient String key;
    List<Partida> partidas;

    public Rodada(){

    }

    public Rodada(int numero){
        this.numero = numero;
        partidas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public void addPartida(Partida partida){
        this.partidas.add(partida);
    }
}
