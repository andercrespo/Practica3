import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LlistaAssociacio {
    private Associacio[] associacions;
    private int capacitat;
    private int tamany;

    /**
     * Constructor de la classe LlistaAssociacio.
     * 
     * @param capacitat la capacitat inicial de la llista.
     */
    public LlistaAssociacio(int capacitat) {
        this.associacions = new Associacio[capacitat];
        this.capacitat = capacitat;
        this.tamany = 0;
    }

    /**
     * Obté el nombre d'associacions actuals en la llista.
     * 
     * @return el tamany actual de la llista.
     */
    public int getTamany() {
        return tamany;
    }

    /**
     * Obté l'array d'associacions actuals.
     * 
     * @return un array d'objectes Associacio.
     */
    public Associacio[] getAssociacions() {
        return associacions;
    }

    /**
     * Assigna un nou array d'associacions a la llista.
     * 
     * @param associacions l'array d'associacions a assignar.
     */
    public void setAssociacions(Associacio[] associacions) {
        this.associacions = associacions;
    }

    /**
     * Incrementa el tamany de la llista en una unitat.
     */
    public void aumentaTamany() {
        tamany++;
    }

    /**
     * Afegeix una nova associació a la llista.
     * Si la capacitat actual es completa, es duplica la mida de la llista.
     * 
     * @param associacio l'Associacio a afegir.
     */
    public void afegirAssociacio(Associacio associacio) {
        if (capacitat == tamany) {
            capacitat = capacitat * 2;
            Associacio[] newAssociacions = new Associacio[capacitat];
            System.arraycopy(associacions, 0, newAssociacions, 0, tamany);
            associacions = newAssociacions;
        }
        associacions[tamany] = associacio;
        aumentaTamany();
    }

    /**
     * Elimina una associació de la llista basada en el seu nom.
     * 
     * @param nom el nom de l'associació a eliminar.
     * @return true si l'associació es va eliminar correctament, false altrament.
     */
    public boolean eliminarAssociacio(String nom) {
        boolean eliminat = false;
        int i = 0;
        while (!eliminat && i < tamany) {
            if (associacions[i].getNom().equalsIgnoreCase(nom)) {
                for (int j = i; j < tamany - 1; j++) {
                    associacions[j] = associacions[j + 1];
                }
                associacions[tamany - 1] = null;
                eliminat = true;
            } else {
                i++;
            }
        }
        if (eliminat) {
            tamany--;
        }
        return eliminat;
    }

    /**
     * Cerca una associació en la llista pel seu nom.
     * 
     * @param nom el nom de l'associació a buscar.
     * @return l'Associacio trobada o null si no existeix.
     */
    public Associacio buscarAssociacio(String nom) {
        boolean trobat = false;
        int i = 0;
        while (!trobat && i < tamany) {
            if (associacions[i].getNom().equalsIgnoreCase(nom)) {
                return associacions[i];
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * Obté les associacions que tenen una titulació específica.
     * 
     * @param titulacio la titulació a buscar.
     * @return un array d'associacions que compleixen el criteri.
     */
    public Associacio[] obtenirAssociacionsAmbTitulacions(String titulacio) {
        int contador = 0;
        for (int i = 0; i < tamany; i++) {
            for (String titulacioAssociacio : associacions[i].getTitulacions()) {
                if (titulacioAssociacio.equalsIgnoreCase(titulacio)) {
                    contador++;
                    break;
                }
            }
        }
        Associacio[] associacionsTrobades = new Associacio[contador];
        int j = 0;
        for (int i = 0; i < tamany; i++) {
            for (String titulacioAssociacio : associacions[i].getTitulacions()) {
                if (titulacioAssociacio.equalsIgnoreCase(titulacio)) {
                    associacionsTrobades[j] = associacions[i];
                    j++;
                    break;
                }
            }
        }

        return associacionsTrobades;
    }

    /**
     * Genera una representació textual de totes les associacions en la llista.
     * 
     * @return una cadena amb informació de totes les associacions.
     */
    public String obtenirInformacio() {
        String[] associacionsString = new String[tamany];
        for (int i = 0; i < tamany; i++) {
            associacionsString[i] = associacions[i].getNom();
        }
        String stringAssociacions = String.join("\n", associacionsString);
        stringAssociacions = String.join("Aquesta es la llista d'associacions:\n ", stringAssociacions);
        return stringAssociacions;
    }
}
