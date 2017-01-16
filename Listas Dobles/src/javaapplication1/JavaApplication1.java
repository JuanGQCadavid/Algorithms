/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.*;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author jquiro12
 */
public class JavaApplication1<Item> implements Iterable<Item> {
    
    private Nodo nodoInicio;
    private Nodo nodoActual;
    
    private class Nodo{
        Item item;
        Nodo siguiente;
        Nodo atras;
    }
    public void inicializarLista(){
        nodoInicio = new Nodo();
        nodoInicio.siguiente = null;
        nodoInicio.atras = null;
        nodoActual = nodoInicio;
        
    }
    public void agregar(Item item){
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.item = item;
        nodoNuevo.siguiente = null;
        nodoNuevo.atras= nodoActual;
        nodoActual.siguiente = nodoNuevo;
        nodoActual = nodoNuevo;
    }
    public void recorrer(){
        for (Nodo x = nodoInicio.siguiente; x != null; x = x.siguiente) {
            System.out.println("En la lista hacia ADELANTE: " + x.item);
        }
    }
    public void recorrerA(){
        System.out.println("A");
        for (Nodo x = nodoActual; x.atras != null; x = x.atras) {
            System.out.println("En la lista hacia ATRAS: " + x.item);
        }
    }
    
    public void eliminar(Item item,JavaApplication1<String > primeraLista ){
        System.out.println("--------Elemento a borrar: " + item + " --------");
        for(Nodo x = nodoInicio.siguiente; x.siguiente != null; x = x.siguiente){
            
            if(x != nodoActual){
                
                if(x.item.equals(item)){
                    
                    Nodo nodoBorrar = x;
                    Nodo nodoAnterior = x.atras;
                    Nodo nodoSiguiente = x.siguiente;
                    
                    nodoAnterior.siguiente = nodoSiguiente;
                    nodoSiguiente.atras = nodoAnterior;
                            
                    
                    System.out.println("--------Lista nueva------------------");
                    primeraLista.recorrer();
                    System.out.println("--------Item Borrado------------------");
                    break;
                
                }
            }else if(x ==(nodoActual)){
                    
                    if(x.item.equals(item)){
                        
                        Nodo nodoAntes = x;


                        nodoAntes.siguiente= null;
                        nodoAntes.atras = null;
                                

                        
                        
                        System.out.println("--------Lista nueva------------------");
                        primeraLista.recorrer();
                        System.out.println("--------Item Borrado------------------");
                        break;
                    }else{
                        System.out.println("--------No parce,eso no existe.------------------");
                        break;
                    }
                    
                
            }
        }
        
    }
    
    public Iterator <Item> iterator(){
        return new ListIterator();
    }
    
    public class ListIterator implements Iterator<Item>{
        private Nodo nodoActual = nodoInicio;
        public boolean hasNext(){
            return nodoActual != null;
        }
        public void remove (){
        
        }
        public Item next(){
            Item item = nodoActual.item;
            nodoActual = nodoActual.siguiente;
            return item;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        JavaApplication1<String > primeraLista = new JavaApplication1<String>();
       

        primeraLista.inicializarLista();
        
        
        
        primeraLista.LeerArchivo(primeraLista);
        
        primeraLista.recorrerA();
        /*
            Profesor, tenga en cuenta que el numero que esta entre ""
            es el numero que se desea eliminar.
        */
        primeraLista.eliminar("961",primeraLista );
        
        /*
            Profesor, o trabajo con el archivo Fichero, es uno con menos numeros
            y esto nos permite una facil observacion del trabajo, si decea trabajar
            con el archivo inicial, por favor cambie en LeerArchivo En la variable
            Archivo en donde dice "Fichero.txt" por "aleatorio.txt"
            
            Muchas Gracias!
        */
        
    }
    public void LeerArchivo(JavaApplication1<String > primeraLista) throws FileNotFoundException, IOException{
        String Archivo = ""+getClass().getResource("Fichero.txt");
        Archivo = Archivo.substring(5, Archivo.length());
        String cadena;
        FileReader f = new FileReader(Archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
           primeraLista.agregar(cadena);
        }
        b.close();       
    }
    
    
}
