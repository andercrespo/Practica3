import java.time.LocalDate;

public class Alumne extends Membre {

    String ensenyament;
    int anysETSE;
    boolean graduat;

    /**
     * Constructor de la classe Alumne.
     * 
     * @param alies Alies de l'alumne.
     * @param correu Correu electrònic de l'alumne.
     * @param dataAlta Dates d'alta com a membre.
     * @param dataBaixa Dates de baixa com a membre.
     * @param associacions Llista d'associacions a les quals l'alumne pertany.
     * @param tipus Tipus de membre.
     * @param ensenyament Ensenyament en el qual està matriculat l'alumne.
     * @param anysETSE Nombre d'anys que l'alumne ha estat a l'ETSE.
     * @param graduat Indica si l'alumne està graduat.
     */
    public Alumne(String alies, String correu, LocalDate[] dataAlta, LocalDate[] dataBaixa, LlistaAssociacio associacions, String tipus, String ensenyament, int anysETSE, boolean graduat) {
        super(alies, correu, dataAlta, dataBaixa, associacions, tipus);
        this.ensenyament = ensenyament;
        this.anysETSE = anysETSE;
        this.graduat = graduat;
    }

    /**
     * Obté l'ensenyament en el qual està matriculat l'alumne.
     * 
     * @return L'ensenyament de l'alumne.
     */
    public String getEnsenyament() {
        return ensenyament;
    }

    /**
     * Obté el nombre d'anys que l'alumne ha estat a l'ETSE.
     * 
     * @return Els anys a l'ETSE.
     */
    public int getAnysETSE() {
        return anysETSE;
    }

    /**
     * Determina si l'alumne està graduat.
     * 
     * @return True si l'alumne està graduat, false altrament.
     */
    public boolean esGraduat() {
        return graduat;
    }

    /**
     * Actualitza l'estat de graduació de l'alumne.
     * 
     * @param graduat Nou estat de graduació.
     */
    public void setGraduat(boolean graduat) {
        this.graduat = graduat;
    }

    /**
     * Guarda la informació de l'alumne en format de text.
     * 
     * @return Una cadena de text amb la informació de l'alumne.
     */
    public String guardarFitxer() {
        return (super.guardarFitxer() + ensenyament + ";" + anysETSE + ";" + graduat);
    }
}
