package com.example.rudan.amadoresfc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.model.Clube;
import com.example.rudan.amadoresfc.model.Rodada;

import java.util.List;

public class RankingAdapter extends BaseAdapter {
    private final Context context;
    private final List<Clube> clubes;

    public RankingAdapter(Context context, List<Clube> clubes){
        this.context=context;
        this.clubes=clubes;
    }

    @Override
    public int getCount() {
        return clubes!=null ? clubes.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return clubes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_ranking, parent, false);

        TextView nomeClube = view.findViewById(R.id.textNomeClube);
        TextView pontuacaoClube = view.findViewById(R.id.textPontuacaoClube);

        Clube clube = clubes.get(position);
        nomeClube.setText(clube.getNome());
        pontuacaoClube.setText(Integer.toString(clube.getPontuacao()));

        return view;
    }
}
