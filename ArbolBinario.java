/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

/**
 *
 * @author German
 */
public class ArbolBinario {
     // Raíz del árbol
    private Nodo raiz;

    /**
     * Constructor por defecto
     */
    public ArbolBinario() {
        this.raiz = null;
    }

    /**
     * Método para insertar un valor en el árbol
     * @param valor Valor a insertar
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Método recursivo auxiliar para inserción
     * @param nodoActual Nodo actual en la recursión
     * @param valor Valor a insertar
     * @return Nodo actualizado
     */
    private Nodo insertarRecursivo(Nodo nodoActual, int valor) {
        // Si el árbol está vacío, crea un nuevo nodo
        if (nodoActual == null) {
            return new Nodo(valor);
        }

        // Decidir en qué subárbol insertar
        if (valor < nodoActual.getValor()) {
            nodoActual.setIzquierdo(insertarRecursivo(nodoActual.getIzquierdo(), valor));
        } else if (valor > nodoActual.getValor()) {
            nodoActual.setDerecho(insertarRecursivo(nodoActual.getDerecho(), valor));
        }

        // Retorna el nodo sin modificaciones si el valor ya existe
        return nodoActual;
    }

    /**
     * Recorrido en Preorden (Raíz - Izquierdo - Derecho)
     */
    public void recorridoPreorden() {
        System.out.println("Recorrido Preorden:");
        recorridoPreordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Método recursivo auxiliar para recorrido preorden
     * @param nodo Nodo actual
     */
    private void recorridoPreordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            // Primero visita la raíz
            System.out.print(nodo.getValor() + " ");
            
            // Luego recorre el subárbol izquierdo
            recorridoPreordenRecursivo(nodo.getIzquierdo());
            
            // Finalmente recorre el subárbol derecho
            recorridoPreordenRecursivo(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en Inorden (Izquierdo - Raíz - Derecho)
     */
    public void recorridoInorden() {
        System.out.println("Recorrido Inorden:");
        recorridoInordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Método recursivo auxiliar para recorrido inorden
     * @param nodo Nodo actual
     */
    private void recorridoInordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            // Primero recorre el subárbol izquierdo
            recorridoInordenRecursivo(nodo.getIzquierdo());
            
            // Luego visita la raíz
            System.out.print(nodo.getValor() + " ");
            
            // Finalmente recorre el subárbol derecho
            recorridoInordenRecursivo(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en Posorden (Izquierdo - Derecho - Raíz)
     */
    public void recorridoPosorden() {
        System.out.println("Recorrido Posorden:");
        recorridoPosordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Método recursivo auxiliar para recorrido posorden
     * @param nodo Nodo actual
     */
    private void recorridoPosordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            // Primero recorre el subárbol izquierdo
            recorridoPosordenRecursivo(nodo.getIzquierdo());
            
            // Luego recorre el subárbol derecho
            recorridoPosordenRecursivo(nodo.getDerecho());
            
            // Finalmente visita la raíz
            System.out.print(nodo.getValor() + " ");
        }
    }

    /**
     * Método para buscar un valor en el árbol
     * @param valor Valor a buscar
     * @return true si el valor existe, false en caso contrario
     */
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    /**
     * Método recursivo auxiliar para buscar un valor
     * @param nodo Nodo actual
     * @param valor Valor a buscar
     * @return true si el valor existe, false en caso contrario
     */
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        // Si el nodo es nulo, el valor no existe
        if (nodo == null) {
            return false;
        }

        // Si el valor es igual al nodo actual, se encontró
        if (valor == nodo.getValor()) {
            return true;
        }

        // Buscar en el subárbol izquierdo o derecho según el valor
        return valor < nodo.getValor() 
            ? buscarRecursivo(nodo.getIzquierdo(), valor)
            : buscarRecursivo(nodo.getDerecho(), valor);
    }

    /**
     * Método para obtener la altura del árbol
     * @return Altura del árbol
     */
    public int obtenerAltura() {
        return obtenerAlturaRecursivo(raiz);
    }

    /**
     * Método recursivo auxiliar para obtener la altura
     * @param nodo Nodo actual
     * @return Altura del nodo
     */
    private int obtenerAlturaRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = obtenerAlturaRecursivo(nodo.getIzquierdo());
        int alturaDerecha = obtenerAlturaRecursivo(nodo.getDerecho());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }
    
    /**
     * Método getter para obtener la raíz del árbol
     * @return Nodo raíz del árbol
     */
    public Nodo getRaiz() {
        return raiz;
    }
}
