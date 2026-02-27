package main.java.dosw.bitacora.semana3.SOLIDPatrones2.Ejercicio10Iterator;

public class Main {
    public static void main(String[] args) {
        RomeTour tour = new RomeTour();

        // Agregamos los lugares del ejercicio
        tour.addPlace(new Place("Coliseo"));
        tour.addPlace(new Place("Foro Romano"));
        tour.addPlace(new Place("Fontana di Trevi"));
        tour.addPlace(new Place("Panteón"));
        tour.addPlace(new Place("Plaza de España"));

        // Obtenemos el iterador
        Iterator<Place> iterator = tour.createIterator();

        System.out.println("--- Recorrido Turístico por Roma ---");
        while (iterator.hasNext()) {
            Place place = iterator.next();
            System.out.println("Visitando: " + place.getName());
        }
    }
}