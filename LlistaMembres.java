public class LlistaMembres {
    private Membre[] membres;
    private int tamany, capacitat;

    public LlistaMembres(int capacitat,int tamany){
        this.capacitat = capacitat;
        membres = new Membre[capacitat];
        this.tamany=tamany;
    }

    public Membre[] getMembres(){
        return membres;
    }

    public int getTamany(){
        return tamany;
    }

    public void buidarLlista(){
        this.membres=new Membre[capacitat];
        this.tamany=0;
    }

    public void aumentaTamany(){
        tamany++;
    }

    public void setMembres(Membre[] membres){
        this.membres=membres;
    }

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
        tamany--;
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

    public String obtenirInformacio() {
        String[] membresString = new String[membres.length];
    
        for (int i = 0; i < membres.length; i++) {
            if (membres[i] != null) {
                membresString[i] = membres[i].getAlies();
            }
        }
        String stringMembres = String.join("\n", membresString);
        stringMembres ="Aquesta es la llista de membres:\n " + stringMembres;   
        return stringMembres;
    }
    
}
