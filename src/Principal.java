import java.util.ArrayList;

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
