import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ManipulerChar {
    public static HashMap listeCharEtEffets(Note nouvelleNote, ArrayList donnees){
        //donnees = ManipulerFichiers.listeChar();

        HashMap listeChar = new HashMap<String, Objects>();
        //listeChar.put("1", new Fraction(3,1));
        listeChar.put("1", nouvelleNote.setDuree(new Fraction(1,1)));
        listeChar.put("2", nouvelleNote.setNumDeNote(2));

        return listeChar;
    }

    public static Note manipulerLaNote(Note nouvelleNote, ArrayList donnees){
        HashMap listeChar = listeCharEtEffets(nouvelleNote, donnees);
        for (int i = 0; i < donnees.size(); i++) {
            if (listeChar.containsKey(i)){
               nouvelleNote = (Note) listeChar.get(i);
                //System.out.println(nouvelleNote);
                // nouvelleNote.setDuree(new Fraction(1,1));

                //nouvelleNote.setDuree((Fraction) listeChar.get("1"));

            }
        }
        return nouvelleNote;
    }


    public static boolean validerChar(){
          boolean charValide = false;
//        ArrayList listeFichier = ManipulerFichiers.listeChar();
//        ArrayList listeCharValides = ManipulerChar.charValides();
//
//        for (int i = 0; i < listeFichier.size(); i++) {
//            for (int j = 0; j < listeCharValides.size(); j++) {
//
//            }
//
//        }




       return charValide;
    }
}


//        ArrayList<String> listeCharValide = new ArrayList<String >();
//        listeCharValide.add("1");
//        listeCharValide.add("*");
//        listeCharValide.add(".");
//        listeCharValide.add("/");
//        listeCharValide.add("[");
//        listeCharValide.add("]");
//        listeCharValide.add("a");
//        listeCharValide.add("b");
//        listeCharValide.add("c");
//        listeCharValide.add("d");
//        listeCharValide.add("e");
//        listeCharValide.add("f");
//        listeCharValide.add("g");
//        listeCharValide.add("2");
//        listeCharValide.add("3");
//        listeCharValide.add("4");
//        listeCharValide.add("5");
//        listeCharValide.add("6");
//        listeCharValide.add("7");
//        listeCharValide.add("8");
//        listeCharValide.add("9");
//        listeCharValide.add("&");
//        listeCharValide.add("#");
//        listeCharValide.add("!");
//        System.out.println(listeCharValide);

//return listeCharValide;