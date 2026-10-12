import java.util.Scanner;

public class EvaluadorAritmetico {

    public double procesarOperacionInteractivamente(Scanner scanner) {
        Pila pila = new Pila();
        boolean continuar = true;

        System.out.println("\n--- EVALUACIÓN ARITMÉTICA CON PILA ---");
        System.out.println("- Ingresa números uno a uno.");
        System.out.println("- Usa los operadores +, -, *, / para calcular con los últimos 2 números.");
        System.out.println("- Escribe '=' para finalizar y ver el resultado final.\n");

        while (continuar) {
            pila.mostrarPila();
            System.out.print("-- Ingrese entrada (Número, +, -, *, / o =): ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equals("=")) {
                continuar = false;
            }
            else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/")) {
                Double b = pila.pop(); // Segundo operando
                Double a = pila.pop(); // Primer operando

                if (a != null && b != null) {
                    double resultado = 0;
                    switch (entrada) {
                        case "+": resultado = a + b; break;
                        case "-": resultado = a - b; break;
                        case "*": resultado = a * b; break;
                        case "/":
                            if (b == 0) {
                                System.out.println(" Error: No se puede dividir entre cero.");
                                pila.push(a);
                                pila.push(b);
                                continue;
                            }
                            resultado = a / b;
                            break;
                    }
                    System.out.println(">> Operación realizada: " + a + " " + entrada + " " + b + " = " + resultado);
                    pila.push(resultado); // Volvemos a meter el resultado a la pila
                } else {
                    System.out.println(" Error: Necesitas al menos dos números en la pila para operar.");
                    if (a != null) pila.push(a);
                }
            }
            else {
                try {
                    double numero = Double.parseDouble(entrada);
                    pila.push(numero);
                    System.out.println(">> Apilado número: " + numero);
                } catch (NumberFormatException e) {
                    System.out.println(" Entrada no válida. Ingrese un número u operador válido.");
                }
            }
        }

        Double resultadoFinal = pila.pop();
        return resultadoFinal != null ? resultadoFinal : 0.0;
    }
}