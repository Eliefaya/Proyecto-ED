/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas_g1;
/**
 *
 * @author efaya
 */
public class MetodosEstaticos {
    //Metodo para invertir los elementos de una pila
    public static <T>void invertirPila(PilaADT<T> stack) {
        PilaADT<T> stackAux= new PilaA<>();
        PilaADT<T> stackAux2= new PilaA<>();
        
        while(!stack.isEmpty()){
            stackAux.push(stack.pop());
        }
        while(!stackAux.isEmpty()){
            stackAux2.push(stackAux.pop());
        }
        while(!stackAux2.isEmpty()){
            stack.push(stackAux2.pop());
        }
        
    }
    public static <T>int calculaNumElementos(PilaADT <T>pila){
        PilaADT <T> pilaAux= new PilaA<>();
        int numElementos; 
        numElementos=0; 
        
        while(!pila.isEmpty()){
            pilaAux.push(pila.pop());
        }
        while(!pilaAux.isEmpty()){
            pila.push(pilaAux.pop());
            numElementos++;
        }
        return numElementos;
        
    }/*
    public static <T> void eliminaRepetidos(PilaADT <T> stack){
        PilaADT <T> stackAux= new PilaA<>();
        PilaADT<T> stackAux2= new PilaA<>();
        
        while(!stack.isEmpty()){
            stackAux.push(stack.pop());
            if(stackAux.peek().equals(stack.pop())==false){
                stackAux2.push(stackAux.pop());
            }
            else 
                stackAux.pop();
            
        }
        stack.push(stackAux2.pop());
    }
    */
    /*
    //Ejercicio !5
    public static <T> boolean verificarContencion(PilaADT<T> stack1, PilaADT<T> stack2) {
        boolean contenido = false;
        T elemento;
        PilaADT<T> stackAux = new PilaA<>();
        
        while (!stack2.isEmpty()) {
            elemento = stack2.pop();
            if (stack1.contains(elemento)) {
                contenido = true;
                stackAux.push(elemento);
            }
        }
        while (!stackAux.isEmpty()) {
            stack2.push(stackAux.pop());
        }
        return contenido;   
    }
    //Ejercicio 20 
    */
    public static int regresaBinario(int num){
        
        PilaADT <Integer> stack = new PilaA<>();
        int i=1; 
        int numBin=0;
        while(num !=1 ){
            int bin; 
            bin= num%2;
            double binFin= Math.pow(i, bin);
            stack.push(bin);
            binFin=stack.pop();
            i++;
        }
        return numBin;
    }
    public static <T>void eliminarNElementos(PilaADT <T> stack, int n){
        int c= MetodosEstaticos.calculaNumElementos(stack);
        int i =1;
        if(c>n){
            while(i<=n){
                stack.pop();
                i++;
            }
        }
            
        }
        
    
    
}




