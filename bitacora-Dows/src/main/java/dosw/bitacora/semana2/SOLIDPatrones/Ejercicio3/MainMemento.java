package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio3;

public class MainMemento {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Historial historial = new Historial();

        // El usuario escribe algo y lo guarda
        editor.escribir("Primera versión del texto.");
        historial.guardarEstado(editor.guardar());
        System.out.println("Actual: " + editor.getContenido());

        //  El usuario cambia el texto y lo vuelve a guardar
        editor.escribir("Segunda versión con más ideas.");
        historial.guardarEstado(editor.guardar());
        System.out.println("Actual: " + editor.getContenido());

        //  El usuario comete un error
        editor.escribir("Texto borrado por error!");
        System.out.println("Error: " + editor.getContenido());

        //  DESHACER Undo
        // Sacamos el último estado guardado (Segunda versión)
        editor.restaurar(historial.deshacer());
        System.out.println("Después de deshacer 1 vez: " + editor.getContenido());

        // Deshacer otra vez
        editor.restaurar(historial.deshacer());
        System.out.println("Después de deshacer 2 veces: " + editor.getContenido());
    }
}
