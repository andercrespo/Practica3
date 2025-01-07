import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {
        //Crear les llistes vuides i assignem a aquestes el contingut dels fitxers
        LlistaMembres llistaMembres=new LlistaMembres(100, 0);
        LlistaAccions llistaAccions=new LlistaAccions(100);
        LlistaAssociacio llistaAssociacio=new LlistaAssociacio(100);
        GestorFitxers.llegirFitxerText("alumnes.txt",llistaMembres,llistaAccions,llistaAssociacio);
        GestorFitxers.llegirFitxerText("professors.txt",llistaMembres,llistaAccions,llistaAssociacio);
        GestorFitxers.llegirFitxerText("xerrades.txt",llistaMembres,llistaAccions,llistaAssociacio);
        GestorFitxers.llegirFitxerText("demostracions.txt",llistaMembres,llistaAccions,llistaAssociacio);
        GestorFitxers.llegirFitxerText("associacions.txt",llistaMembres,llistaAccions,llistaAssociacio);
        GestorFitxers.revisarLlistaMembre(llistaMembres, llistaAssociacio);
        GestorFitxers.revisarLlistaAccio(llistaAccions, llistaAssociacio);

        // Verificar si el fitxer serialitzat ja existeix
        File fitxerSerialitzat = new File("associacions.ser");
        if (fitxerSerialitzat.exists()) {
            // Llegir el fitxer serialitzat si existeix
            try {
                LlistaAssociacio[] arrayAssociacions = { llistaAssociacio };
                GestorFitxers.llegirLlistaAssociacionsDesSerialitzat(arrayAssociacions);
            } catch (Exception e) {
                System.err.println("Error al llegir el fitxer serialitzat. Es carregarà des del fitxer de text.");
                // Si hi ha un error, carregar des del fitxer de text com a fallback
                GestorFitxers.llegirFitxerText("associacions.txt", llistaMembres, llistaAccions, llistaAssociacio);
            }
        } else {
            // Llegir des del fitxer de text la primera vegada
            GestorFitxers.llegirFitxerText("associacions.txt", llistaMembres, llistaAccions, llistaAssociacio);
            System.out.println("Associacions carregades des del fitxer de text.");
        }


        mostraMenu();
        int opcio = Integer.parseInt(teclat.nextLine());

        while (opcio != 18) {
            switch (opcio) {
                case 1:
                    opcio1(llistaAssociacio);
                    break;
                case 2:
                    opcio2(llistaAssociacio);
                    break;
                case 3:
                    Associacio associacio = llistaAssociacio.getAssociacions()[0];
                    opcio3(associacio);
                    break;
                case 4:
                    opcio4(llistaAccions);
                    break;
                case 5:
                    opcio5(llistaAccions,llistaAssociacio);
                    break;
                case 6:
                    opcio6(llistaAccions);
                    break;
                case 7:
                    opcio7(llistaAssociacio);
                    break;
                case 8:
                    opcio8(llistaAssociacio, llistaMembres);
                    break;
                case 9:
                    opcio9(llistaAccions);
                    break;
                case 10:
                    opcio10(llistaAccions);
                    break;
                case 11:
                    opcio11(llistaAccions);
                    break;
                case 12:
                    opcio12(llistaMembres);
                    break;
                case 13:
                    opcio13(llistaAccions);
                    break;
                case 14:
                    opcio14(llistaAccions);
                    break;
                case 15:
                    opcio15(llistaAccions);
                    break;
                case 16:
                    opcio16(llistaAccions,llistaMembres);
                    break;
                case 17:
                    opcio17(llistaAccions);
                    break;
            }
            mostraMenu();
            opcio = Integer.parseInt(teclat.nextLine());
        }

        System.out.println("Vols guardar els canvis abans de sortir? (S/N)");
        String respostaGuardar = teclat.nextLine().trim().toUpperCase();

        if ("S".equals(respostaGuardar)) {
            // Guardar membres.txt
            GestorFitxers.guardarFitxerText("alumnes.txt", llistaMembres,llistaAccions);
            GestorFitxers.guardarFitxerText("professors.txt", llistaMembres,llistaAccions);
            // Guardar accions.txt
            //GestorFitxers.guardarFitxerText("accions.txt", null, llistaAccions);
        
            // Serialitzar associacions a associacions.ser
            //GestorFitxers.guardarLlistaAssociacionsASerialitzat(new LlistaAssociacio[]{llistaAssociacio});
            //System.out.println("Associacions guardades correctament al fitxer serialitzat: associacions.ser");
            
        
            System.out.println("Totes les dades s'han guardat correctament.");
        } else {
            System.out.println("Sortint sense guardar els canvis.");
        }
    }


    public static void mostraMenu() {
        System.out.println("\n\nOpcions del menú:");
        System.out.println("\t1. Mostrar les dades de la llista d’associacions.");
        System.out.println("\t2. Mostrar les dades de la llista de membres que formen part d’una associació.");
        System.out.println("\t3. Mostrar les dades de la llista de membres actius.");
        System.out.println("\t4. Mostrar les dades de la llista d’accions.");
        System.out.println("\t5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta.");
        System.out.println("\t6. Obtenir i mostrar la llista de les xerrades en una franja de dates.");
        System.out.println("\t7. Afegir una nova associació.");
        System.out.println("\t8. Alta d’un membre a una associació.");
        System.out.println("\t9. Afegir una nova xerrada.");
        System.out.println("\t10. Afegir una nova demostració.");
        System.out.println("\t11. Consultar i mostrar demostracions no actives.");
        System.out.println("\t12. Calcular la persona més activa.");
        System.out.println("\t13. Consultar xerrades amb més assistents.");
        System.out.println("\t14. Valorar una xerrada.");
        System.out.println("\t15. Consultar la xerrada millor valorada.");
        System.out.println("\t16. Mostrar dades de les xerrades que farà una persona.");
        System.out.println("\t17. Donar de baixa demostracions no actives abans d’una data.");
        System.out.println("\t18. Sortir de l'aplicació.");
        System.out.print("\nIndica opció: ");
    }

    public static void opcio1(LlistaAssociacio  llistaAss) {
        try {
            System.out.println(llistaAss.obtenirInformacio());
        } catch (Exception e) {
            System.out.println("Error en opció1: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio2(LlistaAssociacio llistaAssociacio) {
        //Demanar l'associacio i si s'han d'incluir alumnes i professors
        boolean incAlu = false;
        boolean incPro = false;
        System.out.println("Vols incluir alumnes?(si/no): ");
        String resposta1 = teclat.nextLine();
        if(resposta1.equalsIgnoreCase("si")){
            incAlu=true;
        }
        System.out.println("Vols incluir professors?(si/no): ");
        String resposta2 = teclat.nextLine();
        if(resposta2.equalsIgnoreCase("si")){
            incPro=true;
        }
        System.out.println("De quina associaciació: ");
        String nomAss = teclat.nextLine();
        Associacio[] llistaAss=llistaAssociacio.getAssociacions();
        int i =0;
        boolean trobada = false;
        Associacio associacio = null;
        while(!trobada && i<llistaAssociacio.getTamany()){
            if(nomAss.equalsIgnoreCase(llistaAss[i].getNom())){
                 associacio=llistaAss[i];
                 trobada=true;
           }
           else{
            i++;
           }
        }
        //
        try {
            LlistaMembres llista = associacio.obtenirMembresFiltrats(incPro, incAlu);
            System.out.println(llista.obtenirInformacio());
        } catch (NullPointerException e) {
            System.out.println("Error en opcio2: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio3(Associacio associacio) {
        //Demanar si s'han d'incluir alumnes i professors
        boolean incAlu = false;
        boolean incPro = false;
        System.out.println("Vols incluir alumnes?(si/no): ");
        String resposta1 = teclat.nextLine();
        if(resposta1.equalsIgnoreCase("si")){
            incAlu=true;
        }
        System.out.println("Vols incluir professors?(si/no): ");
        String resposta2 = teclat.nextLine();
        if(resposta2.equalsIgnoreCase("si")){
            incPro=true;
        }
        try {
            LlistaMembres llista = associacio.obtenirMembresFiltrats(incPro, incAlu);
            System.out.println(llista.obtenirInformacio());
        } catch (NullPointerException e) {
            System.out.println("Error en opcio3: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio4(LlistaAccions llistaAccions) {
        //Demanar si s'han d'incluir demostracions i xerrades
        boolean incDem = false;
        boolean incXerr = false;
        System.out.println("Vols incluir demostracions?(si/no): ");
        String resposta1 = teclat.nextLine();
        if(resposta1.equalsIgnoreCase("si")){
            incDem=true;
        }
        System.out.println("Vols incluir xerrades?(si/no): ");
        String resposta2 = teclat.nextLine();
        if(resposta2.equalsIgnoreCase("si")){
            incXerr=true;
        }
        //
        try {
            Accio[] accions = llistaAccions.getAccions();
            LlistaAccions resultat = new LlistaAccions(accions.length);
            for (int i = 0; i < accions.length; i++) {
                if (accions[i].esXerrada() && incXerr) {
                    resultat.afegirAccio(accions[i]);
                    break;
                }
                if (accions[i].esDemostracio() && incDem) {
                    resultat.afegirAccio(accions[i]);
                    break;
                }
            }
            System.out.println(resultat.obtenirInformacio());
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio5(LlistaAccions llistaAccions, LlistaAssociacio llistaAssociacions) {
        //Preguntar l'associació
        System.out.println("De quina associaciació: ");
        String nomAss = teclat.nextLine();
        Associacio[] llistaAss=llistaAssociacions.getAssociacions();
        int i =0;
        boolean trobada = false;
        Associacio associacio = null;
        while(!trobada && i<llistaAss.length){
            if(llistaAss[i].getNom().equalsIgnoreCase(nomAss)){
                 associacio=llistaAss[i];
                 trobada=true;
           }
           else{
            i++;
           }
        }
        //
        try {
            Accio[] accions = llistaAccions.getAccions();
            LlistaAccions resultat = new LlistaAccions(accions.length);
            for (int j = 0; j < accions.length; j++) {
                if(accions[j] != null){
                Associacio[] associacionsOrganitzadores = accions[j].getAssociacionsOrganitzadores();
                if (associacionsOrganitzadores != null ){
                for (int k = 0; k < associacionsOrganitzadores.length; k++) {
                    if (associacionsOrganitzadores[k] == associacio) {
                        resultat.afegirAccio(accions[j]);
                    }
                }}}
            }
            System.out.println(resultat.obtenirInformacio());
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio6(LlistaAccions llistaAccions) {
        //
        System.out.println("Introdueix la data inicial (format: yyyy-MM-dd): ");
        String dataIniString = teclat.nextLine();
        LocalDate dataIni = LocalDate.parse(dataIniString);
        System.out.println("Introdueix la data final (format: yyyy-MM-dd): ");
        String dataFinString = teclat.nextLine();
        LocalDate dataFin = LocalDate.parse(dataFinString);
        //
        try {
            System.out.println("Xerrades dins la franja de dates:");
            Accio[] accions = llistaAccions.getAccions();
            LlistaAccions resultat = new LlistaAccions(accions.length);
            for (int i = 0; i < accions.length; i++) {
                if(accions[i] != null){
                if (accions[i].esXerrada()) {
                    Xerrada xerrada = (Xerrada) accions[i];
                    if (xerrada.obtenirDataRealitzacio().isBefore(dataFin) && xerrada.obtenirDataRealitzacio().isAfter(dataIni)) {
                        resultat.afegirAccio(xerrada);
                    }
                }}
            }
            System.out.println(resultat.obtenirInformacio());
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio7(LlistaAssociacio llistaAssociacions) {
        //Demanar i crear l'associació nova
        System.out.println("Introdueix el nom de l'associació: ");
        String nom = teclat.nextLine();
        System.out.println("Introdueix el correu de l'associació: ");
        String correu = teclat.nextLine();
        Associacio associacio = new Associacio(nom, correu, null, null, null, null, null, null);
        
        try {
            llistaAssociacions.afegirAssociacio(associacio);
            System.out.println("Associacio afegida amb exit a la llista.");
            System.out.println(llistaAssociacions.obtenirInformacio());
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio8(LlistaAssociacio llistaAssociacions, LlistaMembres llistaMembres) {
        try {
            System.out.println("És el membre nou? (si/no): ");
            String resposta = teclat.nextLine().trim().toLowerCase();
    
            if (resposta.equals("si")) {
                // Cas membre nou
                System.out.println("Introdueix l'àlies del membre: ");
                String alies = teclat.nextLine();
    
                System.out.println("Introdueix el correu electrònic del membre: ");
                String correu = teclat.nextLine();
    
                System.out.println("Introdueix el tipus de membre (Professor/Alumne): ");
                String tipus = teclat.nextLine();
    
                LocalDate[] dataAlta = {LocalDate.now(), null, null}; // S'afegeix la data actual com a data d'alta
    
                System.out.println("Introdueix l'associacio a la que es vol afegir el membre: ");
                String associacio = teclat.nextLine();
                
                Associacio[] associacions = llistaAssociacions.getAssociacions();
                int i = 0;
                boolean trobada = false;
                while (i < llistaAssociacions.getTamany() && !trobada) {
                    if (associacio.equalsIgnoreCase(associacions[i].getNom())) {
                        trobada = true;
                    } else {
                        i++;
                    }
                }
                if (!trobada) {
                    throw new IllegalArgumentException("No s'ha trobat l'associació: " + associacio);
                }
                LlistaAssociacio associacionsPertany = new LlistaAssociacio(3);
                associacionsPertany.afegirAssociacio(associacions[i]);

                if(tipus.equalsIgnoreCase("Professor")){
                    System.out.println("Introdueix el departament al que pertany el membre: ");
                    String departament = teclat.nextLine();

                    System.out.println("Introdueix el despatx del membre: ");
                    int despatx = Integer.parseInt(teclat.nextLine());

                    Professor nouProfessor = new Professor(alies, correu, dataAlta, null, associacionsPertany, tipus, departament, despatx);
                    Membre nouMembre= nouProfessor;
                    associacions[i].afegirMembre(nouMembre);
                }
                else if(tipus.equalsIgnoreCase("Alumne")){
                    System.out.println("Introdueix l'ensenyament del membre: ");
                    String enseyament = teclat.nextLine();

                    System.out.println("Introdueix els anys que porta a l'ETSE el membre: ");
                    int anysETSE = Integer.parseInt(teclat.nextLine());
                    
                    System.out.println("Esta graduat?(true/false): ");
                    boolean graduat = Boolean.parseBoolean(teclat.nextLine());

                    Alumne nouAlumne = new Alumne(alies, correu, dataAlta, null, associacionsPertany, tipus, enseyament, anysETSE, graduat);
                    Membre nouMembre = nouAlumne;
                    associacions[i].afegirMembre(nouMembre);
                }
    
    
                System.out.println("Membre nou afegit amb èxit a l'associació.");
    
            } else if (resposta.equals("no")) {
                // Cas membre ja existent en una altra associació
                System.out.println("Introdueix l'àlies del membre existent: ");
                String alies = teclat.nextLine();
                Membre[] membres = llistaMembres.getMembres();
                int i = 0;
                boolean trobat = false;
                while (i < membres.length && !trobat) {
                    if (alies.equalsIgnoreCase(membres[i].getAlies())) {
                        trobat = true;
                    } else {
                        i++;
                    }
                }
                if (!trobat) {
                    throw new IllegalArgumentException("No s'ha trobat el membre: " + alies);
                }
    
                System.out.println("Introdueix l'associacio a la que es vol afegir el membre: ");
                String associacio2 = teclat.nextLine();
    
                Associacio[] associacions2 = llistaAssociacions.getAssociacions();
                int j = 0;
                boolean trobada = false;
                while (j < associacions2.length && !trobada) {
                    if (associacio2.equalsIgnoreCase(associacions2[j].getNom())) {
                        trobada = true;
                    } else {
                        j++;
                    }
                }
                if (!trobada) {
                    throw new IllegalArgumentException("No s'ha trobat l'associació: " + associacio2);
                }
    
                membres[i].afegirAssociacio(associacions2[j]);
                associacions2[j].afegirMembre(membres[i]);
                System.out.println("Membre existent afegit amb èxit a l'associació.");
    
            } else {
                System.out.println("Resposta no vàlida. Torna-ho a intentar.");
            }
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Accés fora dels límits de la llista.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio9(LlistaAccions llistaAccions) {
        //Demanar i crear la xerrada nova
        System.out.println("Introdueix el codi de la Xerrada: ");
        String codi = teclat.nextLine();
        System.out.println("Introdueix el titol de la xerrada: ");
        String titol = teclat.nextLine();
        System.out.println("Introdueix la data de la xerrada (format: yyyy-MM-dd): ");
        String dataString = teclat.nextLine();
        LocalDate dataRealitzacio = LocalDate.parse(dataString);
        System.out.println("Introdueix el nombre d'assistents: ");
        int nAss = Integer.parseInt(teclat.nextLine());
        Xerrada xerrada = new Xerrada(codi, titol, null, null, "Xerrada", dataRealitzacio, nAss, new int[0], new Membre[0]);
        
        try {
            llistaAccions.afegirAccio(xerrada);
            System.out.println("Xerrada afegida amb èxit a la llista.");
            // Aqui fer un print per a mostrar la llista 
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio10(LlistaAccions llistaAccions) {
        //Demanar i crear la demostració nova
        System.out.println("Introdueix el codi de la Demostració: ");
        String codi = teclat.nextLine();
        System.out.println("Introdueix el titol de la demostració: ");
        String titol = teclat.nextLine();
        System.out.println("Introdueix la data de disseny de la demostració (format: yyyy-MM-dd): ");
        String dataString = teclat.nextLine();
        LocalDate dataDisseny = LocalDate.parse(dataString);
        System.out.println("Es vàlida?(si/no): ");
        boolean esValida =false;
        String resposta1 = teclat.nextLine();
        if(resposta1.equalsIgnoreCase("si")){
            esValida=true;
        }
        System.out.println("Introdueix el nombre de vegades oferta: ");
        int nVegOfer = Integer.parseInt(teclat.nextLine());
        System.out.println("Introdueix el cost dels materials: ");
        double costMater = Double.parseDouble(teclat.nextLine());
        Demostracio demostracio = new Demostracio(codi, titol, null, null,"Demostració", dataDisseny, esValida, nVegOfer, costMater);
        //
        try {
            llistaAccions.afegirAccio(demostracio);
            System.out.println("Demostracio afegida amb èxit a la llista.");
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio11(LlistaAccions llistaAccions) {
        try {
            double costTotal = 0;
            Accio[] accions = llistaAccions.getAccions();
            LlistaAccions resultat = new LlistaAccions(accions.length);
            System.out.println("Demostracions no actives:");
            for (int i = 0; i < accions.length; i++) {
                if (accions[i]!= null){
                if (accions[i].esDemostracio()) {
                    Demostracio demostracio = (Demostracio) accions[i];
                    if (!demostracio.esValida()) {
                        resultat.afegirAccio(accions[i]);
                        costTotal = costTotal + demostracio.obtenirCostTotal();
                    }
                }}
            }
            System.out.println("\nCost econòmic total de les demostracions no actives: " + costTotal);
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.err.println("Error: No s'ha pogut convertir l'objecte");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio12(LlistaMembres llistaMembres) {
        try {
            int maxAssociacions = 0;
            LocalDate maxDataAlta = null;
            int index = 0;
            Membre[] membres = llistaMembres.getMembres();
            for (int i = 0; i < membres.length; i++) {
                if (membres[i] != null){
                LlistaAssociacio associacionsPertany = membres[i].getAssociacions();
                if(associacionsPertany != null){
                Associacio[] associacions = associacionsPertany.getAssociacions();
                if (associacions.length >= maxAssociacions) {
                    if (associacions.length == maxAssociacions) {
                        LocalDate[] datesAlta = membres[i].getDataAlta();
                        for (int j = 0; j < datesAlta.length; j++) {
                            if (datesAlta[j] != null){
                            if (datesAlta[j].isBefore(maxDataAlta)) {
                                maxDataAlta = datesAlta[j];
                                index = i;
                            }}}
                        }
                    } else {
                        maxAssociacions = associacions.length;
                        LocalDate[] datesAlta = membres[i].getDataAlta();
                        LocalDate mesAntiga = datesAlta[0];
                        for (int j = 0; j < datesAlta.length; j++) {
                            if (datesAlta[j] != null){
                            if (datesAlta[j].isBefore(mesAntiga)) {
                                mesAntiga = datesAlta[j];
                            }
                        }}
                        maxDataAlta = mesAntiga;
                        index = i;
                    }
                }}
            }
            System.out.println(membres[index].obtenirInformacio());
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: Accés fora dels límits de la llista.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio13(LlistaAccions llistaAccions) {
        try {
            Accio[] accions = llistaAccions.getAccions();
            Xerrada xerradaMax = null; // Para guardar la xerrada con más asistentes
            int maxAssistents = 0; // Comenzamos con 0 asistentes
    
            for (Accio accio : accions) {
                if (accio != null && accio.esXerrada()) {
                    Xerrada xerrada = (Xerrada) accio;
                    int nombreAssistents = xerrada.obtenirNombreAssistents();
                    if (nombreAssistents > maxAssistents) {
                        xerradaMax = xerrada;
                        maxAssistents = nombreAssistents; // Actualizamos el máximo
                    }
                }
            }
    
            // Mostrar la xerrada con más asistentes
            if (xerradaMax != null) {
                System.out.println("Xerrada amb més assistents:");
                System.out.println(xerradaMax.obtenirTitol());
            } else {
                System.out.println("No s'ha trobat cap xerrada.");
            }
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat un valor nul inesperat.");
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.err.println("Error: No s'ha pogut convertir l'objecte.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    

    public static void opcio14(LlistaAccions llistaAccions) {
        try {
            Accio[] accions = llistaAccions.getAccions();
            Xerrada[] xerrades = new Xerrada[llistaAccions.getTamany()];
            int index = 0;
            for (int i = 0; i < llistaAccions.getTamany(); i++) {
                if (accions[i] != null && accions[i].esXerrada()) {
                    xerrades[index] = (Xerrada) accions[i];
                    index++;
                }
            }
            int n = 1;
            for (int i = 0; i < index; i++) {
                System.out.println(n + ". " + xerrades[i].obtenirTitol());
                n++;
            }

            System.out.print("Digues el número de la xerrada que vols valorar: ");
            int indexXerrada = Integer.parseInt(teclat.nextLine()) - 1;
            if (indexXerrada < 0 || indexXerrada >= xerrades.length || xerrades[indexXerrada] == null) {
                System.out.println("Xerrada seleccionada no vàlida.");
                return;
            }
            System.out.print("Quina valoració li dones a la xerrada?(1-10): ");
            int valoracio = Integer.parseInt(teclat.nextLine());
            xerrades[indexXerrada].afegirValoracio(valoracio);
            System.out.println("Valoració afegida correctament!");
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.err.println("Error: No s'ha pogut convertir l'objecte");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error: Entrada invàlida al convertir a número.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio15(LlistaAccions llistaAccions) {
        String mesValorada = null;
        double maxValoracio = 0;
        int numValoracionsMax = 0;
    
        try {
            Accio[] accions = llistaAccions.getAccions();
            
            for (Accio accio : accions) {
                if (accio instanceof Xerrada) {
                    Xerrada xerrada = (Xerrada) accio;
                    double mitjanaValoracions = xerrada.obtenirMitjanaValoracions();
                    int numValoracionsActual = xerrada.getNumValoracions();
    
                    if (mitjanaValoracions > maxValoracio || 
                       (mitjanaValoracions == maxValoracio && numValoracionsActual > numValoracionsMax)) {
                        maxValoracio = mitjanaValoracions;
                        numValoracionsMax = numValoracionsActual;
                        mesValorada = xerrada.obtenirCodi();
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat un valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    
        if (mesValorada == null) {
            System.out.println("No hi ha cap xerrada valorada.");
        } else {
            System.out.println("La xerrada més valorada és: " + mesValorada);
        }
    }

    public static void opcio16(LlistaAccions llistaAccions, LlistaMembres llistaMembres) {
        System.out.println("Introdueix el nom del membre: ");
        String nom = teclat.nextLine();
        Membre[] membres = llistaMembres.getMembres();
        Membre membre = null;
    
        // Buscar el membre per alies
        for (Membre m : membres) {
            if (m != null && m.getAlies().equalsIgnoreCase(nom)) {
                membre = m;
                break;
            }
        }
    
        if (membre == null) {
            System.out.println("Membre no trobat.");
            return;
        }
    
        try {
            Accio[] accions = llistaAccions.getAccions();
            boolean capXerrada = true;
    
            for (int i = 0; i < accions.length; i++) {
                if (accions[i] != null && accions[i].esXerrada()) {
                    Xerrada xerrada = (Xerrada) accions[i];
                    boolean jaMostrada = false;
    
                    // Verificar si una charla con la misma información ya fue mostrada
                    String infoActual = xerrada.obtenirInformacio();
                    for (int j = 0; j < i; j++) {
                        if (accions[j] != null && accions[j].esXerrada()) {
                            Xerrada xerradaAnterior = (Xerrada) accions[j];
                            if (xerradaAnterior.obtenirInformacio().equals(infoActual)) {
                                jaMostrada = true;
                                break;
                            }
                        }
                    }
    
                    // Si no está mostrada, comprobar los impartidors
                    if (!jaMostrada) {
                        Membre[] impartidors = xerrada.getImpartidors();
                        for (Membre impartidor : impartidors) {
                            if (impartidor != null && impartidor.equals(membre)) {
                                System.out.println("Xerrada: " + infoActual);
                                capXerrada = false;
                                break;
                            }
                        }
                    }
                }
            }
    
            if (capXerrada) {
                System.out.println("No s'han trobat xerrades per a aquest membre.");
            }
    
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio17(LlistaAccions llistaAccions) {
        //Demanar la data
        System.out.println("Introdueix la data inicial (format: yyyy-MM-dd): ");
        String dataString = teclat.nextLine();
        LocalDate data = LocalDate.parse(dataString);
        //
        Accio[] accions = llistaAccions.getAccions();
        int n=llistaAccions.getTamany();
        for (int i = 0; i < n; i++) {
            if (accions[i] != null && accions[i].esDemostracio()) {
                Demostracio demostracio = null;
                try {
                    demostracio = (Demostracio) accions[i];
                } catch (ClassCastException e) {
                    System.err.println("Error al convertir accions[" + i + "] a Demostracio.");
                    continue; 
                }
                if (demostracio != null) {
                    if (demostracio.esValida() && (demostracio.getData() != null && demostracio.getData().isBefore(data))) {
                        for (int j = i; j < n - 1; j++) {
                            accions[j] = accions[j + 1];
                            System.out.println("Demostracio "+accions[j+1].obtenirCodi()+" donada de baixa");
                        }
                        accions[n - 1] = null;
                        n--;
                        i--; 
                    }
                }
            }
        }
    }
}