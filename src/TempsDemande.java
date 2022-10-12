import java.util.Scanner;

/**
 * Classe qui permet de demander le temps à l'utilisateur.
 * @Author Isabelle Tamas
 */
public class TempsDemande {
    /**
     * Méthode qui demande à l'utilisateur le nombre de temps par ligne.
     * @return le nombre de temps par ligne
     */
    public static int nbrTemps(){
        int nbrTempsParLigne = 0;
        Scanner nbrTempsClavier = new Scanner(System.in);
        boolean nbrTempsValide = false;
        boolean pasUncChiffre = false;

        while (!nbrTempsValide || pasUncChiffre) {
            pasUncChiffre = false;

            try{
                System.out.print("Sélectionnez un nombre de temps par ligne : ");
                nbrTempsParLigne = Integer.parseInt(nbrTempsClavier.next());
                if (nbrTempsParLigne > 0) {
                    nbrTempsValide = true;
                }else {
                    System.out.println("Vous avez selectionné un nombre négatif ou égal à 0!");
                }
            }catch (Exception e){
                System.out.println("Vous n'avez pas selectionné un chiffre!");
                pasUncChiffre = true;
            }
        }
        return nbrTempsParLigne;
    }
}
