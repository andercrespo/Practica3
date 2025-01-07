import java.time.LocalDate;

public class Xerrada extends Accio {
    private LocalDate dataRealitzacio;
    private int nombreAssistents;
    private int[] valoracions;
    private Membre[] impartidors;

    private int numImpartidors;
    private int numValoracions;

    public Xerrada(String codi, String titol,Associacio[] associacionsOrganitzadores, Membre responsable, String tipus, LocalDate dataRealitzacio, int nombreAssistents, int[] valoracions, Membre[] impartidors) {
        super(codi, titol, associacionsOrganitzadores, responsable, tipus);
        this.dataRealitzacio = dataRealitzacio;
        this.nombreAssistents = nombreAssistents;
        if(valoracions==null){
            this.valoracions=null;
        }else{
            this.valoracions = valoracions;
        }
        this.impartidors = (impartidors != null) ? impartidors : new Membre[0]; // Evita null
        this.numImpartidors = impartidors.length;
        if(valoracions==null){
            this.numValoracions=0;
        }else{
            this.numValoracions = valoracions.length;
        }
    }

    public LocalDate obtenirDataRealitzacio() {
        return dataRealitzacio;
    }

    public int getNumValoracions(){
        return numValoracions;
    }

    public Membre[] getImpartidors(){
        return impartidors;
    }

    public static Xerrada[] obtenirXerrades() {
        int nXerrades = 0;
        Xerrada[] xerrades = new Xerrada[nXerrades];
        return xerrades;
    }

    public int obtenirNombreAssistents() {
        return nombreAssistents;
    }

    public void afegirImpartidor(Membre impartidor) {
        if (numImpartidors < 3) {
            impartidors[numImpartidors+1] = impartidor;
        } else {
            System.out.println("No es poden afegir més impartidors, ja n'hi ha 3.");
        }
    }

    public void registrarAssistents(int nombre) {
        this.nombreAssistents = nombre;
    }

    public void afegirValoracio(int valoracio) {
        if (valoracio >= 0 && valoracio <= 10) {
            if (numValoracions >= valoracions.length) {
                int[] nouValoracions = new int[valoracions.length + 1];
                System.arraycopy(valoracions, 0, nouValoracions, 0, valoracions.length);
                valoracions = nouValoracions;
            }
            valoracions[numValoracions++] = valoracio;
        }
    }
    

    public double obtenirMitjanaValoracions() {
        if (numValoracions == 0) return 0;
        double mitjana = 0;
        for (int i = 0; i < numValoracions; i++) {
            mitjana += valoracions[i];
        }
        return mitjana / numValoracions;
    }

    public int obtenirValoracionsTotals() {
        return numValoracions;
    }

    public String obtenirInformacioDetallada() {
        String info = "El nombre d'impartidors és " + numImpartidors + ", " +
                      "el nombre d'assistents és " + nombreAssistents + " i " +
                      "el nombre de valoracions és " + obtenirValoracionsTotals();
        return info;
    }

    public String guardarFitxer(){
        String vals="";
        String imp="";
        if(valoracions==null){
            if(impartidors==null){
                return(super.guardarFitxer()+dataRealitzacio+";"+nombreAssistents+";null;null");
            }
            else{
                for(int i=0;i<impartidors.length;i++){
                    imp=imp+impartidors[i].getAlies();
                    if(i!=(impartidors.length-1)){
                        imp=imp+"/";
                    }
                }
                return(super.guardarFitxer()+dataRealitzacio+";"+nombreAssistents+";null;"+imp);
            }
        }else{
            for(int i=0;i<valoracions.length;i++){
                vals=vals+valoracions[i];
                if(i!=(valoracions.length-1)){
                    vals=vals+"/";
                }
            }
            if(impartidors==null){
                return(super.guardarFitxer()+dataRealitzacio+";"+nombreAssistents+";"+vals+";"+"null");
            }
            else{
                for(int i=0;i<impartidors.length;i++){
                    imp=imp+impartidors[i].getAlies();
                    if(i!=(impartidors.length-1)){
                        imp=imp+"/";
                    }
                }
            }
            
        }
        return(super.guardarFitxer()+dataRealitzacio+";"+nombreAssistents+";"+vals+";"+imp);
    }
}