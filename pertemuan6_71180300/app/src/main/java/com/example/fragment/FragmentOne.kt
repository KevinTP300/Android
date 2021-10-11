package com.example.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class FragmentOne:  Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val on = inflater.inflate(R.layout.one_fragment, container, false)
        val btnFgn = on.findViewById<Button>(R.id.btnFragmentOne)
        btnFgn.setOnClickListener {
        val intent = Intent(context, MainActivity2::class.java)
            context?.startActivity(intent)
    }
        return on
    }
}