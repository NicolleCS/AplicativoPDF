package com.example.apppdf

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adiciona_servico.*

class AdicionaServico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiciona_servico)
    }

    fun AdicionarServico(componente: View){
        val teste1 = findViewById<EditText>(R.id.et_quantidade)
        val teste2 = findViewById<EditText>(R.id.et_descricao)
        val teste3 = findViewById<EditText>(R.id.et_valor)

        val quantidade = teste1.text.toString().toInt()
        val descricao = teste2.text.toString()
        val valor = teste3.text.toString().toBigDecimal()

        val servico = Servico(quantidade,descricao,valor)
        Lista.listaServico.add(servico)

        teste1.getText().clear()
        teste2.getText().clear()
        teste3.getText().clear()

        Toast.makeText(baseContext, "Serviço Adicionado!", Toast.LENGTH_SHORT).show()


    }

    fun Finalizar(componente: View){
        val intent = Intent()
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}