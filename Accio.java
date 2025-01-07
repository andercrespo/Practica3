public class Accio {

    private String codi;
    private String titol;
    private Associacio[] associacionsOrganitzadores;
    private Membre responsable;
    private int tamany;
    private String tipus;

    /**
     * Constructor de la classe Accio.
     * 
     * @param codi Codi identificador de l'acció.
     * @param titol Títol descriptiu de l'acció.
     * @param associacionsOrganitzadores Array d'associacions organitzadores.
     * @param responsable Membre responsable de l'acció.
     * @param tipus Tipus d'acció ("xerrada" o "demostració").
     */
    public Accio(String codi, String titol, Associacio[] associacionsOrganitzadores, Membre responsable, String tipus) {
        this.codi = codi;
        this.titol = titol;
        this.associacionsOrganitzadores = associacionsOrganitzadores;
        this.responsable = responsable;
        this.tipus = tipus;
        this.tamany = (associacionsOrganitzadores != null) ? associacionsOrganitzadores.length : 0;
    }

    /**
     * Obté el codi de l'acció.
     * 
     * @return El codi de l'acció.
     */
    public String obtenirCodi() {
        return codi;
    }

    /**
     * Obté el títol de l'acció.
     * 
     * @return El títol de l'acció.
     */
    public String obtenirTitol() {
        return titol;
    }

    /**
     * Assigna un nou conjunt d'associacions organitzadores.
     * 
     * @param associacions Array d'associacions organitzadores.
     */
    public void setAssociacions(Associacio[] associacions) {
        this.associacionsOrganitzadores = associacions;
    }

    /**
     * Obté les associacions organitzadores de l'acció.
     * 
     * @return Array d'associacions organitzadores.
     */
    public Associacio[] getAssociacionsOrganitzadores() {
        return associacionsOrganitzadores;
    }

    /**
     * Determina si l'acció és de tipus "xerrada".
     * 
     * @return True si l'acció és una xerrada, false altrament.
     */
    public boolean esXerrada() {
        return "Xerrada".equalsIgnoreCase(this.tipus);
    }

    /**
     * Determina si l'acció és de tipus "demostració".
     * 
     * @return True si l'acció és una demostració, false altrament.
     */
    public boolean esDemostracio() {
        return "Demostracio".equalsIgnoreCase(this.tipus);
    }

    /**
     * Afegeix una associació a les organitzadores de l'acció.
     * Si l'associació ja existeix o no hi ha espai, no s'afegeix.
     * 
     * @param associacio Associació a afegir.
     */
    public void afegirAssociacio(Associacio associacio) {
        boolean trobat = false;
        int i = 0;
        while (i < tamany && !trobat) {
            if (associacionsOrganitzadores[i].equals(associacio)) {
                trobat = true;
            } else {
                i++;
            }
        }
        if (!trobat && tamany < associacionsOrganitzadores.length) {
            associacionsOrganitzadores[tamany++] = associacio;
        }
    }

    /**
     * Obté la informació detallada de l'acció, incloent les associacions organitzadores.
     * 
     * @return Una cadena de text amb la informació de l'acció.
     */
    public String obtenirInformacio() {
        String info = "Títol: " + titol + "\nCodi: " + codi + "\nAssociacions Organitzadores: ";
        boolean hiHaAssociacions = false;
        String coma = "";

        for (int i = 0; i < tamany; i++) {
            if (associacionsOrganitzadores[i] != null) {
                info += coma + associacionsOrganitzadores[i].getNom();
                coma = ", ";
                hiHaAssociacions = true;
            }
        }

        // Si no hi ha associacions, afegir text per defecte
        if (!hiHaAssociacions) {
            info += "Cap associació registrada.";
        }

        return info;
    }

    /**
     * Guarda la informació de l'acció en format de text.
     * 
     * @return Una cadena de text en format semicolon separat.
     */
    public String guardarFitxer() {
        String ass = "";
        if (associacionsOrganitzadores == null) {
            return (codi + ";" + titol + ";null;" + responsable.getAlies() + ";" + tipus + ";");
        } else {
            for (int i = 0; i < associacionsOrganitzadores.length; i++) {
                ass = ass + associacionsOrganitzadores[i].getNom();
                if (i != (associacionsOrganitzadores.length - 1)) {
                    ass = ass + "/";
                }
            }
        }
        return (codi + ";" + titol + ";" + ass + ";" + responsable.getAlies() + ";" + tipus + ";");
    }
}
