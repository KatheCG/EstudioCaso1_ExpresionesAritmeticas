import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EvaluadorAritmetico evaluador = new EvaluadorAritmetico();
        int opcion = 0;

        do {
            System.out.println("\n=================================================");
            System.out.println("  ESTUDIO DE CASO: ANÁLISIS DE EXPRESIONES ARITMÉTICAS ");
            System.out.println("=================================================");
            System.out.println("1. Resolver operación matemática interactiva");
            System.out.println("2. Ver prueba rápida de la Pila (push/pop)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    double resultado = evaluador.procesarOperacionInteractivamente(scanner);
                    System.out.println("\n RESULTADO FINAL DE LA EXPRESIÓN:");
                    System.out.println("Resultado = " + resultado);
                    break;

                case 2:
                    System.out.println("\n--- PRUEBA DIRECTA DE OPERACIONES EN PILA ---");
                    Pila demo = new Pila();
                    System.out.println("Haciendo push(10)...");
                    demo.push(10);
                    demo.mostrarPila();

                    System.out.println("Haciendo push(20)...");
                    demo.push(20);
                    demo.mostrarPila();

                    System.out.println("Ejecutando pop()...");
                    Double extraido = demo.pop();
                    System.out.println("Elemento extraído del tope: " + extraido);
                    demo.mostrarPila();
                    break;

                case 3:
                    System.out.println("Saliendo del programa... ¡Hasta luego!");
                    break;

                default:
                    System.out.println(" Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}