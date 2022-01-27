package com.example.shipapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shipapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.OnClick {

    private lateinit var binding: ActivityMainBinding
    private val image = mutableListOf<String>()
    private val list = arrayListOf<String>()
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        sendToSecondActivity()
    }

    private fun sendToSecondActivity() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(KEY, list)
            startActivity(intent)
        }
    }

    private fun initView() {
        adapter = Adapter(fullList())
        adapter.setOnClick(this)
        binding.rvListImage.adapter = adapter
    }

    private fun fullList(): MutableList<String> {
        for (i in 1..10) {
            image.add("https://upload.wikimedia.org/wikipedia/ru/e/e6/Goat_Simulator_logo.png")
        }
        return image
    }

    companion object {
        const val KEY = "key"
    }

    override fun onClicked(position: String) {
        list.add(position)
    }

    override fun onRemoved(position: String) {
        list.remove(position)
    }
}