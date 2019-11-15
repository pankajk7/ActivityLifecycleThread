package com.pankaj.activitylifecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmet_layout.*

class Fragment2 : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment-Lifecycle-2", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment-Lifecycle-2", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment-Lifecycle-2", "onCreateView")
        val view = inflater.inflate(R.layout.fragment2_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment-Lifecycle-2", "onViewCreated")
        button.setOnClickListener {
            startActivity(Intent(activity, Activity2::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment-Lifecycle-2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment-Lifecycle-2", "onResume")
    }

    override fun onPause() {
        Log.d("Fragment-Lifecycle-2", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Fragment-Lifecycle-2", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Fragment-Lifecycle-2", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Fragment-Lifecycle-2", "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Fragment-Lifecycle-2", "onDetach")
        super.onDetach()
    }

    companion object {

        fun getInstance(): Fragment {
            return Fragment2()
        }
    }
}