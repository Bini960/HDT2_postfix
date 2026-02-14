// Permite que se usen las pilas tipo Vector, 
// solo con los métodos que definimos

import java.util.EmptyStackException;
import java.util.Vector;

public class VectorStack<T> implements IStack<T> {

    private Vector<T> data;

    // Constructor para tener una pila vacía
    public VectorStack() {
        data = new Vector<>();
    }

    // _____________________________________________________________________________________________

    // Hay que definir los métodos de la interfaz (usando @Override) para que el VectorStack funcione/compile bien
    @Override
    public void push(T value) {
        data.add(value);
    }
    
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data.remove(data.size() - 1);
    }
    
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }
    
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    @Override
    public int size() {
        return data.size();
    }
    
    @Override
    public void clear() {
        data.clear();
    }
    
}
