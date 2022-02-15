package br.senai.sp.jandira.calculadoraimc

import android.widget.EditText

/**
 * verefica se os EditText passados como parametros estão em branco
 *
 * @param [campos] campos a serem verificador
 * @return Boolean
 */
fun isCamposVazios(vararg campos : EditText): Boolean {
    var isVazio = false;

    for (campo in campos){
        if (campo.text.isBlank()) {
            campo.setError("Por favor preencha esse campo!")
            isVazio = true;
        }
    }

    return isVazio;
}