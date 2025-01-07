import java.time.LocalDate;

public class LlistaAccions {

    private Accio[] accions;
    private int tamany;
    private int capacitat;

    /**
     * Constructor de la classe LlistaAccions.
     * 
     * @param capacitatInicial Capacitat inicial de la llista.
     */
    public LlistaAccions(int capacitatInicial) {
        this.capacitat = capacitatInicial;
        this.accions = new Accio[capacitatInicial];
        this.tamany = 0;
    }

    /**
     * Obte el nombre actual d'accions a la llista.
     * 
     * @return Nombre d'accions.
     */
    public int getTamany(){
        return tamany;
    }

    /**
     * Obte l'array d'accions actual.
     * 
     * @return Array d'objectes Accio.
     */
    public Accio[] getAccions(){
        return accions;
    }

    /**
     * Actualitza l'array d'accions.
     * 
     * @param accions Nou array d'accions.
     */
    public void setAccions(Accio[] accions){
        this.accions = accions;
    }

    /**
     * Buida la llista d'accions i reinicia el tamany.
     */
    public void buidarLlista(){
        this.accions = new Accio[capacitat];
        this.tamany = 0;
    }

    /**
     * Afegeix una nova acció a la llista. Si la capacitat és insuficient,
     * redimensiona l'array per duplicar la seva capacitat.
     * 
     * @param accio Acció a afegir.
     */
    public void afegirAccio(Accio accio) {
        if (tamany == capacitat) {
            Accio[] nouArray = new Accio[capacitat * 2];
            for (int i = 0; i < tamany; i++) {
                nouArray[i] = accions[i];
            }
            accions = nouArray;
        }
        accions[tamany] = accio;
        tamany++;
    }

    /**
     * Elimina una acció de la llista basant-se en el seu codi.
     * 
     * @param codi Codi de l'acció a eliminar.
     * @return true si l'acció s'ha eliminat amb èxit, false altrament.
     */
    public boolean eliminarAccio(String codi) {
        for (int i = 0; i < tamany; i++) {
            if (accions[i].obtenirCodi().equals(codi)) {
                accions[i] = accions[tamany - 1]; 
                accions[tamany - 1] = null; 
                tamany--;
                return true;
            }
        }
        return false;
    }

    /**
     * Obte totes les demostracions vàlides de la llista.
     * 
     * @return Array d'accions que són demostracions vàlides.
     */
    public Accio[] obtenirDemostracionsValides() {
        Accio[] demostracionsValides = new Accio[accions.length];
        int j = 0;
        for (int i = 0; i < accions.length; i++) {
            Accio accio = accions[i];
            if (accio instanceof Demostracio) {
                Demostracio demostracio = (Demostracio) accio;
                if (demostracio.esValida()) { 
                    demostracionsValides[j] = accio;
                    j++;
                }
            }
        }
        return demostracionsValides;
    }

    /**
     * Filtra i retorna les xerrades que tenen lloc entre dues dates.
     * 
     * @param inici Data d'inici del rang.
     * @param fi Data de fi del rang.
     * @return Array d'accions que són xerrades en el rang especificat.
     */
    public Accio[] obtenirXerradesEntreDates(LocalDate inici, LocalDate fi) {
        int comptador = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i] instanceof Xerrada) {
                Xerrada xerrada = (Xerrada) accions[i];
                if (xerrada.obtenirDataRealitzacio().isAfter(inici.minusDays(1)) && 
                    xerrada.obtenirDataRealitzacio().isBefore(fi.plusDays(1))) {
                    comptador++;
                }
            }
        }

        Accio[] resultats = new Accio[comptador];
        int index = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i] instanceof Xerrada) {
                Xerrada xerrada = (Xerrada) accions[i];
                if (xerrada.obtenirDataRealitzacio().isAfter(inici.minusDays(1)) && 
                    xerrada.obtenirDataRealitzacio().isBefore(fi.plusDays(1))) {
                        resultats[index++] = accions[i];
                }
            }
        }
        return resultats;
    }

    /**
     * Genera un resum amb la informació de totes les accions de la llista.
     * 
     * @return String amb la informació de les accions.
     */
    public String obtenirInformacio() {
        String resultat = ""; 
        for (int i = 0; i < tamany; i++) {
            resultat = resultat + accions[i].obtenirInformacio() + "\n";            
        }
        return resultat;
    }
}
