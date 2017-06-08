package com.example.khristian.futizinbeta;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Khristian on 11/05/2017.
 */

public class RegistroRequest extends StringRequest {
    private static final String REQUEST_USUARIO_INSERT_URL = "http://futizin.pe.hu/registroUsuario.php";
    private Map<String, String> params;

    public RegistroRequest (String nome_usuario, String email_usuario, String data_nascimento_usuario, String contato_usuario, String login_usuario, String senha_usuario, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_USUARIO_INSERT_URL, listener, null);
        params = new HashMap<>();
        params.put("nome_usuario", nome_usuario);
        params.put("email_usuario", email_usuario);
        params.put("data_nascimento_usuario", data_nascimento_usuario);
        params.put("contato_usuario", contato_usuario);
        params.put("login_usuario", login_usuario);
        params.put("senha_usuario", senha_usuario);
    }

    @Override

    public Map<String, String> getParams() {
        return params;
    }

}
