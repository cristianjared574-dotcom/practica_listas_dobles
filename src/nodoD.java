/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chris
 */
public class nodoD {
    private int dato;
    private nodoD siguiente;
    private nodoD anterior;
    
    //constructor
    public nodoD(int datoEntrada){
        dato = datoEntrada;
        siguiente = null;
        anterior = null;
    }
    
    //propiedades
    //get y set del atributo dato
    public int getDato(){
        return dato;
    }
    
    public void setDatos(int dato){
        this.dato = dato;
    }
    
    //get y set de siguiente
    public nodoD getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(nodoD sig){
        siguiente = sig;
    }
    
    //get y set de anterior
    public nodoD getAnterior(){
        return anterior;
    }
    
    public void setAnterior( nodoD Ant){
        anterior = Ant;
    }
    
    
}
