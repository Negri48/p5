package es.uam.ads.p5.Agentes;

import es.uam.ads.p5.Matrices.IMatrixElement;
import es.uam.ads.p5.Matrices.IllegalPositionException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Agent extends BasicAgent implements IAgent {

    // Lista de comportamientos
    private List<Behaviour> listaComportamientos = new ArrayList<>();

    // Celda de desplazamiento
    private Cell nuevaCelda;

    /**
     * Constructor de la clase
     * @param nombre String que indica el nombre del Agente
     */
    public Agent(String nombre) {
        super(nombre);
    }

    /**
     * Funcion que mueve un agente a otra celda
     * @param destination Cell nueva celda
     */
    @Override
    public void moveTo(Cell destination) {
        int i = this.cell().getI();
        int j = this.cell().getI();
        List<IMatrixElement<List<IBasicAgent>>> celdas;
        nuevaCelda = this.cell();
        try {
            celdas = this.cell().simulador.getEntorno().getNeighboursAt(i,j);
            if(celdas.contains(destination)) {
                nuevaCelda = destination;
            }
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    /**
     * Getter de la lista de comportamientos
     * @return Dicha lista
     */
    public List<Behaviour> getListaComportamientos() {
        return listaComportamientos;
    }


    /**
     * Funcion que ejecuta los comportamientos, en funcion de si
     * se cumple la condicion o no
     */
    @Override
    public void exec() {
        for (Behaviour b : listaComportamientos) {
            if(b.trigger.test(this)) {
                if(b.behaviour.apply(this)) {
                    celda.getElement().remove(this);
                    celda = nuevaCelda;
                    celda.getElement().add(this);
                    return;
                }
            }
        }
    }


    /**
     * Añade un comportamiento con una condicion
     * @param trigger Condicion
     * @param behaviour Comportamiento
     * @return Agente con nuevo comportamiento
     */
    @Override
    public IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour) {
        listaComportamientos.add(new Behaviour(trigger,behaviour));
        return this;
    }


    /**
     * Añade un comportamiento que se realiza siempre
     * @param behaviour Comportamiento
     * @return Agente con nuevo comportamiento
     */
    @Override
    public IAgent addBehaviour(Function<IAgent, Boolean> behaviour) {
        addBehaviour(x->true,behaviour);
        return this;
    }


    /**
     * Funcion que realiza una copia de un agente
     * @return Agente copiado
     */
    @Override
    public IAgent copy() {
        Agent copia = new Agent(getNombre());
        copia.celda = celda;
        copia.listaComportamientos = listaComportamientos;
        return copia;
    }
}
