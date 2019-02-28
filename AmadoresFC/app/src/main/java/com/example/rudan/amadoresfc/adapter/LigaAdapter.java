package com.example.rudan.amadoresfc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.model.Liga;

import java.util.List;

public class LigaAdapter extends BaseAdapter {
    private final Context context;
    private  final List<Liga> ligas;

    public  LigaAdapter(Context context, List<Liga> ligas){
        this.context = context;
        this.ligas = ligas;
    }

    @Override
    public int getCount() {
        return ligas!= null ? ligas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return ligas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_liga, parent, false);
        TextView nomeLiga = view.findViewById(R.id.textNome);
        TextView dataCriacao = view.findViewById(R.id.textDataCriacao);

        Liga liga = ligas.get(position);
        nomeLiga.setText(liga.getNome());
        dataCriacao.setText(liga.getDataCriacao());
        return view;
    }
}
