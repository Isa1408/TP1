
/**
 * Bibliotheque de fonction mathematique traitent les nombres entiers.
 * @author Bruno Malenfant
 *
 */
public class MathDiscrete {

    /**
     * Calcule le Plus Grand Commun Diviseur entre deux nombres.
     * @param a Le premier nombre.
     * @param b Le deuxieme nombre.
     * @return Le PGCD entre les deux nombres.
     *         Si un des deux nombres est 0, alors le PGCD sera 0.
     */
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

    /**
     * Calcule le Plus Petit Commun Multiple entre deux nombre.
     * @param a Le premier nombre.
     * @param b Le deuxieme nombre.
     * @return Le PPCM entre les deux nombres.
     *         Si un des deux nombres est 0, alors le PPCM sera 0.
     */
    public static int ppcm( int a, int b ){
        int pg = pgcd( a, b );

        return 0 == pg ? 0 : ( a / pg ) * b;
    }
}

