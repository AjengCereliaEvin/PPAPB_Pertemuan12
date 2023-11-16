package com.example.tugaspertemuan12

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan12.databinding.ActivityMainBinding
import com.example.tugaspertemuan12.model.Data
import com.example.tugaspertemuan12.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var FictionAdapter: FictionAdapter
    private lateinit var Fictionlist: List<Data>

    private val client = ApiClient.getInstance()
    private val call = client.getAllFiction()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        call.enqueue(object : Callback<List<Data>>{
            @SuppressLint("NotifyDataChanged")
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if(response.isSuccessful){
                    val FictionData = response.body()
                    FictionData?.let {
                        Fictionlist = it
                        FictionAdapter= FictionAdapter(Fictionlist)
                        recyclerView.adapter= FictionAdapter
                        recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)

                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {

            }
        })

        with(binding){
            recyclerView = rvFiction
        }
    }
}