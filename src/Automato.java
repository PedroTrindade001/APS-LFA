import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Automato {
    static ValidarExpressaoService validator = new ValidarExpressaoService();

    public static void main(String[] args) throws Exception {
        String arquivo = "src/entrada.txt";
        List<String> linhas = Files.readAllLines(Paths.get(arquivo));
        String expressaoFinal = linhas.get(linhas.size()-1);
        Map<String, Double> valores = new HashMap<>();

        for (String linha : linhas) {
            if (!linha.trim().isEmpty() && linha == expressaoFinal) {
                if (validator.validarString(linha)) {
                    System.out.println("A expressão final '" + linha + "' é válida.");
                    String expressaoAnalisada = analisarExpressaoFinal(expressaoFinal, valores);
                    System.out.println("Resultado = " + calcularExpressaoFinal(expressaoAnalisada));
                } else {
                    System.out.println("A expressão final '" + linha + "' é inválida.");
                    break;
                }
            } else if (!linha.trim().isEmpty()) {
                if (validator.validarString(linha)) {
                    System.out.println("A expressão '" + linha + "' é válida.");
                    processarLinha(linha, valores);
                } else {
                    System.out.println("A expressão '" + linha + "' é inválida.");
                    break;
                }
            }
        }
    }

    private static void processarLinha(String linha, Map<String, Double> valores) {
        String regex = "\\b([a-z][a-z0-9_]*)\\s*=\\s*([0-9]+(\\.[0-9]+)?)\\b";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(linha);

        while (matcher.find()) {
            String identificador = matcher.group(1);
            double valor = Double.parseDouble(matcher.group(2));
            valores.put(identificador, valor);
        }
    }

    private static String analisarExpressaoFinal(String expressao, Map<String, Double> valores) {
        String[] partes = expressao.split("=");

        if (partes.length == 2) {
            String parteAntesDoIgual = partes[0].trim();
            String parteDepoisDoIgual = partes[1].trim();
            for (Map.Entry<String, Double> entry : valores.entrySet()) {
                parteDepoisDoIgual = parteDepoisDoIgual.replaceAll(entry.getKey(), String.valueOf(entry.getValue()));
            }
            return parteAntesDoIgual + "=" + parteDepoisDoIgual;
        } else {
            return expressao;
        }
    }

    private static Double calcularExpressaoFinal(String expressaoAnalisada) {
        Stack<Double> valores = new Stack<>();
        Stack<Character> operadores = new Stack<>();
        StringBuilder numero = new StringBuilder();

        for (char caractere : expressaoAnalisada.toCharArray()) {
            if (Character.isDigit(caractere) || caractere == '.') {
                numero.append(caractere);
            } else if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/') {
                if (numero.length() > 0) {
                    valores.push(Double.parseDouble(numero.toString()));
                    numero.setLength(0);
                }
                operadores.push(caractere);
            }
        }

        if (numero.length() > 0) {
            valores.push(Double.parseDouble(numero.toString()));
        }

        while (!operadores.isEmpty()) {
            char operador = operadores.pop();
            double segundoNumero = valores.pop();
            double primeiroNumero = valores.pop();

            switch (operador) {
                case '+':
                    valores.push(primeiroNumero + segundoNumero);
                    break;
                case '-':
                    valores.push(primeiroNumero - segundoNumero);
                    break;
                case '*':
                    valores.push(primeiroNumero * segundoNumero);
                    break;
                case '/':
                    valores.push(primeiroNumero / segundoNumero);
                    break;
            }
        }

        return valores.pop();
    }
}