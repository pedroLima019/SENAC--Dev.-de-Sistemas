programa
{
    inclua biblioteca Texto --> tx 	
	funcao inicio()
	{
		cadeia hospedes[15], pesquisa 
		inteiro resp=0, c=0 
		logico encontrado=falso

          
		
		
			faca{
				escreva("Digite 1-cadastrar; 2-pesquisar; 3-sair \n")
				leia(resp)
				se(resp==1){
					se(c<15){
						escreva("Nome de hóspede:")
						leia(hospedes[c])
						c++
					}senao{
						escreva("Máximo de cadastros atingido \n")
					}
				}
				se(resp==2){
					
					escreva("Pesquisar por:")
					leia(pesquisa)
					encontrado=falso
					
					para(inteiro linha =0; linha<15; linha++){
						se(hospedes[linha]==pesquisa){
							escreva("Hóspede ", pesquisa, " foi encontrado no índice ", linha, "\n")
							encontrado=verdadeiro
						}
					}
					se(encontrado==falso){
						escreva("Hóspede não encontrado\n")
					}
					

					inteiro pos = tx.posicao_texto(pesquisa , hospedes[15] , 0)

					se(pos >= 0){
						escreva("Texto foi encontrado !")
					}
					senao{
						escreva("Não foi encontrado")
					}
				}
			}enquanto(resp!=3)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 818; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */