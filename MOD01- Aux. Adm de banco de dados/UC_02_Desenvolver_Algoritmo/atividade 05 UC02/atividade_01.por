programa
{
	
		inclua biblioteca Util --> utl

	/*ordena utilizando insertion sort*/
	funcao ordena(inteiro v[])
	{
		inteiro i = 0, j = 1, aux = 0

		//Y:descobre o tamanho do vetor
		inteiro tamanho = utl.numero_elementos(v)

		//parte do segundo item em diante; para cada item, compara com os anteriores
		// trocando quando necessário deixando o valor do item no local correto
		para(j = 1; j< tamanho; j++)
		{
			aux = v[j]

			i = checaAnteriores(v, j, aux)

			v[i+1]=aux
			
			exibeVetor(v)
		}
		
	}

	/*vrifica os valores anteriores para trocas*/
	funcao inteiro checaAnteriores(inteiro v[], inteiro controle, inteiro valorControle)
	{
		inteiro index = controle-1
		enquanto(index >= 0 e v[index] > valorControle)
		{
			v[index+1] = v[index]
			index--
		}
		retorne index
	}

	/*percorre o vetor exibindo na tela os valores*/
	funcao exibeVetor(inteiro v[])
	{
		inteiro i = 0, j = 0, tamanho
		//Y:descobre tamanho do vetor
		tamanho = utl.numero_elementos(v)
		//Y:exibe todo o vetor
		escreva("\n")
		enquanto(i < tamanho)
		{
			escreva(v[i], " ")
			i++
		}
	}

	/*sorteia valores para o vetor*/
	funcao montaVetor(inteiro v[])
	{
		inteiro tamanho = utl.numero_elementos(v)

		escreva("\n")
		para(inteiro i = 0; i< tamanho; i++)
		{
			v[i] = utl.sorteia(0, 50)
		}
	}

	/*lê valores do usuário para o vetor*/
	funcao informaVetor(inteiro v[])
	{
		//Y:descobre o número de elementos no vetor
		inteiro tamanho = utl.numero_elementos(v)

		//Y:apenas pede os valores do vetor
		escreva("\n")
		para(inteiro i = 0; i< tamanho; i++)
		{
			escreva("\nInforme o valor ", i, ": ")
			leia(v[i])
		}
	}
	
	funcao inicio()
	{
		inteiro vetor[10] 

		informaVetor(vetor)
		
		exibeVetor(vetor)

		ordena(vetor)
		escreva("\nResultado final:")
		exibeVetor(vetor)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1782; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */