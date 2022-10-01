public class Fraction {
    private static int numerateur;
    private static int denominateur;

    public Fraction(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
//        simplifierFraction();
    }

//    public static int trouverPGCD(int numerateur, int denominateur){
//        int resultat = 0;
//
//        while (denominateur != 0){
//            resultat = denominateur;
//            denominateur = numerateur % denominateur;
//            numerateur = resultat;
//        }
//        return resultat;
//    }
    public static int pgcd( int a, int b ){
        int resultat = 0;

        if( 0 != a || 0 != b ){
            a = Math.abs( a );
            b = Math.abs( b );

            while( b != 0 ) {
                int temp = a % b;

                a = b;
                b = temp;
            }

            resultat = a;
        }

        return resultat;
    }


    // mm denom
    public static void simplifierFraction(){

        numerateur = numerateur ;
//        denominateur = pgcd;
//        System.out.println(pgcd);
    }

    public static Fraction additionnerFraction(Fraction laFraction){
        int num;
        int denom;
        System.out.println(numerateur);
        System.out.println(laFraction.getNumerateur());
        int pgcd = pgcd(numerateur,denominateur);
        Fraction fractionAdditionnee = null;
        System.out.println(numerateur);


       Fraction temp = new Fraction(laFraction.getNumerateur()*pgcd,laFraction.getDenominateur()*pgcd);
        if (denominateur == temp.getDenominateur()) {
//            System.out.println(numerateur);
            fractionAdditionnee = new Fraction(numerateur + temp.getNumerateur(), denominateur);
        }

//        Fraction fractionAdditionee = null;
//
//        if (denominateur == laFraction.getDenominateur()){
//            fractionAdditionee = new Fraction(numerateur + laFraction.getNumerateur(), denominateur);
//        }else {
//            simplifierFraction();
////            num = numerateur * laFraction.getNumerateur();
////            denom = denominateur * laFraction.getDenominateur();
//
//        }
       // simplifierFraction();

        return fractionAdditionnee;
    }

    public int getNumerateur() {
        return numerateur;
    }

    public void setNumerateur(int numerateur) {
        this.numerateur = numerateur;
    }

    public int getDenominateur() {
        return denominateur;
    }

    public void setDenominateur(int denominateur) {
        this.denominateur = denominateur;
    }
}
