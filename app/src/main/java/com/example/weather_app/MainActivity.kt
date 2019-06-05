package com.example.weather_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ciudad = intent.getStringExtra(CiudadesActivity.TAG)

        val ciudadVc = Ciudad("Vancouver", 16, "Lluvia")
        val ciudadMt = Ciudad("Montreal", 19, "Nublado")

        if (ciudad == "ciudad-vancouver") {
            tv_ciudad.text = ciudadVc.nombre
            tv_grados.text= ciudadVc.grados.toString() + "°"
            tv_estatus.text = ciudadVc.estatus

        } else if (ciudad == "ciudad-montreal") {
            tv_ciudad.text  = ciudadMt.nombre
            tv_grados.text= ciudadMt.grados.toString() + "°"
            tv_estatus.text = ciudadMt.estatus

        } else {
            Toast.makeText(this, "No se pudo obtener la informacion", Toast.LENGTH_SHORT).show()
        }


    }
}
