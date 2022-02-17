package uca.ni.edu.myapplication

data class Calificacion(private val sis1:Double, private  val sis2:Double,private val exam:Double) {
    val notaFinal:Double
        get() = sis1+sis2+exam
}