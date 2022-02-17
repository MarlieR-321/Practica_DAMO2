package uca.ni.edu.salario

data class Empleado(private val nombre:String, private  val cargo:String,private val salario:Double) {

    val salarioAumentado:Double
        get() {
            if(salario in 0.0..5000.00){
                return  (1.2*salario)
            }

            if (salario in 5000.01..10000.00){
                return (1.15*salario)
            }
            return (1.1 *salario)
        }


    val aumento:String
        get() = "El salario del $cargo: $nombre ha sido aumentado a $salarioAumentado"
}