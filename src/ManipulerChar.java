import java.util.ArrayDeque;
import java.util.ArrayList;

public class ManipulerChar {
    public static ArrayList manipulerLaNote(Note noteTemp, ArrayList<String> donnees){
        ArrayDeque<Note> notePile = new ArrayDeque<>();
        ArrayList<Note> notesAJouer = new ArrayList<>();
        Note derniereNotePile;

        for (String laDonnee : donnees){
            switch (laDonnee){
                case "1":
                    noteTemp.setDuree(new Fraction(1,1));
                    break;
                case "*":
                    noteTemp.setDuree(noteTemp.getDuree().multiplierFractions(new Fraction(2,1)));
                    break;
                case ".":
                    noteTemp.setDuree(noteTemp.getDuree().multiplierFractions(new Fraction(3,2)));
                    break;
                case "/":
                    noteTemp.setDuree(noteTemp.getDuree().diviserFractions(new Fraction(2,1)));
                    break;
                case "[":
                    //sauvegarde la note courante sur la pile
                    notePile.add(new Note(noteTemp));
                    break;
                case "]":
                    //remplace ls note courante par la note au sommet de la pile
                    if (notePile != null){
                        derniereNotePile = notePile.pollLast();
                        noteTemp = derniereNotePile;
                    }
                    break;
                case "a":
                    noteTemp.setNumDeNote(9);
                    break;
                case "b":
                    noteTemp.setNumDeNote(11);
                    break;
                case "c":
                    noteTemp.setNumDeNote(0);
                    break;
                case "d":
                    noteTemp.setNumDeNote(2);
                    break;
                case "e":
                    noteTemp.setNumDeNote(4);
                    break;
                case "f":
                    noteTemp.setNumDeNote(5);
                    break;
                case "g":
                    noteTemp.setNumDeNote(7);
                    break;
                case "2":
                    noteTemp.setNumOctave(2);
                    break;
                case "3":
                    noteTemp.setNumOctave(3);
                    break;
                case "4":
                    noteTemp.setNumOctave(4);
                    break;
                case "5":
                    noteTemp.setNumOctave(5);
                    break;
                case "6":
                    noteTemp.setNumOctave(6);
                    break;
                case "7":
                    noteTemp.setNumOctave(7);
                    break;
                case "8":
                    noteTemp.setNumOctave(8);
                    break;
                case "9":
                    noteTemp.setNumOctave(9);
                    break;
                case "&":
                    if(noteTemp.getNumDeNote() == 0 && noteTemp.getNumOctave() == 2){
                        noteTemp = noteTemp;
                    } else if (noteTemp.getNumDeNote() == 0) {
                        noteTemp.setNumDeNote(11);
                        noteTemp.setNumOctave(noteTemp.getNumOctave()-1);
                    }else{
                        noteTemp.setNumDeNote(noteTemp.getNumDeNote()-1);
                }
                    break;
                case "#":
                    if(noteTemp.getNumDeNote() == 11 && noteTemp.getNumOctave() == 9){
                        noteTemp = noteTemp;
                    } else if (noteTemp.getNumDeNote() == 11) {
                        noteTemp.setNumDeNote(0);
                        noteTemp.setNumOctave(noteTemp.getNumOctave()+1);
                    }else {
                        noteTemp.setNumDeNote(noteTemp.getNumDeNote()+1);
                    }
                    break;
                case "!":
                    //indique qu il faut jouer la note courante
                    notesAJouer.add(new Note(noteTemp));
                    break;
            }
        }
        return notesAJouer;
    }

