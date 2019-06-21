package com.example.weather_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ciudad = intent.getStringExtra(CiudadesActivity.TAG)

        if (Network.red(this)) {
            solicitudHttpVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=5f79d7c454fb39f7bc63cf2c1ab67fe8&units=metric&lang=es")
            //5f79d7c454fb39f7bc63cf2c1ab67fe8
            //ID Vancouver 6173331
            //ID Montreal 6077243
        } else {
            Toast.makeText(this,"No hay red", Toast.LENGTH_SHORT).show()
        }

    }

    //Metodo para Volley

    private fun solicitudHttpVolley(url: String) {

        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
            try {
                Log.d("SolicitudVolley", response)

                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)

                tv_ciudad?.text = ciudad.name
                tv_grados?.text= ciudad.main?.temp.toString() + "°"
                tv_estatus?.text = ciudad.weather?.get(0)?.description
                Log.d("GSON", ciudad.name)
            } catch (e: Exception) {

            }
        }, Response.ErrorListener {})

        queue.add(solicitud)
    }
}
