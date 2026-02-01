import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Programa principal para evaluar expresiones en notación Postfix
 * @author Yu-Fong Chen & Andrés Castro
*/

public class Main {

    public static void main(String[] args) {
        System.out.println("*** Calculadora Postfix ***");

        // Instancia una pila tipo VectorStack
        IStack<Double> pila = new VectorStack<>();
        // Crea una calculadora con la pila esta /\
        ICalculadora calculadora = new CalculadoraPostfix(pila);

        try {
            List<String> expresiones = leerArchivo("datos.txt");

            // Evalúa cada expresión
            for (int i = 0; i < expresiones.size(); i++) {
                String expresion = expresiones.get(i);
                System.out.println("Expresión " + (i + 1) + ": " + expresion);
            
            try {
                double resultado = calculadora.evaluar(expresion);
                System.out.println("Resultado: " + resultado);
                System.out.println();

            } catch (CalculadoraException e) {
                System.out.println("!!! " + e.getMessage());
                System.out.println();
            } 
        }

            } catch (IOException e) {
                System.err.println("Error: No se pudo leer el archivo 'datos.txt'");
            }
        }

        // Lee el archivo
        private static List<String> leerArchivo(String nombreArchivo) throws IOException {
            List<String> lineas = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            try {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (!linea.trim().isEmpty()) {
                        lineas.add(linea);
                    }
                }
            } finally {
                br.close();
        }
        return lineas;
    }
}
