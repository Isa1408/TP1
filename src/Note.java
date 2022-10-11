public class Note {
    private int numDeNote;
    private int numOctave;
    private Fraction duree;


    public Note(int numDeNote, int numOctave, Fraction duree) {
        this.numDeNote = numDeNote;
        this.numOctave = numOctave;
        this.duree = duree;
    }

    public Note(Note nouvelleNote){
        this.numDeNote = nouvelleNote.numDeNote;
        this.numOctave = nouvelleNote.numOctave;
        this.duree = nouvelleNote.duree;
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

    public String toString(){
        String noteRendue = this.numDeNote + "," + this.numOctave + "," + this.duree;
        return noteRendue;
    }
}
