import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ergebnis;
        boolean weiterRechnen = true;

        while (weiterRechnen) {
            System.out.println("********************************************");
            System.out.println("Wähle aus folgenden Rechenoperationen aus: ");
            System.out.println("(+), (-), (*), (/), (MwSt19), (MwSt7), (Rabatt)");
            System.out.println("********************************************");
            String eingabe = scanner.next();

            if (eingabe.equals("MwSt19") || eingabe.equals("MwSt7")) {
                // Mehrwertsteuer Berechnung
                System.out.println("Gib den Nettobetrag ein: ");
                double netAmount = scanner.nextDouble();
                double steuerbetrag, gesamtbetrag;
                if (eingabe.equals("MwSt19")) {
                    steuerbetrag = Calculator.calculateMwst19(netAmount);
                } else {
                    steuerbetrag = Calculator.calculateMwst7(netAmount);
                }
                gesamtbetrag = netAmount + steuerbetrag;

                System.out.println("Die Mehrwertsteuer beträgt: " + steuerbetrag);
                System.out.println("Der Gesamtbetrag (inkl. Mehrwertsteuer) beträgt: " + gesamtbetrag);
            } else if (eingabe.equals("Rabatt")) {
                // Rabattberechnung
                System.out.println("Gib den Originalpreis ein: ");
                double originalPrice = scanner.nextDouble();
                System.out.println("Gib den Rabattprozentsatz ein: ");
                double discountRate = scanner.nextDouble();
                ergebnis = Calculator.calculateDiscountPrice(originalPrice, discountRate);

                System.out.println("Der rabattierte Preis beträgt: " + ergebnis);
            } else {
                // Berechnung basierend auf dem Rechenoperator
                System.out.println("Gib die erste Zahl ein: ");
                double zahl1 = scanner.nextDouble();
                System.out.println("Gib die zweite Zahl ein: ");
                double zahl2 = scanner.nextDouble();

                switch (eingabe.charAt(0)) {
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
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Ungültiger Rechenoperator!");
                        continue;
                }
                System.out.println("Das Ergebnis ist: " + ergebnis);
            }


            // Möchte der Benutzer weiterrechnen?
            System.out.println("Möchtest du weiterrechnen? (ja/nein)");
            String antwort = scanner.next();
            if (antwort.equalsIgnoreCase("nein")) {
                weiterRechnen = false;
            }
        }

        System.out.println("Programm beendet.");
        scanner.close();
    }
}
