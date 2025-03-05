/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tree;

/**
 *
 * @author German
 */
public class Tree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Crear un nuevo árbol binario
        ArbolBinario arbol = new ArbolBinario();

        // Insertar valores en el árbol
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            arbol.insertar(valor);
        }

        // Realizar los diferentes recorridos
        System.out.println("Demostrando los diferentes recorridos del árbol binario:");
        arbol.recorridoPreorden();
        arbol.recorridoInorden();
        arbol.recorridoPosorden();

        // Demostrar búsqueda de valores
        System.out.println("\nDemostrando búsqueda de valores:");
        int[] valoresBuscar = {40, 90, 50, 100};
        for (int valor : valoresBuscar) {
            System.out.println("¿Existe el valor " + valor + "? " + arbol.buscar(valor));
        }

        // Mostrar altura del árbol
        System.out.println("\nAltura del árbol: " + arbol.obtenerAltura());
    }
    
}
