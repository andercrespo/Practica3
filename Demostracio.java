import java.time.LocalDate;

public class Demostracio extends Accio {
    private LocalDate[] dataDisseny=new LocalDate[3];
    private boolean esValida;
    private int nombreVegadesOfertes;
    private double costMaterials;

    //Constructor//
    public Demostracio(String codi, String titol,Associacio[] associacionsOrganitzadores, Membre responsable, String tipus, LocalDate[] dataDisseny, boolean esValida, int nombreVegadesOfertes, double costMaterials){
        super(codi, titol, associacionsOrganitzadores, responsable, tipus);
        this.dataDisseny = dataDisseny;
        this.esValida = esValida;
        this.nombreVegadesOfertes = nombreVegadesOfertes;
        this.costMaterials = costMaterials;
    }

    public void marcarComNoValida(){
        esValida = false;    
    }

    public boolean esValida(){
        return esValida;
    }

    public void incerementarNombreVegadesOfertes(){
        nombreVegadesOfertes = nombreVegadesOfertes+1;
    }

    public double obtenirCostTotal(){
        return costMaterials;
    }

    public String obternirInformacioDetallada(){
        String informacio = "La demostració dissenyada el "+dataDisseny+" te un cost de "+costMaterials+" i la seua validesa es: "+esValida;
        return informacio;
    }

}
