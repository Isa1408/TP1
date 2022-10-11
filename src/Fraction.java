public class Fraction {
    private int numerateur;
    private int denominateur;

    public Fraction(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
        simplifier();
    }

    public static int trouverPGCD(int num, int denum){
        int lePGCD = 0;
        int mod;

        if (num != 0 || denum != 0){
            num = Math.abs(num);
            denum = Math.abs(denum);

            while (denum != 0) {
                mod = num % denum;
                num = denum;
                denum = mod;
            }
            lePGCD = num;
        }
        return lePGCD;
    }

    public void simplifier(){
        int lePGCD = trouverPGCD(numerateur, denominateur);
        numerateur = numerateur / lePGCD;
        denominateur = denominateur / lePGCD;

    }

    public Boolean estPlusGrand(Fraction autreFraction){
        boolean fractionComparee = this.numerateur * autreFraction.denominateur
                > this.denominateur * autreFraction.numerateur;
        return fractionComparee;
    }

    public Boolean estEgal(Fraction autreFraction){
        boolean fractionComparee = this.numerateur * autreFraction.denominateur
                == this.denominateur * autreFraction.numerateur;
        return fractionComparee;
    }

    public Fraction additionnerFractions(Fraction autreFraction){
        Fraction fractionsAdditionnees;
        int numerateur = 0;
        int denominateur = 0;

        numerateur = this.numerateur * autreFraction.getDenominateur() +
                autreFraction.getNumerateur() * this.denominateur;
        denominateur = this.denominateur * autreFraction.getDenominateur();
        fractionsAdditionnees = new Fraction(numerateur, denominateur);

        return fractionsAdditionnees;
    }

    public Fraction soustraireFractions(Fraction autreFraction){
        Fraction fractionsSoustraites;
        int numerateur = 0;
        int denominateur = 0;

        numerateur = this.numerateur * autreFraction.getDenominateur() -
                autreFraction.getNumerateur() * this.denominateur;
        denominateur = this.denominateur * autreFraction.getDenominateur();
        fractionsSoustraites = new Fraction(numerateur, denominateur);

        return fractionsSoustraites;
    }

    public Fraction multiplierFractions(Fraction autreFraction){
        Fraction fractionsMultipliees;
        int numerateur = 0;
        int denominateur = 0;

        numerateur = this.numerateur * autreFraction.getNumerateur();
        denominateur = this.denominateur * autreFraction.getDenominateur();
        fractionsMultipliees = new Fraction(numerateur, denominateur);

        return fractionsMultipliees;
    }

    public Fraction diviserFractions(Fraction autreFraction){
        Fraction fractionsDivisees;
        int numerateur = 0;
        int denominateur = 0;

        numerateur = this.numerateur * autreFraction.getDenominateur();
        denominateur = this.denominateur * autreFraction.getNumerateur();
        fractionsDivisees = new Fraction(numerateur, denominateur);

        return fractionsDivisees;
    }

    public int getNumerateur() {
        return numerateur;
    }

    public int getDenominateur() {
        return denominateur;
    }

    public String toString(){
        String fractionRendue = "";

        if(this.denominateur == 1 ){
            fractionRendue = this.numerateur + "";
        }else {
            fractionRendue = this.numerateur + "/" + this.denominateur;
        }
        return fractionRendue;
    }
}
