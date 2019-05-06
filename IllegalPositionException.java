package es.uam.ads.p5;

/**
 * Excepcion que salta si intentamos acceder a una posicion ilegal
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */

public class IllegalPositionException extends Exception {
    @Override
    public String toString() {
        return "IllegalPositionException: La nueva posicion no es valida";
    }
}
