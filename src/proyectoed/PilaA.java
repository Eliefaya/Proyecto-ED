/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoed;

import java.util.Arrays;

/**
 *
 * @author efaya
 */
public class PilaA <T> implements PilaADT<T>{
    
    private T []arrePila; 
    private int tope;
    private final int MAX=100;
    
    public PilaA(){
        arrePila= (T[])new Object[MAX]; //Creo un objeto y los casteo del tipo <T>
        tope=-1;
    }

    @Override
    public void push(T dato) {
        if(tope + 1== arrePila.length) //Pila llena
            expande();
        tope++;
        arrePila[tope]= dato;
    }
    
    //Metodo que construye un arreglo mas grande y copia los elementos
    //de la pila a el, reasignando el valor del altributo "pila"
    private void expande(){
        T[] masGrande= (T[]) new Object [arrePila.length*2];
        for(int i=0; i<arrePila.length; i++){
        masGrande[i]=arrePila[i];
        arrePila=masGrande;
        }
    }
    
    @Override
    public T pop() {
        if(this.isEmpty())
            throw new ExcepcionColeccionVacia("La pila esta vacia "); //Lanza excpetion (throw new)
        T eliminado;
        eliminado= arrePila[tope];
        arrePila[tope]= null; 
        tope--;
        return eliminado; 
    }
    
    @Override
    public boolean isEmpty() {
        return tope==-1;
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new ExcepcionColeccionVacia("La pila esta vacia ");
        return arrePila[tope];
    }
    
    public String toString(){
        StringBuilder texto = new StringBuilder();
        texto.append("Pila de 0 a tope: \n");
        for(int i=0; i<=tope; i++){
            texto.append(arrePila[i]).append(" ");
        }
        return texto.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Arrays.deepHashCode(this.arrePila);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PilaA<?> other = (PilaA<?>) obj;
        return Arrays.deepEquals(this.arrePila, other.arrePila);
    }
    
    // Método para verificar si un elemento está contenido en la pila
    public boolean contains(T elemento) {
        for (int i = 0; i < arrePila.length; i++) {
            if (arrePila[i] == elemento) {
                return true;
            }
        }
        return false;
    }
}
