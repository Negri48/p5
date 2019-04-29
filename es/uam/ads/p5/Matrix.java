package es.uam.ads.p5;
//MEJORARRRRRR
import java.util.*;

/**
 * Clase Matrix, que implementa la Interfaz IMatrix
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */

public class Matrix<T> implements IMatrix<T> {

    /**
     * Matriz que contiene a los elementos
     */
    Map<Integer, Map<Integer, IMatrixElement<T>>> matriz = new HashMap<>();

    /**
     * Numero de columnas
     */
    private int nCols;

    /**
     * Numero de columnas
     */
    private int nRows;


    /**
     * Constructor de Matrix
     * @param nRows numero de filas
     * @param nCols numero de columnas
     */
    public Matrix(int nRows, int nCols) {
        this.nCols = nCols;
        this.nRows = nRows;
    }

    /**
     * Devuelve el numero de filas de la matriz
     * @return numero de filas
     */
    public int getRows() {
        return nRows;
    }

    /**
     * Devuelve el numero de columnas de la matriz
     * @return numero de columnas
     */
    public int getCols() {
        return nCols;
    }

    /**
     * FALTA
     * @return
     */
    public Comparator<IMatrixElement<T>> getRowComparator() {
        return rowsComparator;
    }

    /**
     * FALTA
     * @return
     */
    public Comparator<IMatrixElement<T>> getColComparator() {
        return colsComparator;
    }

    Comparator<IMatrixElement<T>> colsComparator = new Comparator<>() {

        /**
         * FALTA
         * @param o1 elemento de la matriz
         * @param o2 otro elemento de la matriz
         * @return
         */
        @Override
        public int compare(IMatrixElement<T> o1, IMatrixElement<T> o2) {
            if (o1.getJ() == o2.getJ()) {
                return (o1.getI() - o2.getI());
            }
            return (o1.getJ() - o2.getJ());
        }
    };

    Comparator<IMatrixElement<T>> rowsComparator = new Comparator<>() {

        /**
         * FALTA
         * @param o1 elemento de la matriz
         * @param o2 otro elemento de la matriz
         * @return
         */
        @Override
        public int compare(IMatrixElement<T> o1, IMatrixElement<T> o2) {
            if(o1.getI() == o2.getI()){
                return (o1.getJ()-o2.getJ());
            }
            return  (o1.getI() - o2.getI());
        }
    };


    /**
     * Comprueba si una posicion de la matriz es legal
     * @param i numero de fila
     * @param j numero de columna
     * @return true si es legal, false en caso contrario
     */
    public boolean isLegalPosition(int i, int j) {
        if (i >= nRows || j >= nCols) {
            return false;
        }
        return true;
    }

    /**
     * Añade un elemento a la matriz
     * @param element el elemento a añadir
     * @throws IllegalPositionException excepcion que salta si la posicion es ilegal
     */
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

    /**
     * Devuelve el elemento de la posicion i,j contenido en la matriz
     * @param i numero de fila
     * @param j numero de columna
     * @return elemento en dicha posicion
     * @throws IllegalPositionException excepcion que salta si al posicion es ilegal
     */
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


    /**
     * Devuelve los vecinos de un elemento de la matriz
     * @param i numero de fila
     * @param j numero de columna
     * @return lista que contiene a los vecinos
     * @throws IllegalPositionException excepcion que salta si la posicion es ilegal
     */
    public List<IMatrixElement<T>> getNeighboursAt ( int i, int j) throws IllegalPositionException {
        if (isLegalPosition(i, j) == false) {
            throw new IllegalPositionException();
        } else {
            return List.of(getElementAt(i - 1, j), getElementAt(i + 1, j), getElementAt(i, j + 1), getElementAt(i, j - 1));
        }
    }

    /**
     * Devuelve todos los elementos no nulos de la matriz en una lista
     * @return lista con los elementos
     */
    public List<IMatrixElement<T>> asList () {
        List<IMatrixElement<T>> lista = new ArrayList<>();

        for (Integer i : matriz.keySet()) {
            for (Integer j : matriz.get(i).keySet()) {
                lista.add(matriz.get(i).get(j));
            }
        }
        return lista;
    }


    /**
     * Devuelve los elementos ordenados mediante un comparador
     * @param c comparador con el que se ordenara la lista
     * @return lista con los elementos ordenados
     */
    @Override
    public List<IMatrixElement<T>> asListSortedBy(Comparator <IMatrixElement<T>> c) {

        List<IMatrixElement<T>> lista = asList();
        Collections.sort(lista, c);
        return lista;
    }


    /**
     * FALTA
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix = (Matrix<?>) o;
        return nCols == matrix.nCols && nRows == matrix.nRows && matriz.equals(matrix.matriz);
    }

    /**
     * FALTA
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(matriz, nCols, nRows);
    }



}
