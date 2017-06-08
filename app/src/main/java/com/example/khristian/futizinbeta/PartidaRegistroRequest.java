package com.example.khristian.futizinbeta;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Khristian on 04/06/2017.
 */

public class PartidaRegistroRequest extends StringRequest {
    private static final String REQUEST_PARTIDA_REGISTRO_URL = "http://futizin.pe.hu/registroPartida.php";
    private Map<String, String> params;

    public PartidaRegistroRequest (String local, String data, String horario, int faixa_etaria, int valor, int quantidade_jogadores, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_PARTIDA_REGISTRO_URL, listener, null);
        params = new HashMap<>();
        params.put("local", local);
        params.put("data", data);
        params.put("horario", horario);
        params.put("faixa_etaria", faixa_etaria + "");
        params.put("valor", valor + "");
        params.put("quantidade_jogadores", quantidade_jogadores + "");
    }

    @Override

    public Map<String, String> getParams() {
        return params;
    } 
}
