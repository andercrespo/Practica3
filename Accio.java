public class Accio {
    private String codi;
    private String titol;
    private Associacio[] associacionsOrganitzadores;
    private Membre responsable;
    private int tamany;
    private String tipus; //Pot ser xerrada o demostració//

    public Accio(String codi, String titol,Associacio[] associacionsOrganitzadores, Membre responsable, String tipus) {
        this.codi = codi;
        this.titol = titol;
        this.associacionsOrganitzadores = associacionsOrganitzadores;
        this.responsable = responsable;
        this.tipus=tipus;
    }

    public String obtenirCodi() {
        return codi;
    }

    public String obtenirTitol() {
        return titol;
    }

    public boolean esXerrada(){
        return "Xerrada".equalsIgnoreCase(this.tipus);
    }

    public boolean esDemostracio(){
        return "Demostracio".equalsIgnoreCase(this.tipus);
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
            info = info.substring(0, info.length() - 2);
        }
        return info;
    }
}
