// Son algunos posibles errores en una calculadora
// !!! Se recomienda nombrarlas terminando con "Exception"

public class CalculadoraException extends Exception{
    // La clase Exception ya existe en Java, no necesitamos crearla
    
    public CalculadoraException(String mensaje) {
        // Llama al constructor de Exception \/
        super(mensaje);
    }

    // Cuando tratan de dividir por cero
    class DivisionPorCeroException extends CalculadoraException{
        public DivisionPorCeroException() {
            super("Error: División por cero");
        }
    }

    // Cuando no hay suficientes operandos
    class OperandosInsuficientesException extends CalculadoraException{
        public OperandosInsuficientesException() {
            super("Error: Operandos insuficientes");
        }
    }

    // Cuando hay caracteres inválidos
    class CaracterInvalidoException extends CalculadoraException{
        public CaracterInvalidoException() {
            super("Error: Caracteres inválidos");
            // super("Error: Caracteres inválidos: '" + caracter + "'");
        }
    }
}
