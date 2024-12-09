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
        if (tamany == accions.length) {
            Accio[] nouArray = new Accio[accions.length * 2];
        for (int i = 0; i < accions.length; i++) {
            nouArray[i] = accions[i];
        }
        accions = nouArray;
        }
        accions[tamany++] = accio;
    }

    public boolean eliminarAccio(String codi) {
        for (int i = 0; i < tamany; i++) {
            if (accions[i].getCodi().equals(codi)) {
                accions[i] = accions[tamany - 1]; 
                accions[tamany - 1] = null; 
                tamany--;
                return true;
            }
        }
        return false;
    }
    public Accio[] obtenirDemostracionsValides() {
        int comptador = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i].esDemostracioValida()) {
                comptador++;
            }
        }
        Accio[] resultats = new Accio[comptador];
        int index = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i].esDemostracioValida()) {
                resultats[index++] = accions[i];
            }
        }
        return resultats;
    }

    public Accio[] obtenirXerradesEntreDates(LocalDate inici, LocalDate fi) {
        int comptador = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i].esXerrada() && accions[i].getData().isAfter(inici.minusDays(1)) && accions[i].getData().isBefore(fi.plusDays(1))) {
                comptador++;
            }
        }
        Accio[] resultats = new Accio[comptador];
        int index = 0;
        for (int i = 0; i < tamany; i++) {
            if (accions[i].esXerrada() && accions[i].getData().isAfter(inici.minusDays(1)) && accions[i].getData().isBefore(fi.plusDays(1))) {
                resultats[index++] = accions[i];
            }
        }
        return resultats;
    }      
    public String obtenirInformacio(){
        public String obtenirInformacio() {
            String resultat = ""; 
            for (int i = 0; i < tamany; i++) {
                resultat = resultat + accions[i].toString() + "\n";            }
            return resultat;
        }
        
    }


}
