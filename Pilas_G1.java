/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilas_g1;

/**
 *
 * @author efaya
 */
public class Pilas_G1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*PilaA<Integer> p1= new PilaA();
        PilaADT p2= new PilaA();
        //Ejemplo de manejo de excepcion
        try{
            p1.pop();
        }
        catch(Exception error){
            System.out.println("\n Algo paso: "+ error.getMessage());
        }
        p1.push(25);
        p1.push(40);
        p1.push(10);
        p1.push(71);
        System.out.println("\nContendio de la pila p1: "+ p1);
        
        //Prueba de el metodo estatico que invierte los elementos de una pila 
        PilaADT<Integer> stack = new PilaA<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(6);
        stack.push(6);
        stack.push(5);
        stack.push(6);
        System.out.println("Pila original: " + stack);
        
        MetodosEstaticos.invertirPila(stack);
        
        System.out.println("Pila invertida: " + stack);
        System.out.println("Numero de Elementos: "+MetodosEstaticos.calculaNumElementos(stack));
        MetodosEstaticos.eliminaRepetidos(stack);
        System.out.println("La Pila post Eliminaciond de repetidos: "+stack);
        
        String expresionInfija = "(2+3)+(7+8)";
        String expresionPostfija = ConvertidorExpresion.infijaAPostfija(expresionInfija);
        System.out.println("Expresion infija: " + expresionInfija);
        System.out.println("Expresion postfija: " + expresionPostfija);

        PilaADT stack3 = new PilaA();
        PilaADT stack2= new PilaA();
        stack2.push(1);
        stack2.push(2);
        stack2.push(5);
        
        stack3.push(5);
        stack3.push(6);
        stack3.push(6);
        
        System.out.println("Pila principal: " + stack2);
        System.out.println("Pila secundaria: " + stack3);
        if((MetodosEstaticos.verificarContencion(stack2, stack3))==true){
            System.out.println("Esta contenida");
        }
        else 
            System.out.println("No esta contenida");*/
       /* PilaADT stack= new PilaA();
       int bin= MetodosEstaticos.regresaBinaario(28);
        System.out.println(bin);*/
        
        PilaADT<Integer> stack = new PilaA<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(6);
        stack.push(6);
        stack.push(5);
        stack.push(6);
        System.out.println("Pila original: " + stack);
        
        MetodosEstaticos.eliminarNElementos(stack, 10);
        System.out.println("Pila post eliminacion"+stack);
        System.out.println(MetodosEstaticos.regresaBinario(9));
        
    }
    
    }
    


