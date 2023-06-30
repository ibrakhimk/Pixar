package com.example.pixar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pixar.databinding.ActivityMainBinding
import com.example.pixar.model.AdapterImage
import com.example.pixar.model.PixarModel
import com.example.pixar.model.PixarService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { AdapterImage(arrayListOf()) }
    var counter =0
    var edit = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnChange.setOnClickListener {
            if (edit != binding.etText.text.toString()) {
                adapter.clearImage()
                getImage()
            } else {
                adapter.clearImage()
                getImage()
            }
        }
        binding.btnGet.setOnClickListener {
            edit = binding.etText.text.toString()
            counter++
            getImage()
        }
    }

    private fun getImage() {
        PixarService().apiPixar.getImage(binding.etText.text.toString(), page =counter )
            .enqueue(object : Callback<PixarModel> {
                override fun onResponse(call: Call<PixarModel>, response: Response<PixarModel>) {
                    adapter.addImage(response.body()!!.hits)
                    binding.recyclerView.adapter = adapter
                }

                override fun onFailure(call: Call<PixarModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}