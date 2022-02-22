package br.senai.sp.jandira.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val imc : TextView = findViewById(R.id.imc)
        val classificacao : TextView = findViewById(R.id.classificacao)

        val actionBar = supportActionBar
        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true);

        imc.text = String.format("%.2f", this.intent.getDoubleExtra("imc", 0.0))
        classificacao.text = this.intent.getStringExtra("categoria")
    }
}