package com.example.myapplication

import android.graphics.RectF
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EdificioViewModel : ViewModel() {

    private val _ambientes = MutableLiveData<List<Ambiente>>()
    val ambientes: LiveData<List<Ambiente>> get() = _ambientes

    init {
        cargarDatosDesdeArchivo()
    }

    private fun cargarDatosDesdeArchivo() {
        // Simulación de lectura desde un archivo JSON o CSV
        val listaAmbientes = listOf(
            Ambiente("Patio 1", RectF(100f, 100f, 300f, 300f)),
            Ambiente("Salón 1", RectF(350f, 100f, 550f, 300f)),
            Ambiente("Patio 2", RectF(100f, 350f, 300f, 550f)),
            Ambiente("Salón 2", RectF(350f, 350f, 550f, 550f))
        )
        _ambientes.postValue(listaAmbientes)
    }
}