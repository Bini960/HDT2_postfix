// Interfaz para calculadoras, evalúa expresiones

public interface ICalculadora {
    
    /**
     * Evalúa una expresión, retorna el resultado o tira un error.
     * @param expresion lo que hay que evaluar
     * @return resultado de la evaluación
     * @throws CalculadoraException si hay error
    */

    double evaluar (String expresion) throws CalculadoraException;

}
