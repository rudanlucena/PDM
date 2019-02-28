package com.example.rudan.amadoresfc.model;

import java.io.Serializable;
import java.util.Objects;

public class Partida implements Serializable{
    private int placarMandante;
    private int placarVisitante;
    private Clube clubeMandante;
    private Clube clubeVisitante;
    private String dataPartida;

    public Partida(){

    }

    public Partida(Clube clubeMandante, Clube clubeVisitante, String dataPartida) {
        this.clubeMandante = clubeMandante;
        this.clubeVisitante = clubeVisitante;
        this.dataPartida = dataPartida;
    }

    public int getPlacarMandante() {
        return placarMandante;
    }

    public void setPlacarMandante(int placarMandante) {
        this.placarMandante = placarMandante;
    }

    public int getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(int placarVisitante) {
        this.placarVisitante = placarVisitante;
    }

    public Clube getClubeMandante() {
        return clubeMandante;
    }

    public void setClubeMandante(Clube clubeMandante) {
        this.clubeMandante = clubeMandante;
    }

    public Clube getClubeVisitante() {
        return clubeVisitante;
    }

    public void setClubeVisitante(Clube clubeVisitante) {
        this.clubeVisitante = clubeVisitante;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partida partida = (Partida) o;
        return placarMandante == partida.placarMandante &&
                placarVisitante == partida.placarVisitante &&
                Objects.equals(clubeMandante, partida.clubeMandante) &&
                Objects.equals(clubeVisitante, partida.clubeVisitante) &&
                Objects.equals(dataPartida, partida.dataPartida);
    }

    @Override
    public int hashCode() {

        return Objects.hash(placarMandante, placarVisitante, clubeMandante, clubeVisitante, dataPartida);
    }

    @Override
    public String toString() {
        return "Partida{" +
                "placarMandante=" + placarMandante +
                ", placarVisitante=" + placarVisitante +
                ", clubeMandante=" + clubeMandante +
                ", clubeVisitante=" + clubeVisitante +
                ", dataPartida='" + dataPartida + '\'' +
                '}';
    }
}
