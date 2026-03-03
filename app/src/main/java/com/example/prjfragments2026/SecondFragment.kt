package com.example.prjfragments2026

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
       val layout = inflater.inflate(R.layout.fragment_second, container, false)
        val txtInput :EditText = layout.findViewById(R.id.txtInput)
        val btnPressMe:Button = layout.findViewById(R.id.btnFrag2)
        val tvOutput :TextView = layout.findViewById(R.id.lblOutput)

        btnPressMe.setOnClickListener{
            tvOutput.text=txtInput.text
        }

        return layout
    }


}