import java.time.LocalDate;

public class Associacio {
    private String nom;
    private String correuContacte;
    private String titulacions[];
    private LlistaMembres membres;
    private LlistaMembres membresActius;
    private Alumne president;
    private Alumne secretari;
    private Alumne tresorer;

    //Constructor//
    public Associacio (String nom,String correuContacte, String[] titulacions, LlistaMembres membres, LlistaMembres membresActius, Alumne president, Alumne secretari, Allumne tresorer){
        this.nom=nom;
        this.correuContacte=correuContacte;
        this.titulacions=titulacions;
        this.membres=membres;
        this.membresActius=membresActius;
        this.president=president;
        this.secretari=secretari;
        this.tresorer=tresorer;

    }

    //Getters//
    public String getNom(){
        return nom;
    }

    public String[] getTitulacions(){
        return titulacions;
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
            titulacions[titulacions.length]=titulacio;
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
        membres[tamany]=membre;
        if(membre.getDataBaixa()==null){
            membresActius[tamany]=membre;
        }
    }

    public void donarDeBaixaMembre(Membre membre, LocalDate dataBaixa){
        int i=0;
        boolean trobat = false;
        while(!trobat){
            if(membres[i]==membre){
                trobat=true;
            }
            else{
                i++;
            }
        }
        for(int j=i;j<tamany;j++){
            membres[j]=membres[j+1];
        }
        membre.dataBaixa=donarBaixa(dataBaixa);
    }

    public LlistaMembres obtenirMembresActius(){
        Membre[] llistaMembresActius = new Membre[capacitat];
        int j=0;
        for(int i=0; i<tamany;i++){
            if(membres[i].esActiu()){
                llistaMembresActius[j]=membres[i];
                j++;
            }
        }
        return llistaMembresActius;
    }

    public LlistaMembres obtenirMembresFiltrats(boolean inclouProfessors,boolean inclouAlumnes){
        Membre[] llistaMembresFiltrats = new Membre[capacitat];
        int j=0;
        for(int i=0; i<tamany;i++){
            if(inclouProfessors==true && inclouAlumnes==true){
                if(membres[i].esProfessor() && membres[i].esAlumne()){
                    llistaMembresFiltrats[j]=membres[i];
                    j++;
                }
            }
            if(inclouProfessors==false && inclouAlumnes==true){
                if(!membres[i].esProfessor() && membres[i].esAlumne()){
                    llistaMembresFiltrats[j]=membres[i];
                    j++;
                }
            }
            if(inclouProfessors==true && inclouAlumnes==false){
                if(membres[i].esProfessor() && !membres[i].esAlumne()){
                    llistaMembresFiltrats[j]=membres[i];
                    j++;
                }
            }
            //Si se pot estar a una associacio sense ser professor o alumne deixar el if seguent sino llevarlo//
            if(inclouProfessors==false && inclouAlumnes==false){
                if(membres[i].esProfessor() && membres[i].esAlumne()){
                    llistaMembresFiltrats[j]=membres[i];
                    j++;
                }
            }
        }
        return llistaMembresFiltrats;
    }

    public static boolean identificarMembre(Membre membre) {
        if (membre instanceof Professor) {
            return true;
        }
        else{
            return false;
        }
    }


    public boolean esAlumne(Membre membre){
        if (membre instanceof Alumne) {
            return true;
        }
        else{
            return false;
        }
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
    public String obtenirInformacio (){
        String stringTitulacions = String.join(", ", titulacions);
        String stringActius = String.join(", ", membresActius);
        System.out.println("L'associació"+ nom +" ,té com a correu de contacte"+ correuContacte +" i esta formada per alumnes d'aquestes titulacions:"+ stringTitulacions +". I té els seguents membres en actiu:\n"+ stringActius);
    }
}