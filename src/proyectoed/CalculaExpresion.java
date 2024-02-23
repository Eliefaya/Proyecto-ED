package proyectoed;

import java.util.ArrayList;
/**
 *
 * @author Kyrie
 */
public class CalculaExpresion {
    
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
