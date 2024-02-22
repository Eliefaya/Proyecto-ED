package proyectoed;

/**
 * Clase que contiene todas las funciones para la verificación de la sintaxis de la cadena
 * @author juanpa
 */
public class VerificaCadena {

    /**
     * Función que verifica que la operación no tenga errores de sintaxis
     * <ul> Condiciones de la cadena
     * <li> La cadena no puede iniciar con un operador que no sea '+' o '-' </li>
     * <li> La cadena no puede finalizar con un operador </li>
     * <li> Caracteres admitidos: +, -, *, /, ^, (), '.', números del 1-9 </li>
     * <li> <ol> Separaciones entre caracteres
     * <li> No pueden haber dos (o más) operadores juntos </li>
     * <li> No pueden haber dos (o más) puntos juntos </li>
     * </ol>
     * <li> El punto debe tener un número como vecino (a la izquierda y/o derecha) </li>
     * <li> No pueden haber dos puntos separados por números </li>
     * <li> Los paréntesis deben estar balanceados </li>
     * <li> Los paréntesis deben contener por lo menos algo </li>
     * <li> El contenido de los paréntesis no puede iniciar con un operador que no sea '+' o '-' y no puede finalizar con un operador </li>
     * </ul>
     * Nota: las funciones que utiliza verifica están configuradas como public únicamente para que el javadoc sea correctamente generado. 
     * @param cadena
     * @return Regresa true si la cadena cumple con todas las condiciones, y false si no cumple con alguna de ellas.
    */
    public static boolean verifica(String cadena){
        boolean res = false;
        if (cadena.length() > 0 && verificaInicio(cadena) && verificaFinal(cadena) && verificaCaracteresAdmitidos(cadena) && verificaSeparaciones(cadena) && verificaPuntosNumVecinos(cadena) && verificaPuntosConteniendoNum(cadena) && verificaParentesisBalanceados(cadena) && verificaParentesisContenido(cadena) && verificaParentesisInicioFinal(cadena)){
            res = true;
        }
        return res;
    }
    
    
    
    /**
     * Identificador de caracter
     * @param caracter
     * @return Regresa true si un caracter en específico es paréntesis
     */
    public static boolean esParentesis(char caracter){
        boolean res = false;
        if (caracter == '(' || caracter == ')')
            res = true;
        return res;     
    }
    
    /**
     * Identificador de caracter
     * @param caracter
     * @return Regresa true si un caracter en específico es operador
     */
    public static boolean esOperador(char caracter){
        boolean res = false;
        if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
            res = true;
        return res;     
    }
    
    /**
     * Identificador de caracter
     * @param caracter
     * @return Regresa true si un caracter en específico es punto
     */
    public static boolean esPunto(char caracter){
        boolean res = false;
        if (caracter == '.')
            res = true;
        return res;     
    }
    
    /**
     * Identificador de caracter
     * @param caracter
     * @return Regresa true si un caracter en específico es número
     */
    public static boolean esNumero(char caracter){
        boolean res = false;
        if (caracter == '0' || caracter == '1' || caracter == '2' || caracter == '3' || caracter == '4' || caracter == '5' || caracter == '6' || caracter == '7' || caracter == '8' || caracter == '9')
            res = true;
        return res;     
    }
    
    /**
     * Identificador de caracter
     * @param caracter
     * @return Regresa true si un caracter en específico es + o -
     */
    public static boolean esMasMenos(char caracter){
        boolean res = false;
        if (caracter == '-' || caracter == '+')
            res = true;
        return res;
    }
    
    /**
     * Condición 1
     * @param cadena
     * @return Regresa true si la cadena no inicia con un operador que no sea '+' o '-'
     */
    public static boolean verificaInicio(String cadena){
        boolean res = true;
        char caracter;
        if (cadena.length() > 0){
            caracter = cadena.charAt(0);
            if ((esOperador(caracter) && !esMasMenos(caracter)))
                res = false;
        }
        else
            res = false;
        return res;
    }
    
    /**
     * Condición 2
     * @param cadena
     * @return Regresa true si la cadena no finaliza con un operador
     */
    public static boolean verificaFinal(String cadena){
        boolean res = true;
        char caracter;
        if (cadena.length() > 0){
            caracter = cadena.charAt(cadena.length() - 1);
            if (esOperador(caracter))
                res = false;
        }
        else
            res = false;
        return res;
    }

    /**
     * Condición 3
     * @param cadena
     * @return Regresa true si la cadena no contiene caracteres que no sean +, -, *, /, ^, (), '.' o números del 1-9
     */
    public static boolean verificaCaracteresAdmitidos(String cadena){
        boolean res = true;
        char caracter;
        int i = 0;
        if (cadena.length() > 0){
            while (i < cadena.length() && res){
                caracter = cadena.charAt(i);
                if (!esParentesis(caracter) && !esOperador(caracter) && !esPunto(caracter) && !esNumero(caracter))
                    res = false;  
                i++;
            }
        }
        else
            res = false;
        return res;
    }
    
