package br.senai.sp.jandira.calculadoraimc

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
        categoria = "Abaixo do peso."
    else if (imc < 25)
        categoria = "Peso normal."
    else if (imc < 30)
        categoria = "Acima do peso."
    else if (imc < 35)
        categoria = "Obesidade grau I."
    else if (imc < 40)
        categoria = "Obesidade grau II."
    else if (imc >=40)
        categoria = "Obesidade morbida."
    else
        categoria = "ERRO: Impossivel classificar IMC!"


    return categoria
}