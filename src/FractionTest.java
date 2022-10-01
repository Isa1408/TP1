
    /**
     * Represente un type abstrait pour les fractions.
     *
     * @author Bruno Malenfant
     *
     */
    public class FractionTest {

        /**
         * Represente le numerateur de la <code>Fraction</code>.
         */
        private int _numerateur;

        /**
         * Represente le denominateur de la <code>Fraction</code>.
         * @invariant  _denominateur != 0
         */
        private int _denominateur;

        /**
         * Initialisation des variables d'instance.
         */
        {
            _numerateur = 0;
            _denominateur = 1;
        }



        /**
         * Reduit la <code>Fraction</code>.
         */
        private void reduit(){
            int pgcd = MathDiscrete.pgcd( _numerateur, _denominateur );

            if( 0 != pgcd ){
                _numerateur /= pgcd;
                _denominateur /= pgcd;
            } else {
                _numerateur = 0;
                _denominateur = 1;
            }
        }



        /**
         * Constructeur, la <code>Fraction</code> construite est reduite.
         * @param numerateur Un numerateur pour la fraction
         * @param denominateur Un denominateur pour la fraction.
         * @throws ArithmeticException Lance lorsque le denominateur est a 0.
         */
        public FractionTest(int numerateur, int denominateur ) throws ArithmeticException {
            numerateur( numerateur );
            denominateur( denominateur );

            reduit();
        }

        /**
         * Constructeur, la <code>Fraction</code> construite represente une valeur entiere.
         * @param valeurEntiere La valeur entiere a representer.
         */
        public FractionTest(int valeurEntiere ){
            numerateur( valeurEntiere );
        }



        /**
         * Setter : change le numerateur de la <code>Fraction</code>.
         * @param valeur La valeur place dans le numerateur.
         */
        public void numerateur( int valeur ){
            _numerateur = valeur;
        }

        /**
         * Setter : change le denominateur de la <code>Fraction</code>.
         * @param valeur La valeur place dans le denominateur.
         * @throws ArithmeticException Lance lorsque le denominateur est a 0.
         */
        public void denominateur( int valeur ) throws ArithmeticException {
            if( 0 == valeur ) {
                throw new ArithmeticException( "Une Fraction ne peu avoir un denominateur a 0." );
            }

            _denominateur = valeur;
        }

        /**
         * Getter : retourne le numerateur de la <code>Fraction</code>.
         * @return Le numerateur de la <code>Fraction</code>
         */
        public int numerateur(){
            return _numerateur;
        }

        /**
         * Getter : retourne le denominateur de la <code>Fraction</code>.
         * @return Le denominateur de la <code>Fraction</code>.
         */
        public int denominateur(){
            return _denominateur;
        }


        /**
         * Verifie si la <code>Fraction</code> est egale a 0.
         * @return <code>true</code> si la <code>Fraction</code> est
         *         egale a 0, <code>false</code> sinon.
         */
        public boolean estZero(){
            return 0 == _numerateur;
        }


        /**
         * Construit une <code>Fraction</code> contenant l'inverse additif
         * de cette <code>Fraction</code>.
         * @return L'inverse additif de la <code>Fraction</code>.
         */
        public FractionTest inverseAdditif(){
            return new FractionTest( -1 * _numerateur, _denominateur );
        }

        /**
         * Construit une <code>Fraction</code> contenant l'inversi multiplicatif
         * de cette <code>Fraction</code>.
         * @return L'inverse multiplicatif de la <code>Fraction</code>.
         * @throws ArithmeticException Lance si la <code>Fraction</code> a inverse est ZERO.
         */
        public FractionTest inverseMultiplicatif() throws ArithmeticException {
            return new FractionTest( _denominateur, _numerateur );
        }

        /**
         * Additionne les deux <code>Fraction</code>s (<code>this</code> et <code>f2</code>).
         * @param f2 La <code>Fraction</code> ajoutee a <code>this</code>.
         * @return Une nouvelle <code>Fraction</code> contenant le resultat de l'addition.
         */
        public FractionTest add(FractionTest f2 ){
            int ppcm = MathDiscrete.ppcm( _numerateur, _denominateur );

            int multiplicateurThis = ppcm / _denominateur;
            int multiplicateurF2 = ppcm / f2._denominateur;

            int numerateurResultat = multiplicateurThis * _numerateur + multiplicateurF2 * f2._numerateur;

            return new FractionTest( numerateurResultat, ppcm );
        }

        /**
         * Soustrait <code>f2</code> de la <code>Fraction</code>s <code>this</code>.
         * @param f2 La <code>Fraction</code> soustraite de <code>this</code>.
         * @return Une nouvelle <code>Fraction</code> contenant le resultat de la soustraction <code>this</code> - <code>f2</code>.
         */
        public FractionTest sub(FractionTest f2 ){
            return add( f2.inverseAdditif() );
        }

        /**
         * Multiplie les deux <code>Fraction</code>s (<code>this</code> et <code>f2</code>).
         * @param f2 La <code>Fraction</code> multiplie a <code>this</code>.
         * @return Une nouvelle <code>Fraction</code> contenant le resultat de la multiplication.
         */
        public FractionTest mul(FractionTest f2 ){
            FractionTest resultat = ZERO;

            if( ! estZero() && ! f2.estZero() ) {
                int pgcd1 = MathDiscrete.pgcd( _numerateur, f2._denominateur );

                int numerateurResultat = _numerateur / pgcd1;
                int denominateurResultat = f2._denominateur / pgcd1;

                int pgcd2 = MathDiscrete.pgcd( f2._numerateur, _denominateur );

                numerateurResultat *= ( f2._numerateur / pgcd2 );
                denominateurResultat *= ( _denominateur / pgcd2 );

                resultat = new FractionTest( numerateurResultat, denominateurResultat );
            }

            return resultat;
        }

        /**
         * Diviser <code>this</code> par la <code>Fraction</code> <code>f2</code>.
         * @param f2 La <code>Fraction</code> diviseur de <code>this</code>.
         * @return Une nouvelle <code>Fraction</code> contenant le resultat de la division <code>this</code> / <code>f2</code>.
         * @throws ArithmeticException Lance si la <code>Fraction</code> <code>f2</code> est ZERO.
         */
        public FractionTest div(FractionTest f2 ) throws ArithmeticException {
            return mul( f2.inverseMultiplicatif() );
        }


        /**
         * Transforme la <code>Fraction</code> en format affichable (<code>String</code>).
         * @return Une chaine de caractere contenant une representation du numerateur et du denominateur de la
         *         <code>Fraction</code>.
         */
        @Override
        public String toString(){
            return _numerateur + " / " + _denominateur;
        }


        /**
         * Verifie l'egalite entre deux <code>Fraction</code>s.
         * @param obj La deuxieme <code>Fraction</code> comparee avec <code>this</code>.
         */
        @Override
        public boolean equals( Object obj ){
            boolean resultat = false;

            if( obj != null && obj instanceof FractionTest){
                FractionTest temp = (FractionTest)obj;

                resultat = _numerateur * temp._denominateur == _denominateur * temp._numerateur;
            }

            return resultat;
        }


        /**
         * Represente la valeur 0.
         */
        public static final FractionTest ZERO;

        /**
         * Represente la valeur 1.
         */
        public static final FractionTest UN;


        /**
         * Initialisation des variables de classe.
         */
        static {
            ZERO = new FractionTest( 0, 1 );
            UN = new FractionTest( 1, 1 );
        }
    }

