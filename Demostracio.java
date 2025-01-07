import java.time.LocalDate;

public class Demostracio extends Accio {
    private LocalDate dataDisseny;  // Data en la qual es va dissenyar la demostració
    private boolean esValida;      // Indica si la demostració és vàlida
    private int nombreVegadesOfertes; // Nombre de vegades que s'ha ofert la demostració
    private double costMaterials;  // Cost dels materials utilitzats en la demostració

    /**
     * Constructor de la classe Demostracio.
     *
     * @param codi el codi identificador de la demostració
     * @param titol el títol de la demostració
     * @param associacionsOrganitzadores llista d'associacions que organitzen la demostració
     * @param responsable el membre responsable de la demostració
     * @param tipus el tipus d'acció (per exemple, "demostració")
     * @param dataDisseny la data de disseny de la demostració
     * @param esValida indica si la demostració és vàlida
     * @param nombreVegadesOfertes el nombre de vegades que s'ha ofert la demostració
     * @param costMaterials el cost dels materials de la demostració
     */
    public Demostracio(String codi, String titol, Associacio[] associacionsOrganitzadores, Membre responsable, String tipus, LocalDate dataDisseny, boolean esValida, int nombreVegadesOfertes, double costMaterials) {
        super(codi, titol, associacionsOrganitzadores, responsable, tipus);
        this.dataDisseny = dataDisseny;
        this.esValida = esValida;
        this.nombreVegadesOfertes = nombreVegadesOfertes;
        this.costMaterials = costMaterials;
    }

    /**
     * Marca la demostració com a no vàlida.
     */
    public void marcarComNoValida() {
        esValida = false;
    }

    /**
     * Comprova si la demostració és vàlida.
     *
     * @return true si és vàlida, false en cas contrari
     */
    public boolean esValida() {
        return esValida;
    }

    /**
     * Obtenim la data de disseny de la demostració.
     *
     * @return la data de disseny
     */
    public LocalDate getData() {
        return dataDisseny;
    }

    /**
     * Genera un array buit de demostracions.
     *
     * @return un array buit de demostracions
     */
    public static Demostracio[] obtenirDemostracions() {
        int nDemostracions = 0;
        Demostracio[] demostracions = new Demostracio[nDemostracions];
        return demostracions;
    }

    /**
     * Incrementa el nombre de vegades que s'ha ofert la demostració en una unitat.
     */
    public void incerementarNombreVegadesOfertes() {
        nombreVegadesOfertes = nombreVegadesOfertes + 1;
    }

    /**
     * Obtenim el cost total dels materials utilitzats en la demostració.
     *
     * @return el cost total dels materials
     */
    public double obtenirCostTotal() {
        return costMaterials;
    }

    /**
     * Proporciona una cadena amb la informació detallada de la demostració.
     *
     * @return una cadena amb la informació detallada
     */
    public String obternirInformacioDetallada() {
        String informacio = "La demostració dissenyada el " + dataDisseny + " te un cost de " + costMaterials + " i la seua validesa es: " + esValida;
        return informacio;
    }

    /**
     * Prepara la informació de la demostració en un format adequat per ser desada en un fitxer.
     *
     * @return una cadena amb la informació formatada
     */
    public String guardarFitxer() {
        return (super.guardarFitxer() + dataDisseny + ";" + esValida + ";" + nombreVegadesOfertes + ";" + costMaterials);
    }
}
