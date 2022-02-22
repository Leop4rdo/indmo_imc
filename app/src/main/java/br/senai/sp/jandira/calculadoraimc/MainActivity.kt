package br.senai.sp.jandira.calculadoraimc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        buttonCalcular.setOnClickListener { buttonCalcularOnClick() }
    }

    /**
     * Evento de click do buttonCalcular
     */
    private fun buttonCalcularOnClick() {

        if (!isCamposVazios(findViewById(R.id.editAltura), findViewById(R.id.editPeso))) {

            // recebendo valores:
            val altura = findViewById<EditText>(R.id.editAltura).text.toString().toDouble()
            val peso = findViewById<EditText>(R.id.editPeso).text.toString().toDouble()

            val imc = calcularIMC(altura, peso)
            val categoria = classificarIMC(imc)


            // trocando activity
            val intent = Intent(this, ResultadoActivity::class.java);

            intent.putExtra("imc", imc);
            intent.putExtra("categoria", categoria);

            startActivity(intent);
        }
    }
}