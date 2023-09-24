programa
{
	inclua biblioteca Texto --> tx
	
	funcao inicio()
	{
		cadeia hospedes[15], pesquisa, cad
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
					para(inteiro i =0; i<c; i++){
						
						inteiro pos=tx.posicao_texto(pesquisa, hospedes[i], 0)
						se(pos>=00){
							escreva("Hóspede ", pesquisa, " foi encontrado no índice ", i, "\n")
							encontrado=verdadeiro
						}
					}
					se(encontrado==falso){
						escreva("Hóspede não encontrado\n")
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
 * @SIMBOLOS-INSPECIONADOS = {hospedes, 7, 9, 8}-{pesquisa, 7, 23, 8}-{pos, 29, 14, 3};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */