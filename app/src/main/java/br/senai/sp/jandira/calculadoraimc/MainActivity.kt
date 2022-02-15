package br.senai.sp.jandira.calculadoraimc

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

        val resultado = findViewById<TextView>(R.id.resultado)
        val resultadoMsg = findViewById<TextView>(R.id.resultadoMsg)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        // limpando os TextView de resultado:
        resultado.text = ""
        resultadoMsg.text = ""

        buttonCalcular.setOnClickListener { buttonCalcularOnClick() }
    }

    /**
     * quando necessario, gera um aviso e o renderiza no textView com id resultadoMsg.
     *
     * @param[imc] imc usado para definir se o aviso deve ser exibido ou não.
     */
    private fun gerarAviso(imc : Double, resultadoMsg : TextView) {
        if (imc >= 18.5 && imc <25) {
            resultadoMsg.text = "Parabéns!"
            resultadoMsg.setTextColor(Color.GREEN)
        } else if (imc >= 40) {
            resultadoMsg.text = "Cuidado!"
            resultadoMsg.setTextColor(Color.RED)
        } else {
            resultadoMsg.text = ""
        }
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

            // mostrando o resultado para o usuario:
            findViewById<TextView>(R.id.resultado).text =
                "seu imc é ${String.format("%.2f", imc)} e você esta ${categoria}"

            // renderizando aviso:
            gerarAviso(imc, findViewById(R.id.resultadoMsg))
        }
    }
}