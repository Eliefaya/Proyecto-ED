package proyectoed;

import java.util.ArrayList;
/**
 * <pre>
 * Clase para calcular el resultado de una operacion escrita en notacion postfija.
 * @author Kyrie
 */
public class CalculaExpresion {
    
    /**
     * Calcula el resultado de una operacion escrita en notacion postfija.
     * @param expresionPostfija (ArrayList de doubles y caracteres, estos siendo +, -, *, / y ^)
     * @see Calculadora
     * btIgualActionPerformed
     * @return <ul>
     * <li> El resultado, si puede ser calculado (double) </li>
     * <li> Infinity o NaN </li>
     * <li> RuntimeException "Error al realizar la operacion" si la expresion postfija tiene un error, o no se puede calcular el resultado por otra razon </li>
     * </ul>
     */
    public static double calculaResultado(ArrayList expresionPostfija) {
        PilaA<Double> operandos = new PilaA<Double>();
        double numero1, numero2;
        char operador;
        
        try {
            for (int i = 0; i < expresionPostfija.size(); i++) {
                if (expresionPostfija.get(i) instanceof Double) {
                   operandos.push((Double) expresionPostfija.get(i));
                }
                else if (expresionPostfija.get(i) instanceof Character) {
                    operador = (Character) expresionPostfija.get(i);
                    numero2 = operandos.pop();
                    numero1 = operandos.pop();
                    switch(operador) {
                        case '+':
                            operandos.push(numero1+numero2);
                            break;
                        case '-':
                            operandos.push(numero1-numero2);
                            break;
                        case '*':
                            operandos.push(numero1*numero2);
                            break;
                        case '/':
                            operandos.push(numero1/numero2);
                            break;
                        case '^':
                            operandos.push(Math.pow(numero1, numero2));
                            break;
                        default:
                            throw new Exception("Operador no aceptado");
                    }
                }
                else {
                    throw new Exception("Simbolo no aceptado");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la operacion");
        }
        return operandos.pop();
    }
}
