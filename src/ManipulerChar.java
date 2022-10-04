import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ManipulerChar {
    public static Note manipulerLaNote(Note noteTemp, ArrayList<String> donnees){
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

                    break;
            }
        }
        return noteTemp;
    }
}
