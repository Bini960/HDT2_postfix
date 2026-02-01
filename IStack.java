// Interfaz que es una estructura de datos genérica y
// en nuestro caso, nos ayuda a evaluar las expresiones Postfix.

public interface IStack<T> {
    
    /**
     * Pone un elemento a la cima de la pila
     * @param value Necesita el elemento que se va a poner en la sima
     */
    void push(T value);
    
    /**
     * Hace @return el elemento en la cima de la pila y lo quita
     */
    T pop();
    
    /**
     * Hace @return el elemento en la cima de la pila, no lo quita
     */
    T peek();
    
    /**
     * Para verificar si la pila está vacía o no
     * Hace @return "true" si la pila no tiene elementos
     */
    boolean isEmpty();
    
    /**
     * Hace @return el número de elementos en la pila
     */
    int size();
    
    // Quita todos los elementos de la pila
    void clear();
}