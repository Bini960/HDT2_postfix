import java.util.EmptyStackException;

//Calculadora para expresiones en notación Postfix

public class CalculadoraPostfix implements ICalculadora {

    private IStack<Double> pila;

    // Constructor 
    public CalculadoraPostfix(IStack<Double> pila) {
        this.pila = pila;
    }

    @Override
    public double evaluar(String expresion) throws CalculadoraException {
        // Validación inicial
        if (expresion == null || expresion.trim().isEmpty()) {
            throw new CalculadoraException("Error: La expresión está vacía");
        }

        // Limpiamos la pila para asegurar que iniciamos desde cero
        pila.clear();

        // Usamos split para manejar múltiples espacios accidentales
        String[] tokens = expresion.trim().split("\\s+");

        for (String token : tokens) {
            // 1. Si es un operador, operamos
            if (esOperador(token)) {
                try {
                    // Verificación preventiva
                    if (pila.size() < 2) {
                        throw new CalculadoraException.OperandosInsuficientesException();
                    }

                    // El primero que sale (pop) es el operando de la DERECHA (b)
                    double b = pila.pop();
                    double a = pila.pop();
                    
                    double resultado = operar(a, b, token.charAt(0));
                    pila.push(resultado);
                    
                } catch (EmptyStackException e) {
                    throw new CalculadoraException.OperandosInsuficientesException();
                }
            } 
            // 2. Si es un número, lo guardamos
            else if (esNumero(token)) {
                try {
                    double valor = Double.parseDouble(token);
                    pila.push(valor);
                } catch (NumberFormatException e) {
                    throw new CalculadoraException.CaracterInvalidoException(token);
                }
            } 
            // 3. Si no es nada conocido, error
            else {
                throw new CalculadoraException.CaracterInvalidoException(token);
            }
        }

        // Al final debe quedar un resultado
        if (pila.size() != 1) {
            throw new CalculadoraException("Error: La expresión está mal formada (sobran números)");
        }

        return pila.pop();
    }

    // Métodos Auxiliares para limpieza y orden

    private boolean esNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esOperador(String token) {
        // Verifica si es +, -, * o / y que tenga longitud 1
        return token.length() == 1 && "+-*/".contains(token);
    }

    private double operar(double a, double b, char operador) throws CalculadoraException {
        switch (operador) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new CalculadoraException.DivisionPorCeroException();
                }
                return a / b;
            default: return 0;
        }
    }
}