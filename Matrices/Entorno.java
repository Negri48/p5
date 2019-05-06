package es.uam.ads.p5.Matrices;

import es.uam.ads.p5.Agentes.IBasicAgent;

import java.util.List;

/**
 * Clase Entorno
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public class Entorno extends Matrix<List<IBasicAgent>> {

    /**
     * Constructor de Entorno
     * @param nRows numero de filas
     * @param nCols numero de columnas
     */
    public Entorno(int nRows, int nCols) {
        super(nRows, nCols);
    }

    /**
     * Imprime el entorno por pantalla
     * @return matriz pertinente
     */
    public String toString() {
        int row,col;
        String pantalla="  ";

        for (row = 0 ; row < this.getRows() ; row++) {
            for (col = 0 ; col < this.getCols() ; col++) {
                try {
                    if (this.getElementAt(row,col) == null) {
                        pantalla +="· |  ";
                    }
                    else {
                        pantalla +=String.format("%3s",this.getElementAt(row,col).getElement().size() +"|  ");
                    }
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                }
            }
            pantalla +="\n  ";

        }
        return pantalla;
    }



}
