/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chris
 */
public class listaDoble {
    private int tamanio;
    private nodoD cabeza;
    private nodoD cola;
    
    //constructor
    public listaDoble(){
        tamanio = 0;
        cabeza = null;
        cola=null;
    }
    
    //saber tamaño de la lista
    public int getTamanio(){
        return tamanio;
    }
    
    //metodo 1. si esta vacia 
    public boolean estaVacia(){
        boolean resultado = (cabeza == null && cola == null)?true:false;
        return resultado;
    }
    
    //metodo 2. Insertar inicio
    public void insertarInicio(int dato){
        nodoD nuevo = new nodoD(dato);
        
        if(estaVacia()){
            cabeza = nuevo;
            cola = nuevo;
            tamanio++;
        }else{
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
            tamanio++;
        }
    }
    //metodo3. Insertar final
    public void insertarFinal(int dato){
        nodoD nuevo = new nodoD(dato);
        
        if(estaVacia()){
            cabeza = nuevo;
            cola = nuevo;
            tamanio++;
        }else{
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
            tamanio++;
        }
    }
    //metodo4. eliminar inicio
    public int eliminarInicio(){
        if(estaVacia()){
            throw new IllegalStateException("La lista esta vacia");
        }
        
        int dato = cabeza.getDato();
        
        if(cabeza == cola){
            cabeza = null;
            cola=null;
        }else{
            
            cabeza = cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(null);
            cabeza.setAnterior(null);
            tamanio--;
            
        }
        return dato;
    }
   
    
    //metodo 5. buscar
    public boolean buscar(int dato){
        if(estaVacia()){
            return false;
        }else{
            nodoD aux = cabeza;
            while(aux != null){
                if(aux.getDato() == dato){
                    return true;
                }
                aux = aux.getSiguiente();
            }
            return false;
        }
    }
    
    //metodo 6. obtener nodo
    public nodoD ObtenerNodo(int pos){
        if(pos <= 0 || pos > tamanio){
           throw new IllegalStateException("Posicion invalida");
        }else{
            nodoD aux = cabeza;
            for(int i = 1; i < pos; i++){
                aux = aux.getSiguiente();
            }
            return aux;
        }
    }
    
    //metodo 7. actualizar
    public void actualizar(int dato, int pos){  
        nodoD aux = ObtenerNodo(pos);
        aux.setDatos(dato);
    }
    
    //METODOS DE TAREA
    //metodo 8. Insertar por posicion
    public void insertarEnPosicion(int pos, int dato){
        if(pos <= 0 || pos > tamanio){
            throw new IllegalStateException("posicion invalido");
        }
        
        if(pos == 1){
            insertarInicio(dato);
            return;
        }
        //aqui buscamos el nodo en la posicion que se solicito
        nodoD actual = ObtenerNodo(pos);
        //creamos el nuevo nodo para el dato
        nodoD nuevo = new nodoD(dato); 
        
        //el nodo anterior del actual apunta al nodo nuevo
        actual.getAnterior().setSiguiente(nuevo);
        //en nodo nuevo de su enlace anterior apunta al nodo acual anterior
        nuevo.setAnterior(actual.getAnterior());
        //el nodo nuevo apunta al nodo actual
        nuevo.setSiguiente(actual);
        
        actual.setAnterior(nuevo);
        tamanio++;
    }
    //metodo 9. eliminar en posicion
    public int eliminarEnPosicion(int pos){
        if(pos <= 0 || pos > tamanio){
            throw new IllegalStateException("La lista esta vacia");
        }
        
        if(pos == 1){
            return eliminarInicio();
        }
        //buscamos el nodo en esa posicion
        nodoD aux = ObtenerNodo(pos);
        //guardamos el valor del nodo que se va a eliminar
        int resultado = aux.getDato();
        //el nodo anterior del nodo actual(aux) lo apuntamos al nodo siguiente de actual
        aux.getAnterior().setSiguiente(aux.getSiguiente());
        //el nodo siguiente del actual lo apuntamos al nodo anterior del actual
        aux.getSiguiente().setAnterior(aux.getAnterior());
        //aunque hemos vinculado, el actual aun sigue formando parte de la lista por
        //su aux.getsiguiente y aux.getAnterior
        //para quitarlos de la lista los enlazamos a null
        aux.setAnterior(null);
        aux.setSiguiente(null);
        tamanio--;
        return resultado;
        
    }
    //metodo 10. eliminar por valor
    public boolean eliminarPorValor(int dato){
        if(estaVacia()){
            return false;
        }
        
        if(cabeza.getDato()==dato){
            eliminarInicio();
            return true;
        }
        
        nodoD aux = cabeza;
        while(aux.getSiguiente()!=null){
            if(aux.getSiguiente().getDato() == dato){
                aux=aux.getSiguiente();
                //el nodo anterior del nodo actual(aux) lo apuntamos al nodo siguiente de actual
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                //el nodo siguiente del actual lo apuntamos al nodo anterior del actual
                aux.getSiguiente().setAnterior(aux.getAnterior());
                //aunque hemos vinculado, el actual aun sigue formando parte de la lista por
                //su aux.getsiguiente y aux.getAnterior
                //para quitarlos de la lista los enlazamos a null
                aux.setAnterior(null);
                aux.setSiguiente(null);
                tamanio--;
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    //metodo 11. Eliminar el ultimo
    public boolean eliminarUltimo(){
        if(estaVacia()){
            return false;
        }
        if(cabeza == cola){
            cabeza = null;
            cola = null;
            tamanio--;
             return true;
        }else{
            cola = cola.getAnterior();
            cola.setSiguiente(null);
            tamanio--;
            return true;
        }
    }
    
    
    //metodo 12. insertarOrdenado
    public void insertarOrdenado(int dato){
        
        //el dato es menor o igual que la cabeza
        if(estaVacia() || dato <= cabeza.getDato()){
            insertarInicio(dato);
            return;
        }
        
        //el dato es mayor que todos, se inserta al final
        if(dato >= cola.getDato()){
            insertarFinal(dato);
            return;
        }
        
        nodoD nuevo = new nodoD(dato);
        nodoD aux = cabeza;
        while(aux.getSiguiente() != null){
            //verificamos que dato siguiente es mayor que el dato de entrada
            if(aux.getSiguiente().getDato() > nuevo.getDato()){
                
                nodoD auxSig =aux.getSiguiente();
                
                aux.setSiguiente(nuevo);
                nuevo.setAnterior(aux);
                nuevo.setSiguiente(auxSig);
                auxSig.setAnterior(nuevo);
                return;
            }
            aux = aux.getSiguiente();
        }
        tamanio++;
    }
    
    //metodo 13. imprimir
    public void imprimir(){
        nodoD actual = cabeza;
        
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print(actual.getDato());
            if (actual.getSiguiente() != null) {
                System.out.print(" <-> ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println(" -> null"); 
    }
   
    
    
}