    /**
     * Condición 4
     * @param cadena
     * @return Regresa true si no hay dos operadores ni dos puntos juntos
     */
    public static boolean verificaSeparaciones(String cadena){
        boolean res = true;
        char caracter1;
        char caracter2;
        int i = 1;
        if (cadena.length() > 0){
            caracter1 = cadena.charAt(0);
            while (i < cadena.length() && res){
                caracter2 = cadena.charAt(i);
                if ((esOperador(caracter1) && esOperador(caracter2)) || (esPunto(caracter1) && esPunto(caracter2)))
                    res = false;
                caracter1 = caracter2;
                i++;
            }
        }
        else
            res = false;
        return res;
    }
    
    /**
     * Condición 5
     * @param cadena
     * @return Regresa true si el punto tiene un número como vecino (a la izquierda y/o derecha)
     */
    public static boolean verificaPuntosNumVecinos(String cadena){
        boolean res = true;
        boolean condicion1 = false;
        char caracter1;
        char caracter2;
        int i = 1;
        if (cadena.length() > 0){
            caracter1 = cadena.charAt(0);
            if (esPunto(caracter1) && cadena.length() == 1)
                res = false;
            while (i < cadena.length() && res){
                caracter2 = cadena.charAt(i);
                if (condicion1 && !esNumero(caracter2))
                    res = false;
                else
                    if (!esNumero(caracter1) && esPunto(caracter2)){
                        condicion1 = true;
                        if (i + 1 == cadena.length())
                            res = false;
                    }
                    else 
                        condicion1 = false;
                caracter1 = caracter2;
                i++;
            }
        }
        else
            res = false;
        return res;
    }
    
    /**
     * Condición 6
     * @param cadena
     * @return Regresa true si, en ningún lugar de la cadena, existen dos puntos que contengan números entre ellos
     */
    public static boolean verificaPuntosConteniendoNum(String cadena){
        boolean res = true;
        boolean condicion = false;
        char caracter;
        int i = 0;
        if (cadena.length() > 0){
            while (i < cadena.length() && res){
                caracter = cadena.charAt(i);
                if (condicion)
                    if (esPunto(caracter))
                        res = false;
                    else
                        if (!esNumero(caracter))
                            condicion = false;
                if (esPunto(caracter))
                        condicion = true;
                i++;
            }
        }
        else 
            res = false;
        return res;
    }
    
    /**
     * Condición 7
     * @param cadena
     * @return Regresa true si los paréntesis de la cadena estan balanceados
     */
    public static boolean verificaParentesisBalanceados(String cadena){
        boolean res = false;
        boolean huboExcepcion = false;
        char caracter;
        PilaA<Character> pila = new PilaA<>();
        int i = 0;
        if (cadena.length() > 0){
            while (i < cadena.length() && !huboExcepcion){
                caracter = cadena.charAt(i);
                if (caracter == '(')
                    pila.push(cadena.charAt(i));
                else{
                    if (caracter == ')'){
                        try{
                            pila.pop();
                        }
                        catch(Exception error){
                            huboExcepcion = true;
                        }
                    }
                }
                i++;   
            }
            if (pila.isEmpty() && !huboExcepcion)
            res = true;
        }
        else
            res = false;
        return res;
    }
    
    /**
     * Condición 8
     * @param cadena
     * @return Regresa true si no hay paréntesis vacíos
     */
    public static boolean verificaParentesisContenido(String cadena){
        boolean res = true;
        char caracter1;
        char caracter2;
        int i = 1;
        if (cadena.length() > 0){
            caracter1 = cadena.charAt(0);
            while (i < cadena.length() && res){
                caracter2 = cadena.charAt(i);
                if (caracter1 == '(' && caracter2 == ')')
                    res = false;
                caracter1 = caracter2;
                i++;
            }
        }
        else
            res = false;
        return res;
    }
    
    /**
     * Condición 9
     * @param cadena
     * @return Regresa true si el contenido de los paréntesis no inicia con un operador que no sea '+' o '-', y no termina con un operador
     */
    public static boolean verificaParentesisInicioFinal(String cadena){
        boolean res = true;
        char caracter1;
        char caracter2;
        int i = 0;
        if (cadena.length() > 0){
            caracter1 = cadena.charAt(0);
            while (i < cadena.length() && res){
                caracter2 = cadena.charAt(i);
                if ((caracter1 == '(' && esOperador(caracter2) && !esMasMenos(caracter2)) || (esOperador(caracter1) && caracter2 == ')'))
                    res = false;
                caracter1 = caracter2;
                i++;
            }
        }
        else
            res = false;
        return res;
    }

}