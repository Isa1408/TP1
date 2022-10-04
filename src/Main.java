import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //ManipulerFichiers.lireFichier();
        //Specs.nbrTemps();
        //ManipulerChar.charValides();
        Fraction fraction = new Fraction(-32, 68);
        Fraction fraction2 = new Fraction(5, 4);


//
//        Fraction fraction3 = fraction.diviserFractions(fraction2);
//        System.out.println(fraction3.toString());
//       // System.out.println(fraction3.getNumerateur() + "/" + fraction3.getDenominateur());

//        int test = Fraction.trouverPGCD(-4,-2);
//        System.out.println(test);

        Note note1 = new Note(11,9,fraction2);
        Note note2 = new Note(8,5,fraction);

            //        ArrayList<ArrayList<Object>> noteTest = note1.lesNotes();
            //        ArrayList<ArrayList<Object>> noteTest2 = note2.lesNotes();
            //
            //        System.out.println(noteTest.get(0).set(1,note1));
            //        //System.out.println(noteTest2);
            //
            //
            //       // System.out.println();
            //
            ////        System.out.println();
            ////        System.out.println(note1.lesNotes());
            ////        System.out.println(note2.lesNotes());


//        ManipulerChar.listeCharEtEffets(note1);
//        System.out.println();

        //ManipulerFichiers.lireFichier();



//        ArrayList liste = ManipulerFichiers.listeChar();
//        Note nouvelleNote = Note.manipulerLaNote(note1, liste);
//        System.out.println(nouvelleNote.toString());

        ArrayList<String> liste = ManipulerFichiers.listeChar();
        Note nouvelleNote = ManipulerChar.manipulerLaNote(note1, liste);
        System.out.println(nouvelleNote.toString());


    }
}
