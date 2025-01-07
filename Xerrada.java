import java.time.LocalDate;

public class Xerrada extends Accio {
    private LocalDate dataRealitzacio;
    private int nombreAssistents;
    private int[] valoracions;
    private Membre[] impartidors;
    private int numImpartidors;
    private int numValoracions;

    /**
     * Constructor de la classe Xerrada.
     *
     * @param codi                     el codi de la xerrada.
     * @param titol                    el títol de la xerrada.
     * @param associacionsOrganitzadores les associacions que organitzen la xerrada.
     * @param responsable              el membre responsable de la xerrada.
     * @param tipus                    el tipus d'acció (xerrada).
     * @param dataRealitzacio          la data en què es realitza la xerrada.
     * @param nombreAssistents         el nombre d'assistents a la xerrada.
     * @param valoracions              les valoracions de la xerrada (pot ser null).
     * @param impartidors              els membres que imparteixen la xerrada.
     */
    public Xerrada(String codi, String titol, Associacio[] associacionsOrganitzadores, Membre responsable, String tipus, LocalDate dataRealitzacio, int nombreAssistents, int[] valoracions, Membre[] impartidors) {
        super(codi, titol, associacionsOrganitzadores, responsable, tipus);
        this.dataRealitzacio = dataRealitzacio;
        this.nombreAssistents = nombreAssistents;
        this.valoracions = (valoracions != null) ? valoracions : new int[0];
        this.impartidors = (impartidors != null) ? impartidors : new Membre[0];
        this.numImpartidors = this.impartidors.length;
        this.numValoracions = this.valoracions.length;
    }

    /**
     * Retorna la data de realització de la xerrada.
     *
     * @return la data de realització.
     */
    public LocalDate obtenirDataRealitzacio() {
        return dataRealitzacio;
    }

    /**
     * Retorna el nombre total de valoracions de la xerrada.
     *
     * @return el nombre de valoracions.
     */
    public int getNumValoracions() {
        return numValoracions;
    }

    /**
     * Retorna els membres que imparteixen la xerrada.
     *
     * @return un array de membres impartidors.
     */
    public Membre[] getImpartidors() {
        return impartidors;
    }

    /**
     * Retorna un array de xerrades. Actualment inicialitzat amb un array buit.
     *
     * @return un array de xerrades.
     */
    public static Xerrada[] obtenirXerrades() {
        int nXerrades = 0;
        Xerrada[] xerrades = new Xerrada[nXerrades];
        return xerrades;
    }

    /**
     * Retorna el nombre d'assistents a la xerrada.
     *
     * @return el nombre d'assistents.
     */
    public int obtenirNombreAssistents() {
        return nombreAssistents;
    }

    /**
     * Afegeix un impartidor a la xerrada si encara no s'han afegit 3.
     *
     * @param impartidor el membre que es vol afegir com a impartidor.
     */
    public void afegirImpartidor(Membre impartidor) {
        if (numImpartidors < 3) {
            impartidors[numImpartidors++] = impartidor;
        } else {
            System.out.println("No es poden afegir més impartidors, ja n'hi ha 3.");
        }
    }

    /**
     * Registra el nombre d'assistents a la xerrada.
     *
     * @param nombre el nombre d'assistents.
     */
    public void registrarAssistents(int nombre) {
        this.nombreAssistents = nombre;
    }

    /**
     * Afegeix una valoració a la xerrada. Les valoracions han d'estar entre 0 i 10.
     *
     * @param valoracio la valoració que es vol afegir.
     */
    public void afegirValoracio(int valoracio) {
        if (valoracio >= 0 && valoracio <= 10) {
            if (numValoracions >= valoracions.length) {
                int[] nouValoracions = new int[valoracions.length + 1];
                System.arraycopy(valoracions, 0, nouValoracions, 0, valoracions.length);
                valoracions = nouValoracions;
            }
            valoracions[numValoracions++] = valoracio;
        }
    }

    /**
     * Calcula la mitjana de les valoracions de la xerrada.
     *
     * @return la mitjana de valoracions, o 0 si no hi ha valoracions.
     */
    public double obtenirMitjanaValoracions() {
        if (numValoracions == 0) return 0;
        double mitjana = 0;
        for (int i = 0; i < numValoracions; i++) {
            mitjana += valoracions[i];
        }
        return mitjana / numValoracions;
    }

    /**
     * Retorna el nombre total de valoracions de la xerrada.
     *
     * @return el nombre total de valoracions.
     */
    public int obtenirValoracionsTotals() {
        return numValoracions;
    }

    /**
     * Retorna una descripció detallada de la xerrada, incloent el nombre d'impartidors,
     * d'assistents i de valoracions.
     *
     * @return una cadena amb la informació detallada de la xerrada.
     */
    public String obtenirInformacioDetallada() {
        String info = "El nombre d'impartidors és " + numImpartidors + ", " +
                      "el nombre d'assistents és " + nombreAssistents + " i " +
                      "el nombre de valoracions és " + obtenirValoracionsTotals();
        return info;
    }

    /**
     * Genera una representació de la xerrada en format per guardar en un fitxer.
     *
     * @return una cadena amb la informació de la xerrada en format per guardar.
     */
    public String guardarFitxer() {
        String vals = "";
        String imp = "";
        if (valoracions == null) {
            if (impartidors == null) {
                return (super.guardarFitxer() + dataRealitzacio + ";" + nombreAssistents + ";null;null");
            } else {
                for (int i = 0; i < impartidors.length; i++) {
                    imp = imp + impartidors[i].getAlies();
                    if (i != (impartidors.length - 1)) {
                        imp = imp + "/";
                    }
                }
                return (super.guardarFitxer() + dataRealitzacio + ";" + nombreAssistents + ";null;" + imp);
            }
        } else {
            for (int i = 0; i < valoracions.length; i++) {
                vals = vals + valoracions[i];
                if (i != (valoracions.length - 1)) {
                    vals = vals + "/";
                }
            }
            if (impartidors == null) {
                return (super.guardarFitxer() + dataRealitzacio + ";" + nombreAssistents + ";" + vals + ";" + "null");
            } else {
                for (int i = 0; i < impartidors.length; i++) {
                    imp = imp + impartidors[i].getAlies();
                    if (i != (impartidors.length - 1)) {
                        imp = imp + "/";
                    }
                }
            }
        }
        return (super.guardarFitxer() + dataRealitzacio + ";" + nombreAssistents + ";" + vals + ";" + imp);
    }
}
