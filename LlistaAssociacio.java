public class LlistaAssociacio {
    private Associacio[] associacions;
    private int capacitat;
    private int tamany;

    //Constructor
    public LlistaAssociacio (int capacitat){
        this.associacions = new Associacio[capacitat];
        this.capacitat= capacitat;
        this.tamany=0;
    }

    public int getTamany(){
        return tamany;
    }

    public Associacio[] getAssociacions(){
        return associacions;
    }

    public void afegirAssociacio(Associacio associacio){
        if(capacitat==tamany){
            capacitat=capacitat*2;
            Associacio[] newAssociacions= new Associacio[capacitat];
            System.arraycopy(associacions, 0, newAssociacions, 0, tamany);
            associacions = newAssociacions;
        }
        int posicio=0;
        while (posicio < tamany && associacions[posicio].getNom().compareTo(associacio.getNom())<0){
            posicio++;
        }
        for (int i = tamany; i > posicio; i--) {
            associacions[i] = associacions[i - 1];
        }
        associacions[tamany] = associacio;
        tamany++;
    }

    public boolean eliminarAssociacio(String nom){
        boolean eliminat = false;
        int i = 0;
        while(!eliminat && i < tamany){
            if(associacions[i].getNom().equalsIgnoreCase(nom)){
                for(int j = i; j < tamany; j++){
                    associacions[j]=associacions[j+1];
                }
                eliminat = true;
            }
            else{
                i++;
            }
        }
        return eliminat;
    }

    public Associacio buscarAssociacio(String nom){
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < tamany){
            if(associacions[i].getNom().equalsIgnoreCase(nom)){
                return associacions[i];
            }
            else{
                i++;
            }
        }
        return null;
    }

    public Associacio[] obtenirAssociacionsAmbTitulacions(String titulacio){
        int contador = 0;
        for (int i = 0; i < tamany; i++) {
            for (String titulacioAssociacio : associacions[i].getTitulacions()){
                if (titulacioAssociacio.equalsIgnoreCase(titulacio)){
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

    public String obtenirInformacio(){
        String[] associacionsString = new String[tamany];
        for(int i=0; i<tamany;i++){
            associacionsString[i]=associacions[i].getNom();
        }
        String stringAssociacions = String.join("\n", associacionsString);
        stringAssociacions = String.join("Aquesta es la llista d'associacions:\n ", stringAssociacions);
        return stringAssociacions;
    }

}
