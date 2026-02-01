// Calculadora para expresiones en notación Postfix usando pilas

public class CalculadoraPostfix implements ICalculadora{
    private IStack<Double> pila;

    // Recibe cualquier implementación de IStack,
    // no se limita a las clases que lo implementan
    public CalculadoraPostfix(IStack<Double> pila) {
        this.pila = pila;
    }
}
