import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

// Tests para probar que mi Stack funcione bien antes de usarlo en la calcu
public class VectorStackTest {

    @Test
    public void testPushAndPop() {
        // pila vacía para probar
        IStack<Double> stack = new VectorStack<>();
        
        // Le meto un par de números
        stack.push(10.0);
        stack.push(20.0);
        
        // Reviso que el tamaño sea 2, si no algo anda mal
        assertEquals(2, stack.size());
        
        // LIFO: el último que entro tiene que ser el primero en salir
        double valorSacado = stack.pop();
        assertEquals(20.0, valorSacado, 0.001);
        
        // Verifico que haya quedado solo el 10 y que esté en el tope
        assertEquals(1, stack.size());
        assertEquals(10.0, stack.peek(), 0.001);
    }

    @Test
    public void testIsEmpty() {
        IStack<Double> stack = new VectorStack<>();
        
        // Al principio tiene que estar vacía 
        assertTrue(stack.isEmpty());
        
        // Si le meto algo, ya no puede estar vacía
        stack.push(5.0);
        assertEquals(false, stack.isEmpty());
        
        // Si lo saco, debería quedar vacía otra vez
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}