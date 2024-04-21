/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratoriohastable;

/**
 *
 * @author victo
 */
public class NodoX {
    private int dato;
    private NodoX izquierda;
    private NodoX derecha;

    public NodoX(int dato) {
    this.dato = dato;
    this.izquierda = this.derecha = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoX getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoX izquierda) {
        this.izquierda = izquierda;
    }

    public NodoX getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoX derecha) {
        this.derecha = derecha;
    }
    
    
}
