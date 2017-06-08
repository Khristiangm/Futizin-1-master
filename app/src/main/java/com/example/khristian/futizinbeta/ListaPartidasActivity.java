package com.example.khristian.futizinbeta;

import android.app.Activity;
import android.icu.text.MessagePattern;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khristian on 11/05/2017.
 */

public class ListaPartidasActivity extends Activity  {
    // Will show the string "data" that holds the results
    TextView results;
    // URL of object to be parsed
    String JsonURL = "http://futizin.pe.hu/selectPartidas.php";
    // This string will hold the results
    String data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_partida);
        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        // Casts results into the TextView found within the main layout XML with id jsonData
        results = (TextView) findViewById(R.id.partidasDisponiveis);

        // Creating the JsonObjectRequest class called obreq, passing required parameters:
        //GET is used to fetch data from the server, JsonURL is the URL to be fetched from.
        JsonArrayRequest obreq = new JsonArrayRequest(Request.Method.GET, JsonURL,null,
                // The third parameter Listener overrides the method onResponse() and passes
                //JSONObject as a parameter
                new Response.Listener<JSONArray>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            String data = "";
                            List<Partida> partidas = new ArrayList<>();
                            for(int i = 0; i < response.length(); i++) {
                                JSONObject obj = response.getJSONObject(i);
                                Partida tmp = Util.toPartida(obj);
                                partidas.add(tmp);
                                /*JSONObject obj = response.getJSONObject("colorObject");
                                // Retrieves the string labeled "colorName" and "description" from
                                //the response JSON Object
                                //and converts them into javascript objects
                                String color = obj.getString("colorName");
                                String desc = obj.getString("description");

                                // Adds strings from object to the "data" string
                                data += "Color Name: " + color +
                                        "nDescription : " + desc;*/

                                // Adds the data string to the TextView "results"
                            }
                            ListView listaPartidas = (ListView) findViewById(R.id.listaPartidas);
                            PartidaAdapter lPartidaAdapter = new PartidaAdapter(ListaPartidasActivity.this,R.layout.partida_item,partidas);
                            listaPartidas.setAdapter(lPartidaAdapter);
                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (/*JSONException*/ Exception e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }
                    }
                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.getMessage());
                    }
                }
        );
        // Adds the JSON object request "obreq" to the request queue
        requestQueue.add(obreq);
    }

}
