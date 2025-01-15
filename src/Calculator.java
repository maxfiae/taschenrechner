/**
 *     Die Calculator-Klasse bietet grundlegende Rechenoperationen und kaufmännische Berechnungen.
 *
 *     Funktionen:
 *     - Addition, Subtraktion, Multiplikation, Divison
 *     - Berechnung von Brutto- und Nettobeträgen basierend auf einem Steuersatz
 *     - Rabattrechnung
 *     - Berechnung der Mehrwertsteuer (19% und 7%)
 *     - Runden von Zahlen auf zwei Dezimalstellen
 */
public class Calculator {
    /**
     * addiert zwei Zahlen
     *
     * @param a die erste Zahl
     * @param b die zweite Zahl
     * @return die Summe der beiden Zahlen
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * subtrahiert die zweite Zahl von der ersten
     *
     * @param a die erste Zahl
     * @param b die zweite Zahl
     * @return die Differenz der beiden Zahlen
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * multipliziert zwei Zahlen
     *
     * @param a die erste Zahl
     * @param b die zweite Zahl
     * @return das Produkt der beiden Zahlen
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * dividiert die erste Zahl durch die zweite
     *
     * @param a die erste Zahl
     * @param b die zweite Zahl
     * @return das Ergebnis der Division
     * @throws IllegalArgumentException wenn der Divisor 0 ist
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divison durch 0 ist nicht zulässig!");
        }
        return a / b;
    }

    /**
     * berechnet den Bruttobetrag basierend auf dem Nettobetrag und dem Steuersatz
     *
     * @param netAmount der Nettobetrag
     * @param taxRate der Steuersatz in Prozent
     * @return der Bruttobetrag gerundet auf zwei Dezimalstellen
     * @throws IllegalArgumentException wenn Nettobetrag oder Steuersatz negativ sind
     */
    public static double calculateGross(double netAmount, double taxRate) {
        if (netAmount < 0 || taxRate < 0) {
            throw new IllegalArgumentException("Nettobetrag oder Steuersatz darf nicht negativ sein!");
        }
        return roundToTwoDecimals(netAmount + (netAmount * taxRate / 100));
    }

    /**
     * berechnet den Nettobetrag basierend auf dem Bruttobetrag und dem Steuersatz
     *
     * @param grossAmount der Bruttobetrag
     * @param taxRate der Steuersatz in Prozent
     * @return der Nettobetrag gerundet auf zwei Dezimalstellen
     * @throws IllegalArgumentException wenn der Bruttobetrag oder Steuersatz negativ ist
     */
    public static double calculateNet(double grossAmount, double taxRate) {
        if (grossAmount < 0 || taxRate < 0) {
            throw new IllegalArgumentException("Bruttobetrag oder Steuersatz darf nicht negativ sein!");
        }
        return roundToTwoDecimals(grossAmount / (1 + taxRate / 100));
    }

    /**
     * berechnet den rabattierten Preis basierend auf dem Originalpreis und dem Rabattprozentsatz
     *
     * @param originalPrice der ursprüngliche Preis
     * @param discountRate der Rabattprozentsatz (zwischen 0 und 100)
     * @return der rabattierte Preis
     * @throws IllegalArgumentException wenn der Rabattprozentsatz ungültig ist
     */
    public static double calculateDiscountPrice(double originalPrice, double discountRate) {
        if (discountRate < 0 || discountRate > 100) {
            throw new IllegalArgumentException("Rabatt muss zwischen 0% und 100% liegen!");
        }
        return originalPrice - (originalPrice * discountRate / 100);
    }

    /**
     * berechnet die Mehrwertsteuer für einen Nettobetrag mit 19%
     *
     * @param netAmount der Nettobetrag
     * @return der Mehrwertsteuerbetrag gerundet auf zwei Dezimalstellen
     */
    public static double calculateMwst19(double netAmount) {
        return roundToTwoDecimals(netAmount * 0.19);
    }

    /**
     * berechnet die Mehrwertsteuer für einen Nettobetrag mit 7%
     *
     * @param netAmount der Nettobetrag
     * @return der Mehrwertsteuerbetrag gerundet auf zwei Dezimalstellen
     */
    public static double calculateMwst7(double netAmount) {
        return roundToTwoDecimals(netAmount * 0.07);
    }

    /**
     * rundet eine Zahl auf zwei Dezimalstellen, um kaufmännische Genauigkeit sicherzustellen
     *
     * @param value die Zahl, die gerundet werden soll
     * @return die Zahl gerundet auf zwei Dezimalstellen
     */
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100) / 100.0;
    }
}
