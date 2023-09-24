programa {

funcao inicio() {

 

 cadeia dia, nome

 inteiro hora

 

 escreva("Informe o nome da empresa: ")

 leia(nome)

 escreva("Informe o dia da semana a ser reservado: ")

 leia(dia)

 escreva("Informa o horário a ser reservado: ")

 leia(hora)

 

 se (hora < 7 ou hora > 23){

     escreva("Horário indisponível!")

 }

 

    senao se ((dia == "sabado" ou dia == "domingo" e hora > 15)){

        escreva("Horário indisponível")

    }

 

 senao{

     escreva("Restaurante reservado para ", nome, ", ", dia, " às ", hora, "h!")

 }

}

}



/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 553; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */