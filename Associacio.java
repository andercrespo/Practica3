import java.io.Serializable;
import java.time.LocalDate;

public class Associacio implements Serializable{
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


    //Constructor//
    public Associacio(String nom, String correuContacte, String[] titulacions, LlistaMembres membres, LlistaMembres membresActius, Alumne president, Alumne secretari, Alumne tresorer) {
        this.nom = nom;
        this.correuContacte = correuContacte;
        this.titulacions = (titulacions != null) ? titulacions : new String[0];  // Asegura que no sea null
        this.membres = membres;
        this.membresActius = membresActius;
        this.president = president;
        this.secretari = secretari;
        this.tresorer = tresorer;
        this.numTitulacions = this.titulacions.length;  
    }
    

    //Getters//
    public String getNom(){
        return nom;
    }

    public String[] getTitulacions(){
        return titulacions;
    }
    
    public LlistaMembres getMembres(){
        return membres;
    }
        
    //Gestió de titulacions//
    public void afegirTitulacio (String titulacio){
        boolean trobat=false;
        int i=0;
        while(i<titulacions.length && !trobat){
            if(titulacio==titulacions[i]){
                trobat=true;
            }
            else{
                i++;
            }
        }
        if(!trobat){
            if (numTitulacions >= titulacions.length) {
                String[] nouArray = new String[titulacions.length + 1];
                System.arraycopy(titulacions, 0, nouArray, 0, titulacions.length);
                titulacions = nouArray;
            }
            titulacions[numTitulacions++] = titulacio;
        }
    }

    public void eliminarTitulacio (String titulacio){
        boolean trobat=false;
        int i=0;
        while(i<titulacions.length && !trobat){
            if(titulacio==titulacions[i]){
                trobat=true;
                for(int j=i;j<titulacions.length;j++){
                    titulacions[j]=titulacions[j+1];
                }
            }
            else{
                i++;
            }
        }
    }

    public boolean teTitulacio (String titulacio){
        boolean trobat=false;
        int i=0;
        while(i<titulacions.length && !trobat){
            if(titulacio==titulacions[i]){
                trobat=true;
            }
            else{
                i++;
            }
        }
        return (trobat);
    }

    //Gestió de membres// 

    public void afegirMembre(Membre membre){
        membres.afegirMembre(membre);
        if(membre.getDataBaixa()==null){
            membresActius.afegirMembre(membre);
        }
    }

    public void donarDeBaixaMembre(Membre membre, LocalDate dataBaixa, Associacio associacio){
        membre.donarBaixa(dataBaixa, associacio);
        membresActius.eliminarMembre(membre.getAlies());
    }

    public LlistaMembres obtenirMembresActius(){
        return membresActius;
    }

    public LlistaMembres obtenirMembresFiltrats(boolean inclouProfessors,boolean inclouAlumnes){
        LlistaMembres filtrats = new LlistaMembres(membres.getTamany(),0);
        int noAfegits=0;
        for (int i=0;i<membres.getTamany();i++) {
            Membre membre = membres.getMembres()[i];
            boolean esProfessor = membre.esProfessor();
            boolean esAlumne = membre.esAlumne();
            boolean afegit=false;

            if (inclouProfessors && esProfessor){
                filtrats.afegirMembre(membre);
                afegit=true;
            }
            if(!afegit && (inclouAlumnes && esAlumne)){
                filtrats.afegirMembre(membre);
                afegit=true;
            }
            if(!afegit){
                noAfegits++;
            }
        }
        LlistaMembres llistaFiltrats = new LlistaMembres(membres.getTamany()-noAfegits,0);
        for (int i=0;i<membres.getTamany();i++) {
            Membre membre = membres.getMembres()[i];
            boolean esProfessor = membre.esProfessor();
            boolean esAlumne = membre.esAlumne();
            boolean afegit=false;

            if (inclouProfessors && esProfessor){
                llistaFiltrats.afegirMembre(membre);
                afegit=true;
            }
            if(!afegit && (inclouAlumnes && esAlumne)){
                llistaFiltrats.afegirMembre(membre);
            }
        }
        return llistaFiltrats;
    }


    //Gestió de càrrecs//
    public void assignarPresident (Alumne alumne){
        president=alumne;
    }

    public void assignarSecretari (Alumne alumne){
        secretari=alumne;
    }

    public void assignarTresorer (Alumne alumne){
        tresorer=alumne;
    }

    public boolean verificarCarrecsAssignats (){
        if (president!= null && secretari!=null && tresorer!=null) {
            return true;
        }
        else{
            return false;
        }
    }

    //Altres funcions//

    public String obtenirInformacio() {
        String stringTitulacions = String.join(", ", titulacions);
        Membre[] membres = membresActius.getMembres();
        String stringActius = membres[0].getAlies();
        for(int i = 1; i<membresActius.getTamany();i++){
            stringActius= String.join(stringActius,",\n ", membres[i].getAlies());
        }
        String info = "L'associació " + nom + " té com a correu de contacte " + correuContacte + 
                    " i està formada per alumnes d'aquestes titulacions: " + stringTitulacions + 
                    ". I té els següents membres en actiu:\n" + stringActius;

        return info;
    }
}