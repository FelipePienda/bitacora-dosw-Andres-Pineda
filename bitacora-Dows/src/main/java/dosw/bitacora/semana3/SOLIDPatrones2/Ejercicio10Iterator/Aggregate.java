package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio10Iterator;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}
