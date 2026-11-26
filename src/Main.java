/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Chris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        listaDoble lista = new listaDoble();

        System.out.println("Esta vacia: " + lista.estaVacia());
        System.out.println("Eliminar ultimo en vacia: " + lista.eliminarUltimo());
        System.out.println("Eliminar valor 10 en vacia: " + lista.eliminarPorValor(10));
        lista.imprimir();
        
        lista.insertarInicio(20);
        lista.insertarEnPosicion(1, 10);
        lista.insertarEnPosicion(2, 15); 
        lista.insertarFinal(30); 
        lista.imprimir();
        System.out.println("Tamanio: " + lista.getTamanio());

        System.out.println("Buscar 30: " + lista.buscar(30));
        lista.actualizar(35, 3); 
        lista.imprimir();
        
        System.out.println("Eliminar 10 (cabeza): " + lista.eliminarPorValor(10));
        System.out.println("Eliminar 40 (cola): " + lista.eliminarPorValor(40));
        lista.imprimir();

        lista.insertarFinal(50);
        lista.insertarFinal(60);
        System.out.println("Eliminado en pos 2: " + lista.eliminarEnPosicion(2));
        System.out.println("Eliminar ultimo: " + lista.eliminarUltimo());
        lista.imprimir();

        //lista desordenado a lista ordenado
        listaDoble ordenada = new listaDoble();
        int[] datos = {25, 5, 40, 15, 25, 1, 50};
        for (int d : datos) {
            ordenada.insertarOrdenado(d);
        }
        ordenada.imprimir();

        
    }
    
}
