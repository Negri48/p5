package es.uam.ads.p5;

public class Entorno extends Matrix<Cell> {

    public Entorno(int nRows, int nCols) {
        super(nRows, nCols);
    }

    public String toString() {
        int row,col;


        for(row = 0 ; row<this.getRows() ; row++){
            for(col = 0 ; col<this.getCols() ; col++){
                try {
                    if(this.getElementAt(row,col) == null){
                        System.out.println("0|  ");
                    }
                    else {
                        System.out.println(this.getElementAt(row,col).getElement().size()+"|  ");
                    }
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n");
        }
        return null;
    }
}
