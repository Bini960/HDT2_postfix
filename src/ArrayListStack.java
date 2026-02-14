// Permite que se usen pilas tipo ArrayList,
// solo con los métodos que definimos

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<T> implements IStack<T> {

    private ArrayList<T> data;

    // Constructor para tener una pila vacía
    public ArrayListStack() {
        data = new ArrayList<>();
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

