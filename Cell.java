package es.uam.ads.p5;

import java.util.List;

public class Cell extends MatrixElement<List<IBasicAgent>> {

    BasicSimulator simulador;


    public Cell(int i, int j, List<IBasicAgent> element, BasicSimulator bs) {
        super(i, j, element);
        this.simulador = bs;
    }
}
