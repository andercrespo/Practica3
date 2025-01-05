import java.time.LocalDate;

public class Membre {

    private String alies;
    private String correu;
    private LocalDate[] dataAlta, dataBaixa= new LocalDate[3];
    private LlistaAssociacio associacions;
    private String tipus;//Pot ser professor o alumne//


    public Membre(String alies, String correu, LocalDate[] dataAlta, LocalDate[] dataBaixa, LlistaAssociacio associacions, String tipus){
        this.alies = alies;
        this.correu = correu;
        this.dataAlta = dataAlta;
        this.dataBaixa = dataBaixa;
        this.associacions=associacions;
        this.tipus=tipus;
    }

    //getters
    public String getAlies(){
        return alies;
    }

    public String getCorreu(){
        return correu;
    }

    public LocalDate[] getDataAlta(){
        return dataAlta;
    }

    public LocalDate[] getDataBaixa(){
        return dataBaixa;
    }

    public boolean esProfessor() {
        return "Professor".equalsIgnoreCase(tipus);
    }

    public boolean esAlumne() {
        return "Alumne".equalsIgnoreCase(tipus);
    }

    //setters
    public void donarAlta(LocalDate data, String nomAssociacio, LlistaAssociacio llistaAssociacio) {
        Associacio[] associacions=llistaAssociacio.getAssociacions();
        dataAlta[dataAlta.length]=data;
        for (int i = 0; i < llistaAssociacio.getTamany(); i++) {
            if(associacions[i].getNom().equals(nomAssociacio)){
                associacions[i].afegirMembre(this);
                this.associacions.afegirAssociacio(associacions[i]);
            }
        }
    }

    public void donarBaixa(LocalDate data, Associacio associacio){
        boolean trobada=false;
        int index=0;
        int j=0;
        Associacio[] associacionsMembre =associacions.getAssociacions();
        while(!trobada && j<associacionsMembre.length){
            if(associacio.getNom()==associacionsMembre[j].getNom()){
                index=j;
            }
            else{
                j++;
            }
        }
        dataBaixa[index]=data;
    }

    public void setAssociacions(LlistaAssociacio llistaAssociacions){
        this.associacions=llistaAssociacions;
    }

    public boolean esActiu(){
        boolean actiu;
        if(dataBaixa==null){
            actiu = true;
        }else{
            actiu = false;
        }
        return actiu;   
    }

    public boolean potAfegirAssociacio(){
        boolean esPotAfegir=false;
        if(associacions.getTamany()<3){
            esPotAfegir = true;
        }
        return esPotAfegir;
    }

    public void afegirAssociacio(Associacio associacio){
        if(potAfegirAssociacio()==true){
            afegirAssociacio(associacio);
        }
    }
    
    public LlistaAssociacio getAssociacions(){
        return associacions;
    }

    public String obtenirInformacio(){
        return(alies+", "+correu+", "+dataAlta+", "+dataBaixa+", "+associacions+", "+tipus);
    }
}
