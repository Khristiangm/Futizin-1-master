package com.example.khristian.futizinbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by fabio on 09/04/2017.
 */
public class LoginActivity extends Activity {
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());


        final EditText etUsuarioLogin = (EditText) findViewById(R.id.etUsuarioLogin);
        final EditText etUsuarioSenha = (EditText) findViewById(R.id.etUsuarioSenha);
        final Button btnLogin = (Button) findViewById(R.id.btn_Login);
        final TextView registrarLink = (TextView) findViewById(R.id.tvRegistrar);
        final Button fbLogin = (Button) findViewById(R.id.login_button);
        initializeControls();
        loginWithFB();

        registrarLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registarIntent = new Intent(LoginActivity.this, RegistroActivity.class);
                LoginActivity.this.startActivity(registarIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String login_usuario = etUsuarioLogin.getText().toString();
                final String senha_usuario = etUsuarioSenha.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");


                            if (sucesso){
                                Toast.makeText(getBaseContext(), "Usuario Conectado Com Sucesso",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, LobbyActivity.class);
                                LoginActivity.this.startActivity(intent);



                            }else{
                                Toast.makeText(getBaseContext(), "Usuario/Senha Incorreto, ou nao Registrado",Toast.LENGTH_SHORT).show();
                                /*AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Não foi possivel Logar")
                                        .setNegativeButton("Tente novamente", null)
                                        .create()
                                        .show();*/

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(login_usuario, senha_usuario, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);


            }
        });
    }

    private void initializeControls(){
        callbackManager = CallbackManager.Factory.create();
    }

    private void loginWithFB(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getBaseContext(), "Usuario Conectado Com Sucesso",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, LobbyActivity.class);
                LoginActivity.this.startActivity(intent);

            }

            @Override
            public void onCancel() {
                Toast.makeText(getBaseContext(),"Login Cancelado",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getBaseContext(),"Erro de Login" + error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
