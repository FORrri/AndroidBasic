package com.coding404.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coding404.fragment.databinding.FragmentFirstBinding

class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false)
        val binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


}