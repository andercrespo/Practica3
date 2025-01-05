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

    public void aumentaTamany(){
        tamany++;
    }

    public void setMembres(Membre[] membres){
        this.membres=membres;
    }

    public void afegirMembre(Membre membre) {
        if (tamany == capacitat) {
            capacitat = capacitat * 2;
            Membre[] llistaMembreNova = new Membre[capacitat];
            for (int i = 0; i < tamany; i++) {
                llistaMembreNova[i] = membres[i];
            }
            llistaMembreNova[tamany] = membre;
            membres = llistaMembreNova;
        } else {
            membres[tamany] = membre;
        }
        aumentaTamany();
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
        String[] membresString = new String[tamany];
    
        for (int i = 0; i < tamany; i++) {
            membresString[i]=(membres[i].getAlies());
        }
        String stringMembres = String.join("\n", membresString);
        stringMembres = String.join("Aquesta es la llista de membres:\n ", stringMembres);   
        return stringMembres;
    }
}
