public class Professor {
    private String departament;
    private int despatx;

    public Professor(String departament, int despatx){
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

