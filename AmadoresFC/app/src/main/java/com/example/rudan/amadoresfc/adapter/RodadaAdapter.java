package com.example.rudan.amadoresfc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.model.Partida;
import com.example.rudan.amadoresfc.model.Rodada;

import java.util.List;

public class RodadaAdapter extends BaseAdapter {
    private final Context context;
    private final List<Rodada> rodadas;

    public RodadaAdapter(Context context, List<Rodada> rodadas){
        this.context=context;
        this.rodadas=rodadas;
    }

    @Override
    public int getCount() {
        return rodadas!=null ? rodadas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return rodadas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_rodada, parent, false);

        TextView numeroRodada = view.findViewById(R.id.textNumeroRodada);

        Rodada rodada = rodadas.get(position);
        numeroRodada.setText("Rodada: "+rodada.getNumero());

        return view;
    }
}
