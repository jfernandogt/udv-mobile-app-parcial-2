package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcular.setOnClickListener {
            val salarioStr = binding.salario.text.toString()
            val salario = salarioStr.toFloatOrNull()
            val nombres = binding.nombres.text.toString()
            val apellidos = binding.apellidos.text.toString()
            val edadStr = binding.edad.text.toString()
            val edad = edadStr.toIntOrNull()
            val correo = binding.correo.text.toString()

            if(salario != null) {
                var isr: Double = 0.00
                val igss: Double = (salario * 4.83 / 100)
                var deducciones: Double = igss

                if (salario >= 4167) {
                    isr = ((salario * 5 / 100).toDouble())
                    deducciones = igss + isr
                }

                binding.nombresResultado.text = "Nombres: ${nombres}"
                binding.apellidosResultado.text = "Apellidos: ${apellidos}"
                binding.edadResultado.text = "Edad: ${edad}"
                binding.correoResultado.text = "Correo: ${correo}"
                binding.sueldoSinDeducciones.text = "Sueldo sin deducciones: ${salario.toString()}"
                binding.sueldoConDeducciones.text = "Sueldo con deducciones: ${(salario - deducciones).toString()}"
                binding.igss.text = "Igss: ${igss}"
                binding.isr.text = "Isr: ${isr}"
            }
        }
    }

}