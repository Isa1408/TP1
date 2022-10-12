/**
 * Représente la classe qui créé les notes.
 * @Author Isabelle Tamas
 */
public class Note {
    private int numDeNote;
    private int numOctave;
    private Fraction duree;

    /**
     * Constructeur de note.
     * @param numDeNote le numéro de la note
     * @param numOctave le numéro de l'octave
     * @param duree la durée en <code>Fraction</code>
     */
    public Note(int numDeNote, int numOctave, Fraction duree) {
        this.numDeNote = numDeNote;
        this.numOctave = numOctave;
        this.duree = duree;
    }

    /**
     * Constructeur de note qui prend en paramètre une note.
     * @param nouvelleNote une note
     */
    public Note(Note nouvelleNote){
        this.numDeNote = nouvelleNote.numDeNote;
        this.numOctave = nouvelleNote.numOctave;
        this.duree = nouvelleNote.duree;
    }

    /**
     * Getter du numéro de la note.
     * @return le numéro de la note
     */
    public int getNumDeNote() {
        return numDeNote;
    }

    /**
     * Setter du numéro de la note.
     * @param numDeNote le numéro de la note.
     */
    public void setNumDeNote(int numDeNote) {
        this.numDeNote = numDeNote;
    }

    /**
     * Getter du numéro d'octave.
     * @return le numéro d'octave
     */
    public int getNumOctave() {
        return numOctave;
    }

    /**
     * Setter du numéro d'octave.
     * @param numOctave le numéro d'octave
     */
    public void setNumOctave(int numOctave) {
        this.numOctave = numOctave;
    }

    /**
     * Getter de la durée.
     * @return la durée
     */
    public Fraction getDuree() {
        return duree;
    }

    /**
     * Setter de la durée.
     * @param duree la durée
     */
    public void setDuree(Fraction duree) {
        this.duree = duree;
    }

    /**
     * Affichage d'une note.
     * @return la note bien affichée
     */
    public String toString(){
        String noteRendue = this.numDeNote + "," + this.numOctave + "," + this.duree;
        return noteRendue;
    }
}
