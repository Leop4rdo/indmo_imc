package br.senai.sp.jandira.calculadoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultado = findViewById<TextView>(R.id.resultado);
        val resultadoMsg = findViewById<TextView>(R.id.resultadoMsg);
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular);

        // limpando os TextView de resultado:
        resultado.text = "";
        resultadoMsg.text = "";

        buttonCalcular.setOnClickListener { buttonCalcularOnClick() }
    }

    /**
     * Realiza o calculo do IMC com base nos valores passados como parametro.
     *
     * @param[altura] altura usada para o calculo.
     * @param[peso] peso usado para o calculo.
     * @return o resultado do calculo do IMC.
     */
    fun calcularIMC(altura : Double, peso : Double) : Double {
        return peso / (altura * altura)
    }

    /**
     * Realiza a classificação do [imc] passado como parametro.
     *
     * @param[imc] o imc usado para realizar a classificação.
     * @return string com a classificação.
     */
    fun classificarIMC(imc : Double) : String {
        var categoria :String = ""

        if (imc < 18.5)
            categoria = "abaixo do peso."
        else if (imc < 25)
            categoria = "com peso normal."
        else if (imc < 30)
            categoria = "acima do peso."
        else if (imc < 35)
            categoria = "com obesidade grau I."
        else if (imc < 40)
            categoria = "com obesidade grau II."
        else if (imc >=40)
            categoria = "com obesidade morbida."
        else
            categoria = "ERRO: Impossivel classificar IMC!"


        return categoria
    }

    /**
     * quando necessario, gera um aviso e o renderiza no textView com id resultadoMsg.
     *
     * @param[Imc] imc usado para definir se o aviso deve ser exibido ou não.
     */
    fun gerarAviso(imc : Double) {
        val resultadoMsg = findViewById<TextView>(R.id.resultadoMsg);

        if (imc >= 18.5 && imc <25) {
            resultadoMsg.text = "Parabéns!"
            resultadoMsg.setTextColor(Color.GREEN);
        } else if (imc >= 40) {
            resultadoMsg.text = "Cuidado!"
            resultadoMsg.setTextColor(Color.RED);
        } else {
            resultadoMsg.text = ""
        }
    }

    /**
     * Evento de click do buttonCalcular
     */
    fun buttonCalcularOnClick() {
        // recebendo valores:
        val altura = findViewById<EditText>(R.id.editAltura).text.toString().toDouble();
        val peso = findViewById<EditText>(R.id.editPeso).text.toString().toDouble();

        val imc = calcularIMC(altura, peso);
        val categoria = classificarIMC(imc);

        // mostrando o resultado para o usuario:
        findViewById<TextView>(R.id.resultado).text = "seu imc é ${String.format("%.2f", imc)} e você esta ${categoria}"

        // renderizando aviso:
        gerarAviso(imc);
    }
}