programa
{
	funcao inicio()
	{
		cadeia nome[5] 
		caracter sexo[5]

		para(inteiro i = 0; i < 5; i++ ){
			 escreva("Digite o nome do hospede : \n")
      	      leia(nome[i])

      	     escreva("Digite o sexo do hospede (M/F): \n ")
               leia(sexo[i])
		}

		 escreva("Nomes das hospedes femininas: \n ")

		 para( inteiro i = 0; i < 5; i++){

		 	se(sexo[i] == 'F'){
		 		escreva(nome[i], " ")
		 	}
		 }

		 escreva("\n Nomes dos hospedes masculinos: \n")

		 para( inteiro i = 0; i < 5; i++){
		 	se(sexo[i] == 'M'){
		 		escreva(nome[i], " ")
		 	}
		 }
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 467; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */