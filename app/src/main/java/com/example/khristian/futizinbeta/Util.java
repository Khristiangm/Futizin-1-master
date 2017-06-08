package com.example.khristian.futizinbeta;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Diego on 07/06/2017.
 */

public class Util {
    public static Partida toPartida(JSONObject json){
        Partida partida = null;
        try {
            partida = new Partida();
            partida.setID(json.getInt("id_partida"));
            partida.setData(json.getString("data"));
            partida.setLocal(json.getString("local"));
            partida.setHorario(json.getString("horario"));
            partida.setFaixaEtaria(json.getInt("faixa_etaria"));
            partida.setValor(json.getInt("valor"));
            partida.setQuantidadeJogadores(json.getInt("quantidade_jogadores"));
        }catch (JSONException e){
            Log.e("JSONFAIL",e.getMessage());
        }finally {
            return partida;
        }
    }
}
