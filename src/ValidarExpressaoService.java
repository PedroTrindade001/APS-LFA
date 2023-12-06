public class ValidarExpressaoService {

    public static boolean validarPrimeiraLetra(String input) {
        return Character.isLowerCase(input.charAt(0));
    }

    public static boolean validarExpressao(String input) {
        String expressao = "";
        int vazio = 0;

        if (!validarPrimeiraLetra(input)) {
            System.out.println("A expressão não inicia com uma letra minúscula.");
            return false;
        }

        for (char caractere : input.toCharArray()) {
            expressao += caractere;
            if (!Character.isLetter(caractere) && !Character.isDigit(caractere) && caractere != '_') {
                if (caractere != ' ') {
                    if (caractere == '=') {
                        return validarOperador(expressao, input);
                    }
                    System.out.println("A expressão possui caracteres inválidos.");
                    return false;
                } else {
                    vazio++;
                    if (vazio == 2){
                        System.out.println("A expressão possui muitos caracteres vazios.");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private static boolean validarOperador(String expressao, String input) {
        input = input.replace(expressao, "");
        expressao = "";
        int vazio = 0;

        for (char caractere : input.toCharArray()) {
            expressao += caractere;

            if (Character.isDigit(caractere)){
                input = input.replace(expressao, "");
                expressao = "";

                for (char numero : input.toCharArray()) {
                    expressao += numero;
                    vazio = 0;

                    if (Character.isDigit(numero)) {
                    } else if (numero == ';') {
                        return true;
                    } else if (Character.isWhitespace(numero)){

                        vazio++;
                        if (vazio == 2){
                            System.out.println("A expressão possui muitos caracteres vazios.");
                            return false;
                        }

                    } else if (numero == '+' || numero == '-' || numero == '/' || numero == '*') {

                        return validarOperador(expressao, input);

                    } else {

                        System.out.println("A expressão é invalida pois possui um caractere invalido.");
                        return false;

                    }
                }
            } else if (Character.isWhitespace(caractere)){

                vazio++;
                if (vazio == 2){
                    System.out.println("A expressão possui muitos caracteres vazios.");
                    return false;
                }

            } else if (caractere == '+' || caractere == '-' || caractere == '/' || caractere == '*') {
                return validarOperador(expressao, input);
            } else {

                expressao = "";
                vazio = 0;

                if (!validarPrimeiraLetra(input)) {
                    System.out.println(input);
                    System.out.println("A expressão não inicia com uma letra minúscula.");
                    return false;
                }

                for (char variavel : input.toCharArray()) {
                    expressao += variavel;
                    if (!Character.isLetter(variavel) && !Character.isDigit(variavel) && variavel != '_') {
                        if (variavel != ' ') {
                            if (variavel == ';') {
                                return true;
                            } else if (variavel == '+' || variavel == '-' || variavel == '/' || variavel == '*') {
                                input = input.replace(expressao, "");
                                return validarOperador(expressao, input);
                            } else {
                                System.out.println("A expressão possui caracteres inválidos.");
                                return false;
                            }
                        } else {
                            vazio++;
                            if (vazio == 2){
                                System.out.println("A expressão possui muitos caracteres vazios.");
                                return false;
                            }
                        }
                    }
                }

            }

        }
        return false;
    }

    public static boolean validarString(String input) {

        if (!validarExpressao(input))
            return false;

        return true;
    }

}