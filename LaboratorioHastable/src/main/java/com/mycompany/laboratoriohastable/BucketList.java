/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratoriohastable;

/**
 *
 * @author victo
 */
public class BucketList {

    private Bucket cabeza;
    private Bucket cola;

    public BucketList() { // Constructor de la clase NodoListaHorizontal
        this.cabeza = this.cola = null; // Inicializa cabeza y cola como nulos
    }

    public void insertarEnBucket(int dato, int tamanio) {
        int numeroBucket = 0;
        numeroBucket = dato % tamanio;
        Bucket actual = cabeza; // Crea un nodo auxiliar y lo inicializa con la cabeza
        if (actual.getIndice() == numeroBucket) {
            actual.getListaEnlazada().insertarEnHorizontal(new NodoX(dato));
        }
        while (actual != null) { // Mientras no lleguemos al final de la lista
            if (actual.getIndice() == numeroBucket) {
                actual.getListaEnlazada().insertarEnHorizontal(new NodoX(dato));
                break;
            }
            actual = actual.getAbajo(); // Avanza al siguiente nodo
        }
    }

    public void insertarEnVertical(Bucket nodoVertical) { // Método para insertar un nodo en la lista vertical
        //si la cabeza esta vacia entonces podemos asignar un nuevo elemento
        if (cabeza == null) { // Verifica si la cabeza está vacía
            this.cabeza = this.cola = nodoVertical; // Asigna el nuevo nodo como cabeza y cola
            //cocmo vamos aumentando segun se van ingresando al principio estaran los menores y de ultimo los mayores
        } else { // Si la cabeza no está vacía
            if (nodoVertical.getIndice() < cabeza.getIndice()) { // Verifica si el nuevo nodo tiene un valor menor que el de la cabeza
                cabeza = insertarInicio(nodoVertical); // Inserta el nuevo nodo al inicio de la lista
            } else if (nodoVertical.getIndice() > cola.getIndice()) { // Verifica si el nuevo nodo tiene un valor mayor que el de la cola
                cola = insertarFinal(nodoVertical); // Inserta el nuevo nodo al final de la lista
            } else { // Si el nuevo nodo tiene un valor entre la cabeza y la cola
                insertarEnMedio(nodoVertical); // Inserta el nuevo nodo en medio de la lista
            }

        }

    }

    //aqui los valores se van empujando de izquierda a derecha hasta llegar a null
    // 1 <- 2 <- null
    private Bucket insertarInicio(Bucket nodoVertical) { // Método para insertar un nodo al inicio de la lista
        Bucket nuevoNodo = nodoVertical; // Crea un nuevo nodo
        nuevoNodo.setAbajo(cabeza); // Establece el enlace hacia la cabeza
        if (cabeza != null) { // Verifica si la cabeza no es nula
            cabeza.setArriba(nuevoNodo); // Establece el enlace hacia el nuevo nodo
        }
        cabeza = nuevoNodo; // El nuevo nodo se convierte en la cabeza
        return cabeza; // Devuelve la cabeza

    }
//aqui los valores se van empujando de derecha a izquierda inicando con null

    //aqui los valores se van empujando de derecha a izquierda inicando con null
    // nuull -> 2 -> 1 
    private Bucket insertarFinal(Bucket nodoVertical) { // Método para insertar un nodo al final de la lista
        Bucket nuevoNodo = nodoVertical; // Crea un nuevo nodo
        if (cabeza == null) { // Si la cabeza es nula
            return nuevoNodo; // Retorna el nuevo nodo
        }
        Bucket actual = cabeza; // Crea un nodo auxiliar y lo inicializa con la cabeza
        while (actual.getAbajo() != null) { // Mientras no lleguemos al final de la lista
            actual = actual.getAbajo(); // Avanza al siguiente nodo
        }
        actual.setAbajo(nuevoNodo); // Establece el nuevo nodo como el siguiente del último
        nuevoNodo.setArriba(actual); // El nodo anterior al nuevo nodo será el último
        cola = nuevoNodo; // El nuevo nodo se convierte en la cola
        return cola; // Retorna la cabeza
    }

    private Bucket insertarEnMedio(Bucket nodoVertical) { // Método para insertar un nodo en medio de la lista
        Bucket actual = cabeza; // Crea un nodo auxiliar y lo inicializa con la cabeza

        while (actual != null && nodoVertical.getIndice() > actual.getIndice()) { // Mientras no lleguemos al final y la posición del nodo actual sea menor que la del nuevo nodo
            actual = actual.getAbajo(); // Avanza al siguiente nodo
        }

        if (actual == null) { // Si llegamos al final de la lista
            System.out.println("El valor después del cual se desea insertar no se encontró en la lista."); // Muestra un mensaje de error
            return cabeza; // Retorna la cabeza
        }

        Bucket anterior = actual.getArriba(); // Crea un nodo auxiliar que apunta al nodo anterior al actual
        nodoVertical.setAbajo(actual); // Establece el nodo siguiente al nuevo nodo como el nodo actual
        nodoVertical.setArriba(anterior); // Establece el nodo anterior al nuevo nodo como el nodo actual
        actual.setArriba(nodoVertical); // Establece el nodo actual como el nodo anterior al nuevo nodo
        if (anterior != null) { // Si el nodo anterior no es nulo
            anterior.setAbajo(nodoVertical); // Establece el nodo siguiente al nodo anterior como el nuevo nodo
        } else { // Si el nodo anterior es nulo, el nuevo nodo se convierte en la cabeza
            cabeza = nodoVertical;
        }
        return cabeza; // Retorna la cabeza
    }

    public void mostrarLista() { // Método para mostrar la lista vertical
        Bucket actual = cabeza; // Crea un nodo auxiliar y lo inicializa con la cabeza
        while (actual != null) { // Mientras no lleguemos al final de la lista
            System.out.print("|" + actual.getIndice() + "|"); // Imprime el valor del nodo actual
            actual.getListaEnlazada().mostrarLista();
            System.out.println();
            actual = actual.getAbajo(); // Avanza al siguiente nodo
        }
    }
}
