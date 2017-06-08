package com.example.khristian.futizinbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Khristian on 11/05/2017.
 */

public class LobbyActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        final Button btn_BuscarPartida = (Button) findViewById(R.id.btn_BuscarPartida);
        final Button btn_CriarPartida = (Button) findViewById(R.id.btn_CriarPartida);

        btn_BuscarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listaIntent = new Intent(LobbyActivity.this, ListaPartidasActivity.class);
                LobbyActivity.this.startActivity(listaIntent);

            }
        });

        btn_CriarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent criarPartidaIntent = new Intent(LobbyActivity.this, PartidaRegistroActivity.class);
                LobbyActivity.this.startActivity(criarPartidaIntent);

            }
        });
    }
}