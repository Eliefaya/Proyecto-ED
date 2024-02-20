package proyectoed;

/**
 * Función que checa si la operación está bien escrita
 * @author juanpa
 */
public class VerificaCadena {
    
    
    
    /** Condiciones de la cadena
     * 1) La cadena no puede iniciar con un operador que no sea '+' o '-'
     * 2) La cadena no puede finalizar con un operador
     * 3) Caracteres admitidos: +, -, *, /, ^, (), '.', números del 1-9
     * 4) Separaciones entre caracteres
     *    No pueden haber dos (o más) operadores juntos
     *    No pueden haber dos (o más) puntos juntos
     * 5) El punto debe tener un número como vecino (a la izquierda y/o derecha)
     * 6) No pueden haber dos puntos separados por números
     * 7) Los paréntesis deben estar balanceados
     * 8) Los paréntesis deben contener por lo menos algo
     * 9) El contenido de los paréntesis no puede iniciar ni finalizar con un operador que no sea '+' o '-'
     */
    
    
    
    // Función que verifica que todas las condiciones se cumplan en la cadena
    
    /**
     *
     * @param cadena
     * @return 
     */
    public static boolean verifica(String cadena){
        boolean res = false;
        if (cadena.length() > 0 && verificaInicio(cadena) && verificaFinal(cadena) && verificaCaracteresAdmitidos(cadena) && verificaSeparaciones(cadena) && verificaPuntosNumVecinos(cadena) && verificaPuntosConteniendoNum(cadena) && verificaParentesisBalanceados(cadena) && verificaParentesisContenido(cadena) && verificaParentesisInicioFinal(cadena)){
            res = true;
        }
        return res;
    }
    
    
    
    // Funciones que indican si un caracter en específico cumple cierta condición (utilizados en el código)
    
    private static boolean esParentesis(char caracter){
        boolean res = false;
        if (caracter == '(' || caracter == ')')
            res = true;
        return res;     
    }
    
    private static boolean esOperador(char caracter){
        boolean res = false;
        if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^')
            res = true;
        return res;     
    }
    
    private static boolean esPunto(char caracter){
        boolean res = false;
        if (caracter == '.')
            res = true;
        return res;     
    }
    
    private static boolean esNumero(char caracter){
        boolean res = false;
        if (caracter == '0' || caracter == '1' || caracter == '2' || caracter == '3' || caracter == '4' || caracter == '5' || caracter == '6' || caracter == '7' || caracter == '8' || caracter == '9')
            res = true;
        return res;     
    }
    
    private static boolean esMasMenos(char caracter){
        boolean res = false;
        if (caracter == '-' || caracter == '+')
            res = true;
        return res;
    }
    
    private static boolean esCero(char caracter){
        boolean res = false;
        if (caracter == '0')
            res = true;
        return res;
    }
    
    private static boolean esDivision(char caracter){
        boolean res = false;
        if (caracter == '/')
            res = true;
        return res;
    }
    
    
    
    // Funciones que verifican si se cumple cierta condición en la cadena
    
    // 1)
    private static boolean verificaInicio(String cadena){
        boolean res = true;
        char caracter = cadena.charAt(0);
        if ((esOperador(caracter) && !esMasMenos(caracter)))
            res = false;
        return res;
    }
    
    //2)
    private static boolean verificaFinal(String cadena){
        boolean res = true;
        char caracter = cadena.charAt(cadena.length() - 1);
        if (esOperador(caracter))
            res = false;
        return res;
    }

    // 3)
    private static boolean verificaCaracteresAdmitidos(String cadena){
        boolean res = true;
        char caracter;
        int i = 0;
        while (i < cadena.length() && res){
            caracter = cadena.charAt(i);
            if (!esParentesis(caracter) && !esOperador(caracter) && !esPunto(caracter) && !esNumero(caracter))
                res = false;  
            i++;
        }
        return res;
    }
    
    // 4)
    private static boolean verificaSeparaciones(String cadena){
        boolean res = true;
        char caracter1 = cadena.charAt(0);
        char caracter2;
        int i = 1;
        while (i < cadena.length() && res){
            caracter2 = cadena.charAt(i);
            if ((esOperador(caracter1) && esOperador(caracter2)) || (esPunto(caracter1) && esPunto(caracter2)))
                res = false;
            caracter1 = caracter2;
            i++;
        }
        return res;
    }
    
    // 5)
    private static boolean verificaPuntosNumVecinos(String cadena){
        boolean res = true;
        boolean condicion1 = false;
        char caracter1 = cadena.charAt(0);
        char caracter2;
        int i = 1;
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
        return res;
    }
    
    // 6)
    private static boolean verificaPuntosConteniendoNum(String cadena){
        boolean res = true;
        boolean condicion = false;
        char caracter;
        int i = 0;
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
        return res;
    }
    
    // 7)
    private static boolean verificaParentesisBalanceados(String cadena){
        boolean res = false;
        boolean huboExcepcion = false;
        char caracter;
        PilaA<Character> pila = new PilaA<>();
        int i = 0;
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
        return res;
    }
    
    // 8)
    private static boolean verificaParentesisContenido(String cadena){
        boolean res = true;
        char caracter1 = cadena.charAt(0);
        char caracter2;
        int i = 1;
        while (i < cadena.length() && res){
            caracter2 = cadena.charAt(i);
            if (caracter1 == '(' && caracter2 == ')')
                res = false;
            caracter1 = caracter2;
            i++;
        }
        return res;
    }
    
    // 9)
    private static boolean verificaParentesisInicioFinal(String cadena){
        boolean res = true;
        char caracter1 = cadena.charAt(0);
        char caracter2;
        int i = 0;
        while (i < cadena.length() && res){
            caracter2 = cadena.charAt(i);
            if ((caracter1 == '(' && esOperador(caracter2) && !esMasMenos(caracter2)) || (esOperador(caracter1) && caracter2 == ')'))
                res = false;
            caracter1 = caracter2;
            i++;
        }
        return res;
    }

}