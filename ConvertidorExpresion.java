/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas_g1;

/**
 *
 * @author efaya
 */
public class ConvertidorExpresion {
    public static String infijaAPostfija(String expresionInfija) {
        StringBuilder expresionPostfija;
        expresionPostfija = new StringBuilder();
        PilaADT<Character> pila = new PilaA<>();

        for (int i = 0; i < expresionInfija.length(); i++) {
            char caracter; 
            caracter = expresionInfija.charAt(i);

            if (caracter >= '0' && caracter <= '9' || caracter == '.') {
                expresionPostfija.append(caracter);
            } // Si no se cumple revisa si es un parentesis de apertura
            // Y lo guarda en la pila
            else // Si no se cumple revisa si es un parentesis de apertura
                 // Y lo guarda en la pila
                 if (caracter == '(') {
                pila.push(caracter);
            }
                 else
                     if (caracter == ')') {
                // Busca si el ultimo elemento de la pila es diferente
                // de un parentesis de apertura, entonces pasa el operador a la
                // expresionPostFija
                while (!pila.isEmpty() && pila.peek() != '(') {
                    expresionPostfija.append(pila.pop());
                }
                if (!pila.isEmpty()) {
                    pila.pop(); // Elimina el parentesis izquierdo de la pila
                }
                else
                    throw new IllegalArgumentException("Expresion infija incorrecta: parentesis desbalanceados");
                    }
                     else {
                        while (!pila.isEmpty() && prioridad(pila.peek()) >= prioridad(caracter)) {
                            expresionPostfija.append(pila.pop());
                        }
                        pila.push(caracter);
                    }
        }
        // vacia todos lo operadores de la pila en la expresionFinal
        while (!pila.isEmpty()) {
            expresionPostfija.append(pila.pop());
        }
        return expresionPostfija.toString();
    }

    // este switch es para ver la prioridad de los operadores
    private static int prioridad(char operador) {
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

