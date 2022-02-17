package uca.ni.edu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uca.ni.edu.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        validar()
    }

    fun validar(){
        binding.run {
            btnCalcular.setOnClickListener {
                val sis1:Double = etndSistematico1.text.toString().toDouble()
                val sis2:Double = etndSistematico2.text.toString().toDouble()
                val exam:Double = etndExamen.text.toString().toDouble()

                if(sis1 in 0.0..20.0){
                    if (sis2 in 0.0..20.0){
                        if(exam in 0.0..60.0){
                            val nota = Calificacion(sis1,sis2,exam)

                            if (nota.notaFinal <=85.0){
                                tvNota.text = "Usted no ha aprobado con: ${nota.notaFinal}"
                            }else{
                                tvNota.text = "Usted ha aprobado con: ${nota.notaFinal}"
                            }
                        }else{
                            tvNota.text = "El tercer dato esta fuera de rango"
                        }
                    }else{
                        tvNota.text = "El segundo dato esta fuera de rango"
                    }
                }else{
                    tvNota.text = "El primer dato esta fuera de rango"
                }
            }
        }
    }
}