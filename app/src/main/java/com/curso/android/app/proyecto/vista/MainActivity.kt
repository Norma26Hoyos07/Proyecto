package com.curso.android.app.proyecto.vista


import android.os.Bundle
import android.text.Layout
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.proyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        mainViewModel.modelo.observe(this) {
            binding.resultado.text = "${it.resulta}"

        }



        binding.boton.setOnClickListener() {
            mainViewModel.comparar(
                binding.palabra1.text.toString(),
                binding.palabra2.text.toString()
            )
        }
    }
}