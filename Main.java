import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static Scanner teclat = new Scanner(System.in);
    private static Associacio associacio = new Associacio();
    public static void main(String[] args) {
        mostraMenu();
        int opcio = Integer.parseInt(teclat.nextLine());

        while (opcio != 18) {
            switch (opcio) {
                case 1
                    opcio1();
                    break;
                case 2:
                    opcio2();
                    break;
                case 3:
                    opcio3();
                    break;
                case 4:
                    opcio4();
                    break;
                case 5:
                    opcio5();
                    break;
                case 6:
                    opcio6();
                    break;
                case 7:
                    opcio7();
                    break;
                case 8:
                    opcio8();
                    break;
                case 9:
                    opcio9();
                    break;
                case 10:
                    opcio10();
                    break;
                case 11:
                    opcio11();
                    break;
                case 12:
                    opcio12();
                    break;
                case 13:
                    opcio13();
                    break;
                case 14:
                    opcio14();
                    break;
                case 15:
                    opcio15();
                    break;
                case 16:
                    opcio16();
                    break;
                case 17:
                    opcio17();
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

    public static void opcio1(LlistaAssociacio llista) {
        System.out.println(llista.obtenirInformacio());
    }

    public static void opcio2(Associacio associacio, boolean incluirAlumnes, boolean incluirProfessors) {
        LlistaMembres llista = associacio.obtenirMembresFiltrats(incluirProfessors, incluirAlumnes);
        llista.obtenirInformacio();
    }

    public static void opcio3() {
    }

    public static void opcio4(String[] args) {
        LlistaAccions llista = new LlistaAccions(10);
        System.out.println("Totes les accions disponibles:");
        System.out.println(llista.obtenirInformacio());
    }

    public static void opcio5() {
    }

    public static void opcio6() {
    }

    public static void opcio7(Associacio associacio, LlistaAssociacio llista) {
        llista.afegirAssociacio(associacio);
    }

    public static void opcio8() {
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

            LocalDate[] dataAlta = { LocalDate.now(), null, null }; // S'afegeix la data actual com a data d'alta

            Membre nouMembre = new Membre(alies, correu, dataAlta, null, new LlistaAssociacio(10), tipus);
            associacio.afegirMembre(nouMembre);
            System.out.println("Membre nou afegit amb èxit a l'associació.");

        } else if (resposta.equals("no")) {
            // Cas membre ja existent en una altra associació
            System.out.println("Introdueix l'àlies del membre existent: ");
            String alies = teclat.nextLine();

            System.out.println("Introdueix el correu electrònic del membre: ");
            String correu = teclat.nextLine();

            Membre membreExistent = new Membre(alies, correu, null, null, new LlistaAssociacio(10), "");
            associacio.afegirMembre(membreExistent);
            System.out.println("Relació amb el membre existent afegida amb èxit.");

        } else {
            System.out.println("Resposta no vàlida. Torna-ho a intentar.");
        }
    }

    public static void opcio9(Xerrada xerrada, LlistaAccions llista) {
        llista.afegirAccio(xerrada);  
    }   

    public static void opcio10(LlistaAccions llista, Demostracio demostracio) {
        Accio accio = demostracio;
        llista.afegirAccio(accio);
    }

    public static void opcio11() {
        double costTotal = 0;
    
        Demostracio[] demostracions = Demostracio.obtenirDemostracions();
    
        System.out.println("Demostracions no actives:");
    
        for (Demostracio demostracio : demostracions) {
            // Comprovar si la demostració no és vàlida
            if (!demostracio.esValida()) {
                // Mostrar la informació de la demostració no activa
                System.out.println(demostracio.obternirInformacioDetallada());
                // Afegir el cost de materials al total
                costTotal += demostracio.obtenirCostTotal();
            }
        }
    
        // Mostrar el cost total
        System.out.println("\nCost econòmic total de les demostracions no actives: " + costTotal);
    }

    public static void opcio12() {
    }

    public static void opcio13() {
        System.out.println("Indica el nombre d'assistents:");
        int nAssistents = Integer.parseInt(teclat.nextLine());

        Xerrada[] xerrades = Xerrada.obtenirXerrades();
        System.out.println("Xerrades amb més de " + nAssistents + " assistents:");

        for (Xerrada xerrada : xerrades) {
            if (xerrada != null && xerrada.obtenirNombreAssistents() > nAssistents) {
                System.out.println(xerrada.obtenirInformacioDetallada());
            }
        }

    }

    public static void opcio14() {
        Xerrada[] xerrades = Xerrada.obtenirXerrades();
        if (xerrades == null || xerrades.length == 0) {
            System.out.println("No hi ha xerrades disponibles per valorar.");
            return;
        }
    
        System.out.println("Selecciona la xerrada que vols valorar:");
        for (int i = 0; i < xerrades.length; i++) {
            if (xerrades[i] != null) {
                System.out.println((i + 1) + ". " + xerrades[i].obtenirInformacioDetallada());
            }
        }
    
        System.out.print("Número de la xerrada: ");
        int indexXerrada = Integer.parseInt(teclat.nextLine()) - 1;
    
        if (indexXerrada < 0 || indexXerrada >= xerrades.length || xerrades[indexXerrada] == null) {
            System.out.println("Xerrada seleccionada no vàlida.");
            return;
        }
    
        System.out.print("Quina seria la seva valoració de la xerrada (0-10)?: ");
        int valoracio = Integer.parseInt(teclat.nextLine());
    
        if (valoracio < 0 || valoracio > 10) {
            System.out.println("La valoració ha de ser entre 0 i 10.");
            return;
        }
    
        xerrades[indexXerrada].afegirValoracio(valoracio);
    
        System.out.println("Valoració afegida correctament!");
    }

    public static String opcio15(LlistaAccions llista) {
        Accio[] accions=llista.getAccions();
        double maxValoracio = 0;
        String mesValorada=null;
        int numValoracions=0;
        for(int i=0;i<accions.length;i++){
                Xerrada xerrada = (Xerrada) accions[i];
            if(xerrada.obtenirMitjanaValoracions()>=maxValoracio){
                if(xerrada.obtenirMitjanaValoracions()==maxValoracio){
                    if(xerrada.getNumValoracions()>numValoracions){
                        maxValoracio=xerrada.obtenirMitjanaValoracions();
                        mesValorada=accions[i].obtenirCodi();
                        numValoracions=xerrada.getNumValoracions();
                    }
                }
                else{
                    maxValoracio=xerrada.obtenirMitjanaValoracions();
                    mesValorada=accions[i].obtenirCodi();
                    numValoracions=xerrada.getNumValoracions();
                }
            }
        }
        return mesValorada;
    }

    public static void opcio16() {
    }

    public static void opcio17(LlistaAccions llista, LocalDate data) {
        Accio[] accions=llista.getAccions();
        for(int i=0;i<accions.length;i++){
            if(accions[i].esDemostracio()){
                Demostracio demostracio = (Demostracio) accions[i];
                if(){//ns a que se referix mirar si una demostracio es activa
                    demostracio.marcarComNoValida();
                }
                if(demostracio.getData().isBefore(data)){
                    demostracio.marcarComNoValida();
                }
            }
        }
    }
}
