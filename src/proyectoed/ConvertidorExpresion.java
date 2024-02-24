package proyectoed;

import java.util.ArrayList;
/**
 *Clase que proporciona un método para convertir de expresiones infijas a postfijas
 * Inlcuye un método para determinar la prioridad de los operadores
 * @author Elie y Kyrie
 */
public class ConvertidorExpresion {
    /**
     * Convierte una expresión infija a postfija.
     * 
     * @param expresionInfija La expresión infija a convertir.
     * @return Un ArrayList de Doubles y caracteres (+, -, *, /, ^).
     * <ul>
     * <li> La expresión infija debe ser válida. </li>
     * <li> Los operadores válidos son (+, -, *, /, ^, (, )). </li>
     * <li> Los operandos válidos son números enteros y decimales. </li>
     * </ul>
     */
    
    /**
     * 
     * @param expresionInfija recibe la expresión infija 
     * @return regresa una expresion en postfija
     */
    public static ArrayList infijaAPostfija(String expresionInfija) {
        StringBuilder numero;
        ArrayList expresionPostfija;
        expresionPostfija = new ArrayList();
        PilaA<Character> pila = new PilaA<Character>();
        char caracter, caracterSiguiente, caracterAnterior; 

        for (int i = 0; i < expresionInfija.length(); i++) {
            caracter = expresionInfija.charAt(i);
            numero = new StringBuilder();
            if (caracter >= '0' && caracter <= '9' || caracter == '.') {
                try {
                    //try catch porque es posible que i+1 no exista, en cuyo caso el programa ya termino
                    caracterSiguiente = expresionInfija.charAt(i+1);
                    numero.append(caracter);
                    while (caracterSiguiente >= '0' && caracterSiguiente <= '9' || caracterSiguiente == '.') {
                        //Guarda varios dígitos com solo un número
                        i++;
                        caracterSiguiente = expresionInfija.charAt(i+1);
                        numero.append(expresionInfija.charAt(i));
                    }
                    expresionPostfija.add(Double.parseDouble(numero.toString()));
                }
                catch (Exception e) {
                    numero.append(expresionInfija.charAt(i));
                    expresionPostfija.add(Double.parseDouble(numero.toString()));
                }
            } // Si no se cumple revisa si es un parentesis de apertura
            // Y lo guarda en la pila
            else // Si no se cumple revisa si es un parentesis de apertura
                 // Y lo guarda en la pila
                if (caracter == '(') {
                    if (i > 0) {
                        //Checa si el paréntesis se está usando para multiplicar, en cuyo caso previamente corre el código como si hubiera un * antes
                        caracterAnterior = expresionInfija.charAt(i-1);
                        if (caracterAnterior == ')' || (caracterAnterior >= '0' && caracterAnterior <= '9')) {
                            while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad('*')) {
                                expresionPostfija.add(pila.pop());
                            }
                            pila.push('*');
                        }
                    }
                    pila.push(caracter);
                }
                else if (caracter == ')') {
                // Busca si el ultimo elemento de la pila es diferente
                // de un parentesis de apertura, entonces pasa el operador a la
                // expresionPostFija
                    while (!pila.isEmpty() && pila.peek() != '(') {
                        expresionPostfija.add(pila.pop());
                    }
                    if (!pila.isEmpty()) {
                        pila.pop(); // Elimina el parentesis izquierdo de la pila
                    }
                    else
                        throw new IllegalArgumentException("Expresion infija incorrecta: parentesis desbalanceados");
                }
                else if (caracter == '-') {
                    //Checa si el número se debe tratar como negativo o si es una resta, en cuyo caso el menos se guarda como cualquier otro operador
                    if (i == 0) {
                        try {
                            caracterSiguiente = expresionInfija.charAt(i+1);
                            numero.append(caracter);
                            while (caracterSiguiente >= '0' && caracterSiguiente <= '9' || caracterSiguiente == '.') {
                                i++;
                                caracterSiguiente = expresionInfija.charAt(i+1);
                                numero.append(expresionInfija.charAt(i));
                            }
                            expresionPostfija.add(Double.parseDouble(numero.toString()));
                        }
                        catch (Exception e) {
                            numero.append(expresionInfija.charAt(i));
                            expresionPostfija.add(Double.parseDouble(numero.toString()));
                        }
                    }
                    else {
                        caracterAnterior = expresionInfija.charAt(i-1);
                        if (caracterAnterior == '*' || caracterAnterior == '/' || caracterAnterior == '(') {
                             numero.append(caracter);
                            try {
                                caracterSiguiente = expresionInfija.charAt(i+1);
                                while (caracterSiguiente >= '0' && caracterSiguiente <= '9' || caracterSiguiente == '.') {
                                    i++;
                                    caracterSiguiente = expresionInfija.charAt(i+1);
                                    numero.append(expresionInfija.charAt(i));
                                }
                                expresionPostfija.add(Double.parseDouble(numero.toString()));
                            }
                            catch (Exception e) {
                                numero.append(expresionInfija.charAt(i));
                                expresionPostfija.add(Double.parseDouble(numero.toString()));
                                }
                        }
                        else {
                            while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(caracter)) {
                                expresionPostfija.add(pila.pop());
                            }
                            pila.push(caracter);
                        }
                    }
                }
                else {
                    while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(caracter)) {
                        expresionPostfija.add(pila.pop());
                    }
                    pila.push(caracter);
                }
        }
        // vacia todos lo operadores de la pila en la expresionFinal
        while (!pila.isEmpty()) {
            expresionPostfija.add(pila.pop());
        }
        return expresionPostfija;
    }
    /**
     * Método para determinar la prioridad de un operador
     * @param operador El operador cuya prioridad se va a determinar
     * @return Un entero que representa la prioridad del operador
     */

    // este switch es para ver la prioridad de los operadores
    public static int prioridad(char operador) {
        switch (operador) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            return -1;
        }
    }
}

