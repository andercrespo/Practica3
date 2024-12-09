public class LlistaMembres {
    private Membre[] membres;
    private int tamany, capacitat;

    public LlistaMembres(int capacitat){
        this.capacitat = capacitat;
        membres = new Membre[capacitat];
        tamany = 0;
    }

    public Membre[] getMembres(){
        return membres;
    }

    public int getTamany(){
        return tamany;
    }

    public void afegirMembre(Membre membre){
        if(tamany == capacitat){
            capacitat = capacitat*2;
            Membre[] llistaMembreNova = new Membre[capacitat];
            for(int i=0; i<tamany; i++){
                llistaMembreNova[i] = membres[i];
            }
            llistaMembreNova[tamany + 1] = membre;
        }else{
            membres[tamany + 1] = membre;
        }
        tamany++;
    }

 

    public boolean eliminarMembre(String alies){
        boolean trobat=false;
        int i=0;
        while(trobat==false){
            if(membres[i].getAlies()==alies){
                for(int j=i; j<tamany; j++){
                    membres[j]=membres[j+1];
                }
            trobat=true;
            }
        i++;
        }
        return trobat;
    }

    public Membre buscarMembre(String alies){
        boolean trobat=false;
        int i=0;
        while(trobat==false){
            if(membres[i].getAlies()==alies){
                trobat=true;
            }
        i++;
        }
        return membres[i];
    }

    public Membre[] obtenirMembresActius(){
        Membre[] llistaMembresActius = new Membre[capacitat];
        int j=0;
        for(int i=0; i<tamany; i++){
            if(membres[i].esActiu()){
                llistaMembresActius[j] = membres[i];
                j++;
            }
        }
        return llistaMembresActius;
    }

    String obtenirInformacio() {
        String concatenacio = "";
    
        for (int i = 0; i < tamany; i++) {
            concatenacio += membres[i].getAlies();
            concatenacio += membres[i].getCorreu();
            concatenacio += membres[i].getDataAlta();
            concatenacio += membres[i].getDataBaixa();
        }   
        return concatenacio;
    }
}
