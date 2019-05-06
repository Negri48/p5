package es.uam.ads.p5;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Clase Behaviour, implementa el comportamiento de los agentes
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public class Behaviour {

    // Condicion
    protected Predicate<IAgent> trigger;

    // Comportamiento
    protected Function<IAgent,Boolean> behaviour;


    /**
     * Constructor de la clase
     * @param trigger Condicion
     * @param behaviour Comportamiento
     */
    public Behaviour (Predicate<IAgent> trigger,Function<IAgent,Boolean> behaviour) {
        this.trigger = trigger;
        this.behaviour = behaviour;
    }



}
