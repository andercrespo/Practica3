import java.time.LocalDate;

public class Xerrada extends Accio {
    private LocalDate dataRealitzacio;
    private int nombreAssistents;
    private int[] valoracions;
    private Membre[] impartidors;

    private int numImpartidors;
    private int numValoracions;

    public Xerrada(String codi, String titol,Associacio[] associacionsOrganitzadores, Membre responsable, String tipus, LocalDate dataRealitzacio, int nombreAssistents, int[] valoracions, Membre[] impartidors) {
        super(codi, titol, associacionsOrganitzadores, responsable, tipus);
        this.dataRealitzacio = dataRealitzacio;
        this.nombreAssistents = nombreAssistents;
        this.valoracions = valoracions;
        this.impartidors = impartidors;
        this.numImpartidors = 0;
        this.numValoracions = 0;
    }

    public LocalDate obtenirDataRealitzacio() {
        return dataRealitzacio;
    }

    public void afegirImpartidor(Membre impartidor) {
        if (numImpartidors < 3) {
            impartidors[numImpartidors+1] = impartidor;
        } else {
            System.out.println("No es poden afegir més impartidors, ja n'hi ha 3.");
        }
    }

    public void registrarAssistents(int nombre) {
        this.nombreAssistents = nombre;
    }

    public void afegirValoracio(int valoracio) {
        if (valoracio >= 0 && valoracio <= 10 && numValoracions < valoracions.length) {
            valoracions[numValoracions++] = valoracio;
        }
    }

    public double obtenirMitjanaValoracions() {
        if (numValoracions == 0) return 0;
        double mitjana = 0;
        for (int i = 0; i < numValoracions; i++) {
            mitjana += valoracions[i];
        }
        return mitjana / numValoracions;
    }

    public int obtenirValoracionsTotals() {
        return numValoracions;
    }

    public String obtenirInformacioDetallada() {
        String info = "El nombre d'impartidors és " + numImpartidors + ", " +
                      "el nombre d'assistents és " + nombreAssistents + " i " +
                      "el nombre de valoracions és " + obtenirValoracionsTotals();
        return info;
    }
}
