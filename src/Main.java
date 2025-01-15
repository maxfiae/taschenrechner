import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********************************************");
        System.out.println("Wähle aus folgenden Rechenoperatoren aus: ");
        System.out.println("(+), (-), (*), (/)");
        System.out.println("********************************************");
        char rechenoperator = scanner.next().charAt(0);

        System.out.println("Gib die erste Zahl ein: ");
        double zahl1 = scanner.nextDouble();
        System.out.println("Gib die zweite Zahl ein: ");
        double zahl2 = scanner.nextDouble();

        double ergebnis;

        // Berechnung basierend auf dem Rechenoperator
        switch (rechenoperator) {
            case '+':
                ergebnis = Calculator.add(zahl1, zahl2);
                break;
            case '-':
                ergebnis = Calculator.subtract(zahl1, zahl2);
                break;
            case '*':
                ergebnis = Calculator.multiply(zahl1, zahl2);
                break;
            case '/':
                try {
                    ergebnis = Calculator.divide(zahl1, zahl2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("Ungültiger Rechenoperator!");
                scanner.close();
                return;
        }

        System.out.println("Das Ergebnis ist: " + ergebnis);
        scanner.close();
    }
}