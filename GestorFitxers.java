import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class GestorFitxers {

    public static void guardarFitxerText(String nomFitxer, LlistaMembres llistaMembres,LlistaAccions llistaAccions) {
        if (nomFitxer == null || nomFitxer.trim().isEmpty()) {
            System.out.println("El nom del fitxer no és vàlid.");
            return;
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFitxer))) {
            if ("alumnes.txt".equalsIgnoreCase(nomFitxer)) {
                if (llistaMembres != null && llistaMembres.getMembres() != null) {
                    for (Membre membre : llistaMembres.getMembres()) {
                        if (membre != null) {
                            Alumne alumne = (Alumne) membre;
                            writer.write(alumne.guardarFitxer()); // Retorna els atributs separats per ';'
                            writer.newLine();
                        }
                    }
                }
            } else if ("professors.txt".equalsIgnoreCase(nomFitxer)) {
                if (llistaMembres != null && llistaMembres.getMembres() != null) {
                    for (Membre membre : llistaMembres.getMembres()){
                        if ((membre != null) && (membre.esProfessor())) {
                            Professor professor = (Professor) membre;
                            writer.write(professor.guardarFitxer()); // Retorna els atributs separats per ';'
                            writer.newLine();
                        }
                    }
                }
            }else if ("accions.txt".equalsIgnoreCase(nomFitxer)) {
                if (llistaAccions != null && llistaAccions.getAccions() != null) {
                    for (Accio accio : llistaAccions.getAccions()) {
                        if (accio != null) {
                            writer.write(accio.toString()); // Retorna els atributs separats per ';'
                            writer.newLine();
                        }
                    }
                }
            } else {
                System.out.println("El nom del fitxer no és vàlid.");
            }
        } catch (IOException e) {
            System.err.println("Error escrivint al fitxer: " + e.getMessage());
        }
    }

    public static void llegirLlistaAssociacionsDesSerialitzat(LlistaAssociacio[] llista) {
        ObjectInputStream inputFile;
        try {
            inputFile = new ObjectInputStream(new FileInputStream("associacions.ser"));
            for (int i = 0; i < llista.length; i++) {
                llista[i] = (LlistaAssociacio) inputFile.readObject();
            }
            inputFile.close();
            System.out.println("Les associacions s'han carregat correctament des del fitxer: associacions.ser");
        } catch (IOException e) {
            System.out.println("Error en l'arxiu d'entrada: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Error, no es troba la classe LlistaAssociacio: " + e.getMessage());
            } catch (ClassCastException e) {
                System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe LlistaAssociacio: " + e.getMessage());
            }
    }


    public static void guardarLlistaAssociacionsASerialitzat(LlistaAssociacio[] llista) {
        ObjectOutputStream outputFile;
        try {
            outputFile = new ObjectOutputStream(new FileOutputStream("associacions.ser"));
            for (int i = 0; i < llista.length; i++) {
                outputFile.writeObject(llista[i]);
            }
            outputFile.close();
            System.out.println("Les associacions s'han guardat correctament al fitxer: associacions.ser");
        } catch (IOException e) {
            System.out.println("Error en l'arxiu de sortida: " + e.getMessage());
        }
    }
    
    
    public static void llegirFitxerText(String nomFitxer, LlistaMembres llistaMembres, LlistaAccions llistaAccions, LlistaAssociacio llistaAssociacio) {
        try (BufferedReader lector = new BufferedReader(new FileReader(nomFitxer))) {
            String linia;
            while ((linia = lector.readLine()) != null) {
                String[] dades = linia.split(";"); // Separar els atributs per ';'

                // Processar dades segons el fitxer
                if (nomFitxer.equalsIgnoreCase("alumnes.txt")) {
                    processarAlumne(dades, llistaMembres);
                } else if (nomFitxer.equalsIgnoreCase("professors.txt")) {
                    processarProfessor(dades, llistaMembres);
                }else if (nomFitxer.equalsIgnoreCase("xerrades.txt")) {
                    processarXerrada(dades, llistaAccions, llistaMembres);
                } else if (nomFitxer.equalsIgnoreCase("demostracions.txt")) {
                    processarDemostracio(dades,llistaAccions, llistaMembres);
                }else if (nomFitxer.equalsIgnoreCase("associacions.txt")) {
                    processarAssociacio(dades, llistaAssociacio, llistaMembres);
                }
            } 
        }catch (IOException e) {
            System.err.println("Error al llegir el fitxer: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al processar dades numèriques: " + e.getMessage());
        }
    }
    public static void processarAlumne(String[] dades, LlistaMembres llistaMembres) {
        String alies = dades[0];
        String correu = dades[1];

        String[] datesAlta = dades[2].split("/");
        LocalDate dataAlta1= null;
        if(!"null".equalsIgnoreCase(datesAlta[0])){
            dataAlta1 = LocalDate.parse(datesAlta[0]);
        }
        LocalDate dataAlta2= null;
        if(!"null".equalsIgnoreCase(datesAlta[1])){
            dataAlta2 = LocalDate.parse(datesAlta[1]);
        }
        LocalDate dataAlta3= null;
        if(!"null".equalsIgnoreCase(datesAlta[2])){
            dataAlta3 = LocalDate.parse(datesAlta[2]);
        }
        LocalDate[] dataAlta ={dataAlta1,dataAlta2,dataAlta3};

        String[] datesBaixa = dades[3].split("/");
        LocalDate dataBaixa1= null;
        if(!"null".equalsIgnoreCase(datesBaixa[0])){
            dataBaixa1 = LocalDate.parse(datesBaixa[0]);
        }
        LocalDate dataBaixa2= null;
        if(!"null".equalsIgnoreCase(datesBaixa[1])){
            dataBaixa2 = LocalDate.parse(datesBaixa[1]);
        }
        LocalDate dataBaixa3= null;
        if(!"null".equalsIgnoreCase(datesBaixa[2])){
            dataBaixa3 = LocalDate.parse(datesBaixa[2]);
        }
        LocalDate[] dataBaixa ={dataBaixa1,dataBaixa2,dataBaixa3};

        LlistaAssociacio associacions = null; // Placeholder
        String tipus = dades[5];
        String ensenyament = dades[6];
        int anysETSE = Integer.parseInt(dades[7]);
        boolean graduat = Boolean.parseBoolean(dades[8]);

        Alumne alumne = new Alumne(alies, correu, dataAlta, dataBaixa, associacions, tipus, ensenyament, anysETSE, graduat);
        llistaMembres.afegirMembre(alumne);
    }

    public static void processarProfessor(String[] dades, LlistaMembres llistaMembres) {
        String alies = dades[0];
        String correu = dades[1];

        String[] datesAlta = dades[2].split("/");
        LocalDate dataAlta1= null;
        if(!"null".equalsIgnoreCase(datesAlta[0])){
            dataAlta1 = LocalDate.parse(datesAlta[0]);
        }
        LocalDate dataAlta2= null;
        if(!"null".equalsIgnoreCase(datesAlta[1])){
            dataAlta2 = LocalDate.parse(datesAlta[1]);
        }
        LocalDate dataAlta3= null;
        if(!"null".equalsIgnoreCase(datesAlta[2])){
            dataAlta3 = LocalDate.parse(datesAlta[2]);
        }
        LocalDate[] dataAlta ={dataAlta1,dataAlta2,dataAlta3};

        String[] datesBaixa = dades[3].split("/");
        LocalDate dataBaixa1= null;
        if(!"null".equalsIgnoreCase(datesBaixa[0])){
            dataBaixa1 = LocalDate.parse(datesBaixa[0]);
        }
        LocalDate dataBaixa2= null;
        if(!"null".equalsIgnoreCase(datesBaixa[1])){
            dataBaixa2 = LocalDate.parse(datesBaixa[1]);
        }
        LocalDate dataBaixa3= null;
        if(!"null".equalsIgnoreCase(datesBaixa[2])){
            dataBaixa3 = LocalDate.parse(datesBaixa[2]);
        }
        LocalDate[] dataBaixa ={dataBaixa1,dataBaixa2,dataBaixa3};

        LlistaAssociacio associacions = null; // Placeholder
        String tipus = dades[5];
        String departament = dades[6];
        int despatx = Integer.parseInt(dades[7]);

        Professor professor = new Professor(alies, correu, dataAlta, dataBaixa, associacions, tipus, departament, despatx);
        llistaMembres.afegirMembre(professor);
    }

    public static void processarXerrada(String[] dades, LlistaAccions llistaAccions, LlistaMembres llistaMembres) {
        String codi = dades[0];
        String titol = dades[1];
        Associacio[] associacionsOrganitzadores = null;//placeholder

        String nomResponsable = dades[3];
        Membre[] llistaMembre = llistaMembres.getMembres();
        int i = 0;
        boolean trobat = false;
        Membre responsable = null;
        while (!trobat && i < llistaMembre.length) {
            if (llistaMembre[i] != null && nomResponsable.equalsIgnoreCase(llistaMembre[i].getAlies())) {
                responsable = llistaMembre[i];
                trobat = true;
            } else {
                i++;
            }
        }
        if (!trobat) {
            System.err.println("Error: No s'ha trobat cap membre amb l'àlies especificat.");
        }

        String tipus = dades[4];
        LocalDate dataRealitzacio =null;
        if(!"null".equalsIgnoreCase(dades[5])){
            dataRealitzacio = LocalDate.parse(dades[5]);
        }
        int nombreAssistents = Integer.parseInt(dades[6]);

        String[] stringValoracions = dades[7].split("/");
        int[] valoracions= new int[stringValoracions.length];
        for(int j =0;j<stringValoracions.length;j++){
            int valj = Integer.parseInt(stringValoracions[j]);
            valoracions[j]=valj;
        }
        
        String[] stringImpartidors = dades[8].split("/");
        Membre[] impartidors = new Membre[stringImpartidors.length];

        for (int l = 0; l < stringImpartidors.length; l++) {
            String nomImpartidorl = stringImpartidors[l];
            int k = 0;
            boolean trobat2 = false;
            while (!trobat2 && k < llistaMembre.length) {
                if (llistaMembre[k] != null && nomImpartidorl.equalsIgnoreCase(llistaMembre[k].getAlies())) {
                    impartidors[l] = llistaMembre[k];
                    trobat2 = true;
                } else {
                    k++;
                }
            }
            if (!trobat2) {
                System.err.println("Advertència: No s'ha trobat cap membre amb l'àlies: " + nomImpartidorl);
            }
        }

        Xerrada xerrada = new Xerrada(codi, titol, associacionsOrganitzadores, responsable, tipus, dataRealitzacio, nombreAssistents, valoracions, impartidors);
        llistaAccions.afegirAccio(xerrada);
    }

    public static void processarDemostracio(String[] dades, LlistaAccions llistaAccions, LlistaMembres llistaMembres) {
        String codi = dades[0];
        String titol = dades[1];
        Associacio[] associacionsOrganitzadores = null;//placeholder

        String nomResponsable = dades[3];
        Membre[] llistaMembre = llistaMembres.getMembres();
        int i = 0;
        boolean trobat = false;
        Membre responsable = null;
        while (!trobat && i < llistaMembre.length) {
            if (llistaMembre[i] != null && nomResponsable.equalsIgnoreCase(llistaMembre[i].getAlies())) {
                responsable = llistaMembre[i];
                trobat = true;
            } else {
                i++;
            }
        }
        if (!trobat) {
            System.err.println("Error: No s'ha trobat cap membre amb l'àlies especificat.");
        }
        String tipus = dades[4];
        LocalDate dataDisseny = LocalDate.parse(dades[5]);
        boolean esValida = Boolean.parseBoolean(dades[6]);
        int nombreVegadesOfertes = Integer.parseInt(dades[7]);
        double costMaterials = Double.parseDouble(dades[8]);
        Demostracio demostracio = new Demostracio(codi, titol, associacionsOrganitzadores, responsable, tipus, dataDisseny, esValida, nombreVegadesOfertes, costMaterials);
        llistaAccions.afegirAccio(demostracio);
    }

    public static void processarAssociacio(String[] dades, LlistaAssociacio llistaAssociacio, LlistaMembres llistaMembres){
        String nom = dades [0];
        String correuContacte = dades[1];

        String[] stringMembres = dades[2].split("/");
        Membre[] llistaMembre = llistaMembres.getMembres();
        Membre[] membres = new Membre[stringMembres.length];

        for (int i = 0; i < stringMembres.length; i++) {
            String nomMembrei = stringMembres[i];
            int j = 0;
            boolean trobat = false;
            while (!trobat && j < llistaMembre.length) {
                if (llistaMembre[j] != null && nomMembrei.equalsIgnoreCase(llistaMembre[j].getAlies())) {
                    membres[i] = llistaMembre[j];
                    trobat = true;
                } else {
                    j++;
                }
            }

            if (!trobat) {
                System.err.println("Advertència: No s'ha trobat cap membre amb l'àlies: " + nomMembrei);
            }
        }

        String[] stringMembresActius = dades[3].split("/");
        Membre[] membresActius = new Membre[stringMembresActius.length];
        for (int i = 0; i < stringMembresActius.length; i++) {
            String nomMembrei = stringMembresActius[i];
            int j = 0;
            boolean trobat = false;
            while (!trobat && j < llistaMembre.length) {
                if (llistaMembre[j] != null && nomMembrei.equalsIgnoreCase(llistaMembre[j].getAlies())) {
                    membresActius[i] = llistaMembre[j];
                    trobat = true;
                } else {
                    j++;
                }
            }

            if (!trobat) {
                System.err.println("Advertència: No s'ha trobat cap membre amb l'àlies: " + nomMembrei);
            }
        }

        String[] titulacions = new String[0];
        int numTitulacions=0;
        for(int k=0;k<membres.length;k++){
            if(membres[k].esAlumne()){
                Alumne membrek = (Alumne) membres[k];
                String titulaciok= membrek.getEnsenyament();
                boolean trobat=false;
                int i=0;
                while(i<titulacions.length && !trobat){
                    if(titulaciok==titulacions[i]){
                        trobat=true;
                    }
                    else{
                    i++;
                }
                }
                if(!trobat){
                    numTitulacions = titulacions.length;
                    String[] nouArray = new String[titulacions.length + 1];
                    System.arraycopy(titulacions, 0, nouArray, 0, titulacions.length);
                    titulacions = nouArray;
                }
                titulacions[numTitulacions] = titulaciok;
            }
        }

        String nomPresident = dades[4];
        int i=0;
        boolean trobat = false;
        Alumne president=null;
        if(llistaMembre[i] != null){
            while(!trobat && i<llistaMembre.length){
                if(nomPresident.equalsIgnoreCase(llistaMembre[i].getAlies())){
                    president = (Alumne) llistaMembre[i];
                    trobat=true;
                }
                else{
                    i++;
                }
            }
        }
        
        String nomSecretari = dades[5];
        int j=0;
        boolean trobat2 = false;
        Alumne secretari = null;
        if(llistaMembre[j] != null){
            while(!trobat2 && j<llistaMembre.length){
                if(nomSecretari.equalsIgnoreCase(llistaMembre[j].getAlies())){
                    secretari = (Alumne) llistaMembre[j];
                    trobat2=true;
                }
                else{
                    j++;
                }
            }
        }

        String nomTresorer = dades[6];
        int l=0;
        boolean trobat3 = false;
        Alumne tresorer = null;
        if(llistaMembre[l] != null){
            while(!trobat3 && l<llistaMembre.length){
                if(nomTresorer.equalsIgnoreCase(llistaMembre[l].getAlies())){
                    tresorer = (Alumne) llistaMembre[l];
                    trobat3=true;
                }
                else{
                    l++;
                }
            }
        }

        LlistaMembres llistamembres= new LlistaMembres(100, membres.length);
        llistamembres.setMembres(membres);
        LlistaMembres llistamembresActius= new LlistaMembres(100, membres.length);
        llistamembresActius.setMembres(membresActius);
        
        Associacio associacio = new Associacio(nom, correuContacte, titulacions, llistamembres, llistamembresActius, president, secretari, tresorer);
        llistaAssociacio.afegirAssociacio(associacio);
    }
    //
    public static void revisarLlistaMembre(LlistaMembres llistaMembres, LlistaAssociacio llistaAssociacio) {
        for(int i=0;i<llistaMembres.getTamany();i++){
            Membre membre = llistaMembres.getMembres()[i];
            if(membre.esAlumne()){
                Alumne alumne = (Alumne) membre;
                try (BufferedReader lector = new BufferedReader(new FileReader("alumnes.txt"))) {
                    String linia;
                    while ((linia = lector.readLine()) != null) {
                        String[] dades = linia.split(";");
                        if (dades[0].equalsIgnoreCase(alumne.getAlies())) {
                            String[] associacionsMembre = dades[4].split("/");
                            Associacio[] llistAssociacions = llistaAssociacio.getAssociacions();
                            Associacio ass1=null;
                            int j =0;
                            boolean trobada=false;
                            while(!trobada && j<llistaAssociacio.getTamany()){
                                if(llistAssociacions[j].getNom().equalsIgnoreCase(associacionsMembre[0])){
                                    ass1=llistAssociacions[j];
                                    trobada=true;
                                }
                                else{
                                    j++;
                                }
                            }
                            Associacio ass2=null;
                            j =0;
                            trobada=false;
                            while(!trobada && j<llistaAssociacio.getTamany()){
                                if(llistAssociacions[j].getNom().equalsIgnoreCase(associacionsMembre[1])){
                                    ass2=llistAssociacions[j];
                                    trobada=true;
                                }
                                else{
                                    j++;
                                }
                            }
                            Associacio ass3=null;
                            j =0;
                            trobada=false;
                            while(!trobada && j<llistaAssociacio.getTamany()){
                                if(llistAssociacions[j].getNom().equalsIgnoreCase(associacionsMembre[2])){
                                    ass3=llistAssociacions[j];
                                    trobada=true;
                                }
                                else{
                                    j++;
                                }
                            }
                            Associacio[] associacions = {ass1,ass2,ass3};
                            LlistaAssociacio llistaAssAlumne = new LlistaAssociacio(associacions.length);
                            llistaAssAlumne.setAssociacions(associacions);
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error al llegir el fitxer: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Error al processar dades numèriques: " + e.getMessage());
                }
            }
        }
        for (int i = 0; i < llistaMembres.getTamany(); i++) {
            Membre membre = llistaMembres.getMembres()[i];
            if (membre.esProfessor()) {
                Professor professor = (Professor) membre;
                try (BufferedReader lector = new BufferedReader(new FileReader("professors.txt"))) {
                    String linia;
                    while ((linia = lector.readLine()) != null) {
                        String[] dades = linia.split(";");
                        if (dades[0].equalsIgnoreCase(professor.getAlies())) {
                            String[] associacionsMembre = dades[4].split("/");
                            Associacio[] llistAssociacions = llistaAssociacio.getAssociacions();
                            Associacio ass1=null;
                            int j =0;
                            boolean trobada=false;
                            while(!trobada && j<llistaAssociacio.getTamany()){
                                if(llistAssociacions[j].getNom().equalsIgnoreCase(associacionsMembre[0])){
                                    ass1=llistAssociacions[j];
                                    trobada=true;
                                }
                                else{
                                    j++;
                                }
                            }
                            Associacio ass2=null;
                            j =0;
                            trobada=false;
                            while(!trobada && j<llistaAssociacio.getTamany()){
                                if(llistAssociacions[j].getNom().equalsIgnoreCase(associacionsMembre[1])){
                                    ass2=llistAssociacions[j];
                                    trobada=true;
                                }
                                else{
                                    j++;
                                }
                            }
                            Associacio ass3=null;
                            j =0;
                            trobada=false;
                            while(!trobada && j<llistaAssociacio.getTamany()){
                                if(llistAssociacions[j].getNom().equalsIgnoreCase(associacionsMembre[2])){
                                    ass3=llistAssociacions[j];
                                    trobada=true;
                                }
                                else{
                                    j++;
                                }
                            }
                            Associacio[] associacions = {ass1,ass2,ass3};
                            LlistaAssociacio llistaAssProfessor = new LlistaAssociacio(associacions.length);
                            llistaAssProfessor.setAssociacions(associacions);
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error al llegir el fitxer: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Error al processar dades numèriques: " + e.getMessage());
                }
            }
        }
    }

    public static void revisarLlistaAccio (LlistaAccions llistaAccions, LlistaAssociacio llistaAssociacio){
        for(int i=0;i<llistaAccions.getTamany();i++){
            Accio accio = llistaAccions.getAccions()[i];
            if(accio.esXerrada()){
                Xerrada xerrada = (Xerrada) accio;
                try (BufferedReader lector = new BufferedReader(new FileReader("xerrades.txt"))) {
                    String linia;
                    while ((linia = lector.readLine()) != null) {
                        String[] dades = linia.split(";");
                        if (dades[0].equalsIgnoreCase(xerrada.obtenirCodi())) {
                            String[] associacionsXerrada = dades[2].split("/");
                            Associacio[] llistAssociacions = llistaAssociacio.getAssociacions();
                            Associacio[] associacionsOrg = new Associacio[llistaAssociacio.getTamany()];
                            int index=0;
                            for(int j=0;j<associacionsXerrada.length;j++){
                                for(int k=0;k<llistAssociacions.length;k++){
                                    if(associacionsXerrada[j].equalsIgnoreCase(llistAssociacions[k].getNom())){
                                        index=k;
                                        break;
                                    }
                                }
                                associacionsOrg[j]=llistAssociacions[index];
                            }
                            accio.setAssociacions(associacionsOrg);
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error al llegir el fitxer: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Error al processar dades numèriques: " + e.getMessage());
                }
            }
        }
        for(int i=0;i<llistaAccions.getTamany();i++){
            Accio accio = llistaAccions.getAccions()[i];
            if(accio.esDemostracio()){
                Demostracio demostracio = (Demostracio) accio;
                try (BufferedReader lector = new BufferedReader(new FileReader("demostracions.txt"))) {
                    String linia;
                    while ((linia = lector.readLine()) != null) {
                        String[] dades = linia.split(";");
                        if (dades[0].equalsIgnoreCase(demostracio.obtenirCodi())) {
                            String[] associacionsDemostracio = dades[2].split("/");
                            Associacio[] llistAssociacions = llistaAssociacio.getAssociacions();
                            Associacio[] associacionsOrg = new Associacio[llistaAssociacio.getTamany()];
                            int index=0;
                            for(int j=0;j<associacionsDemostracio.length;j++){
                                for(int k=0;k<llistAssociacions.length;k++){
                                    if(associacionsDemostracio[j].equalsIgnoreCase(llistAssociacions[k].getNom())){
                                        index=k;
                                        break;
                                    }
                                }
                                associacionsOrg[j]=llistAssociacions[index];
                            }
                            accio.setAssociacions(associacionsOrg);
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error al llegir el fitxer: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Error al processar dades numèriques: " + e.getMessage());
                }
            }
        }
    }
    
}