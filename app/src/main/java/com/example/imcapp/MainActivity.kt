package com.example.imcapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecycle","CREATE - estou criando a tela")
        setListeners()
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle","START - deixei a tela visível para você")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle","RESUME - agora você pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle","PAUSE - a tela perdeu o foco, você não pode mais interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecycle","STOP - a tela não está mais visível, mas ainda existe")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle","\nRESTART - a tela está retomando o foco")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle","\nDESTROY - oh não! a tela foi destruída, adeus!")
    }

    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { text ->
           //Toast.makeText(this, text.toString(),Toast.LENGTH_SHORT).show()
        }

        pesoEDT?.doOnTextChanged { text, start, before, count ->
            //titleTXT.text = text
        }

        calcularBTN?.setOnClickListener {
            if(alturaEDT.text.toString().toFloatOrNull() != null && pesoEDT.text.toString().toFloatOrNull() != null){

                val altura = alturaEDT.text.toString().toFloat()
                val peso = pesoEDT.text.toString().toFloat()
                val imc = peso/(altura*altura)
                titleTXT.text = "O seu IMC é %.2f".format(imc)
            }else{
                titleTXT.text = "Valor inválido, digite novamente"
            }
        }

    }






}