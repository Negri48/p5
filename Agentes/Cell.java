package es.uam.ads.p5.Agentes;

import es.uam.ads.p5.Simuladores.BasicSimulator;
import es.uam.ads.p5.Matrices.IMatrixElement;
import es.uam.ads.p5.Matrices.IllegalPositionException;
import es.uam.ads.p5.Matrices.MatrixElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cell
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public class Cell extends MatrixElement<List<IBasicAgent>> {

    // Simulador
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

    /**
     * Funcion que devuelve las celdas vecinas a la dada
     * @return Lista de Celdas
     * @throws IllegalPositionException No es valida la posicion
     */
    public List<Cell> neighbours() throws IllegalPositionException {
        List<IMatrixElement<List<IBasicAgent>>> vecinos;
        List<Cell> celdas = new ArrayList<>();

        vecinos = simulador.getEntorno().getNeighboursAt(getI(),getJ());
        for (IMatrixElement l : vecinos) {
            celdas.add(new Cell(l.getI(),l.getJ(),(List<IBasicAgent>) l.getElement(),simulador));
        }
        return celdas;

    }

    /**
     * Devuelve los elementos de la lista
     * @return IBasicAgent
     */
    public List<IBasicAgent> agents(){
        return getElement();
    }

    /**
     * Añade la coleccion recibida
     * @param l Coleccion a añadir
     */
    public void addAgents(List<IBasicAgent> l){
        getElement().addAll(l);
    }
}
