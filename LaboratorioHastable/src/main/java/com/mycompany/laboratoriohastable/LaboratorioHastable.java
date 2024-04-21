/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratoriohastable;

/**
 *
 * @author victo
 */
import java.util.*;

public class LaboratorioHastable {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tamanio = 0;
        int contador = 0;
        int dato = 0;
        String continuar = "";
        BucketList bucketList = new BucketList();

        System.out.println("De qué tamaño desea el bucket list? ");
        tamanio = entrada.nextInt();

        while (contador < tamanio) {
            contador++;
            bucketList.insertarEnVertical(new Bucket(contador));
        }

        do {
            System.out.println("Ingrese un dato para el hash table ");
            dato = entrada.nextInt();
            bucketList.insertarEnBucket(dato, tamanio);
            bucketList.mostrarLista();
            System.out.println("¿Desea ingresar otro dato? [s/N]");
            continuar = entrada.next(); // Actualiza la variable continuar
        } while (!continuar.equalsIgnoreCase("n"));
    }
}
