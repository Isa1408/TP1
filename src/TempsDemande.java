import java.util.Scanner;

public class TempsDemande {
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
        //nbrTempsClavier.close();
        return nbrTempsParLigne;
    }
}
