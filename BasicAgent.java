package es.uam.ads.p5;

public class BasicAgent implements IBasicAgent {

    private Cell celda;
    private String nombre;


    public BasicAgent(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Cell cell() {
        return celda;
    }

    @Override
    public IBasicAgent copy() {
        BasicAgent copia = new BasicAgent(nombre);
        copia.celda = this.celda;
        return copia;
    }
}
