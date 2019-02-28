package com.example.rudan.amadoresfc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.model.Partida;

import java.util.List;

public class PartidaAdapter extends BaseAdapter {
    private final Context context;
    private final List<Partida> partidas;

    public PartidaAdapter(Context context, List<Partida> partidas){
        this.context=context;
        this.partidas=partidas;
    }

    @Override
    public int getCount() {
        return partidas!=null ? partidas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return partidas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_partida, parent, false);

        TextView mandante = view.findViewById(R.id.textClubeMandante);
        TextView visitante = view.findViewById(R.id.textClubeVisitante);
        TextView placarMandante = view.findViewById(R.id.textPlacarMandante);
        TextView placarVisitante = view.findViewById(R.id.textPlacarVisitante);
        TextView dataPartida = view.findViewById(R.id.textDataPartida);

        Partida partida = partidas.get(position);

        mandante.setText(partida.getClubeMandante().getNome());
        placarMandante.setText(partida.getPlacarMandante()+"");
        visitante.setText(partida.getClubeVisitante().getNome());
        placarVisitante.setText(partida.getPlacarVisitante()+"");
        dataPartida.setText(partida.getDataPartida());
        return view;
    }
}
