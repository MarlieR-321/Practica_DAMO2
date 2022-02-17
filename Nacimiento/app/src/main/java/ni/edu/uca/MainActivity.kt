package ni.edu.uca

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mDateSetListener:DatePickerDialog.OnDateSetListener


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mDateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            binding.tvSeleccione.text = "$day / ${month+1} / $year"
            val edad = diferencia(year, month, day)
            if(edad<18){
                binding.ivFoto.setImageResource(R.drawable.juguete)
            }else{
                binding.ivFoto.setImageResource(R.drawable.factura)
            }
        }

        binding.tvSeleccione.setOnClickListener {
            var cal:Calendar = Calendar.getInstance()
            var year = cal.get(Calendar.YEAR)
            var month = cal.get(Calendar.MONTH)
            var day = cal.get(Calendar.DAY_OF_MONTH)

            var dialog = DatePickerDialog(
                this, android.R.style.Theme_Holo_Dialog_MinWidth,
                mDateSetListener, year, month,day
            )

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
    }

    private fun diferencia(year: Int, month: Int, day: Int): Int {
        val strInicio = "$day/${month + 1}/$year"
        val formato = SimpleDateFormat("dd/mm/yyyy")
        val inicio: Date = formato.parse(strInicio)

        val actual = Date(System.currentTimeMillis())
        return (actual.year - inicio.year)
    }
}