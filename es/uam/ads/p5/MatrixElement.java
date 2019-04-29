package es.uam.ads.p5;

/**
 * Clase IMatrixElement, que implementa la Interfaz IMatrixElement
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public class MatrixElement<T> implements IMatrixElement<T> {

    /**
     * Numero de fila
     */
    private int i;

    /**
     * Numero de columna
     */
    private int j;

    /**
     * Elemento
     */
    private T element;


    /**
     * Constructor de MatrixElement
     * @param i numero de fila
     * @param j numero de columna
     * @param element Elemento de la matriz
     */
    public MatrixElement(int i, int j, T element) {
        this.i = i;
        this.j = j;
        this.element = element;
    }

    /**
     * Devuelve la fila donde se encuentra el elemento
     * @return el numero de la fila
     */

    public int getI() {
        return i;
    }

    /**
     * Devuelve la columna donde se encuentra el elemento
     * @return el numero de la columna
     */
    public int getJ() {
        return j;
    }

    /**
     * Devuelve el elemento
     * @return elemento de la matriz
     */
    public Object getElement() {
        return element;
    }

    /**
     * Sustituye el elemento que habia por uno que se pasa como argumento
     * @param element nuevo elemento que se quiere introducir en la matriz
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Imprime la informacion del elemento de la matriz
     * @return cadena de caracteres con la informacion
     */
    public String toString() {
        return "La coordenada i es: " + i + ". La coordenada j es: " + j + ". El elemento es: " + element+"\n";
    }


}
