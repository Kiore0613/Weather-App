package com.example.weather_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ciudad = intent.getStringExtra(CiudadesActivity.TAG)

        if(Network.red(this)){
            solicitudHttpVolley("http://api.openweathermap.org/data/2.5/weather?id=6173331&appid=5f79d7c454fb39f7bc63cf2c1ab67fe8")
            //5f79d7c454fb39f7bc63cf2c1ab67fe8
            //ID Vancouver 6173331
        }
        else {

        }

        val ciudadVc = Ciudad("Vancouver", 16, "Lluvia")
        val ciudadMt = Ciudad("Montreal", 19, "Nublado")

        if (ciudad == "ciudad-vancouver") {
            tv_ciudad?.text = ciudadVc.nombre
            tv_grados?.text= ciudadVc.grados.toString() + "°"
            tv_estatus?.text = ciudadVc.estatus

        } else if (ciudad == "ciudad-montreal") {
            tv_ciudad?.text  = ciudadMt.nombre
            tv_grados?.text= ciudadMt.grados.toString() + "°"
            tv_estatus?.text = ciudadMt.estatus

        } else {
            Toast.makeText(this, "No se pudo obtener la informacion", Toast.LENGTH_SHORT).show()
        }


    }

    //Metodo para Volley

    private fun solicitudHttpVolley(url:String) {

        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
                response ->
            try {
                Log.d("SolicitudVolley", response)
            }
            catch (e: Exception){

            }
        }, Response.ErrorListener{})

        queue.add(solicitud)
    }
}
