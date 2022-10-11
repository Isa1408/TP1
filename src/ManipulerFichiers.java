import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipulerFichiers {
    public static String demanderNomFichier(){
        Scanner clavier = new Scanner(System.in);
        //Scanner fichier = null; // pas oblige de l ecrire le null mais ici c obligatoire

        System.out.print("entrez le nom du fichier: ");
        String nomFichierEntrees = clavier.next();

        //clavier.close(); //on ferme nos truc une fois a la fin
        return nomFichierEntrees;
    }

    public static Scanner lireFichier(){
        String nomFichierEntree = demanderNomFichier();
        Scanner fichier = null;

        try {
            fichier = new Scanner(new File( nomFichierEntree));
        } catch (FileNotFoundException e) {
            System.err.println("erreur");
            System.exit(-1);
        }

        return fichier;
    }

    public static ArrayList<String> listeChar(){
        Scanner fichier = lireFichier();
        String courant = "";
        fichier.useDelimiter("");
        ArrayList<String> liste = new ArrayList<String>();
        while(fichier.hasNext()){
            courant = fichier.next();
            if (!courant.equals("\n"))
                liste.add(courant);
        }
        return liste;
    }

    public static void ecrireFichier(ArrayList<String> notesAJouer){
        String nomFichierSortie = demanderNomFichier();
        PrintStream sortie = null;
        String notesAffichage;
        try {
            sortie = new PrintStream( new File(nomFichierSortie));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        notesAffichage = toString(notesAJouer);
        sortie.print(notesAffichage);
        sortie.close();
    }

    public static String toString(ArrayList<String> notesAJouer){
        String affichage = "";

        for (String chaque : notesAJouer){
            if(!chaque.equals("\n"))
                affichage = affichage + chaque + " , ";
            else
                affichage = affichage + chaque + "";
        }
        affichage = affichage.replaceAll(", \n", "\n");
        return affichage.substring(0, affichage.lastIndexOf(","));
    }


}
