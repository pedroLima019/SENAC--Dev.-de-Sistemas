programa{

funcao inicio()

{

 cadeia hospedes[100], flag, maisVelho = "", maisNovo = ""

 inteiro diaria = 0, idades[100], i = 0, total = 0, grats = 0, meias = 0, maiorIdade = 0, menorIdade = 0

 escreva("Valor da diária: >>> R$")

 leia(diaria)

 limpa()

 faca{

  escreva("Nome do hóspede: >>> ")

  leia(hospedes[i])

  faca{

   escreva("Idade do(a) hóspede ", hospedes[i]," >>> ")

   leia(idades[i])

   se(idades[i] < 0){

    escreva(":( Não entendi. Digite a idade novamente.\n")

   }

  }enquanto(idades[i] < 0)

  se(idades[i] < 4){

   escreva("O hóspede ", hospedes[i], " possui gratuidade.\n")

   total += 0 // nem precisava dessa linha

   grats++

  }senao se(idades[i] > 80){

   escreva("O hóspede ", hospedes[i], " paga meia.\n")

   total += diaria/2

   meias++

  }senao{

   total += diaria

  }

  escreva("Deseja parar? [S/N] >>> ")

  leia(flag)

  limpa()

  se(flag != "S"){

   i++

  }

 } enquanto(flag != "S")

 para(inteiro j = 0; j <= i; j++){

  se(j == 0){

   maiorIdade = idades[j]

   menorIdade = idades[j]

  }

  se(idades[j] > maiorIdade){

   maiorIdade = idades[j]

   maisVelho = hospedes[j]

  }

  se(idades[j] < menorIdade){

   menorIdade = idades[j]

   maisNovo = hospedes[j]

  }

 }

 escreva("====================================================================\n")

 escreva("RESULTADOS:\n")

 escreva("\tTotal de hospedagens: R$", total,";\n")

 escreva("\tTotal de de gratuidades: ", grats,";\n")

 escreva("\tTotal de meias: ", meias,";\n")

 escreva("\tO(a) hóspede mais velho(a) é ", maisVelho, " com ", maiorIdade, " anos;\n")

 escreva("\tO(a) hóspede mais novo(a) é ", maisNovo, " com ", menorIdade, " anos.\n")

 escreva("====================================================================")

}

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1768; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */