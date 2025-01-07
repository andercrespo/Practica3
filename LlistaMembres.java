public class LlistaMembres {
    private Membre[] membres;
    private int tamany, capacitat;

    /**
     * Constructor de la classe LlistaMembres.
     * 
     * @param capacitat la capacitat inicial de la llista.
     * @param tamany    el nombre inicial d'elements a la llista.
     */
    public LlistaMembres(int capacitat, int tamany) {
        this.capacitat = capacitat;
        membres = new Membre[capacitat];
        this.tamany = tamany;
    }

    /**
     * Retorna l'array de membres.
     * 
     * @return l'array de membres.
     */
    public Membre[] getMembres() {
        return membres;
    }

    /**
     * Retorna el nombre actual de membres a la llista.
     * 
     * @return el tamany de la llista.
     */
    public int getTamany() {
        return tamany;
    }

    /**
     * Buida la llista de membres i reinicia el tamany a 0.
     */
    public void buidarLlista() {
        this.membres = new Membre[capacitat];
        this.tamany = 0;
    }

    /**
     * Incrementa el tamany de la llista en 1.
     */
    public void aumentaTamany() {
        tamany++;
    }

    /**
     * Assigna un nou array de membres a la llista.
     * 
     * @param membres el nou array de membres.
     */
    public void setMembres(Membre[] membres) {
        this.membres = membres;
    }

    /**
     * Afegeix un nou membre a la llista.
     * Si la capacitat actual no és suficient, la llista s'expandeix.
     * 
     * @param membre el membre a afegir.
     */
    public void afegirMembre(Membre membre) {
        capacitat++;
        Membre[] nouMembres = new Membre[capacitat];
        for (int i = 0; i < membres.length; i++) {
            nouMembres[i] = membres[i];
        }
        nouMembres[tamany] = membre;
        membres = nouMembres;
        tamany++;
    }

    /**
     * Elimina un membre de la llista segons el seu alies.
     * 
     * @param alies l'alies del membre a eliminar.
     * @return true si el membre ha estat eliminat, false en cas contrari.
     */
    public boolean eliminarMembre(String alies) {
        boolean trobat = false;
        int i = 0;
        while (!trobat) {
            if (membres[i].getAlies().equals(alies)) {
                for (int j = i; j < tamany; j++) {
                    membres[j] = membres[j + 1];
                }
                trobat = true;
            }
            i++;
        }
        tamany--;
        return trobat;
    }

    /**
     * Busca un membre a la llista segons el seu alies.
     * 
     * @param alies l'alies del membre a buscar.
     * @return el membre trobat, o null si no existeix.
     */
    public Membre buscarMembre(String alies) {
        boolean trobat = false;
        int i = 0;
        while (!trobat) {
            if (membres[i].getAlies().equals(alies)) {
                trobat = true;
            }
            i++;
        }
        return membres[i];
    }

    /**
     * Retorna una llista de membres que estan actius.
     * 
     * @return un array de membres actius.
     */
    public Membre[] obtenirMembresActius() {
        Membre[] llistaMembresActius = new Membre[capacitat];
        int j = 0;
        for (int i = 0; i < tamany; i++) {
            if (membres[i].esActiu()) {
                llistaMembresActius[j] = membres[i];
                j++;
            }
        }
        return llistaMembresActius;
    }

    /**
     * Retorna una cadena amb informació detallada sobre els membres de la llista.
     * 
     * @return una cadena amb informació dels membres.
     */
    public String obtenirInformacio() {
        String[] membresString = new String[membres.length];

        for (int i = 0; i < membres.length; i++) {
            if (membres[i] != null) {
                membresString[i] = membres[i].getAlies();
            }
        }
        String stringMembres = String.join("\n", membresString);
        stringMembres = "Aquesta es la llista de membres:\n " + stringMembres;
        return stringMembres;
    }
}
