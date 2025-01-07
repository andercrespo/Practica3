import java.time.LocalDate;

public class Professor extends Membre {
    private String departament;
    private int despatx;

    /**
     * Constructor de la classe Professor.
     *
     * @param alies          l'àlies del professor.
     * @param correu         el correu electrònic del professor.
     * @param dataAlta       les dates d'alta del professor.
     * @param dataBaixa      les dates de baixa del professor.
     * @param associacions   la llista d'associacions a les quals pertany el professor.
     * @param tipus          el tipus de membre (en aquest cas, professor).
     * @param departament    el departament al qual pertany el professor.
     * @param despatx        el número de despatx del professor.
     */
    public Professor(String alies, String correu, LocalDate[] dataAlta, LocalDate[] dataBaixa, LlistaAssociacio associacions, String tipus, String departament, int despatx) {
        super(alies, correu, dataAlta, dataBaixa, associacions, tipus);
        this.departament = departament;
        this.despatx = despatx;
    }

    /**
     * Retorna el departament del professor.
     *
     * @return el departament del professor.
     */
    public String getDepartament() {
        return departament;
    }

    /**
     * Retorna el número de despatx del professor.
     *
     * @return el número de despatx.
     */
    public int getDespatx() {
        return despatx;
    }

    /**
     * Assigna un departament al professor. Només s'accepten els valors "DEIM" o "DEEEA".
     *
     * @param departament el departament a assignar (ha de ser "DEIM" o "DEEEA").
     */
    public void setDepartament(String departament) {
        if (departament.equals("DEIM") || departament.equals("DEEEA")) {
            this.departament = departament;
        } else {
            System.out.println("El departament només pot ser DEIM o DEEEA");
        }
    }

    /**
     * Genera una representació en forma de cadena del professor.
     *
     * @param membre el membre associat al professor.
     * @return una cadena amb la informació del professor.
     */
    public String toString(Membre membre) {
        return "Professor:" + membre.getAlies() + ", correu:" + membre.getCorreu() + ", departament:" + departament
                + ", despatx:" + despatx;
    }

    /**
     * Genera una representació del professor en format per guardar en un fitxer.
     *
     * @return una cadena amb la informació del professor en format per guardar.
     */
    public String guardarFitxer() {
        return (super.guardarFitxer() + departament + ";" + despatx);
    }
}
