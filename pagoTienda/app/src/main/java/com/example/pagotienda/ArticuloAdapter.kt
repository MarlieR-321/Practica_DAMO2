package com.example.pagotienda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticuloAdapter(val compra:List<Articulo>):RecyclerView.Adapter<ArticuloAdapter.ArticuloHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticuloHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, null, false)
        return ArticuloHolder(view)
    }

    override fun onBindViewHolder(holder: ArticuloHolder, position: Int) {
        val current =compra[position]
        holder.tvNombre.text = current.nombre
        holder.tvPrecio.text = current.precio.toString()
        holder.tvCantidad.text = current.cantidad.toString()
    }

    override fun getItemCount(): Int = compra.size

    class ArticuloHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tvProducto)
        val tvPrecio:TextView = itemView.findViewById(R.id.tvPrecio)
        val tvCantidad:TextView = itemView.findViewById(R.id.tvCantidad)
    }

}