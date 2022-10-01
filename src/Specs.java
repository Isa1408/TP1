import java.util.Scanner;

public class Specs {
    public static int nbrTemps(){
        int nbrTempsParLigne = 0;
        Scanner nbrTempsClavier = new Scanner(System.in);
        boolean nbrTempsValide = false;

        while (nbrTempsValide == false) {
            System.out.println("Sélectionnez un nombre de temps par ligne : ");
            nbrTempsParLigne = nbrTempsClavier.nextInt();
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
