package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
            System.out.println("Вычисление окончено");
        } catch (NegativeRadiusException negativeRadiusException) {
            System.out.println("Не удалось посчитать площадь");
            System.out.println("Вычисление окончено");
        }
    }
}
// END
