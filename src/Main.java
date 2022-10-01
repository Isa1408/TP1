public class Main {
    public static void main(String[] args) {
        //ManipulerFichiers.lireFichier();
        //Specs.nbrTemps();
        //ManipulerChar.charValides();
        Fraction fraction = new Fraction(5, 3);
        Fraction fraction2 = new Fraction(4, 6);
        //System.out.println(fraction2.additionnerFraction(fraction));
        Fraction fraction3 = fraction2.additionnerFraction(fraction);
        System.out.println(fraction3.getNumerateur());
        System.out.println(fraction3.getDenominateur());





    }
}
