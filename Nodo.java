public class Nodo {
    private double valor;   // Guardará los números (ej: 10.0, 5.0)
    private Nodo siguiente; // Apunta al nodo inferior en la pila

    public Nodo(double valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public double getValor() {
        return valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}