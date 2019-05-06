package es.uam.ads.p5.Agentes;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Interfaz IAgent
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public interface IAgent extends IBasicAgent {

    void moveTo(Cell destination); // Mover a una celda adyacente
    void exec(); // Ejecutar comportamiento del agente
    IAgent addBehaviour(Predicate<IAgent> trigger, Function<IAgent, Boolean> behaviour);
    IAgent addBehaviour(Function<IAgent, Boolean> behaviour);
    IAgent copy(); // Realiza una copia del agente

}
