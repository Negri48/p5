package es.uam.ads.p5.Simuladores;

import es.uam.ads.p5.Agentes.Agent;
import es.uam.ads.p5.Agentes.BasicAgent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Clase Simulator, implementa la funcionalidad del ejercicio 4
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public class Simulator extends BasicSimulator {

    // Agentes
    protected List<BasicAgent> agentes = new ArrayList<>();

    /**
     * Constructor de BasicSimulator
     *
     * @param nRow numero de filas
     * @param nCol numero de columnas
     */
    public Simulator(int nRow, int nCol) {
        super(nRow, nCol);
    }

    /**
     * Actualiza la lista de agentes
     * @param agentes Añade los agentes
     */
    public void actualizar(List<BasicAgent> agentes) {
        agentes.addAll(agentes);
    }

    /**
     * Funcion que realiza la simulacion
     * @param pasos numero de pasos que se realizan
     */
    @Override
    public void run(int pasos) {
        int i;

        for(i = 0; i < pasos ; i++) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = "+time);
            System.out.println(getEntorno());
            time ++;
            Collections.shuffle(agentes);

            for (BasicAgent a : agentes) {
                ((Agent)a).exec();
            }
        }
    }
}
