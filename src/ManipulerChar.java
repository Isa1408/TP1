import java.util.ArrayList;
import java.util.Arrays;

public class ManipulerChar {
    public static ArrayList charValides(){
        ArrayList<String> listeCharValide = new ArrayList<String >();
        listeCharValide.add("1");
        listeCharValide.add("*");
        listeCharValide.add(".");
        listeCharValide.add("/");
        listeCharValide.add("[");
        listeCharValide.add("]");
        listeCharValide.add("a");
        listeCharValide.add("b");
        listeCharValide.add("c");
        listeCharValide.add("d");
        listeCharValide.add("e");
        listeCharValide.add("f");
        listeCharValide.add("g");
        listeCharValide.add("2");
        listeCharValide.add("3");
        listeCharValide.add("4");
        listeCharValide.add("5");
        listeCharValide.add("6");
        listeCharValide.add("7");
        listeCharValide.add("8");
        listeCharValide.add("9");
        listeCharValide.add("&");
        listeCharValide.add("#");
        listeCharValide.add("!");
        System.out.println(listeCharValide);

        return listeCharValide;
    }

    public static boolean validerChar(){
        boolean charValide = false;
        ArrayList listeFichier = ManipulerFichiers.listeChar();
        ArrayList listeCharValides = ManipulerChar.charValides();

        for (int i = 0; i < listeFichier.size(); i++) {
            for (int j = 0; j < listeCharValides.size(); j++) {

            }

        }




        return charValide;
    }
}
