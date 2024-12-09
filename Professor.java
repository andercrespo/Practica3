import java.time.LocalDate;

public class Professor extends Membre{
    private String departament;
    private int despatx;

    public Professor(String alies, String correu, LocalDate[] dataAlta, LocalDate[] dataBaixa, LlistaAssociacio associacions, String tipus, String departament, int despatx){
        super(alies, correu, dataAlta, dataBaixa,associacions,tipus);
        this.departament = departament;
        this.despatx = despatx;
    }

    public String getDepartament(){
        return departament;
    }

    public int getDespatx(){
        return despatx;
    }

    public void setDepartament(String departament){
        if(departament == "DEIM" || departament == "DEEEA"){
            this.departament = departament;
        }else{
            System.out.println("El departament nomes pot ser DEIM o DEEEA");
        }
        
    }

    public String toString(Membre membre){
        return "Professor:" + membre.getAlies() + ", correu:" + membre.getCorreu() + ", departament:" + departament
				+ "despatx:" + despatx;
    }

}
