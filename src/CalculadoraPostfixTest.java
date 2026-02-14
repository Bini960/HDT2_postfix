import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

// Tests para probar la lógica de la calculadora y los errores
public class CalculadoraPostfixTest {

    @Test
    public void testSumaSimple() {
        // 1 + 2 tiene que dar 3
        IStack<Double> stack = new VectorStack<>();
        ICalculadora calcu = new CalculadoraPostfix(stack);
        
        try {
            double resultado = calcu.evaluar("1 2 +");
            assertEquals(3.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            fail("Esto no debería fallar, es una suma simple");
        }
    }

    @Test
    public void testRestaOrden() {
        // Prueba que el orden de la resta sea correcto 
        // Si estuviera mal, haría 4 - 10 y daría -6
        IStack<Double> stack = new VectorStack<>();
        ICalculadora calcu = new CalculadoraPostfix(stack);
        
        try {
            double resultado = calcu.evaluar("10 4 -");
            assertEquals(6.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            fail("Falló la resta");
        }
    }

    @Test
    public void testOperacionCombinada() {
        // ejemplo que venía en la hoja de trabajo
        IStack<Double> stack = new VectorStack<>();
        ICalculadora calcu = new CalculadoraPostfix(stack);
        
        try {
            double resultado = calcu.evaluar("1 2 + 4 * 3 +");
            assertEquals(15.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            fail("No funcionó la operación combinada");
        }
    }

    @Test
    public void testDivisionPorCero() {
        // Esta prueba Tdebe que fallar. Si no tira error, el test está malo.
        IStack<Double> stack = new VectorStack<>();
        ICalculadora calcu = new CalculadoraPostfix(stack);
        
        try {
            calcu.evaluar("5 0 /");
            // Si llega a esta línea es porque no detectó el error
            fail("Debió tirar error por dividir entre cero y no lo hizo");
        } catch (CalculadoraException e) {
            // Si entra al catch, atrapó la excepción correcta
            assertTrue(e instanceof CalculadoraException.DivisionPorCeroException);
        }
    }
}