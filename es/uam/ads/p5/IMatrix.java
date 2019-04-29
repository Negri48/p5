package es.uam.ads.p5;

import java.util.Comparator;
import java.util.List;

/**
 * Interfaz IMatrix
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public interface IMatrix<T> {

    int getCols();
    int getRows();
    Comparator<IMatrixElement<T>> getRowComparator();
    Comparator<IMatrixElement<T>> getColComparator();
    boolean isLegalPosition(int i, int j);
    void addElement(IMatrixElement<T> element) throws IllegalPositionException;
    IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException;
    List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException;
    List<IMatrixElement<T>> asList();
    List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c);

}