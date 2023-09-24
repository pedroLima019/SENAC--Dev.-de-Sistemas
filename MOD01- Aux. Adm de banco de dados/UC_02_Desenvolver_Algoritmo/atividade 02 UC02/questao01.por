programa {
  funcao inicio() {
  	
  
    real ValorDiaria , total = 0 
    inteiro diarias 

    escreva("\n digite a quantidade de dias: \n")
    leia(diarias)
    
    escreva(" \n Digite o valor da diaria: \n")
    leia(ValorDiaria)

    se(diarias > 30 ou diarias <= 0)
    {
    	escreva("valor inválido !")
    }

    senao se (diarias <= 30)
    {
    	total = diarias * ValorDiaria
    	escreva("\n o valor das diarias é:R$", total, "\n")
    	escreva("Fim do programa")
    }
}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 408; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */