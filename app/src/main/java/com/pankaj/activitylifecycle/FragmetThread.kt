package com.pankaj.activitylifecycle

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmet_layout.*

class FragmetThread : Fragment() {

    var uiHandler: Handler? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment-Lifecycle", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment-Lifecycle", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment-Lifecycle", "onCreateView")
        val view = inflater.inflate(R.layout.fragmet_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment-Lifecycle", "onViewCreated")
        button.setOnClickListener {
//            startActivity(Intent(activity, Activity2::class.java))
            (activity as MainActivity).showSecondFragment()
        }

        // UI Hanndler handling message and showing to textview
        uiHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                textView.text = msg.obj.toString()
            }
        }


        // Creating thread and starting it
        val thread = MyThread()
        thread.start()

        // Edittext listener to lister every key pressed
        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                val msg = thread.mHandler.obtainMessage()
                val bundle = Bundle()
                bundle.putString("msg", "$s")
                msg.data = bundle
                thread.mHandler.sendMessage(msg)
            }
        });
    }

    internal inner class MyThread() :
        Thread() {
        var mHandler = Handler()

        override fun run() {
            Looper.prepare()
            mHandler = object : Handler() {
                override fun handleMessage(msg: Message) {
                    val bundle = msg.data
                    val string = bundle.getString("msg")
//                    textView1.text = string
                    val message = Message()
                    message.obj = string
                    uiHandler?.sendMessage(message)
                }
            }
            Looper.loop()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment-Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment-Lifecycle", "onResume")
    }

    override fun onPause() {
        Log.d("Fragment-Lifecycle", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Fragment-Lifecycle", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Fragment-Lifecycle", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("Fragment-Lifecycle", "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Fragment-Lifecycle", "onDetach")
        super.onDetach()
    }

    companion object {

        fun getInstance(): Fragment {
            return FragmetThread()
        }
    }
}