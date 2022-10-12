import java.util.ArrayList;

/**
 * @Author Isabelle Tamas
 * Code permanent: TAMI76580208
 * Présenté à: Bruno Malenfant
 * Date: 13 octobre 2022
 */
public class Principal {
    public static void main(String[] args) {

        try {
            ArrayList<String> liste = ManipulerFichiers.listeChar();
            ArrayList notesAJouer = ManipulerChar.
                    listeNotesAJouer(new Note(9,4,
                    new Fraction(1,1)), liste);

            ManipulerFichiers.ecrireFichier(notesAJouer);
        }catch (Exception e){
            System.exit(-1);
        }
    }
}
