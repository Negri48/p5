package es.uam.ads.p5;

import java.util.List;

/**
 * Clase Cell
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public class Cell extends MatrixElement<List<IBasicAgent>> {

    /**
     * Simulador
     */
    BasicSimulator simulador;

    /**
     * Constructor de celda
     * @param i fila
     * @param j columna
     * @param element elemento de la celda
     * @param bs simulador
     */
    public Cell(int i, int j, List<IBasicAgent> element, BasicSimulator bs) {
        super(i, j, element);
        this.simulador = bs;
    }
}
