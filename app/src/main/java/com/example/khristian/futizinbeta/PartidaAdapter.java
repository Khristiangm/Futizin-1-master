package com.example.khristian.futizinbeta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Khristian on 11/05/2017.
 */

public class PartidaAdapter extends ArrayAdapter<Partida> {
    private List<Partida> partidas;
    private int layout;

    public PartidaAdapter(Context context, int resource, List<Partida> partidas) {
        super(context, resource, partidas);
        this.partidas = partidas;
        layout = resource;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View localView = contentView;


        if (localView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = inflater.inflate(layout, null);
        }

        Partida partida = partidas.get(position);

        if (partida != null) {
            TextView textID = (TextView) localView.findViewById(R.id.textID);
            TextView textlocal = (TextView) localView.findViewById(R.id.textLocal);
            TextView textdata = (TextView) localView.findViewById(R.id.textData);
            TextView texthorario = (TextView) localView.findViewById(R.id.textHorario);
            TextView textfaixaEtaria = (TextView) localView.findViewById(R.id.textFaixaEtaria);
            TextView textquantidadejogadores = (TextView) localView.findViewById(R.id.textQuantidadeJogadores);
            TextView textvalor = (TextView) localView.findViewById(R.id.textValor);

            if (textID != null) {
                textID.setText(String.valueOf(partida.getID()));
            }
            if (textlocal != null) {
                textlocal.setText(partida.getLocal());
            }
            if (textdata != null) {
                textdata.setText(partida.getData());
            }
            if (texthorario != null) {
                texthorario.setText(String.valueOf(partida.getHorario()));
            }
            if (textfaixaEtaria != null) {
                textfaixaEtaria.setText(String.valueOf(partida.getFaixaEtaria()));
            }
            if (textquantidadejogadores != null) {
                textquantidadejogadores.setText(String.valueOf(partida.getQuantidadeJogadores()));
            }
            if (textvalor != null) {
                textvalor.setText(String.valueOf(partida.getValor()));
            }
        }
        return localView;
    }
}