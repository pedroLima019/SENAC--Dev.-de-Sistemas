programa
{
	
	funcao inicio()
	{
		cadeia quartos[20]
		caracter ocupQuarto , continuar
		inteiro numQuarto 

		faca{
			escreva(" \n Digite o número do quarto de 1 á 20 :")
			leia(numQuarto)
			escreva(" \n o quarto está livre ou ocupado ? (L / O): ")
			leia(ocupQuarto)
		   se(ocupQuarto == 'O' e quartos[numQuarto-1] == "OCUPADO"){
		   	   escreva("Qaurto já está ocupado ! \n")
		   	} senao se (ocupQuarto == 'O'){
 				quartos[numQuarto-1] = "OCUPADO"
		   	}senao se(ocupQuarto == 'L'){
		   		quartos[numQuarto-1] = "LIVRE"
		   	}
 
		   	escreva("\n Deseja Continuar ? S / N :")
		   	leia(continuar)
		   	limpa()
		}enquanto(continuar == 'S')
		para(inteiro i = 0 ; i < 20; i++){
			se(quartos[i] == ""){
				quartos[i] = "LIVRE"
			}
			escreva("Quarto", i+1, "-", quartos[i], "\n")
		}   
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 595; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */