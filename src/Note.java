import java.util.Objects;

public class Note {
    private int numDeNote = 9;
    private int numOctave = 4;
    private Fraction duree = new Fraction(1,1);

    public Note(int numDeNote, int numOctave, Fraction duree) {
        this.numDeNote = numDeNote;
        this.numOctave = numOctave;
        this.duree = duree;
    }



//    public ArrayList<ArrayList<Object>> lesNotes(){
//        ArrayList<ArrayList<Object>> toutesLesNotes = new ArrayList<ArrayList<Object>>();
//        ArrayList<Object> notes = new ArrayList<>();
//        toutesLesNotes.add(notes);
//        notes.add(numDeNote);
//        notes.add(numOctave);
//        notes.add(duree);
//
//
//        return toutesLesNotes;
//    }

    public int getNumDeNote() {
        return numDeNote;
    }

    public Object setNumDeNote(int numDeNote) {
        this.numDeNote = numDeNote;
        return null;
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

    public Objects setDuree(Fraction duree) {
        this.duree = duree;
        return null;
    }

    public String toString(){
        String noteRendue = this.numDeNote + "," + this.numOctave + "," + this.duree;
        return noteRendue;
    }
}
