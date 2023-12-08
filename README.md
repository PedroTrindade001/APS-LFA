# APS-linguagens Formais e Autômatos
Curso: Engenharia da Computação (10º Semestre - Noturno - Vila Olímpia)  

# Nomes:  

- **Alexandre Freire Ropero Junior RA:125111375230**    
- **Guilherme dos Reis Freitas RA: 125111356415**   
- **Pedro Trindade Francisco RA: 125111346772**  

# Requisitos:  
Java 17  

## Como utilizar?  
Para utilizar o projeto é necessário colocar as strings de entrada em um arquivo txt chamado entrada.txt dentro da pasta "src" do projeto e executar a classe chamada: ExpressionValidator.java  

## Como funciona a implementação?  
### 1. **Leitura do Arquivo:**
  O programa inicia lendo o arquivo "entrada.txt" e separa cada linha em índices de uma lista. A última linha é armazenada em uma String chamada `expressaoFinal`.  
### 2. **Validação das Strings:**
  Cada uma dessas linhas são passadas para um método chamado validarString(), que faz a validação  delas utilizando condicionais `if`, `else if` e `if`, para tomada de decisões relacionadas a String, uma variável do tipo int chamada `vazio` para limitar o número de caracteres vazias seguidas em 1, também foi utilizado a estrutura de repetição `for each` para rodar caractere por caractere da string recebida, e foi utilizado recursividade para que fosse possível analisar todos os tipos de Strings contidos no txt utilizando os mesmos metodos, obtendo assim a confirmação se as Strings estão dentro do padrão solicitado na APS ou não. Caso as Strings não estejam válidas o programa finaliza.  
### 3. **Atribuições de Valores:**
  Com as Strings validadas é realizada as atribuições de valores, que utilizam o Regex para pegar o nome da variável antes do caractere "=" e o valor após do caractere "=", e colocam dentro de um HashMap para facilitar a substituição na expressão final posteriormente, pois com o HashMap conseguimos atrelar uma String a um valor numérico, com isso a é realizada a substituição do nome de variáveis pelos valores númerico delas. 
### 4. **Cálculo da Expressão Final:**  
  Com os valores da expressão final substituídos por valores númericos, a parte final da aplicação acontece, onde basicamente recebe a expressão analisada e realiza o cálculo final da expressão matemática, em resumo o metodo utiliza duas pilhas(`valores` e `operadores`) que são variáveis do tipo Stack, para manter o controle dos valores numéricos e operadores na expressão. A expressão é iterada caractere por caractere, se for um número coloca dentro da variável `numero`, caso seja um operador processa o número dentro da variável valor e coloca na pilha `valores`, e em seguida coloca o operador na pilha de `operadores`, com isso realiza a operação aritmética conforme a ordem dos operadores na pilha de `operadores` utilizando os valores da pilha de `valores`.  

## Estrutura de Dados Utilizadas:
List, HashMap e Stack
