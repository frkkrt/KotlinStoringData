package com.furkankurt.kotlinstoringdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.furkankurt.kotlinstoringdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   lateinit var sharedPreferences :SharedPreferences
    var ageFromPreferences :Int?=null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //sharedPreferences Initialize
        sharedPreferences=this.getSharedPreferences("com.furkankurt.kotlinstoringdata", Context.MODE_PRIVATE)
        ageFromPreferences=sharedPreferences.getInt("age",-1)

        if(ageFromPreferences==-1)
        {
            binding.textView.text="Your Age"
        }
        else
        {
            binding.textView.text="Your Age:$ageFromPreferences"
        }

    }
    fun save(view: View)
    {
        //SharedPreferences
        val myAge=binding.edtAge.text.toString().toIntOrNull()
        if(myAge!=null)
        {
            binding.textView.text="Your Age:" + myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }

    }
    fun delete(view:View)
    {
        ageFromPreferences=sharedPreferences.getInt("age",-1)
        if(ageFromPreferences!=-1)
        {
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text="Your Age: "
        }

    }
}