    public static ArrayList<String> listeNotesAJouer(Note noteTemp,
                                                ArrayList<String> donnees){
        int nbrTemps = TempsDemande.nbrTemps();
        Fraction leTempsDemande = new Fraction(nbrTemps,1);
        ArrayList<Note> notesAJouer = manipulerLaNote(noteTemp, donnees);
        ArrayList<String> listeNotesAJouer = new ArrayList<String>();
        //ArrayList<Note> listeNotesAJouer = new ArrayList<>();
        Fraction laDuree;
        int leNumNote;
        int leNumOctave;
        String valeurDeLaNote = "";
        boolean valeurDeLaNoteTrouvee;
        boolean valeurPasDansTableau;
        String noteBonFormat = "";
        Note note;
        Fraction temps = null;
        ArrayList<Fraction> lesDurees = new ArrayList<>();
        Fraction somme;
        Fraction tmpRestant;
        Fraction tmpTransf = null;
        boolean dureeTransf = false;


        for (Note chaqueNote : notesAJouer){
            noteBonFormat = "";
            valeurDeLaNoteTrouvee = true;
            valeurPasDansTableau = true;
            laDuree = chaqueNote.getDuree();
            leNumNote = chaqueNote.getNumDeNote();
            leNumOctave = chaqueNote.getNumOctave();

            do {
                switch (leNumNote) {
                    case 9:
                        valeurDeLaNote = "A";
                        valeurDeLaNoteTrouvee = true;
                        break;
                    case 11:
                        valeurDeLaNote = "B";
                        valeurDeLaNoteTrouvee = true;
                        break;
                    case 0:
                        valeurDeLaNote = "C";
                        valeurDeLaNoteTrouvee = true;
                        break;
                    case 2:
                        valeurDeLaNote = "D";
                        valeurDeLaNoteTrouvee = true;
                        break;
                    case 4:
                        valeurDeLaNote = "E";
                        valeurDeLaNoteTrouvee = true;
                        break;
                    case 5:
                        valeurDeLaNote = "F";
                        valeurDeLaNoteTrouvee = true;
                        break;
                    case 7:
                        valeurDeLaNote = "G";
                        valeurDeLaNoteTrouvee = true;
                        break;
                    default:
                        valeurDeLaNoteTrouvee = false;
                        valeurPasDansTableau = false;
                        leNumNote = leNumNote -1;
                }
            }while (!valeurDeLaNoteTrouvee);

            if (valeurPasDansTableau == false){
                valeurDeLaNote = valeurDeLaNote + "#";
            }


            if (temps != null){
//                if(dureeTransf){
//                    temps = temps.additionnerFractions(tmpTransf);
//                }
//                if(tmpTransf != null){
//                    temps = temps.additionnerFractions(tmpTransf);
//                }
//                if(!lesDurees.isEmpty()){
//                    temps = temps.additionnerFractions(lesDurees.get(0));
//                }
                temps = temps.additionnerFractions(laDuree);
            }else {
                temps = new Fraction(laDuree.getNumerateur(),
                        laDuree.getDenominateur());
            }

            if(dureeTransf){
                temps = temps.additionnerFractions(tmpTransf);
            }

            lesDurees.add(laDuree); //ajouter duree transferee

            if(temps.estPlusGrand(leTempsDemande)){
                somme = lesDurees.get(0);
                for(int i = 1; i < lesDurees.size()-1; i++){
                    somme = somme.additionnerFractions(lesDurees.get(i));
                }
//                if(tmpTransf != null){
//                    temps = temps.additionnerFractions(tmpTransf);
//                }
                tmpRestant = leTempsDemande.soustraireFractions(somme);
                tmpTransf = temps.soustraireFractions(leTempsDemande);
                laDuree = tmpRestant;

            }

            noteBonFormat = laDuree + " " + valeurDeLaNote + leNumOctave;
            listeNotesAJouer.add(new String(noteBonFormat));
            dureeTransf = false;
            if(temps.estPlusGrand(leTempsDemande) || temps.estEgal(leTempsDemande)){
                listeNotesAJouer.add(new String("\n"));
                if(temps.estPlusGrand(leTempsDemande)){
                    noteBonFormat = tmpTransf + " " + valeurDeLaNote + leNumOctave;
                    listeNotesAJouer.add(new String(noteBonFormat));
                }
                //tmpTransf = null;

                lesDurees.clear();
                if(temps.estPlusGrand(leTempsDemande)){
                    lesDurees.add(tmpTransf);
                    dureeTransf = true;
                }
                //tmpTransf = null; //pas le mettre a null

                temps = null;
            }
        }
        return listeNotesAJouer;
    }

    //mettre retour en String
//    public static ArrayList affichage(Note noteTemp, ArrayList<String> donnees){
//        ArrayList<String> listeNotesAJouer = listeNotesAJouer(noteTemp,donnees);
//        String notesAAfficher = "";
//        int nbrTemps = TempsDemande.nbrTemps();
//        //TempsDemande temps = new TempsDemande(nbrTemps);
//
//        for (Note chaqueNote : listeNotesAJouer){
//
//        }
//
//
//
//        return listeNotesAJouer;
//    }
}
