package es.uam.ads.p5;


public class MatrixElement<T> implements IMatrixElement<T> {

    private int i;
    private int j;
    private T element;


    public MatrixElement(int i, int j, T element) {
        this.i = i;
        this.j = j;
        this.element = element;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public String toString() {
        return "La coordenada i es: " + i + ". La coordenada j es: " + j + ". El elemento es: " + element+"\n";
    }


}
