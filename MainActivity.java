package com.example.ejemplovolleyrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Equipo> listaEquipos;

    RecyclerView rvEquipos;

    String ESCUDOS_URL = "http://192.168.0.11/Equipos/obtenerEquipos.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEquipos = findViewById(R.id.rvEquipos);
        rvEquipos.setLayoutManager(new GridLayoutManager(this, 2));

        listaEquipos = new ArrayList<Equipo>();

        obtenerEquipos();
    }

    public void obtenerEquipos() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ESCUDOS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("Equipos");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                                String auxEscudo = jsonObject1.getString("escudo");
                                String auxNombre = jsonObject1.getString("nombre");

                                auxEscudo = auxEscudo.replace(" ", "%20");
                                auxEscudo = auxEscudo.replace("localhost", "192.168.0.11");

                                listaEquipos.add(new Equipo(auxNombre, auxEscudo));
                            }

                            AdapterEquipo adaptador = new AdapterEquipo(listaEquipos);

                            rvEquipos.setAdapter(adaptador);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(stringRequest);
    }
}
