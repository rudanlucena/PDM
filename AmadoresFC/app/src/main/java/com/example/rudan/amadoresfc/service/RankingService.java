package com.example.rudan.amadoresfc.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.rudan.amadoresfc.admin.GerenciarRankingActivity;
import com.example.rudan.amadoresfc.admin.GerenciarRodadasActivity;
import com.example.rudan.amadoresfc.model.Clube;
import com.example.rudan.amadoresfc.model.Partida;
import com.example.rudan.amadoresfc.model.Rodada;
import com.example.rudan.amadoresfc.util.NotificationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RankingService extends IntentService {

    public RankingService() {
        super("RankingService");
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        Random gerador = new Random();
        List<Clube> clubes = new ArrayList<>();

        Clube vasco = new Clube("vasco");
        vasco.setPontuacao(gerador.nextInt(26));
        Clube flamengo = new Clube("flamengo");
        flamengo.setPontuacao(gerador.nextInt(26));
        Clube botafogo = new Clube("botafogo");
        botafogo.setPontuacao(gerador.nextInt(26));
        Clube fluminense = new Clube("fluminense");
        fluminense.setPontuacao(gerador.nextInt(26));

//        List<Rodada> rodadas = GerenciarRodadasActivity.rodadas;
//
//        for (Rodada rodada: rodadas){
//            for(Partida partida: rodada.getPartidas()){
//                if (partida.getClubeMandante().getNome().equals("vasco")){
//                    if(partida.getPlacarMandante() > partida.getPlacarVisitante()){
//                        vasco.setPontuacao(vasco.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        vasco.setPontuacao(vasco.getPontuacao()+1);
//                    }
//                }
//
//                if (partida.getClubeVisitante().getNome().equals("vasco")){
//                    if(partida.getPlacarVisitante() > partida.getPlacarMandante()){
//                        vasco.setPontuacao(vasco.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        vasco.setPontuacao(vasco.getPontuacao()+1);
//                    }
//                }
//
//                if (partida.getClubeMandante().getNome().equals("flamengo")){
//                    if(partida.getPlacarMandante() > partida.getPlacarVisitante()){
//                        flamengo.setPontuacao(flamengo.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        flamengo.setPontuacao(flamengo.getPontuacao()+1);
//                    }
//                }
//
//                if (partida.getClubeVisitante().getNome().equals("flamengo")){
//                    if(partida.getPlacarVisitante() > partida.getPlacarMandante()){
//                        flamengo.setPontuacao(flamengo.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        flamengo.setPontuacao(flamengo.getPontuacao()+1);
//                    }
//                }
//
//                if (partida.getClubeMandante().getNome().equals("botafogo")){
//                    if(partida.getPlacarMandante() > partida.getPlacarVisitante()){
//                        botafogo.setPontuacao(botafogo.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        botafogo.setPontuacao(botafogo.getPontuacao()+1);
//                    }
//                }
//
//                if (partida.getClubeVisitante().getNome().equals("botafogo")){
//                    if(partida.getPlacarVisitante() > partida.getPlacarMandante()){
//                        botafogo.setPontuacao(botafogo.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        botafogo.setPontuacao(botafogo.getPontuacao()+1);
//                    }
//                }
//
//                if (partida.getClubeMandante().getNome().equals("fluminense")){
//                    if(partida.getPlacarMandante() > partida.getPlacarVisitante()){
//                        fluminense.setPontuacao(fluminense.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        fluminense.setPontuacao(fluminense.getPontuacao()+1);
//                    }
//                }
//
//                if (partida.getClubeVisitante().getNome().equals("fluminense")){
//                    if(partida.getPlacarVisitante() > partida.getPlacarMandante()){
//                        fluminense.setPontuacao(fluminense.getPontuacao()+3);
//                    }
//                    if(partida.getPlacarMandante() == partida.getPlacarVisitante()){
//                        fluminense.setPontuacao(fluminense.getPontuacao()+1);
//                    }
//                }
//
//
//
//
//            }
//        }

        clubes.add(vasco);
        clubes.add(flamengo);
        clubes.add(fluminense);
        clubes.add(botafogo);
        GerenciarRankingActivity.setClubes(clubes);

        Intent notifIntent = new Intent(getApplicationContext(), GerenciarRankingActivity.class);
        NotificationUtil.create(getApplicationContext(), notifIntent, "Classificação Atualizada", "Após a remoção da partida os dados foram atualizados", 1 );
        Log.d("serviceranking", "chamado");

    }
}
