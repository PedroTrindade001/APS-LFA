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
A primeiro momento o projeto acessa o arquivo "entrada.txt" e separa cada linha em um dos índices de uma lista, e também a última linha em uma String chamada expressaoFinal. Cada uma dessas linhas são passadas para um método chamado validarString(), que faz a validação  delas utilizando condicionais if, else if e if, para tomada de decisões relacionadas a String, uma variável do tipo int para limitar o número de caracteres vazias seguidas em 1, também foi utilizado o for each para rodar caractere por caractere da string, para assim analisar a String do início ao fim e confirmar se estão dentro do padrão solicitado na APS ou não, caso não estejam o programa finaliza, porém se forem válidas as Strings que realizam atribuições de valor, utilizam o Regex para pegar o nome antes do "=" e o valor numérico depois do "=" e colocam dentro de um HashMap para facilitar a substituição na expressão final posteriormente, pois com o HashMap conseguimos atrelar uma String a um valor numérico, após o HashMap estar mapeado, a expressão final é analisada e realiza a substituição do nome de variáveis pelos valores delas. Com os valores da expressão substituídos por valores númericos, a parte final da aplicação acontece, que basicamente recebe a expressão analisada e realiza o cálculo final da expressão matemática, em resumo o metodo utiliza duas pilhas (valores e operadores) para manter o controle dos valores numéricos e operadores na expressão, e itera a expressão caractere por caractere, se for um número coloca dentro da variável número, caso seja um operador processa o número dentro da variável valor e coloca na pilha valores, e em seguida coloca o operador na pilha de operadores, e assim realiza a operação aritmética conforme a ordem dos operadores na pilha de operadores utilizando os valores da pilha de valores.  
