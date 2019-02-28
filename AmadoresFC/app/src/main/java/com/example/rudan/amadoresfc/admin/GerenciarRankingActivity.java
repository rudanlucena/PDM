package com.example.rudan.amadoresfc.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.rudan.amadoresfc.R;
import com.example.rudan.amadoresfc.adapter.PartidaAdapter;
import com.example.rudan.amadoresfc.adapter.RankingAdapter;
import com.example.rudan.amadoresfc.model.Clube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciarRankingActivity extends AppCompatActivity {
    private ListView listClubes;
    public static List<Clube> clubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_ranking);
        listClubes = findViewById(R.id.listRanking);
        //clubes = new ArrayList<>();

        Collections.sort(clubes);
        listClubes.setAdapter(new RankingAdapter(this, clubes));
    }

    public static List<Clube> getClubes() {
        return clubes;
    }

    public static void setClubes(List<Clube> clubes) {
        GerenciarRankingActivity.clubes = clubes;
    }
}
