package main.java.dosw.bitacora.semana2.SOLIDPatrones.Ejercicio4;

public class MainSolid {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Probamos Suma
        double resSuma = calc.ejecutarOperacion(new Suma(), 10.5, 5.5);
        System.out.println("Suma: " + resSuma);

        // Probamos División
        try {
            double resDiv = calc.ejecutarOperacion(new Division(), 20, 2);
            System.out.println("División: " + resDiv);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
}
