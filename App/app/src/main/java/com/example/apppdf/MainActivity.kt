package com.example.apppdf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Orcamento(componente:View){
        val telaInicial = Intent(this, Index::class.java)
        telaInicial.putExtra("tipo","orcamento")
        startActivity(telaInicial)
    }

    fun Recibo(componente: View){
        val telaInicial = Intent(this, Index::class.java)
        telaInicial.putExtra("tipo","recibo")
        startActivity(telaInicial)
    }
}