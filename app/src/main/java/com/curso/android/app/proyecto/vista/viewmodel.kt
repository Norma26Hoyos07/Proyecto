package com.curso.android.app.proyecto.vista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.proyecto.modelo.Modelo
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    // Solo queremos que se pueda leer el contador
    val modelo: LiveData<Modelo> get() = _modelo
    // no nos interesa que se modifique por fuera del ViewModel
    private var _modelo = MutableLiveData<Modelo>(Modelo("","","estan vacias"))
    var texto= "siguen vacias"
    fun comparar(a:String,b:String) {
       //println(a)
        texto="estan vacias"
        if(a!="" || b!=""){
        if (a == b) {
            texto = "Son iguales"
        } else {
            texto = "Son distintas"
        }}

      actualizar(texto,a,b)
    }
    private fun actualizar(texto:String,a:String,b:String){
        viewModelScope.launch {
            _modelo.value = Modelo(a,b,texto)

        }

    }

    }





