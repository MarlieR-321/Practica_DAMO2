package com.example.pagotienda

import android.media.MediaCodec
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagotienda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var precio = 0.0
    var compras: MutableList<Articulo> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ingresar()
        getIva()
        nuevo()
    }

    fun initRecycler(){
        binding.rvCompra.layoutManager = LinearLayoutManager(this)
        val adapter = ArticuloAdapter(compras)
        binding.rvCompra.adapter = adapter
    }

    fun ingresar(){
        binding.run {
            btnIngresar.setOnClickListener {
                compras.add(
                    Articulo(
                        etndPrecio.text.toString().toDouble(),
                        etndCantidad.text.toString().toInt().toDouble(),
                        etNombre.text.toString()
                    )
                )
                initRecycler()

                compras.forEach {
                    precio += it.subtotalPorArt
                    tvSubtotal.text = "Subtotal: $precio"
                }
                tvIVA.text = "IVA: "
                tvNeto.text = "Neto: "
            }
        }

    }

    fun getIva(){
        binding.run {
            btnIVA.setOnClickListener {
                val compra = Compra(precio)

                tvIVA.text = "IVA: ${compra.iva}"
                tvNeto.text = "Neto: ${compra.total}"
            }
        }
    }

    fun nuevo(){
        binding.run {
            btnNuevo.setOnClickListener {
                compras = mutableListOf()
                initRecycler()
                tvIVA.text = "IVA: 0.0"
                tvNeto.text = "Neto: 0.0"
                precio = 0.0
                tvSubtotal.text = "Subtotal: $precio"
            }
        }

    }
}
