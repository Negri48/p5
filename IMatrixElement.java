package es.uam.ads.p5;

import java.util.List;

public interface IMatrixElement<T> {
    int getI();
    int getJ();
    Object getElement();
    void setElement(T element);
    String toString();
    boolean equals(Object obj);
}