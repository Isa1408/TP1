import java.util.Scanner;

public class TempsDemande {
    private int nbrTemps;

    public TempsDemande(int nbrTemps) {
        this.nbrTemps = nbrTemps;
    }

    public int getNbrTemps() {
        return nbrTemps;
    }

    public static int nbrTemps(){
        int nbrTempsParLigne = 0;
        Scanner nbrTempsClavier = new Scanner(System.in);
        boolean nbrTempsValide = false;

        while (nbrTempsValide == false) {
            System.out.print("Sélectionnez un nombre de temps par ligne : ");
            nbrTempsParLigne = nbrTempsClavier.nextInt(); //faire exception
            // pour si l utilisateur met pas de int mais des caracteres
            if (nbrTempsParLigne > 0) {
                nbrTempsValide = true;
            }else {
                System.out.println("Vous avez selectionné un nombre négatif ou égal à 0!");
            }
        }
        //nbrTempsClavier.close();

        return nbrTempsParLigne;
    }
}
