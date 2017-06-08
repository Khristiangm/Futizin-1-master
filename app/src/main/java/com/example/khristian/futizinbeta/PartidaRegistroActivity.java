package com.example.khristian.futizinbeta;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Khristian on 11/05/2017.
 */

public class PartidaRegistroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_partida);

        final EditText etLocalPartida = (EditText) findViewById(R.id.etLocalPartida);
        final EditText etHorarioPartida = (EditText) findViewById(R.id.etHorarioPartida);
        final EditText etDataPartida = (EditText) findViewById(R.id.etDataPartida);
        final EditText etFaixaEtaria = (EditText) findViewById(R.id.etFaixaEtaria);
        final EditText etValorPartida = (EditText) findViewById(R.id.etValorPartida);
        final EditText etQuantidadeJogadores = (EditText) findViewById(R.id.etQuantidadeJogadores);
        final Button btnCriarPartida = (Button) findViewById(R.id.btn_CriarPartida);


        btnCriarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String local = etLocalPartida.getText().toString();
                final String data = etDataPartida.getText().toString();
                final String horario = etHorarioPartida.getText().toString();
                final int faixa_etaria = Integer.parseInt(etFaixaEtaria.getText().toString());
                final int valor = Integer.parseInt(etValorPartida.getText().toString());
                final int quantidade_jogadores = Integer.parseInt(etQuantidadeJogadores.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            if (sucesso){
                                Toast.makeText(getBaseContext(), "Partida Criada Com Sucesso",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(PartidaRegistroActivity.this, LobbyActivity.class);
                                PartidaRegistroActivity.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(PartidaRegistroActivity.this);
                                builder.setMessage("Não foi possivel gravar registros")
                                        .setNegativeButton("Tente novamente", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                PartidaRegistroRequest partidaRequest = new PartidaRegistroRequest(local, data, horario, faixa_etaria, valor, quantidade_jogadores, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PartidaRegistroActivity.this);
                queue.add(partidaRequest);
            }
        });



    }

    /*public void criarPartida(View view) {
        boolean granted = true;

        if (etLocalPartida.getText().toString().isEmpty()) {
            etLocalPartida.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            etLocalPartida.setBackground(getDrawable(R.drawable.border));
        }
        if (horarioPartida.getText().toString().isEmpty()) {
            horarioPartida.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            horarioPartida.setBackground(getDrawable(R.drawable.border));
        }
        if (dataPartida.getText().toString().isEmpty()) {
            dataPartida.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            dataPartida.setBackground(getDrawable(R.drawable.border));
        }
        if (faixaEtaria.getText().toString().isEmpty()) {
            faixaEtaria.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            faixaEtaria.setBackground(getDrawable(R.drawable.border));
        }
        if (valorPartida.getText().toString().isEmpty()) {
            valorPartida.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            valorPartida.setBackground(getDrawable(R.drawable.border));
        }
        if (quantidadeJogadores.getText().toString().isEmpty()) {
            quantidadeJogadores.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            quantidadeJogadores.setBackground(getDrawable(R.drawable.border));
        }

        if (granted == true) {
            Toast.makeText(this, "Partida criada com Sucesso!.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PartidaRegistroActivity.this, ListaPartidasActivity.class);
            startActivity(intent);
        }
    }*/
}
