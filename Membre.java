import java.time.LocalDate;

public class Membre {

    private String alies;
    private String correu;
    private LocalDate[] dataAlta, dataBaixa = new LocalDate[3];
    private LlistaAssociacio associacions;
    private String tipus; // Pot ser "Professor" o "Alumne"

    /**
     * Constructor de la classe Membre.
     *
     * @param alies          l'àlies del membre.
     * @param correu         el correu electrònic del membre.
     * @param dataAlta       la data d'alta del membre.
     * @param dataBaixa      la data de baixa del membre.
     * @param associacions   la llista d'associacions a les quals pertany el membre.
     * @param tipus          el tipus de membre (Professor o Alumne).
     */
    public Membre(String alies, String correu, LocalDate[] dataAlta, LocalDate[] dataBaixa, LlistaAssociacio associacions, String tipus) {
        this.alies = alies;
        this.correu = correu;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
        this.associacions = associacions;
        this.tipus = tipus;
    }

    // Getters

    /**
     * Retorna l'àlies del membre.
     * 
     * @return l'àlies del membre.
     */
    public String getAlies() {
        return alies;
    }

    /**
     * Retorna el correu electrònic del membre.
     * 
     * @return el correu electrònic del membre.
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * Retorna les dates d'alta del membre.
     * 
     * @return un array de dates d'alta.
     */
    public LocalDate[] getDataAlta() {
        return dataAlta;
    }

    /**
     * Retorna les dates de baixa del membre.
     * 
     * @return un array de dates de baixa.
     */
    public LocalDate[] getDataBaixa() {
        return dataBaixa;
    }

    /**
     * Retorna el tipus de membre.
     * 
     * @return el tipus de membre (Professor o Alumne).
     */
    public String getTipus() {
        return tipus;
    }

    /**
     * Verifica si el membre és un professor.
     * 
     * @return true si el membre és un professor, false en cas contrari.
     */
    public boolean esProfessor() {
        return "Professor".equalsIgnoreCase(tipus);
    }

    /**
     * Verifica si el membre és un alumne.
     * 
     * @return true si el membre és un alumne, false en cas contrari.
     */
    public boolean esAlumne() {
        return "Alumne".equalsIgnoreCase(tipus);
    }

    // Setters

    /**
     * Assigna el membre a una associació en una data concreta.
     * 
     * @param data              la data d'alta.
     * @param nomAssociacio     el nom de l'associació.
     * @param llistaAssociacio  la llista d'associacions disponibles.
     */
    public void donarAlta(LocalDate data, String nomAssociacio, LlistaAssociacio llistaAssociacio) {
        Associacio[] associacions = llistaAssociacio.getAssociacions();
        dataAlta[dataAlta.length] = data;
        for (int i = 0; i < llistaAssociacio.getTamany(); i++) {
            if (associacions[i].getNom().equals(nomAssociacio)) {
                associacions[i].afegirMembre(this);
                this.associacions.afegirAssociacio(associacions[i]);
            }
        }
    }

    /**
     * Marca la baixa del membre en una associació específica.
     * 
     * @param data         la data de baixa.
     * @param associacio   l'associació de la qual es dóna de baixa.
     */
    public void donarBaixa(LocalDate data, Associacio associacio) {
        boolean trobada = false;
        int index = 0;
        int j = 0;
        Associacio[] associacionsMembre = associacions.getAssociacions();
        while (!trobada && j < associacionsMembre.length) {
            if (associacio.getNom().equals(associacionsMembre[j].getNom())) {
                index = j;
                trobada = true;
            } else {
                j++;
            }
        }
        dataBaixa[index] = data;
    }

    /**
     * Assigna una nova llista d'associacions al membre.
     * 
     * @param llistaAssociacions la nova llista d'associacions.
     */
    public void setAssociacions(LlistaAssociacio llistaAssociacions) {
        this.associacions = llistaAssociacions;
    }

    /**
     * Verifica si el membre està actiu.
     * 
     * @return true si el membre està actiu, false en cas contrari.
     */
    public boolean esActiu() {
        return dataBaixa == null;
    }

    /**
     * Verifica si el membre pot afegir més associacions.
     * 
     * @return true si pot afegir més associacions, false en cas contrari.
     */
    public boolean potAfegirAssociacio() {
        return associacions.getTamany() < 3;
    }

    /**
     * Afegeix una associació al membre si és possible.
     * 
     * @param associacio l'associació a afegir.
     */
    public void afegirAssociacio(Associacio associacio) {
        if (potAfegirAssociacio()) {
            associacions.afegirAssociacio(associacio);
        }
    }

    /**
     * Retorna la llista d'associacions del membre.
     * 
     * @return la llista d'associacions.
     */
    public LlistaAssociacio getAssociacions() {
        return associacions;
    }

    /**
     * Obté informació detallada sobre el membre.
     * 
     * @return una cadena amb la informació del membre.
     */
    public String obtenirInformacio() {
        return (alies + ", " + correu + ", " + dataAlta + ", " + dataBaixa + ", " + associacions + ", " + tipus);
    }

    /**
     * Genera una representació del membre en format per guardar en un fitxer.
     * 
     * @return una cadena amb la informació del membre en format per guardar.
     */
    public String guardarFitxer() {
        Associacio[] ass = new Associacio[3];
        if (associacions == null) {
            return (alies + ";" + correu + ";" + dataAlta[0] + "/" + dataAlta[1] + "/" + dataAlta[2] + ";" + dataBaixa[0] + "/" + dataBaixa[1] + "/" + dataBaixa[2] + ";null/null/null;" + tipus + ";");
        } else {
            ass = associacions.getAssociacions();
            if (ass[0] == null) {
                return (alies + ";" + correu + ";" + dataAlta[0] + "/" + dataAlta[1] + "/" + dataAlta[2] + ";" + dataBaixa[0] + "/" + dataBaixa[1] + "/" + dataBaixa[2] + ";null/null/null;" + tipus + ";");
            }
            if (ass[1] == null) {
                return (alies + ";" + correu + ";" + dataAlta[0] + "/" + dataAlta[1] + "/" + dataAlta[2] + ";" + dataBaixa[0] + "/" + dataBaixa[1] + "/" + dataBaixa[2] + ";" + ass[0].getNom() + "/null/null;" + tipus + ";");
            }
            if (ass[2] == null) {
                return (alies + ";" + correu + ";" + dataAlta[0] + "/" + dataAlta[1] + "/" + dataAlta[2] + ";" + dataBaixa[0] + "/" + dataBaixa[1] + "/" + dataBaixa[2] + ";" + ass[0].getNom() + "/" + ass[1].getNom() + "/null;" + tipus + ";");
            }
        }
        return (alies + ";" + correu + ";" + dataAlta[0] + "/" + dataAlta[1] + "/" + dataAlta[2] + ";" + dataBaixa[0] + "/" + dataBaixa[1] + "/" + dataBaixa[2] + ";" + ass[0].getNom() + "/" + ass[1].getNom() + "/" + ass[2].getNom() + ";" + tipus + ";");
    }
}
