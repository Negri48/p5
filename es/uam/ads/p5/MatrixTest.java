package es.uam.ads.p5;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test de los metodos de Matrix
 * @author David Quintana Ruiz, Victor Sanchez de la Roda Nuñez
 */
public class MatrixTest {

    IMatrix<String> string;
    IMatrix<Integer> integer;
    IMatrixElement<String> strElem;
    IMatrixElement<Integer> intElem;

    @Before
    public void setUp() {
        string = new Matrix<>(4,8);
        integer = new Matrix<>(6,7);
        strElem = new MatrixElement<>(1,3,"ESTOYTOPERDIO");
        intElem = new MatrixElement<>(1,3,5);
    }

    @Test
    public void getRows() {
        assertEquals(string.getRows(),4);
    }

    @Test
    public void getCols() {
        assertEquals(string.getCols(),8);
    }

    @Test
    public void isLegalPosition() {
        assertTrue(string.isLegalPosition(2,7));
        assertFalse(integer.isLegalPosition(7,4));
    }

    @Test
    public void addElement() {
        try {
            string.addElement(strElem);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a String");
        }

        try {
            integer.addElement(intElem);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a Integer");
        }


    }

    @Test
    public void getElementAt() throws IllegalPositionException {

        try {
            string.addElement(strElem);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a String");
        }
        assertEquals(string.getElementAt(1,3),strElem);
        try {
            integer.addElement(intElem);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a Integer");
        }
        assertEquals(integer.getElementAt(1,3),intElem);
    }

    @Test
    public void getNeighboursAt() {
    }

    @Test
    public void asList() {
        try {
            string.addElement(strElem);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a String");
        }
        IMatrixElement<String> strElem2 = new MatrixElement<>(2,0,"ESRT");
        try {
            string.addElement(strElem2);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a String");
        }
        List<IMatrixElement<String>> lista = string.asList();
        assertTrue(lista.size() == 2);
        assertTrue(lista.contains(strElem));
        assertTrue(lista.contains(strElem2));


    }

    @Test
    public void asListSortedBy() {
        try {
            string.addElement(strElem);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a String");
        }
        IMatrixElement<String> strElem2 = new MatrixElement<>(2,1,"ESRT");
        IMatrixElement<String> strElem3 = new MatrixElement<>(2,3,"E");
        IMatrixElement<String> strElem4 = new MatrixElement<>(3,5,"ES");
        try {
            string.addElement(strElem2);
            string.addElement(strElem3);
            string.addElement(strElem4);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a String");
        }
        List<IMatrixElement<String>> lista = string.asListSortedBy(string.getRowComparator());
        assertTrue(lista.size() == 4);
        assertEquals(lista.get(0),strElem);
        assertEquals(lista.get(1),strElem2);
        assertEquals(lista.get(2),strElem3);
        assertEquals(lista.get(3),strElem4);

        lista = string.asListSortedBy(string.getColComparator());
        assertTrue(lista.size() == 4);
        assertEquals(lista.get(0),strElem2);
        assertEquals(lista.get(1),strElem);
        assertEquals(lista.get(2),strElem3);
        assertEquals(lista.get(3),strElem4);
    }

    @Test
    public void equals1() {

        Matrix<Integer> integer2 = new Matrix<>(6,7);

        try {
            integer.addElement(intElem);
            integer2.addElement(intElem);
        } catch (IllegalPositionException e) {
            fail("La posicion no es valida, para añadir a Integer");
        }
        assertEquals(integer2,integer);
    }
}