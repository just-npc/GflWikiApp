package com.example.gflwikiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTdolls: RecyclerView
    private val list = ArrayList<Tdoll>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvTdolls = findViewById(R.id.rv_tdolls)
        rvTdolls.setHasFixedSize(true)

        list.addAll(getListTdolls())
        showRecycleList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getListTdolls(): ArrayList<Tdoll> {
        val dataName = resources.getStringArray(R.array.tdolls_name)
        val dataWeapon = resources.getStringArray(R.array.tdolls_weapon)
        val dataFaction = resources.getStringArray(R.array.tdolls_faction)
        val dataManufactur = resources.getStringArray(R.array.tdolls_manufacturer)
        val dataPhoto = resources.obtainTypedArray(R.array.tdolls_photo)
        val listTdoll = ArrayList<Tdoll>()
        for (i in dataName.indices) {
            val tdoll = Tdoll(dataName[i], dataWeapon[i], dataFaction[i], dataManufactur[i], dataPhoto.getResourceId(i, -1))
            listTdoll.add(tdoll)
        }
        dataPhoto.recycle()
        return listTdoll
    }

    private fun showRecycleList() {
        rvTdolls.layoutManager = LinearLayoutManager(this)
        val listTdollAdapter = ListTdollAdapter(list)
        rvTdolls.adapter = listTdollAdapter
    }
}