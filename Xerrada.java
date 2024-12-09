import java.time.LocalDate;

public class Xerrada {
    private Accio heretats;
    private LocalDate dataRealitzacio;
    private int nombreAssistents;
    private int[] valoracions;
    private Membre[] impartidors;

    private int numImpartidors;
    private int numValoracions;

    public Xerrada(Accio heretats, LocalDate dataRealitzacio, int nombreAssistents, int[] valoracions, Membre[] impartidors) {
        this.heretats = heretats;
        this.dataRealitzacio = dataRealitzacio;
        this.nombreAssistents = nombreAssistents;
        this.valoracions = valoracions;
        this.impartidors = impartidors;
        this.numImpartidors = 0;
        this.numValoracions = 0;
    }

    public void afegirImpartidor(Membre impartidor) {
        if (numImpartidors < 3) {
            impartidors[numImpartidors++] = impartidor;
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
