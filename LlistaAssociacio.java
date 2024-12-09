public class LlistaAssocicacio {
    private Associacio[] associacions;
    private int capacitat;
    private int tamany;

    //Constructor
    public LlistaAssocicacio(int capacitat){
        this.associacions = new Associacio[capacitat];
        this.capacitat= capacitat;
        this.tamany=0;
    }

    public void afegirAssociacio(Associacio associacio){
        if(capacitat==tamany){
            capacitat=capacitat*2;
            Associacio[] newAssociacions=LlistaAssocicacio(capacitat);
            associacions = newAssociacions;
        }
        int posicio=0;
        while (posicio < tamany && associacions[posicio].getNom().compareTo.(associacio.getNom())<0){
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
                Associacio associacio = associacions[i];
                trobat = true;
            }
            else{
                i++
            }
        }
        return associacio;
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
        String stringAssociacions = String.join(",\n ", associacions);
        System.out.println("Aquesta es la llista d'associacions:\n"+ stringAssociacions);
    }
}
