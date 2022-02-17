package uca.ni.edu.salario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uca.ni.edu.salario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        aumentar()

    }

    private fun aumentar() {
        binding.run {
            btnCalcular.setOnClickListener {
                val nombre:String =etNombre.text.toString()
                val cargo:String = etCargo.text.toString()
                val salario:Double = etndSalario.text.toString().toDouble()
                val empleado = Empleado(nombre,cargo,salario)

                tvNota.text = empleado.aumento
            }

        }
    }

}