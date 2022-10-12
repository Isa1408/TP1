/**
 * Représente la classe qui construit et manipule des fractions.
 * @Author Bruno Malenfant
 * @Author Isabelle Tamas
 */
public class Fraction {
    private int numerateur;
    private int denominateur;

    /**
     * Constructeur d'une <code>Fraction</code>
     * @param numerateur le numérateur de la <code>Fraction</code>
     * @param denominateur le dénominateur de la <code>Fraction</code>
     */
    public Fraction(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
        simplifier();
    }

    /**
     * Calcule le plus grand commun diviseur entre deux valeurs entiere.
     * @Author Bruno Malenfant
     * @param num le numérateur de la <code>Fraction</code>
     * @param denum le dénominateur de la <code>Fraction</code>
     * @return le pgcd entre les deux valeurs
     */
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

    /**
     * Méthode qui permet de simplifier une <code>Fraction</code>.
     */
    public void simplifier(){
        int lePGCD = trouverPGCD(numerateur, denominateur);
        numerateur = numerateur / lePGCD;
        denominateur = denominateur / lePGCD;

    }

    /**
     * Détermine si la <code>Fraction</code> est plus grande qu'une autre
     * <code>Fraction</code> (<code>this</code> et
     *      * <code>autreFraction</code>).
     * @param autreFraction une autre <code>Fraction</code>
     * @return true si la <code>Fraction</code> est plus grande que celle
     * donnée en paramètre.
     */
    public Boolean estPlusGrand(Fraction autreFraction){
        boolean fractionComparee = this.numerateur * autreFraction.denominateur
                > this.denominateur * autreFraction.numerateur;
        return fractionComparee;
    }

    /**
     * Détermine si la <code>Fraction</code> est égale à une autre
     * <code>Fraction</code> (<code>this</code> et
     *      * <code>autreFraction</code>).
     * @param autreFraction une autre <code>Fraction</code>
     * @return true si la <code>Fraction</code> est égale à la
     * <code>Fraction</code> donnée en paramètre.
     */
    public Boolean estEgal(Fraction autreFraction){
        boolean fractionComparee = this.numerateur * autreFraction.denominateur
                == this.denominateur * autreFraction.numerateur;
        return fractionComparee;
    }

    /**
     * Additionne deux <code>Fraction</code>s (<code>this</code> et
     *      * <code>autreFraction</code>).
     * @param autreFraction une autre <code>Fraction</code>
     * @return les <code>Fraction</code>s addionnées
     */
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

    /**
     * Soustrait deux <code>Fraction</code>s (<code>this</code> et
     *      * <code>autreFraction</code>).
     * @param autreFraction une autre <code>Fraction</code>
     * @return les <code>Fraction</code>s soustraitent
     */
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

    /**
     * Multiplie deux <code>Fraction</code>s (<code>this</code> et
     *      * <code>autreFraction</code>).
     * @param autreFraction une autre <code>Fraction</code>
     * @return les <code>Fraction</code>s multipliées
     */
    public Fraction multiplierFractions(Fraction autreFraction){
        Fraction fractionsMultipliees;
        int numerateur = 0;
        int denominateur = 0;

        numerateur = this.numerateur * autreFraction.getNumerateur();
        denominateur = this.denominateur * autreFraction.getDenominateur();
        fractionsMultipliees = new Fraction(numerateur, denominateur);

        return fractionsMultipliees;
    }

    /**
     * Divise deux <code>Fraction</code>s (<code>this</code> et
     * <code>autreFraction</code>).
     * @param autreFraction une autre <code>Fraction</code>
     * @return les <code>Fraction</code>s divisées
     */
    public Fraction diviserFractions(Fraction autreFraction){
        Fraction fractionsDivisees;
        int numerateur = 0;
        int denominateur = 0;

        numerateur = this.numerateur * autreFraction.getDenominateur();
        denominateur = this.denominateur * autreFraction.getNumerateur();
        fractionsDivisees = new Fraction(numerateur, denominateur);

        return fractionsDivisees;
    }

    /**
     * Getter du numérateur de la <code>Fraction</code>.
     * @return le numérateur
     */
    public int getNumerateur() {
        return numerateur;
    }

    /**
     * Getter du dénominateur de la <code>Fraction</code>.
     * @return le dénominateur
     */
    public int getDenominateur() {
        return denominateur;
    }

    /**
     * Permet d'afficher une <code>Fraction</code> dans le bon format.
     * @return la <code>Fraction</code> dans le bon format
     */
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