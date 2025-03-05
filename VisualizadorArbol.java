package tree;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para visualizar el árbol binario gráficamente
 */
public class VisualizadorArbol extends JPanel {
    private ArbolBinario arbol;
    private static final int RADIO_NODO = 20;
    private static final int ESPACIO_VERTICAL = 50;
    private static final int ESPACIO_HORIZONTAL = 50;

    /**
     * Constructor del visualizador
     * @param arbol Árbol binario a visualizar
     */
    public VisualizadorArbol(ArbolBinario arbol) {
        this.arbol = arbol;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dibujar el árbol comenzando desde la raíz
        dibujarArbol(g2, getWidth() / 2, 50, arbol.getRaiz(), getWidth() / 4);
    }

    /**
     * Método recursivo para dibujar el árbol
     * @param g Contexto gráfico
     * @param x Coordenada x del nodo actual
     * @param y Coordenada y del nodo actual
     * @param nodo Nodo actual a dibujar
     * @param espacioHorizontal Espacio horizontal entre nodos
     */
    private void dibujarArbol(Graphics2D g, int x, int y, Nodo nodo, int espacioHorizontal) {
        if (nodo == null) return;

        // Dibujar nodo actual
        g.setColor(Color.BLUE);
        g.fillOval(x - RADIO_NODO, y - RADIO_NODO, 2 * RADIO_NODO, 2 * RADIO_NODO);
        
        // Texto del nodo
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        String valorNodo = String.valueOf(nodo.getValor());
        FontMetrics fm = g.getFontMetrics();
        int anchoTexto = fm.stringWidth(valorNodo);
        g.drawString(valorNodo, x - anchoTexto/2, y + fm.getAscent()/2);

        // Dibujar subárbol izquierdo
        if (nodo.getIzquierdo() != null) {
            int hijoX = x - espacioHorizontal;
            int hijoY = y + ESPACIO_VERTICAL;
            
            // Dibujar línea de conexión
            g.setColor(Color.BLACK);
            g.drawLine(x, y + RADIO_NODO, hijoX, hijoY - RADIO_NODO);
            
            // Dibujar nodo hijo izquierdo
            dibujarArbol(g, hijoX, hijoY, nodo.getIzquierdo(), espacioHorizontal / 2);
        }

        // Dibujar subárbol derecho
        if (nodo.getDerecho() != null) {
            int hijoX = x + espacioHorizontal;
            int hijoY = y + ESPACIO_VERTICAL;
            
            // Dibujar línea de conexión
            g.setColor(Color.BLACK);
            g.drawLine(x, y + RADIO_NODO, hijoX, hijoY - RADIO_NODO);
            
            // Dibujar nodo hijo derecho
            dibujarArbol(g, hijoX, hijoY, nodo.getDerecho(), espacioHorizontal / 2);
        }
    }

    /**
     * Método para mostrar el árbol en una ventana
     */
    public void mostrarArbol() {
        JFrame frame = new JFrame("Visualización del Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Método getter para obtener la raíz del árbol
     * @return Nodo raíz del árbol
     */
    public Nodo getRaiz() {
        return arbol.getRaiz();
    }
}