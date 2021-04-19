package com.example.apppdf

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_index.*
import org.w3c.dom.Text

class Index : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val tipo = intent.extras?.getString("tipo")
    }

    private val SECOND_ACTIVITY_REQUEST_CODE = 0


    fun Adicionar(componente:View){
        val telaAdicionar = Intent(this, AdicionaServico::class.java);
        startActivityForResult(telaAdicionar, SECOND_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                val layout = findViewById<LinearLayout>(R.id.ll_lista)
                layout.removeAllViews()

                val total = TextView(this)
                var valorTotal = 0.0

                Lista.listaServico.forEach{
                    val linear = LinearLayout(this)
                    linear.orientation = LinearLayout.HORIZONTAL

                    val quantidade = TextView(this)
                    quantidade.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                    quantidade.width = 250
                    val descricao = TextView(this)
                    descricao.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                    descricao.width = 600
                    val valor = TextView(this)
                    valor.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                    valor.width = 150

                    quantidade.text = it.quantidade.toString()
                    descricao.text = it.descricao
                    valor.text = it.valor.toString()
                    valorTotal += it.valor.toDouble() * it.quantidade

                    linear.addView(quantidade)
                    linear.addView(descricao)
                    linear.addView(valor)

                    layout.addView(linear)
                }

                total.text = """TOTAL: ${valorTotal}"""
                layout.addView(total)

            }

        }
    }

    fun Finalizar(componente: View){
        val cliente = et_cliente.text.toString()
        val cpf = et_cpf.text.toString()
        val endereco = et_endereco.text.toString()

        Lista.lista.add(cliente)
        Lista.lista.add(cpf)
        Lista.lista.add(endereco)

        val teste = AlterarDocumento()
        teste.alterar("D:/","D:/")

        val telaInicial = Intent(this, MainActivity::class.java)
        startActivity(telaInicial)

        Toast.makeText(baseContext, "Finalizado este documento!", Toast.LENGTH_LONG).show()
    }

}


