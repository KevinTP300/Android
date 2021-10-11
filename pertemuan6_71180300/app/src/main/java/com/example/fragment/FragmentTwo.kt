package com.example.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentTwo:  Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val on = inflater.inflate(R.layout.two_fragment, container, false)
        val btnFgn = on.findViewById<Button>(R.id.btnFragmentTwo)
        btnFgn.setOnClickListener {
            val intent = Intent(context, MainActivity3::class.java)
            context?.startActivity(intent)
        }
        return on
    }
}