programa
{
	
	funcao inicio()
	{
		real valorDiaria = 0.0 
		inteiro diasHosp = 0 

		escreva("\nValor da diária: ")
		leia(valorDiaria)
		escreva("\nDias de hospedagem: ")
		leia(diasHosp)

		se(valorDiaria < 0){
			escreva("valor inválidos")
			leia(valorDiaria)
		}senao {
			se(valorDiaria < 0){
				escreva("valor valido")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 268; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */