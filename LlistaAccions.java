import java.time.LocalDate;

public class LlistaAccions {
    private Accio[] accions;
    private int tamany;
    private int capacitat;

    public LlistaAccions(int capacitatInicial) {
        this.capacitat = capacitatInicial;
        this.accions = new Accio[capacitatInicial];
        this.tamany = 0;
    }


    public void afegirAccio(Accio accio) {
        if (tamany == capacitat) {
            Accio[] nouArray = new Accio[capacitat * 2];
            for (int i = 0; i < tamany; i++) {
                nouArray[i] = accions[i];
            }
            accions = nouArray;
        }
        accions[tamany] = accio;
        tamany++;
    }

    public boolean eliminarAccio(String codi) {
        for (int i = 0; i < tamany; i++) {
            if (accions[i].obtenirCodi().equals(codi)) {
                accions[i] = accions[tamany - 1]; 
                accions[tamany - 1] = null; 
                tamany--;
                return true;
            }
        }
        return false;
    }

    public Accio[] obtenirDemostracionsValides() {
        Accio[] demostracionsValides=new Accio[accions.length];
        int j=0;
        for(int i=0;i<accions.length;i++){
            Accio accio = accions[i];
            if (accio instanceof Demostracio) {
                Demostracio demostracio = (Demostracio) accio;
                if (demostracio.esValida()) { 
                    demostracionsValides[j]=accio;
                    j++;
                }
            }
        }
        return demostracionsValides;
    }

    public Accio[] obtenirXerradesEntreDates(LocalDate inici, LocalDate fi) {
        int comptador = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i] instanceof Xerrada) {
                Xerrada xerrada = (Xerrada) accions[i];
                if (xerrada.obtenirDataRealitzacio().isAfter(inici.minusDays(1)) && 
                    xerrada.obtenirDataRealitzacio().isBefore(fi.plusDays(1))) {
                    comptador++;
                }
            }
        }
    
        Accio[] resultats = new Accio[comptador];
        int index = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i] instanceof Xerrada) {
                Xerrada xerrada = (Xerrada) accions[i];
                if (xerrada.obtenirDataRealitzacio().isAfter(inici.minusDays(1)) && 
                    xerrada.obtenirDataRealitzacio().isBefore(fi.plusDays(1))) {
                        resultats[index++] = accions[i];
                }
            }
        }
        return resultats;
    }

    public String obtenirInformacio() {
        String resultat = ""; 
        for (int i = 0; i < tamany; i++) {
            resultat = resultat + accions[i].toString() + "\n";            
        }
        return resultat;
    }


}
