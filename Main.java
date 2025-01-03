import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {
        mostraMenu();
        int opcio = Integer.parseInt(teclat.nextLine());

        while (opcio != 18) {
            switch (opcio) {
                case 1:
                    opcio1(LlistaAssociacio);
                    break;
                case 2:
                    opcio2(llistaAssociacions);
                    break;
                case 3:
                    opcio3(associacio);
                    break;
                case 4:
                    opcio4(llistaAccions);
                    break;
                case 5:
                    opcio5(LlistaAccions,LlistaAssociacio);
                    break;
                case 6:
                    opcio6(LlistaAccions);
                    break;
                case 7:
                    opcio7(LlistaAssociacio);
                    break;
                case 8:
                    opcio8(LlistaAssociacio, LlistaMembres);
                    break;
                case 9:
                    opcio9(LlistaAccions);
                    break;
                case 10:
                    opcio10(LlistaAccions);
                    break;
                case 11:
                    opcio11(LlistaAccions);
                    break;
                case 12:
                    opcio12(LlistaMembres);
                    break;
                case 13:
                    opcio13(LlistaAccions);
                    break;
                case 14:
                    opcio14(LlistaAccions);
                    break;
                case 15:
                    opcio15(LlistaAccions);
                    break;
                case 16:
                    opcio16(LlistaAccions,LlistaMembres);
                    break;
                case 17:
                    opcio17(LlistaAccions);
            }
            mostraMenu();
            opcio = Integer.parseInt(teclat.nextLine());
        }
        System.out.println("Sortint de l'aplicació.");
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
            System.out.println("Error en obtenir les dades de la llista d'associacions: " + e.getMessage());
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
            LlistaMembres llista = associacio.obtenirMembresFiltrats(incPro, incAlu);
            System.out.println(llista.obtenirInformacio());
        } catch (Exception e) {
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
            Membre[] llistaActius = llista.obtenirMembresActius();
            LlistaMembres resultat = new LlistaMembres(llistaActius.length, llistaActius.length);
            System.out.println(resultat.obtenirInformacio());
        } catch (Exception e) {
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
                Associacio[] associacionsOrganitzadores = accions[j].getAssociacionsOrganitzadores();
                for (int k = 0; k < associacionsOrganitzadores.length; k++) {
                    if (associacionsOrganitzadores[k] == associacio) {
                        resultat.afegirAccio(accions[j]);
                    }
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
                if (accions[i].esXerrada()) {
                    Xerrada xerrada = (Xerrada) accions[i];
                    if (xerrada.obtenirDataRealitzacio().isBefore(dataFin) && xerrada.obtenirDataRealitzacio().isAfter(dataIni)) {
                        resultat.afegirAccio(xerrada);
                    }
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
    
    public static void opcio7(LlistaAssociacio llistaAssociacions) {
        //Demanar i crear l'associació nova
        System.out.println("Introdueix el nom de l'associació: ");
        String nom = teclat.nextLine();
        System.out.println("Introdueix el correu de l'associació: ");
        String correu = teclat.nextLine();
        Associacio associacio = new Associacio(nom, correu, null, null, null, null, null, null);
        //
        try {
            llistaAssociacions.afegirAssociacio(associacio);
            System.out.println("Associacio afegida amb exit a la llista.");
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
                while (!trobada) {
                    if (associacio.equalsIgnoreCase(associacions[i].getNom())) {
                        trobada = true;
                    } else {
                        i++;
                    }
                }
                LlistaAssociacio associacionsPertany = new LlistaAssociacio(3);
                associacionsPertany.afegirAssociacio(associacions[i]);
                Membre nouMembre = new Membre(alies, correu, dataAlta, null, associacionsPertany, tipus);
                associacions[i].afegirMembre(nouMembre);
    
                System.out.println("Membre nou afegit amb èxit a l'associació.");
    
            } else if (resposta.equals("no")) {
                // Cas membre ja existent en una altra associació
                System.out.println("Introdueix l'àlies del membre existent: ");
                String alies = teclat.nextLine();
                Membre[] membres = llistaMembres.getMembres();
                int i = 0;
                boolean trobat = false;
                while (!trobat) {
                    if (alies.equalsIgnoreCase(membres[i].getAlies())) {
                        trobat = true;
                    } else {
                        i++;
                    }
                }
                System.out.println("Introdueix l'associacio a la que es vol afegir el membre: ");
                String associacio2 = teclat.nextLine();
    
                Associacio[] associacions2 = llistaAssociacions.getAssociacions();
                int j = 0;
                boolean trobada = false;
                while (!trobada) {
                    if (associacio2.equalsIgnoreCase(associacions2[j].getNom())) {
                        trobada = true;
                    } else {
                        j++;
                    }
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
        Xerrada xerrada = new Xerrada(codi, titol, null, null, "Xerrada", dataRealitzacio, nAss, null, null);
        //
        try {
            llistaAccions.afegirAccio(xerrada);
            System.out.println("Xerrada afegida amb èxit a la llista.");
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
                if (accions[i].esDemostracio()) {
                    Demostracio demostracio = (Demostracio) accions[i];
                    if (!demostracio.esValida()) {
                        resultat.afegirAccio(accions[i]);
                        costTotal = costTotal + demostracio.obtenirCostTotal();
                    }
                }
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
                LlistaAssociacio associacionsPertany = membres[i].getAssociacions();
                Associacio[] associacions = associacionsPertany.getAssociacions();
                if (associacions.length >= maxAssociacions) {
                    if (associacions.length == maxAssociacions) {
                        LocalDate[] datesAlta = membres[i].getDataAlta();
                        for (int j = 0; j < datesAlta.length; j++) {
                            if (datesAlta[j].isBefore(maxDataAlta)) {
                                maxDataAlta = datesAlta[j];
                                index = i;
                            }
                        }
                    } else {
                        maxAssociacions = associacions.length;
                        LocalDate[] datesAlta = membres[i].getDataAlta();
                        LocalDate mesAntiga = datesAlta[0];
                        for (int j = 0; j < datesAlta.length; j++) {
                            if (datesAlta[j].isBefore(mesAntiga)) {
                                mesAntiga = datesAlta[j];
                            }
                        }
                        maxDataAlta = mesAntiga;
                        index = i;
                    }
                }
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
        //
        System.out.println("Introdueix el nombre d'assistents: ");
        int nAss = Integer.parseInt(teclat.nextLine());
        //
        try {
            Accio[] accions = llistaAccions.getAccions();
            Xerrada[] xerrades = new Xerrada[accions.length];
            for (int i = 0; i < accions.length; i++) {
                if (accions[i].esXerrada()) {
                    xerrades[xerrades.length - 1] = (Xerrada) accions[i];
                }
            }
            for (Xerrada xerrada : xerrades) {
                if (xerrada != null && xerrada.obtenirNombreAssistents() > nAss) {
                    System.out.println(xerrada.obtenirInformacioDetallada());
                }
            }
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
    

    public static void opcio14(LlistaAccions llistaAccions) {
        try {
            Accio[] accions = llistaAccions.getAccions();
            Xerrada[] xerrades = new Xerrada[accions.length];
            for (int i = 0; i < accions.length; i++) {
                if (accions[i].esXerrada()) {
                    xerrades[xerrades.length - 1] = (Xerrada) accions[i];
                }
            }
            for (int i = 0; i < xerrades.length; i++) {
                if (xerrades[i] != null) {
                    System.out.println((i + 1) + ". " + xerrades[i].obtenirInformacioDetallada());
                }
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
    

    public static String opcio15(LlistaAccions llistaAccions) {
        try {
            Accio[] accions = llistaAccions.getAccions();
            double maxValoracio = 0;
            String mesValorada = null;
            int numValoracions = 0;
            for (int i = 0; i < accions.length; i++) {
                Xerrada xerrada = (Xerrada) accions[i];
                if (xerrada.obtenirMitjanaValoracions() >= maxValoracio) {
                    if (xerrada.obtenirMitjanaValoracions() == maxValoracio) {
                        if (xerrada.getNumValoracions() > numValoracions) {
                            maxValoracio = xerrada.obtenirMitjanaValoracions();
                            mesValorada = accions[i].obtenirCodi();
                            numValoracions = xerrada.getNumValoracions();
                        }
                    } else {
                        maxValoracio = xerrada.obtenirMitjanaValoracions();
                        mesValorada = accions[i].obtenirCodi();
                        numValoracions = xerrada.getNumValoracions();
                    }
                }
            }
            return mesValorada;
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
        return null;
    }
    

    public static void opcio16(LlistaAccions llistaAccions,LlistaMembres llistaMembres) {
        //Demanar el membre
        System.out.println("Introdueix el nom del membre: ");
        String nom=teclat.nextLine();
        int i=0;
        boolean trobat =false;
        Membre[] membres = llistaMembres.getMembres();
        Membre membre=null;
        while (!trobat && i<membres.length){
            if(membres[i].getAlies().equalsIgnoreCase(nom)){
                membre=membres[i];
                trobat=true;
            }
            else{
                i++;
            }
        }
        //
        try {
            Accio[] accions = llistaAccions.getAccions();
            for (int j = 0; j < accions.length; j++) {
                if (accions[i].esXerrada()) {
                    Xerrada xerrada = (Xerrada) accions[j];
                    Membre[] impartidors = xerrada.getImpartidors();
                    for (int k = 0; k < impartidors.length; k++) {
                        if (impartidors[k].equals(membre)) {
                            System.out.println("Xerrada: " + accions[j].obtenirInformacio());
                        }
                    }
                }
            }
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

    public static void opcio17(LlistaAccions llistaAccions) {
        //Demanar la data
        System.out.println("Introdueix la data inicial (format: yyyy-MM-dd): ");
        String dataString = teclat.nextLine();
        LocalDate data = LocalDate.parse(dataString);
        //
        Accio[] accions = llistaAccions.getAccions();
        int n = accions.length;
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
                    if (demostracio.esValida() || 
                            (demostracio.getData() != null && demostracio.getData().isBefore(data))) {
                        for (int j = i; j < n - 1; j++) {
                            accions[j] = accions[j + 1];
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
