import java.time.LocalDate;

public class Demostracio extends Accio {
    private LocalDate dataDisseny;
    private boolean esValida;
    private int nombreVegadesOfertes;
    private double costMaterials;

    //Constructor//
    public Demostracio(LocalDate dataDisseny, boolean esValida, int nombreVegadesOfertes, double costMaterials){
        super(codi, titol, associacionsOrganitzadores, responsable);
        this.dataDisseny = dataDisseny;
        this.esValida = esValida;
        this.nombreVegadesOfertes = nombreVegadesOfertes;
        this.costMaterials = costMaterials;
    }

    public void marcarComNoValida(){
        esValida = false;    
    }

    public void incerementarNombreVegadesOfertes(){
        nombreVegadesOfertes++;
    }

    public double obtenirCostTotal(){
        return costMaterials;
    }

    public String obternirInformacioDetallada(){
        String informacio = "La demostració dissenyada el "+dataDisseny+" te un cost de "+costMaterials+" i la seua validesa es: "+esValida;
        return informacio;
    }

}
