public class Main {
    public static void main(String[] args) {
        //ManipulerFichiers.lireFichier();
        //Specs.nbrTemps();
        //ManipulerChar.charValides();
        Fraction fraction = new Fraction(-32, 68);
        Fraction fraction2 = new Fraction(69, -36);
        //System.out.println(fraction2.additionnerFraction(fraction));
//        Fraction fraction3 = fraction2.additionnerFraction(fraction);
//        System.out.println(fraction3.getNumerateur());
//        System.out.println(fraction3.getDenominateur());


        Fraction fraction3 = fraction.diviserFractions(fraction2);
        System.out.println(fraction3.toString());
       // System.out.println(fraction3.getNumerateur() + "/" + fraction3.getDenominateur());

//        int test = Fraction.trouverPGCD(-4,-2);
//        System.out.println(test);







    }
}
