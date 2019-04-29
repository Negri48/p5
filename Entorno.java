package es.uam.ads.p5;

import java.util.List;

public class Entorno extends Matrix<List<IBasicAgent>> {

    public Entorno(int nRows, int nCols) {
        super(nRows, nCols);
    }

    public String toString() {
        int row,col;
        String pantalla="  ";

        for(row = 0 ; row<this.getRows() ; row++){
            for(col = 0 ; col<this.getCols() ; col++){
                try {
                    if(this.getElementAt(row,col) == null){
                        pantalla +="0|  ";
                    }
                    else {
                        pantalla +=this.getElementAt(row,col).getElement().size() "| ";
                    }
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                }
            }
            pantalla +="\n  ";

            /*Decision de diseño de no usar system pq nos imprime \n de mas*/
        }
        return pantalla;
    }
}
