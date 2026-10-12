public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    // PUSH: Guarda un número en la cima
    public void push(double valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    // POP: Extrae el número de la cima
    public Double pop() {
        if (estaVacia()) {
            return null;
        }
        double valor = tope.getValor();
        tope = tope.getSiguiente();
        return valor;
    }

    // Muestra en consola cómo se ve la pila actualmente
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Estado actual de la Pila: [ Pila Vacía ]");
            return;
        }
        Nodo aux = tope;
        System.out.print("Estado actual de la Pila (Tope -> Fondo): ");
        while (aux != null) {
            System.out.print("[" + aux.getValor() + "] ");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }
}
