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

public class RegistroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        final EditText etNomeUsuario = (EditText) findViewById(R.id.etNomeUsuario);
        final EditText etEmailUsuario = (EditText) findViewById(R.id.etEmailUsuario);
        final EditText etDataNascimentoUsuario = (EditText) findViewById(R.id.etDataNascimentoUsuario);
        final EditText etContatoUsuario = (EditText) findViewById(R.id.etContatoUsuario);
        final EditText etLoginUsuario = (EditText) findViewById(R.id.etLoginUsuario);
        final EditText etSenhaUsuario = (EditText) findViewById(R.id.etSenhaUsuario);
        final Button btn_RegistrarUsuario = (Button) findViewById(R.id.btn_RegistrarUsuario);

        btn_RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nome_usuario = etNomeUsuario.getText().toString();
                final String email_usuario = etEmailUsuario.getText().toString();
                final String data_nascimento_usuario = etDataNascimentoUsuario.getText().toString();
                final String contato_usuario = etContatoUsuario.getText().toString();
                final String login_usuario = etLoginUsuario.getText().toString();
                final String senha_usuario = etSenhaUsuario.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            if (sucesso){
                                Toast.makeText(getBaseContext(), "Usuario Registrado Com Sucesso",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                                RegistroActivity.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegistroActivity.this);
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

                RegistroRequest registroRequest = new RegistroRequest(nome_usuario, email_usuario, data_nascimento_usuario, contato_usuario, login_usuario, senha_usuario, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegistroActivity.this);
                queue.add(registroRequest);
            }
        });

    }

    /*public void register(View view) {
        boolean granted = true;

        if (nome_usuario.getText().toString().isEmpty()) {
            etNomeUsuario.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            etNomeUsuario.setBackground(getDrawable(R.drawable.border));
        }
        if (etEmailUsuario.getText().toString().isEmpty()) {
            etEmailUsuario.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            etNomeUsuario.setBackground(getDrawable(R.drawable.border));
        }
        if (etDataNascimentoUsuario.getText().toString().isEmpty()) {
            etDataNascimentoUsuario.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            etNomeUsuario.setBackground(getDrawable(R.drawable.border));
        }
        if (etContatoUsuario.getText().toString().isEmpty()) {
            etContatoUsuario.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            etNomeUsuario.setBackground(getDrawable(R.drawable.border));
        }
        if (etSenhaUsuario.getText().toString().isEmpty()) {
            etSenhaUsuario.setBackground(getDrawable(R.drawable.border_error));
            Toast.makeText(this, "Campo Incorreto!.", Toast.LENGTH_SHORT).show();
            granted = false;
        } else {
            etNomeUsuario.setBackground(getDrawable(R.drawable.border));
        }

        if (granted == true) {
            Toast.makeText(this, "Registrado Com Sucesso!.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
            startActivity(intent);
        }*/

}

