public class Accio {
    private String codi;
    private String titol;
    private Associacio[] associacionsOrganitzadores;
    private Membre responsable;
    private int tamany;

    public Accio(String codi, String titol, int capacitat, Membre responsable) {
        this.codi = codi;
        this.titol = titol;
        this.associacionsOrganitzadores = new Associacio[capacitat];
        this.responsable = responsable;
        this.tamany = 0;
    }

    public String obtenirCodi() {
        return codi;
    }

    public String obtenirTitol() {
        return titol;
    }

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

    public String obtenirInformacio() {
        String info = "Títol: " + titol + "\nCodi: " + codi + "\nAssociacions Organitzadores: ";
        for (int i = 0; i < tamany; i++) {
            info += associacionsOrganitzadores[i].getNom() + ", ";
        }
        if (tamany > 0) {
            info = info.substring(0, info.length() - 2); // Retirem l'última coma
        }
        return info;
    }
}
