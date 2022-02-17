package uca.ni.edu.adivinar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uca.ni.edu.adivinar.databinding.ActivityMainBinding

// Realice una aplicación que permita simular un juego de adivinar un numero entre un rango
//predeterminado por el usuario, se tendrán máximo 3 intentos para adivinar dicho número.

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var intento = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        generarAleatorio()
    }

    private fun generarAleatorio() {
        binding.run {
            btnRango.setOnClickListener {
                intento = 3
                val menor = etnNumMen.text.toString().toInt()
                val mayor = etnMay.text.toString().toInt()
                if ( menor < mayor){
                    val rndm = (menor..mayor).random( )
                    adivinar(rndm)
                    tvRango.text = "Rango: $menor - $mayor"
                }else{
                    tvRango.text = "Verifique el orden de los  números en rango"
                }
            }
        }
    }

    private fun adivinar(rndm:Int) {

        binding.run {
            btnAdivinar.setOnClickListener {
                if(intento in 1..3){
                    if(etnAdivina.text.toString().toInt() == rndm){
                        tvNota.text = "Numero ${etnAdivina.text.toString().toInt()} adivinado"
                    }else{
                        if(intento ==1){
                            tvNota.text = "Sin intentos restantes, ingrese nuevo rango"
                        }else{
                            intento--
                            tvNota.text = "Intentos restantes: $intento"
                        }
                    }
                }
            }
        }
    }
}