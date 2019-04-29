package es.uam.ads.p5;

import java.util.*;

public class Matrix<T> implements IMatrix<T> {

    //JUnit
    Map<Integer, Map<Integer, IMatrixElement<T>>> matriz = new HashMap<>();
    private int nCols;
    private int nRows;


    public Matrix(int nRows, int nCols) {
        this.nCols = nCols;
        this.nRows = nRows;
    }

    public int getRows() {
        return nRows;
    }

    public int getCols() {
        return nCols;
    }

    public Comparator<IMatrixElement<T>> getRowComparator(){
        return rowsComparator;
    }

    public Comparator<IMatrixElement<T>> getColComparator(){
        return colsComparator;
    }

    Comparator<IMatrixElement<T>> colsComparator = new Comparator<>() {

        @Override
        public int compare(IMatrixElement<T> o1, IMatrixElement<T> o2) {
            if (o1.getJ() == o2.getJ()) {
                return (o1.getI() - o2.getI());
            }
            return (o1.getJ() - o2.getJ());
        }
    };

    Comparator<IMatrixElement<T>> rowsComparator = new Comparator<>(){

        @Override
        public int compare(IMatrixElement<T> o1, IMatrixElement<T> o2) {
            if(o1.getI() == o2.getI()){
                return (o1.getJ()-o2.getJ());
            }
            return  (o1.getI() - o2.getI());
        }
    };


    public boolean isLegalPosition(int i, int j) {
        if (i >= nRows || j >= nCols) {
            return false;
        }
        return true;
    }

    public void addElement(IMatrixElement<T> element) throws IllegalPositionException {
        int i, j;

        i = element.getI();
        j = element.getJ();


        if (isLegalPosition(i, j) == false) {
            throw new IllegalPositionException();
        }

        HashMap<Integer, IMatrixElement<T>> columna = new HashMap<>();

        if (matriz.get(i) != null) {
            if (matriz.get(i).get(j) != null) {
                matriz.get(i).get(j).setElement((T) element.getElement());
            } else {
                matriz.get(i).put(j, element);
            }
        } else {
            columna.put(j, element);
            matriz.put(i, columna);
        }

        return;
    }

    public IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException {

        if (isLegalPosition(i, j) == false) {
            throw new IllegalPositionException();
        } else {
            if (matriz.get(i) != null) {
                if (matriz.get(i).get(j) != null) {
                    return matriz.get(i).get(j);
                }
            }
        }
        return null;
    }


    public List<IMatrixElement<T>> getNeighboursAt ( int i, int j) throws IllegalPositionException {
        if (isLegalPosition(i, j) == false) {
            throw new IllegalPositionException();
        } else {
            return List.of(getElementAt(i - 1, j), getElementAt(i + 1, j), getElementAt(i, j + 1), getElementAt(i, j - 1));
        }
    }

    public List<IMatrixElement<T>> asList () {
        List<IMatrixElement<T>> lista = new ArrayList<>();

        for (Integer i : matriz.keySet()) {
            for (Integer j : matriz.get(i).keySet()) {
                lista.add(matriz.get(i).get(j));
            }
        }
        return lista;
    }


    @Override
    public List<IMatrixElement<T>> asListSortedBy(Comparator <IMatrixElement<T>> c) {

        List<IMatrixElement<T>> lista = asList();
        Collections.sort(lista, c);
        return lista;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix = (Matrix<?>) o;
        return nCols == matrix.nCols && nRows == matrix.nRows && matriz.equals(matrix.matriz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriz, nCols, nRows);
    }



}
