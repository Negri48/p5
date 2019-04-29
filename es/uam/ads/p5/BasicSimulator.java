package es.uam.ads.p5;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase BasicSimulator
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */

public class BasicSimulator {

    /**
     * Entorno del BasicAgent
     */
    private Entorno entorno;

    /**
     * Tiempo de simulacion
     */
    int time = 0;

    /**
     * Constructor de BasicSimulator
     * @param nRow numero de filas
     * @param nCol numero de columnas
     */
    public BasicSimulator(int nRow, int nCol) {
        this.entorno = new Entorno(nRow,nCol);
    }


    /**
     * Añade agentes al simulador
     * @param agente agente que se añade
     * @param numAgentes numero de agentes que contiene
     * @param row filas
     * @param col columnas
     */
    public void create(IBasicAgent agente, int numAgentes, int row, int col){
        List<IBasicAgent> listaAgentes = new ArrayList<>();
        int i;
        for(i = 0; i < numAgentes ; i++) {
            listaAgentes.add(agente.copy());
        }
        Cell celda = new Cell(row,col,listaAgentes,this);
        try {
            entorno.addElement(celda);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }


    /**
     * Ejecuta el simulador
     * @param pasos numero de pasos que se realizan
     */
    public void run(int pasos){
        int i;

        for(i = 0; i < pasos ; i++) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = "+time);
            System.out.println(entorno);
            time ++;
        }
    }
}
