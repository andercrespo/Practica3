import java.time.LocalDate;

public class Membre {

    private String alies;
    private String correu;
    private LocalDate[] dataAlta, dataBaixa = new LocalDate[3];
    private LlistaAssociacio associacions;
    private String[] nomAssociacio;/////////////


    public Membre(String alies, String correu, LocalDate[] dataAlta){
        this.alies = alies;
        this.correu = correu;
        this.dataAlta = dataAlta;
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

    //setters
    public void donarAlta(LocalDate data, String nomAssociacio, LlistaAssociacio llistaAssociacio) {//////////
        for (int i = 0; i < dataAlta.length; i++) {
            if (dataAlta[i] == null) {
                dataAlta[i] = data;
                associacio.afegirMembre(this);
            }
        }
    }

    public void donarBaixa(LocalDate[] data){
        dataBaixa=data;
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

    //potser ferho miranant getter de tamany de llista associacio
    public boolean potAfegirAssociacio(){
        boolean esPotAfegir = false;
        int i= 0;
        while(dataAlta[i] != null && i<=2){
            i++;
        }
        if(i<2){
            esPotAfegir = true;
        }
        return esPotAfegir;
    }

    public void afegirAssociacio(Associacio associacio){
        if(potAfegirAssociacio()==true){
            afegirAssociacio(associacio);
        }
    }
    
    public LlistaAssociacions getAssociacions(){
        return LlistaAssociacions;
    }
}
