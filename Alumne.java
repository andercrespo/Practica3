import java.time.LocalDate;

public class Alumne extends Membre {

    String ensenyament;
    int anysETSE;
    boolean graduat;
    
    // Constructor 
    public Alumne(String alies, String correu, LocalDate dataAlta, String ensenyament, int anysETSE, boolean graduat){
        super(alies, correu, dataAlta);
        this.ensenyament = ensenyament;
        this.anysETSE = anysETSE;
        this.graduat = graduat;
    }

    // ?????
    public String getEnsenyament(){
        return ensenyament;
    }

    public int getAnysETSE(){
        return anysETSE;
    }

    public boolean esGraduat(){
        return graduat;
    }

    public void setGraduat(boolean graduat){
        this.graduat = graduat;
    }

    public String toString() {
        return "Membre {" + "Àlies='" + getAlies() + '\'' + ", Correu='" + getCorreu() + '\'' + ", Ensenyament='" + getEnsenyament() + '\'' + '}';
    }

}

