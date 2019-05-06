package es.uam.ads.p5.Matrices;

/**
 * Interfaz IMatrixElement
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */

public interface IMatrixElement<T> {
    int getI();
    int getJ();
    T getElement();
    void setElement(T element);
    String toString();
    boolean equals(Object obj);
}