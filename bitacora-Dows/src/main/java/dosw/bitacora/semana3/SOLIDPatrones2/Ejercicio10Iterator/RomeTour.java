package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio10Iterator;

import java.util.ArrayList;
import java.util.List;

public class RomeTour implements Aggregate<Place> {
    private List<Place> places = new ArrayList<>();

    public void addPlace(Place place) {
        places.add(place);
    }

    @Override
    public Iterator<Place> createIterator() {
        return new RomeIterator();
    }

    // Clase interna que implementa el iterador
    private class RomeIterator implements Iterator<Place> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < places.size();
        }

        @Override
        public Place next() {
            if (this.hasNext()) {
                return places.get(position++);
            }
            return null;
        }
    }
}
