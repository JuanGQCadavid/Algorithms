/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesb;

import java.util.ArrayList;

/**
 *
 * @author juanu
 */
public class Nodo {
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;
    private Nodo nodoCentro;
    
    private ArrayList<Integer> datos;
    
    private Nodo nodoPadre;
    private Nodo nodoAlLadoIzq;
    private Nodo nodoAlLadoDerecho;
    
    private Nodo nodoTemporal;

    public Nodo() {
    }

    public Nodo(Nodo nodoIzquierdo, Nodo nodoDerecho, Nodo nodoCentro, ArrayList<Integer> datos, Nodo nodoPadre, Nodo nodoAlLadoIzq, Nodo nodoAlLadoDerecho, Nodo nodoTemporal) {
        this.nodoIzquierdo = nodoIzquierdo;
        this.nodoDerecho = nodoDerecho;
        this.nodoCentro = nodoCentro;
        this.datos = datos;
        this.nodoPadre = nodoPadre;
        this.nodoAlLadoIzq = nodoAlLadoIzq;
        this.nodoAlLadoDerecho = nodoAlLadoDerecho;
        this.nodoTemporal = nodoTemporal;
    }

    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public Nodo getNodoCentro() {
        return nodoCentro;
    }

    public void setNodoCentro(Nodo nodoCentro) {
        this.nodoCentro = nodoCentro;
    }

    public ArrayList<Integer> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Integer> datos) {
        this.datos = datos;
    }

    public Nodo getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(Nodo nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public Nodo getNodoAlLadoIzq() {
        return nodoAlLadoIzq;
    }

    public void setNodoAlLadoIzq(Nodo nodoAlLadoIzq) {
        this.nodoAlLadoIzq = nodoAlLadoIzq;
    }

    public Nodo getNodoAlLadoDerecho() {
        return nodoAlLadoDerecho;
    }

    public void setNodoAlLadoDerecho(Nodo nodoAlLadoDerecho) {
        this.nodoAlLadoDerecho = nodoAlLadoDerecho;
    }

    public Nodo getNodoTemporal() {
        return nodoTemporal;
    }

    public void setNodoTemporal(Nodo nodoTemporal) {
        this.nodoTemporal = nodoTemporal;
    }
    
}
