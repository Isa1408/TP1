import java.util.ArrayList;

public class Note {
    private int numDeNote = 9;
    private int numOctave = 4;
    private Fraction duree = new Fraction(1,1);

    public Note(int numDeNote, int numOctave, Fraction duree) {
        this.numDeNote = numDeNote;
        this.numOctave = numOctave;
        this.duree = duree;
    }

    public ArrayList<ArrayList<Object>> lesNotes(){
        ArrayList<ArrayList<Object>> toutesLesNotes = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> notes = new ArrayList<>();
        toutesLesNotes.add(notes);
        notes.add(numDeNote);
        notes.add(numOctave);
        notes.add(duree);


        return toutesLesNotes;
    }

    public int getNumDeNote() {
        return numDeNote;
    }

    public void setNumDeNote(int numDeNote) {
        this.numDeNote = numDeNote;
    }

    public int getNumOctave() {
        return numOctave;
    }

    public void setNumOctave(int numOctave) {
        this.numOctave = numOctave;
    }

    public Fraction getDuree() {
        return duree;
    }

    public void setDuree(Fraction duree) {
        this.duree = duree;
    }
}
