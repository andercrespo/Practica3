import java.time.LocalDate;
import java.util.Scanner;

public class main2 {
    
    public void mostrarMembres(Scanner scanner, LlistaAssociacio associacio){
        System.out.println("Filtre: 1. Professors 2. Alumnes 3. Ambdós");
        int filtre = scanner.nextInt();
        scanner.nextLine();

        for (Membre membre : llistaMembres.getMembres()){
            if (membre.getAssociacions().getNom() == associacio) {
                if (filtre == 3 || (filtre == 1 && membre instanceof Professor) || (filtre == 2 && (membre instanceof Alumne))){
                System.out.println(membre.getAlies(), membre.getCorreu(), membre.getDataAlta(), membre.getDataBaixa());
            }
        }
        }
    }

    public static void mostrarMembresActius(Scanner scanner){
        System.out.println("Filtre: 1. Professors 2. Alumnes 3. Ambdós");
        int filtre = scanner.nextInt();
        scanner.nextLine();

        for (Membre membre : llistaMembres.obtenirMembresActius()){
            if (filtre == 3 || (filtre == 1 && membre instanceof Professor) || (filtre == 2 && (membre instanceof Alumne))){
                System.out.println(membre.getAlies(), membre.getCorreu(), membre.getDataAlta(), membre.getDataBaixa());
            }
        }
    }

    public void mostrarAccionsAssociacio(Scanner scanner){
        System.out.print("Introdueix el nom de l'associació: ");
        String nomAssociacio = scanner.nextLine();

        for (Membre membre : llistaMembres.getMembres()){
                if (membre.getAssociacions().getNom() == nomAssociacio){
                    System.out.println("Accions disponibles: " + membre.getAssociacions().getAccions());
                    return;
                }
        }

        System.out.println("Associació no trobada.");
    }

    private static void mostrarXerradesPerFranja(Scanner scanner){
        System.out.print("Introdueix la data inicial: ");
        LocalDate dataInicial = LocalDate.parse(scanner.nextLine());
        System.out.print("Introdueix la data final: ");
        LocalDate dataFinal = LocalDate.parse(scanner.nextLine());

        System.out.println("Xerrades dins la franja de dates:");
        for (Membre membre : llistaMembres.getMembres()){
                for (Accio accio : membre.getAssociacions().getAccions()){
                    if (accio instanceof Xerrada) {
                        Xerrada xerrada = (Xerrada) accio;
                        if (xerrada.obtenirDataRealitzacio().isAfter(dataInicial.minusDays(1)) && xerrada.obtenirDataRealitzacio().isBefore(dataFinal.plusDays(1))){
                            System.out.println("-"+xerrada.getTitol() + " el " + xerrada.obtenirDataRealitzacio());
                        }
                    }
                }
        }
    }
    }
