package es.uam.ads.p5;

import java.util.ArrayList;
import java.util.List;

public class BasicSimulator {

    private Entorno entorno;
    int time = 0;


    public BasicSimulator(int nRow, int nCol) {
        this.entorno = new Entorno(nRow,nCol);
    }


    public void create(IBasicAgent agente, int numAgentes, int row, int col){
        List<IBasicAgent> listaAgentes = new ArrayList<>();
        int i;
        for(i = 0; i < numAgentes ; i++){
            listaAgentes.add(agente.copy());
        }
        Cell celda = new Cell(row,col,listaAgentes,this);
        try {
            entorno.addElement(celda);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }



    public void run(int pasos){
        int i;

        for(i = 0; i<pasos ; i++){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Time = "+time);
            System.out.println(entorno);
            time ++;
        }
    }
}
