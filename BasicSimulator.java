package es.uam.ads.p5;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase BasicSimulator
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */

public class BasicSimulator {

    // Entorno del simulador
    private Entorno entorno;

    // Tiempo de simulacion
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
    public void create(IBasicAgent agente, int numAgentes, int row, int col) throws IllegalPositionException {
        List<IBasicAgent> listaAgentes = new ArrayList<>(numAgentes);
        int i;
        for (i = 0; i < numAgentes; i++) {
            listaAgentes.add(agente.copy());
        }
        Cell celda = new Cell(row,col,listaAgentes,this);
        if (entorno.getElementAt(row,col) != null) {
            ((Cell) (entorno.getElementAt(row,col))).addAgents(listaAgentes);
        }
        else {
            entorno.addElement(celda);
        }

        actualizar(listaAgentes);
    }

    /**
     * Funcion que actualiza la lista de agentes
     * @param listaAgentes Nueva lista
     */
    private void actualizar(List<IBasicAgent> listaAgentes) {
        //Esta vacia porque en la simulacion basica no es necesaria
    }

    /**
     * Getter del entorno
     * @return Entorno
     */
    public Entorno getEntorno() {
        return entorno;
    }

    /**
     * Ejecuta el simulador
     * @param pasos numero de pasos que se realizan
     */
    public void run(int pasos) {
        int i;

        for (i = 0; i < pasos; i++) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = "+time);
            System.out.println(entorno);
            time ++;
        }
    }
}
