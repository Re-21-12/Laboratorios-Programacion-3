/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratoriopila;

/**
 *
 * @author victo
 */
import java.util.Stack;

public class LaboratorioPila {
//para que haya un balance debe haber la misma cantidad de parentesis de apertura que de cierre
    //para que sea una expresion matematica debe haber cocntenido dentro de los parentesis
    
    public static boolean verificarBalance(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                if (pila.isEmpty() || pila.peek() == '(') {
                    //retorna false si esta desbalanceado o no hay contenido dentro del parentesis
                    return false;
                } else {
                    pila.pop();
                }
            }
        }
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String expresion1 = "((3+4)*2)()";

        if (verificarBalance(expresion1)) {
            System.out.println("La expresión 3 está balanceada: ");
        } else {
            System.out.println("La expresión esta desbalanceada: ");
        }
    }
}
