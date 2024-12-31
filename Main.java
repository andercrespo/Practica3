import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {

    //Dades per al joc de proves//les hem de posar al ininci del main
    LocalDate[] datesAltaUnai= {LocalDate.of(2024,5,12),LocalDate.of(2024,7,22),null};
    LocalDate[] datesBaixaUnai= {LocalDate.of(2024,10,19),null,null};
    LocalDate[] datesAltaAdam= {LocalDate.of(2023,3,12),null,null};
    LocalDate[] datesBaixaAdam= {null,null,null};
    LocalDate[] datesAltaAnder= {LocalDate.of(2022,9,30),null,null};
    LocalDate[] datesBaixaAnder= {null,null,null};
    LocalDate[] datesAltaOscar= {LocalDate.of(2024,1,12),LocalDate.of(2024,8,6),null};
    LocalDate[] datesBaixaOscar= {LocalDate.of(2024,8,7),null,null};

    LocalDate[] datesAltaPresAss1={LocalDate.of(2022,10,21),null,null};
    LocalDate[] datesBaixaPresAss1={null,null,null};
    LocalDate[] datesAltaSecreAss1={LocalDate.of(2023,4,3),null,null};
    LocalDate[] datesBaixaSecreAss1={null,null,null};
    LocalDate[] datesAltaTresAss1={LocalDate.of(2024,1,2),null,null};
    LocalDate[] datesBaixaTresAss1={null,null,null};
    LocalDate[] datesAltaPresAss2={LocalDate.of(2022,5,10),null,null};
    LocalDate[] datesBaixaPresAss2={null,null,null};
    LocalDate[] datesAltaSecreAss2={LocalDate.of(2023,4,1),null,null};
    LocalDate[] datesBaixaSecreAss2={null,null,null};
    LocalDate[] datesAltaTresAss2={LocalDate.of(2024,7,12),null,null};
    LocalDate[] datesBaixaTresAss2={null,null,null};
    LocalDate[] datesAltaPresAss3={LocalDate.of(2022,3,17),null,null};
    LocalDate[] datesBaixaPresAss3={null,null,null};
    LocalDate[] datesAltaSecreAss3={LocalDate.of(2023,9,4),null,null};
    LocalDate[] datesBaixaSecreAss3={null,null,null};
    LocalDate[] datesAltaTresAss3={LocalDate.of(2024,3,1),null,null};
    LocalDate[] datesBaixaTresAss3={null,null,null};

    LlistaAssociacio associacionsUnai= new LlistaAssociacio(3);
    LlistaAssociacio associacionsAdam= new LlistaAssociacio(3);
    LlistaAssociacio associacionsAnder= new LlistaAssociacio(3);
    LlistaAssociacio associacionsOscar= new LlistaAssociacio(3);

    LlistaAssociacio associacionsPresAss1= new LlistaAssociacio(3);
    LlistaAssociacio associacionsSecreAss1= new LlistaAssociacio(3);
    LlistaAssociacio associacionsTresAss1= new LlistaAssociacio(3);
    LlistaAssociacio associacionsPresAss2= new LlistaAssociacio(3);
    LlistaAssociacio associacionsSecreAss2= new LlistaAssociacio(3);
    LlistaAssociacio associacionsTresAss2= new LlistaAssociacio(3);
    LlistaAssociacio associacionsPresAss3= new LlistaAssociacio(3);
    LlistaAssociacio associacionsSecreAss3= new LlistaAssociacio(3);
    LlistaAssociacio associacionsTresAss3= new LlistaAssociacio(3);

    String[] titlsAss1={"GEI","GEQ","GEB",null};
    String[] titlsAss2={"GESST","GEE","GEI",null};
    String[] titlsAss3={"GEMIF","GEE","GEI",null};

    LlistaMembres membresAss1 = new LlistaMembres(50,0);
    LlistaMembres membresActiusAss1 = new LlistaMembres(30,0);
    LlistaMembres membresAss2 = new LlistaMembres(100,0);
    LlistaMembres membresActiusAss2 = new LlistaMembres(80,0);
    LlistaMembres membresAss3 = new LlistaMembres(80,0);
    LlistaMembres membresActiusAss3 = new LlistaMembres(70,0);


    Alumne presAss1 = new Alumne("presAss1","presAss1@gmail.com",datesAltaPresAss1,datesBaixaPresAss1,associacionsPresAss1,"Alumne","GEI",4,true);
    Alumne secreAss1 = new Alumne("secreAss1","secreAss1@gmail.com",datesAltaSecreAss1,datesBaixaSecreAss1,associacionsSecreAss1,"Alumne","GEQ",3,false);
    Alumne tresAss1 = new Alumne("tresAss1","tresAss1@gmail.com",datesAltaTresAss1,datesBaixaTresAss1,associacionsTresAss1,"Alumne","GEB",3,false);
    Alumne presAss2 = new Alumne("presAss2","presAss2@gmail.com",datesAltaPresAss2,datesBaixaPresAss2,associacionsPresAss2,"Alumne","GESST",4,true);
    Alumne secreAss2 = new Alumne("secreAss2","secreAss2@gmail.com",datesAltaSecreAss2,datesBaixaSecreAss2,associacionsSecreAss2,"Alumne","GEE",3,false);
    Alumne tresAss2 = new Alumne("tresAss2","tresAss2@gmail.com",datesAltaTresAss2,datesBaixaTresAss2,associacionsTresAss2,"Alumne","GEI",3,false);
    Alumne presAss3 = new Alumne("presAss3","presAss3@gmail.com",datesAltaPresAss3,datesBaixaPresAss3,associacionsPresAss3,"Alumne","GEMIF",1,false);
    Alumne secreAss3 = new Alumne("secreAss3","secreAss3@gmail.com",datesAltaSecreAss3,datesBaixaSecreAss3,associacionsSecreAss3,"Alumne","GEE",4,true);
    Alumne tresAss3 = new Alumne("tresAss3","tresAss3@gmail.com",datesAltaTresAss3,datesBaixaTresAss3,associacionsTresAss3,"Alumne","GEI",3,false);


    Associacio associacio1= new Associacio("Associacio1","associacio1@gmail.com",titlsAss1,membresAss1,membresActiusAss1,presAss1,secreAss1,tresAss1);
    Associacio associacio2= new Associacio("Associacio2","associacio2@gmail.com",titlsAss2,membresAss2,membresActiusAss2,presAss2,secreAss2,tresAss2);
    Associacio associacio3= new Associacio("Associacio3","associacio3@gmail.com",titlsAss3,membresAss3,membresActiusAss3,presAss3,secreAss3,tresAss3);

    associacionsUnai.afegirAssociacio(associacio1);
    associacionsUnai.afegirAssociacio(associacio2);
    associacionsAdam.afegirAssociacio(associacio1);
    associacionsAnder.afegirAssociacio(associacio2);
    associacionsOscar.afegirAssociacio(associacio1);
    associacionsOscar.afegirAssociacio(associacio3);

    Alumne Unai = new Alumne("Unai","unairosado@gmail.com",datesAltaUnai,datesBaixaUnai,associacionsUnai,"Alumne","GEB",2,true);
    Alumne Adam = new Alumne("Adam", "adamcapilla@gmail.com", datesAltaAdam, datesBaixaAdam, associacionsAdam, "Alumne", "GEB", 2, false);
    Professor Ander = new Professor("Ander", "andercrespo@gmail.com", datesAltaAnder, datesBaixaAnder, associacionsAnder,"Professor","DEIM",314);
    Professor Oscar = new Professor("Oscar", "oscarfumado@gmail.com", datesAltaOscar, datesBaixaOscar, associacionsOscar, "Professor", "DEIM", 312);

    associacio1.afegirMembre(Unai);
    associacio1.afegirMembre(Adam);
    associacio1.afegirMembre(Oscar);
    associacio1.afegirMembre(presAss1);
    associacio1.afegirMembre(secreAss1);
    associacio1.afegirMembre(tresAss1);
    associacio2.afegirMembre(Unai);
    associacio2.afegirMembre(Ander);
    associacio2.afegirMembre(presAss2);
    associacio2.afegirMembre(secreAss2);
    associacio2.afegirMembre(tresAss2);
    associacio3.afegirMembre(Oscar);
    associacio3.afegirMembre(presAss3);
    associacio3.afegirMembre(secreAss3);
    associacio3.afegirMembre(tresAss3);

    Associacio[] assOrgXerr1= {associacio1,null};
    Associacio[] assOrgXerr2= {associacio1,associacio2,null};
    Associacio[] assOrgDem3= {associacio3,null};
    Associacio[] assOrgDem4= {associacio2,associacio3,null};

    LocalDate dataRealXerr1= LocalDate.of(2024,5,9);
    LocalDate dataRealXerr2= LocalDate.of(2023,2,14);
    LocalDate dataRealDem3= LocalDate.of(2023,12,21);
    LocalDate dataRealDem4= LocalDate.of(2024,1,20);

    int[] valorXerr1 = {7,8,3,5,8};
    int[] valorXerr2 = {6,5,7,9,10,9,7};

    Membre[] impXerr1 ={Unai,Adam,null};
    Membre[] impXerr2 ={Unai,Ander,null};

    Xerrada xerrada1 = new Xerrada("ASS100", "xerrada1", assOrgXerr1, Adam, "Xerrada", dataRealXerr1, 55, valorXerr1, impXerr1);
    Xerrada xerrada2 = new Xerrada("ASS101", "xerrada2", assOrgXerr2, Ander, "Xerrada", dataRealXerr2, 78, valorXerr2, impXerr2);
    Demostracio demostracio3 = new Demostracio("ASS102", "demostracio3", assOrgDem3, Oscar, "Demostracio", dataRealDem3, false, 2, 150.45);
    Demostracio demostracio4 = new Demostracio("ASS104", "demostracio4", assOrgDem4, Ander, "Demostracio", dataRealDem4, true, 1, 90.15);

    LlistaAssociacio llistaAss1 = new LlistaAssociacio(50);
    llistaAss1.afegirAssociacio(associacio1);
    llistaAss1.afegirAssociacio(associacio2);
    llistaAss1.afegirAssociacio(associacio3);

    LlistaAccions llistaAcc1 = new LlistaAccions(50);
    llistaAcc1.afegirAccio(xerrada1);
    llistaAcc1.afegirAccio(xerrada2);
    llistaAcc1.afegirAccio(demostracio3);
    llistaAcc1.afegirAccio(demostracio4);

    LlistaMembres llistaMemb1 = new LlistaMembres(50,0);
    llistaMemb1.afegirMembre(Unai);
    llistaMemb1.afegirMembre(Adam);
    llistaMemb1.afegirMembre(Ander);
    llistaMemb1.afegirMembre(Oscar);
    //final joc proves//

        mostraMenu();
        int opcio = Integer.parseInt(teclat.nextLine());

        while (opcio != 18) {
            switch (opcio) {
                case 1:
                    opcio1(llistaAss1);
                    break;
                case 2:
                    //
                    boolean incAlu = false;
                    boolean incPro = false;
                    System.out.println("Vols incluir alumnes?(si/no): ");
                    String resposta1 = teclat.nextLine();
                    if(resposta1=="si"){
                        incAlu=true;
                    }
                    System.out.println("Vols incluir professors?(si/no): ");
                    String resposta2 = teclat.nextLine();
                    if(resposta2=="si"){
                        incPro=true;
                    }
                    //
                    opcio2(associacio1,incAlu,incPro);
                    break;
                case 3:
                    //
                    incAlu = false;
                    incPro = false;
                    System.out.println("Vols incluir alumnes?(si/no): ");
                    resposta1 = teclat.nextLine();
                    if(resposta1=="si"){
                        incAlu=true;
                    }
                    System.out.println("Vols incluir professors?(si/no): ");
                    resposta2 = teclat.nextLine();
                    if(resposta2=="si"){
                        incPro=true;
                    }
                    //
                    opcio3(associacio2,incAlu,incPro);
                    break;
                case 4:
                    //
                    boolean incDem = false;
                    boolean incXerr = false;
                    System.out.println("Vols incluir demostracions?(si/no): ");
                    resposta1 = teclat.nextLine();
                    if(resposta1=="si"){
                        incDem=true;
                    }
                    System.out.println("Vols incluir xerrades?(si/no): ");
                    resposta2 = teclat.nextLine();
                    if(resposta2=="si"){
                        incXerr=true;
                    }
                    //
                    opcio4(llistaAcc1,incXerr,incDem);
                    break;
                case 5:
                    opcio5(llistaAcc1,associacio3);
                    break;
                case 6:
                    //
                    System.out.println("Introdueix el dia inicial: ");
                    int diaIni = Integer.parseInt(teclat.nextLine());
                    System.out.println("Introdueix el mes inicial: ");
                    int mesIni = Integer.parseInt(teclat.nextLine());
                    System.out.println("Introdueix el any inicial: ");
                    int anyIni = Integer.parseInt(teclat.nextLine());
                    System.out.println("Introdueix el dia final: ");
                    int diaFin = Integer.parseInt(teclat.nextLine());
                    System.out.println("Introdueix el mes final: ");
                    int mesFin = Integer.parseInt(teclat.nextLine());
                    System.out.println("Introdueix el any final: ");
                    int anyFin = Integer.parseInt(teclat.nextLine());
                    LocalDate dataIni = LocalDate.of(anyIni,mesIni ,diaIni);
                    LocalDate dataFin = LocalDate.of(anyFin,mesFin ,diaFin);
                    //
                    opcio6(dataIni,dataFin,llistaAcc1);
                    break;
                case 7:
                    opcio7(associacio1,llistaAss1);
                    break;
                case 8:
                    opcio8(llistaAss1,llistaMemb1);
                    break;
                case 9:
                    opcio9(xerrada1,llistaAcc1);
                    break;
                case 10:
                    opcio10(llistaAcc1,demostracio3);
                    break;
                case 11:
                    opcio11(llistaAcc1);
                    break;
                case 12:
                    opcio12(llistaMemb1);
                    break;
                case 13:
                    //
                    System.out.println("Introdueix el nombre d'assistents: ");
                    int nAss = Integer.parseInt(teclat.nextLine());
                    //
                    opcio13(nAss,llistaAcc1);
                    break;
                case 14:
                    opcio14(llistaAcc1);
                    break;
                case 15:
                    opcio15(llistaAcc1);
                    break;
                case 16:
                    opcio16(Adam,llistaAcc1);
                    break;
                case 17:
                    //
                    System.out.println("Introdueix el dia: ");
                    int dia = Integer.parseInt(teclat.nextLine());
                    System.out.println("Introdueix el mes: ");
                    int mes = Integer.parseInt(teclat.nextLine());
                    System.out.println("Introdueix el any: ");
                    int any = Integer.parseInt(teclat.nextLine());
                    LocalDate data = LocalDate.of(any, mes, dia);
                    //
                    opcio17(llistaAcc1,data);
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
        try {
            System.out.println(llista.obtenirInformacio());
        } catch (Exception e) {
            System.out.println("Error en opcio1: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio2(Associacio associacio, boolean incluirAlumnes, boolean incluirProfessors) {
        try {
            LlistaMembres llista = associacio.obtenirMembresFiltrats(incluirProfessors, incluirAlumnes);
            System.out.println(llista.obtenirInformacio());
        } catch (Exception e) {
            System.out.println("Error en opcio2: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio3(Associacio associacio, boolean incluirAlumnes, boolean incluirProfessors) {
        try {
            LlistaMembres llista = associacio.obtenirMembresFiltrats(incluirProfessors, incluirAlumnes);
            Membre[] llistaActius = llista.obtenirMembresActius();
            LlistaMembres resultat = new LlistaMembres(llistaActius.length, llistaActius.length);
            System.out.println(resultat.obtenirInformacio());
        } catch (Exception e) {
            System.out.println("Error en opcio3: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio4(LlistaAccions llista, boolean incluirXerrades, boolean incluirDemostracions) {
        try {
            Accio[] accions = llista.getAccions();
            LlistaAccions resultat = new LlistaAccions(accions.length);
            for (int i = 0; i < accions.length; i++) {
                if (accions[i].esXerrada() && incluirXerrades) {
                    resultat.afegirAccio(accions[i]);
                    break;
                }
                if (accions[i].esDemostracio() && incluirDemostracions) {
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
    
    public static void opcio5(LlistaAccions llista, Associacio associacio) {
        try {
            Accio[] accions = llista.getAccions();
            LlistaAccions resultat = new LlistaAccions(accions.length);
            for (int i = 0; i < accions.length; i++) {
                Associacio[] associacionsOrganitzadores = accions[i].getAssociacionsOrganitzadores();
                for (int j = 0; j < associacionsOrganitzadores.length; j++) {
                    if (associacionsOrganitzadores[j] == associacio) {
                        resultat.afegirAccio(accions[i]);
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
    

    public static void opcio6(LocalDate dataInicial, LocalDate dataFinal, LlistaAccions llista) {
        try {
            System.out.println("Xerrades dins la franja de dates:");
            Accio[] accions = llista.getAccions();
            LlistaAccions resultat = new LlistaAccions(accions.length);
            for (int i = 0; i < accions.length; i++) {
                if (accions[i].esXerrada()) {
                    Xerrada xerrada = (Xerrada) accions[i];
                    if (xerrada.obtenirDataRealitzacio().isBefore(dataFinal) && xerrada.obtenirDataRealitzacio().isAfter(dataInicial)) {
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
    
    public static void opcio7(Associacio associacio, LlistaAssociacio llista) {
        try {
            llista.afegirAssociacio(associacio);
            System.out.println("Associacio afegida amb exit a la llista.");
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio8(LlistaAssociacio llista, LlistaMembres llista2) {
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
    
                Associacio[] associacions = llista.getAssociacions();
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
    
                Membre[] membres = llista2.getMembres();
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
    
                Associacio[] associacions2 = llista.getAssociacions();
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
    

    public static void opcio9(Xerrada xerrada, LlistaAccions llista) {
        try {
            llista.afegirAccio(xerrada);
            System.out.println("Xerrada afegida amb èxit a la llista.");
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void opcio10(LlistaAccions llista, Demostracio demostracio) {
        try {
            llista.afegirAccio(demostracio);
            System.out.println("Demostracio afegida amb èxit a la llista.");
        } catch (NullPointerException e) {
            System.err.println("Error: S'ha trobat unn valor nul inesperat.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    public static void opcio11(LlistaAccions llista) {
        try {
            double costTotal = 0;
            Accio[] accions = llista.getAccions();
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
    

    public static void opcio12(LlistaMembres llista) {
        try {
            int maxAssociacions = 0;
            LocalDate maxDataAlta = null;
            int index = 0;
            Membre[] membres = llista.getMembres();
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
    

    public static void opcio13(int nAssistents, LlistaAccions llista) {
        try {
            Accio[] accions = llista.getAccions();
            Xerrada[] xerrades = new Xerrada[accions.length];
            for (int i = 0; i < accions.length; i++) {
                if (accions[i].esXerrada()) {
                    xerrades[xerrades.length - 1] = (Xerrada) accions[i];
                }
            }
            for (Xerrada xerrada : xerrades) {
                if (xerrada != null && xerrada.obtenirNombreAssistents() > nAssistents) {
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
    

    public static void opcio14(LlistaAccions llista) {
        try {
            Accio[] accions = llista.getAccions();
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
    

    public static String opcio15(LlistaAccions llista) {
        try {
            Accio[] accions = llista.getAccions();
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
    

    public static void opcio16(Membre membre, LlistaAccions llista) {
        try {
            Accio[] accions = llista.getAccions();
            for (int i = 0; i < accions.length; i++) {
                if (accions[i].esXerrada()) {
                    Xerrada xerrada = (Xerrada) accions[i];
                    Membre[] impartidors = xerrada.getImpartidors();
                    for (int j = 0; j < impartidors.length; j++) {
                        if (impartidors[j].equals(membre)) {
                            System.out.println("Xerrada: " + accions[i].obtenirInformacio());
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

    public static void opcio17(LlistaAccions llista, LocalDate data) {//correccio de la opcio17 pa que no pete
        Accio[] accions = llista.getAccions();
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
