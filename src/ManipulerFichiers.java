import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represente la classe qui va manipuler les fichiers d'entrées et de sorties.
 *
 * @Author Bruno Malenfant
 * @Author Isabelle Tamas
 */
public class ManipulerFichiers {

    /**
     * Méthode qui demande à l'utilisateur le nom des fichiers.
     * @return retourne le nom du fichier saisi.
     */
    public static String demanderNomFichier(){
        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrez le nom du fichier: ");
        String nomFichierEntrees = clavier.next();

        return nomFichierEntrees;
    }

    /**
     * Méthode qui lit le fichier d'entrée.
     * @return retourne le fichier demandé.
     */
    public static Scanner lireFichier(){
        String nomFichierEntree = demanderNomFichier();
        Scanner fichier = null;

        try {
            fichier = new Scanner(new File( nomFichierEntree));
        } catch (FileNotFoundException e) {
            System.err.println("Erreur");
            System.exit(-1);
        }
        return fichier;
    }

    /**
     * Méthode qui parcoure le fichier et place chaque caractères dans un
     * <code>Arraylist</code>
     * @return retourne un <code>Arraylist</code> de type <code>String</code>
     */
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


    /**
     * Méthode qui écrit dans un nouveau fichier saisi par l'utilisateur.
     * @param notesAJouer une liste de notes à imprimer.
     */
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

    /**
     * Méthode qui affiche la liste de notes à imprimer dans un bon format.
     * @param notesAJouer liste de notes à imprimer.
     * @return le <code>Strinf</code> qu'il doit afficher.
     */
    public static String toString(ArrayList<String> notesAJouer){
        String affichage = "";

        for (String chaque : notesAJouer){
            if(!chaque.equals("\n"))
                affichage = affichage + chaque + ", ";
            else
                affichage = affichage + chaque + "";
        }
        affichage = affichage.replaceAll(", \n", "\n");
        return affichage;
    }
}
