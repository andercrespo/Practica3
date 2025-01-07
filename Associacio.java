/**
 * Representa una associació amb informació sobre el seu nom, contacte, titulacions,
 * membres i càrrecs directius. Permet gestionar membres, titulacions i càrrecs.
 */
import java.io.Serializable;
import java.time.LocalDate;

public class Associacio implements Serializable {

    private String nom;
    private String correuContacte;
    private String[] titulacions;
    private LlistaMembres membres;
    private LlistaMembres membresActius;
    private Alumne president;
    private Alumne secretari;
    private Alumne tresorer;
    private int numTitulacions;
    static final long serialVersionUID = 1;

    /**
     * Constructor de la classe Associacio.
     * 
     * @param nom Nom de l'associació.
     * @param correuContacte Correu electrònic de contacte.
     * @param titulacions Llista de titulacions associades.
     * @param membres Llista de membres de l'associació.
     * @param membresActius Llista de membres actius de l'associació.
     * @param president Alumne que ocupa el càrrec de president.
     * @param secretari Alumne que ocupa el càrrec de secretari.
     * @param tresorer Alumne que ocupa el càrrec de tresorer.
     */
    public Associacio(String nom, String correuContacte, String[] titulacions, LlistaMembres membres, LlistaMembres membresActius, Alumne president, Alumne secretari, Alumne tresorer) {
        this.nom = nom;
        this.correuContacte = correuContacte;
        this.titulacions = (titulacions != null) ? titulacions : new String[0];
        this.membres = membres;
        this.membresActius = membresActius;
        this.president = president;
        this.secretari = secretari;
        this.tresorer = tresorer;
        this.numTitulacions = this.titulacions.length;
    }

    /**
     * Obté el nom de l'associació.
     * 
     * @return El nom de l'associació.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obté la llista de titulacions associades.
     * 
     * @return Un array de titulacions.
     */
    public String[] getTitulacions() {
        return titulacions;
    }

    /**
     * Obté la llista de membres de l'associació.
     * 
     * @return La llista de membres.
     */
    public LlistaMembres getMembres() {
        return membres;
    }

    /**
     * Afegeix una nova titulació a la llista de titulacions de l'associació.
     * 
     * @param titulacio La titulació a afegir.
     */
    public void afegirTitulacio(String titulacio) {
        boolean trobat = false;
        int i = 0;
        while (i < titulacions.length && !trobat) {
            if (titulacio.equals(titulacions[i])) {
                trobat = true;
            } else {
                i++;
            }
        }
        if (!trobat) {
            if (numTitulacions >= titulacions.length) {
                String[] nouArray = new String[titulacions.length + 1];
                System.arraycopy(titulacions, 0, nouArray, 0, titulacions.length);
                titulacions = nouArray;
            }
            titulacions[numTitulacions++] = titulacio;
        }
    }

    /**
     * Elimina una titulació de la llista de titulacions de l'associació.
     * 
     * @param titulacio La titulació a eliminar.
     */
    public void eliminarTitulacio(String titulacio) {
        boolean trobat = false;
        int i = 0;
        while (i < titulacions.length && !trobat) {
            if (titulacio.equals(titulacions[i])) {
                trobat = true;
                for (int j = i; j < titulacions.length - 1; j++) {
                    titulacions[j] = titulacions[j + 1];
                }
                numTitulacions--;
            } else {
                i++;
            }
        }
    }

    /**
     * Comprova si l'associació té una titulació específica.
     * 
     * @param titulacio La titulació a comprovar.
     * @return True si la titulació existeix, false altrament.
     */
    public boolean teTitulacio(String titulacio) {
        boolean trobat = false;
        int i = 0;
        while (i < titulacions.length && !trobat) {
            if (titulacio.equals(titulacions[i])) {
                trobat = true;
            } else {
                i++;
            }
        }
        return trobat;
    }

    /**
     * Afegeix un membre a l'associació i, si està actiu, també l'afegeix als membres actius.
     * 
     * @param membre El membre a afegir.
     */
    public void afegirMembre(Membre membre) {
        membres.afegirMembre(membre);
        if (membre.getDataBaixa() == null) {
            membresActius.afegirMembre(membre);
        }
    }

    /**
     * Dona de baixa un membre de l'associació.
     * 
     * @param membre El membre a donar de baixa.
     * @param dataBaixa La data de baixa.
     * @param associacio L'associació de la qual es dóna de baixa el membre.
     */
    public void donarDeBaixaMembre(Membre membre, LocalDate dataBaixa, Associacio associacio) {
        membre.donarBaixa(dataBaixa, associacio);
        membresActius.eliminarMembre(membre.getAlies());
    }

    /**
     * Obté la llista de membres actius de l'associació.
     * 
     * @return La llista de membres actius.
     */
    public LlistaMembres obtenirMembresActius() {
        return membresActius;
    }

    /**
     * Filtra els membres de l'associació segons si són professors o alumnes.
     * 
     * @param inclouProfessors Indica si s'inclouen els professors.
     * @param inclouAlumnes Indica si s'inclouen els alumnes.
     * @return Una llista de membres filtrats.
     */
    public LlistaMembres obtenirMembresFiltrats(boolean inclouProfessors, boolean inclouAlumnes) {
        LlistaMembres filtrats = new LlistaMembres(membres.getTamany(), 0);
        for (int i = 0; i < membres.getTamany(); i++) {
            Membre membre = membres.getMembres()[i];
            if ((inclouProfessors && membre.esProfessor()) || (inclouAlumnes && membre.esAlumne())) {
                filtrats.afegirMembre(membre);
            }
        }
        return filtrats;
    }

    /**
     * Assigna el càrrec de president a un alumne.
     * 
     * @param alumne L'alumne a assignar com a president.
     */
    public void assignarPresident(Alumne alumne) {
        president = alumne;
    }

    /**
     * Assigna el càrrec de secretari a un alumne.
     * 
     * @param alumne L'alumne a assignar com a secretari.
     */
    public void assignarSecretari(Alumne alumne) {
        secretari = alumne;
    }

    /**
     * Assigna el càrrec de tresorer a un alumne.
     * 
     * @param alumne L'alumne a assignar com a tresorer.
     */
    public void assignarTresorer(Alumne alumne) {
        tresorer = alumne;
    }

    /**
     * Verifica si tots els càrrecs de l'associació han estat assignats.
     * 
     * @return True si tots els càrrecs estan assignats, false altrament.
     */
    public boolean verificarCarrecsAssignats() {
        return president != null && secretari != null && tresorer != null;
    }

    /**
     * Obté la informació de l'associació en format de text.
     * 
     * @return Una cadena amb la informació de l'associació.
     */
    public String obtenirInformacio() {
        String stringTitulacions = String.join(", ", titulacions);
        Membre[] membresArray = membresActius.getMembres();
        StringBuilder stringActius = new StringBuilder(membresArray[0].getAlies());
        for (int i = 1; i < membresActius.getTamany(); i++) {
            stringActius.append(",\n ").append(membresArray[i].getAlies());
        }
        return "L'associació " + nom + " té com a correu de contacte " + correuContacte +
               " i està formada per alumnes d'aquestes titulacions: " + stringTitulacions +
               ". I té els següents membres en actiu:\n" + stringActius;
    }
}
