package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.EdificioView
import com.example.myapplication.EdificioViewModel

class EdificioFragment : Fragment() {

    private lateinit var viewModel: EdificioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(EdificioViewModel::class.java)
        val edificioView = EdificioView(context)

        // Observar los datos de los ambientes y actualizar la vista
        viewModel.ambientes.observe(viewLifecycleOwner, Observer { ambientes ->
            edificioView.setAmbientes(ambientes)
        })

        return edificioView
    }
}