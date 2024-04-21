/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratoriohastable;

/**
 *
 * @author victo
 */
public class Bucket {
    private int indice;
    private Bucket arriba;
    private Bucket abajo;
    private NodoListX listaEnlazada;

    public Bucket(int indice) {
        this.indice = indice;
        this.arriba = this.abajo ;
        this.listaEnlazada = new NodoListX();
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Bucket getArriba() {
        return arriba;
    }

    public void setArriba(Bucket arriba) {
        this.arriba = arriba;
    }

    public Bucket getAbajo() {
        return abajo;
    }

    public void setAbajo(Bucket abajo) {
        this.abajo = abajo;
    }

    public NodoListX getListaEnlazada() {
        return listaEnlazada;
    }

    public void setListaEnlazada(NodoListX listaEnlazada) {
        this.listaEnlazada = listaEnlazada;
    }
    
    
    
}
