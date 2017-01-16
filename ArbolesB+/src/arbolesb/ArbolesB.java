/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesb;

import java.util.ArrayList;


public class ArbolesB {
    
 
    public static void main(String[] args) {
        Nodo nodoRaiz = new Nodo();
        
        anadirValor(45,nodoRaiz);
        
    }
    public static void anadirValor(int valor, Nodo nodoActual){
        
       /*
            if(nodoActual.getDatos()!= null){
                if(valor < nodoActual.getDatos().get(0)){
                anadirValor(valor, nodoActual.getNodoIzquierdo());
                }else{
                    
                }
            }else{
                
            }
        
        */
        if(nodoActual.getDatos().size() < 2){
            ordenarDatos(valor, nodoActual);
        }else{
            
            ArrayList<Integer> ordenados = ordenarDatosV2(nodoActual.getDatos(),valor);
            
            int nodoSplit = ordenados.get(1);
            
            Nodo nodoIzq = nodoActual.getNodoAlLadoIzq();
            
            Nodo nodoCentro = new Nodo();
            nodoCentro.getDatos().add(ordenados.get(0));
            
            Nodo nodoPadre = nodoActual.getNodoPadre();
            
            nodoCentro.setNodoAlLadoDerecho(nodoActual);
            nodoCentro.setNodoAlLadoIzq(nodoIzq);
            
            nodoCentro.setNodoPadre(nodoPadre);
            
            nodoIzq.setNodoAlLadoDerecho(nodoCentro);
            nodoActual.setNodoAlLadoIzq(nodoIzq);
            
            nodoActual.getDatos().set(0, ordenados.get(1));
            nodoActual.getDatos().set(1, ordenados.get(2));
            
            if(nodoPadre.getNodoTemporal() == null){
                nodoPadre.setNodoCentro(nodoCentro);
                
            }else{
                nodoPadre.setNodoTemporal(nodoCentro);
            }
            
            splitNodo(nodoSplit, nodoActual.getNodoPadre());
            
        }
        
    }
    
    public static void splitNodo(int nodoSplit, Nodo nodoActual){
        if(nodoActual.getDatos().size()<2){
            ordenarDatos(nodoSplit, nodoActual);
            return;
        }
        
            if(nodoSplit > nodoActual.getDatos().get(0)){
                if(nodoSplit>nodoActual.getDatos().get(1)){
                    int nodoTempSplit = nodoActual.getDatos().get(1);
                    nodoActual.getDatos().set(1, nodoSplit);
                    nodoSplit = nodoTempSplit;
                }
            }else{
                int nodoTempSplit = nodoActual.getDatos().get(0);
                nodoActual.getDatos().set(0, nodoSplit);
                nodoSplit = nodoTempSplit;
            }
            
        
        
        // reviso si tengo Temporales
        
        if(nodoActual.getNodoTemporal()!= null){
            Nodo nodoIzquierdoNuevo = new Nodo();
            Nodo nodoDerechoNuevo = new Nodo();
            
            Nodo nodoPadre = nodoActual.getNodoPadre();
            
            
            //Padres
            nodoIzquierdoNuevo.setNodoPadre(nodoPadre);
            nodoDerechoNuevo.setNodoPadre(nodoPadre);
            
            //Hijos
            
            // Hijos Izquierdos
            nodoIzquierdoNuevo.setNodoIzquierdo(nodoActual.getNodoIzquierdo());
            nodoIzquierdoNuevo.setNodoDerecho(nodoActual.getNodoCentro());
            
            // Hijos Derechos
            
            nodoDerechoNuevo.setNodoIzquierdo(nodoActual.getNodoTemporal());
            nodoDerechoNuevo.setNodoDerecho(nodoActual.getNodoDerecho());
            
            //Matamos el Nodo Actual, boom Beacht.
            
            nodoActual.setNodoDerecho(null);
            nodoActual.setNodoIzquierdo(null);
            nodoActual.setNodoAlLadoDerecho(null);
            nodoActual.setNodoAlLadoIzq(null);
            nodoActual.setNodoCentro(null);
            nodoActual.setNodoTemporal(null);
            
            //NodoPadre
            
            if(nodoPadre.getNodoIzquierdo() == nodoActual){
                nodoPadre.setNodoIzquierdo(nodoIzquierdoNuevo);
                if(nodoPadre.getNodoCentro() == null){
                    nodoPadre.setNodoCentro(nodoDerechoNuevo);
                }else{
                    nodoPadre.setNodoTemporal(nodoPadre.getNodoCentro());
                    nodoPadre.setNodoCentro(nodoDerechoNuevo);
                }
            }else{
                nodoPadre.setNodoDerecho(nodoDerechoNuevo);
                nodoPadre.setNodoTemporal(nodoIzquierdoNuevo);
                
            }
            nodoActual.setNodoPadre(null);
            splitNodo(nodoSplit, nodoIzquierdoNuevo.getNodoPadre());
            
        }
        splitNodo(nodoSplit, nodoActual.getNodoPadre());
    }
    
    public static ArrayList<Integer> ordenarDatosV2(ArrayList<Integer> valoresArray, int valores){
        int valorIzquierdo, valorMedio, valorDerecha;
            
            int a = valoresArray.get(0);
            int b = valoresArray.get(1);
            int c = valores;
            if(a > b){
                if(a>c){
                    if(b>c){
                        valorIzquierdo= c;
                        valorMedio = b;
                        valorDerecha = a;
                    }else{
                        valorIzquierdo = b;
                        valorMedio = c;
                        valorDerecha = a;
                    
                    }
                }else{
                    valorIzquierdo = b;
                    valorMedio = a;
                    valorDerecha = c;
                }
                
            }else{
                if(b>c){
                    valorIzquierdo = a;
                    valorMedio = c;
                    valorDerecha = b;
                }else{
                    valorIzquierdo = a;
                    valorMedio = b;
                    valorDerecha = c;
                }
            }
            
            ArrayList<Integer> Ordenado = new ArrayList<>();
            Ordenado.add(0,valorIzquierdo);
            Ordenado.add(1,valorMedio);
            Ordenado.add(2,valorDerecha);
            
            return Ordenado;
    }
    
    public static void ordenarDatos(int valor, Nodo nodoActual){
        if(nodoActual.getDatos().size()== 0){
            nodoActual.getDatos().add(valor);
        }else{
            if(nodoActual.getDatos().get(0)>valor){
                int tempDato = nodoActual.getDatos().get(0);
                nodoActual.getDatos().add(0,valor);
                nodoActual.getDatos().add(1,tempDato);
            
            }else{
                nodoActual.getDatos().add(1,valor);
            }
        }
    }
    
    /*
    
    int nodoSplit = valor;
            
            Nodo nodoIzq = nodoActual.getNodoAlLadoIzq();
            
            Nodo nodoCentro = new Nodo();
            nodoCentro.getDatos().add(valor);
            
            Nodo nodoPadre = nodoActual.getNodoPadre();
            
            nodoCentro.setNodoAlLadoDerecho(nodoActual);
            nodoCentro.setNodoAlLadoIzq(nodoIzq);
            
            nodoCentro.setNodoPadre(nodoPadre);
            
            nodoIzq.setNodoAlLadoDerecho(nodoCentro);
            nodoActual.setNodoAlLadoIzq(nodoIzq);
            
            
            if(nodoPadre.getNodoTemporal() == null){
                nodoPadre.setNodoCentro(nodoCentro);
                
            }else{
                nodoPadre.setNodoTemporal(nodoCentro);
            }
    
    
    */
    
    
    
}
